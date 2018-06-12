#!/bin/bash

mkdir .temp/
wget 192.168.20.14/repository/setup.py -P .temp/
python3 .temp/setup.py
