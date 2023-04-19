# Use the official OpenJDK 11 image as the base image
FROM openjdk:11

# Set the working directory to /app
WORKDIR /app

# Copy the application jar and its dependencies to /app
COPY target/mvc.jar /app

# Expose port 8080
EXPOSE 8080

# Set the entrypoint to run the application using java command
ENTRYPOINT ["java", "-jar", "/app/mvc.jar"]
