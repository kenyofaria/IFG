const sqlite3 = require('sqlite3').verbose();
const bd = new sqlite3.Database('data.db');

const USUARIOS_SCHEMA = `
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    nome_completo VARCHAR(40) NOT NULL UNIQUE, 
    email VARCHAR(255) NOT NULL, 
    senha VARCHAR(255) NOT NULL
)
`;

const INSERIR_USUARIO_1 = 
`
INSERT INTO usuarios (
    nome_completo, 
    email,
    senha
) SELECT 'Kenyo Faria', 'kenyofaria@gmail.com', '123' WHERE NOT EXISTS (SELECT * FROM usuarios WHERE email = 'kenyofaria@gmail.com')
`;

const PACIENTES_SCHEMA = 
`
CREATE TABLE IF NOT EXISTS pacientes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL, 
    peso REAL NOT NULL,
    altura REAL NOT NULL
)
`;

const INSERIR_PACIENTE_1 = 
`
INSERT INTO pacientes (
    nome,
    peso,
    altura
) SELECT 'Kenyo Faria', 93, 1.81 WHERE NOT EXISTS (SELECT * FROM pacientes WHERE nome = 'Kenyo Faria')
`;

const INSERIR_PACIENTE_2 = 
`
INSERT INTO pacientes (
    nome,
    peso,
    altura
) SELECT 'Vitor Soares Faria', 35, 1.35 WHERE NOT EXISTS (SELECT * FROM pacientes WHERE nome = 'Vitor Soares Faria')
`;

bd.serialize(() => {
    bd.run("PRAGMA foreign_keys=ON");
    bd.run(USUARIOS_SCHEMA);
    bd.run(INSERIR_USUARIO_1);
    bd.run(PACIENTES_SCHEMA);
    bd.run(INSERIR_PACIENTE_1);
    bd.run(INSERIR_PACIENTE_2);

    bd.each("SELECT * FROM usuarios", (err, usuario) => {
        console.log('Usuario: ');
        console.log(usuario);
    });
});

process.on('SIGINT', () =>
    bd.close(() => {
        console.log('BD encerrado!');
        process.exit(0);
    })
);

module.exports = bd;