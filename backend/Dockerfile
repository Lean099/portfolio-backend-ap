FROM amazoncorretto:11-alpine-jdk

RUN mkdir -p /backend/src/main/resources/uploads
WORKDIR /backend

COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/backend/app.jar"]