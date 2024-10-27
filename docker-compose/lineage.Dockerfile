FROM openjdk:8-jre-slim

ADD target/Lineage380-1.0-SNAPSHOT.jar /app.jar

ENTRYPOINT ["sh","-c","java -jar /app.jar"]

