BEGIN;

CREATE TABLE data.challenge (
    id        	BIGSERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    name       	VARCHAR(255) NOT NULL,
    structure	BYTEA NOT NULL,
    created     TIMESTAMP
);

CREATE TABLE data.submission (
	id        		BIGSERIAL PRIMARY KEY,
	user_id     	BIGINT NOT NULL,
	challenge_id 	BIGINT NOT NULL,
	structure		BYTEA NOT NULL,
	created     	TIMESTAMP
);

COMMIT;
