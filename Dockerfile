FROM openjdk:21-slim
COPY ./target/GoodStudySpring-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]