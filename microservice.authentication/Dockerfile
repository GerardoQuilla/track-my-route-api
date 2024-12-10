FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice.authentication-0.0.1-SNAPSHOT.jar /app/microservice.authentication-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "microservice.authentication-0.0.1-SNAPSHOT.jar"]