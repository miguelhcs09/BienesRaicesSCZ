# --- FASE 1: El Constructor (Builder) ---
# Usamos una imagen de Maven con Java 17 para compilar nuestro código.
# Puedes cambiar '17' por la versión de Java que usa tu proyecto (ej: 11, 21).
FROM maven:3.9-eclipse-temurin-17 AS builder

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos solo el pom.xml para descargar las dependencias.
# Esto aprovecha el caché de Docker para acelerar futuras compilaciones.
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código fuente del proyecto
COPY src ./src

# Compilamos el proyecto y creamos el archivo .jar. Omitimos los tests.
RUN mvn package -DskipTests


# --- FASE 2: El Ejecutor (Runner) ---
# Usamos una imagen de Java muy ligera, solo con lo necesario para ejecutar.
FROM eclipse-temurin:17-jre-jammy

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo .jar que se creó en la fase anterior ("builder")
# a nuestra nueva imagen y lo renombramos a "app.jar"
COPY --from=builder /app/target/*.jar app.jar

# Exponemos el puerto 8080, que es el estándar para muchas aplicaciones web Java (como Spring Boot)
EXPOSE 8080

# El comando que se ejecutará cuando el contenedor inicie
CMD ["java", "-jar", "app.jar"]