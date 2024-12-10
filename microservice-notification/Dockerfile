FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-notification-0.0.1-SNAPSHOT.jar /app/microservice-notification-0.0.1-SNAPSHOT.jar
EXPOSE 8105
ENTRYPOINT ["java", "-jar", "microservice-notification-0.0.1-SNAPSHOT.jar"]