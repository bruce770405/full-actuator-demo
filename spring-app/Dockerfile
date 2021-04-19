#FROM openjdk:11.0.7-jre-slim
#MAINTAINER bruce770405@gmail.com
#EXPOSE 8081
#ADD /build/libs/spring-app-0.0.1-SNAPSHOT.jar spring-app.jar
#ENTRYPOINT ["java", "-jar", "spring-app.jar"]
FROM gradle:6.8.1-jdk11 AS build
ADD . /maven/src
WORKDIR /maven/src
RUN mvn verify clean
RUN mvn package

FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
EXPOSE 8081
COPY --from=build /home/gradle/src/build/libs/spring-app-0.0.1-SNAPSHOT.jar /app/spring-app.jar
ENTRYPOINT ["java","-jar","/app/spring-app.jar"]