FROM openjdk:17-alpine
ADD target/spring-boot-docker.jar spring-boot-docker.jar
EXPOSE 9095
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]
