FROM adoptopenjdk/openjdk14:alpine-jre

WORKDIR /usr/app

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]