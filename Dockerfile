FROM openjdk

RUN mkdir /app

COPY out/artifacts/auth_jar/auth.jar /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/auth.jar"]
