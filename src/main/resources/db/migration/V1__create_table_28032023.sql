-- Tabela User
create table tb_user (
    id serial,
    name_user varchar(30) NULL,
    taxpayernumber varchar(12) NULL,
    PRIMARY KEY (id)
);

-- -- Table Endereco
-- create table tb_address (
--   id int not null,
--   city varchar(12),
--   street varchar(15),
--   number numeric(6),
--   state varchar(2),
--   country varchar(10),
--   constraint addres_pkey primary key (id)
-- );