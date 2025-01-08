FROM ubuntu:latest
LABEL authors="zee88"

# Dockerfile for Player Service
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/CICD_project-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
