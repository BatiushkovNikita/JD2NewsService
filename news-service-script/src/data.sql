INSERT INTO users (email, password, first_name, last_name) VALUES
  ('aaa@gmail.com', MD5('pass'), 'Sergey', 'Katabin');
INSERT INTO users (email, password, first_name, last_name) VALUES
  ('bbb@gmail.com', MD5('12345'), 'Nikita', 'Petrov');
INSERT INTO users (email, password, first_name, last_name) VALUES
  ('ccc@gmail.com', MD5('123'), 'Ivan', 'Ivanov');
INSERT INTO users (email, password, first_name, last_name) VALUES
  ('ggg@gmail.com', MD5('qwerty'), 'Irina', 'Smernova');
INSERT INTO users (email, password, first_name, last_name) VALUES
  ('fff@gmail.com', MD5('12345'), 'Antom', 'Kryglo');

INSERT INTO news (topic, publication_date, news_text, user_id) VALUES
  ('topic1', '2015-12-08', 'News text1', 1);
INSERT INTO news (topic, publication_date, news_text, user_id) VALUES
  ('topic2', '2015-12-08', 'News text2', 2);
INSERT INTO news (topic, publication_date, news_text, user_id) VALUES
  ('topic3', '2015-12-08', 'News text3', 2);
INSERT INTO news (topic, publication_date, news_text, user_id) VALUES
  ('topic4', '2015-12-08', 'News text4', 5);

INSERT INTO roles (role_name) VALUES
  ('admin');
INSERT INTO roles (role_name) VALUES
  ('moderator');
INSERT INTO roles (role_name) VALUES
  ('user');

INSERT INTO users_roles (user_id, role_id) VALUES
  (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES
  (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES
  (3, 3);
INSERT INTO users_roles (user_id, role_id) VALUES
  (4, 3);