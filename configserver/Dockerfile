FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/configserver-0.0.1-SNAPSHOT.jar /app/configserver.jar
CMD java -jar /app/configserver.jar