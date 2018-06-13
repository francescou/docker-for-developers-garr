FROM maven:3-alpine as maven

# COPY settings.xml  /usr/share/maven/conf/settings.xml

WORKDIR /app/
COPY pom.xml .

RUN mvn dependency:resolve

COPY src src/



RUN find ./src/

RUN mvn clean package -DskipTests




FROM openjdk:8-jre-alpine

LABEL foo=bar

COPY --from=maven /app/target/*.jar /app.jar

USER nobody

EXPOSE 8080

ENV JAVA_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=n -Xmx128m

CMD java ${JAVA_OPTS} -jar /app.jar

