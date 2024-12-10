FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-profile-0.0.1-SNAPSHOT.jar /app/microservice-profile-0.0.1-SNAPSHOT.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "microservice-profile-0.0.1-SNAPSHOT.jar"]