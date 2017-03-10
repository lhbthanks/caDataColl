--第1个表防冻液表
/* Formatted on 2016/12/17 11:36:26 (QP5 v5.252.13127.32847) */
DROP TABLE T_ANTIFREEZE;

CREATE TABLE T_ANTIFREEZE
(
   ID                          NUMBER (11) NOT NULL,
   VIN_CODE                    VARCHAR2 (128 BYTE),
   CAR_TYPE                    VARCHAR2 (128 BYTE),
   MOBILE_UNIT                 VARCHAR2 (128 BYTE),
   FILLING_RESULT              VARCHAR2 (128 BYTE),
   DATA_TIME                   DATE,
   CORSE_VACUUM                VARCHAR2 (128 BYTE),
   CORSE_VACUUM_TIME           VARCHAR2 (128 BYTE),
   FINE_VACUUM                 VARCHAR2 (128 BYTE),
   FINE_VACUUM_TIME            VARCHAR2 (128 BYTE),
   VACUUM_LEAK                 VARCHAR2 (128 BYTE),
   VACUUM_LEAK_TIME            VARCHAR2 (128 BYTE),
   POST_VACUUM                 VARCHAR2 (128 BYTE),
   POST_VACUUM_TIME            VARCHAR2 (128 BYTE),
   FILLING_PRESSURE            VARCHAR2 (128 BYTE),
   FILLING_PRESSURE_TIME       VARCHAR2 (128 BYTE),
   FILLING1_HIGH_PRESSURE      VARCHAR2 (128 BYTE),
   F1HP_TIME                   VARCHAR2 (128 BYTE),
   FILLING_PRESSURE_LEAK       VARCHAR2 (128 BYTE),
   FPL_TIME                    VARCHAR2 (128 BYTE),
   FILLING_VOLUME              VARCHAR2 (128 BYTE),
   FILLING_VOLUME_TIME         VARCHAR2 (128 BYTE),
   FILLING_ADDITIONAL_VOLUME   VARCHAR2 (128 BYTE),
   FAV_TIME                    VARCHAR2 (128 BYTE),
   PROCESS_CYCLE_TIME          VARCHAR2 (128 BYTE),
   COL1                        VARCHAR2 (128 BYTE),
   COL2                        VARCHAR2 (128 BYTE),
   COL3                        VARCHAR2 (128 BYTE),
   COL4                        VARCHAR2 (128 BYTE),
   COL5                        VARCHAR2 (128 BYTE),
   COL6                        VARCHAR2 (128 BYTE)
);


COMMENT ON TABLE T_ANTIFREEZE IS '此表是防冻液表';

--增加T_ANTIFREEZE的序列
DROP SEQUENCE S_ANTIFREEZE;

CREATE SEQUENCE S_ANTIFREEZE START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加t_ANTIFREEZE的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_t_ANTIFREEZE
   BEFORE INSERT
   ON t_ANTIFREEZE
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_ANTIFREEZE.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/

ALTER TABLE T_ANTIFREEZE ADD (
  PRIMARY KEY
  (ID)  USING INDEX);


--第2个表杜尔刹车油表T_BRAKE_FLUID_DURR
drop table T_BRAKE_FLUID_DURR;

CREATE TABLE T_BRAKE_FLUID_DURR
(
  ID                     NUMBER (11)     NOT NULL,
  VIN_CODE               VARCHAR2(128 BYTE),
  CAR_TYPE               VARCHAR2(128 BYTE),
  MOBILE_UNIT            VARCHAR2(128 BYTE),
  FILLING_RESULT         VARCHAR2(128 BYTE),
  DATA_TIME                   DATE,
  CORSE_VACUUM           VARCHAR2(128 BYTE),
  CORSE_VACUUM_TIME      VARCHAR2(128 BYTE),
  FINE_VACUUM            VARCHAR2(128 BYTE),
  FINE_VACUUM_TIME       VARCHAR2(128 BYTE),
  VACUUM_LEAK            VARCHAR2(128 BYTE),
  VACUUM_LEAK_TIME       VARCHAR2(128 BYTE),
  POST_VACUUM            VARCHAR2(128 BYTE),
  POST_VACUUM_TIME       VARCHAR2(128 BYTE),
  FILLING_PRESSURE       VARCHAR2(128 BYTE),
  FILLING_PRESSURE_TIME  VARCHAR2(128 BYTE),
  FILLING_VOLUME         VARCHAR2(128 BYTE),
  FILLING_VOLUME_TIME    VARCHAR2(128 BYTE),
  PROCESS_CYCLE_TIME     VARCHAR2(128 BYTE),
  ABS_STATE              VARCHAR2(128 BYTE),
  COL1                   VARCHAR2(128 BYTE),
  COL2                   VARCHAR2(128 BYTE),
  COL3                   VARCHAR2(128 BYTE),
  COL4                   VARCHAR2(128 BYTE),
  COL5                   VARCHAR2(128 BYTE),
  COL6                   VARCHAR2(128 BYTE)
);

COMMENT ON TABLE T_BRAKE_FLUID_DURR IS '此表是杜尔刹车油表';

ALTER TABLE T_BRAKE_FLUID_DURR ADD (
  PRIMARY KEY
  (ID)  USING INDEX);

--增加T_BRAKE_FLUID_DURR的序列
DROP SEQUENCE S_BRAKE_FLUID_DURR;

CREATE SEQUENCE S_BRAKE_FLUID_DURR START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加T_BRAKE_FLUID_DURR的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_BRAKE_FLUID_DURR
   BEFORE INSERT
   ON T_BRAKE_FLUID_DURR
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_BRAKE_FLUID_DURR.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/
  

--第3个表易恒刹车油表T_BRAKE_FLUID_YH
drop table T_BRAKE_FLUID_YH;
CREATE TABLE T_BRAKE_FLUID_YH
(
  ID                   NUMBER (11)       NOT NULL,
  VIN_CODE             VARCHAR2(128 BYTE),
  CAR_TYPE             VARCHAR2(128 BYTE),
  MOBILE_UNIT          VARCHAR2(128 BYTE),
  FILLING_RESULT       VARCHAR2(128 BYTE),
  DATA_TIME                   DATE,
  CORSE_VACUUM         VARCHAR2(128 BYTE),
  CORSE_VACUUM_TIME    VARCHAR2(128 BYTE),
  FINE_VACUUM          VARCHAR2(128 BYTE),
  FINE_VACUUM_TIME     VARCHAR2(128 BYTE),
  VACUUM_LEAK          VARCHAR2(128 BYTE),
  VACUUM_LEAK_TIME     VARCHAR2(128 BYTE),
  POST_VACUUM          VARCHAR2(128 BYTE),
  POST_VACUUM_TIME     VARCHAR2(128 BYTE),
  FILLING_PRESSURE     VARCHAR2(128 BYTE),
  FILLING_VOLUME       VARCHAR2(128 BYTE),
  FILLING_VOLUME_TIME  VARCHAR2(128 BYTE),
  PROCESS_CYCLE_TIME  VARCHAR2(128 BYTE),
  COL1                 VARCHAR2(128 BYTE),
  COL2                 VARCHAR2(128 BYTE),
  COL3                 VARCHAR2(128 BYTE),
  COL4                 VARCHAR2(128 BYTE),
  COL5                 VARCHAR2(128 BYTE),
  COL6                 VARCHAR2(128 BYTE)
);

COMMENT ON TABLE T_BRAKE_FLUID_YH IS '此表是易恒刹车油';

ALTER TABLE T_BRAKE_FLUID_YH ADD (
  PRIMARY KEY
  (ID)  USING INDEX);

--增加T_BRAKE_FLUID_YH的序列
DROP SEQUENCE S_BRAKE_FLUID_YH;

CREATE SEQUENCE S_BRAKE_FLUID_YH START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加T_BRAKE_FLUID_YH的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_BRAKE_FLUID_YH
   BEFORE INSERT
   ON T_BRAKE_FLUID_YH
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_BRAKE_FLUID_YH.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/
  

--第4个表杜尔冷媒表T_COOLANT_DURR
drop table T_COOLANT_DURR;
CREATE TABLE T_COOLANT_DURR
(
  ID                   NUMBER (11)       NOT NULL,
  VIN_CODE             VARCHAR2(128 BYTE),
  CAR_TYPE             VARCHAR2(128 BYTE),
  MOBILE_UNIT          VARCHAR2(128 BYTE),
  FILLING_RESULT       VARCHAR2(128 BYTE),
  DATA_TIME                   DATE,
  OVER_PRESSURE        VARCHAR2(128 BYTE),
  OVER_PRESSURE_TIME   VARCHAR2(128 BYTE),
  CORSE_VACUUM         VARCHAR2(128 BYTE),
  CORSE_VACUUM_TIME    VARCHAR2(128 BYTE),
  FINE_VACUUM          VARCHAR2(128 BYTE),
  FINE_VACUUM_TIME     VARCHAR2(128 BYTE),
  VACUUM_LEAK          VARCHAR2(128 BYTE),
  VACUUM_LEAK_TIME     VARCHAR2(128 BYTE),
  POST_VACUUM          VARCHAR2(128 BYTE),
  POST_VACUUM_TIME     VARCHAR2(128 BYTE),
  FILLING_VOLUME       VARCHAR2(128 BYTE),
  FILLING_VOLUME_TIME  VARCHAR2(128 BYTE),
  PROCESS_CYCLE_TIME   VARCHAR2(128 BYTE),
  COL1                 VARCHAR2(128 BYTE),
  COL2                 VARCHAR2(128 BYTE),
  COL3                 VARCHAR2(128 BYTE),
  COL4                 VARCHAR2(128 BYTE),
  COL5                 VARCHAR2(128 BYTE),
  COL6                 VARCHAR2(128 BYTE)
);
COMMENT ON TABLE T_COOLANT_DURR IS '此表是杜尔冷媒';
ALTER TABLE T_COOLANT_DURR ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);

--增加T_COOLANT_DURR的序列
DROP SEQUENCE S_COOLANT_DURR;

CREATE SEQUENCE S_COOLANT_DURR START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加T_COOLANT_DURR的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_COOLANT_DURR
   BEFORE INSERT
   ON T_COOLANT_DURR
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_COOLANT_DURR.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/ 

--第5个表易恒冷媒表T_COOLANT_YH
drop table  T_COOLANT_YH;
CREATE TABLE T_COOLANT_YH
(
  ID                   NUMBER (11)       NOT NULL,
  VIN_CODE              VARCHAR2(128 BYTE),
  CAR_TYPE              VARCHAR2(128 BYTE),
  MOBILE_UNIT          VARCHAR2(128 BYTE),
  FILLING_RESULT       VARCHAR2(128 BYTE),
  DATA_TIME                   DATE,
  CORSE_VACUUM         VARCHAR2(128 BYTE),
  CORSE_VACUUM_TIME    VARCHAR2(128 BYTE),
  FINE_VACUUM          VARCHAR2(128 BYTE),
  FINE_VACUUM_TIME     VARCHAR2(128 BYTE),
  VACUUM_LEAK          VARCHAR2(128 BYTE),
  VACUUM_LEAK_TIME     VARCHAR2(128 BYTE),
  POST_VACUUM          VARCHAR2(128 BYTE),
  POST_VACUUM_TIME     VARCHAR2(128 BYTE),
  FILLING_PRESSURE     VARCHAR2(128 BYTE),
  FILLING_VOLUME       VARCHAR2(128 BYTE),
  FILLING_VOLUME_TIME  VARCHAR2(128 BYTE),
  PROCESS_CYCLE_TIME   VARCHAR2(128 BYTE),
  COL1                 VARCHAR2(128 BYTE),
  COL2                 VARCHAR2(128 BYTE),
  COL3                 VARCHAR2(128 BYTE),
  COL4                 VARCHAR2(128 BYTE),
  COL5                 VARCHAR2(128 BYTE),
  COL6                 VARCHAR2(128 BYTE)
);

COMMENT ON TABLE T_COOLANT_YH IS '此表是冷媒易恒';

ALTER TABLE T_COOLANT_YH ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);


--增加T_COOLANT_YH的序列
DROP SEQUENCE S_COOLANT_YH;

CREATE SEQUENCE S_COOLANT_YH START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加T_COOLANT_YH的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_COOLANT_YH
   BEFORE INSERT
   ON T_COOLANT_YH
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_COOLANT_YH.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/ 
  

--第6个表洗涤液表T_WASHINGS
drop table T_WASHINGS;
CREATE TABLE T_WASHINGS
(
  ID                   NUMBER (11)        NOT NULL,
  VIN_CODE             VARCHAR2(128 BYTE),
  CAR_TYPE             VARCHAR2(128 BYTE),
  MOBILE_UNIT          VARCHAR2(128 BYTE),
  FILLING_RESULT       VARCHAR2(128 BYTE),
  DATA_TIME                   DATE,
  FILLING_VOLUME       VARCHAR2(128 BYTE),
  FILLING_VOLUME_TIME  VARCHAR2(128 BYTE),
  PROCESS_CYCLE_TIME   VARCHAR2(128 BYTE),
  COL1                 VARCHAR2(128 BYTE),
  COL2                 VARCHAR2(128 BYTE),
  COL3                 VARCHAR2(128 BYTE),
  COL4                 VARCHAR2(128 BYTE),
  COL5                 VARCHAR2(128 BYTE),
  COL6                 VARCHAR2(128 BYTE)
);

COMMENT ON TABLE T_WASHINGS IS '此表是洗涤液表';
ALTER TABLE T_WASHINGS ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
  
--增加T_WASHINGS的序列
DROP SEQUENCE S_WASHINGS;

CREATE SEQUENCE S_WASHINGS START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加T_WASHINGS的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_WASHINGS
   BEFORE INSERT
   ON T_WASHINGS
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_WASHINGS.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/ 
  

--第7个表洗涤液表T_TIGHTEN_MACHINE
drop table T_TIGHTEN_MACHINE;
CREATE TABLE T_TIGHTEN_MACHINE
(
  ID          NUMBER(11)                NOT NULL,
  IDENTIFIER  VARCHAR2(128 BYTE),
  NODE        VARCHAR2(128 BYTE),
  TOOLTYPE    VARCHAR2(128 BYTE) ,
  RESULT      VARCHAR2(128 BYTE),
  DATERQ       DATE,           ---要注意区别mysql版本的Date类型与oracle版本的Date类型是不一样的
  TIME        VARCHAR2(128 BYTE),
  CHANNEL     NUMBER(11),
  PROGRAM     NUMBER(11),
  CYCLE       NUMBER(11),
  DATA1       VARCHAR2(128 BYTE),
  DATA2       VARCHAR2(128 BYTE),
  DATA3       VARCHAR2(128 BYTE),
  DATA4       VARCHAR2(128 BYTE),
  DATA5       VARCHAR2(128 BYTE),
  DATA6       VARCHAR2(128 BYTE),
  DATA7       VARCHAR2(128 BYTE),
  DATA8       VARCHAR2(128 BYTE),
  DATA9       VARCHAR2(128 BYTE),
  DATA10      VARCHAR2(128 BYTE),
  DATA11      VARCHAR2(128 BYTE),
  DATA12      VARCHAR2(128 BYTE),
  DATA13      VARCHAR2(128 BYTE),
  DUOP        VARCHAR2(128 BYTE),
  OP          VARCHAR2(128 BYTE),
  COL1        VARCHAR2(128 BYTE),
  COL2        VARCHAR2(128 BYTE),
  COL3        VARCHAR2(128 BYTE),
  COL4        VARCHAR2(128 BYTE),
  COL5        VARCHAR2(128 BYTE),
  COL6        VARCHAR2(128 BYTE)
);

COMMENT ON TABLE T_TIGHTEN_MACHINE IS '此表是拧紧机';

ALTER TABLE T_TIGHTEN_MACHINE ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
  
--增加T_TIGHTEN_MACHINE的序列
DROP SEQUENCE S_TIGHTEN_MACHINE;

CREATE SEQUENCE S_TIGHTEN_MACHINE START WITH 1
                             MAXVALUE 9999999999
                             MINVALUE 1
                             NOCYCLE
                             CACHE 20
                             ORDER;

--增加T_TIGHTEN_MACHINE的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_TIGHTEN_MACHINE
   BEFORE INSERT
   ON T_TIGHTEN_MACHINE
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_TIGHTEN_MACHINE.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/ 
  
--第8个表变速箱表T_TRANSMISSIONOIL
DROP TABLE T_TRANSMISSIONOIL CASCADE CONSTRAINTS;

CREATE TABLE  T_TRANSMISSIONOIL
(
  RECORDID        NUMBER(36)                    NOT NULL,
  DATETIME        DATE                          NOT NULL,
  ABON            NUMBER(3),
  VIN             VARCHAR2(20 BYTE),
  CARMODELCODE    VARCHAR2(30 BYTE),
  FCID            INTEGER                       NOT NULL,
  PRODUCTIONLINE  NUMBER(10),
  STATION         NUMBER(4),
  DATA1           VARCHAR2(100 BYTE),
  DATA2           VARCHAR2(100 BYTE),
  DATA3           VARCHAR2(100 BYTE),
  DATA4           VARCHAR2(100 BYTE),
  DATA5           VARCHAR2(100 BYTE),
  DATA6           VARCHAR2(100 BYTE),
  DATA7           VARCHAR2(100 BYTE),
  DATA8           VARCHAR2(100 BYTE),
  DATA9           VARCHAR2(100 BYTE),
  DATA10          VARCHAR2(100 BYTE),
  EVENTTYPE       VARCHAR2(20 BYTE)             NOT NULL
);

COMMENT ON TABLE T_transmissionoil IS '此表是变速箱';
ALTER TABLE T_transmissionoil ADD (
  PRIMARY KEY
  (RECORDID)
  USING INDEX);
  
--第9个表脱附检测表t_DETACHMENT
/* Formatted on 2016/12/15 20:38:13 (QP5 v5.136.908.31019) */
CREATE TABLE t_DETACHMENT
(
   DETACHMENTID   VARCHAR2 (50 BYTE) NOT NULL,
   T_ABON         VARCHAR2 (50 BYTE),
   T_VIN          VARCHAR2 (50 BYTE) NOT NULL,
   T_TYPE         VARCHAR2 (50 BYTE),
   T_DATE         DATE NOT NULL,
   T_TIME         DATE NOT NULL,
   T_RESULT       VARCHAR2 (50 BYTE),
   T_TP           VARCHAR2 (50 BYTE),
   T_FL           VARCHAR2 (50 BYTE),
   T_800P         VARCHAR2 (50 BYTE),
   T_800FL        VARCHAR2 (50 BYTE),
   T_1000P        VARCHAR2 (50 BYTE),
   T_1000FL       VARCHAR2 (50 BYTE),
   T_1500P        VARCHAR2 (50 BYTE),
   T_1500FL       VARCHAR2 (50 BYTE),
   T_2000P        VARCHAR2 (50 BYTE),
   T_2000FL       VARCHAR2 (50 BYTE),
   T_2500P        VARCHAR2 (50 BYTE),
   T_2500FL       VARCHAR2 (50 BYTE),
   T_3000P        VARCHAR2 (50 BYTE),
   T_3000FL       VARCHAR2 (50 BYTE),
   T_4000P        VARCHAR2 (50 BYTE),
   T_4000FL       VARCHAR2 (50 BYTE),
   T_POWER        VARCHAR2 (50 BYTE)
);

COMMENT ON TABLE t_DETACHMENT IS '此表是脱附检测';
ALTER TABLE t_DETACHMENT ADD (
  PRIMARY KEY
  (DETACHMENTID)
  USING INDEX);

--第10个表燃油气密表表t_AIRTIGHT_CHECK
/* Formatted on 2016/12/15 20:36:35 (QP5 v5.136.908.31019) */
CREATE TABLE t_AIRTIGHT_CHECK
(
   AIRTIGHTID   VARCHAR2 (50 BYTE) NOT NULL,
   R_ABON       VARCHAR2 (50 BYTE),
   R_VIN        VARCHAR2 (50 BYTE) NOT NULL,
   R_TYPE       VARCHAR2 (50 BYTE),
   R_DATE       DATE NOT NULL,
   R_TIME       DATE NOT NULL,
   R_QMTP       VARCHAR2 (50 BYTE),
   R_QMTD       VARCHAR2 (50 BYTE),
   R_QMDR       VARCHAR2 (50 BYTE),
   R_TQTP       VARCHAR2 (50 BYTE),
   R_TQTD       VARCHAR2 (50 BYTE),
   R_TQDR       VARCHAR2 (50 BYTE),
   R_POWER      VARCHAR2 (50 BYTE)
);

COMMENT ON TABLE t_AIRTIGHT_CHECK IS '此表是燃油气密表';

ALTER TABLE t_AIRTIGHT_CHECK ADD (
  PRIMARY KEY
  (AIRTIGHTID)
  USING INDEX);

/* Formatted on 2016/12/20 19:44:16 (QP5 v5.252.13127.32847) */
--第11个表A301表

CREATE TABLE t_a301
(
   ID         NUMBER (11) NOT NULL,
   VIN        VARCHAR2 (128 BYTE),
   AB_ON      VARCHAR2 (128 BYTE) NOT NULL,
   DATATime   DATE NOT NULL,
   time       DATE NOT NULL,
   BCM        VARCHAR2 (128 BYTE),
   IPC        VARCHAR2 (128 BYTE),
   EMS        VARCHAR2 (128 BYTE),
   ABS        VARCHAR2 (128 BYTE),
   TCM        VARCHAR2 (128 BYTE),
   SRS        VARCHAR2 (128 BYTE),
   RESULT     VARCHAR2 (128 BYTE)
);

ALTER TABLE t_a301 ADD (
  PRIMARY KEY
  (id)
  USING INDEX);

  --增加T_a301的序列
DROP SEQUENCE S_a301;

CREATE SEQUENCE S_a301 START WITH 1
                       MAXVALUE 9999999999
                       MINVALUE 1
                       NOCYCLE
                       CACHE 20
                       ORDER;

--增加T_a301的触发器，自动增加ID序列

CREATE OR REPLACE TRIGGER trig_T_a301
   BEFORE INSERT
   ON T_a301
   FOR EACH ROW
DECLARE
   integrity_error   EXCEPTION;
   errno             INTEGER;
   errmsg            CHAR (200);
   dummy             INTEGER;
   FOUND             BOOLEAN;
BEGIN
   --  Column "RecordId" uses sequence S_FCRecord
   SELECT S_a301.NEXTVAL INTO :new.ID FROM DUAL;
--  Errors handling
EXCEPTION
   WHEN integrity_error
   THEN
      raise_application_error (errno, errmsg);
END;
/