# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.5-eclipse-temurin-17 AS build

ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

WORKDIR /app

# Copy trước pom + libs để cache dependency
COPY pom.xml .
COPY libs ./libs

RUN mvn -B -q dependency:go-offline

# Copy source sau
COPY src ./src

# Build
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Run
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/ROOT.jar app.jar

EXPOSE 1238

ENTRYPOINT ["java","-jar","/app/app.jar"]
