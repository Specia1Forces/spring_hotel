# Spring Hotel — HTTP-интерфейс

Приложение ведёт данные гостиницы через страницы Spring MVC и Thymeleaf. Контроллеры возвращают HTML или перенаправление. Формы передают поля через `application/x-www-form-urlencoded`. Справочник охватывает 28 маршрутов контроллеров. Для сверки использованы контроллеры, формы, модели и настройки Spring Security.

## Адрес и вход

- Базовый адрес по умолчанию `http://localhost:8080`. Приложение рассчитано на Java 17 и MySQL. В настройках указана локальная база `hotel_spring` на порту `3306`.
- Spring Security предоставляет страницу `GET /login` и принимает логин и пароль на `POST /login`. После успешного входа браузер использует сессию. Страница приложения после входа — `/hotel_management`. Для неё можно задать адрес вручную, если вход выполнен напрямую со страницы `/login`.
- Все 28 маршрутов требуют входа. Для отдельных групп дополнительно проверяется роль. Запрос защищённой страницы без сессии перенаправляется к форме входа. При недостаточной роли после входа Spring Security отвечает `403`.
- Thymeleaf отправляет формы `PATCH` как `POST` с полем `_method=PATCH`. Настройка `spring.mvc.hiddenmethod.filter.enabled=true` преобразует метод перед обработкой запроса. В таблицах указан метод контроллера. [Spring MVC — HiddenHttpMethodFilter](https://docs.spring.io/spring-framework/docs/6.1.4/javadoc-api/org/springframework/web/filter/HiddenHttpMethodFilter.html) · [Spring Security — форма входа](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html) · [Настройки приложения](../src/main/resources/application.properties)

Успешный вывод страницы обычно даёт `200`, а `redirect:…` в контроллере перенаправляет браузер на указанный маршрут. Единого JSON-формата ошибок и явного контракта `404` для всех отсутствующих объектов в контроллерах нет. Идентификатор `{id}` в маршрутах услуг имеет тип `int`.

## Матрица ролей

| Маршруты | Условие доступа по конфигурации |
| --- | --- |
| `/hotel_management` и GET журнала уборки и техосмотров | `MANAGER`, `ADMIN` или `HOTEL_MANAGEMENT_SERVICE` |
| `/hotel_management/personnel/**` | `MANAGER` или `ADMIN` |
| `/hotel_management/clients_and_contracts/**`, `/hotel_management/room_reservations/**` | `MANAGER` |
| `GET /all_services` и `POST /all_services` | `MANAGER` или `ADMIN` |
| Формы и операции по другим путям каталога услуг | Достаточно общей аутентификации по текущему правилу. Ограничение для точного пути `/all_services` на них не распространяется. |

Учётные записи для трёх ролей определены в памяти, проверка паролей использует BCrypt. CSRF в текущей конфигурации отключён. Для изменений журнала есть правила доступа, но соответствующих HTTP-обработчиков в контроллере журнала нет. [Конфигурация Spring Security](../src/main/java/com/project/hotel/config/SecurityConfiguration.java)

## Главная страница и журнал

| Метод и маршрут | Ответ |
| --- | --- |
| `GET /hotel_management` | Меню гостиницы со ссылками на разделы. |
| `GET /hotel_management/cleaning_and_technical_inspection_log` | Страница журнала. Ссылки на уборку и техосмотры пока ведут на `#`. |

[Главная страница](../src/main/java/com/project/hotel/controller/DifferentiationOfStaffAndCustomers.java) · [Контроллер журнала](../src/main/java/com/project/hotel/controller/CleaningAndTechnicalInspectionLog.java)

## Клиенты и договоры

| Метод и маршрут | Вход | Ответ и действие |
| --- | --- | --- |
| `GET /hotel_management/clients_and_contracts` | — | Меню раздела. |
| `GET /hotel_management/clients_and_contracts/clients_of_hotel` | — | HTML-список клиентов. |
| `GET /hotel_management/clients_and_contracts/client_of_hotel_create` | — | Форма создания клиента. |
| `POST /hotel_management/clients_and_contracts` | Поля клиента | Сохраняет клиента и перенаправляет в меню раздела. |
| `GET /hotel_management/clients_and_contracts/create_contracts` | — | Форма договора со списком клиентов. |
| `PATCH /hotel_management/clients_and_contracts/add` | Поля договора и `clientId` | Сохраняет новый договор со связанным клиентом и перенаправляет в меню раздела. |

[Контроллер клиентов и договоров](../src/main/java/com/project/hotel/controller/ClientsAndContracts.java)

## Бронирования и счета

| Метод и маршрут | Вход | Ответ и действие |
| --- | --- | --- |
| `GET /hotel_management/room_reservations` | — | Меню раздела. |
| `GET /hotel_management/room_reservations/booking_list` | — | HTML-список бронирований. |
| `GET /hotel_management/room_reservations/create_reservations` | — | Форма бронирования со списком клиентов. |
| `PATCH /hotel_management/room_reservations/add` | Поля брони и `clientId` | Сохраняет новую бронь для выбранного клиента и перенаправляет на `/hotel_management/room_reservations/booking_list`. |
| `GET /hotel_management/room_reservations/accounts_list` | — | HTML-список счетов. |
| `GET /hotel_management/room_reservations/create_accounts` | — | Форма счёта со списком броней. |
| `PATCH /hotel_management/room_reservations/add_accounts` | Поля счёта и `reservationId` | Сохраняет новый счёт для выбранной брони и перенаправляет на `/hotel_management/room_reservations/accounts_list`. |

Форма создания брони передаёт клиента, даты, сумму и статусы. Выбор номера и проверка его доступности в этом сценарии отсутствуют. [Контроллер бронирований и счетов](../src/main/java/com/project/hotel/controller/RoomReservations.java)

## Персонал

| Метод и маршрут | Вход | Ответ и действие |
| --- | --- | --- |
| `GET /hotel_management/personnel` | — | Меню раздела персонала. |
| `GET /hotel_management/personnel/maids` | — | HTML-список сотрудников уборки. |
| `GET /hotel_management/personnel/maids/maid_create` | — | Форма добавления сотрудника уборки. |
| `POST /hotel_management/personnel/maids` | Имя, отчество и фамилия | Сохраняет сотрудника и перенаправляет на `/hotel_management/personnel/maids`. |
| `GET /hotel_management/personnel/collaborator_maintenance` | — | Обработчик списка технического персонала. Обращается к первому элементу списка перед рендерингом. |
| `GET /hotel_management/personnel/collaborator_maintenance/collaborator_maintenance_create` | — | Страница добавления сотрудника. Поля имени в шаблоне закомментированы. |
| `POST /hotel_management/personnel/collaborator_maintenance` | Контроллер принимает поля сотрудника | Сохраняет сотрудника и перенаправляет на `/hotel_management/personnel/collaborator_mainenance`. Этот путь отличается от маршрута списка. |

[Контроллер персонала](../src/main/java/com/project/hotel/controller/Personnel.java)

## Дополнительные услуги

| Метод и маршрут | Вход | Ответ и действие |
| --- | --- | --- |
| `GET /all_services` | — | HTML-список услуг. |
| `GET /service_create` | — | Форма добавления услуги. |
| `POST /all_services` | `name`, `servicePrice` | Сохраняет услугу и перенаправляет на `/all_services`. |
| `GET /service_edit/{id}` | `id` услуги | Форма изменения услуги. Обработчик не возвращает явный `404` при отсутствии записи. |
| `PATCH /all_services/{id}` | `id` услуги, `name`, `servicePrice` | Присваивает модели ID из пути, сохраняет её и перенаправляет на `/all_services`. |
| `GET /service_delete/{id}` | `id` услуги | Удаляет услугу и перенаправляет на `/all_services`. Этот GET изменяет данные. |

[Контроллер услуг](../src/main/java/com/project/hotel/controller/Services.java) · [Сервис услуг](../src/main/java/com/project/hotel/service/AllServicesService.java)

## Поля форм

Названия полей приведены по моделям и рабочим элементам шаблонов. Даты привязываются в формате `dd/MM/yyyy`, например `05/12/2026`. Суммы, цена, срок проживания и идентификаторы в указанных моделях имеют тип `int`. Статусы брони и предоплаты хранятся строками.

| Данные | Поля |
| --- | --- |
| Клиент | `name`, `middleName`, `lastName`, `gender`, `birthdate`, `address`, `phone` |
| Договор | `clientId`, `termOfStay`, `dateConclusionAgreement` |
| Бронь | `clientId`, `settlementDate`, `evictionDate`, `totalAmountOfPayment`, `prepaymentStatus`, `bookingStatus`, `residenceStatus` |
| Счёт | `reservationId`, `amountToBePaid`, `amountOfPrepayment`, `amountForAdditionalServices` |
| Сотрудник уборки | `name`, `middleName`, `lastName` |
| Сотрудник техобслуживания | Модель принимает `name`, `middleName` и `lastName`. Текущая форма этих полей не отправляет. |
| Услуга | `name`, `servicePrice` |

В форме бронирования ссылка на сумму записана как `booking.TotalAmountOfPayment`, а свойство модели называется `totalAmountOfPayment`. Это расхождение следует учитывать при сверке отчёта с формой. [Шаблон бронирования](<../src/main/resources/templates/room reservations/reservation/reservation.html>) · [Модель Booking](../src/main/java/com/project/hotel/models/Booking.java)

## Границы проверки

- Ссылки на редактирование и удаление клиента есть в шаблоне списка, но активных контроллеров для этих действий нет.
- Для пустого списка техперсонала вызов `get(0)` прерывает обработку страницы. Перенаправление после создания сотрудника также ведёт на путь с опечаткой.
- Сверка выполнена по исходникам. Приложение и запросы с MySQL не запускались. В проекте есть тест загрузки контекста, без сценариев на маршруты и роли. [Тест приложения](../src/test/java/com/project/hotel/HotelApplicationTests.java)
