# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven-built jar file into the container
COPY target/VorteXtream-BACK_END-SpringBoot-0.0.1-SNAPSHOT.jar app.jar

# Specify the command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
