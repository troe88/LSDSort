#! /bin/bash

if [ ! `which mvn 2>/dev/null` ] ; 
then
echo " no maven " 
exit 1
fi

mvn -Dtest=OneThousandTest,HundredThousandTest,NegHundredThousandTest,MillionTest,NegMillionTest,TenMillionTest,NegTenMillionTest test | awk '/##/ {print}'



