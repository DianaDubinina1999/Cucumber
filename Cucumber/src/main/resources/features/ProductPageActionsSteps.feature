# language: ru
@all
Функционал: Работа с таблицей FOOD

  Сценарий: заходим на сайт
  Дано заходим на сайт "jdbc:h2:tcp://localhost:9092/mem:testdb", вводим логин "user" и пароль "pass"


Сценарий: Проверка отсутствия лишних элементов в базе данных
Дано Выборка всех строк таблицы FOOD индексом >=5

  Сценарий: Добавление новых товаров в таблицу FOOD
    Дано Добавление новых товаров в таблицу FOOD 5,"Огурец","VEGETABLE", 0
  Сценарий: Добавление новых товаров в таблицу FOOD
    Дано Добавление новых товаров в таблицу FOOD 6,'Артишок','VEGETABLE', 1
  Сценарий: Добавление новых товаров в таблицу FOOD
    Дано Добавление новых товаров в таблицу FOOD 7,'Слива','FRUIT', 0
  Сценарий: Добавление новых товаров в таблицу FOOD
    Дано Добавление новых товаров в таблицу FOOD 8,'Манго','FRUIT', 1

Сценарий: Удаление всех строк таблицы FOOD с 5 по 8 индекс
Дано Удаление всех строк таблицы FOOD с индексом >=5

Сценарий: Проверка удаления всех записей
Дано Выборка всех строк таблицы FOOD индексом >=5