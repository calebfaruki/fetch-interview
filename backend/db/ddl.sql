CREATE TABLE treat (
    id BIGINT NOT NULL,
    name TEXT NOT NULL,
    image_url TEXT,
    price DOUBLE PRECISION NOT NULL,
    bulk_pricing jsonb,

    PRIMARY KEY (id)
);

CREATE TABLE sale (
    id BIGINT NOT NULL,
    treat_id BIGINT NOT NULL,
    count INT NOT NULL,
    price DOUBLE PRECISION,
    time TEXT,
    repeat BOOLEAN,

    PRIMARY KEY (id),
    FOREIGN KEY (treat_id) REFERENCES treat(id)
    ON DELETE RESTRICT
);
