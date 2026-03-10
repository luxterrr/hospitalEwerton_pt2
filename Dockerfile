FROM eclipse-temurin:21
ARG JAR_FILE=target/*.jar
COPY ./target/Hospital-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "hospital.jar"]