-- Drop table se existir
DROP TABLE IF EXISTS task;

-- Criação da nova estrutura da tabela task
CREATE TABLE task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(250) NOT NULL,
    completed BOOLEAN
);

-- Inserção dos dados iniciais
INSERT INTO task (description, completed) VALUES
('Primeira tarefa', false),
('Segunda tarefa', false),
('Terceira tarefa', false);
