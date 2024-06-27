FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/SpringbootApp-0.0.1-SNAPSHOT.jar /app/my-java-app.jar
CMD ["java", "-jar", "my-java-app.jar"]
