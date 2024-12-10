FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-eureka-0.0.1-SNAPSHOT.jar /app/microservice-eureka-0.0.1-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "microservice-eureka-0.0.1-SNAPSHOT.jar"]