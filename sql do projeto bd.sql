create table funcionario(
nome varchar(30),
cpf varchar(20) unique,
telefone varchar(20),
id int auto_increment,
primary key(id)
);

create table produto(
nome varchar(30),
valor float,
quantidade int,
id int auto_increment,
primary key(id)
);



create table extra(
descricao varchar(20),
id int auto_increment,
primary key(id)
);

create table hospede(
nome varchar(30),
email varchar(20),
cpf varchar(15) unique,
telefone varchar(15),
id int auto_increment,
primary key(id)
);

create table quarto(
id int auto_increment,
diaria float,
acomodacoes int,
status varchar(20),
primary key(id)
);

create table pedido(
id int auto_increment,
data_pedido date,
id_hospede int not null,
primary key(id));


create table quarto_extra(
id_quarto int not null,
id_extra int not null,
primary key(id_quarto,id_extra),
foreign key(id_quarto) references quarto(id),
foreign key(id_extra) references extra(id)
);

create table reserva(
id_hospede int not null,
id_quarto int not null,
diaria float,
quant_dias int,
id int auto_increment,
constraint pk_reserva primary key(id),
constraint fk_hospede foreign key(id_hospede) references hospede(id),
constraint fk_quarto foreign key(id_quarto) references quarto(id));

create table pagamento(
id_reserva int not null,
data_pg date,
valor float,
constraint fk_reserva foreign key(id_reserva) references reserva(id)
);

create table produto_pedido(
id_produto int not null,
id_pedido int not null,
quantidade int not null,
foreign key(id_produto) references produto(id),
foreign key(id_pedido) references pedido(id)
);


create view relatorio as (
select p.id as codigo, h.nome hospede, prod.nome as produto, (pp.quantidade * prod.valor) as total, p.data_pedido from
pedido p inner join produto_pedido pp on (p.id = pp.id_pedido) inner join produto prod
on (pp.id_produto = prod.id) inner join hospede h on (h.id = p.id_hospede)

);

delimiter $
create trigger subtraiProd after insert
on produto_pedido
for each row
begin
update produto set quantidade = (quantidade - new.quantidade) where id = new.id_produto;
end $