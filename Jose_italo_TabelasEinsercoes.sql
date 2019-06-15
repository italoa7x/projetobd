-- CRIAÇÃO DAS TABELAS --

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




-- INSERÇÕES --
insert into funcionario(nome,telefone,cargo,cpf) values
('Maria','8-21541313','Recepcionista','12382731'),('Fernando','9-3812-12331','Atendente','192839183'),
('Ana','8-654242','Serviços Gerais','095676'),('Paulo','9-6871435','Serviços Gerais','7896363'),
('João','9-45134154','Atendente','80794743'),('Cristiano','8-12345123','Serviços Gerais','8706847'),
('Silvano','9-12282871','Atendente','9123892381'),('Marivalda','9-1273217821','Serviços Gerais','12318231')
,('Albária',null,'Serviços Gerais','1119282281'),('Salves',null,'Recepcionista','001293012931');

insert into produto(nome,valor,quantidade) values 
('Pippos',2.50,500),('Guaraná 2L',6.00,100),('Guaraná 500ML',3.00,1000),('Coca cola latinha',3.50,1000),
('Solda latinha',3.00,500),('Fanta 2L',6.00,1000),('Cerveja Skoll',3.50,1000),('Cerveja Itaipava',5.00,1000),
('Cerveja Itaipava 1L',7.00,1000),('Montila 1L',7.00,200);

insert into hospede(nome,email,cpf,telefone) values
('Fernanda Santos',null,'1283781','9-1231131231'),('Mariana','maaria@gmail.com',1251432,null),
('Carlos Borges','crlos@outlook.com','128371837','8-12731231873'),('Alexandra Caetano Santos','ale@gmail.com','12728132','9-479541418')
,('Paula Barros da Costa','p.barros@hotmail.com','1231512','8-123123441'),('João Alcapone','joao@contato.com','28371283','9-131233131'),
('Samara Silva',null,'1234124','9-54722346'),('Carmen da Silveira','carmen@gmail.com','131313','9-12311231231'),('Silvana Bispo','sil.bispo@gmail.com','129081',null),
('Natan Romão','natan@gmail.com','871178178',null);

insert into extra(descricao) values
('Frigobar'),('Geladeira'),('Ar-condcionado'),('Ventialdor'),
('cama a água'),('Chuveiro elétrico'),('cama de casal'),
('Frigobar com bebidas'),('Hidromassagem'),('Banheiro com saln');

insert into quarto(diaria,acomodacoes) values
(70,2),(100,4),(500,5),(70,1),(150,3),(250,3),(300,6),(1000,10),(100,1),(120,2);

insert into quarto_extra (id_quarto,id_extra) values
(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);

insert into pedido (id_hospede,id_funcionario) values
(3,6),(4,1),(5,8),(6,3),(7,1),(8,1),(9,3),(10,8),(11,8),(12,8);

insert into reserva(id_hospede,id_quarto,id_funcionario,quant_dias) values
(3,3,2,5),(4,4,2,2),(5,5,2,10),(6,6,2,15),(7,7,2,30),(8,8,2,5),(9,9,2,7),(10,10,2,24),(11,11,2,20),(12,12,2,7);

insert into pagamento (id_reserva,valor) values
(1,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 1)),
(2,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 2)),
(5,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 5)),
(6,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 6)),
(7,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 7)),
(8,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 8)),
(9,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 9))
,(10,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 10)),
(11,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 11)),
(12,(select (r.quant_dias * q.diaria) total from quarto q, reserva r where q.id = r.id_quarto and q.id = 12));


insert into produto_pedido (id_produto,id_pedido,quantidade) values
(1,1,2),(2,2,5),(3,3,1),(4,4,4),(5,5,2),(6,6,3),(7,7,1),(8,8,1),(9,9,3),(10,10,4);