#!/bin/bash

# chemin racine des sources java
SRC_DIR="src/main/java/com/example/Badge"

# Pour chaque dossier qui contient des fichiers java
find $SRC_DIR -type d | while read dir; do
  PACKAGE_NAME=$(echo $dir | sed -e "s|src/main/java/||" -e "s|/|.|g")
  FILE="$dir/package-info.java"

  if [ ! -f "$FILE" ]; then
    echo "/**" > $FILE
    echo " * Package $PACKAGE_NAME." >> $FILE
    echo " */" >> $FILE
    echo "package $PACKAGE_NAME;" >> $FILE
    echo "Generated package-info.java in $dir"
  else
    echo "File package-info.java already exists in $dir"
  fi
done
