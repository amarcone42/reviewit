/*************************************************

	Riempimento tabelle del database reviewit
	
	Progetto d'esame - corso basi di dati 2023/24
	
	Realizzato da:
	Antonio Marcone
	Ersilio Petretta
	
*************************************************/


/*************************************************
	Inserimento parte 1: Opere e dati annessi
*************************************************/

-- Insert nella tabella opera
INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "01:58:00", "The Killer", "Execution is everything", "poster-0000001.png", "2023-01-01", "16+", 3.4);

INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "02:11:00", "Saltburn", "We're all about to lose our minds", "poster-0000002.png", "2023-11-22", "18+", 3.5);

INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "03:01:00", "Oppenheimer", "The world forever changes", "poster-0000003.png", "2023-06-14", "tutti", 4.3);

INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "01:54:00", "Barbie", "She's everything. He's just Ken", "poster-0000004.png", "2023-06-14", "tutti", 3.9);

INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "02:29:00", "2001: A Space Odyssey", "The ultimate trip", "poster-0000005.png", "1968-01-01", "tutti", 4.3);


INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Mr.Robot", "Control is an illusion", "poster-0000006.png", "2015-01-01", "16+", 4.8);

INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Neon Genesis Evangelion", "Ma è Godzilla?!", "poster-0000007.png", "1995-01-01", "16+", 4.8);

INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Scott Pilgrim Takes Off", "Scott Pilgrim incontra la ragazza dei suoi sogni ma qualcosa va storto", "poster-0000008.png", "2023-11-01", "tutti", 4.9);

INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "The Power", "The power that changes everything", "poster-0000009.png", "2023-01-20", "16+", 4.7);

INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Poker Face", "She can see your lies", "poster0000010.png", "2023-01-01", "tutti", 4.7);

INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "The White Lotus", "Relax can cost your life", "poster0000001.png", "2021-01-01", "18+", 4.3);

-- Insert nella tabella serie
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (6, 0);
	
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (7, 0);
	
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (8, 0);
	
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (9, 1);
	
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (10, 1);
	
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (11, 1);
	
	
-- Insert nella tabella stagione
-- Mr.Robot
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (6, 1, "Prima stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (6, 2, "Seconda stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (6, 3, "Terza stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (6, 4, "Quarta stagione");
-- Neon Genesis Evangelion
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (7, 1, "Prima stagione");
-- Scott Pilgrim Takes Off
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (8, 1, "Prima stagione");
-- The Power
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (9, 1, "Prima stagione");
-- Poker Face
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (10, 1, "Prima stagione");
-- The White Lotus
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (11, 1, "Prima stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (11, 2, "Seconda stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (11, 3, "Terza stagione");
	
-- Insert nella tabella episodio
-- Mr.Robot
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 1, 1, "eps1.0_hellofriend.mov", "2015-06-25", "00:50:00", "episode-6-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 1, 2, "eps1.1_ones-and-zer0es.mpeg", "2015-06-25", "00:50:00", "episode-6-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 1, 3, "eps1.2_d3bug.mkv", "2015-06-25", "00:50:00", "episode-6-1-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 1, 4, "eps1.3_da3m0ns.mp4", "2015-06-25", "00:50:00", "episode-6-1-4.png");

INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 2, 1, "eps2.0_unm4sk-pt1.tc", "2016-07-14", "00:50:00", "episode-6-2-1.png");
	INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 2, 2, "eps2.1_unm4sk-pt2.tc", "2015-07-14", "00:50:00", "episode-6-2-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 2, 3, "eps2.2_k3rnel-pan1c.ksd", "2015-07-14", "00:50:00", "episode-6-2-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 2, 4, "eps2.3_init_1.asec", "2015-07-14", "00:50:00", "episode-6-2-4.png");
	
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 3, 1, "eps3.0_power-saver-mode.h", "2017-10-12", "00:50:00", "episode-6-3-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 3, 2, "eps3.1_undo.gz", "2017-10-12", "00:50:00", "episode-6-3-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 3, 3, "eps3.2_legacy.so", "2017-10-12", "00:50:00", "episode-6-3-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 3, 4, "eps3.3_metadata.par2", "2017-10-12", "00:50:00", "episode-6-3-4.png");

INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 1, "401 Unauthorized", "2019-10-07", "00:50:00", "episode-6-4-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 2, "42 Payment Required", "2019-10-07", "00:50:00", "episode-6-4-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 3, "403 Forbidden", "2019-10-07", "00:50:00", "episode-6-4-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 4, "404 Not Found", "2019-10-07", "00:50:00", "episode-6-4-4.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 5, "405 Method Not Allowed", "2019-10-07", "00:50:00", "episode-6-4-5.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 6, "406 Not Acceptable", "2019-10-07", "00:50:00", "episode-6-4-6.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 7, "407 Proxy Authentication Required", "2019-10-07", "00:50:00", "episode-6-4-7.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 8, "408 Request Timeout", "2019-10-07", "00:50:00", "episode-6-4-8.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 9, "409 Conflict", "2019-10-07", "00:50:00", "episode-6-4-9.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 10, "410 Gone", "2019-10-07", "00:50:00", "episode-6-4-10.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 11, "eXit", "2019-10-07", "00:50:00", "episode-6-4-11.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 12, "whoami", "2019-10-07", "00:50:00", "episode-6-4-12.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (6, 4, 13, "Hello, Elliot", "2019-10-07", "00:50:00", "episode-6-4-13.png");

-- Neon Genesis Evangelion
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (7, 1, 1, "Angel Attack", "1995-10-04", "00:25:00", "episode-21-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (7, 1, 2, "The Beast", "1995-10-11", "00:25:00", "episode-21-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (7, 1, 3, "A Transfer", "1995-10-18", "00:25:00", "episode-21-1-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (7, 1, 4, "Hedgehog's Dilemma", "1995-10-25", "00:25:00", "episode-21-1-4.png");	

-- Scott Pilgrim Takes Off
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (8, 1, 1, "Scott Pilgrim's Precious Little Life", "2023-11-17", "00:28:00", "episode-22-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (8, 1, 2, "A League of Their Own", "2023-11-17", "00:28:00", "episode-22-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (8, 1, 3, "Ramona Rents a Video", "2023-11-17", "00:28:00", "episode-22-1-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (8, 1, 4, "Whatever", "2023-11-17", "00:28:00", "episode-22-1-4.png");	
	
-- The Power
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (9, 1, 1, "A Better Future is in Your Hands", "2023-03-31", "00:58:00", "episode-23-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (9, 1, 2, "The World is on Fu*king Fire", "2023-03-31", "00:58:00", "episode-23-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (9, 1, 3, "A New Organ", "2023-03-31", "00:58:00", "episode-23-1-3.png");

-- Poker Face
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (10, 1, 1, "Dead Man's Hand", "2023-01-26", "00:55:00", "episode-24-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (10, 1, 2, "The Night Shift", "2023-01-26", "00:55:00", "episode-24-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (10, 1, 3, "The Stall", "2023-01-26", "00:55:00", "episode-24-1-3.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (10, 1, 4, "Rest in Metal", "2023-01-26", "00:55:00", "episode-24-1-4.png");

-- The White Lotus
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (11, 1, 1, "Arrivals", "2021-07-12", "00:59:00", "episode-25-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (11, 1, 2, "New Day", "2021-07-12", "00:59:00", "episode-25-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (11, 1, 3, "Mysterious Monkeys", "2021-07-12", "00:59:00", "episode-25-1-3.png");

INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (11, 2, 1, "Ciao", "2022-10-31", "00:59:00", "episode-25-2-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (11, 2, 2, "Italian Dream", "2022-10-31", "00:59:00", "episode-25-2-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (11, 2, 3, "Bull Elephants", "2022-10-31", "00:59:00", "episode-25-2-3.png");



-- Insert nella tabella genere
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Thriller");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Crime");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Comedy");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Drama");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("History");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Fantasy");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Adventure");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Mistery");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Science Fiction");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Animation");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Anime");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Action");
	
-- Insert nella tabella appartenenza
-- The Killer
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (1,1);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (1,2);
-- Saltburn
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (2,3);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (2,4);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (2,1);
-- Oppenheimer
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (3,5);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (3,4);
-- Barbie
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (4,3);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (4,6);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (4,7);
-- 2001: A Space Odyssey
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (5,7);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (5,8);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (5,9);
	
-- Mr.Robot
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (6,4);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (6,2);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (6,1);
-- Neon Genesis Evangelion
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (7,9);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (7,4);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (7,10);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (7,11);
-- Scott Pilgrim Takes Off
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (8,3);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (8,10);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (8,11);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (8,12);
-- The Power
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (9,9);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (9,4);
-- Poker Face
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (10,4);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (10,2);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (10,8);
-- The White Lotus
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (11,4);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (11,3);
	
-- Insert nella tabella lavoratore
-- Registi e sceneggiatori
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("David","Fincher", "worker-pic-00001.png", "1962-08-28");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Emerald","Fennell", "worker-pic-00002.png", "1985-10-01");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Christopher","Nolan", "worker-pic-00003.png", "1970-07-30");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Greta","Gerwig", "worker-pic-00004.png", "1983-08-04");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita, dataDiMorte)
	VALUES ("Stanley","Kubrik", "worker-pic-00005.png", "1928-07-26", "1999-03-07");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Sam","Esmail", "worker-pic-00006.png", "1977-09-17");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Hideaki","Anno", "worker-pic-00007.png", "1960-05-22");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Bryan Lee","O'Malley", "worker-pic-00008.png", "1979-02-21");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Naomi","Alderman", "worker-pic-00009.png", "1974-01-01");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Rian","Johnson", "worker-pic-00010.png", "1973-12-17");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Mike","White", "worker-pic-00011.png", "1970-06-28");

-- attori e doppiatori
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Micheal","Fassbender", "worker-pic-00012.png", "1977-04-02");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Barry","Keoghan", "worker-pic-00013.png", "1992-10-18");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Jacob","Elordi", "worker-pic-00014.png", "1997-06-26");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Cillian","Murphy", "worker-pic-00015.png", "1976-05-25");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Margot","Robbie", "worker-pic-00016.png", "1990-07-02");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Ryan","Gosling", "worker-pic-00017.png", "1980-11-12");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("America","Ferrera", "worker-pic-00018.png", "1984-04-18");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Keir","Dullea", "worker-pic-00019.png", "1936-05-30");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Rami","Malek", "worker-pic-00020.png", "1981-05-12");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Micheal","Cera", "worker-pic-00021.png", "1988-06-07");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Toni","Collette", "worker-pic-00022.png", "1972-11-01");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Natasha","Lyonne", "worker-pic-00023.png", "1979-04-04");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Murray","Bartlett", "worker-pic-00024.png", "1971-03-20");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Jennifer","Coolidge", "worker-pic-00025.png", "1961-08-28");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Sabrina","Impacciatore", "worker-pic-00026.png", "1968-03-29");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Aubrey","Plaza", "worker-pic-00027.png", "1984-06-26");
	
-- Insert nella tabella attore
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (12);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (13);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (14);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (15);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (16);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (17);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (18);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (19);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (20);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (21);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (22);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (23);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (24);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (25);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (26);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (27);

-- Insert nella tabella membroCrew
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (1);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (2);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (3);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (4);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (5);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (6);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (7);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (8);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (9);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (10);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (11);

-- Insert nella tabella recitazione
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (1, 12, "The Killer");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (2, 13, "Oliver Quick");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (2, 14, "Felix Catton");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (3, 15, "J. Robert Oppenheimer");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (4, 16, "Barbie");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (4, 17, "Ken");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (4, 18, "Gloria");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (5, 19, "Dr. David Bowman");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (6, 20, "Elliot Alderson");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (8, 21, "Scott Pilgrim");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (9, 22, "Mayor Margot Cleary-Lopez");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (10, 23, "Charlie Cale");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (11, 24, "Armond");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (11, 25, "Tanya McQuoid");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (11, 26, "Valentina");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (11, 27, "Harper Spiller");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (8, 27, "Julie Powers");

-- Insert nella tabella partecipazione
-- ruolo Regista
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (1, 1, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (2, 2, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (3, 3, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (4, 4, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (5, 5, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (7, 7, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (10, 10, "Regista");
-- ruolo Sceneggiatore
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (6, 1, "Sceneggiatore");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (7, 2, "Sceneggiatore");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (8, 8, "Sceneggiatore");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (9, 4, "Sceneggiatore");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (10, 10, "Sceneggiatore");
	
	
	
	

/*************************************************
	Inserimento parte 2: Profili e dati annessi
*************************************************/

-- Insert nella tabella profilo
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("e_anderson", "elliot.anderson@ecorp.com", "Qwerty@", 1, 2, "akira42.png", "Elliot", "Alderson");
	
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine) 
	VALUES ("mr.robot", "mr.robot@fsociety.net", "domoarigato", 0, 0, "mr.robot.png");
	
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, biografia) 
	VALUES ("akira42", "antonio.marcone@proton.me", "LifeOnMars71", 0, 2, "akira42.png", "Antonio", "Marcone", "Addicted to movies because reality is poor");
	
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, biografia, abilitante) 
	VALUES ("mikisorr", "michele.sorrentino@gmail.com", "ElevetorHum", 0, 2, "mikisorr.png", "Michele", "Sorrentino", "Only filmlovers left alive", "e_anderson");
	
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, biografia) 
	VALUES ("francescam", "francescamonti01@gmail.com", "Heathens01", 0, 1, "francescam.png", "Francesca", "Monti", "she/her - this is my obsession");
	
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("alessiama00", "alessiama00@gmail.com", "TheLoneliest!#", 0, 0, "alessiama00.png", "Alessia", "Manna");
	
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, biografia) 
	VALUES ("milliegibbo", "milliegibbo@gmail.com", "WhatALife!", 0, 0, "milliegibbo.png", "Millie", "Gibson", "don't touch");

INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, biografia) 
	VALUES ("martinscorsese", "cinema@scorsese.com", "TheBlueDanube", 0, 2, "martinscorsese.png", "Martin", "Scorsese", "This is cinema");
	
	

-- Insert nella tabella notizia
INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("mikisorr", "2023-12-22", "16:00:00", "Cosa guardare a Natale? Consigli tra tv e streaming", "news-2023-12-22-16-00-00.png", "Testo dell'articolo"); 	

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("mikisorr", "2023-12-30", "10:00:00", "Capodanno sul grande schermo: tutti i film più iconici per festeggiare l'anno nuovo", "news-2023-12-30-10-00-00.png", "Testo dell'articolo"); 
	
INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("mikisorr", "2024-01-01", "11:00:00", "I migliori film in uscita in questi giorni", "news-2024-01-01-11-00-00.png", "Testo dell'articolo"); 

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("mikisorr", "2024-01-02", "08:00:00", "Le serie più attese del 2024", "news-2024-01-02-08-00-00.png", "Testo dell'articolo"); 

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("mikisorr", "2024-01-08", "10:00:00", "Serata dei golden globe, grandi speranze per Io capitano", "news-2024-01-08-10-00-00.png", "Testo dell'articolo"); 	

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("mikisorr", "2024-01-09", "08:00:00", "Tutti i vincitori dei Golden Globe 2024", "news-2024-01-01-08-00-00.png", "Testo dell'articolo"); 
	
	
	
-- Insert nella tabella seguire
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("akira42","martinscorsese");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("alessiama00","martinscorsese");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("francescam","martinscorsese");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("mikisorr","martinscorsese");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("milliegibbo","martinscorsese");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("akira42","alessiama00");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("akira42","mikisorr");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("alessiama00","akira42");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("alessiama00","milliegibbo");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("alessiama00","francescam");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("francescam","alessiama00");
	
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("mikisorr","milliegibbo");
	
	
	
-- Insert nella tabella recensione
-- The Killer
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 1, "2023-11-18", 3.5, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("francescam", 1, "2023-11-10", 2.0, "Se lui è il migiore...", 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("mikisorr", 1, "2023-10-04", 3.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("milliegibbo", 1, "2023-12-05", 4.0, 0, 0);
-- Saltburn
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 2, "2023-11-20", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("alessiama00", 2, "2023-11-20", 2.5, "...okay, and?", 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("mikisorr", 2, "2023-11-15", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("milliegibbo", 2, "2023-11-24", 4.0, "Non so come ho fatto a non ammalarmi solo a guardare", 0, 1);
-- Oppenheimer
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 3, "2023-08-18", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("francescam", 3, "2023-08-12", 4.5, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("mikisorr", 3, "2023-08-14", 4.0, "Blonde's impact tbh", 1, 0);
-- Barbie
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 4, "2023-07-18", 4.0, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, preferito, spoiler)
	VALUES ("alessiama00", 4, "2023-07-18", 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("francescam", 4, "2023-07-22", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, descrizione, preferito, spoiler)
	VALUES ("mikisorr", 4, "2023-07-14", "Successo strepitoso", 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("milliegibbo", 4, "2023-07-12", 5.0, "I WENT THRU EVERY SINGLE EMOTION", 0, 0);
-- 2001: A Space Odyssey
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 5, "2023-07-14", 4.5, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, descrizione, preferito, spoiler)
	VALUES ("mikisorr", 5, "2020-06-02", "Capolavoro senza tempo", 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, preferito, spoiler)
	VALUES ("martinscorsese", 5, "2015-01-01", 1, 0);
-- Mr.Robot
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("mr.robot", 6, "2018-07-14", 5.0, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 6, "2018-07-14", 5.0, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("alessiama00", 6, "2018-07-14", 2.5, "Troppo noiosa per finirla", 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("mikisorr", 6, "2018-07-14", 4.0, "Tanti disturbi mentali tutti insieme", 1, 1);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("milliegibbo", 6, "2018-07-14", 4.0, 0, 0);
-- Neon Genesis Evangelion
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("akira42", 7, "2016-05-23", 5.0, "Devo rivederlo...", 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("alessiama00", 7, "2020-04-16", 4.0, "descrizione", 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, preferito, spoiler)
	VALUES ("mikisorr", 7, "2010-11-21", 1, 0);
-- Scott Pilgrim Takes Off
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 8, "2023-11-01", 4.0, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("francescam", 8, "2023-11-01", 3.5, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("milliegibbo", 8, "2023-11-01", 4.5, "Better than the movie", 1, 0);
-- The Power
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("akira42", 9, "2023-10-15", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("francescam", 9, "2023-03-24", 4.5, "Dopo il libro non potevo non vedere la serie!", 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("mikisorr", 9, "2023-01-26", 3.5, 0, 0);
-- Poker Face
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("akira42", 10, "2023-04-20", 5.0, "La signora in giallo per le nuove generazioni", 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("alessiama00", 10, "2023-04-20", 4.0, 1, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("mikisorr", 10, "2023-04-20", 4.5, "Rian Johnson dimostra di saper fare anche ottime serie", 1, 0);
-- The White Lotus
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("akira42", 11, "2023-01-20", 4.5, "Divorata senza sosta", 1, 0);	
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, descrizione, preferito, spoiler)
	VALUES ("alessiama00", 11, "2023-01-20", 3.5, "Le morti più assurde di sempre", 0, 1);	
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("milliegibbo", 11, "2023-01-20", 5.0, 0, 0);	
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("mikisorr", 11, "2023-01-20", 4.0, 1, 0);	

	

-- Insert nella tabella lista
-- Watchlist
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "akira42");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "alessiama00");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "francescam");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "martinscorsese");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "mikisorr");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "milliegibbo");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watchlist", "Salvati da guardare", "mr.robot");
-- Raccolte
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"Watch Party", "Da guardare insieme", "akira42");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0,"This is Cinema", "Collection of movies that makes cinema great", "martinscorsese");
-- Classifiche
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (1,"Ranking film del 2023", "Classifica dei migliori film del 2023", "mikisorr");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (1,"Ranking serie del 2023", "Classifica delle migliori serie del 2023", "mikisorr");
	
	
	
-- Insert nella tabella collezione
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (3,2);

INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (8,2);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (8,4);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (8,7);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (8,10);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (8,11);
	
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (9,5);

INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (10,3,1);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (10,4,2);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (10,2,3);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (10,1,4);



-- Insert nella tabella classificazione
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (11,11,1);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (11,10,2);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (11,8,3);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (11,9,4);	
	
