BEGIN;

CREATE USER application WITH password 'xxx';
CREATE USER flyway WITH password 'xxx';

CREATE SCHEMA data;

GRANT USAGE ON SCHEMA data TO application;

GRANT USAGE, CREATE ON SCHEMA data TO flyway;

ALTER DEFAULT privileges IN SCHEMA data GRANT 
	ALL
ON TABLES TO flyway;

ALTER DEFAULT privileges IN SCHEMA data GRANT 
	ALL
ON SEQUENCES TO flyway;

COMMIT;
