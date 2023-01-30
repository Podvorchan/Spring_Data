-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_store.order_id_seq;
CREATE SEQUENCE IF NOT EXISTS my_store.product_id_seq;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.product
(
    id integer NOT NULL DEFAULT next-val('my_store.product_id_seq'),
    name           text NOT NULL,
    cost           integer NOT NULL
);

CREATE TABLE IF NOT EXISTS my_store.order
(
    id integer NOT NULL DEFAULT next-val('my_store.order_id_seq'),
    creation_date    date,
    cost            integer NOT NULL,
    products        text NOT NULL,
     primary key  (id),
       foreign key  (order_id) references my_store.order (id)
    );


-- -- Создание индекса
 CREATE INDEX IF NOT EXISTS idx_order_status ON my_store.order USING hash (cost);