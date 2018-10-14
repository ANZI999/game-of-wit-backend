BEGIN;

CREATE USER application_account WITH password 'password';

CREATE SCHEMA data;

CREATE TABLE data.challenge (
    id        	BIGSERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    name       	VARCHAR(255) NOT NULL,
    created     TIMESTAMP
);

GRANT USAGE ON SCHEMA data TO application_account;
GRANT SELECT, UPDATE, INSERT, DELETE ON ALL TABLES IN SCHEMA data TO application_account;
GRANT SELECT, UPDATE, USAGE ON ALL SEQUENCES IN SCHEMA data TO application_account;

COMMIT;
