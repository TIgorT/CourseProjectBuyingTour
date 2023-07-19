# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

## Документация

1. [Текст задания](https://github.com/netology-code/aqa-qamid-diplom)
2. [План автоматизации](https://github.com/TIgorT/CourseProjectBuyingTour/blob/main/documents/Plan.md)
3. [Отчёт о проведенном тестировании](https://github.com/TIgorT/CourseProjectBuyingTour/blob/main/documents/Report.md)
4. [Отчет о проведённой автоматизации тестирования](https://github.com/TIgorT/CourseProjectBuyingTour/blob/main/documents/Summary.md)

## **Инструкция для запуска автотестов**
1. Клонировать проект:
2. Открыть проект в IntelliJ IDEA
3. Запустить Docker Desktop
4. Запустить в терменале контейнеры командой docker-compose up
5. Запустить в новом окне терминала jar файл командой java -jar ./artifacts/aqa-shop.jar
6. Проверить доступность приложения в браузере по ссылке http://localhost:8080/.
7. Запустить тесты командой ./gradlew clean test.
8. Запустить в новом окне терминала Allure для создания отчёта командой ./gradlew allureServe
9. Остановить Allure комбинацией клавиш Ctrl+C.
10. Остановить в терминале jar файл  комбинацией клавиш Ctrl+C.
11. Остановить в термиле работу контейнеров командой комбинацией клавиш Ctrl+C.
12. В термиле с Docker запустить командой docker-compose down.
