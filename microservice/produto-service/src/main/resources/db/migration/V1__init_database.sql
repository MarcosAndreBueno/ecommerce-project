create table if not exists categoria (
    id integer not null primary key,
    nome varchar(255),
    descricao varchar(255)
);

create table if not exists produto (
    id integer not null primary key,
    nome varchar(255),
    descricao varchar(255),
    quantidade_disponivel integer,
    preco numeric(38, 2),
    categoria_id integer constraint fk_produto_categoria
        references categoria
);

create sequence if not exists categoria_seq increment by 50;
create sequence if not exists produto_seq increment by 50;
