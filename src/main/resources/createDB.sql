BEGIN;

CREATE USER application_account WITH password 'password';

CREATE SCHEMA data;

GRANT USAGE ON SCHEMA data TO application_account;
ALTER DEFAULT privileges IN SCHEMA data GRANT 
	SELECT, 
	UPDATE, 
	INSERT, 
	DELETE 
ON TABLES TO application_account;
ALTER DEFAULT privileges IN SCHEMA data GRANT 
	SELECT, 
	UPDATE, 
	USAGE 
ON SEQUENCES TO application_account;

COMMIT;
