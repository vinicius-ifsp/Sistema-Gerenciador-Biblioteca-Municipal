CREATE DATABASE IF NOT EXISTS biblioteca CHARSET = Latin1 COLLATE = latin1_swedish_ci;
Use biblioteca;

CREATE TABLE Livro(
    id int auto_increment,
    titulo varchar(64),
    subtitulo varchar(64),
    autor varchar(64),
    genero varchar(64),
    anoPublicacao varchar(5),
    qtdPaginas int,
    editora varchar(64),
    publicacao varchar(64),
    qtdExemplares int,
    dataEntrada varchar(16),
    PRIMARY KEY(id)
);

CREATE TABLE Leitor(
    id int auto_increment,
    nome varchar(64),
    rg varchar(64),
    cpf varchar(64),
    endereco varchar(64),
    complemento varchar(64),
    numero varchar(64),
    telefone varchar(64),
    celular varchar(64),
    email varchar(64),
    dataEntrada varchar(16),
    PRIMARY KEY(id)
);

CREATE TABLE Emprestimo(
    id int auto_increment,
    dataSaida varchar(16),
    dataRetorno varchar(16),
    
    PRIMARY KEY(id)
);

CREATE TABLE LivroEmprestimo(
    idLivro int,
    idEmprestimo int,
    
    FOREIGN KEY(idLivro) REFERENCES Livro(id),
    FOREIGN KEY(idEmprestimo) REFERENCES Emprestimo(id),
    PRIMARY KEY(idLivro, idEmprestimo)
    
);

CREATE TABLE LeitorEmprestimo(
    idLeitor int,
    idEmprestimo int,
    
    FOREIGN KEY(idLeitor) REFERENCES Leitor(id),
    FOREIGN KEY(idEmprestimo) REFERENCES Emprestimo(id),
    PRIMARY KEY(idLeitor, idEmprestimo)
);




CREATE TABLE Usuario(
    id int AUTO_INCREMENT,
    nome varchar(64),
    rg varchar(64),
    email varchar(64),
    pswd varchar(64),
    tipoUser varchar(64),
    PRIMARY KEY(id)
)