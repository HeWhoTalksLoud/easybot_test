-- Типы товаров
insert into category (name)
values ('Настольные компьютеры'), ('Ноутбуки'), ('Мониторы'), ('Жесткие диски');

-- Производители
insert into manufacturer (name)
values ('Sony'), ('Samsung'), ('Acer'), ('HP'), ('LG');

-- Товары
insert into item (serial_number, manufacturer_id, category_id, price, quantity)
values ('ABC123', 1, 1, 499.99, 10),
       ('DEF456', 2, 1, 899.99, 5),
       ('GHI789', 3, 2, 49.99, 20),
       ('JKL012', 4, 2, 29.99, 15),
       ('MNO345', 5, 3, 799.99, 8),
       ('856540654', 5, 4, 19999.99, 3),
       ('00546865', 2, 4, 25000.00, 12);

-- Свойства
insert into property (category_id, name)
values (1, 'Форм-фактор'),
       (2, 'Размер, дюймы'),
       (3, 'Диагональ, дюймы'),
       (4, 'Объем, ГБ');

-- Значения свойств у опред. ед. товара
insert into item_property_value (item_id, property_id, value)
values (1, 1, 'Десктоп'),
       (2, 1, 'Неттоп'),
       (3, 2, '17'),
       (4, 2, '15'),
       (5, 3, '15'),
       (6, 4, '16');