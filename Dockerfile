FROM openjdk:latest
EXPOSE 8080
ADD target/flight-booking-system.jar flight-booking-system.jar
ENTRYPOINT ["sh", "-c", "java -jar /flight-booking-system.jar"]