FROM openjdk:17

VOLUME /tmp
ADD maven/Fabric8App-0.0.1-SNAPSHOT.jar fabric8app.jar
RUN sh -c 'touch /Fabric8App-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/fabric8app.jar"]