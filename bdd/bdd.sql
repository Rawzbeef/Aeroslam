CREATE DATABASE AeroSlam;

USE AeroSlam;

CREATE TABLE Destination (
	codeD int(4) auto_increment,
	villeD varchar(30),
	paysD varchar(30),
	PRIMARY KEY (codeD)
);

CREATE TABLE Avion (
	codeA int(4) auto_increment,
	nomA varchar(30),
	nbPlace int(4),
	PRIMARY KEY (codeA)
);

CREATE TABLE VolCommercial (
	codeVCommercial int(4) auto_increment,
	dateVCommercial date,
	codeA int(4),
	codeD int(4),
	FOREIGN KEY (codeA) REFERENCES Avion(codeA),
	FOREIGN KEY (codeD) REFERENCES Destination(codeD),
	PRIMARY KEY (codeVCommercial)
);

CREATE TABLE VolCourrier (
	codeVCourrier int(4) auto_increment,
	dateVCourrier date,
	codeA int(4),
	codeD int(4),
	FOREIGN KEY (codeA) REFERENCES Avion(codeA),
	FOREIGN KEY (codeD) REFERENCES Destination(codeD),
	PRIMARY KEY (codeVCourrier)
);

CREATE TABLE Passager (
	codeP int(4) auto_increment,
	nomP varchar(30),
	prenomP varchar(30),
	rueP varchar(60),
	numRueP varchar(10),
	cpP int(5),
	villeP varchar(30),
	PRIMARY KEY (codeP)
);

CREATE TABLE Enregistrer (
	codeP int(4),
	codeV int(4),
	FOREIGN KEY (codeP) REFERENCES Passager(codeP),
	FOREIGN KEY (codeV) REFERENCES VolCourrier(codeVCourrier),
	PRIMARY KEY (codeP, codeV)
);

CREATE TABLE Administrateur (
	codeAdmin int(4) auto_increment,
	identifiantAdmin varchar(30),
	mdpAdmin varchar(30),
	PRIMARY KEY (codeAdmin)
);

INSERT INTO Destination (paysD, villeD)
VALUES("France", "Paris"),
("France", "Lyon")

INSERT INTO Administrateur (identifiantAdmin, mdpAdmin) 
VALUE("admin", "admin");