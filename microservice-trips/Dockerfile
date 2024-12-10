FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-trips-0.0.1-SNAPSHOT.jar /app/microservice-trips-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "microservice-trips-0.0.1-SNAPSHOT.jar"]