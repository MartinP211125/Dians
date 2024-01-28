# Use a base image with Java and a specific version
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY out/artifacts/AuthMicroService_jar/AuthMicroService.jar /app/

# Expose the port your application will run on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "/app/AuthMicroService.jar"]

