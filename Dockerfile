FROM maven:3.6.0-jdk-11-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /app/target/business*.jar /app/business.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/business.jar"]