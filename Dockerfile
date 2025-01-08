# Utilisation de l'image de base Eclipse Temurin JDK 17
FROM eclipse-temurin:17.0.8.1_1-jdk-focal

# Répertoire de travail pour l'application Spring Boot
WORKDIR /app

# Copier le JAR de l'application dans l'image Docker
COPY target/location_voiture-1.0.0.jar /app/location_voiture.jar

# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 4444

# Commande pour exécuter l'application Spring Boot
CMD ["java", "-jar", "location_voiture.jar"]
