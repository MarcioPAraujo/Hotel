create table hotel(
	id int auto_increment primary key,
	nome varchar(30),
    capacidade int
);

create table agencia(
	id int auto_increment primary key,
    nome varchar(50),
    classificacao char
);

create table quarto(
	numero int auto_increment primary key,
    classificacao char,
    capacidade int,
    disponivel bit
    
);

create table usuario(
	email varchar(100) unique primary key,
    senha varchar(50),
    root bit,
    hospede int,
    constraint fk_hospede_id foreign key(hospede) references hospede (id)
);

create table hospede(
	id int auto_increment primary key,
    nome varchar(100),
    cpf varchar(11),
    rg varchar(20),
    nascimento date
);

create table reserva(
	id bigint auto_increment primary key,
    dia_da_reserva date,
    expiracao date,
    dias_reservados int,
    diaria numeric(6,2),
    despesas_totais numeric(7,2),
    servicos_adicionais bit,
    hospede int,
    agencia int,
    quarto int,
    constraint fk_hospede_id foreign key (hospede) references hospede (id),
    constraint fk_agencia_id foreign key (agencia) references agencia (id),
    constraint fk_quarto_num foreign key (quarto) references quarto (numero)
);

create table historico(
	id bigint auto_increment primary key,
     dia_da_reserva date,
    expiracao date,
    dias_reservados int,
    diaria numeric(6,2),
    despesas_totais numeric(7,2),
    servicos_adicionais bit,
    hospede int,
    agencia int,
    quarto int,
    constraint fk_hospede_id foreign key (hospede) references hospede (id),
    constraint fk_agencia_id foreign key (agencia) references agencia (id),
    constraint fk_quarto_num foreign key (quarto) references quarto (numero)
);



