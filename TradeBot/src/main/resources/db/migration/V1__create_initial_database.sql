--
-- Table structure for table "config"
--
DROP TABLE IF EXISTS "tb_config";

CREATE TABLE "tb_config" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "name" varchar(255) NOT NULL,
  "value" varchar(255) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
);

--
-- Table structure for table "admin"
--
DROP TABLE IF EXISTS "tb_admin";

CREATE TABLE "tb_admin" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "name" varchar(255) NOT NULL,
  "email" varchar(255) NOT NULL,
  "password" varchar(255),
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id"),
  UNIQUE ("email")
);

CREATE UNIQUE INDEX "id_Admin_UNIQUE" ON "tb_admin" ("id" ASC);

--
-- Table structure for table "admin group"
--
DROP TABLE IF EXISTS "tb_admin_group";

CREATE TABLE "tb_admin_group" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "name" varchar(255) NOT NULL,
  "description" varchar(255) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX "id_admin_group_UNIQUE" ON "tb_admin_group" ("id" ASC);

--
-- Table structure for table "admin route"
--
DROP TABLE IF EXISTS "tb_admin_route";

CREATE TABLE "tb_admin_route" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "route" varchar(255) NOT NULL,
  "method" varchar(45) NOT NULL,
  "description" text,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX "id_tb_admin_route_UNIQUE" ON "tb_admin_route" ("id" ASC);

--
-- Table structure for table "user"
--
DROP TABLE IF EXISTS "tb_user";

CREATE TABLE "tb_user" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "name" varchar(255) NOT NULL,
  "email" varchar(255) NOT NULL,
  "password" varchar(255) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id"),
  UNIQUE ("email")
  );
  
CREATE UNIQUE INDEX "id_tb_user_UNIQUE" ON "tb_user" ("id" ASC);
  
--
-- Table structure for table "user group"
--
DROP TABLE IF EXISTS "tb_user_group";

CREATE TABLE "tb_user_group" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "name" varchar(255) NOT NULL,
  "description" varchar(255) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
  ); 

CREATE UNIQUE INDEX "id_tb_user_group_UNIQUE" ON tb_user_group ("id" ASC);
  
--
-- Table structure for table "user route"
--
DROP TABLE IF EXISTS "tb_user_route";

CREATE TABLE "tb_user_route" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "route" varchar(255) NOT NULL,
  "method" varchar(255) NOT NULL,
  "description" varchar(255) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
  );
  
CREATE UNIQUE INDEX "id_tb_user_route_UNIQUE" ON "tb_user_route" ("id" ASC);  

--
-- Table structure for table "cash balance type"
--
DROP TABLE IF EXISTS "tb_cash_balance_type";

CREATE TABLE "tb_cash_balance_type" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "type" varchar(45) NOT NULL,
  "description" varchar(45) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX "id_tb_cash_balance_type_UNIQUE" ON "tb_cash_balance_type" ("id" ASC);

--
-- Table structure for table "cash balance"
--
DROP TABLE IF EXISTS "tb_cash_balance";

CREATE TABLE "tb_cash_balance" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "user_id" INT8 NOT NULL,
  "cash_balance_type_id" INT8 NOT NULL,
  "value" DECIMAL NOT NULL,
  "simulated" BOOLEAN NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_tb_cash_balance_tb_user" FOREIGN KEY ("user_id") REFERENCES "tb_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_tb_cash_balance_tb_cash_balance_type" FOREIGN KEY ("cash_balance_type_id") REFERENCES "tb_cash_balance_type" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE UNIQUE INDEX "id_tb_cash_balance_UNIQUE" ON "tb_cash_balance" ("id" ASC);
CREATE INDEX "fk_tb_cash_balance_tb_user_idx" ON "tb_cash_balance" ("user_id" ASC);
CREATE INDEX "fk_tb_cash_balance_tb_cash_balance_type_idx" ON "tb_cash_balance" ("cash_balance_type_id" ASC);

--
-- Table structure for table "cryptocurrency"
--
DROP TABLE IF EXISTS "tb_cryptocurrency";

CREATE TABLE "tb_cryptocurrency" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "symbol" varchar(255) NOT NULL,
  "name" varchar(255) NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX "id_tb_cryptocurrency_UNIQUE" ON "tb_cryptocurrency" ("id" ASC);

--
-- Table structure for table "tb_document_type"
--
DROP TABLE IF EXISTS "tb_document_type";
CREATE TABLE "tb_document_type" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "type" varchar(255) NOT NULL,
  "description" varchar(255) NOT NULL,
  "expiration_time" INT NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id")
);
CREATE UNIQUE INDEX "id_tb_document_type_UNIQUE" ON "tb_document_type" ("id" ASC);

--
-- Table structure for table "document"
--
DROP TABLE IF EXISTS "tb_document";

CREATE TABLE "tb_document" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "user_id" INT8 NOT NULL,
  "document_type_id" INT8 NOT NULL,
  "number" varchar(255) NOT NULL,
  "issuing_entity" varchar(255) NOT NULL,
  "issue_date" date NOT NULL, 
  "due_date" date NOT NULL,
  "link" varchar(255) NOT NULL,
  "main" BOOLEAN NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_tb_document_tb_user" FOREIGN KEY ("user_id") REFERENCES "tb_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_tb_document_tb_document_type" FOREIGN KEY ("document_type_id") REFERENCES "tb_document_type" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
  );
  
CREATE UNIQUE INDEX "id_tb_document_UNIQUE" ON "tb_document" ("id" ASC);
CREATE INDEX "fk_tb_document_tb_user_idx" ON "tb_document" ("user_id" ASC);
CREATE INDEX "fk_tb_document_tb_document_type" ON "tb_document" ("document_type_id" ASC); 
  
--
-- Table structure for table "investment"
--
DROP TABLE IF EXISTS "tb_investment";

CREATE TABLE "tb_investment" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "user_id" INT8 NOT NULL,
  "cryptocurrency_id" INT8 NOT NULL,
  "initial_value" DECIMAL NOT NULL,
  "unit_value" DECIMAL NOT NULL,
  "units" DECIMAL NOT NULL,
  "active" BOOLEAN NOT NULL,
  "simulated" BOOLEAN NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_tb_investment_tb_user" FOREIGN KEY ("user_id") REFERENCES "tb_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_tb_investment_tb_cryptocurrency" FOREIGN KEY ("cryptocurrency_id") REFERENCES "tb_cryptocurrency" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
  );
  
CREATE UNIQUE INDEX "id_tb_investment_UNIQUE" ON "tb_investment" ("id" ASC);
CREATE INDEX "fk_tb_investment_tb_user_idx" ON "tb_investment" ("user_id" ASC);
CREATE INDEX "fk_tb_investment_tb_cryptocurrency_idx" ON "tb_investment" (cryptocurrency_id ASC);   
  
--
-- Table structure for table "investment balance"
--
DROP TABLE IF EXISTS "tb_investment_balance";

CREATE TABLE "tb_investment_balance" (
  "id" INT8 GENERATED BY DEFAULT AS IDENTITY,
  "investment_id" INT8 NOT NULL,
  "net_value" DECIMAL NOT NULL,
  "units" DECIMAL NOT NULL,
  "average_unit_value" DECIMAL,
  "profit" DECIMAL,
  "profitable" BOOLEAN,
  "simulated" BOOLEAN NOT NULL,
  "reference_date" date NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "updated_at" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "deleted_at" TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_tb_investment_balance_tb_investment" FOREIGN KEY ("investment_id") REFERENCES "tb_investment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
  );
  
CREATE UNIQUE INDEX "id_tb_investment_balance_UNIQUE" ON "tb_investment_balance" ("id" ASC);
CREATE INDEX "fk_tb_investment_balance_tb_invesment_idx" ON "tb_investment_balance" ("investment_id" ASC);  
