# Use a base image with Java and a specific version
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /mainapp

# Copy the JAR file into the container at /app
COPY target/fineWine.jar /mainapp/

# Expose the port your application will run on
EXPOSE 8081

# Specify the command to run your application
CMD ["java", "-jar", "/mainapp/fineWine.jar"]

