-- 创建数据库
CREATE DATABASE family
  CHARSET = utf8;

# 创建测试表
CREATE TABLE test (
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(12)     NOT NULL,
  age  INT             NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF8
  COMMENT ='测试表';

#添加测试数据
INSERT INTO test VALUES (1000, 'walle', 10);
INSERT INTO test VALUES (1001, 'lily', 15);
INSERT INTO test VALUES (1002, 'jim', 20);