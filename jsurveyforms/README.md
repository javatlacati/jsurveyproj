# jsurveyforms

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/jsurveyforms-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- REST Client Classic ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- Jacoco - Code Coverage ([guide](https://quarkus.io/guides/tests-with-coverage)): Jacoco test coverage support
- Quarkus Extension for Spring Data JPA API ([guide](https://quarkus.io/guides/spring-data-jpa)): Use Spring Data JPA
  annotations to create your data access layer
- SmallRye GraphQL ([guide](https://quarkus.io/guides/microprofile-graphql)): Create GraphQL Endpoints using the
  code-first approach from MicroProfile GraphQL

## Provided Code

### REST Client

Invoke different services through REST with JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### SmallRye GraphQL

Start coding with this Hello GraphQL Query

[Related guide section...](https://quarkus.io/guides/smallrye-graphql)


## Algunas consultas utiles

retrieve all uuids from all templates:
```graphql
{
  templates {
    uuid
  }
}
```
Retrieve the template details from a template using uuid

```graphql
{
  template(uuid: "772df4ec-fa29-4c75-a6b2-07e8b1b9a877") {
    surveyTemplateId
    uuid
    sections {
      sectionId
      name
      questions {
        ... on MultipleOptionQuestion {
          questionId
          statement
          type
          required
          answerOptions
        }
        ... on Question {
          questionId
          statement
          type
          required
        }
      }
    }
  }
}
```

Add a new answered survey

```graphql
mutation {
    saveNewSurvey(
        survey: {
          surveyId: null,
          templateId: 1,
          answers: [
            {
              id: null,
              questionId: 1,
              questionType: OPEN
              answerData:{
                answer:"Paco"
                theDate: null
                answerIdx:null
              }
            },
            {
              id:null
              questionId:2
              questionType:DATE
              answerData:{
              theDate:"06/06/2023"
                answer:null
                answerIdx: null
              }
            },
            {
              id:null
              questionId:3
              questionType: MULTIPLE_OPTION
              answerData:{
                answerIdx:0
                answer:null
                theDate:null
              }
            },
            {
              id:null
              questionId:4
              questionType:MULTIPLE_OPTION
              answerData:{
                answerIdx:4
                answer:null
                theDate:null
              }
            }
          ]
        }
    )  {
      surveyId
      templateId
      answers {
        id
        questionId
        questionType
        answerData {
          answer
          answerIdx
          theDate
        }
      }
    }
}
```
retrieve all answered surveys

```graphql
{
  surveys {
    surveyId
    templateId
    answers {
      id
      questionId
      questionType
      answerData {
        answerIdx
        answer
        theDate
      }
    }
  }
}
```
