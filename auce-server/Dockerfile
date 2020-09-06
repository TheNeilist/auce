FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

#FROM openjdk:11
#ARG JAR_FILE="build /usr/src/app/target/auce-server-0.0.1-SNAPSHOT.jar"
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:8
#FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/auce-server-0.0.1-SNAPSHOT.jar /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]