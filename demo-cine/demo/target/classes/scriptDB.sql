CREATE TABLE LUIS.Leaf_type(
    leaf_id INT PRIMARY KEY,
    leaf_name VARCHAR2(32)
);
CREATE TABLE LUIS.Habitat(
    habitat_id INT PRIMARY KEY,
    habitat_name VARCHAR2(32)
);
CREATE TABLE LUIS.Trees(
    tree_id INT PRIMARY KEY,
    tree_name VARCHAR2(64),
    leaf_type INT REFERENCES Leaf_type(leaf_id),
    habitat INT REFERENCES Habitat(habitat_id)
);
CREATE TABLE LUIS.Bushes(
    bush_id INT PRIMARY KEY,
    bush_name VARCHAR2(64),
    leaf_id INT REFERENCES Leaf_type(leaf_id),
    habitat_id INT REFERENCES Habitat(habitat_id),
    bush_description CLOB
);
CREATE TABLE LUIS.Compatibles(
    compatible_id INT PRIMARY KEY,
    tree_id INT REFERENCES Trees(tree_id),
    bush_id INT REFERENCES Bushes(bush_id),
    compatible_risk INT
);
INSERT INTO Leaf_type
values (1, 'PERENNE');
INSERT INTO Leaf_type
values (2, 'CADUCA');
INSERT INTO Habitat
values (1, 'TROPICAL');
INSERT INTO Habitat
values (2, 'HUMEDO');
INSERT INTO Habitat
values (3, 'SECO');
INSERT INTO Habitat
values (4, 'CALIDO');
INSERT INTO Trees
values (1, 'Abies pinsapo', 1, 1);
INSERT INTO Trees
values (2, 'Acer campestre', 2, 2);
INSERT INTO Trees
values (3, 'Betula pendula', 2, 2);
INSERT INTO Trees
values (4, 'Ceratonia siliqua', 2, 3);
INSERT INTO Trees
values (5, 'Citrus aurantium', 1, 4);
INSERT INTO Bushes
values (
        1,
        'Magnolia grandiflora',
        1,
        2,
        'importada, mayormente uso ornamental'
    );
INSERT INTO Bushes
values (
        2,
        'Convolvulus arvensis',
        2,
        2,
        'trepadora, muy invasiva'
    );
INSERT INTO Bushes
values (3, 'Echium creticum', 2, 2, 'ornamental');
INSERT INTO Bushes
values (
        4,
        'Anchusa azurea',
        2,
        3,
        'propiedades medicinales'
    );
INSERT INTO Compatibles
values (1, 1, 1, 3);
INSERT INTO Compatibles
values (2, 1, 2, 9);
INSERT INTO Compatibles
values (3, 1, 3, 1);
INSERT INTO Compatibles
values (4, 1, 4, 6);
INSERT INTO Compatibles
values (5, 2, 1, 3);
INSERT INTO Compatibles
values (6, 2, 2, 8);
INSERT INTO Compatibles
values (7, 2, 3, 3);
INSERT INTO Compatibles
values (8, 2, 4, 5);
INSERT INTO Compatibles
values (9, 3, 1, 2);
INSERT INTO Compatibles
values (10, 3, 2, 7);
INSERT INTO Compatibles
values (11, 3, 3, 3);
INSERT INTO Compatibles
values (12, 3, 4, 5);
INSERT INTO Compatibles
values (13, 4, 1, 3);
INSERT INTO Compatibles
values (14, 4, 2, 9);
INSERT INTO Compatibles
values (15, 4, 3, 3);
INSERT INTO Compatibles
values (16, 4, 4, 3);
INSERT INTO Compatibles
values (17, 5, 1, 1);
INSERT INTO Compatibles
values (18, 5, 2, 7);
INSERT INTO Compatibles
values (19, 5, 3, 0);
INSERT INTO Compatibles
values (20, 5, 4, 2);
CREATE TABLE Located(
    located_id INT PRIMARY KEY,
    located_name VARCHAR2(64),
    located_coord VARCHAR2(32)
);
CREATE TABLE Flora(
    flora_id INT PRIMARY KEY,
    flora_type_id INT,
    flora_type VARCHAR2(32),
    located_id INT REFERENCES Located(located_id)
);