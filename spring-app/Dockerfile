FROM gradle:6.8.1-jdk11 AS build
MAINTAINER BruceHsu bruce770405@gmail.com
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
EXPOSE 8081
COPY --from=build /home/gradle/src/build/libs/spring-app-0.0.1-SNAPSHOT.jar /app/spring-app.jar
ENTRYPOINT ["java","-jar","/app/spring-app.jar"]