/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.49-community : Database - classnet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/classnet1 /*!40100 DEFAULT CHARACTER SET utf8 */;

USE classnet1;

/*Table structure for table answer_table */

DROP TABLE  answer_table;

CREATE TABLE answer_table (
  id NUMBER(11,0) NOT NULL ,
  content varchar2(1000 byte) NOT NULL,
  status NUMBER(11,0) DEFAULT NULL,
  pubtime date DEFAULT NULL,
  topicId NUMBER(11,0) NOT NULL,
  userId NUMBER(11,0) NOT NULL
);

/*Data for the table answer_table */

insert  into answer_table(id,content,status,pubtime,topicId,userId) values (2,'是的',1,to_date('2013-04-27 18:51:53','yyyy-mm-dd hh24:mi:ss'),2,3);
/*Table structure for table clazz_menu */

DROP TABLE  clazz_menu;

CREATE TABLE clazz_menu (
  id NUMBER(11,0) NOT NULL ,
  name varchar(20) NOT NULL,
  parentId NUMBER(11,0) DEFAULT NULL  
) ;

/*Data for the table clazz_menu */

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (1, '网页基础', NULL);

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (4, 'html', 1);

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (7, 'css', 1);

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (8, 'javascript', 1);

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (9, 'Java基础', NULL);

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (10, 'java语法', 9);

INSERT INTO clazz_menu (id, name, parentId)
     VALUES (11, 'java面向对象', 9);
     
/*Table structure for table clazz_table */

DROP TABLE  clazz_table;

CREATE TABLE clazz_table (
  id NUMBER(11,0) NOT NULL ,
  name varchar(100) NOT NULL,
  filename varchar(40) NOT NULL,
  status NUMBER(11,0) DEFAULT NULL,
  author varchar(10) DEFAULT NULL,
  pubtime date DEFAULT NULL,
  img varchar(40) DEFAULT NULL,
  flashFilename varchar(40) DEFAULT NULL,
  school varchar(50) DEFAULT NULL,
  viewcount NUMBER(11,0) DEFAULT NULL,
  filetype NUMBER(11,0) NOT NULL,
  menuId NUMBER(11,0) NOT NULL
) ;

/*Data for the table clazz_table */

/* Formatted on 2016/12/14 0:46:56 (QP5 v5.252.13127.32847) */
INSERT INTO clazz_table (id,
                         name,
                         filename,
                         status,
                         author,
                         pubtime,
                         img,
                         flashFilename,
                         school,
                         viewcount,
                         filetype,
                         menuId)
     VALUES (5,
             'html初级教程',
             '201304271834049284.txt',
             1,
             'admin',
             sysdate,
             '201304271836472989.jpg',
             '201304271834051459.swf',
             '哈哈',
             0,
             1,
             4);

INSERT INTO clazz_table (id,
                         name,
                         filename,
                         status,
                         author,
                         pubtime,
                         img,
                         flashFilename,
                         school,
                         viewcount,
                         filetype,
                         menuId)
     VALUES (6,
             'css中级',
             '201304271839100285.txt',
             1,
             'admin',
             sysdate,
             '201304271839098787.jpg',
             '201304271839101767.swf',
             'aa',
             0,
             2,
             7);

INSERT INTO clazz_table (id,
                         name,
                         filename,
                         status,
                         author,
                         pubtime,
                         img,
                         flashFilename,
                         school,
                         viewcount,
                         filetype,
                         menuId)
     VALUES (7,
             'java高级语法',
             '201304271840013347.txt',
             1,
             'admin',
             sysdate,
             '201304271840012126.jpg',
             '201304271840014700.swf',
             'aa',
             0,
             3,
             10);
/*Table structure for table file_type */

DROP TABLE  file_type;

CREATE TABLE file_type (
  id NUMBER(11,0) NOT NULL ,
  name varchar(20) NOT NULL
) ;

/*Data for the table file_type */

INSERT INTO file_type (id, name)
     VALUES (1, '初级类');

INSERT INTO file_type (id, name)
     VALUES (2, '中级类');

INSERT INTO file_type (id, name)
     VALUES (3, '高级类');

/*Table structure for table homework_title */

DROP TABLE  homework_title;

CREATE TABLE homework_title (
  id NUMBER(11,0) NOT NULL ,
  pubtime date DEFAULT NULL,
  description varchar2(1000 byte),
  title varchar2(1000 byte) NOT NULL
);

/*Data for the table homework_title */

/* Formatted on 2016/12/14 0:49:26 (QP5 v5.252.13127.32847) */
INSERT INTO homework_title (id,
                            pubtime,
                            description,
                            title)
        VALUES (
                  1,
                  sysdate,
                  '完成数组int[] a = {100,40, 60, 87, 34, 11, 56, 0}的快速排序、冒泡排序；',
                  '实现快速排序、冒泡排序；');

INSERT INTO homework_title (id,
                            pubtime,
                            description,
                            title)
        VALUES (
                  2,
                 sysdate,
                  '将一个数组中值=0的项去掉,将不为0的值存入一个新的数组,比如:<br />\r\nint a[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};<br />\r\n生成的新数组为:<br />\r\nint b[]={1,3,4,5,6,6,5,4,7,6,7,5}<br />',
                  '将一个数组中值=0的项去掉,将不为0的值存入一个新的数组');
/*Table structure for table news */

DROP TABLE  news;

CREATE TABLE news (
  id NUMBER(11,0) NOT NULL ,
  content varchar2(1000 byte) NOT NULL,
  source varchar(20) DEFAULT NULL,
  status NUMBER(11,0) DEFAULT NULL,
  title varchar(50) NOT NULL,
  author varchar(10) DEFAULT NULL,
  pubtime date DEFAULT NULL,
  viewnum NUMBER(11,0) DEFAULT NULL,
  img varchar(50) DEFAULT NULL,
  menuId NUMBER(11,0) NOT NULL
) ;

/*Data for the table news */
/* Formatted on 2016/12/14 0:51:37 (QP5 v5.252.13127.32847) */
INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (10,
             '此新闻纯属虚构。',
             '校园网',
             4,
             '大一美女新生报道',
             'admin',
             sysdate,
             0,
             '201304271733396452.jpg',
             3);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (12,
             '这个校园动态新闻1，你懂的。',
             '哈哈',
             1,
             '这个校园动态新闻1，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             3);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (13,
             '这个校园动态新闻1，你懂的。',
             '哈哈',
             2,
             '这个校园动态新闻2，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             3);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (14,
             '这个校园动态新闻1，你懂的。',
             '哈哈',
             1,
             '这个校园动态新闻1，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             3);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (15,
             '这个校园风采新闻1，你懂的。',
             '哈哈',
             1,
             '这个校园风采新闻1，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             4);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (16,
             '这个校园风采新闻1，你懂的。',
             '哈哈',
             2,
             '这个校园风采新闻2，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             4);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (17,
             '这个校园风采新闻1，你懂的。',
             '哈哈',
             2,
             '这个校园风采新闻2，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             4);

INSERT INTO news (id,
                  content,
                  source,
                  status,
                  title,
                  author,
                  pubtime,
                  viewnum,
                  img,
                  menuId)
     VALUES (18,
             '这个校园风采新闻1，你懂的。',
             '哈哈',
             2,
             '这个校园风采新闻1，你懂的。',
             'admin',
             sysdate,
             0,
             NULL,
             4);
/*Table structure for table news_menu */

DROP TABLE  news_menu;

CREATE TABLE news_menu (
  id NUMBER(11,0) NOT NULL ,
  name varchar(50) NOT NULL
) ;

/*Data for the table news_menu */

INSERT INTO news_menu (id, name)
     VALUES (3, '校园动态');

INSERT INTO news_menu (id, name)
     VALUES (4, '校园风采');

/*Table structure for table source_menu */

DROP TABLE  source_menu;

CREATE TABLE source_menu (
  id NUMBER(11,0) NOT NULL ,
  name varchar(50) NOT NULL
) ;

/*Data for the table source_menu */

INSERT INTO source_menu (id, name)
     VALUES (3, 'java资源');

INSERT INTO source_menu (id, name)
     VALUES (4, '网页基础资源');

/*Table structure for table source_table */

DROP TABLE  source_table;

CREATE TABLE source_table (
  id NUMBER(11,0) NOT NULL ,
  name varchar(50) NOT NULL,
  filename varchar(50) NOT NULL,
  pubtime date DEFAULT NULL,
  fileSize varchar(20) NOT NULL,
  menuId NUMBER(11,0) NOT NULL
) ;

/*Data for the table source_table */

/* Formatted on 2016/12/14 0:55:34 (QP5 v5.252.13127.32847) */
INSERT INTO source_table (id,
                          name,
                          filename,
                          pubtime,
                          fileSize,
                          menuId)
     VALUES (2,
             'java编程思想',
             '201304271844560452.txt',
             sysdate,
             '10',
             3);

INSERT INTO source_table (id,
                          name,
                          filename,
                          pubtime,
                          fileSize,
                          menuId)
     VALUES (3,
             'css基础',
             '201304271845128702.txt',
             sysdate,
             '10',
             4);
/*Table structure for table topic_menu */

DROP TABLE  topic_menu;

CREATE TABLE topic_menu (
  id NUMBER(11,0) NOT NULL ,
  name varchar(50) NOT NULL
);

/*Data for the table topic_menu */

insert  into topic_menu(id,name) values (1,'学习交流');
insert  into topic_menu(id,name) values (2,'灌水专区');

/*Table structure for table topic_table */

DROP TABLE  topic_table;

CREATE TABLE topic_table (
  id NUMBER(11,0) NOT NULL ,
  title varchar2(1000 byte) NOT NULL,
  pubtime date DEFAULT NULL,
  detail varchar2(1000 byte) NOT NULL,
  replynum NUMBER(11,0) DEFAULT NULL,
  edituser varchar(50) DEFAULT NULL,
  edittime date DEFAULT NULL,
  menuId NUMBER(11,0) NOT NULL,
  userId NUMBER(11,0) NOT NULL
);

/*Data for the table topic_table */

/* Formatted on 2016/12/14 0:57:26 (QP5 v5.252.13127.32847) */
INSERT INTO topic_table (id,
                         title,
                         pubtime,
                         detail,
                         replynum,
                         edituser,
                         edittime,
                         menuId,
                         userId)
     VALUES (2,
             'java好好学啊',
             sysdate,
             '哈哈',
             1,
             'user2',
             SYSDATE,
             1,
             3);
/*Table structure for table user_table */

DROP TABLE  user_table;

CREATE TABLE user_table (
  id NUMBER(11,0) NOT NULL ,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  authorite varchar(50) NOT NULL,
  enable varchar(50) DEFAULT NULL,
  email varchar(50) NOT NULL
) ;

/*Data for the table user_table */

/* Formatted on 2016/12/14 0:59:35 (QP5 v5.252.13127.32847) */
INSERT INTO user_table (id,
                        username,
                        password,
                        authorite,
                        enable,
                        email)
     VALUES (1,
             'admin',
             '123',
             'ROLE_SUPERVISOR',
             '1',
             '123@126.com')
             ;INSERT INTO user_table (id,
                        username,
                        password,
                        authorite,
                        enable,
                        email)
     VALUES (2,'user1','123','ROLE_USER','1','234@qq.com');INSERT INTO user_table (id,
                        username,
                        password,
                        authorite,
                        enable,
                        email)
     VALUES (3,'user2','123','ROLE_USER','1','345@qq.com');
/*Table structure for table userhoumework_table */

DROP TABLE  userhoumework_table;

CREATE TABLE userhoumework_table (
  id NUMBER(11,0) NOT NULL ,
  name varchar(200) NOT NULL,
  addtime date DEFAULT NULL,
  titleId NUMBER(11,0) NOT NULL,
  userId NUMBER(11,0) NOT NULL
) ;

/*Data for the table userhoumework_table */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
ALTER TABLE answer_table ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE clazz_menu ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE clazz_table ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE file_type ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE homework_title ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE news ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE news_menu ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE source_menu ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE source_table ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE topic_menu ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE topic_table ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE user_table ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
ALTER TABLE userhoumework_table ADD (
  PRIMARY KEY
  (ID)
  USING INDEX);
