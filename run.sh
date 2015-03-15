#! /bin/bash

if [ ! `which mvn 2>/dev/null` ] ; 
then
echo " no maven " 
exit 1
fi

mvn package | awk '/##/ {print}'



