# План автоматизации тестирования
## Перечень автоматизируемых сценариев
#### Позитивные сценарии:
1. Покупка по карте с валидным номером карты. Статус APPROVED.  
**Ожидаемый результат:** появляется сообщение об успешной операции, в БД статус операции APPROVED.

2. Покупка в кредит с валидным номером карты. Статус APPROVED.  
**Ожидаемый результат:** появляется сообщение об успешной операции, в БД статус операции APPROVED.
#### Негативные сценарии:
1. Покупка по карте с невалидным номером карты. Статус DECLINED.  
**Ожидаемый результат:** появляется сообщение об отклоненной операции, в БД статус операции DECLINED.

2. Покупка в кредит с невалидным номером карты. Статус DECLINED.  
**Ожидаемый результат:** появляется сообщение об отклоненной операции, в БД статус операции DECLINED.

3. Покупка по карте с пустыми полями.  
**Ожидаемый результат:** форма не отправляется, под полями появляется уведомление об ошибках.

4. Покупка в кредит с пустыми полями.  
**Ожидаемый результат:** форма не отправляется, под полями появляется уведомление об ошибках.

5. Покупка по карте с вводом кириллицы в поле «Владелец».  
**Ожидаемый результат:** в поле «Владелец» появляется сообщение «Неверный формат».

6. Покупка в кредит с вводом кириллицы в поле «Владелец».  
**Ожидаемый результат:** в поле «Владелец» появляется сообщение «Неверный формат».

7. Покупка по карте с вводом нулей в поля «Месяц» и «Год».  
**Ожидаемый результат:** в полях «Месяц» и «Год» появляется сообщение «Неверный формат».

8. Покупка в кредит с вводом нулей в поля «Месяц» и «Год».  
**Ожидаемый результат:** в полях «Месяц» и «Год» появляется сообщение «Неверный формат».

9. Покупка по карте с вводом нулей в поле «CVC/CVV».  
**Ожидаемый результат:** в поле «CVC/CVV» появляется сообщение «Неверный формат».

10. Покупка в кредит с вводом нулей в поле «CVC/CVV».  
**Ожидаемый результат:** в поле «CVC/CVV» появляется сообщение «Неверный формат».

11. Покупка по карте с истекшим сроком действия (год).  
**Ожидаемый результат:** под полем «Год» появляется сообщение «Истёк срок действия карты».

12. Покупка в кредит с истекшим сроком действия (год).  
**Ожидаемый результат:** под полем «Год» появляется сообщение «Истёк срок действия карты».

13. Покупка по карте с истекшим сроком действия (месяц).  
**Ожидаемый результат:** под полем «Год» появляется сообщение «Истёк срок действия карты».

14. Покупка в кредит с истекшим сроком действия (месяц).  
**Ожидаемый результат:** под полем «Год» появляется сообщение «Истёк срок действия карты».
## Перечень используемых инструментов с обоснованием выбора
* **IntelliJ IDEA** – интегрированная среда разработки программного обеспечения.
* **Java 11** – современная надежная версия.
* **Docker** – программное обеспечение для автоматизации развёртывания и управления приложениями в средах с поддержкой контейнеризации.
* **Gradle** – система автоматической сборки и управления зависимостями.
* **JUnit5** – фреймворк для написания авто-тестов и их запуска.
* **Selenide** – фреймворк для написания тестов.
* **Allure** – фреймворк для создания отчётов авто-тестов.
## Перечень и описание возможных рисков при автоматизации
* Ограниченность времени.
* Отсутствие ТЗ о правильной работе приложения.
* Сложность настройки окружения.
## Интервальная оценка с учетом рисков (в часах)
* Настройка окружения – **10**
* Написание и запуск авто-тестов – **40**
* Подготовка отчетных документов – **10**
## План сдачи работ
* Планирование автоматизации тестирования – **26.11.2021**
* Автоматизация – **15.12.2021**
* Сдача отчетных документов – **20.12.2021**
