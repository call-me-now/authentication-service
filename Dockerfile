FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar --no-daemon

FROM openjdk:11
EXPOSE 80:8081
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/authorization.jar
ENTRYPOINT ["java","-jar","/app/authorization.jar"]