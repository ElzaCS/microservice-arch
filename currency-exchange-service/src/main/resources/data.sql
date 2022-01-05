CREATE TABLE exchange_value(id INT, currency_from VARCHAR, currency_to VARCHAR, conversion_multiple DECIMAL, port INT);
INSERT INTO exchange_value(id,currency_from,currency_to,conversion_multiple,port) VALUES (10001, 'USD', 'INR', 65, 0);
INSERT INTO exchange_value(id,currency_from,currency_to,conversion_multiple,port) VALUES (10002, 'EUR', 'INR', 75, 0);
INSERT INTO exchange_value(id,currency_from,currency_to,conversion_multiple,port) VALUES (10003, 'AUD', 'INR', 25, 0);
