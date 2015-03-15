#! /bin/bash
mvn -Dtest=OneThousandTest,HundredThousandTest,NegHundredThousandTest,MillionTest,NegMillionTest,TenMillionTest,NegTenMillionTest test | awk '/##/ {print}'



