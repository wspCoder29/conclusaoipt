-- schema.sql
CREATE TABLE IF NOT EXISTS clients (
                                       id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                       firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    phone VARCHAR(20) NULL,
    address VARCHAR(200) NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO clients (firstname, lastname, email, phone, address)
VALUES
    ('João', 'Silva', 'joao.silva@example.com', '11-98765-4321', 'São Paulo, SP'),
    ('Maria', 'Santos', 'maria.santos@example.com', '21-99876-5432', 'Rio de Janeiro, RJ'),
    ('Pedro', 'Oliveira', 'pedro.oliveira@example.com', '31-98765-1234', 'Belo Horizonte, MG'),
    ('Ana', 'Rodrigues', 'ana.rodrigues@example.com', '41-99876-2345', 'Curitiba, PR'),
    ('Carlos', 'Ferreira', 'carlos.ferreira@example.com', '51-98765-3456', 'Porto Alegre, RS'),
    ('Juliana', 'Almeida', 'juliana.almeida@example.com', '61-99876-4567', 'Brasília, DF'),
    ('Marcos', 'Costa', 'marcos.costa@example.com', '71-98765-5678', 'Salvador, BA'),
    ('Fernanda', 'Carvalho', 'fernanda.carvalho@example.com', '81-99876-6789', 'Recife, PE'),
    ('Lucas', 'Gomes', 'lucas.gomes@example.com', '91-98765-7890', 'Belém, PA'),
    ('Beatriz', 'Martins', 'beatriz.martins@example.com', '85-99876-8901', 'Fortaleza, CE');