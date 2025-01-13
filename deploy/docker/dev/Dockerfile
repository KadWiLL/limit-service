FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app
COPY limit-service/.mvn/ ./.mvn
COPY limit-service/mvnw limit-service/pom.xml ./
COPY limit-service/.env.dev .env
RUN chmod 777 mvnw
RUN ./mvnw dependency:go-offline
COPY ./limit-service/src ./src
RUN ls
RUN ls
RUN ls
RUN ./mvnw clean install -Dmaven.test.skip=true -Dmaven.test.skip=true
RUN ls target

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY limit-service/.env.dev .env
COPY --from=builder /app/target/*.jar limit-service.jar
ENV min=1 \
    max=1000

ENTRYPOINT ["java","-jar","limit-service.jar"]
# RUN java -jar /opt/app/tcp-middleware.jar
# RUN echo $SEND_MAIL_HOST
# CMD ["java", "-jar", "/opt/app/tcp-middleware.jar" ]
