FROM openjdk:21-alpine
ADD target/spring-boot-app.jar spring-boot-app.jar
EXPOSE 9095
ENTRYPOINT ["java", "-jar", "/spring-boot-app.jar"]
