FROM openjdk:17-jdk-slim
COPY target/MyGuuApp-1.0.1-SNAPSHOT.jar MyGuuApp-1.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MyGuuApp-1.0.1-SNAPSHOT.jar"]