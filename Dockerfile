FROM maven:3.6.3-jdk-11-slim AS build
FROM openjdk:11
EXPOSE 8089
WORKDIR /kenya_build_acts_javabackend
COPY . /kenya_build_acts_javabackend
ADD target/KenyaActs.jar KenyaActs.jar
ENTRYPOINT ["java","-jar","target/KenyaActs.jar"]