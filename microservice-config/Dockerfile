FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/microservice-config-0.0.1-SNAPSHOT.jar /app/microservice-config-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "microservice-config-0.0.1-SNAPSHOT.jar"]