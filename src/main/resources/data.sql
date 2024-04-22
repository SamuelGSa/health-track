
CREATE TABLE IF NOT EXISTS emergency_contact (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(255) NOT NULL,
    degree_of_kinship VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS patient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    emergencyContact_id BIGINT,
    CONSTRAINT fk_emergency_contact
        FOREIGN KEY (emergencyContact_id)
        REFERENCES emergency_contact(id)
        ON DELETE CASCADE
);

---- Inserir dados na tabela emergency_contact
INSERT INTO emergency_contact (first_name, last_name, contact_phone, degree_of_kinship)
VALUES
('Ana', 'Cardoso', '123456', 'Irmã'),
('Pedro', 'Gomes', '11987654321', 'Pai');

---- Inserir dados na tabela patient
INSERT INTO patient (first_name, last_name, contact_phone, birth_date, cpf, email, EMERGENCY_CONTACT_ID)
VALUES
('João', 'Silva', '1122334455', '1990-05-01', '123.456.789-00', 'joao.silva@example.com', 1),
('Maria', 'Oliveira', '2233445566', '1982-08-15', '987.654.321-00', 'maria.oliveira@example.com', 2);



