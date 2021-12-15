# Дипломное задание профессии «Тестировщик ПО»
## Документация
* [План автоматизации тестирования](https://github.com/NinePage/Diplom/blob/master/documentation/Plan.md)
* [Отчет по итогам тестирования](https://github.com/NinePage/Diplom/blob/master/documentation/Report.md)
* [Отчет по итогам автоматизации](https://github.com/NinePage/Diplom/blob/master/documentation/Summary.md)
# Запуск тестов
## MySQL:
1. Клонировать репозиторий командой `git clone`
2. Запустить контейнеры командой `docker-compose up`
3. Запустить SUT с поддержкой MySQL командой `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
4. Запустить тесты командой `./gradlew "-Ddb.url=jdbc:mysql://localhost:3306/app" clean test`
5. Сформировать отчет Allure командами `./gradlew allureReport` и `./gradlew allureServe`
6. Остановить контейнеры командой `docker-compose down`
## PostgreSQL:
1. Клонировать репозиторий командой `git clone`
2. Запустить контейнеры командой `docker-compose up`
3. Запустить SUT с поддержкой PostgreSQL командой `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
4. Запустить тесты командой `./gradlew "-Ddb.url=jdbc:postgresql://localhost:5432/app" clean test`
5. Сформировать отчет Allure командами `./gradlew allureReport` и `./gradlew allureServe`
6. Остановить контейнеры командой `docker-compose down`
