# Etapa de construcción
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Compilar el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:21-slim

WORKDIR /app

# Copiar el JAR generado en la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Configuración de variables de entorno
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]