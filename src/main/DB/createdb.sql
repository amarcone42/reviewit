/*************************************************

	Creazione database reviewit e tabelle
	
	Progetto d'esame - corso basi di dati 2023/24
	
	Realizzato da:
	Antonio Marcone
	Ersilio Petretta
	
*************************************************/

CREATE SCHEMA reviewit;
USE reviewit;
 
CREATE TABLE reviewit.profilo (
  	username 	VARCHAR(20) NOT NULL PRIMARY KEY,
  	email 		VARCHAR(45) NOT NULL,
  	password 	VARCHAR(45) NOT NULL,
  	tipo 		BOOL NOT NULL,
  	grado 		SMALLINT NOT NULL,
  	immagine 	VARCHAR(100) NOT NULL,
  	nome 		VARCHAR(20) NULL,
  	cognome 	VARCHAR(20) NULL,
  	biografia 	VARCHAR(200) NULL,
  	abilitante 	VARCHAR(20) NULL,
  	CONSTRAINT credenziali UNIQUE (email,password),
  	FOREIGN KEY (abilitante)
  		REFERENCES reviewit.profilo (username)
  		ON DELETE NO ACTION
  		ON UPDATE NO ACTION
);

CREATE TABLE reviewit.notizia (
	profiloId 	VARCHAR(20) NOT NULL,
	data 		DATE NOT NULL,
	ora			TIME NOT NULL,
	titolo		VARCHAR(100) NOT NULL,
	anteprima	VARCHAR(100) NOT NULL,
	contenuto	VARCHAR(5000) NOT NULL,
	CONSTRAINT profilo
		FOREIGN KEY (profiloId)
		REFERENCES reviewit.profilo (username)
		ON DELETE RESTRICT
  		ON UPDATE CASCADE,
  	PRIMARY KEY (profiloId, data, ora)
);

CREATE TABLE reviewit.seguire (
	profiloSeguente		VARCHAR(20) NOT NULL,
	profiloSeguito		VARCHAR(20) NOT NULL,
	CONSTRAINT seguente
		FOREIGN KEY (profiloSeguente) 
		REFERENCES reviewit.profilo (username)
		ON DELETE CASCADE 
		ON UPDATE CASCADE, 
	CONSTRAINT seguito
		FOREIGN KEY (profiloSeguito) 
		REFERENCES reviewit.profilo (username)
		ON DELETE CASCADE 
		ON UPDATE CASCADE,
	PRIMARY KEY (profiloSeguente, profiloSeguito)
);

CREATE TABLE reviewit.opera (
	id	INT auto_increment NOT NULL PRIMARY KEY,
	tipo SMALLINT NOT NULL,
    durata TIME,
    titolo VARCHAR(100) NOT NULL,
    descrizione VARCHAR(200) NOT NULL,
    locandina VARCHAR(100) NOT NULL,
    dataDiUscita DATE NOT NULL,
    classificazione VARCHAR(20) NOT NULL,
    votoMedio NUMERIC(2,1) NOT NULL CHECK (votoMedio >= 0.0 AND votoMedio <= 5.0) default 0,
    numRecensioni MEDIUMINT NOT NULL default 0
);

CREATE TABLE reviewit.genere (
	id INT auto_increment NOT NULL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL
);

CREATE TABLE reviewit.appartenenza (
	operaId INT NOT NULL,
    genereId INT NOT NULL,
    CONSTRAINT definita
		FOREIGN KEY(operaId)
		REFERENCES reviewit.opera (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT definisce
		FOREIGN KEY(genereId)
        REFERENCES reviewit.genere (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	PRIMARY KEY(operaId, genereId)
);
    
CREATE TABLE reviewit.recensione (
	profiloId VARCHAR(20) NOT NULL,
	operaId INT NOT NULL,
    data DATE NOT NULL,
    voto NUMERIC(2,1) CHECK (voto >= 0.5 AND voto <= 5.0),
    descrizione VARCHAR(500),
    preferito BOOL,
    spoiler BOOL,
    CONSTRAINT autore
		FOREIGN KEY (profiloId) 
		REFERENCES reviewit.profilo (username)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	CONSTRAINT valutazione
		FOREIGN KEY (operaId) 
		REFERENCES reviewit.opera (id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	PRIMARY KEY (profiloId, operaId)
);

CREATE TABLE reviewit.lista (
	id INT auto_increment NOT NULL PRIMARY KEY,
    tipo SMALLINT NOT NULL,
    titolo VARCHAR(50) NOT NULL,
    descrizione VARCHAR(200) NOT NULL,
    profiloId VARCHAR(20) NOT NULL,
	CONSTRAINT creatore
		FOREIGN KEY (profiloId) 
		REFERENCES reviewit.profilo (username)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE reviewit.collezione (
	listaId INT NOT NULL,
    operaId INT NOT NULL,
	CONSTRAINT collezionato
		FOREIGN KEY (operaId) 
		REFERENCES reviewit.opera (id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	CONSTRAINT collezionante
		FOREIGN KEY (listaId) 
		REFERENCES reviewit.lista (id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	PRIMARY KEY (listaId, operaId)
);

CREATE TABLE reviewit.classificazione (
	listaId INT NOT NULL,
    operaId INT NOT NULL,
    posizione SMALLINT NOT NULL,
	CONSTRAINT classificato
		FOREIGN KEY (operaId) 
		REFERENCES reviewit.opera (id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	CONSTRAINT classificante
		FOREIGN KEY (listaId) 
		REFERENCES reviewit.lista (id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	PRIMARY KEY (listaId, operaId)
);

CREATE TABLE reviewit.serie (
	operaId INT NOT NULL PRIMARY KEY,
    stato BOOL NOT NULL,
	CONSTRAINT rappresentazione
    		FOREIGN KEY (operaId)
		REFERENCES reviewit.opera (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE reviewit.stagione (
	serieId INT NOT NULL,
    numero SMALLINT NOT NULL,
    titolo VARCHAR(50) NOT NULL,
	CONSTRAINT composizione
    		FOREIGN KEY (serieId)
		REFERENCES reviewit.serie (operaId)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (serieId, numero)
);

CREATE TABLE reviewit.episodio (
	serieId INT NOT NULL,
    numeroStagione SMALLINT NOT NULL,
    numero SMALLINT NOT NULL,
    titolo VARCHAR(50) NOT NULL,
	dataDiUscita DATE NOT NULL,
    durata TIME NOT NULL,
	anteprima VARCHAR(100) NOT NULL,
	CONSTRAINT formazione
    		FOREIGN KEY (serieId, numeroStagione)
		REFERENCES reviewit.stagione (serieId, numero)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (serieId, numeroStagione, numero)
);

CREATE TABLE reviewit.lavoratore (
	id INT auto_increment NOT NULL PRIMARY KEY,
    nome 		VARCHAR(20) NULL,
  	cognome 	VARCHAR(20) NULL,
	immagine 	VARCHAR(100) NOT NULL,
    dataDiNascita DATE NOT NULL,
    dataDiMorte DATE
);

CREATE TABLE reviewit.attore (
	lavoratoreId INT NOT NULL PRIMARY KEY,
	CONSTRAINT lavora
    		FOREIGN KEY (lavoratoreId)
		REFERENCES reviewit.lavoratore (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE reviewit.membroCrew (
	lavoratoreId INT NOT NULL PRIMARY KEY,
	CONSTRAINT impiego
    		FOREIGN KEY (lavoratoreId)
		REFERENCES reviewit.lavoratore (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE reviewit.recitazione (
	id INT NOT NULL auto_increment,
	operaId INT NOT NULL,
    attoreId INT NOT NULL,
    nomePersonaggio VARCHAR(50) NOT NULL,
	CONSTRAINT recita
    		FOREIGN KEY (operaId)
		REFERENCES reviewit.opera (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	CONSTRAINT interprete
    		FOREIGN KEY (attoreId)
		REFERENCES reviewit.attore (lavoratoreId)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (id, operaId, attoreId)
);

CREATE TABLE reviewit.partecipazione (
	id INT NOT NULL auto_increment,
	operaId INT NOT NULL,
    membroCrewId INT NOT NULL,
    ruolo VARCHAR(20) NOT NULL,
	CONSTRAINT partecipa
    		FOREIGN KEY (operaId)
		REFERENCES reviewit.opera (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	CONSTRAINT staff
    		FOREIGN KEY (membroCrewId)
		REFERENCES reviewit.membroCrew (lavoratoreId)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (id, operaId, membroCrewId)
);