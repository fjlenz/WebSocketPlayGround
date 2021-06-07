FROM maven:latest AS build
RUN mkdir /websocket-playground
COPY . /websocket-playground
WORKDIR /websocket-playground
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk11:latest
RUN mkdir /app
COPY --from=build /websocket-playground/target/websocket-playground-0.0.1-SNAPSHOT.jar /app/java-application.jar
WORKDIR /app
CMD "java" "-jar" "java-application.jar"
