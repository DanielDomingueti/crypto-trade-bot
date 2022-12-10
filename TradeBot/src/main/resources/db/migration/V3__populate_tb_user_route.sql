--fuutre balance
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/bsFutureBalance/sm', 'GET', 'Fetch latest business future balance simulation');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 1);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/bsFutureBalance', 'GET', 'Fetch latest business future balance');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 2);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/futureBalance/usdt/user/*', 'GET', 'Fetch latest user future balance');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 3);


--spot balance
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/bsSpotBalance/cryptocurrency/*', 'GET', 'Fetch latest business spot balance by Crypto ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 4);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/bsSpotBalance', 'GET', 'Fetch total latest business spot balance');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 5);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/spotBalance/cryptocurrency/*/user/*', 'GET', 'Fetch latest user spot balance by Crypto ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 6);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/spotBalance/user/*', 'GET', 'Fetch latest user spot balance');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 7);


--business wallet
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/bs/wallet', 'GET', 'Fetch business wallet');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 8);


--business profit
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/bs/profit', 'GET', 'Fetch business profit');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 9);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/bs/profit/sm', 'GET', 'Fetch business profit simulation');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 10);


--cryptocurrency
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/cryptocurrencies/all', 'GET', 'Fetch all cryptocurrencies');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 11);


--document
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/documenttypes/all', 'GET', 'Fetch all document types');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 12);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/document/all', 'GET', 'Fetch all cryptocurrencies');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 13);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/document/user/*', 'GET', 'Fetch documents by User ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 14);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/document/*', 'GET', 'Fetch document by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 15);


--investment
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/investment/all', 'GET', 'Fetch all investments');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 16);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investment/user/*', 'GET', 'Fetch all investments by user ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 17);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investment/*', 'GET', 'Fetch investment by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 18);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/investment/insert', 'POST', 'Insert an investment');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 19);


--trade history
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/tradehistory/balance', 'GET', 'Fetch trade history balance between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 20);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/tradehistory/profit', 'GET', 'Fetch trade history profit between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 21);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/tradehistory/loss', 'GET', 'Fetch trade history loss between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 22);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/tradehistory/sm/balance', 'GET', 'Fetch trade history balance simulation between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 23);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/tradehistory/sm/profit', 'GET', 'Fetch trade history profit simulation between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 24);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/tradehistory/sm/loss', 'GET', 'Fetch trade history loss simulation between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 25);


--users
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/users/all', 'GET', 'Fetch all users');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 26);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/user/*', 'GET', 'Fetch user by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 27);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/user/wallet/all', 'GET', 'Fetch all user wallets');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 28);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/user/wallet/*', 'GET', 'Fetch user wallet by user ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 29);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/user/insert', 'POST', 'Insert new user');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 30);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/user/delete/*', 'DELETE', 'Delete user by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 31);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/user/patch/*', 'PATCH', 'Patch user by ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 32);


--position types
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/balanceorigintype/all', 'GET', 'Fetch balance origin types');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 33);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/openpositiontype/all', 'GET', 'Fetch open position types');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 34);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/pairsymboltype/all', 'GET', 'Fetch pair symbol types');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (1, 35);


--position 
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/openposition/all', 'GET', 'Fetch all open positions');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 36);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/openposition/pair/*', 'GET', 'Fetch open position by pair symbol ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 37);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/openposition/roe', 'GET', 'Fetch summarized open position ROEs');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 38);


--position simulation
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/openposition/sm/all', 'GET', 'Fetch all open position simulations');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 39);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/openposition/sm/pair/*', 'GET', 'Fetch open position simulation by pair symbol ID');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 40);

INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/openposition/sm/roe', 'GET', 'Fetch summarized open position simulation ROEs');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 41);


--aport history
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/aporthistory', 'GET', 'Fetch aport history between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 42);


--withdraw history
INSERT INTO "tb_user_route" ("route", "method", "description") VALUES ('/admin/withdrawhistory', 'GET', 'Fetch withdraw history between dates');
INSERT INTO "tb_pivot_user_group_user_route" ("user_group_id", "user_route_id") VALUES (2, 43);
