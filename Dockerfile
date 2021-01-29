FROM openjdk:11.0.7-jre-slim
EXPOSE 8080
ADD /build/libs/actuatordemo-0.0.1-SNAPSHOT.jar actuatordemo.jar
ENTRYPOINT ["java", "-jar", "actuatordemo.jar"]