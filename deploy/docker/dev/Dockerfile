FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY .env.dev .env
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ls -R /app
RUN ./mvnw clean install -Dmaven.test.skip=true

FROM openjdk:17-oracle
WORKDIR /app
COPY .env.dev .env
COPY --from=builder /app/target/limit-service.jar /app/limit-service.jar
ENV min=1 \
    max=1000

ENTRYPOINT ["java","-jar","/app/limit-service.jar"]
# RUN java -jar /opt/app/tcp-middleware.jar
# RUN echo $SEND_MAIL_HOST
# CMD ["java", "-jar", "/opt/app/tcp-middleware.jar" ]
