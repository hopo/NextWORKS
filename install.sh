#!/bin/bash

#file="$HOME/.gdrive/gdrive"
file="$HOME/.gdrive/list.txt"
if [ -f "$file" ]
then
	echo "$file found."
else
	echo "$file not found."
fi