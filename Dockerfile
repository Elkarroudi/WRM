FROM openjdk:17-jdk-alpine

# Create User to run app as (Instead of Root)
RUN addgroup -S app && adduser -S app -G app

# Use User "app"
USER app

# Copy the WAR file into the Docker image
COPY target/*.war /app.war

# Run the WAR file
ENTRYPOINT ["java", "-jar", "/app.war"]