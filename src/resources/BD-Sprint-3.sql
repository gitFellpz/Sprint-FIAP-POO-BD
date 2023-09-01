--Criando Tabelas
CREATE TABLE usuario(
    cod_usuario     NUMBER(7)       CONSTRAINT usuario_pk PRIMARY KEY,
    primeiro_nome   VARCHAR2(15)    NOT NULL,
    meio_nome       VARCHAR2(15),
    ultimo_nome     VARCHAR2(15)    NOT NULL,
    email           VARCHAR2(25)    CONSTRAINT usuario_email_uk UNIQUE,
    cell            NUMBER(11)      NOT NULL
);

CREATE TABLE gestor(
    cod_gestor      NUMBER(7)       CONSTRAINT gestor_pk PRIMARY KEY,
    primeiro_nome   VARCHAR2(15)    NOT NULL,
    meio_nome       VARCHAR2(15)    NOT NULL,
    ultimo_nome     VARCHAR2(15)    NOT NULL,
    email           VARCHAR2(25)    CONSTRAINT gestor_email_uk UNIQUE,
    cell            NUMBER(11)      NOT NULL,
    depart          VARCHAR2(15)    NOT NULL
);
    
CREATE TABLE categoria(
    cod_categoria   Number(7)    CONSTRAINT categoria_pk PRIMARY KEY,
    nome            VARCHAR2(15) NOT NULL,
    descricao       VARCHAR2(40) NOT NULL
);
    
CREATE TABLE prioridade(
    cod_prioridade   Number(7)    CONSTRAINT prioridade_pk PRIMARY KEY,
    nome_prioridade  VARCHAR2(15) NOT NULL,
    desc_prioridade  VARCHAR2(40) NOT NULL
);
    
CREATE TABLE status_feedback(
    cod_status    Number(7)      CONSTRAINT status_feedback_pk PRIMARY KEY,
    nome_status   VARCHAR2(15)   NOT NULL,
    desc_status   VARCHAR2(40)   NOT NULL
);

CREATE TABLE resposta(
    cod_resposta        NUMBER(7)       CONSTRAINT resposta_pk PRIMARY KEY,
    mensagem_resposta   VARCHAR2(15)    NOT NULL,
    data_envio          DATE            NOT NULL,
    hora_envio          DATE            NOT NULL,

    cod_gestor          VARCHAR2(25),
    cod_feeedback       NUMBER(11)
);
    
CREATE TABLE feedback_(
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
    
CREATE TABLE historico(
    cod_historico        NUMBER(7)      CONSTRAINT historico_pk PRIMARY KEY,
    acao_realizada       VARCHAR(30)    NOT NULL,
    data_realizacao      DATE           NOT NULL,
    hora_realizacao      DATE           NOT NULL,

    cod_gestor           NUMBER(11), 
    cod_feeedback        NUMBER(7),
);

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




