# PowerShell script to deploy the application to Azure Kubernetes Service (AKS)

# Configuration - Replace these values with your own
$ACR_NAME = "spechofykloud"
$RESOURCE_GROUP = "spechofy"
$AKS_CLUSTER_NAME = "spechofy-aks"
$NAMESPACE = "badge-service"

# Display configuration
Write-Host "Deploying to AKS with the following configuration:"
Write-Host "ACR Name: $ACR_NAME"
Write-Host "Resource Group: $RESOURCE_GROUP"
Write-Host "AKS Cluster Name: $AKS_CLUSTER_NAME"
Write-Host "Namespace: $NAMESPACE"
Write-Host ""

# Login to Azure
#Write-Host "Logging in to Azure..."
#az login

# Login to ACR
Write-Host "Logging in to ACR..."
az acr login --name $ACR_NAME

# Build and tag the Docker image
Write-Host "Building and tagging Docker image..."
docker build -t "$ACR_NAME.azurecr.io/badge-service:latest" .

# Push the image to ACR
Write-Host "Pushing image to ACR..."
docker push "$ACR_NAME.azurecr.io/badge-service:latest"

# Update the Kubernetes manifest with the ACR name
Write-Host "Updating Kubernetes manifest with ACR name..."
(Get-Content -Path "kubernetes\badge\badge-deployment.yaml") -replace '\$\{ACR_NAME\}', $ACR_NAME | Set-Content -Path "kubernetes\badge\badge-deployment.yaml"

# Get AKS credentials
Write-Host "Getting AKS credentials..."
az aks get-credentials --resource-group $RESOURCE_GROUP --name $AKS_CLUSTER_NAME

# Create namespace if it doesn't exist
Write-Host "Creating namespace if it doesn't exist..."
kubectl create namespace $NAMESPACE --dry-run=client -o yaml | kubectl apply -f -

# Switch to the namespace
Write-Host "Switching to namespace $NAMESPACE..."
kubectl config set-context --current --namespace=$NAMESPACE

# Apply Kubernetes manifests
Write-Host "Applying Kubernetes manifests..."
kubectl apply -f kubernetes\mongodb\mongodb-service.yaml
kubectl apply -f kubernetes\badge\badge-deployment.yaml

# Wait for the deployment to be ready
Write-Host "Waiting for deployment to be ready..."
kubectl rollout status deployment/badge-service

# Get the service URL
Write-Host "Getting service URL..."
Write-Host "The application will be available at:"
$IP = kubectl get service badge-service -o jsonpath="{.status.loadBalancer.ingress[0].ip}"
Write-Host $IP

Write-Host ""
Write-Host "Deployment completed successfully!"