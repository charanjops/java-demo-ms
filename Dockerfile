FROM gradle:7.5.1-jdk17-alpine AS build
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle build --no-daemon --stacktrace

FROM gcr.io/distroless/java:17
WORKDIR /app
COPY --from=build /app/build/libs/java-demo-ms-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
USER nonroot:nonroot
CMD ["java", "-jar", "java-demo-ms-0.0.1-SNAPSHOT.jar"]