# Проект по API тестам для [reqres.in](https://reqres.in/)

<p align="center">
<img title="reqres.in" name="reqres.in" src="media/logo/reqresIn.png">
</p>

##  Содержание:

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Запуск тестов](#-запуск-тестов)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Уведомления в Telegram](#-уведомления-в-telegram)

##  Технологии и инструменты

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://qameta.io/"><img src="media/logo/Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
</p>

## Тест кейсы

- [x] Успешная регистрация пользователя
- [x] Неуспешная регистрация пользователя
- [x] Успешный логин пользователя
- [x] Неуспешный логин пользователя
- [x] Создание пользователя
- [x] Обновление пользователя
- [x] Удаление пользователя
- [x] Неуспешный поиск пользователя
- [x] Проверка, что количество записей в списке равно заданному


# Запуск тестов

Для  запуска тестов:
```shell
gradle clean test 
```

Получение отчёта:
```bash
allure serve build/allure-results
```

## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/diploma_project_mobile/)

###Сборка проекта:
- Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/regresInApiTesting/">проект</a>
- Нажать **Собрать**
- Результат запуска сборки можно посмотреть в отчёте Allure
<p align="center">
  <img src="media/screen/reg_jenkins.png" alt="Jenkins" width="800">
</p>

## <img width="4%" title="Allure Report" src="media/logo/Allure_Report.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/diploma_project_mobile/1/allure/)

<p align="center">
  <img src="media/screen/reg_allure.png" alt="allure-report_1" width="900">
</p>

## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прохождении тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screen/reg_telegram.png">



[Вернуться к началу ⬆](#Wikipedia)