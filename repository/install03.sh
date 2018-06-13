# /bin/bash

gdrivePath=$HOME/.gdrive

mkdir $gdrivePath

wget 192.168.20.14/repository/gdrive -P $gdrivePath

chmod +x $gdrivePath/gdrive

$gdrivePath/gdrive about
