FROM eclipse-temurin:17 AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
RUN apt-get clean
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk-17-jdk
EXPOSE 8080
EXPOSE 8081
EXPOSE 8082
COPY --from=build /build/libs/Globify-0.0.1-SNAPSHOT.jar app.jar

LABEL authors="rohitsandadi"

ENTRYPOINT ["java", "-jar", "app.jar"]
# ENTRYPOINT ["top", "-b"]
