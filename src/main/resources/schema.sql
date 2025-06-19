CREATE TABLE IF NOT EXISTS advance_data (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    `date` DATE,
    advance_type VARCHAR(100),
    vechicle_type VARCHAR(100),
    route_name VARCHAR(100),
    status VARCHAR(50),
    vendor VARCHAR(100),
    amount DOUBLE,
    action VARCHAR(100),
    user_id_creation BIGINT NOT NULL,
    user_id_updation BIGINT NOT NULL,
    creation_date DATETIME,
    updation_date DATETIME,
    UNIQUE KEY unique_advance (
        `date`, advance_type, vechicle_type, route_name, status, vendor
    )
);
