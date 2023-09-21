-- Crear tabla Edition
CREATE TABLE IF NOT EXISTS Edition (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    `year` 		INT,
    start_date 	DATE,
    end_date 	DATE
);

-- Crear tabla Sponsor
CREATE TABLE Sponsor (
    NIT  INT PRIMARY KEY NOT NULL,
    name VARCHAR(255)
);

-- Crear tabla Team
CREATE TABLE Team (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    foundation_date DATE
);

-- Crear tabla Edition_Team
CREATE TABLE Edition_Team (
    id INT PRIMARY KEY AUTO_INCREMENT,
    edition_id INT NOT NULL,
    team_id INT NOT NULL,
    sponsor_id INT NOT NULL,
    FOREIGN KEY (edition_id) REFERENCES Edition(id),
    FOREIGN KEY (team_id) REFERENCES Team(id),
    FOREIGN KEY (sponsor_id) REFERENCES Sponsor(NIT)
);

-- Crear tabla Athlete
CREATE TABLE Athlete (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    country VARCHAR(255),
    birth_date DATE
);

-- Crear tabla Athlete_Team
CREATE TABLE IF NOT EXISTS Athlete_Team (
    edition_team_id INT,
    athlete_id INT,
    FOREIGN KEY (edition_team_id) REFERENCES Edition_team(id),
    FOREIGN KEY (athlete_id) REFERENCES Athlete(id),
    PRIMARY KEY (edition_team_id, athlete_id)
);

-- Crear tabla Stage
CREATE TABLE Stage (
    id INT PRIMARY KEY AUTO_INCREMENT,
    edition_id INT,
    origin VARCHAR(255),
    destination VARCHAR(255),
    `length` DECIMAL,
    stage_type VARCHAR(255),
    FOREIGN KEY (edition_id) REFERENCES Edition(id)
);

-- Crear tabla Podium
CREATE TABLE Podium (
    stage_id INT,
    athlete_id INT,
    `position` INT,
    `time` TIME,
    FOREIGN KEY (stage_id) REFERENCES Stage(id),
    FOREIGN KEY (athlete_id) REFERENCES Athlete(id),
    PRIMARY KEY (stage_id, athlete_id)
);