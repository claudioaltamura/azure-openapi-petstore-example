FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY target/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]