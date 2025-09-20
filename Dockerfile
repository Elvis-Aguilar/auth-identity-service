# Etapa 1: build
FROM gradle:8.9-jdk21 AS builder
WORKDIR /workspace/app

COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
COPY gradle ./gradle

RUN gradle bootJar --no-daemon

# Etapa 2: runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=builder /workspace/app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
