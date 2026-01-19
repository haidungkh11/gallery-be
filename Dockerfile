# Sử dụng Maven image để build project (stage 1)
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy file cấu hình và mã nguồn vào container
COPY pom.xml .
COPY src ./src

# Build project để tạo file JAR
RUN mvn clean package -DskipTests

# Sử dụng openjdk 17 làm base image (stage 2)
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy file JAR đã build từ stage 1 vào image
COPY --from=build /app/target/*.jar /app/ROOT.jar

# Chạy ứng dụng Spring Boot khi container khởi động
CMD ["java", "-jar", "/app/ROOT.jar"]

# Expose port 8080 để có thể truy cập ứng dụng
EXPOSE 8080
