FROM amazoncorretto:17.0.7-alpine
COPY build/libs/*.jar /app.jar
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java", "-jar", "app.jar"]