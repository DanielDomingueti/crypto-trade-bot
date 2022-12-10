INSERT INTO "tb_config"("name", "value") VALUES ('TOKEN_SECRET', 'test-token-signature');
INSERT INTO "tb_config"("name", "value") VALUES ('SIGN_IN_USER_URL', '/user/login');
INSERT INTO "tb_config"("name", "value") VALUES ('HEADER_STRING', 'Authorization');
INSERT INTO "tb_config"("name", "value") VALUES ('TOKEN_TYPE', 'Bearer ');
INSERT INTO "tb_config"("name", "value") VALUES ('TOKEN_EXPIRATION_TIME', '86400000');
INSERT INTO "tb_config"("name", "value") VALUES ('TOKEN_ADMIN_EXPIRATION_TIME', '86400000');

INSERT INTO "tb_user_type" ("type", "description") VALUES ('natural_person', 'Natural person');
INSERT INTO "tb_user_type" ("type", "description") VALUES ('legal_person', 'Legal person');

INSERT INTO "tb_user_group"("name", "description") VALUES ('regular_client', 'REGULAR CLIENT');
INSERT INTO "tb_user_group"("name", "description") VALUES ('admin', 'ADMIN');

INSERT INTO "tb_document_type" ("type", "description") VALUES ('cpf', 'CPF');
INSERT INTO "tb_document_type" ("type", "description") VALUES ('rg', 'RG');
INSERT INTO "tb_document_type" ("type", "description") VALUES ('cnpj', 'CNPJ');

INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('aport', 'USDT transfer from user to business [spot balance]');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('withdraw', 'USDT withdraw from business to user [spot balance]');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('swap_entry', 'Income from swap transaction');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('swap_exit', 'Exit from swap transaction');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('from_future', 'Aport from future balance to spot balance');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('to_future', 'Aport to future balance from spot balance');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('long_return', 'Future balance after long position output');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('short_return', 'Future balance after short position output');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('from_spot', 'Aport from spot balance to future balance');
INSERT INTO "tb_balance_origin_type" ("type", "description") VALUES ('to_spot', 'Aport to spot balance from future balance');

INSERT INTO "tb_open_position_type" ("type", "description") VALUES ('long', 'LONG');
INSERT INTO "tb_open_position_type" ("type", "description") VALUES ('short', 'SHORT');


INSERT INTO "tb_income_type" ("type", "description") VALUES ('coupon', 'After closing a position the user gets his proportional profit through his digital wallet');
INSERT INTO "tb_income_type" ("type", "description") VALUES ('reinvest', 'After closing a position the users proportional profit goes into his investment again');

INSERT INTO "tb_pair_symbol_type" ("type", "description") VALUES ('btcusdt', 'BTCUSDT');
INSERT INTO "tb_pair_symbol_type" ("type", "description") VALUES ('ethusdt', 'ETHUSDT');
INSERT INTO "tb_pair_symbol_type" ("type", "description") VALUES ('maticusdt', 'MATICUSDT');
INSERT INTO "tb_pair_symbol_type" ("type", "description") VALUES ('dotusdt', 'DOTUSDT');

INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('BTC', 'Bitcoin');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('ETH', 'Ethereum');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('USDT', 'Tether');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('BNB', 'BNB');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('USDC', 'USD Coin');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('BUSD', 'Binance USD');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('XRP', 'XRP');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('ADA', 'Cardano');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('DOGE', 'Dogecoin');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('MATIC', 'Polygon');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('DOT', 'Polkadot');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('DAI', 'Dai');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('SOL', 'Solana');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('SHIB', 'Shiba Inu');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('TRX', 'TRON');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('LTC', 'Litecoin');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('UNI', 'Uniswap');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('WBTC', 'Wrapped Bitcoin');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('AVAX', 'Avalanche');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('LINK', 'Chainlink');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('ETC', 'Ethereum Classic');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('XLM', 'Stellar');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('ALGO', 'Algorand');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('VET', 'VeChain');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('LUNC', 'Terra Classic');
INSERT INTO "tb_cryptocurrency" ("symbol", "name") VALUES ('AAVE', 'Aave');
