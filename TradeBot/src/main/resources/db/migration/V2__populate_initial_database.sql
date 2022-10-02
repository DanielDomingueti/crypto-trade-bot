INSERT INTO tb_config(name, value) VALUES ('TOKEN_SECRET', 'test-token-signature');
INSERT INTO tb_config(name, value) VALUES ('SIGN_IN_USER_URL', '/user/login');
INSERT INTO tb_config(name, value) VALUES ('SIGN_IN_ADMIN_URL', '/admin/login');
INSERT INTO tb_config(name, value) VALUES ('HEADER_STRING', 'Authorization');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_TYPE', 'Bearer ');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_EXPIRATION_TIME', '86400000');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_ADMIN_EXPIRATION_TIME', '86400000');

INSERT INTO tb_user(name, email, password) VALUES ('teste user', 'teste@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e');
INSERT INTO tb_user_group(name, description) VALUES ('regular_client', 'REGULAR CLIENT');
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (1, 1);
INSERT INTO tb_user_route(route, method, description) VALUES ('/documents/all/*', 'GET', 'Fetch documents by user id');
INSERT INTO tb_pivot_user_group_user_route(user_group_id, user_route_id) VALUES (1, 1);

INSERT INTO tb_admin(name, email, password) VALUES ('admin', 'admin@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e');
INSERT INTO tb_admin_group(name, description) VALUES ('admin', 'ADMIN');
INSERT INTO tb_pivot_admin_group_admin(admin_id, admin_group_id) VALUES (1, 1);
INSERT INTO tb_admin_route(route, method, description) VALUES ('/admin/teste/**', 'GET', 'Testing full access to admins');
INSERT INTO tb_pivot_admin_group_admin_route(admin_group_id, admin_route_id) VALUES (1, 1);


