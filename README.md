# desk-common-dto

Общая библиотека DTO для доски объявлений.


## Структура проекта

```
src/main/java/org/example/
│
├── advertisement/        — Объявления, категории, атрибуты
├── auction/              — Аукционы и ставки
├── auth/                 — Регистрация, логин, пароли, роли
├── chat/                 — Чат между покупателем и продавцом
├── comment/              — Комментарии к объявлениям
├── eventDto/             — События для обмена между модулями
├── photo/                — Загрузка фото через Cloudinary
└── user/                 — Профили, верификация компаний, ИНН
```

---

## advertisement — Объявления

### Запросы (request)

| Класс | Зачем |
|---|---|
| `AdvertisementCreateRequestDto` | Создать объявление |
| `AdvertisementUpdateRequest` | Редактировать объявление |
| `AdvertisementSearchRequest` | Поиск объявлений с фильтрами и пагинацией |
| `CategoryCreateRequest` | Создать категорию |
| `CategoryUpdateRequest` | Редактировать категорию |
| `CategoryAttributeCreateRequest` | Добавить атрибут к категории |
| `CategoryAttributeUpdateRequest` | Редактировать атрибут категории |

### Ответы (response)

| Класс | Зачем                                  |
|---|----------------------------------------|
| `AdvertisementResponseDto` | Полная информация об объявлении        |
| `AdvertisementShortDto` | Карточка объявления в списке           |
| `AdvertisementInfoForChatDto` | Минимальная информация для чата        |
| `CategoryDto` | Категория с деревом дочерних категорий |
| `CategoryAttributeDto` | Атрибут категории                      |
| `CategoryImportResultResponse` | Результат импорта категорий            |
| `PageResponse<T>` | Обёртка для постраничного ответа       |

### Вспомогательные

| Класс | Зачем |
|---|---|
| `AdvertisementAttributeValueDto` | Значение атрибута объявления |
| `AttributeFilterDto` | Фильтр по атрибуту |
| `AttributeValueInput` | Ввод атрибута при создании объявления |
| `Location` | Адрес: страна, город, улица, дом |
| `AttributeType` | Тип атрибута: строка, число, дата, булево, выбор |
| `SortOption` | Варианты сортировки: по дате, по цене |

### Валидация

| Аннотация | Что проверяет |
|---|---|
| `@ValidAttributeValue` | Значение атрибута: не объект/массив, не слишком длинное, без отрицательных чисел |
| `@ValidCostRange` | Цена «от» не больше цены «до» |

---

## auction — Аукционы

### Запросы

| Класс | Зачем |
|---|---|
| `AuctionCreateRequest` | Создать аукцион |
| `AuctionUpdateRequest` | Обновить аукцион (шаг, текущая цена) |
| `BidRequest` | Сделать ставку |

### Ответы

| Класс | Зачем                             |
|---|-----------------------------------|
| `AuctionResponse` | Полная информация об аукционе     |
| `BidResponse` | Информация о ставке               |
| `SubscribeAuctionResponse` | Подтверждение подписки на аукцион |
| `AuctionRedisInfoDto` | Лёгкая версия для Redis           |
| `RedisBidEntryDto` | Ставки в Redis                    |

### Вспомогательные

| Класс | Зачем |
|---|---|
| `AuctionStatus` | Статус аукциона: ожидание, активный, завершён, отменён |
| `ParticipantStatus` | Статус участника: подписан, активен, выбыл |
| `AuctionConfigConstants` | Константы: допустимое число участников, таймауты |

### Валидация

| Аннотация | Что проверяет |
|---|---|
| `@ValidAuctionDates` | Дата окончания позже начала, длительность от 10 мин до 24 ч |
| `@AtLeastThreeDaysInFuture` | Дата минимум через 3 дня от сейчас |
| `@ValidMaxParticipants` | Число участников из списка: 10, 25, 50, 100 |

---

## auth — Авторизация

### Запросы

| Класс | Зачем |
|---|---|
| `RegisterUserRequest` | Регистрация нового пользователя |
| `LoginUserRequest` | Вход (логин + пароль) |
| `ChangePasswordRequest` | Смена пароля |
| `RoleUpdateRequest` | Изменить роль |

### Ответы

| Класс | Зачем |
|---|---|
| `TokenResponse` | JWT-токены: access + refresh |
| `CaptchaResponse` | Данные капчи для отрисовки |
| `RoleDto` | Роль: id + название |

### Валидация

| Аннотация | Что проверяет |
|---|---|
| `@FieldsMatch` | Два поля совпадают (пароль == подтверждение) или не совпадают (старый != новый пароль) |

---

## chat — Чат

### Запросы

| Класс | Зачем |
|---|---|
| `ChatSearchRequest` | Поиск чатов с пагинацией |
| `MessageCreateRequest` | Отправить сообщение |
| `MessageUpdateRequest` | Редактировать сообщение |

### Ответы

| Класс | Зачем |
|---|---|
| `ChatResponse` | Карточка чата: собеседник, аватар, последнее сообщение |
| `CreateChatResponse` | Результат создания чата |
| `MessageResponse` | Сообщение: текст, отправитель, статус, время |

### Вспомогательные

| Класс | Зачем |
|---|---|
| `ChatMessageStatus` | Статус сообщения: прочитано, отправляется, не прочитано, ошибка |

---

## comment — Комментарии

### Запросы

| Класс | Зачем |
|---|---|
| `CommentCreateRequest` | Создать комментарий (можно ответить на другой) |
| `CommentUpdateRequest` | Редактировать комментарий |
| `CommentSearchRequest` | Поиск комментариев с фильтрами |

### Ответы

| Класс | Зачем |
|---|---|
| `CommentResponse` | Комментарий: текст, лайки, автор, ответы, глубина вложенности |

### Вспомогательные

| Класс | Зачем |
|---|---|
| `CommentStatus` | Статус: виден, скрыт, на модерации, удалён |

---

## photo — Фотографии

### DTO

| Класс | Зачем |
|---|---|
| `PhotoDto` | Полные данные фото: URL-ы, размер, тип, порядок |
| `PhotoToAdvertDto` | Фото, привязанное к объявлению |
| `TempPhotoDto` | Временное фото (загружено до создания объявления) |
| `CloudinaryUploadResult` | Результат загрузки в Cloudinary |

### Вспомогательные

| Класс | Зачем |
|---|---|
| `PhotoType` | Тип фото: аватар, главное, галерея |
| `OwnerType` | Кому принадлежит фото: пользователь, объявление, документ |

### Валидация

| Аннотация | Что проверяет |
|---|---|
| `@ValidImageFile` | Один файл: не пустой, до 10 МБ |
| `@ValidImageFiles` | Список файлов: не больше 10 штук, каждый до 10 МБ |

---

## user — Пользователи

### DTO

| Класс | Зачем |
|---|---|
| `UserProfilePublicDto` | Публичный профиль пользователя |
| `UserProfileUpdateRequest` | Обновить профиль |
| `UserProfileSearchDto` | Поиск пользователей |
| `ShortUserDto` | Краткая карточка пользователя |
| `ShortUserChatDto` | Минимальная информация для чата |
| `CompanyInfoDto` | Информация о компании |
| `CompanyVerificationRequestDto` | Заявка на верификацию (полная) |
| `CompanyVerificationSubmitRequest` | Подать заявку на верификацию |
| `CompanyVerificationReviewRequest` | Рассмотреть заявку (админ) |

### Вспомогательные

| Класс | Зачем |
|---|---|
| `ProfileType` | Тип профиля: личный / компания |
| `CompanyStatus` | Статус компании из ФНС: действующая, в ликвидации, банкрот и т.д. |
| `VerificationStatus` | Статус заявки: ожидание, одобрена, отклонена |

### Валидация

| Аннотация | Что проверяет |
|---|---|
| `@ValidInn` | Формат ИНН: 10 или 12 цифр с проверкой контрольной суммы |
| `@ValidCompanyFields` | У компании заполнены название и ИНН; у личного профиля нет названия компании |

---

## eventDto — События между сервисами

### Объявления

| Класс | Когда отправляется |
|---|---|
| `AdvertisementDeletedEvent` | Объявление удалено |
| `AdvertisementPhotosUploadedEvent` | Фото загружены |

### Аукционы

| Класс | Когда отправляется |
|---|---|
| `AuctionStartedEvent` | Аукцион начался |
| `AuctionEndedEvent` | Аукцион завершился |
| `AuctionDeletedEvent` | Аукцион удалён |
| `AuctionUpdatedEvent` | Аукцион обновлён |
| `AuctionSubscribedEvent` | Пользователь подписался |
| `AuctionUnsubscribedEvent` | Пользователь отписался |

### Пользователи

| Класс | Когда отправляется |
|---|---|
| `UserRegisteredEvent` | Регистрация |
| `UserDeletedEvent` | Удаление |
| `EmailVerificationEvent` | Подтверждение email |
| `PasswordResetEvent` | Сброс пароля |
| `SuspiciousActivityEvent` | Подозрительная активность |

### Фото

| Класс | Когда отправляется |
|---|---|
| `AvatarUploadedEvent` | Аватар загружен |
| `AvatarDeletedEvent` | Аватар удалён |
| `PhotoDeletedEvent` | Фото удалено |
| `PrimaryPhotoChangedEvent` | Главное фото изменено |

### Общение

| Класс | Когда отправляется |
|---|---|
| `MessageSentEvent` | Сообщение отправлено |
| `CommentLikedEvent` | Комментарий лайкнут |

---

## Как подключить

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>desk-common-dto</artifactId>
    <version>...</version>
</dependency>
```

## Валидная версия
```text
1.0.0
```
