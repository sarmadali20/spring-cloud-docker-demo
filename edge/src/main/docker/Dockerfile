FROM java:7
VOLUME /tmp
ADD edge-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djdk.nio.maxCachedBufferSize=262144","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]docker