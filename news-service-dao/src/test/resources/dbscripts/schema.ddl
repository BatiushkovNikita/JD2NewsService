CREATE TABLE news
(
    id INT PRIMARY KEY NOT NULL DEFAULT 0,
    topic VARCHAR(255),
    publication_date DATETIME,
    news_text LONGTEXT,
    user_id INT
);
CREATE TABLE roles
(
    id INT PRIMARY KEY NOT NULL DEFAULT 0,
    role_name VARCHAR(50)
);
CREATE TABLE users
(
    id INT PRIMARY KEY NOT NULL DEFAULT 0,
    email VARCHAR(50),
    password VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);
CREATE TABLE users_roles
(
    user_id INT,
    role_id INT
);
ALTER TABLE news ADD FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_roles ADD FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_roles ADD FOREIGN KEY (role_id) REFERENCES roles (id);
