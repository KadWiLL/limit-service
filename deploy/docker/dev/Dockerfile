FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /opt/app
COPY limit-service/.mvn/ .mvn/
COPY limit-service/mvnw limit-service/pom.xml ./
COPY limit-service/.env.dev .env
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY ./limit-service/src ./src
RUN ls -R /app
RUN ./mvnw clean install -Dmaven.test.skip=true

FROM openjdk:17-oracle
WORKDIR /app
COPY limit-service/.env.dev .env
COPY --from=builder /opt/app/target/limit-service.jar /opt/app/limit-service.jar
ENV min=1 \
    max=1000

ENTRYPOINT ["java","-jar","/opt/app/limit-service.jar"]
# RUN java -jar /opt/app/tcp-middleware.jar
# RUN echo $SEND_MAIL_HOST
# CMD ["java", "-jar", "/opt/app/tcp-middleware.jar" ]
