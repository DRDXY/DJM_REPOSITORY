/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/10/17 15:44:34                          */
/*==============================================================*/


--alter table R_ROLE_AUTHORITY drop constraint FK_R_ROLE_A_REFERENCE_T_ROLE_I;

--alter table R_ROLE_AUTHORITY drop constraint FK_R_ROLE_A_REFERENCE_T_AUTHOR;

--alter table R_USER_ROLE drop constraint FK_R_USER_R_REFERENCE_T_USER_I;

--alter table R_USER_ROLE drop constraint FK_R_USER_R_REFERENCE_T_ROLE_I;

--drop table R_ROLE_AUTHORITY cascade constraints;

--drop table R_USER_ROLE cascade constraints;

--drop table T_AUTHORITY_INFO cascade constraints;

--drop table T_ROLE_INFO cascade constraints;

--drop table T_USER_INFO cascade constraints;

/*==============================================================*/
/* Table: R_ROLE_AUTHORITY                                      */
/*==============================================================*/
create table R_ROLE_AUTHORITY 
(
   ID                   INTEGER              not null,
   AUTHORITYID          INTEGER              not null,
   ROLEID               INTEGER              not null,
   CREATETIME           DATE                 not null,
   UPDATETIME           DATE                 not null,
   constraint PK_R_ROLE_AUTHORITY primary key (ID)
);

comment on column R_ROLE_AUTHORITY.AUTHORITYID is
'�û����';

comment on column R_ROLE_AUTHORITY.ROLEID is
'��ɫ���';

/*==============================================================*/
/* Table: R_USER_ROLE                                           */
/*==============================================================*/
create table R_USER_ROLE 
(
   ID                   INTEGER              not null,
   USERID               INTEGER              not null,
   ROLEID               INTEGER              not null,
   CREATETIME           DATE                 not null,
   UPDATETIME           DATE                 not null,
   constraint PK_R_USER_ROLE primary key (ID)
);

comment on column R_USER_ROLE.USERID is
'�û����';

comment on column R_USER_ROLE.ROLEID is
'��ɫ���';

/*==============================================================*/
/* Table: T_AUTHORITY_INFO                                      */
/*==============================================================*/
create table T_AUTHORITY_INFO 
(
   ID                   INTEGER              not null,
   AUTHORITYNAME        VARCHAR(50)          not null,
   COMM                 VARCHAR(200),
   CREATETIME           DATE                 not null,
   UPDATETIME           DATE                 not null,
   constraint PK_T_AUTHORITY_INFO primary key (ID)
);

/*==============================================================*/
/* Table: T_ROLE_INFO                                           */
/*==============================================================*/
create table T_ROLE_INFO 
(
   ID                   INTEGER              not null,
   ROLENAME             VARCHAR2(30 CHAR)    not null,
   DESCRIBE             VARCHAR2(60 CHAR)    not null,
   CREATETIME           DATE                 not null,
   UPDATETIME           DATE                 not null,
   constraint PK_T_ROLE_INFO primary key (ID)
);

comment on column T_ROLE_INFO.ID is
'���';

comment on column T_ROLE_INFO.ROLENAME is
'�û���';

comment on column T_ROLE_INFO.DESCRIBE is
'����';

comment on column T_ROLE_INFO.CREATETIME is
'����ʱ��';

comment on column T_ROLE_INFO.UPDATETIME is
'����ʱ��';

/*==============================================================*/
/* Table: T_USER_INFO                                           */
/*==============================================================*/
create table T_USER_INFO 
(
   ID                   INTEGER              not null,
   USERNAME             VARCHAR2(30 CHAR)    not null,
   TELEPHONE            VARCHAR2(15 CHAR)    not null,
   CREATETIME           DATE                 not null,
   UPDATETIME           DATE                 not null,
   ISENABLE             NUMBER(1)            not null,
   constraint PK_T_USER_INFO primary key (ID)
);

comment on column T_USER_INFO.ID is
'���';

comment on column T_USER_INFO.USERNAME is
'�û���';

comment on column T_USER_INFO.TELEPHONE is
'��ϵ�绰';

comment on column T_USER_INFO.CREATETIME is
'����ʱ��';

comment on column T_USER_INFO.UPDATETIME is
'����ʱ��';

comment on column T_USER_INFO.ISENABLE is
'�Ƿ�����,0����,1����';

ALTER TABLE T_USER_INFO
ADD ( PASSWORD VARCHAR2(256 CHAR) DEFAULT ''  NOT NULL  ) ;

COMMENT ON COLUMN T_USER_INFO.PASSWORD IS '�û���¼����';



alter table R_ROLE_AUTHORITY
   add constraint FK_R_ROLE_A_REFERENCE_T_ROLE_I foreign key (ROLEID)
      references T_ROLE_INFO (ID);

alter table R_ROLE_AUTHORITY
   add constraint FK_R_ROLE_A_REFERENCE_T_AUTHOR foreign key (AUTHORITYID)
      references T_AUTHORITY_INFO (ID);

alter table R_USER_ROLE
   add constraint FK_R_USER_R_REFERENCE_T_USER_I foreign key (USERID)
      references T_USER_INFO (ID);

alter table R_USER_ROLE
   add constraint FK_R_USER_R_REFERENCE_T_ROLE_I foreign key (ROLEID)
      references T_ROLE_INFO (ID);
	  
--��������
CREATE SEQUENCE TUI_SEQ MINVALUE 1 NOMAXVALUE START WITH 1 INCREMENT BY 1 NOCACHE;

--����������
CREATE OR REPLACE TRIGGER TUI_TRI
BEFORE INSERT ON T_USER_INFO 
FOR EACH ROW
BEGIN
	SELECT
		TUI_SEQ.nextval INTO :NEW.ID
	FROM
		DUAL;
END ;
--����Ȩ�ޱ�--END-----------------------------------------------------------------


--��������
CREATE SEQUENCE TRI_SEQ MINVALUE 1 NOMAXVALUE START WITH 1 INCREMENT BY 1 NOCACHE;

--����������
CREATE OR REPLACE TRIGGER TRI_TRI
BEFORE INSERT ON T_ROLE_INFO 
FOR EACH ROW
BEGIN
	SELECT
		TRI_SEQ.nextval INTO :NEW.ID
	FROM
		DUAL;
END ;
--����Ȩ�ޱ�--END-----------------------------------------------------------------


--��������
CREATE SEQUENCE TAI_SEQ MINVALUE 1 NOMAXVALUE START WITH 1 INCREMENT BY 1 NOCACHE;

--����������
CREATE OR REPLACE TRIGGER TAI_TRI
BEFORE INSERT ON T_AUTHORITY_INFO 
FOR EACH ROW
BEGIN
	SELECT
		TAI_SEQ.nextval INTO :NEW.ID
	FROM
		DUAL;
END ;
--����Ȩ�ޱ�--END-----------------------------------------------------------------


--��������
CREATE SEQUENCE RRA_SEQ MINVALUE 1 NOMAXVALUE START WITH 1 INCREMENT BY 1 NOCACHE;

--����������
CREATE OR REPLACE TRIGGER RRA_TRI
BEFORE INSERT ON R_ROLE_AUTHORITY 
FOR EACH ROW
BEGIN
	SELECT
		RRA_SEQ.nextval INTO :NEW.ID
	FROM
		DUAL;
END ;
--����Ȩ�ޱ�--END-----------------------------------------------------------------


--��������
CREATE SEQUENCE RUR_SEQ MINVALUE 1 NOMAXVALUE START WITH 1 INCREMENT BY 1 NOCACHE;

--����������
CREATE OR REPLACE TRIGGER RUR_TRI
BEFORE INSERT ON R_USER_ROLE 
FOR EACH ROW
BEGIN
	SELECT
		RUR_SEQ.nextval INTO :NEW.ID
	FROM
		DUAL;
END ;
--����Ȩ�ޱ�--END-----------------------------------------------------------------


ALTER TABLE T_ROLE_INFO ADD CONSTRAINT U_ROLENAME UNIQUE (ROLENAME);
ALTER TABLE T_USER_INFO ADD CONSTRAINT U_USERNAME UNIQUE (USERNAME);
ALTER TABLE R_ROLE_AUTHORITY ADD CONSTRAINT U_AUTH_ROLE UNIQUE (AUTHORITYID, ROLEID);
ALTER TABLE R_USER_ROLE ADD CONSTRAINT U_USER_ROLE UNIQUE (USERID, ROLEID);


ALTER TABLE T_AUTHORITY_INFO
ADD ( INTERCEPTURL VARCHAR2(200 CHAR) DEFAULT ''  NOT NULL  ) 
ADD ( ACCESSAUTH VARCHAR2(60 CHAR) DEFAULT 'IS_AUTHENTICATED_ANONYMOUSLY'  NOT NULL  ) ;
COMMENT ON COLUMN T_AUTHORITY_INFO.INTERCEPTURL IS '拦截URL';
COMMENT ON COLUMN T_AUTHORITY_INFO.ACCESSAUTH IS '访问权限';
