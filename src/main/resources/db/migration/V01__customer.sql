CREATE TABLE CUSTOMER(
  id bigserial primary key,
  name varchar(255) not null,
  email varchar(255) not null unique,
  password varchar(255) not null,
  phone varchar(255) not null,
  profile_image_id TEXT not null,
  age int,
  status boolean default false
  );

  INSERT INTO CUSTOMER (id, name, email, password, phone, profile_image_id)
  VALUES (1, 'Ismael Trocha', 'ismaeltrocha@gmail.com', '1234', '3001111100', 'test_url');


  CREATE TABLE IMAGEUPLOAD(
      id bigserial primary key,
      name varchar(255) not null,
      resource TEXT not null
  );