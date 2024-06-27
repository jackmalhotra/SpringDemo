# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim
 
# Set the working directory in the container
WORKDIR /app
    
# Copy the application's jar file to the container
COPY target/SpringbootApp-0.0.1-SNAPSHOT.jar /app/my-java-app.jar
 
# Expose the port the application runs on   
EXPOSE 8085
 
# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/my-java-app.jar"]
