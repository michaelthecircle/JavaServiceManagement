<h1>Сервис менеджер</h1>

Сервис менеджер по типу RESTfull, на базе `Spring Boot`.

Сервис управляет правилами фильтрации https://github.com/michaelthecircle/JavaServiceFiltering, 
дедубликации https://github.com/michaelthecircle/JavaServiceDeduplication,
обогащения https://github.com/michaelthecircle/JavaServiceEnrichment.
Пользователь через `Swagger` (`OpenApi`) имеет возможность получать всю информацию по правилам, добавлять новые правила и удалять правила из базы данных `PostgreSQL`.
Таким образом сервис менеджера имеет подключение к каждой из таблиц сервисов фильтрации, дедубликации и обогащения в `PostgreSQL`.
<p>Сервис имеет валидацию входных данных.
<p>Сервис имеет актуальное описание endpoint's через swagger.
<p>Сервис имеет следующие метрики:
<ol>
    <li> Количество правил фильтрации - название метрики countFilters</li>
    <li> Количество правил дедубликации - название метрики countDeduplications</li>
    <li> Количество правил обогащения - название метрики countEnrichments</li>
</ol>

Сервис вычитывает конфигурации из `application.conf` и/или `application.yaml`.

Сервис по запросам манипулирует данными в `PostgreSQL`.

Для соединения и работы с БД используются средства `Spring Boot JPA`.

Для валидации данных используются средства `Spring Boot Validation`.

Для документации используется `Swagger (OpenApi)`.

Для метрик используется `Actuator`.

Для логирования используется библиотека `Sl4j`.

Для работы с JSON используется библиотека `jackson`.

![Сервис менеджмента](https://github.com/new94/JavaServiceManagment/assets/3996014/2ef88a52-2f13-4e80-ae70-a4d886c785be)
