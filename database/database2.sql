CREATE TABLE rooms (
    room_no INT PRIMARY KEY,
    capacity INT NOT NULL,
    allocated INT DEFAULT 0
);