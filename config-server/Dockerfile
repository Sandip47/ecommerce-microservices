FROM eclipse-temurin:21-jdk

LABEL maintainer="Sandip Pote"

WORKDIR /app

COPY target/config-server-*.jar app.jar

EXPOSE 8888

ENTRYPOINT ["java","-jar","app.jar"]