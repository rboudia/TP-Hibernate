CREATE TABLE IF NOT EXISTS annonce (
                                       id SERIAL PRIMARY KEY,
                                       title VARCHAR(64),
    description VARCHAR(256),
    adress VARCHAR(64),
    mail VARCHAR(64),
    date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO annonce (title, description, adress, mail, date)
VALUES
    ('Vente Appartement', 'Appartement 3 pièces à vendre, 65m², proche centre-ville', '123 Rue de Paris, France', 'contact@example.com', NOW()),
    ('Vente Maison', 'Maison individuelle 5 pièces, 120m² avec jardin', '56 Route de Lyon, France', 'maisonvente@example.com', NOW()),
    ('Vente Voiture', 'Peugeot 208, 2018, 50 000 km, excellent état', '78 Boulevard de Paris, France', 'auto@example.com', NOW());
