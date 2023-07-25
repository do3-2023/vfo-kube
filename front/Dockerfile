FROM eclipse-temurin:17-jdk-alpine

LABEL org.opencontainers.image.source="https://github.com/do3-2023/vfo-kube"

COPY . .
RUN chmod +x gradlew
RUN ./gradlew build

EXPOSE 80
ENTRYPOINT ["java", "-jar", "build/libs/front-0.0.1-SNAPSHOT.jar"]