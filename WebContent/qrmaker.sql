drop database qrmaker;
create database qrmaker;
use qrmaker

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : db_kesheng_web

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-10-20 22:12:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '�Զ����',
  `manager` char(20) NOT NULL DEFAULT '' COMMENT '����Ա�ʺ�',
  `password` char(40) NOT NULL DEFAULT '' COMMENT '����',
  `createdate` date NOT NULL COMMENT '����ʱ��',
  `auth` int(10) unsigned NOT NULL COMMENT '��ɫ���',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'yemeng', '12345', '2016-07-01', '1');
INSERT INTO `admin` VALUES ('2', 'admin', '12345', '2016-07-14', '2');
INSERT INTO `admin` VALUES ('3', 'test', '12345', '2016-08-18', '3');
INSERT INTO `admin` VALUES ('4', 'testtest', '12345', '2016-09-11', '2');
INSERT INTO `admin` VALUES ('8', 'wuhan', '111111', '0000-00-00', '2');
INSERT INTO `admin` VALUES ('9', 'jianhgzhi', '123456', '2016-10-10', '1');
INSERT INTO `admin` VALUES ('21', 'zhaojunzhi', '123456', '2016-10-10', '1');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `autoid` int(8) unsigned NOT NULL,
  `id` int(5) unsigned zerofill NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `admin` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '���״̬1ͨ����2��ͨ����0�������',
  `restime` datetime DEFAULT '0000-00-00 00:00:00' COMMENT 'ע��ʱ��',
  `statime` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '����ʱ��',
  `resnum` varchar(50) DEFAULT NULL COMMENT '��˾ע���',
  `refusereason` int(10) unsigned DEFAULT '0' COMMENT '�ܾ�����',
  PRIMARY KEY (`autoid`),
  KEY `hash1` (`admin`,`password`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '90001', '��ʤ�ܹ�˾', 'kesheng', '12345', 'kesheng@qq.com', '1', '2016-10-05 21:08:55', '2016-10-14 21:09:04', 'ZC_20010301001231', '0');
INSERT INTO `company` VALUES ('2', '90002', '�Ͼ���˾', 'nanjing', '12345', 'nanjing@qq.com', '1', '2016-10-01 21:08:46', '2016-10-17 21:08:52', '2010032301240124', '0');
INSERT INTO `company` VALUES ('3', '90003', '�γ�ĳ��˾', 'yancheng', '12345', 'yancheng@qq.com', '1', '2016-10-15 21:08:59', '2016-10-17 21:09:07', '20121024124156634', '0');
INSERT INTO `company` VALUES ('4', '90004', '�⺺�ܹ�˾', 'wuhan', '123456', 'wuhan@sina.com', '2', '2016-10-10 20:10:31', '2016-10-11 11:21:23', '2014120915125125', '1001');

-- ----------------------------
-- Table structure for nav
-- ----------------------------
DROP TABLE IF EXISTS `nav`;
CREATE TABLE `nav` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '�Զ����',
  `text` char(20) NOT NULL COMMENT '��������',
  `state` char(10) NOT NULL DEFAULT '' COMMENT '����״̬',
  `iconCls` char(20) NOT NULL DEFAULT '' COMMENT '����ͼ��',
  `url` char(50) NOT NULL DEFAULT '' COMMENT '��������',
  `nid` int(10) NOT NULL DEFAULT '0' COMMENT '�ڵ�',
  `auth` int(10) NOT NULL DEFAULT '4' COMMENT '��ɫ',
  `active` int(10) NOT NULL DEFAULT '1' COMMENT '�����Ƿ񼤻�',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nav
-- ----------------------------
INSERT INTO `nav` VALUES ('1', '����������Ϣ', 'closed', 'icon-flag-red', '', '0', '1', '1');
INSERT INTO `nav` VALUES ('2', '��װ���', 'open', 'icon-package-green', 'specification', '1', '1', '1');
INSERT INTO `nav` VALUES ('3', 'ũҩ����', 'open', 'icon-user', 'type', '1', '1', '1');
INSERT INTO `nav` VALUES ('4', 'ƿ��', 'open', 'icon-database', 'bottle', '1', '1', '1');
INSERT INTO `nav` VALUES ('5', '����', 'open', 'icon-box', 'box', '1', '1', '1');
INSERT INTO `nav` VALUES ('6', '������', 'open', 'icon-user', 'tray', '1', '1', '1');
INSERT INTO `nav` VALUES ('7', '��������', 'open', 'icon-user', 'pici', '1', '1', '1');
INSERT INTO `nav` VALUES ('8', '����������Ϣ', 'closed', 'icon-car', '', '0', '1', '1');
INSERT INTO `nav` VALUES ('9', 'Դ����������', 'open', 'icon-user', 'factoryinout', '8', '1', '1');
INSERT INTO `nav` VALUES ('10', '������������', 'open', 'icon-user', 'bussinessmaninout', '8', '1', '1');
INSERT INTO `nav` VALUES ('11', '������������', 'open', 'icon-user', 'sellmaninout', '8', '1', '1');
INSERT INTO `nav` VALUES ('12', '�ͻ���Ϣ', 'closed', 'icon-folder-user', '', '0', '1', '1');
INSERT INTO `nav` VALUES ('13', '������', 'open', 'icon-user', 'bussinessman', '12', '1', '1');
INSERT INTO `nav` VALUES ('14', '������', 'open', 'icon-user', 'sellman', '12', '1', '1');
INSERT INTO `nav` VALUES ('15', 'ũ��', 'open', 'icon-user', 'farmer', '12', '1', '1');
INSERT INTO `nav` VALUES ('16', '��������', 'closed', 'icon-money-yen', '', '0', '1', '1');
INSERT INTO `nav` VALUES ('17', '������', 'open', 'icon-coins', 'promotion', '16', '1', '1');
INSERT INTO `nav` VALUES ('18', '�Ż�ȯ', 'open', 'icon-user', 'coupon', '16', '1', '1');
INSERT INTO `nav` VALUES ('19', 'ϵͳ����', 'closed', 'icon-cog', '', '0', '1', '1');
INSERT INTO `nav` VALUES ('20', '����Ա����', 'open', 'icon-admin', 'manager', '19', '1', '1');
INSERT INTO `nav` VALUES ('21', 'ϵͳ��ɫ', 'open', 'icon-computer-key', 'rule', '19', '1', '1');
INSERT INTO `nav` VALUES ('22', 'ũҩ�ֵ�', 'open', 'icon-computer-key', 'pesticide', '19', '1', '1');
INSERT INTO `nav` VALUES ('23', '��˾����', 'open', 'icon-computer-key', 'company', '19', '1', '1');
INSERT INTO `nav` VALUES ('24', '�����ݱ���', 'closed', 'icon-chart-bar', '', '0', '1', '1');
INSERT INTO `nav` VALUES ('25', 'ͳ������', 'open', 'icon-chart-curve', 'statistics', '24', '1', '1');
INSERT INTO `nav` VALUES ('26', '��', 'em', 'em', 'em', '0', '0', '0');
INSERT INTO `nav` VALUES ('27', '��', 'em', 'em', 'em', '0', '0', '0');
INSERT INTO `nav` VALUES ('40', '����������Ϣ', 'closed', 'icon-flag-red', '', '0', '2', '1');
INSERT INTO `nav` VALUES ('41', '��װ���', 'open', 'icon-package-green', 'specification', '40', '2', '1');
INSERT INTO `nav` VALUES ('42', 'ũҩ����', 'open', 'icon-user', 'type', '40', '2', '1');
INSERT INTO `nav` VALUES ('43', 'ƿ��', 'open', 'icon-database', 'bottle', '40', '2', '1');
INSERT INTO `nav` VALUES ('44', '����', 'open', 'icon-box', 'box', '40', '2', '1');
INSERT INTO `nav` VALUES ('45', '������', 'open', 'icon-user', 'tray', '40', '2', '1');
INSERT INTO `nav` VALUES ('46', '��������', 'open', 'icon-user', 'pici', '40', '2', '1');
INSERT INTO `nav` VALUES ('47', '����������Ϣ', 'closed', 'icon-car', '', '0', '2', '1');
INSERT INTO `nav` VALUES ('48', 'Դ����������', 'open', 'icon-user', 'factoryinout', '47', '2', '1');
INSERT INTO `nav` VALUES ('49', '������������', 'open', 'icon-user', 'bussinessmaninout', '47', '2', '1');
INSERT INTO `nav` VALUES ('50', '������������', 'open', 'icon-user', 'sellmaninout', '47', '2', '1');
INSERT INTO `nav` VALUES ('51', '�ͻ���Ϣ', 'closed', 'icon-folder-user', '', '0', '2', '1');
INSERT INTO `nav` VALUES ('52', '������', 'open', 'icon-user', 'bussinessman', '51', '2', '1');
INSERT INTO `nav` VALUES ('53', '������', 'open', 'icon-user', 'sellman', '51', '2', '1');
INSERT INTO `nav` VALUES ('54', 'ũ��', 'open', 'icon-user', 'farmer', '51', '2', '1');
INSERT INTO `nav` VALUES ('55', '��������', 'closed', 'icon-money-yen', '', '0', '2', '1');
INSERT INTO `nav` VALUES ('56', '������', 'open', 'icon-coins', 'promotion', '55', '2', '1');
INSERT INTO `nav` VALUES ('57', '�Ż�ȯ', 'open', 'icon-user', 'coupon', '55', '2', '1');
INSERT INTO `nav` VALUES ('58', 'ϵͳ����', 'closed', 'icon-cog', '', '0', '2', '1');
INSERT INTO `nav` VALUES ('59', '����Ա����', 'open', 'icon-admin', 'manager', '58', '2', '1');
INSERT INTO `nav` VALUES ('60', 'ϵͳ��ɫ', 'open', 'icon-computer-key', 'rule', '58', '2', '1');
INSERT INTO `nav` VALUES ('61', 'ũҩ�ֵ�', 'open', 'icon-computer-key', 'pesticide', '58', '2', '1');
INSERT INTO `nav` VALUES ('62', '��˾����', 'open', 'icon-computer-key', 'company', '58', '2', '1');
INSERT INTO `nav` VALUES ('63', '�����ݱ���', 'closed', 'icon-chart-bar', '', '0', '2', '1');
INSERT INTO `nav` VALUES ('64', 'ͳ������', 'open', 'icon-chart-curve', 'statistics', '63', '2', '1');
INSERT INTO `nav` VALUES ('65', '', '', '', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('66', '', '', '', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('80', '����������Ϣ', 'closed', 'icon-flag-red', '', '0', '3', '1');
INSERT INTO `nav` VALUES ('81', '��װ���', 'open', 'icon-package-green', 'specification', '80', '3', '1');
INSERT INTO `nav` VALUES ('82', 'ũҩ����', 'open', 'icon-user', 'type', '80', '3', '1');
INSERT INTO `nav` VALUES ('83', 'ƿ��', 'open', 'icon-database', 'bottle', '80', '3', '1');
INSERT INTO `nav` VALUES ('84', '����', 'open', 'icon-box', 'box', '80', '3', '1');
INSERT INTO `nav` VALUES ('85', '������', 'open', 'icon-user', 'tray', '80', '3', '1');
INSERT INTO `nav` VALUES ('86', '��������', 'open', 'icon-user', 'pici', '80', '3', '1');
INSERT INTO `nav` VALUES ('87', '����������Ϣ', 'closed', 'icon-car', '', '0', '3', '1');
INSERT INTO `nav` VALUES ('88', 'Դ����������', 'open', 'icon-user', 'factoryinout', '87', '3', '1');
INSERT INTO `nav` VALUES ('89', '������������', 'open', 'icon-user', 'bussinessmaninout', '87', '3', '1');
INSERT INTO `nav` VALUES ('90', '������������', 'open', 'icon-user', 'sellmaninout', '87', '3', '1');
INSERT INTO `nav` VALUES ('91', '�ͻ���Ϣ', 'closed', 'icon-folder-user', '', '0', '3', '1');
INSERT INTO `nav` VALUES ('92', '������', 'open', 'icon-user', 'bussinessman', '91', '3', '1');
INSERT INTO `nav` VALUES ('93', '������', 'open', 'icon-user', 'sellman', '91', '3', '1');
INSERT INTO `nav` VALUES ('94', 'ũ��', 'open', 'icon-user', 'farmer', '91', '3', '1');
INSERT INTO `nav` VALUES ('95', '��������', 'closed', 'icon-money-yen', '', '0', '3', '1');
INSERT INTO `nav` VALUES ('96', '������', 'open', 'icon-coins', 'promotion', '95', '3', '1');
INSERT INTO `nav` VALUES ('97', '�Ż�ȯ', 'open', 'icon-user', 'coupon', '95', '3', '1');
INSERT INTO `nav` VALUES ('98', 'ϵͳ����', 'closed', 'icon-cog', '', '0', '3', '1');
INSERT INTO `nav` VALUES ('99', '����Ա����', 'open', 'icon-admin', 'manager', '98', '3', '1');
INSERT INTO `nav` VALUES ('100', 'ϵͳ��ɫ', 'open', 'icon-user', 'rule', '98', '3', '1');
INSERT INTO `nav` VALUES ('101', 'ũҩ�ֵ�', 'open', 'icon-computer-key', 'pesticide', '98', '3', '1');
INSERT INTO `nav` VALUES ('102', '��˾����', 'open', 'icon-computer-key', 'company', '98', '3', '1');
INSERT INTO `nav` VALUES ('103', '�����ݱ���', 'closed', 'icon-chart-bar', '', '0', '3', '1');
INSERT INTO `nav` VALUES ('104', 'ͳ������', 'open', 'icon-chart-curve', 'statistics', '103', '3', '1');
INSERT INTO `nav` VALUES ('107', '��', 'em', 'em', 'em', '0', '0', '0');
INSERT INTO `nav` VALUES ('108', '��', 'em', 'em', 'em', '0', '0', '0');
INSERT INTO `nav` VALUES ('120', '����������Ϣ', 'closed', 'icon-flag-red', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('121', '��װ���', 'open', 'icon-package-green', 'specification', '120', '4', '1');
INSERT INTO `nav` VALUES ('122', 'ũҩ����', 'open', 'icon-user', 'type', '120', '4', '1');
INSERT INTO `nav` VALUES ('123', 'ƿ��', 'open', 'icon-database', 'bottle', '120', '4', '1');
INSERT INTO `nav` VALUES ('124', '����', 'open', 'icon-box', 'box', '120', '4', '1');
INSERT INTO `nav` VALUES ('125', '������', 'open', 'icon-user', 'tray', '120', '4', '1');
INSERT INTO `nav` VALUES ('126', '��������', 'open', 'icon-user', 'pici', '120', '4', '1');
INSERT INTO `nav` VALUES ('127', '����������Ϣ', 'closed', 'icon-car', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('128', 'Դ����������', 'open', 'icon-user', 'factoryinout', '127', '4', '1');
INSERT INTO `nav` VALUES ('129', '������������', 'open', 'icon-user', 'bussinessmaninout', '127', '4', '1');
INSERT INTO `nav` VALUES ('130', '������������', 'open', 'icon-user', 'sellmaninout', '127', '4', '1');
INSERT INTO `nav` VALUES ('131', '�ͻ���Ϣ', 'closed', 'icon-folder-user', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('132', '������', 'open', 'icon-user', 'bussinessman', '131', '4', '1');
INSERT INTO `nav` VALUES ('133', '������', 'open', 'icon-user', 'sellman', '131', '4', '1');
INSERT INTO `nav` VALUES ('134', 'ũ��', 'open', 'icon-user', 'farmer', '131', '4', '1');
INSERT INTO `nav` VALUES ('135', '��������', 'closed', 'icon-money-yen', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('136', '������', 'open', 'icon-coins', 'promotion', '135', '4', '1');
INSERT INTO `nav` VALUES ('137', '�Ż�ȯ', 'open', 'icon-user', 'coupon', '135', '4', '1');
INSERT INTO `nav` VALUES ('138', 'ϵͳ����', 'closed', 'icon-cog', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('139', '����Ա����', 'open', 'icon-admin', 'manager', '138', '4', '1');
INSERT INTO `nav` VALUES ('140', 'ϵͳ��ɫ', 'open', 'icon-user', 'rule', '138', '4', '1');
INSERT INTO `nav` VALUES ('141', 'ũҩ�ֵ�', 'open', 'icon-computer-key', 'pesticide', '138', '4', '1');
INSERT INTO `nav` VALUES ('142', '��˾����', 'open', 'icon-computer-key', 'company', '138', '4', '1');
INSERT INTO `nav` VALUES ('143', '�����ݱ���', 'closed', 'icon-chart-bar', '', '0', '4', '1');
INSERT INTO `nav` VALUES ('144', 'ͳ������', 'open', 'icon-chart-curve', 'statistics', '143', '4', '1');
INSERT INTO `nav` VALUES ('147', '��', 'em', 'em', 'em', '0', '0', '0');
INSERT INTO `nav` VALUES ('148', '��', 'em', 'em', 'em', '0', '0', '0');

-- ----------------------------
-- Table structure for tb_bottle
-- ----------------------------
DROP TABLE IF EXISTS `tb_bottle`;
CREATE TABLE `tb_bottle` (
  `AUTO_ID` bigint(24) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` bigint(12) unsigned zerofill NOT NULL COMMENT 'ҩƿ���',
  `TYPE_ID` int(4) unsigned NOT NULL DEFAULT '0' COMMENT 'ũҩ����',
  `PDCDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '��������',
  `PACKDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '��װ����',
  `BOX_ID` bigint(12) unsigned zerofill NOT NULL DEFAULT '000000000000' COMMENT '����������',
  `PICI_ID` int(4) NOT NULL DEFAULT '0' COMMENT '��������',
  `COMPANY_ID` int(5) unsigned DEFAULT NULL COMMENT '������˾id',
  PRIMARY KEY (`AUTO_ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bottle
-- ----------------------------
INSERT INTO `tb_bottle` VALUES ('000000000000000000000001', '100000000001', '2', '2016-09-20', '2016-09-28', '200000000002', '3', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000002', '100000000002', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000003', '100000000003', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000004', '100000000004', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000005', '100000000005', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000006', '100000000006', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000007', '100000000007', '2', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000008', '100000000008', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000009', '100000000009', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000010', '100000000010', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000011', '100000000011', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000012', '100000000012', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000013', '100000000013', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000014', '100000000014', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000015', '100000000015', '1', '2016-06-28', '2016-06-29', '200000000001', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000016', '100000000016', '1', '2016-06-28', '2016-06-29', '200000000003', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000017', '100000000017', '1', '2016-06-28', '2016-06-29', '200000000003', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000018', '100000000018', '1', '2016-06-28', '2016-06-29', '200000000003', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000019', '100000000019', '1', '2016-06-28', '2016-06-29', '200000000003', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000020', '100000000020', '1', '2016-06-28', '2016-06-29', '200000000003', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000021', '100000000021', '1', '2016-06-28', '2016-06-29', '200000000002', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000022', '100000000022', '1', '2016-06-28', '2016-06-29', '200000000002', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000023', '100000000023', '1', '2016-06-28', '2016-06-29', '200000000002', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000024', '100000000024', '1', '2016-06-28', '2016-06-29', '200000000002', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000025', '100000000025', '1', '2016-06-28', '2016-06-29', '200000000002', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000042', '100000000033', '1', '0000-00-00', '2002-02-02', '200000000004', '1', '90001');
INSERT INTO `tb_bottle` VALUES ('000000000000000000000043', '100000000044', '1', '2004-01-01', '2004-02-02', '200000000010', '1', '90001');

-- ----------------------------
-- Table structure for tb_box
-- ----------------------------
DROP TABLE IF EXISTS `tb_box`;
CREATE TABLE `tb_box` (
  `AUTO_ID` bigint(24) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` bigint(12) unsigned zerofill NOT NULL COMMENT '���ӱ��',
  `CAPACITY` char(20) NOT NULL DEFAULT '' COMMENT '��������',
  `PICI_ID` int(4) NOT NULL DEFAULT '0' COMMENT '��������',
  `COMPANY_ID` int(5) DEFAULT NULL,
  PRIMARY KEY (`AUTO_ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_box
-- ----------------------------
INSERT INTO `tb_box` VALUES ('000000000000000000000001', '200000000001', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000002', '200000000002', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000003', '200000000003', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000004', '200000000004', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000005', '200000000005', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000006', '200000000006', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000007', '200000000007', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000008', '200000000008', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000009', '200000000009', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000010', '200000000010', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000011', '200000000011', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000012', '200000000012', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000013', '200000000013', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000014', '200000000014', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000015', '200000000015', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000016', '200000000016', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000017', '200000000017', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000018', '200000000018', '20ƿ/��', '1', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000019', '200000000019', '10ƿ/��', '5', '90001');
INSERT INTO `tb_box` VALUES ('000000000000000000000020', '200000000020', '10ƿ/��', '5', '90001');

-- ----------------------------
-- Table structure for tb_bussinessman
-- ----------------------------
DROP TABLE IF EXISTS `tb_bussinessman`;
CREATE TABLE `tb_bussinessman` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` int(4) unsigned NOT NULL COMMENT '�����̱��',
  `NAME` char(50) NOT NULL DEFAULT '' COMMENT '��������',
  `TEL` char(50) DEFAULT NULL COMMENT '��ϵ�绰',
  `PROVINCE` char(50) DEFAULT NULL COMMENT 'ʡ',
  `CITY` char(50) DEFAULT NULL COMMENT '��',
  `AREA` char(50) DEFAULT NULL COMMENT '��',
  `ADDRESS` char(50) DEFAULT NULL COMMENT '��ַ',
  PRIMARY KEY (`AUTO_ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bussinessman
-- ----------------------------
INSERT INTO `tb_bussinessman` VALUES ('1', '20001', '����ũҩ���۹�˾', '025-1234567', '����ʡ', '�Ͼ���', '��¥��', 'x�ֵ�x¥404');
INSERT INTO `tb_bussinessman` VALUES ('2', '20002', '���Ͼ����ܹ�˾', '13811112223', '����ʡ', '��ɳ��', '������', '����');
INSERT INTO `tb_bussinessman` VALUES ('3', '20003', '������������˾2', '11111111', '���ɹ�������', '���ͺ�����', '�³���', '������');
INSERT INTO `tb_bussinessman` VALUES ('4', '20004', '�ӱ���ᾭ����˾', '13932123102', '�ӱ�ʡ', null, null, '�ӱ�');
INSERT INTO `tb_bussinessman` VALUES ('5', '20005', '���չ�¥������˾1', '152619765431111', 'ɽ��ʡ', '������', '������', '�����Ͼ�');
INSERT INTO `tb_bussinessman` VALUES ('6', '20006', '���ս���������˾', '15276543211', '����ʡ', '�Ͼ���', '������', '�����Ͼ�');

-- ----------------------------
-- Table structure for tb_bussinessmaninout
-- ----------------------------
DROP TABLE IF EXISTS `tb_bussinessmaninout`;
CREATE TABLE `tb_bussinessmaninout` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `BUSSINESSMAN_ID` int(4) NOT NULL COMMENT '������',
  `BOX_ID` bigint(12) unsigned zerofill NOT NULL COMMENT '������',
  `INDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '���ʱ��',
  `OUTDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '����ʱ��',
  `POSITION` varchar(20) DEFAULT NULL COMMENT '��λ',
  `SELLMAN_ID` int(4) unsigned DEFAULT '0' COMMENT '����������',
  `BOTTLE_ID` bigint(24) unsigned zerofill DEFAULT NULL COMMENT 'ƿ��',
  PRIMARY KEY (`AUTO_ID`),
  KEY `btree1` (`BUSSINESSMAN_ID`,`BOX_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bussinessmaninout
-- ----------------------------
INSERT INTO `tb_bussinessmaninout` VALUES ('1', '20002', '200000000001', '2016-06-20', '2016-09-10', '', '30001', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('2', '20001', '200000000002', '2016-06-29', '0000-00-00', 'A-5-2', '30002', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('3', '20001', '200000000003', '2016-06-29', '0000-00-00', 'A-5-3', '30002', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('4', '20001', '200000000004', '2016-06-29', '0000-00-00', 'A-5-4', '30001', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('5', '20001', '200000000005', '2016-06-29', '0000-00-00', 'A-5-5', '0', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('6', '20002', '200000000006', '2016-06-29', '0000-00-00', '1-1', '0', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('7', '20002', '200000000007', '2016-06-29', '0000-00-00', '1-2', '0', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('8', '20002', '200000000008', '2016-06-29', '0000-00-00', '1-3', '0', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('9', '20002', '200000000009', '2016-06-29', '0000-00-00', '2-1', '0', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('10', '20002', '200000000010', '2016-06-29', '0000-00-00', '2-2', '0', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('14', '20002', '200000000011', '2009-01-01', '2010-01-01', '', '30002', null);
INSERT INTO `tb_bussinessmaninout` VALUES ('15', '20001', '200000000088', '1998-09-09', '1999-01-01', '', '30001', null);

-- ----------------------------
-- Table structure for tb_factoryinout
-- ----------------------------
DROP TABLE IF EXISTS `tb_factoryinout`;
CREATE TABLE `tb_factoryinout` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `BOX_ID` bigint(12) unsigned zerofill NOT NULL COMMENT '������',
  `INDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '���ʱ��',
  `OUTDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '����ʱ��',
  `POSITION` varchar(20) DEFAULT NULL COMMENT '��λ',
  `BUSSINESSMAN_ID` int(4) unsigned DEFAULT '0' COMMENT '����������',
  `POINT` varchar(128) NOT NULL DEFAULT '' COMMENT '��γ��',
  PRIMARY KEY (`AUTO_ID`),
  KEY `FK_BOX_ID` (`BOX_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_factoryinout
-- ----------------------------
INSERT INTO `tb_factoryinout` VALUES ('1', '200000000001', '2016-06-20', '2016-06-20', 'A15-71', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('2', '200000000002', '2016-06-27', '2016-06-29', 'A15-7', '20001', '');
INSERT INTO `tb_factoryinout` VALUES ('3', '200000000003', '2016-06-28', '2016-06-29', 'A15-7', '20001', '');
INSERT INTO `tb_factoryinout` VALUES ('4', '200000000004', '2016-06-29', '2016-06-29', 'A15-7', '20001', '');
INSERT INTO `tb_factoryinout` VALUES ('5', '200000000005', '2016-06-29', '2016-06-29', 'A15-7', '20001', '');
INSERT INTO `tb_factoryinout` VALUES ('6', '200000000006', '2016-06-29', '2016-06-29', 'A15-8', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('7', '200000000007', '2016-06-29', '2016-06-29', 'A15-8', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('8', '200000000008', '2016-06-29', '2016-06-29', 'A15-8', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('9', '200000000009', '2016-06-29', '2016-06-29', 'A15-8', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('10', '200000000010', '2016-06-29', '2016-06-29', 'A15-8', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('11', '200000000011', '2016-06-29', '2016-06-29', 'A15-7', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('12', '200000000012', '2016-06-29', '2016-06-29', 'A15-7', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('13', '200000000013', '2016-06-29', '2016-06-29', 'A15-7', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('14', '200000000014', '2016-06-29', '2016-06-29', 'A15-8', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('15', '200000000015', '2016-06-29', '2016-06-29', 'A15-8', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('16', '200000000016', '2016-06-29', '2016-06-29', 'A15-8', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('17', '200000000017', '2016-06-29', '2016-06-29', 'A15-8', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('18', '200000000018', '2016-06-29', '2016-06-29', 'A15-8', '0', '');
INSERT INTO `tb_factoryinout` VALUES ('20', '200000000020', '0000-00-00', '2009-09-09', 'A20', '1', '');
INSERT INTO `tb_factoryinout` VALUES ('21', '200000000033', '2008-01-01', '2009-02-02', 'A15-7', '20002', '');
INSERT INTO `tb_factoryinout` VALUES ('22', '200000000034', '2001-01-01', '2002-01-02', '', '0', '');

-- ----------------------------
-- Table structure for tb_farmer
-- ----------------------------
DROP TABLE IF EXISTS `tb_farmer`;
CREATE TABLE `tb_farmer` (
  `auto_id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `id` int(4) unsigned NOT NULL COMMENT '��Ա��ũ�������',
  `telnum` bigint(11) unsigned NOT NULL DEFAULT '10' COMMENT '�ֻ�����',
  `name` char(20) DEFAULT NULL COMMENT 'ũ������',
  `birthday` date DEFAULT NULL COMMENT '����',
  `registtime` date DEFAULT NULL COMMENT 'ע��ʱ��',
  `points` int(10) unsigned DEFAULT NULL COMMENT '��ǰ����',
  `lastfillformtime` datetime DEFAULT NULL COMMENT '�ϴ����ʱ��',
  `PROVINCE` char(50) DEFAULT NULL COMMENT 'ʡ',
  `CITY` char(50) DEFAULT NULL COMMENT '��',
  `AREA` char(50) DEFAULT NULL COMMENT '��',
  `ADDRESS` char(50) DEFAULT NULL COMMENT '�ֵ��ȵ�ַ',
  PRIMARY KEY (`auto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_farmer
-- ----------------------------
INSERT INTO `tb_farmer` VALUES ('1', '30000001', '13815891845', '�⺺', '2016-09-08', '2016-09-20', '1000', '2016-09-01 11:39:18', null, null, null, null);
INSERT INTO `tb_farmer` VALUES ('2', '30000002', '13654781254', '�⺺', '2016-09-08', '2016-09-20', '1000', '2016-09-01 11:39:18', null, null, null, null);
INSERT INTO `tb_farmer` VALUES ('3', '30000003', '15245693218', '�⺺', '2016-09-08', '2016-09-20', '1000', '2016-09-01 11:39:18', null, null, null, null);

-- ----------------------------
-- Table structure for tb_farmerlogin
-- ----------------------------
DROP TABLE IF EXISTS `tb_farmerlogin`;
CREATE TABLE `tb_farmerlogin` (
  `auto_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `id` int(20) unsigned NOT NULL COMMENT 'ũ��id',
  `telnum` bigint(11) unsigned NOT NULL DEFAULT '10' COMMENT '��¼�ֻ�����',
  `pwd` varchar(50) NOT NULL DEFAULT '' COMMENT 'ũ����¼����',
  `lastlogintime` datetime DEFAULT NULL COMMENT '�ϴε�¼ʱ��',
  PRIMARY KEY (`auto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_farmerlogin
-- ----------------------------
INSERT INTO `tb_farmerlogin` VALUES ('1', '30000001', '13815891845', '12345', '2016-10-20 21:05:53');

-- ----------------------------
-- Table structure for tb_pesticide
-- ----------------------------
DROP TABLE IF EXISTS `tb_pesticide`;
CREATE TABLE `tb_pesticide` (
  `auto_id` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '����id',
  `id` int(8) unsigned NOT NULL COMMENT '�Զ���id',
  `pname` varchar(50) NOT NULL DEFAULT '' COMMENT 'ũҩ��',
  `num` varchar(50) DEFAULT '' COMMENT '���ұ�׼���',
  `described` varchar(100) DEFAULT '' COMMENT 'ũҩ����',
  `solution` varchar(100) DEFAULT NULL COMMENT '�ж����',
  `usage` varchar(200) DEFAULT NULL COMMENT '�÷���;',
  `toxic` char(5) DEFAULT '0' COMMENT '����',
  PRIMARY KEY (`auto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pesticide
-- ----------------------------
INSERT INTO `tb_pesticide` VALUES ('00000001', '80001', '�е�η', 'GB_12345', '�˺��˻���������', '������ˮ��ȥҽԺ����', 'ÿ����300ml,��1����ˮ������������', '1');
INSERT INTO `tb_pesticide` VALUES ('00000002', '80002', '��ѽͪ', 'GB_12512_TF_124', 'һ�ֳ����', '������ˮ�����£�ȥҽԺ����', 'ÿ����300ml,��1����ˮ������������', '1');

-- ----------------------------
-- Table structure for tb_pici
-- ----------------------------
DROP TABLE IF EXISTS `tb_pici`;
CREATE TABLE `tb_pici` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` int(4) unsigned NOT NULL COMMENT '���κ�',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '��ע',
  `BTNUM` int(8) unsigned DEFAULT NULL COMMENT 'ƿ������',
  `BXNUM` int(8) unsigned DEFAULT NULL COMMENT '��������',
  `STATUS` int(1) unsigned DEFAULT '0' COMMENT '�Ƿ����ɹ���ά��',
  `TYPE_ID` int(8) unsigned DEFAULT NULL COMMENT 'ũҩ����',
  `COMPANY_ID` int(5) DEFAULT NULL,
  PRIMARY KEY (`AUTO_ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pici
-- ----------------------------
INSERT INTO `tb_pici` VALUES ('1', '1', '��������20160702', '60', '3', '0', '1', '90001');
INSERT INTO `tb_pici` VALUES ('2', '2', '��������20160820', '120', '6', '0', '2', '90001');
INSERT INTO `tb_pici` VALUES ('3', '3', '��������20160821', '12000', '600', '0', '3', '90001');
INSERT INTO `tb_pici` VALUES ('4', '4', '��������20160825', '2400', '120', '0', '4', '90001');
INSERT INTO `tb_pici` VALUES ('5', '5', '��������20080808', '100000', '5000', '0', '1', '90001');

-- ----------------------------
-- Table structure for tb_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_rule`;
CREATE TABLE `tb_rule` (
  `auto_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `id` int(10) unsigned NOT NULL COMMENT '��ɫid',
  `name` char(10) NOT NULL DEFAULT '' COMMENT '��ɫ��',
  `described` char(50) DEFAULT '' COMMENT '��ɫ����',
  `rule` int(10) unsigned NOT NULL COMMENT '��ɫȨ�޺�',
  PRIMARY KEY (`auto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_rule
-- ----------------------------
INSERT INTO `tb_rule` VALUES ('1', '1', '�����޵й���Ա', '��һ�еĹ���Ա', '1');
INSERT INTO `tb_rule` VALUES ('2', '2', '��ͨ����Ա', '��ҵһ�����Ա', '2');
INSERT INTO `tb_rule` VALUES ('3', '3', '�����̹���Ա', '�鿴������', '3');
INSERT INTO `tb_rule` VALUES ('4', '4', '�����̹���Ա', '�鿴������', '4');

-- ----------------------------
-- Table structure for tb_sellman
-- ----------------------------
DROP TABLE IF EXISTS `tb_sellman`;
CREATE TABLE `tb_sellman` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` int(4) NOT NULL COMMENT '�����̱��',
  `NAME` char(50) NOT NULL DEFAULT '' COMMENT '��������',
  `TEL` char(50) DEFAULT NULL COMMENT '��ϵ�绰',
  `PROVINCE` char(50) DEFAULT NULL COMMENT 'ʡ',
  `CITY` char(50) DEFAULT NULL COMMENT '��',
  `AREA` char(50) DEFAULT NULL COMMENT '��',
  `ADDRESS` char(50) DEFAULT NULL COMMENT '�ֵ���ַ',
  PRIMARY KEY (`AUTO_ID`,`ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sellman
-- ----------------------------
INSERT INTO `tb_sellman` VALUES ('1', '30001', '�γǾ�����˾', '025-12354678111111222', '������', '��Ͻ��', '������', '�γ���ĳ�ֵ�');
INSERT INTO `tb_sellman` VALUES ('2', '30002', '����������˾', '13800011112', '����ʡ', '������', null, '������');
INSERT INTO `tb_sellman` VALUES ('3', '30003', '��ͨ���۹�˾', '13000001112', '����ʡ', '��ͨ��', null, '��ͨ������');
INSERT INTO `tb_sellman` VALUES ('4', '30004', '���߾�����˾', null, '����ʡ', '̩����', null, null);
INSERT INTO `tb_sellman` VALUES ('5', '30005', '���Ͼ�����˾', null, '����ʡ', '������', '������', null);
INSERT INTO `tb_sellman` VALUES ('6', '30006', '���ݾ�����˾', '15271654321', '����ʡ', '������', '������', null);
INSERT INTO `tb_sellman` VALUES ('7', '30007', '�ձ�������˾', '15222222222', '����ʡ', '������', '������', null);
INSERT INTO `tb_sellman` VALUES ('8', '30008', '���ݵڶ�������˾', '15522211111', '����ʡ', '������', '������', null);
INSERT INTO `tb_sellman` VALUES ('9', '88', '�⺺������', '1521111111112121', '', '', '', null);

-- ----------------------------
-- Table structure for tb_sellmaninout
-- ----------------------------
DROP TABLE IF EXISTS `tb_sellmaninout`;
CREATE TABLE `tb_sellmaninout` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `SELLMAN_ID` int(4) NOT NULL COMMENT '������',
  `BOX_ID` bigint(12) unsigned zerofill NOT NULL COMMENT '������',
  `INDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '���ʱ��',
  `OUTDATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '����ʱ��',
  `POSITION` varchar(20) DEFAULT NULL COMMENT '��λ',
  `CUSTOMERNAME` varchar(20) DEFAULT 'δ�Ǽ�' COMMENT '������',
  `BOTTLE_ID` bigint(12) unsigned zerofill DEFAULT NULL COMMENT 'ƿ��',
  PRIMARY KEY (`AUTO_ID`),
  KEY `btree1` (`SELLMAN_ID`) USING BTREE,
  KEY `btree2` (`BOX_ID`) USING BTREE,
  KEY `btree3` (`BOTTLE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sellmaninout
-- ----------------------------
INSERT INTO `tb_sellmaninout` VALUES ('1', '30001', '200000000001', '2016-07-11', '2016-07-11', 's001', '�Ծ���1', '100000000001');
INSERT INTO `tb_sellmaninout` VALUES ('2', '30001', '200000000002', '2016-07-01', '2016-07-01', 's002', '����', '100000000021');
INSERT INTO `tb_sellmaninout` VALUES ('3', '30002', '200000000001', '2016-07-01', '0000-00-00', 's002', 'δ�Ǽ�', '100000000004');
INSERT INTO `tb_sellmaninout` VALUES ('5', '30002', '200000000003', '2016-09-07', '2016-09-08', 't101', 'δ�Ǽ�', '100000000041');
INSERT INTO `tb_sellmaninout` VALUES ('24', '30001', '200000000000', '0000-00-00', '0000-00-00', '', '1111', '100000000000');
INSERT INTO `tb_sellmaninout` VALUES ('26', '30002', '200000000002', '0000-00-00', '0000-00-00', '', '��', '100000000033');
INSERT INTO `tb_sellmaninout` VALUES ('27', '88', '200000000002', '1990-01-02', '1998-09-09', '', '�⺺', '100000000038');
INSERT INTO `tb_sellmaninout` VALUES ('28', '88', '200000000123', '1990-01-01', '1999-02-02', '', 'whan', '100000003232');
INSERT INTO `tb_sellmaninout` VALUES ('31', '88', '200000000001', '0000-00-00', '0000-00-00', '', '', '100000033323');

-- ----------------------------
-- Table structure for tb_specification
-- ----------------------------
DROP TABLE IF EXISTS `tb_specification`;
CREATE TABLE `tb_specification` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` int(4) unsigned NOT NULL COMMENT '���',
  `SPECIFICATION` char(20) NOT NULL DEFAULT '' COMMENT '���',
  `MATERIAL` char(10) DEFAULT '' COMMENT '��װ����',
  `MATERIALNO` int(1) unsigned DEFAULT '0' COMMENT '��װ���ʺ�',
  PRIMARY KEY (`AUTO_ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_specification
-- ----------------------------
INSERT INTO `tb_specification` VALUES ('1', '1', '400ml/ƿ', '����', '1');
INSERT INTO `tb_specification` VALUES ('2', '2', '250ml/ƿ', '����', '1');
INSERT INTO `tb_specification` VALUES ('3', '3', '10g/��', '����', '2');
INSERT INTO `tb_specification` VALUES ('4', '4', '20g/��', '����', '2');

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `AUTO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '����id',
  `ID` int(4) unsigned zerofill NOT NULL,
  `PESTICIDE_ID` int(8) unsigned NOT NULL COMMENT 'ũҩ��',
  `TYPE` char(20) NOT NULL DEFAULT '' COMMENT 'ũҩ����',
  `QGP` char(20) NOT NULL DEFAULT '' COMMENT '������',
  `SPECIFICATION_ID` int(4) unsigned NOT NULL COMMENT '��װ���',
  `COMPANY_ID` int(5) unsigned DEFAULT NULL COMMENT '��˾��',
  PRIMARY KEY (`AUTO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', '1001', '80002', '������', '24����', '1', '90001');
INSERT INTO `tb_type` VALUES ('2', '1002', '80002', '������', '24����', '2', '90001');
INSERT INTO `tb_type` VALUES ('3', '1003', '80002', '������', '24����', '3', '90001');
INSERT INTO `tb_type` VALUES ('4', '1004', '80002', '������', '24����', '4', '90001');

-- ----------------------------
-- Table structure for tb_userlogin
-- ----------------------------
DROP TABLE IF EXISTS `tb_userlogin`;
CREATE TABLE `tb_userlogin` (
  `auto_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `id` int(4) unsigned NOT NULL COMMENT '�����������۱��id',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '��¼�˺�',
  `pwd` varchar(50) NOT NULL DEFAULT '' COMMENT '����',
  `level` int(10) unsigned NOT NULL COMMENT '1������2������3����',
  PRIMARY KEY (`auto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userlogin
-- ----------------------------
INSERT INTO `tb_userlogin` VALUES ('1', '0', 'factory1', 'factory1', '1');
INSERT INTO `tb_userlogin` VALUES ('2', '0', 'factory2', 'factory2', '1');
INSERT INTO `tb_userlogin` VALUES ('3', '20001', 'bman1', 'bman1', '2');
INSERT INTO `tb_userlogin` VALUES ('4', '20002', 'bman2', 'bman2', '2');
INSERT INTO `tb_userlogin` VALUES ('5', '30001', 'sman1', 'sman1', '3');
INSERT INTO `tb_userlogin` VALUES ('6', '30002', 'sman2', 'sman2', '3');
