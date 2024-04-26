FROM maven:3.8.3-openjdk-17 as build

WORKDIR /app

# Docker içerisine .m2/settings.xml oluştur.
# <server> ekle.

RUN mkdir -p /root/.m2 \
    && mkdir /root/.m2/repository

COPY settings.xml /root/.m2

COPY . /app/

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk

COPY --from=build /app/target/customerservice-0.0.1-SNAPSHOT.jar /app/customerservice.jar

CMD java -jar /app/customerservice.jar