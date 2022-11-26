INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/*', 'GET', 'Fetch cash balance by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 1);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/admin/all', 'GET', 'Fetch all cash balances');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 2);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalancetype/all', 'GET', 'Fetch all cash balance types');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 3);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/all', 'GET', 'Fetch all cryptocurrencies');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 4);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/all', 'GET', 'Fetch all document types');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 5);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/*', 'GET', 'Fetch document by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 6);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/user/*', 'GET', 'Fetch all documents by user ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 7);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/admin/all', 'GET', 'Fetch all documents');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 8);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/investment/*', 'GET', 'Fetch investment balance by investment ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 9);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/admin/all', 'GET', 'Fetch all latest investment balances');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 10);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/user/*', 'GET', 'Fetch all investment balances by user ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 11);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/admin/insert', 'POST', 'Insert new investment balance');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 12);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/admin/all', 'GET', 'Fetch all investments');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 13);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/user/*', 'GET', 'Fetch all investments by user ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 14);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/*', 'GET', 'Fetch investment by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 15);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/insert/fiat', 'POST', 'Insert new investment through FIAT');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 16);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/insert/crypto', 'POST', 'Insert new investment through CRYPTO');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 17);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/all', 'GET', 'Fetch all users');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 18);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/*', 'GET', 'Fetch user by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 19);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/insert', 'POST', 'Insert new user');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 20);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/delete/*', 'DELETE', 'Delete user by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 21);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/patch/*', 'PATCH', 'Patch user by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 22);
