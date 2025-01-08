FROM ubuntu:latest
LABEL authors="zee88"

# Dockerfile for Player Ranking Service
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/PlayerRanking-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
