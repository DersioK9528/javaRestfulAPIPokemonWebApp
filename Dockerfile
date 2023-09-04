# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application will listen on
EXPOSE 80

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
