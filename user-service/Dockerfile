# Stage 1: Build using Maven and JDK 24
FROM openjdk:24-jdk-slim AS builder
RUN apt-get update && \
    apt-get install -y maven
    
WORKDIR /app
COPY . .

# Build with Java 24
RUN mvn clean package -DskipTests

# Stage 2: Run Spring Boot
FROM openjdk:24-jdk-slim

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Create /app/data directory for SQLite to write into
RUN mkdir -p /app/data

ENTRYPOINT ["java", "-jar", "app.jar"]