insert into dishes
(dishName, description, price)
values
('Meet and Potato', 'Description1', 100),
('Fish and Potato', 'Description2', 200),
('Fried eggs', 'Description3', 300);


insert into ingredients
(food_name, price)
values
('Potato', 5.0),
('Meet', 15.0),
('Fish', 20.0),
('Eggs', 10.0);

insert into dish_ingredient
(dish_id, ingredient_id)
values
(1, 1),
(1, 2),
(2, 3),
(2, 2),
(3, 4);