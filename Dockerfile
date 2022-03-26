FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
EXPOSE 8080 80
ARG JAR_FILE_PATH=target/*.jar
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:80", "-jar", "app.jar"]