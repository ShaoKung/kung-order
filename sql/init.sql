CREATE DATABASE `busiOrder` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


-- busiOrder.T_BUSI_ORDER definition

CREATE TABLE `T_BUSI_ORDER` (
  `ORDER_ID` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PROVINCE_CODE` varchar(2) NOT NULL,
  `CITY` varchar(4) DEFAULT NULL,
  `DISTRICT` varchar(6) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `PHONE` varchar(16) NOT NULL,
  `COMM_PRICE` double NOT NULL,
  `COMM_COUNT` int NOT NULL,
  `COMM_ID` varchar(16) NOT NULL,
  `POST_ID` varchar(16) DEFAULT NULL,
  `ORDER_TIME` datetime NOT NULL,
  `EXT_ORDER_ID` varchar(40) NOT NULL COMMENT '外部订单号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- busiOrder.T_BUSI_ORDERLOG definition

CREATE TABLE `T_BUSI_ORDERLOG` (
  `ORDER_ID` varchar(100) NOT NULL,
  `ACCEPT_DATE` datetime NOT NULL,
  `ORDER_MSG` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PROVINCE_CODE` varchar(10) NOT NULL,
  `TYPE` varchar(2) NOT NULL COMMENT '日志类型，1：下单消息、2：其他'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='下单报文表';


-- busiOrder.T_BUSI_PAYINFO definition

CREATE TABLE `T_BUSI_PAYINFO` (
  `ORDER_ID` varchar(20) NOT NULL,
  `PAY_ID` varchar(20) NOT NULL,
  `PAY_TYPE` varchar(2) DEFAULT NULL COMMENT '支付类型，0：微信，1：支付宝',
  `PAY_MONEY` double DEFAULT NULL COMMENT '支付金额',
  `PAY_TIME` datetime DEFAULT NULL COMMENT '支付时间',
  `PAY_ACCOUNT` varchar(30) DEFAULT NULL COMMENT '支付账号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- busiOrder.T_BUSI_POSTINFO definition

CREATE TABLE `T_BUSI_POSTINFO` (
  `ORDER_ID` varchar(20) NOT NULL,
  `POST_ID` varchar(20) NOT NULL,
  `CHECKED` varchar(2) DEFAULT NULL COMMENT '快递是否核验，0：没有核验，1：已经核验',
  `CHECK_STAFF` varchar(20) DEFAULT NULL COMMENT '核验人员，如果收件的时候未指定，默认为揽收人',
  `COLLECT_STAFF` varchar(20) DEFAULT NULL,
  `COLLECT_TIME` datetime DEFAULT NULL COMMENT '揽收时间',
  `WEIGHT` double DEFAULT NULL COMMENT '快递重量',
  `FROM_PROV` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '快递发出省份',
  `FROM_CITY` varchar(4) DEFAULT NULL COMMENT '快递发出地市',
  `FROM_DIST` varchar(8) DEFAULT NULL COMMENT '快递发出区县',
  `FROM_ADDR` varchar(40) DEFAULT NULL COMMENT '快递发出地址',
  `DEST_PROV` varchar(2) DEFAULT NULL COMMENT '快递目标省份',
  `DEST_CITY` varchar(4) DEFAULT NULL COMMENT '快递目标地市',
  `DEST_DIST` varchar(8) DEFAULT NULL COMMENT '快递目标区县',
  `DEST_ADDR` varchar(40) DEFAULT NULL COMMENT '快递目标地址',
  `RECE_NAME` varchar(20) DEFAULT NULL COMMENT '收件人姓名',
  `RECE_PHON` varchar(20) DEFAULT NULL COMMENT '收件人电话',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '快递备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;