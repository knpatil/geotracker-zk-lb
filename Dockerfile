FROM openjdk:8
RUN mkdir -p /opt/kpatil/geotracker
ADD target/geotracker-zk-lb-1.0.0.jar /opt/kpatil/geotracker/
EXPOSE 8080
CMD ["java", "-jar", "/opt/kpatil/geotracker/geotracker-zk-lb-1.0.0.jar"]
