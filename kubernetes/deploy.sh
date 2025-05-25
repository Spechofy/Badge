#!/bin/bash
#minikube image load confluentinc/cp-kafka:latest
#minikube image load confluentinc/cp-zookeeper:latest
#minikube image load badge-service:latest
#minikube image load mongo:latest

kubectl apply -f mongodb/
kubectl apply -f zookeeper/
kubectl apply -f kafka/
kubectl apply -f badge/


