DROP SEQUENCE usuario_sequence;
DROP TRIGGER tr_insert_cod_usuario;
DROP TABLE usuario;


DROP SEQUENCE categoria_sequence;
DROP TRIGGER tr_insert_cod_categoria;
DROP TABLE categoria;


DROP SEQUENCE prioridade_sequence;
DROP TRIGGER tr_insert_cod_prioridade;
DROP TABLE prioridade;


DROP SEQUENCE feedback_sequence;
DROP TRIGGER tr_insert_cod_feedback;
DROP TABLE feedback;

CREATE TABLE usuario(
    cod_usuario     NUMBER(7)       CONSTRAINT usuario_pk PRIMARY KEY,
    primeiro_nome   VARCHAR2(15)    NOT NULL,
    meio_nome       VARCHAR2(15),
    ultimo_nome     VARCHAR2(15)    NOT NULL,
    email           VARCHAR2(25)    CONSTRAINT usuario_email_uk UNIQUE,
);
    
CREATE TABLE categoria(
    cod_categoria   Number(7)    CONSTRAINT categoria_pk PRIMARY KEY,
    nome            VARCHAR2(15) NOT NULL,
    descricao       VARCHAR2(40) NOT NULL
);
    
CREATE TABLE prioridade(
    cod_prioridade   Number(7)    CONSTRAINT prioridade_pk PRIMARY KEY,
    nome             VARCHAR2(15) NOT NULL,
    descricao        VARCHAR2(40) NOT NULL
);
    
CREATE TABLE feedback(
    cod_feedback        NUMBER(7)       CONSTRAINT feedback_pk PRIMARY KEY,
    mensagem            VARCHAR(30)     NOT NULL,
    data_envio          DATE            NOT NULL,
    hora_envio          DATE            NOT NULL,
    likes               NUMBER(11)      NOT NULL,

    cod_categoria       Number(7),
    cod_usuario         NUMBER(7),    
    cod_prioridade      NUMBER(7),      
    cod_status          NUMBER(7) 
);

CREATE SEQUENCE usuario_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_insert_cod_usuario
BEFORE INSERT ON USUARIO FOR EACH ROW       
BEGIN
SELECT usuario_sequence.NEXTVAL
INTO :NEW.cod_usuario
FROM DUAL;
END;
/
COMMIT;


CREATE SEQUENCE categoria_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_insert_cod_categoria
BEFORE INSERT ON CATEGORIA FOR EACH ROW       
BEGIN
SELECT categoria_sequence.NEXTVAL
INTO :NEW.cod_categoria
FROM DUAL;
END;
/
COMMIT;


CREATE SEQUENCE prioridade_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_insert_cod_prioridade
BEFORE INSERT ON prioridade FOR EACH ROW       
BEGIN
SELECT prioridade_sequence.NEXTVAL
INTO :NEW.cod_prioridade
FROM DUAL;
END;
/
COMMIT;


CREATE SEQUENCE feedback_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_insert_cod_feedback
BEFORE INSERT ON feedback FOR EACH ROW       
BEGIN
SELECT feedback_sequence.NEXTVAL
INTO :NEW.cod_feedback
FROM DUAL;
END;
/
COMMIT;


ALTER TABLE historico
ADD CONSTRAINT hist_gestor_fk
FOREIGN KEY (cod_gestor)
REFERENCES gestor (cod_gestor);

ALTER TABLE historico
ADD CONSTRAINT hist_fbk_fk
FOREIGN KEY (cod_feedback)
REFERENCES feedback (cod_feedback);



ALTER TABLE feedback
ADD CONSTRAINT fbk_cat_fk
FOREIGN KEY (cod_categoria)
REFERENCES categoria (cod_categoria);

ALTER TABLE feedback
ADD CONSTRAINT fbk_usuario_fk
FOREIGN KEY (cod_usuario)
REFERENCES usuario (cod_usuario);

ALTER TABLE feedback
ADD CONSTRAINT fbk_prioridade_fk
FOREIGN KEY (cod_prioridade)
REFERENCES prioridade (cod_prioridade);

ALTER TABLE feedback
ADD CONSTRAINT fbk_status_fbk_fk
FOREIGN KEY (cod_status)
REFERENCES status_feedback (cod_status);



ALTER TABLE resposta
ADD CONSTRAINT resp_fbk_fk
FOREIGN KEY (cod_feedback)
REFERENCES feedback (cod_feedback);

ALTER TABLE resposta
ADD CONSTRAINT resp_gestor_fk
FOREIGN KEY (cod_gestor)
REFERENCES gestor (cod_gestor);




