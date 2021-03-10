/*INSERT TABLE ESTADO*/
INSERT INTO ESTADO(NOME,SIGLA) VALUES ('PARANA', 'PR');
INSERT INTO ESTADO(NOME,SIGLA) VALUES ('SÃO PAULO', 'SP');
INSERT INTO ESTADO(NOME,SIGLA) VALUES ('SANTA CATARINA', 'SC');

/*INSERT TABLE CIDADE*/
INSERT INTO CIDADE(NOME, ESTADO_ID) VALUES ('ARARUNA', 1);
INSERT INTO CIDADE(NOME, ESTADO_ID) VALUES ('CAMPO MOURÃO', 1);
INSERT INTO CIDADE(NOME, ESTADO_ID) VALUES ('SÃO PAULO', 2);
INSERT INTO CIDADE(NOME, ESTADO_ID) VALUES ('JOINVILLE', 3);

/*INSERT TABLE USUARIO*/
INSERT INTO USUARIO(CPF_CNPJ,DATA_NASCIMENTO,NOME,STATUS) VALUES ('12345678912', '1999-04-04', 'JOAO PAULO', 'ATIVO');
INSERT INTO USUARIO(CPF_CNPJ,DATA_NASCIMENTO,NOME,STATUS) VALUES ('32165498733', '1987-05-04', 'PEDRO ALBUQUERQUE', 'ATIVO');
INSERT INTO USUARIO(CPF_CNPJ,DATA_NASCIMENTO,NOME,STATUS) VALUES ('45678912345', '1991-12-04', 'PATRICIA DA SILVA', 'ATIVO');

/*INSERT TABLE ENDERECO*/
INSERT INTO ENDERECO(BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,CIDADE_ID,USUARIO_ID) VALUES ('JARDIM ALESSIA', '87260000', NULL, 'R. AVELINO HANEL', '6', 1, 1);
INSERT INTO ENDERECO(BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,CIDADE_ID,USUARIO_ID) VALUES ('CENTRO', '87260000', NULL, 'AV. PRESIDENTE VARGAS', '280 B', 1, 2);
INSERT INTO ENDERECO(BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,CIDADE_ID,USUARIO_ID) VALUES ('CENTRO', '87300380', NULL, 'R. HARISSON JOSÉ BORGES', '832', 2, 3);
INSERT INTO ENDERECO(BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,CIDADE_ID,USUARIO_ID) VALUES ('JARDIM ALESSIA', '87260000', NULL, 'TIMBURI', '12', 1, 1);
//INSERT INTO ENDERECO(BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,CIDADE_ID,USUARIO_ID) VALUES ('JARDIM ALESSIA', '87260000', NULL, 'AVELINO HANEL', '6', 1, NULL);

