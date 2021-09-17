# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# maintainer
MAINTAINER baeldung.com

# Copy war file
COPY target/roman-numeral-conversion-1.0-SNAPSHOT.jar /roman-numeral-conversion-1.0-SNAPSHOT.jar

# run the app
ENTRYPOINT ["java","-jar","/roman-numeral-conversion-1.0-SNAPSHOT.jar"]