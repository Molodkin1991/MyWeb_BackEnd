# Используем официальный образ с JDK 21
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем jar-файл приложения
COPY /build/libs/MyWeb_BackEnd-0.0.1-SNAPSHOT-plain.jar /app/app.jar

# Указываем порт и команду запуска
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]