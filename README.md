# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

## Документация

1. [Текст задания](https://github.com/netology-code/aqa-qamid-diplom)
2. [План автоматизации](https://github.com/TIgorT/CourseProjectBuyingTour/blob/main/documents/Plan.md)
3. [Отчёт о проведенном тестировании](https://github.com/TIgorT/CourseProjectBuyingTour/blob/main/documents/Report.md)
4. [Отчет о проведённой автоматизации тестирования](https://github.com/TIgorT/CourseProjectBuyingTour/blob/main/documents/Summary.md)

## **Инструкция для запуска автотестов**
1. Клонировать [проект](https://github.com/TIgorT/CourseProjectBuyingTour)
2. Открыть проект в IntelliJ IDEA
3. Запустить Docker Desktop

### Подключение SUT к MySQL
1. В терминале 1 в корне проекта запустить контейнеры:`docker-compose up`
2. В терминале 2 запустить приложение: `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`
3. Проверить доступность приложения в браузере по ссылке http://localhost:8080/
4. Открыть файл SQLHelper.java (.\src\test\java\ru\netology\data\SQLHelper.java)
5. Раскомментировать для  MySQL
6. Закомментировать для PostgreSQL
7. В терминале 3 запустить тесты командой  `./gradlew clean test --info`
8. В терминале 3 запустить Allure для создания отчёта командой `./gradlew allureserve`
9. Закрыть отчёт в терминаме 3: `CTRL + C --> Y --> Enter`
10. Остановить aqa-shop.jar в терминале 2: `CTRL + C`
11. Остановить контейнеры в терминале 1: `CTRL + C`
12. Выполнить команду в терминале 1: `docker-compose down`

### Подключение SUT к PostgreSQL
1. В терминале 1 в корне проекта запустить контейнеры:`docker-compose up`
2. В терминале 2 запустить приложение: `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app`
3. Проверить доступность приложения в браузере по ссылке http://localhost:8080/
4. Открыть файл SQLHelper.java (.\src\test\java\ru\netology\data\SQLHelper.java)
5. Раскомментировать для PostgreSQL
6. Закомментировать для  MySQL
7. В терминале 3 запустить тесты командой  `./gradlew clean test --info`
8. В терминале 3 запустить Allure для создания отчёта командой `./gradlew allureserve`
9. Закрыть отчёт в терминаме 3: `CTRL + C --> Y --> Enter`
10. Остановить aqa-shop.jar в терминале 2: `CTRL + C`
11. Остановить контейнеры в терминале 1: `CTRL + C`
12. Выполнить команду в терминале 1: `docker-compose down`










