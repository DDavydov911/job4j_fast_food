 create table dishes (
     id serial primary key,
     dishName varchar(200) not null unique,
     description varchar(1000),
     price numeric
 );

 create table ingredients (
     id serial primary key,
     food_name varchar(140),
     price numeric
 );

 create table dish_ingredient (
     id serial primary key,
     dish_id integer not null references dishes(id),
     ingredient_id integer not null references ingredients(id)
 );