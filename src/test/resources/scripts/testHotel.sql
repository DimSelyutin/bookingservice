-- Вставка данных в таблицу addresses
INSERT INTO addresses (city, country, house_number, post_code, street)
VALUES ('Minsk', 'Belarus', '10', '220000', 'Lenin Street'),
       ('Warsaw', 'Poland', '5', '230000', 'Victory Avenue'),
       ('Minsk', 'Belarus', '15', '220001', 'Independence Avenue'), -- Новый адрес для отеля 3
       ('Warsaw', 'Poland', '10', '230001', 'Freedom Boulevard');
-- Новый адрес для отеля 4

-- Вставка данных в таблицу arrival_times
INSERT INTO arrival_times (check_in, check_out)
VALUES ('14:00', '18:00'),
       ('15:00', '19:00'),
       ('13:00', '17:00'), -- Новое время прибытия для отеля 3
       ('12:00', '16:00');
-- Новое время прибытия для отеля 4

-- Вставка данных в таблицу contacts
INSERT INTO contacts (email, phone)
VALUES ('contact@testhotel.com', '+375291234567'),
       ('info@anotherhotel.com', '+375291234568'),
       ('reservations@hotel3.com', '+375291234569'), -- Новый контакт для отеля 3
       ('support@hotel4.com', '+375291234570');
-- Новый контакт для отеля 4

-- Вставка данных в таблицу hotels
INSERT INTO hotels (name, brand, description, address_id, contact_id, arrival_time_id)
VALUES ('DoubleTree by Hilton Minsk', 'Test Brand', 'A fine hotel for your stay.', 1, 1, 1),
       ('Radisson Blu Grodno', 'Another Brand', 'Luxury hotel in the heart of Grodno.', 2, 2, 2),
       ('Hotel 3', 'Brand 3', 'Comfortable hotel in the city center.', 3, 3, 3), -- Новый отель 3
       ('Hotel 4', 'Brand 4', 'Affordable hotel with great amenities.', 4, 4, 4);
-- Новый отель 4

-- Вставка данных в таблицу amenities
INSERT INTO amenities (name)
VALUES ('Free WiFi'),
       ('Breakfast Included'),
       ('Swimming Pool'),
       ('Fitness Center'),
       ('Pet Friendly'),
       ('Spa'), -- Новый удобство для отелей
       ('Parking');
-- Еще одно новое удобство

-- Вставка данных в таблицу hotel_amenities для связи гостиниц и удобств
INSERT INTO hotel_amenities (hotel_id, amenity_id)
VALUES (1, 1), -- Связываем DoubleTree by Hilton Minsk с Free WiFi
       (1, 2), -- Связываем DoubleTree by Hilton Minsk с Breakfast Included
       (1, 3), -- Связываем DoubleTree by Hilton Minsk с Swimming Pool
       (2, 1), -- Связываем Radisson Blu Grodno с Free WiFi
       (2, 4), -- Связываем Radisson Blu Grodno с Fitness Center
       (3, 1), -- Связываем Hotel 3 с Free WiFi
       (3, 5), -- Связываем Hotel 3 с Spa
       (4, 1), -- Связываем Hotel 4 с Free WiFi
       (4, 6); -- Связываем Hotel 4 с Parking
