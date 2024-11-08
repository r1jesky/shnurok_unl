CREATE SCHEMA IF NOT EXISTS labs;

CREATE TABLE labs.functions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    c_function_name VARCHAR(255),
    c_count INT CHECK (c_count >= 2),
    c_x_from DOUBLE,
    c_x_to DOUBLE
);

CREATE TABLE labs.point (
    id INT AUTO_INCREMENT PRIMARY KEY,
    function_id INT,
    c_x_val DOUBLE,
    c_y_val DOUBLE,
    FOREIGN KEY (function_id) REFERENCES labs.functions(id) ON DELETE CASCADE
);