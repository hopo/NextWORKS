# !/bin/bash

mkdir $HOME/.temp/

# Test)
#cp $HOME/NextWORKS/repository/setup.py $HOME/.temp/

wget 192.168.20.14/repository/setup.py -P $HOME/.temp/

python3 $HOME/.temp/setup.py

