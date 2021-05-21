INSERT INTO Chess_Player(id, birth_date, first_name, last_name, version) VALUES (1, '1990-09-30', 'Magnus', 'Carlsen', 0);
INSERT INTO Chess_Player(id, birth_date, first_name, last_name, version) VALUES (2, '1999-04-30', 'Jorden', 'van Foreest', 0);
INSERT INTO Chess_Player(id, birth_date, first_name, last_name, version) VALUES (3, '1994-06-28', 'Anish', 'Giri', 0);
INSERT INTO Chess_Player(id, birth_date, first_name, last_name, version) VALUES (4, '1992-07-30', 'Fabiano', 'Caruana', 0);

INSERT INTO Chess_Tournament(id, start_date, end_date, name, version) VALUES (1, '2021-01-14', '2021-01-30', 'Tata Steel Chess Tournament 2021', 0);

INSERT INTO Chess_Game(id, round, version, chess_tournament_id, player_white_id, player_black_id) VALUES (1, 4, 0, 1, 2, 1);
INSERT INTO Chess_Game(id, round, version, chess_tournament_id, player_white_id, player_black_id) VALUES (2, 10, 0, 1, 4, 1);
INSERT INTO Chess_Game(id, round, version, chess_tournament_id, player_white_id, player_black_id) VALUES (3, 11, 0, 1, 1, 3);
INSERT INTO Chess_Game(id, round, version, chess_tournament_id, player_white_id, player_black_id) VALUES (4, 2, 0, 1, 2, 3);
INSERT INTO Chess_Game(id, round, version, chess_tournament_id, player_white_id, player_black_id) VALUES (5, 1, 0, 1, 4, 2);
INSERT INTO Chess_Game(id, round, version, chess_tournament_id, player_white_id, player_black_id) VALUES (6, 8, 0, 1, 4, 3);