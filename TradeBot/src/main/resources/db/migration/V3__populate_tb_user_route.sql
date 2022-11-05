INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/*', 'GET', 'Fetch cash balance by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/admin/all', 'GET', 'Fetch all cash balances');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/admin/insert', 'POST', 'Insert new cash balances');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/admin/delete/*', 'DELETE', 'Delete cash balance by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalance/admin/patch/*', 'PATCH', 'Patch cash balance by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/all', 'GET', 'Fetch all cryptocurrencies');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/*', 'GET', 'Fetch cryptocurrency by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/admin/insert', 'POST', 'Insert a new cryptocurrency');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/admin/delete/*', 'DELETE', 'Delete cryptocurrency by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/admin/patch/*', 'PATCH', 'Patch cryptocurrency by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/admin/all', 'GET', 'Fetch all documents');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/user/*', 'GET', 'Fetch all documents by user ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/admin/*', 'GET', 'Fetch document by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/insert', 'POST', 'Insert new document for the user');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/delete/*', 'DELETE', 'Delete document by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documents/patch/*', 'PATCH', 'Patch a document by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/all', 'GET', 'Fetch all document types');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/*', 'GET', 'Fetch document type by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/admin/insert', 'POST', 'Insert new document type');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/admin/delete/*', 'DELETE', 'Delete document type by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/admin/patch/*', 'PATCH', 'Patch document type by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/admin/all', 'GET', 'Fetch all investments');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/user/*', 'GET', 'Fetch all investments by user ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/*', 'GET', 'Fetch investment by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/insert', 'POST', 'Insert new investment');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/admin/delete/*', 'DELETE', 'Delete investment by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investments/admin/patch/*', 'PATCH', 'Patch investment by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/admin/all', 'GET', 'Fetch all investment balances');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/user/*', 'GET', 'Fetch all investment balances by user ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/*', 'GET', 'Fetch investment balance by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/admin/insert', 'POST', 'Insert new investment balance');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/admin/delete/*', 'DELETE', 'Delete investment balance by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investmentbalances/admin/patch/*', 'PATCH', 'Patch investment balance by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/all', 'GET', 'Fetch all users');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/*', 'GET', 'Fetch user by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/insert', 'POST', 'Insert new user');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/delete/*', 'DELETE', 'Delete user by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/users/admin/patch/*', 'PATCH', 'Patch user by ID');

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalancetype/*', 'GET', 'Fetch cash balance type by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalancetype/all', 'GET', 'Fetch all cash balance types');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalancetype/admin/insert', 'POST', 'Insert new cash balance type');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalancetype/admin/delete/*', 'DELETE', 'Delete cash balance type by ID');
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cashbalancetype/admin/patch/*', 'PATCH', 'Patch cash balance type by ID');


INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 1);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 6);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 7);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 12);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 13);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 14);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 15);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 16);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 17);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 18);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 23);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 24);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 25);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 29);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 30);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 30);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 35);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 39);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 40);

INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 2);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 3);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 4);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 5);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 8);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 9);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 10);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 11);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 19);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 20);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 21);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 22);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 26);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 27);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 28);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 31);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 32);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 33);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 34);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 36);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 37);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 38);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 41);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 42);
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 43);
