DROP TABLE IF EXISTS public.emecMemoriaCalculo CASCADE;
CREATE TABLE public.emecMemoriaCalculo (
	cdMemoriaCalculo DECIMAL(10,0) NOT NULL UNIQUE,
	cdTabela DECIMAL(10,0) NULL,
	dtGeracao TIMESTAMP WITHOUT TIME ZONE NULL,
	dtInclusao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	cdUsuarioInclusao varchar(50) NOT NULL,
	dtAlteracao TIMESTAMP WITHOUT TIME ZONE NULL,
	cdUsuarioAlteracao varchar(50) NULL,
	CONSTRAINT emecMemoriaCalculo_pk PRIMARY KEY (cdMemoriaCalculo)
) WITH (
  OIDS=FALSE
);


DROP TABLE IF EXISTS public.emecItemMemoria CASCADE;
CREATE TABLE public.emecItemMemoria (
	cdMemoriaItem DECIMAL(10,0) NOT NULL,
	cdServicoMemoria DECIMAL(10,0) NOT NULL,
	deMemoria varchar(255) NOT NULL,
	deEquacao varchar(50) NOT NULL,
	vlResultado DECIMAL(10,4) NOT NULL,
	deObservacao varchar(255) NOT NULL,
	jsonColunas TEXT NOT NULL,
	dtInclusao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	cdUsuarioInclusao varchar(50) NOT NULL,
	dtAlteracao TIMESTAMP WITHOUT TIME ZONE NULL,
	cdUsuarioAlteracao varchar(50) NULL,
	CONSTRAINT emecItemMemoria_pk PRIMARY KEY (cdMemoriaItem)
) WITH (
  OIDS=FALSE
);


DROP TABLE IF EXISTS public.emecColunasMemoria CASCADE;
CREATE TABLE public.emecColunasMemoria (
	cdMemoriaCalculo DECIMAL(10,0) NOT NULL,
	cdColuna varchar(5) NOT NULL,
	deColuna varchar(30) NOT NULL,
	cdOrdem DECIMAL(4,0) NOT NULL,
	dtInclusao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	cdUsuarioInclusao varchar(50) NOT NULL,
	dtAlteracao TIMESTAMP WITHOUT TIME ZONE NULL,
	cdUsuarioAlteracao varchar(50) NULL,
	CONSTRAINT emecColunasMemoria_pk PRIMARY KEY (cdMemoriaCalculo)
) WITH (
  OIDS=FALSE
);


DROP TABLE IF EXISTS public.emecConfigMemoria CASCADE;
CREATE TABLE public.emecConfigMemoria (
	cdMemoriaCalculo DECIMAL(10,0) NOT NULL UNIQUE,
	cdChave varchar(50) NOT NULL,
	cdValor varchar(50) NOT NULL,
	dtInclusao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	cdUsuarioInclusao varchar(50) NOT NULL,
	dtAlteracao TIMESTAMP WITHOUT TIME ZONE NULL,
	cdUsuarioAlteracao varchar(50) NULL,
	CONSTRAINT emecConfigMemoria_pk PRIMARY KEY (cdMemoriaCalculo)
) WITH (
  OIDS=FALSE
);


DROP TABLE IF EXISTS public.emecGrupoMemoria CASCADE;
CREATE TABLE public.emecGrupoMemoria (
	cdGrupoMemoria DECIMAL(10,0) NOT NULL UNIQUE,
	cdMemoriaCalculo DECIMAL(10,0) NOT NULL,
	cdOrdem DECIMAL(4,0) NOT NULL,
	deGrupoMemoria varchar(150) NOT NULL,
	cdPai DECIMAL(10,0) NULL,
	dtInclusao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	cdUsuarioInclusao varchar(50) NOT NULL,
	dtAlteracao TIMESTAMP WITHOUT TIME ZONE NULL,
	cdUsuarioAlteracao varchar(50) NULL,
	CONSTRAINT emecGrupoMemoria_pk PRIMARY KEY (cdGrupoMemoria)
) WITH (
  OIDS=FALSE
);

DROP TABLE IF EXISTS public.emecServicoMemoria CASCADE;
CREATE TABLE public.emecServicoMemoria (
	cdServicoMemoria DECIMAL(10,0) NOT NULL,
	cdGrupoMemoria DECIMAL(10,0) NOT NULL,
	cdTabela DECIMAL(10,0) NULL,
	cdInsumo DECIMAL(10,0) NULL,
	cdOrdem DECIMAL(4,0) NOT NULL,
	deServico varchar(1000) NULL,
	qtQuantidade DECIMAL(10,4) NULL,
	deUnidMedida varchar(6) NULL,
	dtInclusao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	cdUsuarioInclusao varchar(50) NOT NULL,
	dtAlteracao TIMESTAMP WITHOUT TIME ZONE NULL,
	cdUsuarioAlteracao varchar(50) NULL,
	CONSTRAINT emecServicoMemoria_pk PRIMARY KEY (cdServicoMemoria)
) WITH (
  OIDS=FALSE
);

ALTER TABLE public.emecItemMemoria ADD CONSTRAINT emecItemMemoria_fk0 FOREIGN KEY (cdServicoMemoria) REFERENCES public.emecServicoMemoria(cdServicoMemoria);
ALTER TABLE public.emecColunasMemoria ADD CONSTRAINT emecColunasMemoria_fk0 FOREIGN KEY (cdMemoriaCalculo) REFERENCES public.emecMemoriaCalculo(cdMemoriaCalculo);
ALTER TABLE public.emecConfigMemoria ADD CONSTRAINT emecConfigMemoria_fk0 FOREIGN KEY (cdMemoriaCalculo) REFERENCES public.emecMemoriaCalculo(cdMemoriaCalculo);
ALTER TABLE public.emecGrupoMemoria ADD CONSTRAINT emecGrupoMemoria_fk0 FOREIGN KEY (cdMemoriaCalculo) REFERENCES public.emecMemoriaCalculo(cdMemoriaCalculo);
ALTER TABLE public.emecGrupoMemoria ADD CONSTRAINT emecGrupoMemoria_fk1 FOREIGN KEY (cdPai) REFERENCES public.emecGrupoMemoria(cdGrupoMemoria);
ALTER TABLE public.emecServicoMemoria ADD CONSTRAINT emecServicoMemoria_fk0 FOREIGN KEY (cdGrupoMemoria) REFERENCES public.emecGrupoMemoria(cdGrupoMemoria);



insert into emecMemoriaCalculo (cdmemoriacalculo, cdtabela, dtinclusao, cdusuarioinclusao)
values 
	(1, 5401001, current_timestamp, 'SIDER'),
	(2, 5401002, current_timestamp, 'SIDER');

insert into emecGrupoMemoria (cdgrupomemoria, cdmemoriacalculo, cdordem, degrupomemoria, cdpai, dtinclusao, cdusuarioinclusao)
values 
	--orcamento 1
	(1,1,1,'grupo 01 m1', null, current_timestamp, 'SIDER'),
	(2,1,2,'grupo 02 m1', null, current_timestamp, 'SIDER'),
	(3,1,3,'grupo 03 m1', null, current_timestamp, 'SIDER'),
	(4,1,4,'grupo 04 m1', null, current_timestamp, 'SIDER'),
	--orcamento 2
	(5,2,1,'grupo 01 m2', null, current_timestamp, 'SIDER'),	
	(6,2,2,'grupo 02 m2', null, current_timestamp, 'SIDER'),
	(7,2,3,'grupo 03 m2', null, current_timestamp, 'SIDER'),
	(8,2,4,'grupo 04 m2', null, current_timestamp, 'SIDER');

insert into emecGrupoMemoria (cdgrupomemoria, cdmemoriacalculo, cdordem, degrupomemoria, cdpai, dtinclusao, cdusuarioinclusao)
values 
	--orcamento 1
	(9, 1,1,'sub grupo 01.01 m1', 1, current_timestamp, 'SIDER'),
	(10,1,1,'sub grupo 02.01 m1', 2, current_timestamp, 'SIDER'),
	(11,1,1,'sub grupo 03.01 m1', 3, current_timestamp, 'SIDER'),
	(12,1,1,'sub grupo 04.01 m1', 4, current_timestamp, 'SIDER'),
	(13,1,2,'sub grupo 04.02 m1', 4, current_timestamp, 'SIDER'),
	(14,1,3,'sub grupo 04.03 m1', 4, current_timestamp, 'SIDER'),
	--orcamento 2
	(15,2,1,'sub grupo 01.01 m2', 5, current_timestamp, 'SIDER'),	
	(16,2,1,'sub grupo 02.01 m2', 6, current_timestamp, 'SIDER'),
	(17,2,1,'sub grupo 03.01 m2', 7, current_timestamp, 'SIDER'),
	(18,2,1,'sub grupo 04.01 m2', 8, current_timestamp, 'SIDER'),
	(19,2,2,'sub grupo 04.02 m2', 8, current_timestamp, 'SIDER'),
	(20,2,3,'sub grupo 04.03 m2', 8, current_timestamp, 'SIDER');	

insert into emecServicoMemoria (cdservicomemoria, cdgrupomemoria, cdtabela, cdinsumo, cdordem, deservico, qtquantidade, deunidmedida,
	    dtinclusao, cdusuarioinclusao)
values
	--orcamento 1 - grupo
	(1, 1, null, null, 1, 'servico grupo 01 m1', 10, 'm2', current_timestamp, 'SIDER'),
	(2, 2, null, null, 1, 'servico grupo 02 m1', 10, 'm2', current_timestamp, 'SIDER'),
	(3, 3, null, null, 1, 'servico grupo 03 m1', 10, 'm2', current_timestamp, 'SIDER'),
	(4, 4, null, null, 1, 'servico grupo 04 m1 o1', 10, 'm2', current_timestamp, 'SIDER'),
	(5, 4, null, null, 2, 'servico grupo 04 m1 o2', 10, 'm2', current_timestamp, 'SIDER'),
	
	--orcamento 2 - grupo
	(6, 5, null, null, 1, 'servico grupo 01 m2', 10, 'm2', current_timestamp, 'SIDER'),
	(7, 6, null, null, 1, 'servico grupo 02 m2', 10, 'm2', current_timestamp, 'SIDER'),
	(8, 7, null, null, 1, 'servico grupo 03 m2', 10, 'm2', current_timestamp, 'SIDER'),
	(9, 8, null, null, 1, 'servico grupo 04 m2 o1', 10, 'm2', current_timestamp, 'SIDER'),
	(10,8, null, null, 2, 'servico grupo 04 m2 o2', 10, 'm2', current_timestamp, 'SIDER'),

	--orcamento 1 - grupo - subgrupo
	(11, 9, null, null, 1, 'servico subgrupo 01 m1', 10, 'm2', current_timestamp, 'SIDER'),
	(12,10, null, null, 1, 'servico subgrupo 02 m1', 10, 'm2', current_timestamp, 'SIDER'),
	(13,11, null, null, 1, 'servico subgrupo 03 m1', 10, 'm2', current_timestamp, 'SIDER'),
	(14,12, null, null, 1, 'servico subgrupo 04 m1 o1', 10, 'm2', current_timestamp, 'SIDER'),
	(15,12, null, null, 2, 'servico subgrupo 04 m1 o2', 10, 'm2', current_timestamp, 'SIDER'),
	
	--orcamento 2 - grupo - subgrupo
	(16, 13, null, null, 1, 'servico subgrupo 01 m2', 10, 'm2', current_timestamp, 'SIDER'),
	(17, 14, null, null, 1, 'servico subgrupo 02 m2', 10, 'm2', current_timestamp, 'SIDER'),
	(18, 15, null, null, 1, 'servico subgrupo 03 m2', 10, 'm2', current_timestamp, 'SIDER'),
	(19, 16, null, null, 1, 'servico subgrupo 04 m2 o1', 10, 'm2', current_timestamp, 'SIDER'),
	(20, 16, null, null, 2, 'servico subgrupo 04 m2 o2', 10, 'm2', current_timestamp, 'SIDER');
	

select * from emecMemoriaCalculo;
select * from emecGrupoMemoria;
select * from emecServicoMemoria;
select * from emecItemMemoria;
select * from emecConfigMemoria;
select * from emecColunasMemoria;


select 
	grupo.cdmemoriacalculo,
	grupo.cdgrupomemoria,
	grupo.degrupomemoria,
	grupo.cdordem,
	mc.cdtabela,
	'descricao da versao do orcamento' as  dememoria
from 
	emecGrupoMemoria grupo
	join emecMemoriaCalculo mc on grupo.cdmemoriacalculo = mc.cdmemoriacalculo
where
	mc.cdtabela = 5401001
	and coalesce(grupo.cdpai,0) = 0;





select
	gm.cdordem, gm.degrupomemoria, gm.cdpai,
	subgm.cdordem, subgm.degrupomemoria, subgm.cdpai
from
	emecgrupomemoria gm
	left join emecgrupomemoria subgm on subgm.cdpai = gm.cdgrupomemoria
where
	gm.cdmemoriacalculo = 1
	and coalesce(gm.cdpai,0) = 0;