CREATE TABLE data.challenge (
    id        	BIGSERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    name       	VARCHAR(255) NOT NULL,
    structure	BYTEA NOT NULL,
    created     TIMESTAMP
);