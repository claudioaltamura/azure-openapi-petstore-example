FROM --platform=linux/amd64 eclipse-temurin:21-alpine

WORKDIR /app

COPY target/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]