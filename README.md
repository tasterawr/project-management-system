# project-management-system

### Общая структура проекта

![project_structure](https://github.com/tasterawr/project-management-system/assets/70659948/35239749-a75d-41ea-a15a-fde727a05726)

---
### Описание модулей проекта
* **Модуль controller**. Содержит пакет ***com.digdes.java2023.controller*** с классами контроллеров приложения.
* **Модуль dto**. Содержит пакет ***com.digdes.java2023.dto*** с DTO классами приложения.
* **Модуль business**. Содержит пакет ***com.digdes.java2023*** с подпакетами ***model*** (хранит классы моделей приложения), 
***repo*** (хранит классы репозиториев), ***service*** (хранит классы сервисов).
* **Модуль app**. Содержит пакет ***com.digdes.java2023*** с главным классом ***Main***.

---
### Декомпозиция проекта по блокам
* **Разработка моделей и DAL.** Описание моделей и метаданных Hibernate, разработка репозиториев, соединения с БД.
* **Разработка бизнес логики.** Разработка основной логики в коде сервисов.
* **Разработка REST API.** Разработка API приложения, эндпоинтов и создание методов контроллеров, соответствующих им.
* **Разработка аутентификации.** Разработка системы аутентификации и авторизации юзеров с помощью Spring Security.
* **Тестирование.** Покрытие приложения тестами.
* **Логирование.** Покрытие кода логами.
