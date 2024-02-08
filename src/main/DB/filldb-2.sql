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
-- Shrek
INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "01:30:00", "Shrek", "Fuori dalla mia palude!", "Shrek.png", "2001-05-18", "tutti", 4.9);

-- Rocky Balboa
INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "01:42:00", "Rocky Balboa", "Adriana!", "RockyBalboa.png", "2006-12-20", "tutti", 3.5);

-- La vita è bella
INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "02:02:00", "La vita è bella", "Ambientato durante la dittatura fascista", "LaVitaèBella.png", "1997-12-20", "16+", 4.4);

-- Io e Annie
INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "01:33:00", "Io e Annie", "Un noto commediografo newyorkese e una ragazza con aspirazioni artistiche s'innnamorano", "IoeAnnie.png", "1977-08-20", "12+", 4.0);

-- Ritorno al futuro
INSERT INTO reviewit.opera
	(tipo, durata, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (0, "01:56:00", "Ritorno al futuro", "Ehi tu porco! Levale le mani di dosso!", "RitornoAlFuturo.png", "1985-10-18", "tutti", 4.6);

-- Dragon Ball Z
INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Dragon Ball Z", "No non posso crederci... io sono fortissimo! Sono invicibile! Chiunque se la vedrà con me sarà sconfitto, sono il piu forte! HAHAHA!", "DragonBallZ.png", "1989-04-26", "tutti", 5.0);

-- Chainsaw Man
INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Chainsaw Man", "Ero più felice quando inseguivo il mio obiettivo?", "ChainsawMan.png", "2022-10-12", "tutti", 4.7);

-- Arcane
INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Arcane", "Due sorelle si dividono e combattono su fronti opposti di una guerra, tra tecnologie magiche e credenze contrapposte", "Arcane.png", "2021-12-6", "16+", 4.8);

-- Breaking Bad
INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "Breaking Bad", "Un professore di chimica, Walter White, scopre di avere un cancro ai polmoni giudicato incurabile e decide di diventare socio di uno spacciatore di droga, Jesse", "BreakingBad.png", "2008-01-20", "18+", 4.7);

-- The Witcher
INSERT INTO reviewit.opera
	(tipo, titolo, descrizione, locandina, dataDiUscita, classificazione, votoMedio)
	VALUES (1, "The Witcher", "In un mondo abitato da diverse creature magiche, Geralt, un cacciatore di mostri mutante dagli incredibili poteri, deve combattere per salvare le specie pacifiche da quelle bellicose.", "TheWitcher.png", "2019-06-20", "18+", 3.9);
    
-- Insert nella tabella serie
-- Dragon Ball Z
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (17, 0);

-- Chainsaw Man
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (18, 1);

-- Arcane
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (19, 1);

-- Breaking Bad
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (20, 0);

-- The Witcher
INSERT INTO reviewit.serie
	(operaId, stato)
	VALUES (21, 1);
   
-- Insert nella tabella stagione
-- Dragon Ball Z
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (17, 1, "Saga dei Saiyan");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (17, 2, "Saga di Freezer");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (17, 3, "Saga di Cell");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (17, 4, "Saga di Majin Bu");

-- Chainsaw Man
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (18, 1, "Prima stagione");

-- Arcane
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (19, 1, "Prima stagione");

-- Breaking Bad
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (20, 1, "Prima stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (20, 2, "Seconda stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (20, 3, "Terza stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (20, 4, "Quarta stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (20, 5, "Quinta stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (20, 6, "Sesta stagione");

-- The Witcher
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (21, 1, "Prima stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (21, 2, "Seconda stagione");
INSERT INTO reviewit.stagione
	(serieId, numero, titolo)
	VALUES (21, 3, "Terza stagione");

-- Insert nella tabella episodio
-- Dragon Ball Z
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (17, 1, 1, "Il misterioso combattente", "1989-04-26", "00:24:00", "IlMisteriosoCombattente-17-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (17, 1, 2, "Il fratello di Goku", "1989-05-3", "00:24:00", "IlFratelloDiGoku-17-1-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (17, 2, 1, "La speranza vive su Namecc", "1990-2-14", "00:24:00", "LaSperanzaViveSuNamecc-17-2-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (17, 2, 2, "Il veicolo spaziale del Supremo", "1990-2-21", "00:24:00", "IlVeicoloSpazialeDelSupremo-17-2-2.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (17, 3, 1, "Il ritorno di Freezer", "1991-11-27", "00:24:00", "IlRitornoDiFreezer-17-3-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (17, 3, 2, "Il ragazzo misterioso", "1991-12-4", "00:24:00", "IlRagazzoMisterioso-17-3-2.png");

-- Chainsaw Man
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (18, 1, 1, "Cane e motosega", "2022-10-11", "00:24:00", "CaneeMotosega-18-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (18, 1, 2, "Arrivo a Tokyo", "2022-10-12", "00:24:00", "ArrivoaTokyo-18-1-1.png");

-- Arcane
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (19, 1, 1, "Che il gioco abbia inizio", "2021-11-6", "00:44:00", "CheIlGiocoAbbiaInizio-19-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (19, 1, 2, "Alcuni misteri dovrebbero rimanere irrisolti", "2021-11-6", "00:44:00", "AlcuniMisteriDovrebberoRimanereIrrisolti-19-1-2.png");
    
-- Breaking Bad
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (20, 1, 1, "Questione di chimica", "2008-01-20", "00:47:00", "QuestioneDiChimica-20-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (20, 1, 2, "Senza Ritorno", "2008-01-27", "00:47:00", "SenzaRitorno-20-1-2.png");

-- The Withcer
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (21, 1, 1, "L'inizio della fine", "2019-12-20", "00:55:00", "L'inizioDellaFine-21-1-1.png");
INSERT INTO reviewit.episodio
	(serieId, numeroStagione, numero, titolo, dataDiUscita, durata, anteprima)
	VALUES (21, 2, 1, "Un briciolo di verità", "2019-12-20", "00:55:00", "UnBricioloDiVerità-21-2-1.png");

-- Insert nella tabella genere
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Black Humor");    
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Steampunk");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Romantic");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("Sport");
INSERT INTO reviewit.genere
	(nome)
	VALUES ("War");

-- Insert nella tabella appartenenza
-- Shrek
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (12,10);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (12,3);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (12,12);

-- Rocky Balboa
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (13,12);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (13,15);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (13,16);

-- La vita è bella
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (14,5);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (14,17);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (14,3);

-- Io e Annie
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (15,3);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (15,15);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (15,4);

-- Ritorno al futuro
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (16,10);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (16,9);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (16,12);

-- Dragon Ball Z
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (17,12);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (17,7);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (17,11);

-- Chainsaw Man
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (18,11);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (18,12);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (18,3);

-- Arcane
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (19,10);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (19,14);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (19,9);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (19,12);

-- Breaking Bad
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (20,4);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (20,13);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (20,2);

-- The Witcher
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (21,12);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (21,7);
INSERT INTO reviewit.appartenenza
	(operaId, genereId)
	VALUES (21,6);


-- Insert nella tabella lavoratore
-- Shrek
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Andrew","Adamson", "AndrewAdamson.png", "1966-12-01");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Ted","Elliott", "TedElliott.png", "1961-07-04");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Mike","Myers", "MikeMyers.png", "1963-05-25");

-- Rocky Balboa
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Sylvester","Stallone", "SylvesterStallone.png", "1964-07-6");

-- La vita è bella
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Roberto","Benigni", "RobertoBenigni.png", "1952-10-27");

-- Io e Annie
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Woody","Allen", "WoodyAllen.png", "1935-12-30");

-- Ritorno al futuro
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Robert","Zemeckis", "RobertZemeckis.png", "1952-05-14");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Michael J.","Fox", "MichaeljFox.png", "1961-06-09");

-- Dragon Ball Z
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Daisuke","Nishio", "DaisukeNishio.png", "1959-04-1");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Masako","Nozawa", "MasakoNozawa.png", "1936-10-25");

-- Chainsaw Man
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Ryū","Nakayama", "RyūNakayama.png", "1990-02-10");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Kikunosuke","Toya", "KikunosukeToya.png", "1998-12-30");

-- Arcane
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Christian","Linke", "ChristianLinke.png", "1987-03-11");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Ella","Purnell", "EllaPurnell.png", "1996-09-17");

-- Breaking Bad
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Vince","Gilligan", "VinceGilligan.png", "1967-02-10");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Bryan","Cranston", "BryanCranston.png", "1956-03-07");
    
-- The Witcher
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Lauren Schmidt","Hissrich", "LaurenSchmidtHissrich.png", "1978-08-01");
INSERT INTO reviewit.lavoratore
	(nome, cognome, immagine, dataDiNascita)
	VALUES ("Henry","Cavill", "HenryCavill.png", "1983-05-05");



-- Insert nella tabella attore
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (30);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (31);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (32);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (33);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (35);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (37);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (39);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (41);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (43);
INSERT INTO reviewit.attore
	(lavoratoreID)
	VALUES (45);

-- Insert nella tabella membroCrew
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (28);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (29);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (31);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (32);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (33);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (34);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (36);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (38);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (40);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (42);
INSERT INTO reviewit.membrocrew
	(lavoratoreID)
	VALUES (44);

-- Insert nella tabella recitazione
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (12, 30, "Shrek");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (13, 31, "Rocky Balboa");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (14, 32, "Guido Orefice");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (15, 33, "Alvy Singer");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (16, 35, "Marty McFly");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (17, 37, "Son Goku");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (18, 39, "Denji");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (19, 41, "Jinx");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (20, 43, "Walter White");
INSERT INTO reviewit.recitazione
	(operaId, attoreId, nomePersonaggio)
	VALUES (21, 45, "Geralt of Rivia");


-- Insert nella tabella partecipazione
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (12, 28, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (12, 29, "Sceneggiatore");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (13, 31, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (14, 32, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (15, 33, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (15, 33, "Sceneggiatore");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (16, 34, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (17, 36, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (18, 38, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (19, 40, "Direttore Creativo");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (20, 42, "Regista");
INSERT INTO reviewit.partecipazione
	(operaId, membroCrewId, ruolo)
	VALUES (20, 44, "Ideatore");
   
/*************************************************
	Inserimento parte 2: Profili e dati annessi
*************************************************/
-- Insert nella tabella profilo
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, biografia) 
	VALUES ("kers", "ers@gmail.com", "password1", 0, 2, "kers.png", "Ersilio", "Petretta", "basatore di dati");
    
    INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("SalE", "SalE@gmail.com", "SalE1", 1, 2, "kers.png", "Salvatore", "Esposito");

INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("LeoRo", "LeoRo@gmail.com", "LeoRo1", 0, 0, "LeoRo.png", "Leonardo", "Rossi");

INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("FraFe", "FraFe@gmail.com", "FraFe1", 0, 1, "FraFe.png", "Francesco", "Ferrari");
    
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("TomTa", "TomTa@gmail.com", "TomTa1", 0, 2, "TomTa.png", "Tommaso", "Fontata");
    
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("LorMa", "LorMa@gmail.com", "LorMa1", 0, 0, "LorMa.png", "Lorenzo", "Marini");

INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome, abilitante) 
	VALUES ("SofiTe", "SofiTe@gmail.com", "SofiTe1", 0, 0, "SofiTe.png", "Sofia", "Conte", "SalE");
    
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("GabGre", "GabGre@gmail.com", "GabGre1", 0, 0, "GabGre.png", "Gabriele", "Greco");
    
INSERT INTO reviewit.profilo 
	(username, email, password, tipo, grado, immagine, nome, cognome) 
	VALUES ("AnTti", "AnTti@gmail.com", "AnTti1", 0, 1, "AnTti.png", "Andrea", "Rossetti");

-- Insert nella tabella notizia
INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("SofiTe", "2023-12-31", "12:00:00", "Come inziare il nuovo anno al meglio con questi consgili cinematografici", "placeholder.png", "Testo dell'articolo");

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("SofiTe", "2023-03-19", "11:00:00", "Top 10 film da vedere con papà! ôヮô", "placeholder.png", "Testo dell'articolo");

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("SofiTe", "2023-04-8", "10:00:00", "Le più belle serie a tema pasquali", "placeholder.png", "Testo dell'articolo");

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("SofiTe", "2023-04-30", "10:00:00", "Per tutti i nostri duri lavoratori dei film speciali per voi!", "placeholder.png", "Testo dell'articolo");

INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("SofiTe", "2023-05-30", "10:00:00", "Ho troppi film da guardare e troppo poco tempo come faccio? o(╥﹏╥)o Ecco i nostri consigli!", "placeholder.png", "Testo dell'articolo");
    
INSERT INTO reviewit.notizia
	(profiloId, data, ora, titolo, anteprima, contenuto)
	VALUES ("SofiTe", "2023-10-28", "9:00:00", "Cosa guardare ad Halloween? Non solo Nightmare Before Christmas!", "placeholder.png", "Testo dell'articolo");    
   
-- Insert nella tabella seguire
INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("kers","SofiTe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("TomTa","SofiTe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("LorMa","SofiTe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("LeoRo","SofiTe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("FraFe","SofiTe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("AnTti","SofiTe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("SofiTe","kers");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("AnTti","kers");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("SofiTe","FraFe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("LeoRo","FraFe");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("SofiTe","LeoRo");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("FraFe","LeoRo");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("SofiTe","TomTa");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("LorMa","TomTa");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("SofiTe","LorMa");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("TomTa","LorMa");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("kers","AnTti");

INSERT INTO reviewit.seguire
	(profiloSeguente, profiloSeguito)
	VALUES ("SofiTe","AnTti");
    
-- Insert nella tabella recensione
-- Shrek
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("AnTti", 12, "2023-11-02", 4.5, 1, 1, "Shrek sposa la principessa fiona");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("FraFe", 12, "2023-11-03", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("GabGre", 12, "2023-11-04", 5.0, 1, 0);

-- Rocky Balboa
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("SofiTe", 13, "2023-02-12", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LeoRo", 13, "2023-02-13", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LorMa", 13, "2023-02-14", 2.0, 0, 0);

-- La vita è bella
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("TomTa", 14, "2023-02-14", 4.8, 1, 0, "film stupendo mi sono commosso alla fine");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LeoRo", 14, "2023-02-14", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LorMa", 14, "2023-02-16", 4.0, 0, 0);

-- Io e Annie
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("AnTti", 15, "2023-03-21", 4.0, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("FraFe", 15, "2023-03-20", 3.9, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("GabGre", 15, "2023-03-15", 4.1, 0, 0);

-- Ritorno al futuro
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("kers", 16, "2023-10-02", 4.9, 1, 0, "Sempre bello da vedere, uno dei miei film preferiti");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("SofiTe", 16, "2023-10-02", 4.5, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("GabGre", 16, "2023-10-12", 4.2, 0, 0);

-- Dragon Ball Z
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("kers", 17, "2023-11-12", 5.0, 1, 0, "Uno dei miei anime preferiti");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("SofiTe", 17, "2023-11-12", 4.6, 0, 0, "ho visto il finale con il mio ragazzo il giorno del suo compleanno lui lo adora e anche a me è piaciuto molto");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("FraFe", 17, "2023-10-05", 4.2, 0, 0);

-- Chainsaw Man
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("kers", 18, "2023-05-21", 4.3, 0, 1, "Non sanno che sono Chainsaw Man");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("LeoRo", 18, "2023-05-10", 3.4, 0, 0, "Ho letto recensioni molto strane in questa sezione");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LorMa", 18, "2023-04-02", 4.1, 0, 0);

-- Arcane
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("kers", 19, "2023-02-17", 4.3, 0, 0, "Le animazioni sono fatte benissimo");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("TomTa", 19, "2023-03-22", 3.9, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LorMa", 19, "2023-02-11", 3.9, 0, 0);

-- Breaking Bad
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("AnTti", 20, "2023-01-27", 4.3, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("TomTa", 20, "2023-01-22", 2.4, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LorMa", 20, "2023-02-22", 5.0, 1, 0);

-- The Witcher
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("TomTa", 21, "2023-01-27", 4.2, 0, 0);
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler, descrizione)
	VALUES ("SofiTe", 21, "2023-01-22", 4.0, 0, 0, "Non bella quanto il gioco ma non mi posso proprio lamentare!");
INSERT INTO reviewit.recensione
	(profiloId, operaId, data, voto, preferito, spoiler)
	VALUES ("LorMa", 21, "2023-02-22", 4.0, 1, 0);

-- Insert nella tabella lista
-- Whatchlist
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "kers");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "LeoRo");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "FraFe");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "TomTa");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "LorMa");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "SofiTe");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "GabGre");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Watchlist", "Salvati da guardare", "AnTti");

-- raccolte
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Film e serie preferiti", "I Film e serie che mi sono piaciuti particolarmente", "kers");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Serie Preferite", "Le mie serie preferite", "SofiTe");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (0, "Serie per articoli", "Serie che ho visto di cui parlare in futuri articoli", "SofiTe");

-- collezione
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (1, "Top serie d'azione", "Top delle mie serie d'azione preferite", "kers");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (1, "Top 10 film da guardare con il papà!", "Film da guardare con il proprio padre il giorno della festa del papà", "SofiTe");
INSERT INTO reviewit.lista
	(tipo, titolo, descrizione, profiloId)
	VALUES (1, "Top 100 film di tutti i tempi(in corso d'opera)", "Classifica dei 100 migliori filmi in assoluto, ho cercato di essere il più oggettiva possibile", "SofiTe");
    
-- Insert nella tabella collezione
-- kers -Film e serie preferiti
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (20,16);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (20,17);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (20,18);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (20,19);

-- SofiTe -Serie Preferite
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (21,18);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (21,19);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (21,20);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (21,21);

-- SofiTe -Serie per articoli
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (22,16);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (22,17);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (22,18);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (22,19);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (22,20);
INSERT INTO reviewit.collezione
	(listaId, operaId)
	VALUES (22,21);

-- Insert nella tabella classificazione
-- kers -Top serie d'azione
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (23,17,1);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (23,18,2);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (23,19,3);

-- SofiTe -Top 10 film da guardare con il papà!
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (24,12,4);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (24,13,2);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (24,14,3);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (24,15,5);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (24,16,1);

-- SofiTe -Top 100 film di tutti i tempi(in corso d'opera)
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (25,12,2);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (25,13,5);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (25,14,3);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (25,15,4);
INSERT INTO reviewit.classificazione
	(listaId, operaId, posizione)
	VALUES (25,16,1);
    
/*---------------------------------------------------------------------------------------------------------------------------
update numRecensioni
*/
UPDATE opera, (SELECT opera.id as id, COUNT(r.operaId) as numRecensioni 
	FROM recensione r INNER JOIN opera ON opera.id = r.operaId 
    WHERE r.voto is not null
    GROUP BY opera.id) as result 
SET opera.numRecensioni = result.numRecensioni
WHERE opera.id = result.id;

/*
update votoMedio
*/

UPDATE opera, (SELECT opera.id as id, round(AVG(r.voto), 1) as votoMedio 
	FROM recensione r INNER JOIN opera ON opera.id = r.operaId 
    WHERE r.voto is not null
    GROUP BY opera.id) as result 
SET opera.votoMedio = result.votoMedio
WHERE opera.id = result.id;