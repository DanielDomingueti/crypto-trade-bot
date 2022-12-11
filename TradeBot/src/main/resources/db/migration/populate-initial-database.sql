INSERT INTO tb_user_wallet(address) VALUES ('1st_user_wallet_address');
INSERT INTO tb_user_wallet(address) VALUES ('2nd_user_wallet_address');
INSERT INTO tb_user_wallet(address) VALUES ('3rd_user_wallet_address');

INSERT INTO tb_user(user_wallet_id, user_type_id, name, email, password, is_admin) VALUES (1, 1, 'natural user', 'user@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', false);
INSERT INTO tb_user(user_wallet_id, user_type_id, name, email, password, is_admin) VALUES (2, 2, 'legal user', 'usertwo@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', false);
INSERT INTO tb_user(user_wallet_id, user_type_id, name, email, password, is_admin) VALUES (3, 1, 'natural admin', 'admin@gmail.com', '$2a$10$medjTjDZUjmYCiIiIudiYugjbT90A7pMMVZFYx/bhbUS4GOS/KQ4e', true);

INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (1, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (2, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (3, 1);
INSERT INTO tb_pivot_user_group_user(user_id, user_group_id) VALUES (3, 2);

INSERT INTO tb_bs_profit_balance(net_value, reference_date) VALUES ('10', '2022-10-10');
INSERT INTO tb_bs_profit_balance_sm(net_value, reference_date) VALUES ('10', '2022-10-10');

INSERT INTO tb_bs_spot_balance(cryptocurrency_id, balance_origin_type_id, net_value, units, profit, reference_date) VALUES (1, 1, '10', '1', '5', '2022-10-10');
INSERT INTO tb_bs_spot_balance(cryptocurrency_id, balance_origin_type_id, net_value, units, profit, reference_date) VALUES (2, 1, '10', '1', '5', '2022-10-10');

INSERT INTO tb_bs_wallet(address) VALUES ('business_wallet_address');

INSERT INTO tb_bs (bs_wallet_id, bs_profit_balance_id, bs_profit_balance_sm_id, name) VALUES (1, 1, 1, 'Coinquest');