create table users(
    id integer primary key auto_increment,
    nome varchar(20),
    cnpj varchar(14)

);
create table produtos(
    id integer primary key auto_increment,
    nome varchar(255),
    preco double,
    user_id integer references users(id)

);