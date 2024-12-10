FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-promos-0.0.1-SNAPSHOT.jar /app/microservice-promos-0.0.1-SNAPSHOT.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "microservice-promos-0.0.1-SNAPSHOT.jar"]