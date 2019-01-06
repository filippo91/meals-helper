FROM openjdk:8-jdk-alpine

COPY target/meals-helper-0.1.0-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]