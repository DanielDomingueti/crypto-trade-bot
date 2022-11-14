INSERT INTO tb_user(user_type_id, name, email, password, is_admin) VALUES (1, 'natural user', 'user@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', false);
INSERT INTO tb_user(user_type_id, name, email, password, is_admin) VALUES (2, 'legal user', 'usertwo@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', false);
INSERT INTO tb_user(user_type_id, name, email, password, is_admin) VALUES (1, 'natural admin', 'admin@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', true);

INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (1, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (2, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (3, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (3, 2);