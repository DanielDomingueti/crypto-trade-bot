INSERT INTO tb_config(name, value) VALUES ('TOKEN_SECRET', 'test-token-signature');
INSERT INTO tb_config(name, value) VALUES ('SIGN_IN_USER_URL', '/user/login');
INSERT INTO tb_config(name, value) VALUES ('HEADER_STRING', 'Authorization');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_TYPE', 'Bearer ');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_EXPIRATION_TIME', '86400000');
INSERT INTO tb_config(name, value) VALUES ('TOKEN_ADMIN_EXPIRATION_TIME', '86400000');

INSERT INTO "tb_user_bank_transaction_type" ("type", "description") VALUES ('usd', 'USD');
INSERT INTO "tb_user_bank_transaction_type" ("type", "description") VALUES ('eur', 'EUR');
INSERT INTO "tb_user_bank_transaction_type" ("type", "description") VALUES ('brl', 'BRL');

INSERT INTO "tb_document_type" ("type", "description") VALUES ('cpf', 'CPF');
INSERT INTO "tb_document_type" ("type", "description") VALUES ('rg', 'RG');
INSERT INTO "tb_document_type" ("type", "description") VALUES ('cnpj', 'CNPJ');

INSERT INTO "tb_bank_type" ("type", "description") VALUES ('INTER', 'Banco Inter');
INSERT INTO "tb_bank_type" ("type", "description") VALUES ('CAIXA', 'Caixa Econômica Federal');

INSERT INTO "tb_investment_operation_type" ("type", "description") VALUES ('NEW_CONTRIBUTION', 'Put money on it');
INSERT INTO "tb_investment_operation_type" ("type", "description") VALUES ('BUY_EXISTING', 'Buy cryptocurrency');
INSERT INTO "tb_investment_operation_type" ("type", "description") VALUES ('SOLD_EXISTING', 'Sell cryptocurrency');
INSERT INTO "tb_investment_operation_type" ("type", "description") VALUES ('SWAP', 'Swap different cryptocurrencies');
INSERT INTO "tb_investment_operation_type" ("type", "description") VALUES ('STEAKING_INCOME', 'Steaking passive income');
INSERT INTO "tb_investment_operation_type" ("type", "description") VALUES ('LIQUIDITY_POOL_INCOME', 'Liquidity pool passive income');

INSERT INTO "tb_user_type" ("type", "description") VALUES ('natural_person', 'Natural person');
INSERT INTO "tb_user_type" ("type", "description") VALUES ('legal_person', 'Legal person');

INSERT INTO tb_user_group(name, description) VALUES ('regular_client', 'REGULAR CLIENT');
INSERT INTO tb_user_group(name, description) VALUES ('admin', 'ADMIN');

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
