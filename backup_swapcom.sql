prompt PL/SQL Developer Export User Objects for user SWAPCOM@SWAPCOM_UAT
prompt Created by LHDung on Thursday, October 3, 2024
set define off
spool backup_swapcom.log

prompt
prompt Creating table APPDEPARTMENT
prompt ============================
prompt
create table SWAPCOM.APPDEPARTMENT
(
  department_id   NUMBER(19) not null,
  dep_address     VARCHAR2(255 CHAR),
  dep_description VARCHAR2(255 CHAR),
  dep_name        VARCHAR2(255 CHAR),
  phone           VARCHAR2(255 CHAR),
  rate_code       VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPDEPARTMENT
  add primary key (DEPARTMENT_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table APPEOD
prompt =====================
prompt
create table SWAPCOM.APPEOD
(
  eod_time      VARCHAR2(255 CHAR) not null,
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  eod_code      VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPEOD
  add primary key (EOD_TIME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table REVINFO
prompt ======================
prompt
create table SWAPCOM.REVINFO
(
  rev      NUMBER(10) not null,
  revtstmp NUMBER(19)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.REVINFO
  add primary key (REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table APPEOD_AUD
prompt =========================
prompt
create table SWAPCOM.APPEOD_AUD
(
  eod_time      VARCHAR2(255 CHAR) not null,
  rev           NUMBER(10) not null,
  revtype       NUMBER(3),
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  eod_code      VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPEOD_AUD
  add primary key (EOD_TIME, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPEOD_AUD
  add constraint FK38IA3461VW9YCTA4U2A64JFLP foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table APPROLE
prompt ======================
prompt
create table SWAPCOM.APPROLE
(
  rolename    VARCHAR2(255 CHAR) not null,
  description VARCHAR2(255 CHAR),
  isactive    VARCHAR2(255 CHAR),
  status      VARCHAR2(20 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPROLE
  add primary key (ROLENAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table APPUSER
prompt ======================
prompt
create table SWAPCOM.APPUSER
(
  username VARCHAR2(255 CHAR) not null,
  isactive VARCHAR2(255 CHAR),
  password VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPUSER
  add primary key (USERNAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table APPUSERINFO
prompt ==========================
prompt
create table SWAPCOM.APPUSERINFO
(
  username      VARCHAR2(255 CHAR) not null,
  department_id NUMBER(19),
  email         VARCHAR2(255 CHAR),
  fullname      VARCHAR2(255 CHAR),
  limit_id      VARCHAR2(255 CHAR),
  phone         VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPUSERINFO
  add primary key (USERNAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table APPUSERROLE
prompt ==========================
prompt
create table SWAPCOM.APPUSERROLE
(
  rolename VARCHAR2(255 CHAR) not null,
  username VARCHAR2(255 CHAR) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.APPUSERROLE
  add primary key (ROLENAME, USERNAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SACCOUNT
prompt =======================
prompt
create table SWAPCOM.SACCOUNT
(
  acc_no   VARCHAR2(22),
  acc_desc VARCHAR2(100),
  acc_type VARCHAR2(1)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SWAPCOM.SACCOUNT.acc_type
  is 'B; MUA ; S: BAN; R: DOI UNG';
create unique index SWAPCOM.SACC_ACCNO_IDX on SWAPCOM.SACCOUNT (ACC_NO)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SACCOUNTING
prompt ==========================
prompt
create table SWAPCOM.SACCOUNTING
(
  entry_no        VARCHAR2(10) not null,
  trans_no        VARCHAR2(50) not null,
  branch_id       VARCHAR2(5),
  dept_id         VARCHAR2(6),
  product         VARCHAR2(10),
  debit_acc_no    VARCHAR2(22),
  debit_acc_name  VARCHAR2(100),
  credit_acc_no   VARCHAR2(22),
  credit_acc_name VARCHAR2(100),
  trans_content   VARCHAR2(500),
  trans_date      VARCHAR2(10),
  currency        VARCHAR2(3),
  amount          NUMBER(21,2),
  batch_type      VARCHAR2(1),
  trans_type      VARCHAR2(5)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SWAPCOM.SACCOUNTING.batch_type
  is 'B: dau thang; D: hang ngay; E: cuoi thang';

prompt
prompt Creating table SACCOUNTING_CONTENT
prompt ==================================
prompt
create table SWAPCOM.SACCOUNTING_CONTENT
(
  customer_type VARCHAR2(1),
  buy_sell      VARCHAR2(1),
  batch_period  VARCHAR2(1),
  acc_content   VARCHAR2(70),
  trans_type    VARCHAR2(5)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SBATCHLOG
prompt ========================
prompt
create table SWAPCOM.SBATCHLOG
(
  id         NUMBER,
  message    VARCHAR2(4000),
  created_on TIMESTAMP(6)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SBRANCH
prompt ======================
prompt
create table SWAPCOM.SBRANCH
(
  branch_id   VARCHAR2(255 CHAR) not null,
  branch_name VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SBRANCH
  add primary key (BRANCH_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SBRANCH_TEST
prompt ===========================
prompt
create table SWAPCOM.SBRANCH_TEST
(
  branch_id   VARCHAR2(255 CHAR) not null,
  branch_name VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SCATEGORY
prompt ========================
prompt
create table SWAPCOM.SCATEGORY
(
  commotypecode   VARCHAR2(10) not null,
  commotypedesc   VARCHAR2(500),
  created_by      VARCHAR2(255 CHAR),
  created_time    TIMESTAMP(6),
  modified_by     VARCHAR2(255 CHAR),
  modified_time   TIMESTAMP(6),
  category_status VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SCATEGORY
  add constraint COMMOTYPECODE_PK primary key (COMMOTYPECODE)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SCATEGORY_AUD
prompt ============================
prompt
create table SWAPCOM.SCATEGORY_AUD
(
  commotypecode   VARCHAR2(255 CHAR) not null,
  rev             NUMBER(10) not null,
  revtype         NUMBER(3),
  created_by      VARCHAR2(255 CHAR),
  created_time    TIMESTAMP(6),
  modified_by     VARCHAR2(255 CHAR),
  modified_time   TIMESTAMP(6),
  commotypedesc   VARCHAR2(255 CHAR),
  category_status VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SCATEGORY_AUD
  add primary key (COMMOTYPECODE, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SCATEGORY_AUD
  add constraint FK114LOHEJ981H9NWRY5F1OEQUP foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table SCUSTOMER
prompt ========================
prompt
create table SWAPCOM.SCUSTOMER
(
  customer_code VARCHAR2(255 CHAR) not null,
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  account_no    VARCHAR2(255 CHAR),
  address       VARCHAR2(255 CHAR),
  branch_id     VARCHAR2(255 CHAR),
  cif_no        VARCHAR2(255 CHAR),
  cust_type     VARCHAR2(255 CHAR),
  email         VARCHAR2(255 CHAR),
  full_name     VARCHAR2(255 CHAR),
  mobile        VARCHAR2(255 CHAR),
  short_name    VARCHAR2(255 CHAR),
  status        VARCHAR2(255 CHAR),
  tax_code      VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SCUSTOMER
  add primary key (CUSTOMER_CODE)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SCUSTOMER_AUD
prompt ============================
prompt
create table SWAPCOM.SCUSTOMER_AUD
(
  customer_code VARCHAR2(255 CHAR) not null,
  rev           NUMBER(10) not null,
  revtype       NUMBER(3),
  account_no    VARCHAR2(255 CHAR),
  address       VARCHAR2(255 CHAR),
  branch_id     VARCHAR2(255 CHAR),
  cif_no        VARCHAR2(255 CHAR),
  commodity     VARCHAR2(255 CHAR),
  cust_type     VARCHAR2(255 CHAR),
  email         VARCHAR2(255 CHAR),
  full_name     VARCHAR2(255 CHAR),
  mobile        VARCHAR2(255 CHAR),
  short_name    VARCHAR2(255 CHAR),
  status        VARCHAR2(255 CHAR),
  tax_code      VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255;
alter table SWAPCOM.SCUSTOMER_AUD
  add primary key (CUSTOMER_CODE, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SPARAMETER
prompt =========================
prompt
create table SWAPCOM.SPARAMETER
(
  para_name  VARCHAR2(50) not null,
  para_value VARCHAR2(400),
  para_desc  VARCHAR2(300)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SPARAMETER_AUD
prompt =============================
prompt
create table SWAPCOM.SPARAMETER_AUD
(
  para_name  VARCHAR2(255 CHAR) not null,
  rev        NUMBER(10) not null,
  revtype    NUMBER(3),
  para_desc  VARCHAR2(255 CHAR),
  para_value VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPARAMETER_AUD
  add primary key (PARA_NAME, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPARAMETER_AUD
  add constraint FK8NUFM36HGQP40SAWC1Y6OONCS foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table SPARTNER
prompt =======================
prompt
create table SWAPCOM.SPARTNER
(
  partner_code  VARCHAR2(255 CHAR) not null,
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  account_no    VARCHAR2(255 CHAR),
  address       VARCHAR2(255 CHAR),
  cif_no        VARCHAR2(255 CHAR),
  cust_type     VARCHAR2(255 CHAR),
  full_name     VARCHAR2(255 CHAR),
  short_name    VARCHAR2(255 CHAR),
  status        VARCHAR2(255 CHAR),
  branch_id     VARCHAR2(5),
  email         VARCHAR2(20),
  mobile        VARCHAR2(15),
  tax_code      VARCHAR2(20)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPARTNER
  add primary key (PARTNER_CODE)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SPRICE
prompt =====================
prompt
create table SWAPCOM.SPRICE
(
  commo_type_code  VARCHAR2(255 CHAR) not null,
  created_by       VARCHAR2(255 CHAR),
  created_time     TIMESTAMP(6),
  modified_by      VARCHAR2(255 CHAR),
  modified_time    TIMESTAMP(6),
  price_status     VARCHAR2(255 CHAR),
  price_revert     VARCHAR2(255 CHAR),
  price_revert_mid VARCHAR2(255 CHAR),
  sys_date         VARCHAR2(10),
  trans_date       VARCHAR2(10)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPRICE
  add primary key (COMMO_TYPE_CODE)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SPRICEFLOATING
prompt =============================
prompt
create table SWAPCOM.SPRICEFLOATING
(
  contract_name        VARCHAR2(255 CHAR) not null,
  price_floating       NUMBER(19,2),
  period_floating_rate VARCHAR2(10 CHAR),
  gdv                  VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPRICEFLOATING
  add primary key (CONTRACT_NAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SPRICEFLOATING_AUD
prompt =================================
prompt
create table SWAPCOM.SPRICEFLOATING_AUD
(
  contract_name        VARCHAR2(255 CHAR) not null,
  price_floating       NUMBER(19,2),
  period_floating_rate VARCHAR2(10 CHAR),
  gdv                  VARCHAR2(255 CHAR),
  rev                  NUMBER(10) not null,
  revtype              NUMBER(3)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPRICEFLOATING_AUD
  add primary key (CONTRACT_NAME, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPRICEFLOATING_AUD
  add constraint FK6LPOJBLEFJWIQD055RPSM9W00 foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table SPRICE_AUD
prompt =========================
prompt
create table SWAPCOM.SPRICE_AUD
(
  commo_type_code  VARCHAR2(255 CHAR) not null,
  rev              NUMBER(10) not null,
  revtype          NUMBER(3),
  created_by       VARCHAR2(255 CHAR),
  created_time     TIMESTAMP(6),
  modified_by      VARCHAR2(255 CHAR),
  modified_time    TIMESTAMP(6),
  price_status     VARCHAR2(255 CHAR),
  price_revert     VARCHAR2(255 CHAR),
  price_revert_mid VARCHAR2(255 CHAR),
  sys_date         VARCHAR2(10),
  trans_date       VARCHAR2(10)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPRICE_AUD
  add primary key (COMMO_TYPE_CODE, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SPRICE_AUD
  add constraint FK95QETD98XSAOAB84YGOS4CEHX foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table SRATE
prompt ====================
prompt
create table SWAPCOM.SRATE
(
  currency      VARCHAR2(255 CHAR) not null,
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  rate_revert   VARCHAR2(255 CHAR),
  rate_status   VARCHAR2(2),
  sys_date      VARCHAR2(10),
  trans_date    VARCHAR2(10)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SRATE
  add primary key (CURRENCY)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SRATE_AUD
prompt ========================
prompt
create table SWAPCOM.SRATE_AUD
(
  currency      VARCHAR2(255 CHAR) not null,
  rev           NUMBER(10) not null,
  revtype       NUMBER(3),
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  rate_revert   VARCHAR2(255 CHAR),
  rate_status   VARCHAR2(2),
  sys_date      VARCHAR2(10),
  trans_date    VARCHAR2(10)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SRATE_AUD
  add primary key (CURRENCY, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SRATE_AUD
  add constraint FK748MEOV8XAEOGYILH2AC9FESS foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table STRANSACTION
prompt ===========================
prompt
create table SWAPCOM.STRANSACTION
(
  contract_name        VARCHAR2(255 CHAR) not null,
  period_total_payment NUMBER(10),
  volume_current       NUMBER(10),
  volume_period        NUMBER(10),
  approved_by          VARCHAR2(255 CHAR),
  approved_date        VARCHAR2(10),
  branch_id            VARCHAR2(5),
  buy_sell             VARCHAR2(1),
  cancelled_by         VARCHAR2(255 CHAR),
  cancelled_date       VARCHAR2(10),
  commo_type           VARCHAR2(255 CHAR),
  contract_status      VARCHAR2(1),
  contract_type        VARCHAR2(255 CHAR),
  created_by           VARCHAR2(255 CHAR),
  created_time         TIMESTAMP(6),
  currency_type        VARCHAR2(3),
  customer_info        VARCHAR2(255 CHAR),
  customer_type        VARCHAR2(1),
  description          VARCHAR2(255 CHAR),
  end_date             VARCHAR2(10),
  maturity_date        VARCHAR2(10),
  modified_by          VARCHAR2(255 CHAR),
  modified_time        TIMESTAMP(6),
  period_floating_rate VARCHAR2(255 CHAR),
  period_total         NUMBER(10),
  price_buy_fix        NUMBER(19,2),
  price_floating       NUMBER(19,2),
  price_sell_fix       NUMBER(19,2),
  rate                 NUMBER(19,2),
  spread               NUMBER(6,2),
  start_date           VARCHAR2(10),
  status               VARCHAR2(2),
  sys_date             VARCHAR2(10),
  trans_date           VARCHAR2(10),
  transaction_type     VARCHAR2(255 CHAR),
  volume_total         NUMBER(10),
  volume_type          VARCHAR2(255 CHAR),
  customer_id          VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.STRANSACTION
  add primary key (CONTRACT_NAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table STRANSACTION_AUD
prompt ===============================
prompt
create table SWAPCOM.STRANSACTION_AUD
(
  contract_name        VARCHAR2(255 CHAR) not null,
  rev                  NUMBER(10) not null,
  modified_by          VARCHAR2(255 CHAR),
  modified_time        TIMESTAMP(6),
  status               VARCHAR2(2),
  revtype              NUMBER(3),
  period_total_payment NUMBER(10),
  volume_current       NUMBER(10),
  volume_period        NUMBER(10),
  approved_by          VARCHAR2(255 CHAR),
  approved_date        VARCHAR2(10),
  branch_id            VARCHAR2(5),
  buy_sell             VARCHAR2(1),
  cancelled_by         VARCHAR2(255 CHAR),
  cancelled_date       VARCHAR2(10),
  commo_type           VARCHAR2(255 CHAR),
  contract_status      VARCHAR2(1),
  contract_type        VARCHAR2(255 CHAR),
  created_by           VARCHAR2(255 CHAR),
  created_time         TIMESTAMP(6),
  currency_type        VARCHAR2(3),
  customer_info        VARCHAR2(255 CHAR),
  customer_type        VARCHAR2(1),
  description          VARCHAR2(255 CHAR),
  end_date             VARCHAR2(10),
  maturity_date        VARCHAR2(10),
  period_floating_rate VARCHAR2(255 CHAR),
  period_total         NUMBER(10),
  price_buy_fix        NUMBER(19,2),
  price_floating       NUMBER(19,2),
  price_sell_fix       NUMBER(19,2),
  rate                 NUMBER(19,2),
  spread               NUMBER(6,2),
  start_date           VARCHAR2(10),
  sys_date             VARCHAR2(10),
  trans_date           VARCHAR2(10),
  transaction_type     VARCHAR2(255 CHAR),
  volume_total         NUMBER(10),
  volume_type          VARCHAR2(255 CHAR),
  customer_id          VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.STRANSACTION_AUD
  add primary key (CONTRACT_NAME, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.STRANSACTION_AUD
  add constraint FKIBK2YNVEEVG6ECP7VFOKKOPOL foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table STRANSACTION_BATCH_DAILY
prompt =======================================
prompt
create table SWAPCOM.STRANSACTION_BATCH_DAILY
(
  contract_name        VARCHAR2(255 CHAR) not null,
  volume_current       NUMBER,
  buy_sell             VARCHAR2(1),
  currency_type        VARCHAR2(3),
  commo_type           VARCHAR2(255 CHAR),
  period_total_payment NUMBER(10),
  volume_period        NUMBER(10),
  customer_type        VARCHAR2(1),
  maturity_date        DATE,
  end_date             DATE,
  price_buy_fix        NUMBER,
  price_sell_fix       NUMBER,
  rate                 NUMBER,
  spread               NUMBER,
  trans_date           VARCHAR2(10),
  transaction_type     VARCHAR2(255 CHAR),
  volume_total         NUMBER,
  volume_type          VARCHAR2(255 CHAR),
  branch_id            VARCHAR2(5),
  description          VARCHAR2(255 CHAR),
  approved_date        DATE,
  rate_revert          NUMBER,
  price_revert         NUMBER
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table STRANSACTION_BATCH_EOM
prompt =====================================
prompt
create table SWAPCOM.STRANSACTION_BATCH_EOM
(
  contract_name        VARCHAR2(255 CHAR) not null,
  volume_current       NUMBER,
  buy_sell             VARCHAR2(1),
  currency_type        VARCHAR2(3),
  commo_type           VARCHAR2(255 CHAR),
  period_total_payment NUMBER(10),
  volume_period        NUMBER(10),
  customer_type        VARCHAR2(1),
  maturity_date        DATE,
  end_date             DATE,
  price_buy_fix        NUMBER,
  price_sell_fix       NUMBER,
  rate                 NUMBER,
  spread               NUMBER,
  trans_date           VARCHAR2(10),
  transaction_type     VARCHAR2(255 CHAR),
  volume_total         NUMBER,
  volume_type          VARCHAR2(255 CHAR),
  branch_id            VARCHAR2(5),
  description          VARCHAR2(255 CHAR),
  approved_date        DATE,
  rate_revert          NUMBER,
  price_revert         NUMBER
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255;

prompt
prompt Creating table SUNIT
prompt ====================
prompt
create table SWAPCOM.SUNIT
(
  unitid        NUMBER(2) not null,
  unitdesc      VARCHAR2(10),
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  unit_status   VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SUNIT
  add constraint UNITID_PK primary key (UNITID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SUNIT_AUD
prompt ========================
prompt
create table SWAPCOM.SUNIT_AUD
(
  unitid        VARCHAR2(255 CHAR) not null,
  rev           NUMBER(10) not null,
  revtype       NUMBER(3),
  created_by    VARCHAR2(255 CHAR),
  created_time  TIMESTAMP(6),
  modified_by   VARCHAR2(255 CHAR),
  modified_time TIMESTAMP(6),
  unitdesc      VARCHAR2(255 CHAR),
  unit_status   VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SUNIT_AUD
  add primary key (UNITID, REV)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SWAPCOM.SUNIT_AUD
  add constraint FKQYX9YDCAOVDBNR7AE8FYAV0I6 foreign key (REV)
  references SWAPCOM.REVINFO (REV);

prompt
prompt Creating table SWAPCOM_DAYEND_OGL
prompt =================================
prompt
create table SWAPCOM.SWAPCOM_DAYEND_OGL
(
  account       VARCHAR2(50),
  swapcomid     NUMBER(20) not null,
  trxamount     NUMBER(19,2) not null,
  description   VARCHAR2(500) not null,
  trxno         NUMBER(20) not null,
  lineno        NUMBER(1) not null,
  entity        VARCHAR2(50),
  costcenter    VARCHAR2(50) not null,
  intercompany  NUMBER(1) not null,
  product       VARCHAR2(50) not null,
  future1       NUMBER(20),
  future2       NUMBER(20),
  created_date  DATE default sysdate not null,
  trxdate       VARCHAR2(10) not null,
  currency      VARCHAR2(50) not null,
  trxdrcr       VARCHAR2(50) not null,
  refno         NUMBER(10),
  clientorderid NUMBER(15),
  category      VARCHAR2(50),
  addinfo1      VARCHAR2(50),
  addinfo2      NUMBER(10),
  addinfo3      VARCHAR2(50),
  addinfo4      VARCHAR2(50),
  addinfo5      VARCHAR2(50),
  status        VARCHAR2(50) default 0 not null,
  errorcode     NUMBER(15),
  tltxcd        NUMBER(10)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SWAPCOM_DAYEND_OGL_FINAL
prompt =======================================
prompt
create table SWAPCOM.SWAPCOM_DAYEND_OGL_FINAL
(
  account       VARCHAR2(50),
  swapcomid     NUMBER(20) not null,
  trxamount     NUMBER(19,2) not null,
  description   VARCHAR2(500) not null,
  trxno         NUMBER(20) not null,
  lineno        NUMBER(1) not null,
  entity        VARCHAR2(50),
  costcenter    VARCHAR2(50) not null,
  intercompany  NUMBER(1) not null,
  product       VARCHAR2(50) not null,
  future1       NUMBER(20),
  future2       NUMBER(20),
  created_date  DATE not null,
  trxdate       VARCHAR2(10) not null,
  currency      VARCHAR2(50) not null,
  trxdrcr       VARCHAR2(50) not null,
  refno         NUMBER(10),
  clientorderid NUMBER(15),
  category      VARCHAR2(50),
  addinfo1      VARCHAR2(50),
  addinfo2      NUMBER(10),
  addinfo3      VARCHAR2(50),
  addinfo4      VARCHAR2(50),
  addinfo5      VARCHAR2(50),
  status        VARCHAR2(50) not null,
  errorcode     NUMBER(15),
  tltxcd        NUMBER(10)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SWAPCOM_DAYEND_OGL_FLAG
prompt ======================================
prompt
create table SWAPCOM.SWAPCOM_DAYEND_OGL_FLAG
(
  id         NUMBER,
  ogl_date   VARCHAR2(10),
  ogl_status VARCHAR2(2),
  created_on TIMESTAMP(6)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column SWAPCOM.SWAPCOM_DAYEND_OGL_FLAG.ogl_status
  is '0: bat dau do du lieu OGL; 1: da co du lieu OGL';

prompt
prompt Creating table USER_DETAILIMODEL
prompt ================================
prompt
create table SWAPCOM.USER_DETAILIMODEL
(
  username      VARCHAR2(255 CHAR) not null,
  dep_name      VARCHAR2(255 CHAR),
  department_id NUMBER(19),
  email         VARCHAR2(255 CHAR),
  fullname      VARCHAR2(255 CHAR),
  isactive      VARCHAR2(255 CHAR),
  phone         VARCHAR2(255 CHAR)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255;
alter table SWAPCOM.USER_DETAILIMODEL
  add primary key (USERNAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating sequence BATCH_LOG_SEQ
prompt ===============================
prompt
create sequence SWAPCOM.BATCH_LOG_SEQ
minvalue 0
maxvalue 999999999999999999999999999
start with 7921
increment by 1
nocache;

prompt
prompt Creating sequence HIBERNATE_SEQUENCE
prompt ====================================
prompt
create sequence SWAPCOM.HIBERNATE_SEQUENCE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1352
increment by 1
cache 20;

prompt
prompt Creating sequence OGL_FLAG_SEQ
prompt ==============================
prompt
create sequence SWAPCOM.OGL_FLAG_SEQ
minvalue 0
maxvalue 999999999999999999999999999
start with 467
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SACCOUNTING
prompt =================================
prompt
create sequence SWAPCOM.SEQ_SACCOUNTING
minvalue 1
maxvalue 999999999
start with 842
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SCATEGORY
prompt ===============================
prompt
create sequence SWAPCOM.SEQ_SCATEGORY
minvalue 1
maxvalue 999999999
start with 45
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SCUSTOMER
prompt ===============================
prompt
create sequence SWAPCOM.SEQ_SCUSTOMER
minvalue 1
maxvalue 99999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SPARTNER
prompt ==============================
prompt
create sequence SWAPCOM.SEQ_SPARTNER
minvalue 1
maxvalue 99999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SPRICEHIST
prompt ================================
prompt
create sequence SWAPCOM.SEQ_SPRICEHIST
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SUNIT
prompt ===========================
prompt
create sequence SWAPCOM.SEQ_SUNIT
minvalue 1
maxvalue 999999999
start with 45
increment by 1
cache 20;

prompt
prompt Creating view V_CUSTOMER_PARTNER
prompt ================================
prompt
create or replace force view swapcom.v_customer_partner as
select c.customer_code CUSTOMER_PARTNER_CODE,
       c.created_by ,
       c.created_time ,
       c.modified_by ,
       c.modified_time ,
       c.branch_id,
       b.branch_name,
       c.full_name full_name,
       c.account_no account_no,
       c.cif_no cif_no,
       c.tax_code tax_code,
       c.address address,
       c.short_name short_name,
       c.status status,
       c.email email,
       c.mobile mobile,
       c.cust_type cust_type
        from scustomer c
        left join sbranch b on b.branch_id = c.branch_id
 union all
select p.partner_code CUSTOMER_PARTNER_CODE,
       p.created_by ,
       p.created_time ,
       p.modified_by ,
       p.modified_time ,
       p.branch_id,
       b.branch_name,
       p.full_name full_name,
       p.account_no account_no,
       p.cif_no cif_no,
       p.tax_code,
       p.address,
       p.short_name short_name,
       p.status status,
       p.email,
       p.mobile,
       p.cust_type cust_type
        from spartner p
      left join sbranch b on b.branch_id = p.branch_id
        order by modified_time desc;

prompt
prompt Creating view V_SACCOUNTING
prompt ===========================
prompt
create or replace force view swapcom.v_saccounting as
select "ENTRY_NO","TRANS_NO","BRANCH_ID","DEPT_ID","PRODUCT","DEBIT_ACC_NO","DEBIT_ACC_NAME","CREDIT_ACC_NO","CREDIT_ACC_NAME","TRANS_CONTENT","TRANS_DATE","CURRENCY","AMOUNT","BATCH_TYPE" from SACCOUNTING;

prompt
prompt Creating view V_SCATEGORY
prompt =========================
prompt
create or replace force view swapcom.v_scategory as
select "COMMOTYPECODE","COMMOTYPEDESC","CREATED_BY","CREATED_TIME","MODIFIED_BY","MODIFIED_TIME","CATEGORY_STATUS" from SCATEGORY t
where t.category_status = 'A';

prompt
prompt Creating view V_SPRICE
prompt ======================
prompt
create or replace force view swapcom.v_sprice as
select "COMMO_TYPE_CODE","CREATED_BY","CREATED_TIME","MODIFIED_BY","MODIFIED_TIME","PRICE_STATUS","PRICE_REVERT","PRICE_REVERT_MID","SYS_DATE",
"TRANS_DATE" from SPRICE where PRICE_STATUS = 'A';

prompt
prompt Creating view V_SPRICE_FLOATING
prompt ===============================
prompt
create or replace force view swapcom.v_sprice_floating as
select "CONTRACT_NAME","PRICE_FLOATING","GDV", PERIOD_FLOATING_RATE from SPRICEFLOATING;

prompt
prompt Creating view V_SRATE
prompt =====================
prompt
create or replace force view swapcom.v_srate as
select "CURRENCY","CREATED_BY","CREATED_TIME","MODIFIED_BY","MODIFIED_TIME","RATE_REVERT",
 "RATE_STATUS",
"SYS_DATE", TRANS_DATE from SRATE where RATE_STATUS = 'A';

prompt
prompt Creating view V_SUNIT
prompt =====================
prompt
create or replace force view swapcom.v_sunit as
select "UNITID","UNITDESC","CREATED_BY","CREATED_TIME","MODIFIED_BY","MODIFIED_TIME","UNIT_STATUS" from SUNIT t where t.unit_status = 'A';

prompt
prompt Creating view V_SWAPCOM_OGL
prompt ===========================
prompt
create or replace force view swapcom.v_swapcom_ogl as
select "ACCOUNT","SWAPCOMID","TRXAMOUNT","DESCRIPTION","TRXNO","LINENO","ENTITY","COSTCENTER","INTERCOMPANY","PRODUCT","FUTURE1","FUTURE2","CREATED_DATE","TRXDATE","CURRENCY","TRXDRCR","REFNO","CLIENTORDERID","CATEGORY","ADDINFO1","ADDINFO2","ADDINFO3","ADDINFO4","ADDINFO5","STATUS","ERRORCODE","TLTXCD" from SWAPCOM_DAYEND_OGL;

prompt
prompt Creating view V_TRANSACTION
prompt ===========================
prompt
create or replace force view swapcom.v_transaction as
select
       sc.period_total_payment,
       sc.volume_current,
       sc.volume_period,
       sc.buy_sell,
       sc.commo_type,
       sc.contract_name,
       sc.contract_status,
       sc.contract_type,
       sc.created_by,
       sc.created_time,
       sc.currency_type,
       sc.customer_info,
       sc.customer_type,
       sc.end_date,
       sc.maturity_date,
       sc.modified_by,
       sc.modified_time,
       sc.period_floating_rate,
       sc.customer_id,
       sc.period_total,
       sc.price_buy_fix,
       sc.price_floating,
       sc.price_sell_fix,
       sc.rate,
       sc.spread,
       sc.start_date,
       sc.status,
       sc.sys_date,
       sc.trans_date,
       sc.transaction_type,
       sc.volume_total,
       sc.volume_type,
       sc.description,
       sc.approved_by,
       sc.approved_date,
       sc.cancelled_by,
       sc.cancelled_date,
       sca.commotypedesc
from STRANSACTION  sc
Left join SCATEGORY sca ON sc.COMMO_TYPE = sca.commotypecode;

prompt
prompt Creating view V_TRANSACTION_BATCH_DAILY
prompt =======================================
prompt
create or replace force view swapcom.v_transaction_batch_daily as
select T.CONTRACT_NAME, DECODE(T.VOLUME_CURRENT, NULL, 0, T.VOLUME_CURRENT) VOLUME_CURRENT, T.BUY_SELL,
       T.CURRENCY_TYPE, T.COMMO_TYPE, T.PERIOD_TOTAL_PAYMENT, T.VOLUME_PERIOD, T.Period_Total,
       T.CUSTOMER_TYPE, to_date(T.MATURITY_DATE, 'dd/mm/yyyy') MATURITY_DATE,
       to_date(T.END_DATE, 'dd/mm/yyyy') END_DATE,
       to_date(T.Start_Date, 'dd/mm/yyyy') Start_Date,
       DECODE(T.PRICE_BUY_FIX, NULL, 0, T.PRICE_BUY_FIX) PRICE_BUY_FIX,
       DECODE(T.PRICE_SELL_FIX, NULL, 0, T.PRICE_SELL_FIX) PRICE_SELL_FIX,
       DECODE(T.RATE, NULL, 0, T.RATE) RATE,
       DECODE(T.SPREAD, NULL, 0, T.SPREAD) SPREAD,
       T.TRANS_DATE, T.TRANSACTION_TYPE,
       DECODE(T.VOLUME_TOTAL, NULL, 0, T.VOLUME_TOTAL) VOLUME_TOTAL, T.VOLUME_TYPE,
       T.BRANCH_ID, T.DESCRIPTION, to_date(T.approved_date, 'dd/mm/yyyy') APPROVED_DATE
from stransaction T
--left join srate R on R.CURRENCY = T.CURRENCY_TYPE
--LEFT JOIN SPRICE P ON P.COMMO_TYPE_CODE = T.COMMO_TYPE
where T.CONTRACT_STATUS = 'A' and T.status = '03'
;

prompt
prompt Creating view V_TRANSACTION_BATCH_REVERT
prompt ========================================
prompt
create or replace force view swapcom.v_transaction_batch_revert as
select T.CONTRACT_NAME, DECODE(T.VOLUME_CURRENT, NULL, 0, T.VOLUME_CURRENT) VOLUME_CURRENT, T.BUY_SELL,
       T.CURRENCY_TYPE, T.COMMO_TYPE, T.PERIOD_TOTAL_PAYMENT, T.VOLUME_PERIOD, T.Period_Total,
       T.CUSTOMER_TYPE, to_date(T.MATURITY_DATE, 'dd/mm/yyyy') MATURITY_DATE,
       to_date(T.END_DATE, 'dd/mm/yyyy') END_DATE,
       to_date(T.Start_Date, 'dd/mm/yyyy') Start_Date,
       DECODE(T.PRICE_BUY_FIX, NULL, 0, T.PRICE_BUY_FIX) PRICE_BUY_FIX,
       DECODE(T.PRICE_SELL_FIX, NULL, 0, T.PRICE_SELL_FIX) PRICE_SELL_FIX,
       DECODE(T.RATE, NULL, 0, T.RATE) RATE,
       DECODE(T.SPREAD, NULL, 0, T.SPREAD) SPREAD,
       T.TRANS_DATE, T.TRANSACTION_TYPE,
       DECODE(T.VOLUME_TOTAL, NULL, 0, T.VOLUME_TOTAL) VOLUME_TOTAL, T.VOLUME_TYPE,
       T.BRANCH_ID, T.DESCRIPTION, to_date(T.approved_date, 'dd/mm/yyyy') APPROVED_DATE,
       DECODE(R.RATE_REVERT, NULL, 0, R.RATE_REVERT) RATE_REVERT,
       DECODE(P.PRICE_REVERT, NULL, 0, P.PRICE_REVERT) PRICE_REVERT
from stransaction T
left join srate R on R.CURRENCY = T.CURRENCY_TYPE
LEFT JOIN SPRICE P ON P.COMMO_TYPE_CODE = T.COMMO_TYPE
where T.CONTRACT_STATUS = 'A' and T.status = '03' AND R.RATE_STATUS = 'A' AND P.PRICE_STATUS = 'A';


prompt Done
spool off
set define on
