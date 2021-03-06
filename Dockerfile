FROM openjdk:11
WORKDIR /opt/server
COPY ./target/shop-service-0.0.1-SNAPSHOT.jar server.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "server.jar"]