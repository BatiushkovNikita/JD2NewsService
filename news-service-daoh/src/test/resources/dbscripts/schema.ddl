CREATE TABLE news
(
    id INT NOT NULL,
    topic VARCHAR(45),
    publication_date DATETIME,
    news_text LONGTEXT,
    users_id INT NOT NULL,
    PRIMARY KEY (id, users_id)
);
CREATE TABLE news_tag
(
    news_id INT NOT NULL,
    tag_id INT NOT NULL,
    PRIMARY KEY (news_id, tag_id)
);
CREATE TABLE role
(
    id INT PRIMARY KEY NOT NULL,
    role_name VARCHAR(45)
);
CREATE TABLE tag
(
    id INT PRIMARY KEY NOT NULL,
    tag_name VARCHAR(45)
);
CREATE TABLE user
(
    id INT PRIMARY KEY NOT NULL,
    email VARCHAR(45),
    password VARCHAR(45)
);
CREATE TABLE user_details
(
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    phone VARCHAR(45),
    user_id INT PRIMARY KEY NOT NULL
);
CREATE TABLE user_role
(
    users_id INT NOT NULL,
    roles_id INT NOT NULL,
    PRIMARY KEY (users_id, roles_id)
);
ALTER TABLE news ADD FOREIGN KEY (users_id) REFERENCES user (id);
CREATE INDEX fk_news_users1_idx ON news (users_id);
ALTER TABLE news_tag ADD FOREIGN KEY (news_id) REFERENCES news (id);
ALTER TABLE news_tag ADD FOREIGN KEY (tag_id) REFERENCES tag (id);
CREATE INDEX fk_news_has_tag_news1_idx ON news_tag (news_id);
CREATE INDEX fk_news_has_tag_tag1_idx ON news_tag (tag_id);
ALTER TABLE user_details ADD FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE user_role ADD FOREIGN KEY (roles_id) REFERENCES role (id);
ALTER TABLE user_role ADD FOREIGN KEY (users_id) REFERENCES user (id);
CREATE INDEX fk_users_has_roles_roles1_idx ON user_role (roles_id);
CREATE INDEX fk_users_has_roles_users1_idx ON user_role (users_id);
