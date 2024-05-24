#FROM mariadb:latest
#
#ENV MARIADB_ROOT_PASSWORD=my-secret-pw
#ENV MARIADB_DATABASE=dd
#
#COPY init.sql /docker-entrypoint-initdb.d/

FROM maven:3.9.6-eclipse-temurin-22 as build

WORKDIR /app

COPY . /app

RUN mvn install

FROM eclipse-temurin:22.0.1_8-jre-alpine

WORKDIR /app

COPY --from=build /app/target/dnd-jar-with-dependencies.jar ./dnd.jar

CMD java -jar dnd.jar


