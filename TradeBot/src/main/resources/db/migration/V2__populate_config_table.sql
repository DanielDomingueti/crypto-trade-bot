INSERT INTO "tb_config" ("name", "value") VALUES ('TOKEN_SECRET', 'SecretKeyToGenJWTs');
INSERT INTO "tb_config" ("name", "value") VALUES ('TOKEN_SECRET_PROD', 'FMIProdJWTSecretKey');
INSERT INTO "tb_config" ("name", "value") VALUES ('HEADER_STRING', 'Authorization');
INSERT INTO "tb_config" ("name", "value") VALUES ('TOKEN_TYPE', 'Bearer ');
INSERT INTO "tb_config" ("name", "value") VALUES ('TOKEN_EXPIRATION_TIME', '86400000');
INSERT INTO "tb_config" ("name", "value") VALUES ('TOKEN_ADMIN_EXPIRATION_TIME', '86400000');
INSERT INTO "tb_config" ("name", "value") VALUES ('SIGN_IN_ADMIN_URL', '/admin/login');
INSERT INTO "tb_config" ("name", "value") VALUES ('SIGN_IN_USER_URL', '/user/login');

USER_FORGOT_PASSWORD_URL
USER_RESET_PASSWORD_URL
ADMIN_FORGOT_PASSWORD_URL
ADMIN_RESET_PASSWORD_URL