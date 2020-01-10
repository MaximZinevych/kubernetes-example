FROM amazoncorretto:11

COPY target/configuration-repository-app-0.1.jar /app.jar

EXPOSE 8080

ENTRYPOINT [ "/usr/bin/java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]
