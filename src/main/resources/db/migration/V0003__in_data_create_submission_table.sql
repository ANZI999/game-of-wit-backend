CREATE TABLE data.submission (
	id        		BIGSERIAL PRIMARY KEY,
	user_id     	BIGINT NOT NULL,
	challenge_id 	BIGINT NOT NULL,
	structure		BYTEA NOT NULL,
	created     	TIMESTAMP
);