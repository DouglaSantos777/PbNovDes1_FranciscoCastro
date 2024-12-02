-- script para criar SOMENTE as tabelas Person e Gondola

CREATE TABLE Person(
    id        INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name      VARCHAR(100) NOT NULL,
    age       INT          NOT NULL,
    parent_id INT DEFAULT NULL,
    CONSTRAINT fk_parent FOREIGN KEY (parent_id) REFERENCES Person (id) ON DELETE SET NULL
);

CREATE TABLE Gondola(
    id             INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    gondola_number TINYINT UNSIGNED NOT NULL UNIQUE,
    seat1          INT DEFAULT NULL,
    seat2          INT DEFAULT NULL,
    CONSTRAINT fk_seat1 FOREIGN KEY (seat1) REFERENCES Person (id),
    CONSTRAINT fk_seat2 FOREIGN KEY (seat2) REFERENCES Person (id)
);