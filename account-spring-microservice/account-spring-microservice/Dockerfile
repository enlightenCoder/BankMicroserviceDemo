# From define the base image that is required by the container to execute the application for instance
FROM openjdk:17-jdk-slim-buster as build

# Information around who maintains the image
MAINTAINER christnet.com

# Add the application's jar to the container
COPY target/account-spring-microservice-0.0.1-SNAPSHOT.jar account-spring-microservice-0.0.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java", "-jar", "account-spring-microservice-0.0.1-SNAPSHOT.jar"]

