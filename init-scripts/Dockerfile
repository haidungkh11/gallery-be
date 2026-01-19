FROM gvenzl/oracle-xe:21-slim

USER root
# Copy các file script vào container
COPY init-db.sh /docker-entrypoint-initdb.d/init-db.sh
COPY script.sql /docker-entrypoint-initdb.d/script.sql

# Đảm bảo script có quyền thực thi
RUN chmod +x /docker-entrypoint-initdb.d/init-db.sh
USER 54321