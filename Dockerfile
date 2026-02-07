FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY portfolio-backend/ ./portfolio-backend/

WORKDIR /app/portfolio-backend

# 🔧 FIX: give execute permission to mvnw
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/portfolio-backend-0.0.1-SNAPSHOT.jar"]
