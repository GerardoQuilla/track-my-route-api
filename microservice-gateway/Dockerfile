FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-gateway-0.0.1-SNAPSHOT.jar /app/microservice-gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "microservice-gateway-0.0.1-SNAPSHOT.jar"]