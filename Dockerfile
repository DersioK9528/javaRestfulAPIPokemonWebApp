# Use an official OpenJDK runtime as a parent image
FROM openjdk:19
# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar .

# Expose the port that your application will listen on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]


