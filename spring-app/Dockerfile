FROM openjdk:11.0.7-jre-slim
MAINTAINER bruce770405@gmail.com
EXPOSE 8081
ADD /build/libs/spring-app-0.0.1-SNAPSHOT.jar spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]