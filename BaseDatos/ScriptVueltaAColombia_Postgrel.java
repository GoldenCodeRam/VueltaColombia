-- Crear la base de datos si no existe
CREATE DATABASE vueltaaColombia;

-- Crear secuencias para los IDs autoincrementables
CREATE SEQUENCE edition_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE sponsor_nit_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE edition_team_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE stage_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE team_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE athlete_team_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE athlete_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;
CREATE SEQUENCE podium_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100000 NO CYCLE;

-- Crear tabla Edition
CREATE TABLE Edition (
    id INT PRIMARY KEY DEFAULT nextval('edition_id_seq'),
    year INT,
    start_date DATE,
    end_date DATE
);

-- Crear tabla Sponsor
CREATE TABLE Sponsor (
    NIT INT PRIMARY KEY DEFAULT nextval('sponsor_nit_seq'),
    name VARCHAR(255)
);

-- Crear tabla Team
CREATE TABLE Team (
    id INT PRIMARY KEY DEFAULT nextval('team_id_seq'),
    name VARCHAR(255),
    foundation_date DATE
);

-- Crear tabla Edition_Team
CREATE TABLE Edition_Team (
    id INT PRIMARY KEY DEFAULT nextval('edition_team_id_seq'),
    edition_id INT REFERENCES Edition(id),
    team_id INT REFERENCES Team(id),
    sponsor_id INT REFERENCES Sponsor(NIT)
);

-- Crear tabla Athlete
CREATE TABLE Athlete (
    id INT PRIMARY KEY DEFAULT nextval('athlete_id_seq'),
    name VARCHAR(255),
    country VARCHAR(255),
    birth_date DATE
);

-- Crear tabla Athlete_Team
CREATE TABLE Athlete_Team (
    edition_team_id INT REFERENCES Edition_Team(id),
    athlete_id INT REFERENCES Athlete(id),
    PRIMARY KEY (edition_team_id, athlete_id)
);

-- Crear tabla Stage
CREATE TABLE Stage (
    id INT PRIMARY KEY DEFAULT nextval('stage_id_seq'),
    edition_id INT REFERENCES Edition(id),
    origin VARCHAR(255),
    destination VARCHAR(255),
    length DECIMAL,
    stage_type VARCHAR(255)
);

-- Crear tabla Podium
CREATE TABLE Podium (
    stage_id INT REFERENCES Stage(id),
    athlete_id INT REFERENCES Athlete(id),
    position INT,
    time TIME,
    PRIMARY KEY (stage_id, athlete_id)
);