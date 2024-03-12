FROM openjdk:21-slim-bookworm
LABEL authors="Rok"

COPY target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]