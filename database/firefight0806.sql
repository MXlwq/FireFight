/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : firefight0626

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2015-08-06 14:47:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mconclusion`
-- ----------------------------
DROP TABLE IF EXISTS `mconclusion`;
CREATE TABLE `mconclusion` (
  `conclusion` int(11) NOT NULL,
  `conclusionName` varchar(45) DEFAULT NULL,
  `f` float(45,5) DEFAULT NULL,
  `c` float(45,5) DEFAULT NULL,
  `e` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`conclusion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mconclusion
-- ----------------------------
INSERT INTO `mconclusion` VALUES ('11', null, '0.95251', '0.96477', '0.93657');
INSERT INTO `mconclusion` VALUES ('12', null, '0.97516', '0.84372', '0.90090');

-- ----------------------------
-- Table structure for `templearn`
-- ----------------------------
DROP TABLE IF EXISTS `templearn`;
CREATE TABLE `templearn` (
  `leanrId` int(11) NOT NULL AUTO_INCREMENT,
  `Condition1` int(11) DEFAULT NULL,
  `Description1` varchar(45) DEFAULT NULL,
  `Condition2` int(11) DEFAULT NULL,
  `Description2` varchar(45) DEFAULT NULL,
  `Conclusion` int(11) DEFAULT NULL,
  `Frequency` float(45,5) DEFAULT NULL,
  `Confidence` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`leanrId`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of templearn
-- ----------------------------
INSERT INTO `templearn` VALUES ('42', '111', '少于-100-平米', '112', '少于-1000-立方米', '11', '0.89971', '0.66003');
INSERT INTO `templearn` VALUES ('43', '111', '少于-100-平米', '114', '初期', '11', '0.98075', '0.77112');
INSERT INTO `templearn` VALUES ('44', '112', '少于-1000-立方米', '114', '初期', '11', '0.86671', '0.51803');
INSERT INTO `templearn` VALUES ('45', '151', '大于-1000-平米', '152', '大于-10000-立方米', '15', '0.60000', '0.23077');
INSERT INTO `templearn` VALUES ('46', '131', '少于-600-平米', '132', '少于-5000-立方米', '13', '0.80000', '0.28161');
INSERT INTO `templearn` VALUES ('47', '131', '少于-600-平米', '134', '发展期', '13', '0.80000', '0.17355');
INSERT INTO `templearn` VALUES ('48', '132', '少于-5000-立方米', '134', '发展期', '13', '0.63218', '0.56625');
INSERT INTO `templearn` VALUES ('49', '122', '少于-3000-立方米', '124', '初期', '12', '0.80000', '0.28161');
INSERT INTO `templearn` VALUES ('50', '132', '少于-5000-立方米', '13501', '大', '13', '0.60000', '0.52830');
INSERT INTO `templearn` VALUES ('51', '134', '发展期', '13501', '大', '13', '0.95635', '0.52336');
INSERT INTO `templearn` VALUES ('52', '121', '少于-300-平米', '122', '少于-3000-立方米', '12', '0.74055', '0.52732');
INSERT INTO `templearn` VALUES ('53', '12502', '快', '12602', '小于5', '12', '0.80000', '0.66454');
INSERT INTO `templearn` VALUES ('54', '144', '发展期', '14502', '迅猛', '14', '0.60000', '0.13043');
INSERT INTO `templearn` VALUES ('55', '154', '发展期', '15502', '迅猛', '15', '0.60000', '0.13043');
INSERT INTO `templearn` VALUES ('56', '122', '少于-3000-立方米', '133', '大于3次且小于5次', '12', '0.60000', '0.23077');
INSERT INTO `templearn` VALUES ('57', '134', '发展期', '13502', '迅速', '13', '0.80000', '0.54044');
INSERT INTO `templearn` VALUES ('58', '13501', '大', '13502', '迅速', '13', '1.00000', '0.41410');
INSERT INTO `templearn` VALUES ('59', '134', '发展期', '13601', '小于10', '13', '0.80000', '0.55752');
INSERT INTO `templearn` VALUES ('60', '13501', '大', '13601', '小于10', '13', '1.00000', '0.52113');
INSERT INTO `templearn` VALUES ('61', '13502', '迅速', '13601', '小于10', '13', '0.80000', '0.43895');
INSERT INTO `templearn` VALUES ('62', '141', '少于-1000-平米', '153', '大于5次', '14', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('63', '141', '少于-1000-平米', '144', '发展期', '14', '0.80000', '0.28161');
INSERT INTO `templearn` VALUES ('64', '122', '少于-3000-立方米', '12501', '小', '12', '0.80000', '0.17355');
INSERT INTO `templearn` VALUES ('65', '122', '少于-3000-立方米', '12601', '小于5', '12', '0.80000', '0.28161');
INSERT INTO `templearn` VALUES ('66', '12501', '小', '12601', '小于5', '12', '0.60000', '0.21875');
INSERT INTO `templearn` VALUES ('67', '111', '少于-100-平米', '113', '少于3次', '11', '0.95064', '0.61366');
INSERT INTO `templearn` VALUES ('68', '112', '少于-1000-立方米', '113', '少于3次', '11', '0.92501', '0.51114');
INSERT INTO `templearn` VALUES ('69', '111', '少于-100-平米', '11501', '较小', '11', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('70', '112', '少于-1000-立方米', '11501', '较小', '11', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('71', '114', '初期', '11501', '较小', '11', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('72', '111', '少于-100-平米', '11502', '无', '11', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('73', '112', '少于-1000-立方米', '11502', '无', '11', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('74', '114', '初期', '11502', '无', '11', '0.80000', '0.38650');
INSERT INTO `templearn` VALUES ('75', '11501', '较小', '11502', '无', '11', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('76', '124', '初期', '12502', '快', '12', '1.00000', '0.25623');
INSERT INTO `templearn` VALUES ('77', '124', '初期', '12601', '小于5', '12', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('78', '12502', '快', '12601', '小于5', '12', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('79', '111', '少于-100-平米', '11602', '0', '11', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('80', '112', '少于-1000-立方米', '11602', '0', '11', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('81', '114', '初期', '11602', '0', '11', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('82', '111', '少于-100-平米', '12603', '0', '11', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('83', '112', '少于-1000-立方米', '12603', '0', '11', '1.00000', '0.44751');
INSERT INTO `templearn` VALUES ('84', '114', '初期', '12603', '0', '11', '1.00000', '0.44751');

-- ----------------------------
-- Table structure for `tempsimilarity`
-- ----------------------------
DROP TABLE IF EXISTS `tempsimilarity`;
CREATE TABLE `tempsimilarity` (
  `SimilarityId` int(11) NOT NULL AUTO_INCREMENT,
  `Level1` int(11) DEFAULT NULL,
  `Description1` varchar(45) DEFAULT NULL,
  `Level2` int(11) DEFAULT NULL,
  `Description2` varchar(45) DEFAULT NULL,
  `Frequency` float(45,5) DEFAULT NULL,
  `Confidence` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`SimilarityId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tempsimilarity
-- ----------------------------
INSERT INTO `tempsimilarity` VALUES ('25', '13', '三级火灾', '14', '四级火灾', '0.63583', '0.61849');
INSERT INTO `tempsimilarity` VALUES ('26', '13', '三级火灾', '15', '五级火灾', '0.63583', '0.61849');
INSERT INTO `tempsimilarity` VALUES ('27', '14', '四级火灾', '15', '五级火灾', '0.51412', '0.51149');
INSERT INTO `tempsimilarity` VALUES ('28', '11', '一级火灾', '12', '二级火灾', '0.92499', '0.67642');

-- ----------------------------
-- Table structure for `t_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `AreaId` int(11) NOT NULL,
  `AreaName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AreaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO `t_area` VALUES ('111', '少于-100-平米');
INSERT INTO `t_area` VALUES ('121', '少于-300-平米');
INSERT INTO `t_area` VALUES ('131', '少于-600-平米');
INSERT INTO `t_area` VALUES ('141', '少于-1000-平米');
INSERT INTO `t_area` VALUES ('151', '大于-1000-平米');

-- ----------------------------
-- Table structure for `t_callingtime`
-- ----------------------------
DROP TABLE IF EXISTS `t_callingtime`;
CREATE TABLE `t_callingtime` (
  `CallingTimeId` int(11) NOT NULL,
  `CallingTimeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CallingTimeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_callingtime
-- ----------------------------
INSERT INTO `t_callingtime` VALUES ('113', '少于3次');
INSERT INTO `t_callingtime` VALUES ('123', '大于3次且小于5次');
INSERT INTO `t_callingtime` VALUES ('133', '大于3次且小于5次');
INSERT INTO `t_callingtime` VALUES ('143', '大于5次');
INSERT INTO `t_callingtime` VALUES ('153', '大于5次');

-- ----------------------------
-- Table structure for `t_comburent`
-- ----------------------------
DROP TABLE IF EXISTS `t_comburent`;
CREATE TABLE `t_comburent` (
  `ComburentId` int(11) NOT NULL,
  `ComburentName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ComburentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comburent
-- ----------------------------
INSERT INTO `t_comburent` VALUES ('211', '居民住宅');
INSERT INTO `t_comburent` VALUES ('212', '仓库');
INSERT INTO `t_comburent` VALUES ('221', '高于二十四米的建筑物');
INSERT INTO `t_comburent` VALUES ('2101', '居民住宅');
INSERT INTO `t_comburent` VALUES ('2102', '仓库');
INSERT INTO `t_comburent` VALUES ('2103', '工厂');
INSERT INTO `t_comburent` VALUES ('2104', '企业');
INSERT INTO `t_comburent` VALUES ('2105', '商场');
INSERT INTO `t_comburent` VALUES ('2106', '集贸市场');
INSERT INTO `t_comburent` VALUES ('2107', '宾馆');
INSERT INTO `t_comburent` VALUES ('2108', '酒店');
INSERT INTO `t_comburent` VALUES ('2109', '娱乐场所');
INSERT INTO `t_comburent` VALUES ('2301', '地铁');
INSERT INTO `t_comburent` VALUES ('2302', '隧道');
INSERT INTO `t_comburent` VALUES ('2303', '地下商场');
INSERT INTO `t_comburent` VALUES ('2401', '石油化工单位 ');
INSERT INTO `t_comburent` VALUES ('2402', '储油罐');
INSERT INTO `t_comburent` VALUES ('2403', '油类运输工具');
INSERT INTO `t_comburent` VALUES ('2501', '天然气输送管道');
INSERT INTO `t_comburent` VALUES ('2502', '存气罐');
INSERT INTO `t_comburent` VALUES ('2503', '气体运输工具');
INSERT INTO `t_comburent` VALUES ('2601', '特殊气体单位');
INSERT INTO `t_comburent` VALUES ('2701', '粮食仓库');
INSERT INTO `t_comburent` VALUES ('2702', '木材场');
INSERT INTO `t_comburent` VALUES ('2703', '稻草场');
INSERT INTO `t_comburent` VALUES ('2801', '火车');
INSERT INTO `t_comburent` VALUES ('2802', '船舶');
INSERT INTO `t_comburent` VALUES ('2803', '飞机');
INSERT INTO `t_comburent` VALUES ('2804', '汽车');
INSERT INTO `t_comburent` VALUES ('2901', '电器');
INSERT INTO `t_comburent` VALUES ('2902', '单体汽车');
INSERT INTO `t_comburent` VALUES ('2903', '垃圾');

-- ----------------------------
-- Table structure for `t_conclusion`
-- ----------------------------
DROP TABLE IF EXISTS `t_conclusion`;
CREATE TABLE `t_conclusion` (
  `conclusion` int(11) NOT NULL DEFAULT '0',
  `f` float(45,5) DEFAULT NULL,
  `c` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`conclusion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_conclusion
-- ----------------------------
INSERT INTO `t_conclusion` VALUES ('11', '0.95251', '0.96477');
INSERT INTO `t_conclusion` VALUES ('311', '0.95251', '0.78146');

-- ----------------------------
-- Table structure for `t_danger`
-- ----------------------------
DROP TABLE IF EXISTS `t_danger`;
CREATE TABLE `t_danger` (
  `DangerId` int(11) NOT NULL,
  `DangerName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DangerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_danger
-- ----------------------------
INSERT INTO `t_danger` VALUES ('11701', '无');
INSERT INTO `t_danger` VALUES ('12701', '爆炸');
INSERT INTO `t_danger` VALUES ('13701', '爆炸');
INSERT INTO `t_danger` VALUES ('14701', '爆炸');
INSERT INTO `t_danger` VALUES ('15701', '爆炸');

-- ----------------------------
-- Table structure for `t_deathtoll`
-- ----------------------------
DROP TABLE IF EXISTS `t_deathtoll`;
CREATE TABLE `t_deathtoll` (
  `DeathTollId` int(11) NOT NULL,
  `DeathTollName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DeathTollId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_deathtoll
-- ----------------------------
INSERT INTO `t_deathtoll` VALUES ('11603', '0');
INSERT INTO `t_deathtoll` VALUES ('12603', '0');
INSERT INTO `t_deathtoll` VALUES ('13603', '小于3人');
INSERT INTO `t_deathtoll` VALUES ('14603', '大于3人以上');
INSERT INTO `t_deathtoll` VALUES ('15603', '大于10人');

-- ----------------------------
-- Table structure for `t_dispatch`
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatch`;
CREATE TABLE `t_dispatch` (
  `DispatchId` int(10) NOT NULL,
  `TypeId` int(50) DEFAULT NULL,
  `LevelId` int(50) DEFAULT NULL,
  `FireFighterNum` varchar(100) DEFAULT NULL,
  `Equipment` varchar(100) DEFAULT NULL,
  `Frequency` varchar(45) DEFAULT NULL,
  `Confidence` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DispatchId`),
  KEY `kf_type_idx` (`TypeId`),
  KEY `fk_level_idx` (`LevelId`),
  CONSTRAINT `fk_level` FOREIGN KEY (`LevelId`) REFERENCES `t_firelevel` (`FireLevelid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `kf_type` FOREIGN KEY (`TypeId`) REFERENCES `t_firetype` (`FireTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dispatch
-- ----------------------------
INSERT INTO `t_dispatch` VALUES ('311', '21', '11', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('313', '23', '11', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('314', '24', '11', '二十五名-消防员', '两辆防化消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('315', '25', '11', '二十五名-消防员', '一辆水罐消防车∩一辆泡沫消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('316', '26', '11', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('317', '27', '11', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('318', '28', '11', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('319', '29', '11', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('321', '21', '12', '八十名-消防员', '五辆水罐消防车∩一辆抢险救援车∩一辆云梯消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('322', '22', '12', '七十名-消防员', '四辆灌水消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('323', '23', '12', '七十五名-消防员', '六辆灌水消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('324', '24', '12', '七十五名-消防员', '四辆防化消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('325', '25', '12', '七十五名-消防员', '三辆灌水消防车∩两辆泡沫消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('326', '26', '12', '八十名-消防员', ' 两辆灌水消防车∩ 两辆泡沫消防车∩一辆照明∩ 两辆灌水消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('327', '27', '12', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('328', '28', '12', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('329', '29', '12', '二十五名-消防员', '两辆水罐消防车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('331', '21', '13', '一百八十名-消防员', '六辆水罐消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('332', '22', '13', '二百二十名-消防员', '八辆灌水消防车∩一辆抢险救援车∩一辆登高车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('333', '23', '13', '二百二十名-消防员', '五辆灌水消防车∩三辆泡沫消防车∩ 两辆抢险救援车∩两辆照明车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('334', '24', '13', '二百名-消防员', '四辆防化消防车∩四辆泡沫消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('335', '25', '13', '二百名-消防员', '八辆灌水消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('336', '26', '13', '二百二十名-消防员', ' 六辆防化消防车∩一辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('337', '27', '13', '二百二十名-消防员', '六辆水罐消防车∩两辆抢险救援车∩一辆高喷车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('338', '28', '13', '二百二十名-消防员', '四辆水罐消防车∩四辆泡沫消防车∩两辆抢险救援车∩一辆照明车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('339', '29', '13', '二百二十名  -消防员', 'xx', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('341', '21', '14', '四百五十名-消防员', '十二辆水罐消防车∩两辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('342', '22', '14', '五百五十名-消防员', '十二辆灌水消防车∩两辆抢险救援车∩两辆登高车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('343', '23', '14', '五百五十名-消防员', '八辆灌水消防车∩四辆泡沫消防车∩两辆抢险救援车∩一辆照明车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('344', '24', '14', '五百名-消防员', '六辆防化消防车∩六辆泡沫消防车∩二辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('345', '25', '14', '五百名-消防员', '十二辆灌水消防车∩两辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('346', '26', '14', '五百名-消防员', '十辆防化消防车∩两辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('347', '27', '14', '五百五十名-消防员', '十辆水罐消防车∩两辆抢险救援车∩两辆高喷车∩一辆云梯车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('348', '28', '14', '五百五十名-消防员', ' 六辆水罐消防车∩六辆泡沫消防车∩六辆抢险救援车∩两辆照明车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('349', '29', '14', '五百五十名-消防员', 'xx', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('351', '21', '15', '一千名-消防员', '二十四辆水罐消防车∩两辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('352', '22', '15', '一千名-消防员', '十六辆灌水消防车∩两辆抢险救援车∩两辆登高车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('353', '23', '15', '一千名-消防员', '十二辆灌水消防车∩四辆泡沫消防车∩ 两辆抢险救援车∩一辆照明车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('354', '24', '15', '一千名-消防员', '九辆防化消防车∩七辆泡沫消防车∩两辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('355', '25', '15', '一千名-消防员', '十六辆灌水消防车∩两辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('356', '26', '15', '一千名-消防员', '十六辆防化消防车∩三辆抢险救援车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('357', '27', '15', '一千名-消防员', '十四辆水罐消防车∩两辆抢险救援车∩两辆高喷车∩两辆云梯车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('358', '28', '15', '一千名-消防员', '八辆水罐消防车∩八辆泡沫消防车∩两辆抢险救援车∩两辆照明车', '1.0', '0.9');
INSERT INTO `t_dispatch` VALUES ('359', '29', '15', '一千名-消防员', 'xx', '1.0', '0.9');

-- ----------------------------
-- Table structure for `t_fire`
-- ----------------------------
DROP TABLE IF EXISTS `t_fire`;
CREATE TABLE `t_fire` (
  `fireId` int(11) NOT NULL,
  `fireName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`fireId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fire
-- ----------------------------
INSERT INTO `t_fire` VALUES ('11501', '较小');
INSERT INTO `t_fire` VALUES ('12501', '小');
INSERT INTO `t_fire` VALUES ('13501', '大');
INSERT INTO `t_fire` VALUES ('14501', '很大');
INSERT INTO `t_fire` VALUES ('15501', '严峻');

-- ----------------------------
-- Table structure for `t_firelevel`
-- ----------------------------
DROP TABLE IF EXISTS `t_firelevel`;
CREATE TABLE `t_firelevel` (
  `FireLevelid` int(11) NOT NULL,
  `FireLevelName` varchar(45) DEFAULT NULL,
  `Frequency` float(45,5) DEFAULT NULL,
  `Confidence` float(45,5) DEFAULT NULL,
  `Areaid` int(11) NOT NULL,
  `VolumeId` int(11) NOT NULL,
  `CallingTimeId` int(11) NOT NULL,
  `StageId` int(11) NOT NULL,
  `FireId` int(11) NOT NULL,
  `SpreadingId` int(11) NOT NULL,
  `TrappedpeopleId` int(11) NOT NULL,
  `InjuredPeolpeId` int(11) NOT NULL,
  `DeathTollid` int(11) NOT NULL,
  `Dangerid` int(11) NOT NULL,
  PRIMARY KEY (`FireLevelid`),
  KEY `fk_area_idx` (`Areaid`),
  KEY `fk_volume_idx` (`VolumeId`),
  KEY `fk_callingtime_idx` (`CallingTimeId`),
  KEY `fk_fire_idx` (`FireId`),
  KEY `fk_stage_idx` (`StageId`),
  KEY `fk_fire_idx1` (`FireId`),
  KEY `fk_stage_idx1` (`SpreadingId`),
  KEY `fk_trappedpeople_idx` (`TrappedpeopleId`),
  KEY `fk_injuredpeople_idx` (`InjuredPeolpeId`),
  KEY `fk_death_idx` (`DeathTollid`),
  KEY `fk_danger_idx` (`Dangerid`),
  KEY `fk_danger_idx1` (`Dangerid`),
  CONSTRAINT `fk_area` FOREIGN KEY (`Areaid`) REFERENCES `t_area` (`AreaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_callingtime` FOREIGN KEY (`CallingTimeId`) REFERENCES `t_callingtime` (`CallingTimeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_danger` FOREIGN KEY (`Dangerid`) REFERENCES `t_danger` (`DangerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_death` FOREIGN KEY (`DeathTollid`) REFERENCES `t_deathtoll` (`DeathTollId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fire` FOREIGN KEY (`FireId`) REFERENCES `t_fire` (`fireId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_injuredpeople` FOREIGN KEY (`InjuredPeolpeId`) REFERENCES `t_injuredpleople` (`InjuredPleopleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_spreading` FOREIGN KEY (`SpreadingId`) REFERENCES `t_spreading` (`SpreadingId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stage` FOREIGN KEY (`StageId`) REFERENCES `t_stage` (`StageId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trappedpeople` FOREIGN KEY (`TrappedpeopleId`) REFERENCES `t_trappedpeople` (`TrappedPeopleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_volume` FOREIGN KEY (`VolumeId`) REFERENCES `t_volume` (`VolumeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_firelevel
-- ----------------------------
INSERT INTO `t_firelevel` VALUES ('11', '一级火灾', '1.00000', '1.00000', '111', '112', '113', '114', '11501', '11502', '11601', '11602', '11603', '11701');
INSERT INTO `t_firelevel` VALUES ('12', '二级火灾', '1.00000', '1.00000', '121', '122', '123', '124', '12501', '12502', '12601', '12602', '12603', '12701');
INSERT INTO `t_firelevel` VALUES ('13', '三级火灾', '1.00000', '1.00000', '131', '132', '133', '134', '13501', '13502', '13601', '13602', '13603', '13701');
INSERT INTO `t_firelevel` VALUES ('14', '四级火灾', '1.00000', '1.00000', '141', '142', '143', '144', '14501', '14502', '14601', '14602', '14603', '14701');
INSERT INTO `t_firelevel` VALUES ('15', '五级火灾', '1.00000', '1.00000', '151', '152', '153', '154', '15501', '15502', '15601', '15602', '15603', '15701');

-- ----------------------------
-- Table structure for `t_firetype`
-- ----------------------------
DROP TABLE IF EXISTS `t_firetype`;
CREATE TABLE `t_firetype` (
  `FireTypeId` int(11) NOT NULL,
  `FireTypeName` varchar(45) DEFAULT NULL,
  `ComburentId` int(11) DEFAULT NULL,
  `Frequency` float(45,5) DEFAULT NULL,
  `Confidence` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`FireTypeId`),
  KEY `fk_comburent_idx` (`ComburentId`),
  CONSTRAINT `fk_comburent` FOREIGN KEY (`ComburentId`) REFERENCES `t_comburent` (`ComburentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_firetype
-- ----------------------------
INSERT INTO `t_firetype` VALUES ('21', '一般性建筑火灾', '211', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('22', '高层建筑火灾', '221', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('23', '地下空间火灾', '2301', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('24', '油类火灾', '2401', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('25', '一般气体火灾', '2501', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('26', '毒气火灾', '2601', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('27', '露天堆场火灾', '2701', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('28', '交通工具火灾', '2801', '1.00000', '0.90000');
INSERT INTO `t_firetype` VALUES ('29', '一般性火灾', '2901', '1.00000', '0.90000');

-- ----------------------------
-- Table structure for `t_injuredpleople`
-- ----------------------------
DROP TABLE IF EXISTS `t_injuredpleople`;
CREATE TABLE `t_injuredpleople` (
  `InjuredPleopleId` int(11) NOT NULL,
  `InjuredPleopleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`InjuredPleopleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_injuredpleople
-- ----------------------------
INSERT INTO `t_injuredpleople` VALUES ('11602', '0');
INSERT INTO `t_injuredpleople` VALUES ('12602', '小于5');
INSERT INTO `t_injuredpleople` VALUES ('13602', '小于10');
INSERT INTO `t_injuredpleople` VALUES ('14602', '10人以上');
INSERT INTO `t_injuredpleople` VALUES ('15602', '20人以上');

-- ----------------------------
-- Table structure for `t_input`
-- ----------------------------
DROP TABLE IF EXISTS `t_input`;
CREATE TABLE `t_input` (
  `input` int(11) NOT NULL DEFAULT '0',
  `conclusion` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `f` float(45,5) DEFAULT NULL,
  `c` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`input`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input
-- ----------------------------
INSERT INTO `t_input` VALUES ('111', '11', '少于-100-平米', '0.80000', '0.70000');
INSERT INTO `t_input` VALUES ('112', '11', '少于-1000-立方米', '1.00000', '0.90000');
INSERT INTO `t_input` VALUES ('113', '11', null, '1.00000', '0.90000');
INSERT INTO `t_input` VALUES ('114', '11', '初期', '1.00000', '0.90000');
INSERT INTO `t_input` VALUES ('124', '12', '初期', '1.00000', '0.90000');
INSERT INTO `t_input` VALUES ('11501', '11', '较小', '1.00000', '0.90000');
INSERT INTO `t_input` VALUES ('11502', '11', '无', '0.80000', '0.70000');
INSERT INTO `t_input` VALUES ('11601', '11', '0', '0.80000', '0.70000');

-- ----------------------------
-- Table structure for `t_learn`
-- ----------------------------
DROP TABLE IF EXISTS `t_learn`;
CREATE TABLE `t_learn` (
  `leanrId` int(11) NOT NULL AUTO_INCREMENT,
  `Condition1` int(11) DEFAULT NULL,
  `Description1` varchar(45) DEFAULT NULL,
  `Condition2` int(11) DEFAULT NULL,
  `Description2` varchar(45) DEFAULT NULL,
  `Conclusion` int(11) DEFAULT NULL,
  `Frequency` float(45,5) DEFAULT NULL,
  `Confidence` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`leanrId`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_learn
-- ----------------------------
INSERT INTO `t_learn` VALUES ('42', '111', '少于-100-平米', '112', '少于-1000-立方米', '11', '0.89828', '0.66326');
INSERT INTO `t_learn` VALUES ('43', '111', '少于-100-平米', '114', '初期', '11', '0.97183', '0.77993');
INSERT INTO `t_learn` VALUES ('44', '112', '少于-1000-立方米', '114', '初期', '11', '0.87880', '0.54171');
INSERT INTO `t_learn` VALUES ('45', '151', '大于-1000-平米', '152', '大于-10000-立方米', '15', '0.60000', '0.23077');
INSERT INTO `t_learn` VALUES ('46', '131', '少于-600-平米', '132', '少于-5000-立方米', '13', '0.80000', '0.28161');
INSERT INTO `t_learn` VALUES ('47', '131', '少于-600-平米', '134', '发展期', '13', '0.80000', '0.17355');
INSERT INTO `t_learn` VALUES ('48', '132', '少于-5000-立方米', '134', '发展期', '13', '0.63218', '0.56625');
INSERT INTO `t_learn` VALUES ('49', '122', '少于-3000-立方米', '124', '初期', '12', '0.80000', '0.28161');
INSERT INTO `t_learn` VALUES ('50', '132', '少于-5000-立方米', '13501', '大', '13', '0.60000', '0.52830');
INSERT INTO `t_learn` VALUES ('51', '134', '发展期', '13501', '大', '13', '0.95635', '0.52336');
INSERT INTO `t_learn` VALUES ('52', '121', '少于-300-平米', '122', '少于-3000-立方米', '12', '0.74055', '0.52732');
INSERT INTO `t_learn` VALUES ('53', '12502', '快', '12602', '小于5', '12', '0.80000', '0.66454');
INSERT INTO `t_learn` VALUES ('54', '144', '发展期', '14502', '迅猛', '14', '0.60000', '0.13043');
INSERT INTO `t_learn` VALUES ('55', '154', '发展期', '15502', '迅猛', '15', '0.60000', '0.13043');
INSERT INTO `t_learn` VALUES ('56', '122', '少于-3000-立方米', '133', '大于3次且小于5次', '12', '0.60000', '0.23077');
INSERT INTO `t_learn` VALUES ('57', '134', '发展期', '13502', '迅速', '13', '0.80000', '0.54044');
INSERT INTO `t_learn` VALUES ('58', '13501', '大', '13502', '迅速', '13', '1.00000', '0.41410');
INSERT INTO `t_learn` VALUES ('59', '134', '发展期', '13601', '小于10', '13', '0.80000', '0.55752');
INSERT INTO `t_learn` VALUES ('60', '13501', '大', '13601', '小于10', '13', '1.00000', '0.52113');
INSERT INTO `t_learn` VALUES ('61', '13502', '迅速', '13601', '小于10', '13', '0.80000', '0.43895');
INSERT INTO `t_learn` VALUES ('62', '141', '少于-1000-平米', '153', '大于5次', '14', '0.80000', '0.38650');
INSERT INTO `t_learn` VALUES ('63', '141', '少于-1000-平米', '144', '发展期', '14', '0.80000', '0.28161');
INSERT INTO `t_learn` VALUES ('64', '122', '少于-3000-立方米', '12501', '小', '12', '0.80000', '0.17355');
INSERT INTO `t_learn` VALUES ('65', '122', '少于-3000-立方米', '12601', '小于5', '12', '0.80000', '0.28161');
INSERT INTO `t_learn` VALUES ('66', '12501', '小', '12601', '小于5', '12', '0.60000', '0.21875');
INSERT INTO `t_learn` VALUES ('67', '111', '少于-100-平米', '113', '少于3次', '11', '0.93859', '0.63323');
INSERT INTO `t_learn` VALUES ('68', '112', '少于-1000-立方米', '113', '少于3次', '11', '0.93079', '0.53116');
INSERT INTO `t_learn` VALUES ('69', '111', '少于-100-平米', '11501', '较小', '11', '0.80000', '0.55752');
INSERT INTO `t_learn` VALUES ('70', '112', '少于-1000-立方米', '11501', '较小', '11', '0.86128', '0.47597');
INSERT INTO `t_learn` VALUES ('71', '114', '初期', '11501', '较小', '11', '0.84745', '0.45233');
INSERT INTO `t_learn` VALUES ('72', '111', '少于-100-平米', '11502', '无', '11', '0.80000', '0.50544');
INSERT INTO `t_learn` VALUES ('73', '112', '少于-1000-立方米', '11502', '无', '11', '0.84870', '0.45437');
INSERT INTO `t_learn` VALUES ('74', '114', '初期', '11502', '无', '11', '0.83882', '0.43874');
INSERT INTO `t_learn` VALUES ('75', '11501', '较小', '11502', '无', '11', '1.00000', '0.48148');
INSERT INTO `t_learn` VALUES ('76', '124', '初期', '12502', '快', '12', '1.00000', '0.25623');
INSERT INTO `t_learn` VALUES ('77', '124', '初期', '12601', '小于5', '12', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('78', '12502', '快', '12601', '小于5', '12', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('79', '111', '少于-100-平米', '11602', '0', '11', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('80', '112', '少于-1000-立方米', '11602', '0', '11', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('81', '114', '初期', '11602', '0', '11', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('82', '111', '少于-100-平米', '12603', '0', '11', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('83', '112', '少于-1000-立方米', '12603', '0', '11', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('84', '114', '初期', '12603', '0', '11', '1.00000', '0.44751');
INSERT INTO `t_learn` VALUES ('85', '111', '少于-100-平米', '11601', '0', '11', '0.80000', '0.28161');
INSERT INTO `t_learn` VALUES ('86', '112', '少于-1000-立方米', '11601', '0', '11', '1.00000', '0.33511');
INSERT INTO `t_learn` VALUES ('87', '114', '初期', '11601', '0', '11', '1.00000', '0.33511');
INSERT INTO `t_learn` VALUES ('88', '11501', '较小', '11601', '0', '11', '1.00000', '0.33511');
INSERT INTO `t_learn` VALUES ('89', '11502', '无', '11601', '0', '11', '0.80000', '0.28161');

-- ----------------------------
-- Table structure for `t_operator`
-- ----------------------------
DROP TABLE IF EXISTS `t_operator`;
CREATE TABLE `t_operator` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `identityCard` varchar(30) DEFAULT NULL,
  `workdate` datetime DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_operator
-- ----------------------------
INSERT INTO `t_operator` VALUES ('1', 'n', null, null, null, null, null, '', 'n');

-- ----------------------------
-- Table structure for `t_similarity`
-- ----------------------------
DROP TABLE IF EXISTS `t_similarity`;
CREATE TABLE `t_similarity` (
  `SimilarityId` int(11) NOT NULL AUTO_INCREMENT,
  `Level1` int(11) DEFAULT NULL,
  `Description1` varchar(45) DEFAULT NULL,
  `Level2` int(11) DEFAULT NULL,
  `Description2` varchar(45) DEFAULT NULL,
  `Frequency` float(45,5) DEFAULT NULL,
  `Confidence` float(45,5) DEFAULT NULL,
  PRIMARY KEY (`SimilarityId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_similarity
-- ----------------------------
INSERT INTO `t_similarity` VALUES ('25', '13', '三级火灾', '14', '四级火灾', '0.63583', '0.61849');
INSERT INTO `t_similarity` VALUES ('26', '13', '三级火灾', '15', '五级火灾', '0.63583', '0.61849');
INSERT INTO `t_similarity` VALUES ('27', '14', '四级火灾', '15', '五级火灾', '0.51412', '0.51149');
INSERT INTO `t_similarity` VALUES ('28', '11', '一级火灾', '12', '二级火灾', '0.94594', '0.74362');

-- ----------------------------
-- Table structure for `t_spreading`
-- ----------------------------
DROP TABLE IF EXISTS `t_spreading`;
CREATE TABLE `t_spreading` (
  `SpreadingId` int(11) NOT NULL,
  `SpreadingName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SpreadingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_spreading
-- ----------------------------
INSERT INTO `t_spreading` VALUES ('11502', '无');
INSERT INTO `t_spreading` VALUES ('12502', '快');
INSERT INTO `t_spreading` VALUES ('13502', '迅速');
INSERT INTO `t_spreading` VALUES ('14502', '迅猛');
INSERT INTO `t_spreading` VALUES ('15502', '迅猛');

-- ----------------------------
-- Table structure for `t_stage`
-- ----------------------------
DROP TABLE IF EXISTS `t_stage`;
CREATE TABLE `t_stage` (
  `StageId` int(11) NOT NULL,
  `StageName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stage
-- ----------------------------
INSERT INTO `t_stage` VALUES ('114', '初期');
INSERT INTO `t_stage` VALUES ('124', '初期');
INSERT INTO `t_stage` VALUES ('134', '发展期');
INSERT INTO `t_stage` VALUES ('144', '发展期');
INSERT INTO `t_stage` VALUES ('154', '发展期');

-- ----------------------------
-- Table structure for `t_trappedpeople`
-- ----------------------------
DROP TABLE IF EXISTS `t_trappedpeople`;
CREATE TABLE `t_trappedpeople` (
  `TrappedPeopleId` int(11) NOT NULL,
  `TrappedPeopleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TrappedPeopleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_trappedpeople
-- ----------------------------
INSERT INTO `t_trappedpeople` VALUES ('11601', '0');
INSERT INTO `t_trappedpeople` VALUES ('12601', '小于5');
INSERT INTO `t_trappedpeople` VALUES ('13601', '小于10');
INSERT INTO `t_trappedpeople` VALUES ('14601', '大于10');
INSERT INTO `t_trappedpeople` VALUES ('15601', '大于15');

-- ----------------------------
-- Table structure for `t_volume`
-- ----------------------------
DROP TABLE IF EXISTS `t_volume`;
CREATE TABLE `t_volume` (
  `VolumeId` int(11) NOT NULL,
  `VolumeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`VolumeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_volume
-- ----------------------------
INSERT INTO `t_volume` VALUES ('112', '少于-1000-立方米');
INSERT INTO `t_volume` VALUES ('122', '少于-3000-立方米');
INSERT INTO `t_volume` VALUES ('132', '少于-5000-立方米');
INSERT INTO `t_volume` VALUES ('142', '少于-10000-立方米');
INSERT INTO `t_volume` VALUES ('152', '大于-10000-立方米');

-- ----------------------------
-- Procedure structure for `clearConclusion`
-- ----------------------------
DROP PROCEDURE IF EXISTS `clearConclusion`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clearConclusion`()
BEGIN
	#Routine body goes here...
	 truncate table mconclusion;
	 truncate table t_input;
	 truncate table t_conclusion;
	 truncate table tempLearn;
	 truncate table tempSimilarity;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `findMax`
-- ----------------------------
DROP PROCEDURE IF EXISTS `findMax`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findMax`()
BEGIN
	DECLARE done INT;
	DECLARE maxE FLOAT;
	DECLARE cConclu INTEGER;
	DECLARE cF FLOAT;
	DECLARE cC FLOAT;
	DECLARE cE FLOAT;
	DECLARE mCluCursor CURSOR FOR SELECT f,c FROM mconclusion;
	DECLARE mCursor CURSOR FOR SELECT e FROM mconclusion;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
	
	SET done = 0;
	OPEN mCluCursor;
	mCluLoop:LOOP
	FETCH mCluCursor INTO cF,cC;
		IF (done = 1) THEN LEAVE mCluLoop; END IF;
		SET cE = cC*(cF-0.5)+0.5;
		UPDATE mconclusion
		SET e = cE
		WHERE f = cF AND c = cC;

	END LOOP mCluLoop;
	CLOSE mCluCursor;

	SET maxE = 0;
	SET done = 0;
	OPEN mCursor;
	mLoop:LOOP
	FETCH mCursor INTO cE;
		IF (done = 1) THEN LEAVE mLoop; END IF;
		IF maxE<cE THEN
			SET maxE = cE;
		END IF;

	END LOOP mLoop;
	CLOSE mCursor;
	
	INSERT INTO t_conclusion
	SELECT conclusion,f,c
	FROM mconclusion
	WHERE mconclusion.e = maxE;
	

END
;;
DELIMITER ;
