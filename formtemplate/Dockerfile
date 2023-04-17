FROM docker.io/openjdk:11.0
WORKDIR /app
COPY ./target/formtemplate-1.0.jar /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","formtemplate-1.0.jar"]