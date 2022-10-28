INSERT INTO tb_config(name, value) VALUES ('TOKEN_SECRET', 'test-token-signature');
INSERT INTO tb_config(name, value) VALUES ('SIGN_IN_USER_URL', '/user/login');
INSERT INTO tb_config(name, value) VALUES ('HEADER_STRING', 'Authorization');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_TYPE', 'Bearer ');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_EXPIRATION_TIME', '86400000');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_ADMIN_EXPIRATION_TIME', '86400000');

INSERT INTO tb_user(name, email, password, is_admin) VALUES ('user', 'user@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', false);
INSERT INTO tb_user(name, email, password, is_admin) VALUES ('admin', 'admin@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', true);

INSERT INTO tb_user_group(name, description) VALUES ('regular_client', 'REGULAR CLIENT');
INSERT INTO tb_user_group(name, description) VALUES ('admin', 'ADMIN');

INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (1, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (2, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (2, 2);
