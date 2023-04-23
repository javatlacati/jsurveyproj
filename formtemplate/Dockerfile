FROM docker.io/openjdk:15.0
WORKDIR /app
COPY ./target/formtemplate-1.0.jar /app
EXPOSE 8081
ENTRYPOINT ["java","-jar","formtemplate-1.0.jar"]