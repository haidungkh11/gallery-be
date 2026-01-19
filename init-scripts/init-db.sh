#!/bin/bash
sqlplus sys/Swapuat AS SYSDBA <<EOF
CREATE USER swapcom IDENTIFIED BY Swapuat;
GRANT CONNECT, RESOURCE TO swapcom;
GRANT ALL PRIVILEGES TO swapcom;
exit;
EOF
echo "Running script.sql..."
sqlplus swapcom/Swapuat@//localhost:1521/XE
@/docker-entrypoint-initdb.d/script.sql;
echo "Script execution completed."
