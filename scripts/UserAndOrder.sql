-- ----------------------------
-- Table structure for rush_order
-- ----------------------------
DROP TABLE IF EXISTS `rush_order`;
CREATE TABLE `rush_order`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_status` int NOT NULL,
  `seckill_activity_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `order_amount` decimal(10, 0) UNSIGNED NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `pay_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rush_order
-- ----------------------------
INSERT INTO `rush_order` VALUES (5, '524743559841189888', 1, 19, 1234, 5888, '2020-11-13 07:44:40', NULL);
INSERT INTO `rush_order` VALUES (6, '524744128538480640', 2, 19, 1234, 5888, '2020-11-13 07:46:55', '2020-11-13 08:01:19');

-- ----------------------------
-- Table structure for rush_user
-- ----------------------------
DROP TABLE IF EXISTS `rush_user`;
CREATE TABLE `rush_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rush_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;