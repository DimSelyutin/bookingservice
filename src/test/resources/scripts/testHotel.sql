-- Вставка данных в таблицу addresses
INSERT INTO addresses (city, country, house_number, post_code, street)
VALUES ('Minsk', 'Belarus', '10', '220000', 'Lenin Street'),
       ('Grodno', 'Belarus', '5', '230000', 'Victory Avenue');

-- Вставка данных в таблицу arrival_times
INSERT INTO arrival_times (check_in, check_out)
VALUES ('14:00', '18:00'),
       ('15:00', '19:00');

-- Вставка данных в таблицу contacts
INSERT INTO contacts (email, phone)
VALUES ('contact@testhotel.com', '+375291234567'),
       ('info@anotherhotel.com', '+375291234568');

-- Вставка данных в таблицу hotels
INSERT INTO hotels (name, brand, description, address_id, contact_id, arrival_time_id)
VALUES ('DoubleTree by Hilton Minsk', 'Test Brand', 'A fine hotel for your stay.', 1, 1, 1),
       ('Radisson Blu Grodno', 'Another Brand', 'Luxury hotel in the heart of Grodno.', 2, 2, 2);
-- Вставка данных в таблицу amenities
INSERT INTO amenities (name)
VALUES ('Free WiFi'),
       ('Breakfast Included'),
       ('Swimming Pool'),
       ('Fitness Center'),
       ('Pet Friendly');

-- Предполагаем, что у вас есть промежуточная таблица для связи гостиниц с удобствами
-- Вставка данных в таблицу hotel_amenities для связи гостиниц и удобств
INSERT INTO hotel_amenities (hotel_id, amenity_id)
VALUES (1, 1), -- Связываем DoubleTree by Hilton Minsk с Free WiFi
       (1, 2), -- Связываем DoubleTree by Hilton Minsk с Breakfast Included
       (1, 3), -- Связываем DoubleTree by Hilton Minsk с Swimming Pool
       (2, 1), -- Связываем Radisson Blu Grodno с Free WiFi
       (2, 4); -- Связываем Radisson Blu Grodno с Fitness Center
