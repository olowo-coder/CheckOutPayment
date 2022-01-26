FROM openjdk:17
COPY target/checkout-app.jar .
ENTRYPOINT ["java", "-jar","/checkout-app.jar"]