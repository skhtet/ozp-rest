--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: changelog_master.groovy
--  Ran at: 8/28/14 7:25 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/mpcreate
--  Liquibase version: 2.0.5
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE `DATABASECHANGELOGLOCK` (`ID` INT NOT NULL, `LOCKED` TINYINT(1) NOT NULL, `LOCKGRANTED` DATETIME NULL, `LOCKEDBY` VARCHAR(255) NULL, CONSTRAINT `PK_DATABASECHANGELOGLOCK` PRIMARY KEY (`ID`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`) VALUES (1, 0);

--  Lock Database
--  Create Database Change Log Table
CREATE TABLE `DATABASECHANGELOG` (`ID` VARCHAR(63) NOT NULL, `AUTHOR` VARCHAR(63) NOT NULL, `FILENAME` VARCHAR(200) NOT NULL, `DATEEXECUTED` DATETIME NOT NULL, `ORDEREXECUTED` INT NOT NULL, `EXECTYPE` VARCHAR(10) NOT NULL, `MD5SUM` VARCHAR(35) NULL, `DESCRIPTION` VARCHAR(255) NULL, `COMMENTS` VARCHAR(255) NULL, `TAG` VARCHAR(255) NULL, `LIQUIBASE` VARCHAR(20) NULL, CONSTRAINT `PK_DATABASECHANGELOG` PRIMARY KEY (`ID`, `AUTHOR`, `FILENAME`)) ENGINE=InnoDB;

--  Changeset changelog_master.groovy::1409268087922-1::rvsz (generated)::(Checksum: 3:1f5d38f6c5391dcc50cd9a53f0bd0a93)
CREATE TABLE `affiliated_marketplace` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `active` INT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_id` BIGINT NULL, `name` VARCHAR(50) NOT NULL, `server_url` VARCHAR(2083) NOT NULL, `timeout` BIGINT NULL, CONSTRAINT `affiliated_maPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-1', '2.0.5', '3:1f5d38f6c5391dcc50cd9a53f0bd0a93', 1);

--  Changeset changelog_master.groovy::1409268087922-2::rvsz (generated)::(Checksum: 3:e413eee7f1c670e57ccabaf3041c0cf2)
CREATE TABLE `agency` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_url` VARCHAR(2000) NOT NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `agencyPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-2', '2.0.5', '3:e413eee7f1c670e57ccabaf3041c0cf2', 2);

--  Changeset changelog_master.groovy::1409268087922-3::rvsz (generated)::(Checksum: 3:a3517e0e46953925625e1905cbf83145)
CREATE TABLE `application_configuration` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `code` VARCHAR(255) NOT NULL, `description` VARCHAR(255) NULL, `group_name` VARCHAR(255) NOT NULL, `help` VARCHAR(255) NULL, `mutable` bit NOT NULL, `sub_group_name` VARCHAR(255) NULL, `sub_group_order` INT NULL, `title` VARCHAR(255) NOT NULL, `type` VARCHAR(255) NOT NULL, `value` VARCHAR(255) NULL, CONSTRAINT `application_cPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-3', '2.0.5', '3:a3517e0e46953925625e1905cbf83145', 3);

--  Changeset changelog_master.groovy::1409268087922-4::rvsz (generated)::(Checksum: 3:e7e6e0d82829f03c13f2c90878afbfe7)
CREATE TABLE `avatar` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `content_type` VARCHAR(255) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `is_default` bit NOT NULL, `pic` mediumblob NULL, CONSTRAINT `avatarPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-4', '2.0.5', '3:e7e6e0d82829f03c13f2c90878afbfe7', 4);

--  Changeset changelog_master.groovy::1409268087922-5::rvsz (generated)::(Checksum: 3:3c8612802ba92d864bcc75af84bc9bd0)
CREATE TABLE `category` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `categoryPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-5', '2.0.5', '3:3c8612802ba92d864bcc75af84bc9bd0', 5);

--  Changeset changelog_master.groovy::1409268087922-6::rvsz (generated)::(Checksum: 3:98e78239cb364b058aa28d438f0a6f3c)
CREATE TABLE `change_detail` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `field_name` VARCHAR(255) NOT NULL, `new_value` VARCHAR(4000) NULL, `old_value` VARCHAR(4000) NULL, `service_item_activity_id` BIGINT NOT NULL, CONSTRAINT `change_detailPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-6', '2.0.5', '3:98e78239cb364b058aa28d438f0a6f3c', 6);

--  Changeset changelog_master.groovy::1409268087922-7::rvsz (generated)::(Checksum: 3:abba04221822b2d3ac6e8b1011f40bd4)
CREATE TABLE `check_box_cf` (`id` BIGINT NOT NULL, `value` bit NULL, CONSTRAINT `check_box_cfPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-7', '2.0.5', '3:abba04221822b2d3ac6e8b1011f40bd4', 7);

--  Changeset changelog_master.groovy::1409268087922-8::rvsz (generated)::(Checksum: 3:08f698447fff372074098d473727465c)
CREATE TABLE `check_box_cfd` (`id` BIGINT NOT NULL, `selected_by_default` bit NULL, CONSTRAINT `check_box_cfdPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-8', '2.0.5', '3:08f698447fff372074098d473727465c', 8);

--  Changeset changelog_master.groovy::1409268087922-9::rvsz (generated)::(Checksum: 3:2fd2da818906249dcf154d70b688320a)
CREATE TABLE `contact` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(100) NOT NULL, `name` VARCHAR(100) NOT NULL, `organization` VARCHAR(100) NULL, `secure_phone` VARCHAR(50) NULL, `service_item_id` BIGINT NOT NULL, `type_id` BIGINT NOT NULL, `unsecure_phone` VARCHAR(50) NULL, CONSTRAINT `contactPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-9', '2.0.5', '3:2fd2da818906249dcf154d70b688320a', 9);

--  Changeset changelog_master.groovy::1409268087922-10::rvsz (generated)::(Checksum: 3:73e507e6e52c79361a2c768bb9c118df)
CREATE TABLE `contact_type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `required` bit NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `contact_typePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-10', '2.0.5', '3:73e507e6e52c79361a2c768bb9c118df', 10);

--  Changeset changelog_master.groovy::1409268087922-11::rvsz (generated)::(Checksum: 3:e03179959d9ad7042eae2847df6ef654)
CREATE TABLE `custom_field` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `custom_field_definition_id` BIGINT NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, CONSTRAINT `custom_fieldPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-11', '2.0.5', '3:e03179959d9ad7042eae2847df6ef654', 11);

--  Changeset changelog_master.groovy::1409268087922-12::rvsz (generated)::(Checksum: 3:ddb23519ca0394119a5ca12403dd2ce0)
CREATE TABLE `custom_field_definition` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `all_types` bit NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `is_permanent` bit NULL, `is_required` bit NOT NULL, `label` VARCHAR(50) NOT NULL, `name` VARCHAR(50) NOT NULL, `section` VARCHAR(255) NULL, `style_type` VARCHAR(255) NOT NULL, `tooltip` VARCHAR(50) NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `custom_field_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-12', '2.0.5', '3:ddb23519ca0394119a5ca12403dd2ce0', 12);

--  Changeset changelog_master.groovy::1409268087922-13::rvsz (generated)::(Checksum: 3:e06856dce827b1902cd7c284269fbf61)
CREATE TABLE `custom_field_definition_types` (`cf_definition_types_id` BIGINT NULL, `types_id` BIGINT NULL, `types_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-13', '2.0.5', '3:e06856dce827b1902cd7c284269fbf61', 13);

--  Changeset changelog_master.groovy::1409268087922-14::rvsz (generated)::(Checksum: 3:8bad284909f640ab1b5a3bc225f2aae0)
CREATE TABLE `default_images` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `defined_default_type` VARCHAR(255) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_id` BIGINT NOT NULL, CONSTRAINT `default_imagePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-14', '2.0.5', '3:8bad284909f640ab1b5a3bc225f2aae0', 14);

--  Changeset changelog_master.groovy::1409268087922-15::rvsz (generated)::(Checksum: 3:762a6a4ffcd02fc32626dc5cf1670142)
CREATE TABLE `drop_down_cf` (`id` BIGINT NOT NULL, `value_id` BIGINT NULL, CONSTRAINT `drop_down_cfPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-15', '2.0.5', '3:762a6a4ffcd02fc32626dc5cf1670142', 15);

--  Changeset changelog_master.groovy::1409268087922-16::rvsz (generated)::(Checksum: 3:5486eb34099f30b10b8de3b8f824047f)
CREATE TABLE `drop_down_cf_field_value` (`drop_down_cf_field_value_id` BIGINT NULL, `field_value_id` BIGINT NULL, `field_value_list_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-16', '2.0.5', '3:5486eb34099f30b10b8de3b8f824047f', 16);

--  Changeset changelog_master.groovy::1409268087922-17::rvsz (generated)::(Checksum: 3:39f30597959f4526c4925b92e5e083a5)
CREATE TABLE `drop_down_cfd` (`id` BIGINT NOT NULL, `is_multi_select` bit NULL, CONSTRAINT `drop_down_cfdPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-17', '2.0.5', '3:39f30597959f4526c4925b92e5e083a5', 17);

--  Changeset changelog_master.groovy::1409268087922-18::rvsz (generated)::(Checksum: 3:5a925436362f010afc7c68f3a3592fe5)
CREATE TABLE `ext_profile` (`id` BIGINT NOT NULL, `external_edit_url` VARCHAR(2083) NULL, `external_id` VARCHAR(255) NULL, `external_view_url` VARCHAR(2083) NULL, `system_uri` VARCHAR(255) NOT NULL, CONSTRAINT `ext_profilePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-18', '2.0.5', '3:5a925436362f010afc7c68f3a3592fe5', 18);

--  Changeset changelog_master.groovy::1409268087922-19::rvsz (generated)::(Checksum: 3:2b5f64d24a72dd87f7775009007ffdc6)
CREATE TABLE `field_value` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `custom_field_definition_id` BIGINT NOT NULL, `display_text` VARCHAR(255) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `is_enabled` INT NOT NULL, `field_values_idx` INT NULL, CONSTRAINT `field_valuePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-19', '2.0.5', '3:2b5f64d24a72dd87f7775009007ffdc6', 19);

--  Changeset changelog_master.groovy::1409268087922-20::rvsz (generated)::(Checksum: 3:79edb0d451fbf0d2169db7f8c84d2792)
CREATE TABLE `image_url_cf` (`id` BIGINT NOT NULL, `value` VARCHAR(2083) NULL, CONSTRAINT `image_url_cfPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-20', '2.0.5', '3:79edb0d451fbf0d2169db7f8c84d2792', 20);

--  Changeset changelog_master.groovy::1409268087922-21::rvsz (generated)::(Checksum: 3:af88d44f5daa9ff18542be0062263946)
CREATE TABLE `image_url_cfd` (`id` BIGINT NOT NULL, CONSTRAINT `image_url_cfdPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-21', '2.0.5', '3:af88d44f5daa9ff18542be0062263946', 21);

--  Changeset changelog_master.groovy::1409268087922-22::rvsz (generated)::(Checksum: 3:cd7194106bc54a86b229a5a36543e41d)
CREATE TABLE `images` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `bytes` mediumblob NOT NULL, `content_type` VARCHAR(255) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_size` double precision NULL, `is_default` bit NOT NULL, `type` VARCHAR(255) NOT NULL, CONSTRAINT `imagesPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-22', '2.0.5', '3:cd7194106bc54a86b229a5a36543e41d', 22);

--  Changeset changelog_master.groovy::1409268087922-23::rvsz (generated)::(Checksum: 3:ab10ac2aed1beb1454addfca3aa05ea0)
CREATE TABLE `import_task` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `cron_exp` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `enabled` bit NOT NULL, `exec_interval` INT NULL, `extra_url_params` VARCHAR(512) NULL, `interface_config_id` BIGINT NOT NULL, `keystore_pass` VARCHAR(2048) NULL, `keystore_path` VARCHAR(2048) NULL, `last_run_result_id` BIGINT NULL, `name` VARCHAR(50) NOT NULL, `truststore_path` VARCHAR(2048) NULL, `update_type` VARCHAR(7) NOT NULL, `url` VARCHAR(255) NULL, CONSTRAINT `import_taskPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-23', '2.0.5', '3:ab10ac2aed1beb1454addfca3aa05ea0', 23);

--  Changeset changelog_master.groovy::1409268087922-24::rvsz (generated)::(Checksum: 3:2c4db683b45130f9966f2cf458679d9e)
CREATE TABLE `import_task_result` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `message` VARCHAR(4000) NOT NULL, `result` bit NOT NULL, `run_date` DATETIME NOT NULL, `task_id` BIGINT NOT NULL, CONSTRAINT `import_task_rPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-24', '2.0.5', '3:2c4db683b45130f9966f2cf458679d9e', 24);

--  Changeset changelog_master.groovy::1409268087922-25::rvsz (generated)::(Checksum: 3:b7bcd6a774813c71330b345ae2587e2c)
CREATE TABLE `intent` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `data_type_id` BIGINT NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `receive` bit NOT NULL, `send` bit NOT NULL, CONSTRAINT `intentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-25', '2.0.5', '3:b7bcd6a774813c71330b345ae2587e2c', 25);

--  Changeset changelog_master.groovy::1409268087922-26::rvsz (generated)::(Checksum: 3:365527042d2437a24dae64170b83f1ad)
CREATE TABLE `intent_action` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(256) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(256) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `intent_actionPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-26', '2.0.5', '3:365527042d2437a24dae64170b83f1ad', 26);

--  Changeset changelog_master.groovy::1409268087922-27::rvsz (generated)::(Checksum: 3:7caa8271888d7b331581eb007be57633)
CREATE TABLE `intent_data_type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(256) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(256) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `intent_data_tPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-27', '2.0.5', '3:7caa8271888d7b331581eb007be57633', 27);

--  Changeset changelog_master.groovy::1409268087922-28::rvsz (generated)::(Checksum: 3:7d42e3300cd6c6b1301c1a7541cb70cd)
CREATE TABLE `intent_direction` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(7) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `intent_directPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-28', '2.0.5', '3:7d42e3300cd6c6b1301c1a7541cb70cd', 28);

--  Changeset changelog_master.groovy::1409268087922-29::rvsz (generated)::(Checksum: 3:cff3f65d09133dba3925f79a95a7fdd5)
CREATE TABLE `interface_configuration` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `allow_truncate` bit NOT NULL, `auto_create_meta_data` bit NOT NULL, `default_large_icon_url` VARCHAR(2048) NULL, `default_small_icon_url` VARCHAR(2048) NULL, `delta_since_time_param` VARCHAR(64) NULL, `delta_static_parameters` VARCHAR(2048) NULL, `download_images` bit NOT NULL, `full_static_parameters` VARCHAR(2048) NULL, `loose_match` bit NOT NULL, `name` VARCHAR(256) NOT NULL, `query_date_format` VARCHAR(32) NULL, `response_date_format` VARCHAR(32) NULL, CONSTRAINT `interface_conPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-29', '2.0.5', '3:cff3f65d09133dba3925f79a95a7fdd5', 29);

--  Changeset changelog_master.groovy::1409268087922-30::rvsz (generated)::(Checksum: 3:656ef6835c8374c290ca788221b3a463)
CREATE TABLE `item_comment` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `rate` FLOAT NULL, `service_item_id` BIGINT NOT NULL, `text` VARCHAR(4000) NULL, CONSTRAINT `item_commentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-30', '2.0.5', '3:656ef6835c8374c290ca788221b3a463', 30);

--  Changeset changelog_master.groovy::1409268087922-31::rvsz (generated)::(Checksum: 3:b700c0fb68ed1e67cb011c8f9a3e81c7)
CREATE TABLE `modify_relationship_activity` (`id` BIGINT NOT NULL, CONSTRAINT `modify_relatiPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-31', '2.0.5', '3:b700c0fb68ed1e67cb011c8f9a3e81c7', 31);

--  Changeset changelog_master.groovy::1409268087922-32::rvsz (generated)::(Checksum: 3:f60b5ba9f4036768a272364c4828b14d)
CREATE TABLE `owf_properties` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `background` bit NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `descriptor_url` VARCHAR(2083) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `height` BIGINT NULL, `mobile_ready` bit NOT NULL, `owf_widget_type` VARCHAR(255) NOT NULL, `singleton` bit NOT NULL, `stack_context` VARCHAR(200) NULL, `stack_descriptor` longtext NULL, `universal_name` VARCHAR(255) NULL, `visible_in_launch` bit NOT NULL, `width` BIGINT NULL, CONSTRAINT `owf_propertiePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-32', '2.0.5', '3:f60b5ba9f4036768a272364c4828b14d', 32);

--  Changeset changelog_master.groovy::1409268087922-33::rvsz (generated)::(Checksum: 3:0456aa091eb83c59466dd215234dfcb5)
CREATE TABLE `owf_properties_intent` (`owf_properties_intents_id` BIGINT NOT NULL, `intent_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-33', '2.0.5', '3:0456aa091eb83c59466dd215234dfcb5', 33);

--  Changeset changelog_master.groovy::1409268087922-34::rvsz (generated)::(Checksum: 3:d64077b83e972a70165b0bb2dcf9c2e4)
CREATE TABLE `owf_widget_types` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(255) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `owf_widget_tyPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-34', '2.0.5', '3:d64077b83e972a70165b0bb2dcf9c2e4', 34);

--  Changeset changelog_master.groovy::1409268087922-35::rvsz (generated)::(Checksum: 3:a72901002f2b93c3ed260bfd85f7e76c)
CREATE TABLE `profile` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `avatar_id` BIGINT NULL, `bio` VARCHAR(1000) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `display_name` VARCHAR(256) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(256) NULL, `user_roles` VARCHAR(255) NULL, `username` VARCHAR(255) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `profilePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-35', '2.0.5', '3:a72901002f2b93c3ed260bfd85f7e76c', 35);

--  Changeset changelog_master.groovy::1409268087922-36::rvsz (generated)::(Checksum: 3:68b34fdc60312d9ae718e899b7ed900a)
CREATE TABLE `rejection_activity` (`id` BIGINT NOT NULL, `rejection_listing_id` BIGINT NULL, CONSTRAINT `rejection_actPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-36', '2.0.5', '3:68b34fdc60312d9ae718e899b7ed900a', 36);

--  Changeset changelog_master.groovy::1409268087922-37::rvsz (generated)::(Checksum: 3:5dff13cffd0e02292154f45a2be3aa4f)
CREATE TABLE `rejection_justification` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `rejection_jusPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-37', '2.0.5', '3:5dff13cffd0e02292154f45a2be3aa4f', 37);

--  Changeset changelog_master.groovy::1409268087922-38::rvsz (generated)::(Checksum: 3:73999ab49978c811debcc63163528418)
CREATE TABLE `rejection_listing` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(2000) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `justification_id` BIGINT NULL, `service_item_id` BIGINT NOT NULL, CONSTRAINT `rejection_lisPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-38', '2.0.5', '3:73999ab49978c811debcc63163528418', 38);

--  Changeset changelog_master.groovy::1409268087922-39::rvsz (generated)::(Checksum: 3:35de2004bba9f2010a19fae71c5caa1c)
CREATE TABLE `relationship` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `owning_entity_id` BIGINT NOT NULL, `relationship_type` VARCHAR(255) NOT NULL, CONSTRAINT `relationshipPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-39', '2.0.5', '3:35de2004bba9f2010a19fae71c5caa1c', 39);

--  Changeset changelog_master.groovy::1409268087922-40::rvsz (generated)::(Checksum: 3:ccbc00586b719fb2cd9e95552f14a51e)
CREATE TABLE `relationship_activity_log` (`mod_rel_activity_id` BIGINT NOT NULL, `service_item_snapshot_id` BIGINT NULL, `items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-40', '2.0.5', '3:ccbc00586b719fb2cd9e95552f14a51e', 40);

--  Changeset changelog_master.groovy::1409268087922-41::rvsz (generated)::(Checksum: 3:3353ece6d39474face902dc7cb745ae5)
CREATE TABLE `relationship_service_item` (`relationship_related_items_id` BIGINT NULL, `service_item_id` BIGINT NULL, `related_items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-41', '2.0.5', '3:3353ece6d39474face902dc7cb745ae5', 41);

--  Changeset changelog_master.groovy::1409268087922-42::rvsz (generated)::(Checksum: 3:2fe6f76873fca5a11804f8f1b5c510e4)
CREATE TABLE `score_card_item` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(500) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image` VARCHAR(250) NULL, `question` VARCHAR(250) NOT NULL, `show_on_listing` bit NULL, CONSTRAINT `score_card_itPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-42', '2.0.5', '3:2fe6f76873fca5a11804f8f1b5c510e4', 42);

--  Changeset changelog_master.groovy::1409268087922-43::rvsz (generated)::(Checksum: 3:569f18e5b3ee6de4159e8e5832d60fbd)
CREATE TABLE `screenshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `large_image_url` VARCHAR(2083) NULL, `service_item_id` BIGINT NOT NULL, `small_image_url` VARCHAR(2083) NOT NULL, `ordinal` INT NULL, CONSTRAINT `screenshotPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-43', '2.0.5', '3:569f18e5b3ee6de4159e8e5832d60fbd', 43);

--  Changeset changelog_master.groovy::1409268087922-44::rvsz (generated)::(Checksum: 3:dc3227a798f9e3db8139efd81efd0379)
CREATE TABLE `service_item` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `agency_id` BIGINT NULL, `approval_status` VARCHAR(11) NOT NULL, `approved_date` DATETIME NULL, `avg_rate` FLOAT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `dependencies` VARCHAR(1000) NULL, `description` VARCHAR(4000) NULL, `description_short` VARCHAR(150) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_large_url` VARCHAR(2083) NULL, `image_medium_url` VARCHAR(2083) NULL, `image_small_url` VARCHAR(2083) NULL, `install_url` VARCHAR(2083) NULL, `is_hidden` INT NOT NULL, `is_outside` bit NULL, `last_activity_id` BIGINT NULL, `launch_url` VARCHAR(2083) NULL, `opens_in_new_browser_tab` bit NOT NULL, `organization` VARCHAR(256) NULL, `owf_properties_id` BIGINT NULL, `release_date` DATETIME NULL, `requirements` VARCHAR(1000) NULL, `title` VARCHAR(256) NOT NULL, `total_comments` INT NOT NULL, `total_rate1` INT NULL, `total_rate2` INT NULL, `total_rate3` INT NULL, `total_rate4` INT NULL, `total_rate5` INT NULL, `total_votes` INT NOT NULL, `types_id` BIGINT NOT NULL, `uuid` VARCHAR(255) NOT NULL, `version_name` VARCHAR(256) NULL, `what_is_new` VARCHAR(250) NULL, CONSTRAINT `service_itemPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-44', '2.0.5', '3:dc3227a798f9e3db8139efd81efd0379', 44);

--  Changeset changelog_master.groovy::1409268087922-45::rvsz (generated)::(Checksum: 3:df721953caa6b8f438fd7dc2b63f6fc7)
CREATE TABLE `service_item_activity` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action` VARCHAR(255) NOT NULL, `activity_date` DATETIME NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `service_item_id` BIGINT NOT NULL, `service_item_activities_idx` INT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-45', '2.0.5', '3:df721953caa6b8f438fd7dc2b63f6fc7', 45);

--  Changeset changelog_master.groovy::1409268087922-46::rvsz (generated)::(Checksum: 3:8b1dfcd6e47b92de2c867b3d52eaf24f)
CREATE TABLE `service_item_category` (`service_item_categories_id` BIGINT NULL, `category_id` BIGINT NULL, `categories_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-46', '2.0.5', '3:8b1dfcd6e47b92de2c867b3d52eaf24f', 46);

--  Changeset changelog_master.groovy::1409268087922-47::rvsz (generated)::(Checksum: 3:69f10baf384642ff364f5403f53db64a)
CREATE TABLE `service_item_custom_field` (`service_item_custom_fields_id` BIGINT NULL, `custom_field_id` BIGINT NULL, `custom_fields_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-47', '2.0.5', '3:69f10baf384642ff364f5403f53db64a', 47);

--  Changeset changelog_master.groovy::1409268087922-48::rvsz (generated)::(Checksum: 3:a16fda6903cd6797a6d1496735dab339)
CREATE TABLE `service_item_documentation_url` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `name` VARCHAR(255) NOT NULL, `service_item_id` BIGINT NOT NULL, `url` VARCHAR(2083) NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-48', '2.0.5', '3:a16fda6903cd6797a6d1496735dab339', 48);

--  Changeset changelog_master.groovy::1409268087922-49::rvsz (generated)::(Checksum: 3:81da42021cf40d5046b0d45387730d23)
CREATE TABLE `service_item_profile` (`service_item_owners_id` BIGINT NULL, `profile_id` BIGINT NULL, `owners_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-49', '2.0.5', '3:81da42021cf40d5046b0d45387730d23', 49);

--  Changeset changelog_master.groovy::1409268087922-50::rvsz (generated)::(Checksum: 3:a9daca8ada2682389896226df8e5295f)
CREATE TABLE `service_item_score_card_item` (`service_item_id` BIGINT NOT NULL, `score_card_item_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-50', '2.0.5', '3:a9daca8ada2682389896226df8e5295f', 50);

--  Changeset changelog_master.groovy::1409268087922-51::rvsz (generated)::(Checksum: 3:c3d11c80280b277df15391fb13b425c5)
CREATE TABLE `service_item_snapshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `service_item_id` BIGINT NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-51', '2.0.5', '3:c3d11c80280b277df15391fb13b425c5', 51);

--  Changeset changelog_master.groovy::1409268087922-52::rvsz (generated)::(Checksum: 3:8285959ed18a118af62cfab9724fcfa3)
CREATE TABLE `service_item_tag` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NOT NULL, `service_item_id` BIGINT NOT NULL, `tag_id` BIGINT NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-52', '2.0.5', '3:8285959ed18a118af62cfab9724fcfa3', 52);

--  Changeset changelog_master.groovy::1409268087922-53::rvsz (generated)::(Checksum: 3:b62d4c33b02092c509f954a549d1e55a)
CREATE TABLE `service_item_tags` (`service_item_id` BIGINT NULL, `tags_string` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-53', '2.0.5', '3:b62d4c33b02092c509f954a549d1e55a', 53);

--  Changeset changelog_master.groovy::1409268087922-54::rvsz (generated)::(Checksum: 3:cd9a3fa7b42e7cc522c0889767053875)
CREATE TABLE `service_item_tech_pocs` (`service_item_id` BIGINT NULL, `tech_poc` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-54', '2.0.5', '3:cd9a3fa7b42e7cc522c0889767053875', 54);

--  Changeset changelog_master.groovy::1409268087922-55::rvsz (generated)::(Checksum: 3:74935fc64670b3fb5ed627f58cfc1980)
CREATE TABLE `si_recommended_layouts` (`service_item_id` BIGINT NULL, `recommended_layout` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-55', '2.0.5', '3:74935fc64670b3fb5ed627f58cfc1980', 55);

--  Changeset changelog_master.groovy::1409268087922-56::rvsz (generated)::(Checksum: 3:0b38f645f1e59a21f7f0d09388942928)
CREATE TABLE `state` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `is_published` bit NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `statePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-56', '2.0.5', '3:0b38f645f1e59a21f7f0d09388942928', 56);

--  Changeset changelog_master.groovy::1409268087922-57::rvsz (generated)::(Checksum: 3:45814e4253446757713edf56b8da0e6b)
CREATE TABLE `tag` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(16) NOT NULL, CONSTRAINT `tagPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-57', '2.0.5', '3:45814e4253446757713edf56b8da0e6b', 57);

--  Changeset changelog_master.groovy::1409268087922-58::rvsz (generated)::(Checksum: 3:bcdd35af57a22126392c6c385b5c0b3d)
CREATE TABLE `text` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `name` VARCHAR(50) NOT NULL, `read_only` bit NOT NULL, `value` VARCHAR(250) NULL, CONSTRAINT `textPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-58', '2.0.5', '3:bcdd35af57a22126392c6c385b5c0b3d', 58);

--  Changeset changelog_master.groovy::1409268087922-59::rvsz (generated)::(Checksum: 3:b57fdba95c065f64f99daf7da085c2e7)
CREATE TABLE `text_area_cf` (`id` BIGINT NOT NULL, `value` VARCHAR(4000) NULL, CONSTRAINT `text_area_cfPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-59', '2.0.5', '3:b57fdba95c065f64f99daf7da085c2e7', 59);

--  Changeset changelog_master.groovy::1409268087922-60::rvsz (generated)::(Checksum: 3:84035de36fb1eee3b7944c9ec5017c6c)
CREATE TABLE `text_area_cfd` (`id` BIGINT NOT NULL, CONSTRAINT `text_area_cfdPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-60', '2.0.5', '3:84035de36fb1eee3b7944c9ec5017c6c', 60);

--  Changeset changelog_master.groovy::1409268087922-61::rvsz (generated)::(Checksum: 3:f3d79760c78380e11d6d85752e72b97b)
CREATE TABLE `text_cf` (`id` BIGINT NOT NULL, `value` VARCHAR(256) NULL, CONSTRAINT `text_cfPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-61', '2.0.5', '3:f3d79760c78380e11d6d85752e72b97b', 61);

--  Changeset changelog_master.groovy::1409268087922-62::rvsz (generated)::(Checksum: 3:727948b0f05bd6f1a44db2315f59fb30)
CREATE TABLE `text_cfd` (`id` BIGINT NOT NULL, CONSTRAINT `text_cfdPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-62', '2.0.5', '3:727948b0f05bd6f1a44db2315f59fb30', 62);

--  Changeset changelog_master.groovy::1409268087922-63::rvsz (generated)::(Checksum: 3:19e17e607d75f85503dc1f06bf9a8911)
CREATE TABLE `types` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `has_icons` bit NOT NULL, `has_launch_url` bit NOT NULL, `image_id` BIGINT NULL, `is_permanent` bit NULL, `ozone_aware` bit NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `typesPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-63', '2.0.5', '3:19e17e607d75f85503dc1f06bf9a8911', 63);

--  Changeset changelog_master.groovy::1409268087922-64::rvsz (generated)::(Checksum: 3:642c260c7574ccc3903836a0d3b36f15)
CREATE TABLE `U_DOMAIN` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `username` VARCHAR(255) NOT NULL, CONSTRAINT `U_DOMAINPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-64', '2.0.5', '3:642c260c7574ccc3903836a0d3b36f15', 64);

--  Changeset changelog_master.groovy::1409268087922-65::rvsz (generated)::(Checksum: 3:815195668eea3910f62b0066af6b8236)
CREATE TABLE `u_domain_preferences` (`preferences` BIGINT NULL, `preferences_idx` VARCHAR(255) NULL, `preferences_elt` VARCHAR(255) NOT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-65', '2.0.5', '3:815195668eea3910f62b0066af6b8236', 65);

--  Changeset changelog_master.groovy::1409268087922-66::rvsz (generated)::(Checksum: 3:82c9d114ac37145fa4a52ba56f791b53)
CREATE TABLE `user_account` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `last_login` DATETIME NULL, `username` VARCHAR(250) NOT NULL, CONSTRAINT `user_accountPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog_master.groovy', '1409268087922-66', '2.0.5', '3:82c9d114ac37145fa4a52ba56f791b53', 66);

--  Changeset changelog_master.groovy::1409268087922-192::rvsz (generated)::(Checksum: 3:3ef8e38d411fa3475e7716e12a35d1bf)
CREATE INDEX `FK97BAABEE7666C6D2` ON `U_DOMAIN`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-192', '2.0.5', '3:3ef8e38d411fa3475e7716e12a35d1bf', 67);

--  Changeset changelog_master.groovy::1409268087922-193::rvsz (generated)::(Checksum: 3:07c12da8960187d863742cca0007c561)
CREATE INDEX `FK97BAABEEE31CB353` ON `U_DOMAIN`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-193', '2.0.5', '3:07c12da8960187d863742cca0007c561', 68);

--  Changeset changelog_master.groovy::1409268087922-194::rvsz (generated)::(Checksum: 3:1d8d829f17c93a29e297aec596b28543)
CREATE INDEX `FKA6EB2C37666C6D2` ON `affiliated_marketplace`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-194', '2.0.5', '3:1d8d829f17c93a29e297aec596b28543', 69);

--  Changeset changelog_master.groovy::1409268087922-195::rvsz (generated)::(Checksum: 3:5c655bec643a153e1a7f44c0e4fdd048)
CREATE INDEX `FKA6EB2C3E31CB353` ON `affiliated_marketplace`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-195', '2.0.5', '3:5c655bec643a153e1a7f44c0e4fdd048', 70);

--  Changeset changelog_master.groovy::1409268087922-196::rvsz (generated)::(Checksum: 3:342abe96fa572cb5dc8e695160d2679c)
CREATE INDEX `FKA6EB2C3EA25263C` ON `affiliated_marketplace`(`icon_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-196', '2.0.5', '3:342abe96fa572cb5dc8e695160d2679c', 71);

--  Changeset changelog_master.groovy::1409268087922-197::rvsz (generated)::(Checksum: 3:6737c56d2d977a4fa0df3bfb9e8e3ba4)
CREATE INDEX `FKAB611C057666C6D2` ON `agency`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-197', '2.0.5', '3:6737c56d2d977a4fa0df3bfb9e8e3ba4', 72);

--  Changeset changelog_master.groovy::1409268087922-198::rvsz (generated)::(Checksum: 3:f95dceb464d93ea2e10653557b6c3bbd)
CREATE INDEX `FKAB611C05E31CB353` ON `agency`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-198', '2.0.5', '3:f95dceb464d93ea2e10653557b6c3bbd', 73);

--  Changeset changelog_master.groovy::1409268087922-199::rvsz (generated)::(Checksum: 3:a302f3023332b01f9bff3cd7bd73e250)
CREATE INDEX `app_config_group_name_idx` ON `application_configuration`(`group_name`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-199', '2.0.5', '3:a302f3023332b01f9bff3cd7bd73e250', 74);

--  Changeset changelog_master.groovy::1409268087922-200::rvsz (generated)::(Checksum: 3:978202bf4a76e175c9806b9c8902f3c5)
CREATE INDEX `FKAC32C1597666C6D2` ON `avatar`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-200', '2.0.5', '3:978202bf4a76e175c9806b9c8902f3c5', 75);

--  Changeset changelog_master.groovy::1409268087922-201::rvsz (generated)::(Checksum: 3:ff535f0d3ebf587b8ce45d8518171745)
CREATE INDEX `FKAC32C159E31CB353` ON `avatar`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-201', '2.0.5', '3:ff535f0d3ebf587b8ce45d8518171745', 76);

--  Changeset changelog_master.groovy::1409268087922-202::rvsz (generated)::(Checksum: 3:839c5edf03b5a4d78530bfe73c494a2b)
CREATE INDEX `FK302BCFE7666C6D2` ON `category`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-202', '2.0.5', '3:839c5edf03b5a4d78530bfe73c494a2b', 77);

--  Changeset changelog_master.groovy::1409268087922-203::rvsz (generated)::(Checksum: 3:abae98adf693d4c6e252c9635103b9ed)
CREATE INDEX `FK302BCFEE31CB353` ON `category`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-203', '2.0.5', '3:abae98adf693d4c6e252c9635103b9ed', 78);

--  Changeset changelog_master.groovy::1409268087922-204::rvsz (generated)::(Checksum: 3:ff32ab0cc35ab2837f89442cb284d3a9)
CREATE UNIQUE INDEX `uuid_uniq_1409268087782` ON `category`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-204', '2.0.5', '3:ff32ab0cc35ab2837f89442cb284d3a9', 79);

--  Changeset changelog_master.groovy::1409268087922-205::rvsz (generated)::(Checksum: 3:47d39028d2fa936ddfb522da6bd67a5d)
CREATE INDEX `FKB4467BC0855307BD` ON `change_detail`(`service_item_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-205', '2.0.5', '3:47d39028d2fa936ddfb522da6bd67a5d', 80);

--  Changeset changelog_master.groovy::1409268087922-206::rvsz (generated)::(Checksum: 3:6e5bbd52f7512c3f1254fdbebe93e82c)
CREATE INDEX `FKE828FA6E7F5081E1` ON `check_box_cf`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-206', '2.0.5', '3:6e5bbd52f7512c3f1254fdbebe93e82c', 81);

--  Changeset changelog_master.groovy::1409268087922-207::rvsz (generated)::(Checksum: 3:7146047f4ce1fc5766430d82196b8b99)
CREATE INDEX `FK1CF653B69F8CD3D4` ON `check_box_cfd`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-207', '2.0.5', '3:7146047f4ce1fc5766430d82196b8b99', 82);

--  Changeset changelog_master.groovy::1409268087922-208::rvsz (generated)::(Checksum: 3:5512d8b172d706ad23999f647e6422a6)
CREATE INDEX `FK38B724207666C6D2` ON `contact`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-208', '2.0.5', '3:5512d8b172d706ad23999f647e6422a6', 83);

--  Changeset changelog_master.groovy::1409268087922-209::rvsz (generated)::(Checksum: 3:e0cdb4ec69bba14939a8ce5e3947929b)
CREATE INDEX `FK38B72420BA3FC877` ON `contact`(`type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-209', '2.0.5', '3:e0cdb4ec69bba14939a8ce5e3947929b', 84);

--  Changeset changelog_master.groovy::1409268087922-210::rvsz (generated)::(Checksum: 3:c94ee2a89e758bc2395921cdca2fd603)
CREATE INDEX `FK38B72420C7E5C662` ON `contact`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-210', '2.0.5', '3:c94ee2a89e758bc2395921cdca2fd603', 85);

--  Changeset changelog_master.groovy::1409268087922-211::rvsz (generated)::(Checksum: 3:ab223b6396345140982e4218210dd2a6)
CREATE INDEX `FK38B72420E31CB353` ON `contact`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-211', '2.0.5', '3:ab223b6396345140982e4218210dd2a6', 86);

--  Changeset changelog_master.groovy::1409268087922-212::rvsz (generated)::(Checksum: 3:7bf0f61e79c783505df26e909504d64e)
CREATE INDEX `FK4C2BB7F97666C6D2` ON `contact_type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-212', '2.0.5', '3:7bf0f61e79c783505df26e909504d64e', 87);

--  Changeset changelog_master.groovy::1409268087922-213::rvsz (generated)::(Checksum: 3:95d15016c324a6f6a9e954804abcc950)
CREATE INDEX `FK4C2BB7F9E31CB353` ON `contact_type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-213', '2.0.5', '3:95d15016c324a6f6a9e954804abcc950', 88);

--  Changeset changelog_master.groovy::1409268087922-214::rvsz (generated)::(Checksum: 3:79393b44b0b9b07de9fcea3103b224a0)
CREATE UNIQUE INDEX `title_uniq_1409268087788` ON `contact_type`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-214', '2.0.5', '3:79393b44b0b9b07de9fcea3103b224a0', 89);

--  Changeset changelog_master.groovy::1409268087922-215::rvsz (generated)::(Checksum: 3:f5cae524cf3234036c1c2d2a111740f5)
CREATE INDEX `FK2ACD76AC6F62C9ED` ON `custom_field`(`custom_field_definition_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-215', '2.0.5', '3:f5cae524cf3234036c1c2d2a111740f5', 90);

--  Changeset changelog_master.groovy::1409268087922-216::rvsz (generated)::(Checksum: 3:1ec9d09bae60a55305551e9712986afb)
CREATE INDEX `FK2ACD76AC7666C6D2` ON `custom_field`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-216', '2.0.5', '3:1ec9d09bae60a55305551e9712986afb', 91);

--  Changeset changelog_master.groovy::1409268087922-217::rvsz (generated)::(Checksum: 3:66b0fc29ee88d62e6f920d0f882e3fed)
CREATE INDEX `FK2ACD76ACE31CB353` ON `custom_field`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-217', '2.0.5', '3:66b0fc29ee88d62e6f920d0f882e3fed', 92);

--  Changeset changelog_master.groovy::1409268087922-218::rvsz (generated)::(Checksum: 3:14464790764b0a68d645a8f76a4a3846)
CREATE INDEX `FK150F70C67666C6D2` ON `custom_field_definition`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-218', '2.0.5', '3:14464790764b0a68d645a8f76a4a3846', 93);

--  Changeset changelog_master.groovy::1409268087922-219::rvsz (generated)::(Checksum: 3:72480ae11ee1b951c0e27f60078bcef0)
CREATE INDEX `FK150F70C6E31CB353` ON `custom_field_definition`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-219', '2.0.5', '3:72480ae11ee1b951c0e27f60078bcef0', 94);

--  Changeset changelog_master.groovy::1409268087922-220::rvsz (generated)::(Checksum: 3:4febd917c315f1596e4f7d1494f70077)
CREATE UNIQUE INDEX `uuid_uniq_1409268087791` ON `custom_field_definition`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-220', '2.0.5', '3:4febd917c315f1596e4f7d1494f70077', 95);

--  Changeset changelog_master.groovy::1409268087922-221::rvsz (generated)::(Checksum: 3:ce89c161363ad34f3a92c5fd9eea4f45)
CREATE INDEX `FK1A84FFC06928D597` ON `custom_field_definition_types`(`types_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-221', '2.0.5', '3:ce89c161363ad34f3a92c5fd9eea4f45', 96);

--  Changeset changelog_master.groovy::1409268087922-222::rvsz (generated)::(Checksum: 3:ee4410c10ef3b6175b9ec7ffd400090a)
CREATE INDEX `FK6F064E36553AF61A` ON `default_images`(`image_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-222', '2.0.5', '3:ee4410c10ef3b6175b9ec7ffd400090a', 97);

--  Changeset changelog_master.groovy::1409268087922-223::rvsz (generated)::(Checksum: 3:8a8976611132a8eec70e72aa8344e25a)
CREATE INDEX `FK6F064E367666C6D2` ON `default_images`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-223', '2.0.5', '3:8a8976611132a8eec70e72aa8344e25a', 98);

--  Changeset changelog_master.groovy::1409268087922-224::rvsz (generated)::(Checksum: 3:368c92bde52df7596c1884cc17eb9dbd)
CREATE INDEX `FK6F064E36E31CB353` ON `default_images`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-224', '2.0.5', '3:368c92bde52df7596c1884cc17eb9dbd', 99);

--  Changeset changelog_master.groovy::1409268087922-225::rvsz (generated)::(Checksum: 3:b966812de1afb33966b8481a7ac5360b)
CREATE INDEX `FK13ADE7D07F5081E1` ON `drop_down_cf`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-225', '2.0.5', '3:b966812de1afb33966b8481a7ac5360b', 100);

--  Changeset changelog_master.groovy::1409268087922-226::rvsz (generated)::(Checksum: 3:e30428fa31ae7f1ffebb0f6f6e24a4e7)
CREATE INDEX `FK13ADE7D0BC98CEE3` ON `drop_down_cf`(`value_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-226', '2.0.5', '3:e30428fa31ae7f1ffebb0f6f6e24a4e7', 101);

--  Changeset changelog_master.groovy::1409268087922-227::rvsz (generated)::(Checksum: 3:5eeb1a29e92ef123155ff3ed324bf452)
CREATE INDEX `FK2627FFDDA5BD888` ON `drop_down_cf_field_value`(`field_value_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-227', '2.0.5', '3:5eeb1a29e92ef123155ff3ed324bf452', 102);

--  Changeset changelog_master.groovy::1409268087922-228::rvsz (generated)::(Checksum: 3:bb5c9082c2a57d1787bb0c0cec6cbdb1)
CREATE INDEX `FK620F12949F8CD3D4` ON `drop_down_cfd`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-228', '2.0.5', '3:bb5c9082c2a57d1787bb0c0cec6cbdb1', 103);

--  Changeset changelog_master.groovy::1409268087922-229::rvsz (generated)::(Checksum: 3:f9d7ed7c3bef3086b2046d9a79fdfc2c)
CREATE INDEX `FKE9C8098B20F4E01` ON `ext_profile`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-229', '2.0.5', '3:f9d7ed7c3bef3086b2046d9a79fdfc2c', 104);

--  Changeset changelog_master.groovy::1409268087922-230::rvsz (generated)::(Checksum: 3:4338f93ffd90839bbc8915e0799316f4)
CREATE UNIQUE INDEX `unique_external_id` ON `ext_profile`(`system_uri`, `external_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-230', '2.0.5', '3:4338f93ffd90839bbc8915e0799316f4', 105);

--  Changeset changelog_master.groovy::1409268087922-231::rvsz (generated)::(Checksum: 3:63c9e1a811bcd1418ed8ee93759a12a6)
CREATE INDEX `FK29F571EC7666C6D2` ON `field_value`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-231', '2.0.5', '3:63c9e1a811bcd1418ed8ee93759a12a6', 106);

--  Changeset changelog_master.groovy::1409268087922-232::rvsz (generated)::(Checksum: 3:e597f25f1a6a017728b4b70d64b1da2d)
CREATE INDEX `FK29F571ECE31CB353` ON `field_value`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-232', '2.0.5', '3:e597f25f1a6a017728b4b70d64b1da2d', 107);

--  Changeset changelog_master.groovy::1409268087922-233::rvsz (generated)::(Checksum: 3:3e5c4c93c32f1c8a2e77de80840bea99)
CREATE INDEX `FK29F571ECF1F14D3C` ON `field_value`(`custom_field_definition_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-233', '2.0.5', '3:3e5c4c93c32f1c8a2e77de80840bea99', 108);

--  Changeset changelog_master.groovy::1409268087922-234::rvsz (generated)::(Checksum: 3:4ac90bbafd6f6dc2a697d1a20c5c5139)
CREATE INDEX `FK300028977F5081E1` ON `image_url_cf`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-234', '2.0.5', '3:4ac90bbafd6f6dc2a697d1a20c5c5139', 109);

--  Changeset changelog_master.groovy::1409268087922-235::rvsz (generated)::(Checksum: 3:3893186317662d3ba96adb216199191a)
CREATE INDEX `FKD004EAAD9F8CD3D4` ON `image_url_cfd`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-235', '2.0.5', '3:3893186317662d3ba96adb216199191a', 110);

--  Changeset changelog_master.groovy::1409268087922-236::rvsz (generated)::(Checksum: 3:c20e3fcbf94b7ee34bafa868f5ff532e)
CREATE INDEX `FKB95A82787666C6D2` ON `images`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-236', '2.0.5', '3:c20e3fcbf94b7ee34bafa868f5ff532e', 111);

--  Changeset changelog_master.groovy::1409268087922-237::rvsz (generated)::(Checksum: 3:46dab07a3d1de65cbf5b2956e3a2ee01)
CREATE INDEX `FKB95A8278E31CB353` ON `images`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-237', '2.0.5', '3:46dab07a3d1de65cbf5b2956e3a2ee01', 112);

--  Changeset changelog_master.groovy::1409268087922-238::rvsz (generated)::(Checksum: 3:e475b5a5ca65790a54c912c5cd65a287)
CREATE INDEX `FK578EF9DF7666C6D2` ON `import_task`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-238', '2.0.5', '3:e475b5a5ca65790a54c912c5cd65a287', 113);

--  Changeset changelog_master.groovy::1409268087922-239::rvsz (generated)::(Checksum: 3:d773200555e5793c5e27a8c6fa8d54e0)
CREATE INDEX `FK578EF9DF919216CA` ON `import_task`(`last_run_result_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-239', '2.0.5', '3:d773200555e5793c5e27a8c6fa8d54e0', 114);

--  Changeset changelog_master.groovy::1409268087922-240::rvsz (generated)::(Checksum: 3:f6d85e029b667280369a6867789c5ccf)
CREATE INDEX `FK578EF9DFA31F8712` ON `import_task`(`interface_config_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-240', '2.0.5', '3:f6d85e029b667280369a6867789c5ccf', 115);

--  Changeset changelog_master.groovy::1409268087922-241::rvsz (generated)::(Checksum: 3:48d37681ca109e398516905127ed656f)
CREATE INDEX `FK578EF9DFE31CB353` ON `import_task`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-241', '2.0.5', '3:48d37681ca109e398516905127ed656f', 116);

--  Changeset changelog_master.groovy::1409268087922-242::rvsz (generated)::(Checksum: 3:bd29772b4bb362efe989938a32a96303)
CREATE UNIQUE INDEX `name_uniq_1409268087805` ON `import_task`(`name`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-242', '2.0.5', '3:bd29772b4bb362efe989938a32a96303', 117);

--  Changeset changelog_master.groovy::1409268087922-243::rvsz (generated)::(Checksum: 3:29ff752ab0cdf12650641dc76818f414)
CREATE INDEX `FK983AC27D11D7F882` ON `import_task_result`(`task_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-243', '2.0.5', '3:29ff752ab0cdf12650641dc76818f414', 118);

--  Changeset changelog_master.groovy::1409268087922-244::rvsz (generated)::(Checksum: 3:da14f99f470b8f0740917b2db6ee3ddb)
CREATE INDEX `FKB971369C283F938E` ON `intent`(`data_type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-244', '2.0.5', '3:da14f99f470b8f0740917b2db6ee3ddb', 119);

--  Changeset changelog_master.groovy::1409268087922-245::rvsz (generated)::(Checksum: 3:92fbb2f899780719b54ccc740c0cb0a0)
CREATE INDEX `FKB971369C7666C6D2` ON `intent`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-245', '2.0.5', '3:92fbb2f899780719b54ccc740c0cb0a0', 120);

--  Changeset changelog_master.groovy::1409268087922-246::rvsz (generated)::(Checksum: 3:802af6e6aee90434f30ba25741c998d9)
CREATE INDEX `FKB971369CD8544299` ON `intent`(`action_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-246', '2.0.5', '3:802af6e6aee90434f30ba25741c998d9', 121);

--  Changeset changelog_master.groovy::1409268087922-247::rvsz (generated)::(Checksum: 3:6caefac8c527462edff8c85539c23fca)
CREATE INDEX `FKB971369CE31CB353` ON `intent`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-247', '2.0.5', '3:6caefac8c527462edff8c85539c23fca', 122);

--  Changeset changelog_master.groovy::1409268087922-248::rvsz (generated)::(Checksum: 3:408b3989feb3cebeda351838a7cb7934)
CREATE INDEX `FKEBCDD397666C6D2` ON `intent_action`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-248', '2.0.5', '3:408b3989feb3cebeda351838a7cb7934', 123);

--  Changeset changelog_master.groovy::1409268087922-249::rvsz (generated)::(Checksum: 3:32a922b22b3fc432ad57d3df047a93fe)
CREATE INDEX `FKEBCDD39E31CB353` ON `intent_action`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-249', '2.0.5', '3:32a922b22b3fc432ad57d3df047a93fe', 124);

--  Changeset changelog_master.groovy::1409268087922-250::rvsz (generated)::(Checksum: 3:f2caf630bcdc5a20a2521072b6a50b71)
CREATE UNIQUE INDEX `uuid_uniq_1409268087809` ON `intent_action`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-250', '2.0.5', '3:f2caf630bcdc5a20a2521072b6a50b71', 125);

--  Changeset changelog_master.groovy::1409268087922-251::rvsz (generated)::(Checksum: 3:d3e51812e5a2b6c63f5a6eee57ac3903)
CREATE INDEX `FKEADB30CC7666C6D2` ON `intent_data_type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-251', '2.0.5', '3:d3e51812e5a2b6c63f5a6eee57ac3903', 126);

--  Changeset changelog_master.groovy::1409268087922-252::rvsz (generated)::(Checksum: 3:e34567d0543543393c7c10ac62c5e3df)
CREATE INDEX `FKEADB30CCE31CB353` ON `intent_data_type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-252', '2.0.5', '3:e34567d0543543393c7c10ac62c5e3df', 127);

--  Changeset changelog_master.groovy::1409268087922-253::rvsz (generated)::(Checksum: 3:c6a051dd7fde8aeb8b4dfad3245c0138)
CREATE UNIQUE INDEX `uuid_uniq_1409268087810` ON `intent_data_type`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-253', '2.0.5', '3:c6a051dd7fde8aeb8b4dfad3245c0138', 128);

--  Changeset changelog_master.groovy::1409268087922-254::rvsz (generated)::(Checksum: 3:918b638c1ef7b602878bc380e9545244)
CREATE INDEX `FKC723A59C7666C6D2` ON `intent_direction`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-254', '2.0.5', '3:918b638c1ef7b602878bc380e9545244', 129);

--  Changeset changelog_master.groovy::1409268087922-255::rvsz (generated)::(Checksum: 3:2d240fcd92dba845691121d668e64d07)
CREATE INDEX `FKC723A59CE31CB353` ON `intent_direction`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-255', '2.0.5', '3:2d240fcd92dba845691121d668e64d07', 130);

--  Changeset changelog_master.groovy::1409268087922-256::rvsz (generated)::(Checksum: 3:23709c74151c4da106975b8577d5660e)
CREATE UNIQUE INDEX `title_uniq_1409268087811` ON `intent_direction`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-256', '2.0.5', '3:23709c74151c4da106975b8577d5660e', 131);

--  Changeset changelog_master.groovy::1409268087922-257::rvsz (generated)::(Checksum: 3:d317103f932f4ec0362e1c0d65e5f6e4)
CREATE UNIQUE INDEX `uuid_uniq_1409268087811` ON `intent_direction`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-257', '2.0.5', '3:d317103f932f4ec0362e1c0d65e5f6e4', 132);

--  Changeset changelog_master.groovy::1409268087922-258::rvsz (generated)::(Checksum: 3:746e27fa81fd626ea797dc77b328d7bc)
CREATE INDEX `FKE6D04D335A032135` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-258', '2.0.5', '3:746e27fa81fd626ea797dc77b328d7bc', 133);

--  Changeset changelog_master.groovy::1409268087922-259::rvsz (generated)::(Checksum: 3:1b1fd7174764d6af9ff51dbfbd268461)
CREATE INDEX `FKE6D04D337666C6D2` ON `item_comment`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-259', '2.0.5', '3:1b1fd7174764d6af9ff51dbfbd268461', 134);

--  Changeset changelog_master.groovy::1409268087922-260::rvsz (generated)::(Checksum: 3:5e7c7f7f791d99b2ec4f4b1d602ddc9d)
CREATE INDEX `FKE6D04D33C7E5C662` ON `item_comment`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-260', '2.0.5', '3:5e7c7f7f791d99b2ec4f4b1d602ddc9d', 135);

--  Changeset changelog_master.groovy::1409268087922-261::rvsz (generated)::(Checksum: 3:d5b9eff22304b8c7744e69c46394e893)
CREATE INDEX `FKE6D04D33E31CB353` ON `item_comment`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-261', '2.0.5', '3:d5b9eff22304b8c7744e69c46394e893', 136);

--  Changeset changelog_master.groovy::1409268087922-262::rvsz (generated)::(Checksum: 3:53e54435435f21a79bf181d81074de52)
CREATE INDEX `itm_cmnt_author_id_idx` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-262', '2.0.5', '3:53e54435435f21a79bf181d81074de52', 137);

--  Changeset changelog_master.groovy::1409268087922-263::rvsz (generated)::(Checksum: 3:4606fad8fc3f6b329467524f6fa00df7)
CREATE INDEX `itm_cmnt_svc_item_id_idx` ON `item_comment`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-263', '2.0.5', '3:4606fad8fc3f6b329467524f6fa00df7', 138);

--  Changeset changelog_master.groovy::1409268087922-264::rvsz (generated)::(Checksum: 3:3b17dd5dad914166672e096855ce8323)
CREATE INDEX `FKE68D3F71C359936F` ON `modify_relationship_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-264', '2.0.5', '3:3b17dd5dad914166672e096855ce8323', 139);

--  Changeset changelog_master.groovy::1409268087922-265::rvsz (generated)::(Checksum: 3:5b2c47ed962bcec81aa8b5a5e7392bfb)
CREATE INDEX `FKE88638947666C6D2` ON `owf_properties`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-265', '2.0.5', '3:5b2c47ed962bcec81aa8b5a5e7392bfb', 140);

--  Changeset changelog_master.groovy::1409268087922-266::rvsz (generated)::(Checksum: 3:b9d8aa93d30d1edfdd815398c03c6937)
CREATE INDEX `FKE8863894E31CB353` ON `owf_properties`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-266', '2.0.5', '3:b9d8aa93d30d1edfdd815398c03c6937', 141);

--  Changeset changelog_master.groovy::1409268087922-267::rvsz (generated)::(Checksum: 3:08010d4fb5279b237bd3032b1d84230a)
CREATE INDEX `FK3F99ECA74704E25C` ON `owf_properties_intent`(`owf_properties_intents_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-267', '2.0.5', '3:08010d4fb5279b237bd3032b1d84230a', 142);

--  Changeset changelog_master.groovy::1409268087922-268::rvsz (generated)::(Checksum: 3:56cdcb824ab9179adf6c741d1cd42a8a)
CREATE INDEX `FK3F99ECA7A651895D` ON `owf_properties_intent`(`intent_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-268', '2.0.5', '3:56cdcb824ab9179adf6c741d1cd42a8a', 143);

--  Changeset changelog_master.groovy::1409268087922-269::rvsz (generated)::(Checksum: 3:03fbf5c03fbad13bc5903aa8d219586e)
CREATE INDEX `FK6AB6A9DF7666C6D2` ON `owf_widget_types`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-269', '2.0.5', '3:03fbf5c03fbad13bc5903aa8d219586e', 144);

--  Changeset changelog_master.groovy::1409268087922-270::rvsz (generated)::(Checksum: 3:c7e85ff8769ab92e24507569d4b8b732)
CREATE INDEX `FK6AB6A9DFE31CB353` ON `owf_widget_types`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-270', '2.0.5', '3:c7e85ff8769ab92e24507569d4b8b732', 145);

--  Changeset changelog_master.groovy::1409268087922-271::rvsz (generated)::(Checksum: 3:fae02cbd691c680bc53723ed1832d68c)
CREATE UNIQUE INDEX `uuid_uniq_1409268087818` ON `owf_widget_types`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-271', '2.0.5', '3:fae02cbd691c680bc53723ed1832d68c', 146);

--  Changeset changelog_master.groovy::1409268087922-272::rvsz (generated)::(Checksum: 3:824416833084575baab72152689bcf08)
CREATE INDEX `FKED8E89A961C3343D` ON `profile`(`avatar_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-272', '2.0.5', '3:824416833084575baab72152689bcf08', 147);

--  Changeset changelog_master.groovy::1409268087922-273::rvsz (generated)::(Checksum: 3:5c87cefb070afe5245df49edcdf6d6bc)
CREATE INDEX `FKED8E89A97666C6D2` ON `profile`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-273', '2.0.5', '3:5c87cefb070afe5245df49edcdf6d6bc', 148);

--  Changeset changelog_master.groovy::1409268087922-274::rvsz (generated)::(Checksum: 3:0b1b62581a385869ec370e81caf41d45)
CREATE INDEX `FKED8E89A9E31CB353` ON `profile`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-274', '2.0.5', '3:0b1b62581a385869ec370e81caf41d45', 149);

--  Changeset changelog_master.groovy::1409268087922-275::rvsz (generated)::(Checksum: 3:4b0634966e98e739f49beab3fabfbedd)
CREATE UNIQUE INDEX `username_uniq_1409268087820` ON `profile`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-275', '2.0.5', '3:4b0634966e98e739f49beab3fabfbedd', 150);

--  Changeset changelog_master.groovy::1409268087922-276::rvsz (generated)::(Checksum: 3:5e5a6b5b75408b2d403a348eedb86d6a)
CREATE UNIQUE INDEX `uuid_uniq_1409268087820` ON `profile`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-276', '2.0.5', '3:5e5a6b5b75408b2d403a348eedb86d6a', 151);

--  Changeset changelog_master.groovy::1409268087922-277::rvsz (generated)::(Checksum: 3:cca6c45c54b91151bc21e28f8459e6b5)
CREATE INDEX `FKF35C128582548A4A` ON `rejection_activity`(`rejection_listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-277', '2.0.5', '3:cca6c45c54b91151bc21e28f8459e6b5', 152);

--  Changeset changelog_master.groovy::1409268087922-278::rvsz (generated)::(Checksum: 3:81e04eaf534d41090afd6f3e5f333ba6)
CREATE INDEX `FKF35C1285C359936F` ON `rejection_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-278', '2.0.5', '3:81e04eaf534d41090afd6f3e5f333ba6', 153);

--  Changeset changelog_master.groovy::1409268087922-279::rvsz (generated)::(Checksum: 3:83bf85c9a6c11a66907396db59b6627c)
CREATE INDEX `FK12B0A53C7666C6D2` ON `rejection_justification`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-279', '2.0.5', '3:83bf85c9a6c11a66907396db59b6627c', 154);

--  Changeset changelog_master.groovy::1409268087922-280::rvsz (generated)::(Checksum: 3:7fbdaa45ba2134fba5cf706566f0ddae)
CREATE INDEX `FK12B0A53CE31CB353` ON `rejection_justification`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-280', '2.0.5', '3:7fbdaa45ba2134fba5cf706566f0ddae', 155);

--  Changeset changelog_master.groovy::1409268087922-281::rvsz (generated)::(Checksum: 3:ebe7a93726788a3caaf908927e019a5b)
CREATE INDEX `FK3F2BD44E19CEB614` ON `rejection_listing`(`justification_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-281', '2.0.5', '3:ebe7a93726788a3caaf908927e019a5b', 156);

--  Changeset changelog_master.groovy::1409268087922-282::rvsz (generated)::(Checksum: 3:66b6585c51649bacba538f21c706a430)
CREATE INDEX `FK3F2BD44E5A032135` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-282', '2.0.5', '3:66b6585c51649bacba538f21c706a430', 157);

--  Changeset changelog_master.groovy::1409268087922-283::rvsz (generated)::(Checksum: 3:d1f5b33deb169eb9fb0458e7e8b64541)
CREATE INDEX `FK3F2BD44E7666C6D2` ON `rejection_listing`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-283', '2.0.5', '3:d1f5b33deb169eb9fb0458e7e8b64541', 158);

--  Changeset changelog_master.groovy::1409268087922-284::rvsz (generated)::(Checksum: 3:8a6952f66b99f36f0c78e74b3f399f60)
CREATE INDEX `FK3F2BD44EC7E5C662` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-284', '2.0.5', '3:8a6952f66b99f36f0c78e74b3f399f60', 159);

--  Changeset changelog_master.groovy::1409268087922-285::rvsz (generated)::(Checksum: 3:3ff4107bb95921b20fdbf01b1089ce2e)
CREATE INDEX `FK3F2BD44EE31CB353` ON `rejection_listing`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-285', '2.0.5', '3:3ff4107bb95921b20fdbf01b1089ce2e', 160);

--  Changeset changelog_master.groovy::1409268087922-286::rvsz (generated)::(Checksum: 3:43678308dc3a992c28f53b4efeb30268)
CREATE INDEX `rej_lst_author_id_idx` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-286', '2.0.5', '3:43678308dc3a992c28f53b4efeb30268', 161);

--  Changeset changelog_master.groovy::1409268087922-287::rvsz (generated)::(Checksum: 3:185f7cfc5e4834a552850a563be01129)
CREATE INDEX `rej_lst_svc_item_id_idx` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-287', '2.0.5', '3:185f7cfc5e4834a552850a563be01129', 162);

--  Changeset changelog_master.groovy::1409268087922-288::rvsz (generated)::(Checksum: 3:e531cf4217a675f3d14c4e90f894861c)
CREATE INDEX `FKF06476389D70DD39` ON `relationship`(`owning_entity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-288', '2.0.5', '3:e531cf4217a675f3d14c4e90f894861c', 163);

--  Changeset changelog_master.groovy::1409268087922-289::rvsz (generated)::(Checksum: 3:1faa9525346fa580489e9fd365af971c)
CREATE INDEX `FK594974BB25A20F9D` ON `relationship_activity_log`(`service_item_snapshot_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-289', '2.0.5', '3:1faa9525346fa580489e9fd365af971c', 164);

--  Changeset changelog_master.groovy::1409268087922-290::rvsz (generated)::(Checksum: 3:eec26c4329ec72cbffdd562127545f6e)
CREATE INDEX `FKDA02504C7E5C662` ON `relationship_service_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-290', '2.0.5', '3:eec26c4329ec72cbffdd562127545f6e', 165);

--  Changeset changelog_master.groovy::1409268087922-291::rvsz (generated)::(Checksum: 3:17c02086fe38b487303c08354f695f76)
CREATE INDEX `FKE51CCD757666C6D2` ON `score_card_item`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-291', '2.0.5', '3:17c02086fe38b487303c08354f695f76', 166);

--  Changeset changelog_master.groovy::1409268087922-292::rvsz (generated)::(Checksum: 3:cacaa1fa165b5dc021388e8e5e10cc27)
CREATE INDEX `FKE51CCD75E31CB353` ON `score_card_item`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-292', '2.0.5', '3:cacaa1fa165b5dc021388e8e5e10cc27', 167);

--  Changeset changelog_master.groovy::1409268087922-293::rvsz (generated)::(Checksum: 3:1aba62ac454620082692f1eaa640f99f)
CREATE INDEX `FKE72D85667666C6D2` ON `screenshot`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-293', '2.0.5', '3:1aba62ac454620082692f1eaa640f99f', 168);

--  Changeset changelog_master.groovy::1409268087922-294::rvsz (generated)::(Checksum: 3:2cc546119189c2df9dde5afff248114d)
CREATE INDEX `FKE72D8566C7E5C662` ON `screenshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-294', '2.0.5', '3:2cc546119189c2df9dde5afff248114d', 169);

--  Changeset changelog_master.groovy::1409268087922-295::rvsz (generated)::(Checksum: 3:07741cdcf1099bf19899e2737d826d46)
CREATE INDEX `FKE72D8566E31CB353` ON `screenshot`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-295', '2.0.5', '3:07741cdcf1099bf19899e2737d826d46', 170);

--  Changeset changelog_master.groovy::1409268087922-296::rvsz (generated)::(Checksum: 3:d15412c9f28d673fc8d213e522b6cdfb)
CREATE INDEX `FK1571565D143B24BD` ON `service_item`(`agency_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-296', '2.0.5', '3:d15412c9f28d673fc8d213e522b6cdfb', 171);

--  Changeset changelog_master.groovy::1409268087922-297::rvsz (generated)::(Checksum: 3:b5af36144e5852c582747a2fcad614ca)
CREATE INDEX `FK1571565D2746B676` ON `service_item`(`last_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-297', '2.0.5', '3:b5af36144e5852c582747a2fcad614ca', 172);

--  Changeset changelog_master.groovy::1409268087922-298::rvsz (generated)::(Checksum: 3:5b2e89bfe1d7c1e1b95b7ff49f9d53e3)
CREATE INDEX `FK1571565D6928D597` ON `service_item`(`types_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-298', '2.0.5', '3:5b2e89bfe1d7c1e1b95b7ff49f9d53e3', 173);

--  Changeset changelog_master.groovy::1409268087922-299::rvsz (generated)::(Checksum: 3:22143e9523ef163f696b8b0d6715e928)
CREATE INDEX `FK1571565D7666C6D2` ON `service_item`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-299', '2.0.5', '3:22143e9523ef163f696b8b0d6715e928', 174);

--  Changeset changelog_master.groovy::1409268087922-300::rvsz (generated)::(Checksum: 3:408cd5674a07379c6b3367d2b494ac11)
CREATE INDEX `FK1571565D904D6974` ON `service_item`(`owf_properties_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-300', '2.0.5', '3:408cd5674a07379c6b3367d2b494ac11', 175);

--  Changeset changelog_master.groovy::1409268087922-301::rvsz (generated)::(Checksum: 3:a689381710b81e66e508d4431066249e)
CREATE INDEX `FK1571565DE31CB353` ON `service_item`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-301', '2.0.5', '3:a689381710b81e66e508d4431066249e', 176);

--  Changeset changelog_master.groovy::1409268087922-302::rvsz (generated)::(Checksum: 3:6004d165f74d01f95d179c70bfdf4da9)
CREATE INDEX `FK870EA6B15A032135` ON `service_item_activity`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-302', '2.0.5', '3:6004d165f74d01f95d179c70bfdf4da9', 177);

--  Changeset changelog_master.groovy::1409268087922-303::rvsz (generated)::(Checksum: 3:1f03b1ee01724c9a3fe8a8ff2830b510)
CREATE INDEX `FK870EA6B17666C6D2` ON `service_item_activity`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-303', '2.0.5', '3:1f03b1ee01724c9a3fe8a8ff2830b510', 178);

--  Changeset changelog_master.groovy::1409268087922-304::rvsz (generated)::(Checksum: 3:bdce4184a5244cd4570fcb5d3ce73a89)
CREATE INDEX `FK870EA6B1C7E5C662` ON `service_item_activity`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-304', '2.0.5', '3:bdce4184a5244cd4570fcb5d3ce73a89', 179);

--  Changeset changelog_master.groovy::1409268087922-305::rvsz (generated)::(Checksum: 3:dc06d43ca4f59b935996549e400ca07e)
CREATE INDEX `FK870EA6B1E31CB353` ON `service_item_activity`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-305', '2.0.5', '3:dc06d43ca4f59b935996549e400ca07e', 180);

--  Changeset changelog_master.groovy::1409268087922-306::rvsz (generated)::(Checksum: 3:ada5f8ad85b60287a404e1176b07500d)
CREATE INDEX `svc_item_act_svc_item_id_idx` ON `service_item_activity`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-306', '2.0.5', '3:ada5f8ad85b60287a404e1176b07500d', 181);

--  Changeset changelog_master.groovy::1409268087922-307::rvsz (generated)::(Checksum: 3:a2ca461c41d1b5693ab2ef4b2094f123)
CREATE INDEX `FKECC570A0DA41995D` ON `service_item_category`(`category_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-307', '2.0.5', '3:a2ca461c41d1b5693ab2ef4b2094f123', 182);

--  Changeset changelog_master.groovy::1409268087922-308::rvsz (generated)::(Checksum: 3:e0b3adf38923675bede0ea55f9c7db80)
CREATE INDEX `svc_item_cat_id_idx` ON `service_item_category`(`service_item_categories_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-308', '2.0.5', '3:e0b3adf38923675bede0ea55f9c7db80', 183);

--  Changeset changelog_master.groovy::1409268087922-309::rvsz (generated)::(Checksum: 3:c2b0030e73f78d97f0e16f1dbaa29538)
CREATE INDEX `FK46E9894E7B56E054` ON `service_item_custom_field`(`custom_field_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-309', '2.0.5', '3:c2b0030e73f78d97f0e16f1dbaa29538', 184);

--  Changeset changelog_master.groovy::1409268087922-310::rvsz (generated)::(Checksum: 3:64f2609c4d944c0de5e970b163905aaf)
CREATE INDEX `svc_item_cst_fld_id_idx` ON `service_item_custom_field`(`service_item_custom_fields_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-310', '2.0.5', '3:64f2609c4d944c0de5e970b163905aaf', 185);

--  Changeset changelog_master.groovy::1409268087922-311::rvsz (generated)::(Checksum: 3:ec179899b5e9feb38497778d3cda2843)
CREATE INDEX `FK24572D08C7E5C662` ON `service_item_documentation_url`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-311', '2.0.5', '3:ec179899b5e9feb38497778d3cda2843', 186);

--  Changeset changelog_master.groovy::1409268087922-312::rvsz (generated)::(Checksum: 3:388cccadd42e1ecc564a22f1fa17cb62)
CREATE INDEX `FK68B5D9C7C0565C57` ON `service_item_profile`(`profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-312', '2.0.5', '3:388cccadd42e1ecc564a22f1fa17cb62', 187);

--  Changeset changelog_master.groovy::1409268087922-313::rvsz (generated)::(Checksum: 3:ea1926e5c79b5a033cffde87f8aa26ff)
CREATE INDEX `FKBF91F93C7E5C662` ON `service_item_score_card_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-313', '2.0.5', '3:ea1926e5c79b5a033cffde87f8aa26ff', 188);

--  Changeset changelog_master.groovy::1409268087922-314::rvsz (generated)::(Checksum: 3:be4de13c1852275e6fff82ba79a8dd73)
CREATE INDEX `FKBF91F93EF469C97` ON `service_item_score_card_item`(`score_card_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-314', '2.0.5', '3:be4de13c1852275e6fff82ba79a8dd73', 189);

--  Changeset changelog_master.groovy::1409268087922-315::rvsz (generated)::(Checksum: 3:141e9c5ecb54e8040b6ec121228d240f)
CREATE INDEX `FKFABD8966C7E5C662` ON `service_item_snapshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-315', '2.0.5', '3:141e9c5ecb54e8040b6ec121228d240f', 190);

--  Changeset changelog_master.groovy::1409268087922-316::rvsz (generated)::(Checksum: 3:a8f6191ffd749f20bebf9ad01e772a2a)
CREATE INDEX `FKB621CEB87666C6D2` ON `service_item_tag`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-316', '2.0.5', '3:a8f6191ffd749f20bebf9ad01e772a2a', 191);

--  Changeset changelog_master.groovy::1409268087922-317::rvsz (generated)::(Checksum: 3:fc4ea713c366d3ccb6ed9caad9277cff)
CREATE INDEX `FKB621CEB8C7E5C662` ON `service_item_tag`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-317', '2.0.5', '3:fc4ea713c366d3ccb6ed9caad9277cff', 192);

--  Changeset changelog_master.groovy::1409268087922-318::rvsz (generated)::(Checksum: 3:4ecb4043bf1621226f26f0211c0e1d57)
CREATE INDEX `FKB621CEB8EACAF137` ON `service_item_tag`(`tag_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-318', '2.0.5', '3:4ecb4043bf1621226f26f0211c0e1d57', 193);

--  Changeset changelog_master.groovy::1409268087922-319::rvsz (generated)::(Checksum: 3:a2bf898fbf28dd52154b91af99ce8816)
CREATE INDEX `service_item_tag_si_idx` ON `service_item_tag`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-319', '2.0.5', '3:a2bf898fbf28dd52154b91af99ce8816', 194);

--  Changeset changelog_master.groovy::1409268087922-320::rvsz (generated)::(Checksum: 3:9f8b05253fb908abeb7b99d7e9ccbd70)
CREATE INDEX `service_item_tag_tag_idx` ON `service_item_tag`(`tag_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-320', '2.0.5', '3:9f8b05253fb908abeb7b99d7e9ccbd70', 195);

--  Changeset changelog_master.groovy::1409268087922-321::rvsz (generated)::(Checksum: 3:626d6d510df5a61ab65cdbacccb51282)
CREATE INDEX `FKE1808BBC7E5C662` ON `service_item_tags`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-321', '2.0.5', '3:626d6d510df5a61ab65cdbacccb51282', 196);

--  Changeset changelog_master.groovy::1409268087922-322::rvsz (generated)::(Checksum: 3:ac8d0902b5ea1d7ad9d4ad101349ca9f)
CREATE INDEX `FKA55CFB56C7E5C662` ON `service_item_tech_pocs`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-322', '2.0.5', '3:ac8d0902b5ea1d7ad9d4ad101349ca9f', 197);

--  Changeset changelog_master.groovy::1409268087922-323::rvsz (generated)::(Checksum: 3:49086205c9b6649cdc38a5fd839448ef)
CREATE INDEX `FK863C793CC7E5C662` ON `si_recommended_layouts`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-323', '2.0.5', '3:49086205c9b6649cdc38a5fd839448ef', 198);

--  Changeset changelog_master.groovy::1409268087922-324::rvsz (generated)::(Checksum: 3:33a26c95896cced34934ec862b2d4356)
CREATE INDEX `FK68AC4917666C6D2` ON `state`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-324', '2.0.5', '3:33a26c95896cced34934ec862b2d4356', 199);

--  Changeset changelog_master.groovy::1409268087922-325::rvsz (generated)::(Checksum: 3:62bdca6c971512146f595c6b0ae7fa38)
CREATE INDEX `FK68AC491E31CB353` ON `state`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-325', '2.0.5', '3:62bdca6c971512146f595c6b0ae7fa38', 200);

--  Changeset changelog_master.groovy::1409268087922-326::rvsz (generated)::(Checksum: 3:a05b28ebd9f99e7d63843e0a75d3f65d)
CREATE UNIQUE INDEX `uuid_uniq_1409268087836` ON `state`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-326', '2.0.5', '3:a05b28ebd9f99e7d63843e0a75d3f65d', 201);

--  Changeset changelog_master.groovy::1409268087922-327::rvsz (generated)::(Checksum: 3:a3cba4f130b80b40bedb769eaa4ee13c)
CREATE INDEX `FK1BF9A7666C6D2` ON `tag`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-327', '2.0.5', '3:a3cba4f130b80b40bedb769eaa4ee13c', 202);

--  Changeset changelog_master.groovy::1409268087922-328::rvsz (generated)::(Checksum: 3:f5b5e5ee65a5550134c610491eea06ba)
CREATE INDEX `FK1BF9AE31CB353` ON `tag`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-328', '2.0.5', '3:f5b5e5ee65a5550134c610491eea06ba', 203);

--  Changeset changelog_master.groovy::1409268087922-329::rvsz (generated)::(Checksum: 3:d0c633c5b1178d842b342f18069da043)
CREATE INDEX `tag_title_idx` ON `tag`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-329', '2.0.5', '3:d0c633c5b1178d842b342f18069da043', 204);

--  Changeset changelog_master.groovy::1409268087922-330::rvsz (generated)::(Checksum: 3:f8a325c62602e3f169cc8adc728112f1)
CREATE INDEX `FK36452D7666C6D2` ON `text`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-330', '2.0.5', '3:f8a325c62602e3f169cc8adc728112f1', 205);

--  Changeset changelog_master.groovy::1409268087922-331::rvsz (generated)::(Checksum: 3:100ca50b5c9463ff0e2ab0575044af79)
CREATE INDEX `FK36452DE31CB353` ON `text`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-331', '2.0.5', '3:100ca50b5c9463ff0e2ab0575044af79', 206);

--  Changeset changelog_master.groovy::1409268087922-332::rvsz (generated)::(Checksum: 3:50b746966075d759ffe829f10efa8ec0)
CREATE UNIQUE INDEX `name_uniq_1409268087838` ON `text`(`name`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-332', '2.0.5', '3:50b746966075d759ffe829f10efa8ec0', 207);

--  Changeset changelog_master.groovy::1409268087922-333::rvsz (generated)::(Checksum: 3:2d061bb13f0faca29ca3f4d6a2c476bd)
CREATE INDEX `FK4C3A28437F5081E1` ON `text_area_cf`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-333', '2.0.5', '3:2d061bb13f0faca29ca3f4d6a2c476bd', 208);

--  Changeset changelog_master.groovy::1409268087922-334::rvsz (generated)::(Checksum: 3:b7ad7f168a71df1cb595d512de1d9b0e)
CREATE INDEX `FK3B0AE0819F8CD3D4` ON `text_area_cfd`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-334', '2.0.5', '3:b7ad7f168a71df1cb595d512de1d9b0e', 209);

--  Changeset changelog_master.groovy::1409268087922-335::rvsz (generated)::(Checksum: 3:ab4a5ac5a34022b4daee1b93394b6022)
CREATE INDEX `FKAB7D80B57F5081E1` ON `text_cf`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-335', '2.0.5', '3:ab4a5ac5a34022b4daee1b93394b6022', 210);

--  Changeset changelog_master.groovy::1409268087922-336::rvsz (generated)::(Checksum: 3:aee3f913c74c3ef9d8fe57d6fb7dd95c)
CREATE INDEX `FKC432964F9F8CD3D4` ON `text_cfd`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-336', '2.0.5', '3:aee3f913c74c3ef9d8fe57d6fb7dd95c', 211);

--  Changeset changelog_master.groovy::1409268087922-337::rvsz (generated)::(Checksum: 3:709665e6e4014859030edbb911f7051a)
CREATE INDEX `FK69B5879553AF61A` ON `types`(`image_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-337', '2.0.5', '3:709665e6e4014859030edbb911f7051a', 212);

--  Changeset changelog_master.groovy::1409268087922-338::rvsz (generated)::(Checksum: 3:a5f7dd6bfb32a1292256946a54571082)
CREATE INDEX `FK69B58797666C6D2` ON `types`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-338', '2.0.5', '3:a5f7dd6bfb32a1292256946a54571082', 213);

--  Changeset changelog_master.groovy::1409268087922-339::rvsz (generated)::(Checksum: 3:9681cebbda3cad5a4da8675b975b01b5)
CREATE INDEX `FK69B5879E31CB353` ON `types`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-339', '2.0.5', '3:9681cebbda3cad5a4da8675b975b01b5', 214);

--  Changeset changelog_master.groovy::1409268087922-340::rvsz (generated)::(Checksum: 3:254191038f893819384edd10d0770324)
CREATE UNIQUE INDEX `uuid_uniq_1409268087840` ON `types`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-340', '2.0.5', '3:254191038f893819384edd10d0770324', 215);

--  Changeset changelog_master.groovy::1409268087922-341::rvsz (generated)::(Checksum: 3:a1f8d35041be8b00003a053512132ff3)
CREATE INDEX `FK14C321B97666C6D2` ON `user_account`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-341', '2.0.5', '3:a1f8d35041be8b00003a053512132ff3', 216);

--  Changeset changelog_master.groovy::1409268087922-342::rvsz (generated)::(Checksum: 3:4da22521c3b93264bf9fb2054d633016)
CREATE INDEX `FK14C321B9E31CB353` ON `user_account`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-342', '2.0.5', '3:4da22521c3b93264bf9fb2054d633016', 217);

--  Changeset changelog_master.groovy::1409268087922-343::rvsz (generated)::(Checksum: 3:5d756c1786baa88fdbc491c3c72c52dd)
CREATE UNIQUE INDEX `username_uniq_1409268087841` ON `user_account`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog_master.groovy', '1409268087922-343', '2.0.5', '3:5d756c1786baa88fdbc491c3c72c52dd', 218);

--  Changeset changelog_master.groovy::1409268087922-67::rvsz (generated)::(Checksum: 3:012c519b42c92bf84f67dd2a9e3cbf61)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C37666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-67', '2.0.5', '3:012c519b42c92bf84f67dd2a9e3cbf61', 219);

--  Changeset changelog_master.groovy::1409268087922-68::rvsz (generated)::(Checksum: 3:fd91bd2d780f57b6090c3fca7918e9f1)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C3E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-68', '2.0.5', '3:fd91bd2d780f57b6090c3fca7918e9f1', 220);

--  Changeset changelog_master.groovy::1409268087922-69::rvsz (generated)::(Checksum: 3:d0718262545ecb537e4494bbe1692c0e)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C3EA25263C` FOREIGN KEY (`icon_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-69', '2.0.5', '3:d0718262545ecb537e4494bbe1692c0e', 221);

--  Changeset changelog_master.groovy::1409268087922-70::rvsz (generated)::(Checksum: 3:c0e9894b976dceb09fc43de299f992a7)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C057666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-70', '2.0.5', '3:c0e9894b976dceb09fc43de299f992a7', 222);

--  Changeset changelog_master.groovy::1409268087922-71::rvsz (generated)::(Checksum: 3:34b4d2a4851521abae8cfaa2fe8f4b9a)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C05E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-71', '2.0.5', '3:34b4d2a4851521abae8cfaa2fe8f4b9a', 223);

--  Changeset changelog_master.groovy::1409268087922-72::rvsz (generated)::(Checksum: 3:f5966e29d1ddc655bbaf907c82428247)
ALTER TABLE `avatar` ADD CONSTRAINT `FKAC32C1597666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-72', '2.0.5', '3:f5966e29d1ddc655bbaf907c82428247', 224);

--  Changeset changelog_master.groovy::1409268087922-73::rvsz (generated)::(Checksum: 3:397fa2359ca7216e2ae847451e70b0a6)
ALTER TABLE `avatar` ADD CONSTRAINT `FKAC32C159E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-73', '2.0.5', '3:397fa2359ca7216e2ae847451e70b0a6', 225);

--  Changeset changelog_master.groovy::1409268087922-74::rvsz (generated)::(Checksum: 3:0919cac3b93d89e27f450a3f42822f00)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFE7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-74', '2.0.5', '3:0919cac3b93d89e27f450a3f42822f00', 226);

--  Changeset changelog_master.groovy::1409268087922-75::rvsz (generated)::(Checksum: 3:7f041c5ab327f9e6925e7d44efe00d89)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFEE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-75', '2.0.5', '3:7f041c5ab327f9e6925e7d44efe00d89', 227);

--  Changeset changelog_master.groovy::1409268087922-76::rvsz (generated)::(Checksum: 3:ce8d88a6a0824410fe1e2e2951f36f9f)
ALTER TABLE `change_detail` ADD CONSTRAINT `FKB4467BC0855307BD` FOREIGN KEY (`service_item_activity_id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-76', '2.0.5', '3:ce8d88a6a0824410fe1e2e2951f36f9f', 228);

--  Changeset changelog_master.groovy::1409268087922-77::rvsz (generated)::(Checksum: 3:ca8d7816ecb6ae8c74f04fe2e647e0b4)
ALTER TABLE `check_box_cf` ADD CONSTRAINT `FKE828FA6E7F5081E1` FOREIGN KEY (`id`) REFERENCES `custom_field` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-77', '2.0.5', '3:ca8d7816ecb6ae8c74f04fe2e647e0b4', 229);

--  Changeset changelog_master.groovy::1409268087922-78::rvsz (generated)::(Checksum: 3:771a1f90535150e43fb3284471a524d5)
ALTER TABLE `check_box_cfd` ADD CONSTRAINT `FK1CF653B69F8CD3D4` FOREIGN KEY (`id`) REFERENCES `custom_field_definition` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-78', '2.0.5', '3:771a1f90535150e43fb3284471a524d5', 230);

--  Changeset changelog_master.groovy::1409268087922-79::rvsz (generated)::(Checksum: 3:f0906f0eb39b2202ecb84c2bca907d03)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B724207666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-79', '2.0.5', '3:f0906f0eb39b2202ecb84c2bca907d03', 231);

--  Changeset changelog_master.groovy::1409268087922-80::rvsz (generated)::(Checksum: 3:9ee958dc651da79e1462035ba353b6e0)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-80', '2.0.5', '3:9ee958dc651da79e1462035ba353b6e0', 232);

--  Changeset changelog_master.groovy::1409268087922-81::rvsz (generated)::(Checksum: 3:71e66a1509610c829680c54601e03968)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-81', '2.0.5', '3:71e66a1509610c829680c54601e03968', 233);

--  Changeset changelog_master.groovy::1409268087922-82::rvsz (generated)::(Checksum: 3:432fc8bd066d7de72903ae07ec4536f8)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420BA3FC877` FOREIGN KEY (`type_id`) REFERENCES `contact_type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-82', '2.0.5', '3:432fc8bd066d7de72903ae07ec4536f8', 234);

--  Changeset changelog_master.groovy::1409268087922-83::rvsz (generated)::(Checksum: 3:789dc9c339f5d808bbdaf6d72db916fe)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-83', '2.0.5', '3:789dc9c339f5d808bbdaf6d72db916fe', 235);

--  Changeset changelog_master.groovy::1409268087922-84::rvsz (generated)::(Checksum: 3:3225c8cbdce1d11887d89fd757132306)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-84', '2.0.5', '3:3225c8cbdce1d11887d89fd757132306', 236);

--  Changeset changelog_master.groovy::1409268087922-85::rvsz (generated)::(Checksum: 3:983097515729894dad2507ca99f32e06)
ALTER TABLE `custom_field` ADD CONSTRAINT `FK2ACD76AC7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-85', '2.0.5', '3:983097515729894dad2507ca99f32e06', 237);

--  Changeset changelog_master.groovy::1409268087922-86::rvsz (generated)::(Checksum: 3:f8984f55d2d689353911a530b439c31d)
ALTER TABLE `custom_field` ADD CONSTRAINT `FK2ACD76AC6F62C9ED` FOREIGN KEY (`custom_field_definition_id`) REFERENCES `custom_field_definition` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-86', '2.0.5', '3:f8984f55d2d689353911a530b439c31d', 238);

--  Changeset changelog_master.groovy::1409268087922-87::rvsz (generated)::(Checksum: 3:f976b1e9952c72ea3a508eaf57ad1324)
ALTER TABLE `custom_field` ADD CONSTRAINT `FK2ACD76ACE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-87', '2.0.5', '3:f976b1e9952c72ea3a508eaf57ad1324', 239);

--  Changeset changelog_master.groovy::1409268087922-88::rvsz (generated)::(Checksum: 3:7a133c4bc8810f0ef861dc2fd7eb3a65)
ALTER TABLE `custom_field_definition` ADD CONSTRAINT `FK150F70C67666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-88', '2.0.5', '3:7a133c4bc8810f0ef861dc2fd7eb3a65', 240);

--  Changeset changelog_master.groovy::1409268087922-89::rvsz (generated)::(Checksum: 3:57f459ddf25e898a2ca0188a0955cb4b)
ALTER TABLE `custom_field_definition` ADD CONSTRAINT `FK150F70C6E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-89', '2.0.5', '3:57f459ddf25e898a2ca0188a0955cb4b', 241);

--  Changeset changelog_master.groovy::1409268087922-90::rvsz (generated)::(Checksum: 3:b594a5f6dd6d7027e9a5984b5ec0025f)
ALTER TABLE `custom_field_definition_types` ADD CONSTRAINT `FK1A84FFC06928D597` FOREIGN KEY (`types_id`) REFERENCES `types` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-90', '2.0.5', '3:b594a5f6dd6d7027e9a5984b5ec0025f', 242);

--  Changeset changelog_master.groovy::1409268087922-91::rvsz (generated)::(Checksum: 3:f388279add0481baf5b16aae01eb7caf)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E367666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-91', '2.0.5', '3:f388279add0481baf5b16aae01eb7caf', 243);

--  Changeset changelog_master.groovy::1409268087922-92::rvsz (generated)::(Checksum: 3:81a126fb14af66e94b9a936a519c746a)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E36E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-92', '2.0.5', '3:81a126fb14af66e94b9a936a519c746a', 244);

--  Changeset changelog_master.groovy::1409268087922-93::rvsz (generated)::(Checksum: 3:b6d10278dcdd65a228aa56ac8eb98130)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E36553AF61A` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-93', '2.0.5', '3:b6d10278dcdd65a228aa56ac8eb98130', 245);

--  Changeset changelog_master.groovy::1409268087922-94::rvsz (generated)::(Checksum: 3:b14889211605a879980ab6927eb26b8c)
ALTER TABLE `drop_down_cf` ADD CONSTRAINT `FK13ADE7D07F5081E1` FOREIGN KEY (`id`) REFERENCES `custom_field` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-94', '2.0.5', '3:b14889211605a879980ab6927eb26b8c', 246);

--  Changeset changelog_master.groovy::1409268087922-95::rvsz (generated)::(Checksum: 3:975a5156bcf57bd18bf4aa79dc3e62dd)
ALTER TABLE `drop_down_cf` ADD CONSTRAINT `FK13ADE7D0BC98CEE3` FOREIGN KEY (`value_id`) REFERENCES `field_value` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-95', '2.0.5', '3:975a5156bcf57bd18bf4aa79dc3e62dd', 247);

--  Changeset changelog_master.groovy::1409268087922-96::rvsz (generated)::(Checksum: 3:37d8b3369b4505c265fd16265e705669)
ALTER TABLE `drop_down_cf_field_value` ADD CONSTRAINT `FK2627FFDDA5BD888` FOREIGN KEY (`field_value_id`) REFERENCES `field_value` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-96', '2.0.5', '3:37d8b3369b4505c265fd16265e705669', 248);

--  Changeset changelog_master.groovy::1409268087922-97::rvsz (generated)::(Checksum: 3:1e660dc9afa285e0a67b8281c9bdc337)
ALTER TABLE `drop_down_cfd` ADD CONSTRAINT `FK620F12949F8CD3D4` FOREIGN KEY (`id`) REFERENCES `custom_field_definition` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-97', '2.0.5', '3:1e660dc9afa285e0a67b8281c9bdc337', 249);

--  Changeset changelog_master.groovy::1409268087922-98::rvsz (generated)::(Checksum: 3:c39b74423678854769207d31634f0862)
ALTER TABLE `ext_profile` ADD CONSTRAINT `FKE9C8098B20F4E01` FOREIGN KEY (`id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-98', '2.0.5', '3:c39b74423678854769207d31634f0862', 250);

--  Changeset changelog_master.groovy::1409268087922-99::rvsz (generated)::(Checksum: 3:0662d22d0cfe3d99dab27ed24af3ac42)
ALTER TABLE `field_value` ADD CONSTRAINT `FK29F571EC7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-99', '2.0.5', '3:0662d22d0cfe3d99dab27ed24af3ac42', 251);

--  Changeset changelog_master.groovy::1409268087922-100::rvsz (generated)::(Checksum: 3:5c1686ba5598746a0a76db54d7ba7788)
ALTER TABLE `field_value` ADD CONSTRAINT `FK29F571ECF1F14D3C` FOREIGN KEY (`custom_field_definition_id`) REFERENCES `drop_down_cfd` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-100', '2.0.5', '3:5c1686ba5598746a0a76db54d7ba7788', 252);

--  Changeset changelog_master.groovy::1409268087922-101::rvsz (generated)::(Checksum: 3:d13e6a6d601f68416da128b77b8df783)
ALTER TABLE `field_value` ADD CONSTRAINT `FK29F571ECE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-101', '2.0.5', '3:d13e6a6d601f68416da128b77b8df783', 253);

--  Changeset changelog_master.groovy::1409268087922-102::rvsz (generated)::(Checksum: 3:1e7ee4ea63872eaa2864a5574446e9c4)
ALTER TABLE `image_url_cf` ADD CONSTRAINT `FK300028977F5081E1` FOREIGN KEY (`id`) REFERENCES `custom_field` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-102', '2.0.5', '3:1e7ee4ea63872eaa2864a5574446e9c4', 254);

--  Changeset changelog_master.groovy::1409268087922-103::rvsz (generated)::(Checksum: 3:73e6f5b95a92f0d05623a05a975cc4a3)
ALTER TABLE `image_url_cfd` ADD CONSTRAINT `FKD004EAAD9F8CD3D4` FOREIGN KEY (`id`) REFERENCES `custom_field_definition` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-103', '2.0.5', '3:73e6f5b95a92f0d05623a05a975cc4a3', 255);

--  Changeset changelog_master.groovy::1409268087922-104::rvsz (generated)::(Checksum: 3:ee236b44ab2604a6b9e4dab9d16f6776)
ALTER TABLE `images` ADD CONSTRAINT `FKB95A82787666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-104', '2.0.5', '3:ee236b44ab2604a6b9e4dab9d16f6776', 256);

--  Changeset changelog_master.groovy::1409268087922-105::rvsz (generated)::(Checksum: 3:d71a96f57177f3c83d8443003f0762d3)
ALTER TABLE `images` ADD CONSTRAINT `FKB95A8278E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-105', '2.0.5', '3:d71a96f57177f3c83d8443003f0762d3', 257);

--  Changeset changelog_master.groovy::1409268087922-106::rvsz (generated)::(Checksum: 3:ab74cd9c2a3eb6f9202405f2a97c77f3)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DF7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-106', '2.0.5', '3:ab74cd9c2a3eb6f9202405f2a97c77f3', 258);

--  Changeset changelog_master.groovy::1409268087922-107::rvsz (generated)::(Checksum: 3:d4c54fc15156503d313674ee383964d6)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DFE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-107', '2.0.5', '3:d4c54fc15156503d313674ee383964d6', 259);

--  Changeset changelog_master.groovy::1409268087922-108::rvsz (generated)::(Checksum: 3:d587bb9a0b5867061074afb55d11e6e4)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DFA31F8712` FOREIGN KEY (`interface_config_id`) REFERENCES `interface_configuration` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-108', '2.0.5', '3:d587bb9a0b5867061074afb55d11e6e4', 260);

--  Changeset changelog_master.groovy::1409268087922-109::rvsz (generated)::(Checksum: 3:5c0e970a1863f996de204b720c49c413)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DF919216CA` FOREIGN KEY (`last_run_result_id`) REFERENCES `import_task_result` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-109', '2.0.5', '3:5c0e970a1863f996de204b720c49c413', 261);

--  Changeset changelog_master.groovy::1409268087922-110::rvsz (generated)::(Checksum: 3:a053bceea35c1cbd0f4a17b486466d55)
ALTER TABLE `import_task_result` ADD CONSTRAINT `FK983AC27D11D7F882` FOREIGN KEY (`task_id`) REFERENCES `import_task` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-110', '2.0.5', '3:a053bceea35c1cbd0f4a17b486466d55', 262);

--  Changeset changelog_master.groovy::1409268087922-111::rvsz (generated)::(Checksum: 3:46fae3ba2e33eaa68952b0e55e848fe3)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CD8544299` FOREIGN KEY (`action_id`) REFERENCES `intent_action` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-111', '2.0.5', '3:46fae3ba2e33eaa68952b0e55e848fe3', 263);

--  Changeset changelog_master.groovy::1409268087922-112::rvsz (generated)::(Checksum: 3:fde98c8a0d1e864c6a82ad6e6af9795e)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-112', '2.0.5', '3:fde98c8a0d1e864c6a82ad6e6af9795e', 264);

--  Changeset changelog_master.groovy::1409268087922-113::rvsz (generated)::(Checksum: 3:fdbc8c4972d0f9c18602cc6757e1baee)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369C283F938E` FOREIGN KEY (`data_type_id`) REFERENCES `intent_data_type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-113', '2.0.5', '3:fdbc8c4972d0f9c18602cc6757e1baee', 265);

--  Changeset changelog_master.groovy::1409268087922-114::rvsz (generated)::(Checksum: 3:a96ec94441f5d31aff93ea7dc023d833)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-114', '2.0.5', '3:a96ec94441f5d31aff93ea7dc023d833', 266);

--  Changeset changelog_master.groovy::1409268087922-115::rvsz (generated)::(Checksum: 3:abb7940e2269ec8036649b6d7f075cbf)
ALTER TABLE `intent_action` ADD CONSTRAINT `FKEBCDD397666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-115', '2.0.5', '3:abb7940e2269ec8036649b6d7f075cbf', 267);

--  Changeset changelog_master.groovy::1409268087922-116::rvsz (generated)::(Checksum: 3:48df11e51f607f71ab3d78d77c8e862f)
ALTER TABLE `intent_action` ADD CONSTRAINT `FKEBCDD39E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-116', '2.0.5', '3:48df11e51f607f71ab3d78d77c8e862f', 268);

--  Changeset changelog_master.groovy::1409268087922-117::rvsz (generated)::(Checksum: 3:3490f48956316012f6c32eebb1066863)
ALTER TABLE `intent_data_type` ADD CONSTRAINT `FKEADB30CC7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-117', '2.0.5', '3:3490f48956316012f6c32eebb1066863', 269);

--  Changeset changelog_master.groovy::1409268087922-118::rvsz (generated)::(Checksum: 3:bda01aa389d75a04fc6fb48ebabc74b3)
ALTER TABLE `intent_data_type` ADD CONSTRAINT `FKEADB30CCE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-118', '2.0.5', '3:bda01aa389d75a04fc6fb48ebabc74b3', 270);

--  Changeset changelog_master.groovy::1409268087922-119::rvsz (generated)::(Checksum: 3:4e0343e180a1873bf9d9518389a3a694)
ALTER TABLE `intent_direction` ADD CONSTRAINT `FKC723A59C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-119', '2.0.5', '3:4e0343e180a1873bf9d9518389a3a694', 271);

--  Changeset changelog_master.groovy::1409268087922-120::rvsz (generated)::(Checksum: 3:0c6b0dd68dfbbea302c92519c8417bfe)
ALTER TABLE `intent_direction` ADD CONSTRAINT `FKC723A59CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-120', '2.0.5', '3:0c6b0dd68dfbbea302c92519c8417bfe', 272);

--  Changeset changelog_master.groovy::1409268087922-121::rvsz (generated)::(Checksum: 3:a44ccb86429d03ec4fea4a898375f590)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D335A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-121', '2.0.5', '3:a44ccb86429d03ec4fea4a898375f590', 273);

--  Changeset changelog_master.groovy::1409268087922-122::rvsz (generated)::(Checksum: 3:48e7833bd349bbe1a7a03a7c6d8246b0)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D337666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-122', '2.0.5', '3:48e7833bd349bbe1a7a03a7c6d8246b0', 274);

--  Changeset changelog_master.groovy::1409268087922-123::rvsz (generated)::(Checksum: 3:704e07f94eb1a0c534dd728f8c94cede)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-123', '2.0.5', '3:704e07f94eb1a0c534dd728f8c94cede', 275);

--  Changeset changelog_master.groovy::1409268087922-124::rvsz (generated)::(Checksum: 3:e75f65a25771c68ccb85c095a5bb6c66)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-124', '2.0.5', '3:e75f65a25771c68ccb85c095a5bb6c66', 276);

--  Changeset changelog_master.groovy::1409268087922-125::rvsz (generated)::(Checksum: 3:39ddedf5e6c93bded7890f9b5d858211)
ALTER TABLE `modify_relationship_activity` ADD CONSTRAINT `FKE68D3F71C359936F` FOREIGN KEY (`id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-125', '2.0.5', '3:39ddedf5e6c93bded7890f9b5d858211', 277);

--  Changeset changelog_master.groovy::1409268087922-126::rvsz (generated)::(Checksum: 3:2ea996906f2adee37b8dd0590b64674b)
ALTER TABLE `owf_properties` ADD CONSTRAINT `FKE88638947666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-126', '2.0.5', '3:2ea996906f2adee37b8dd0590b64674b', 278);

--  Changeset changelog_master.groovy::1409268087922-127::rvsz (generated)::(Checksum: 3:369d279279c3ec7ad7ed862ff0f36b9a)
ALTER TABLE `owf_properties` ADD CONSTRAINT `FKE8863894E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-127', '2.0.5', '3:369d279279c3ec7ad7ed862ff0f36b9a', 279);

--  Changeset changelog_master.groovy::1409268087922-128::rvsz (generated)::(Checksum: 3:bfd29279c3f4c7af9afeeb5aa13a51d5)
ALTER TABLE `owf_properties_intent` ADD CONSTRAINT `FK3F99ECA7A651895D` FOREIGN KEY (`intent_id`) REFERENCES `intent` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-128', '2.0.5', '3:bfd29279c3f4c7af9afeeb5aa13a51d5', 280);

--  Changeset changelog_master.groovy::1409268087922-129::rvsz (generated)::(Checksum: 3:17a78b4c19df126bd43b218849b4f3b5)
ALTER TABLE `owf_properties_intent` ADD CONSTRAINT `FK3F99ECA74704E25C` FOREIGN KEY (`owf_properties_intents_id`) REFERENCES `owf_properties` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-129', '2.0.5', '3:17a78b4c19df126bd43b218849b4f3b5', 281);

--  Changeset changelog_master.groovy::1409268087922-130::rvsz (generated)::(Checksum: 3:07dc389224bf7c2171107928a594af44)
ALTER TABLE `owf_widget_types` ADD CONSTRAINT `FK6AB6A9DF7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-130', '2.0.5', '3:07dc389224bf7c2171107928a594af44', 282);

--  Changeset changelog_master.groovy::1409268087922-131::rvsz (generated)::(Checksum: 3:c87912351d597d8b7c5d42902c6df86d)
ALTER TABLE `owf_widget_types` ADD CONSTRAINT `FK6AB6A9DFE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-131', '2.0.5', '3:c87912351d597d8b7c5d42902c6df86d', 283);

--  Changeset changelog_master.groovy::1409268087922-132::rvsz (generated)::(Checksum: 3:d18161f4381ebc7d93497532e4e28567)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A961C3343D` FOREIGN KEY (`avatar_id`) REFERENCES `avatar` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-132', '2.0.5', '3:d18161f4381ebc7d93497532e4e28567', 284);

--  Changeset changelog_master.groovy::1409268087922-133::rvsz (generated)::(Checksum: 3:e86f16463585314b530be5e7573a9296)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-133', '2.0.5', '3:e86f16463585314b530be5e7573a9296', 285);

--  Changeset changelog_master.groovy::1409268087922-134::rvsz (generated)::(Checksum: 3:c5cba2edf4144c33b909623615472244)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-134', '2.0.5', '3:c5cba2edf4144c33b909623615472244', 286);

--  Changeset changelog_master.groovy::1409268087922-135::rvsz (generated)::(Checksum: 3:17af64a271de5d59da444e307e0649f0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C1285C359936F` FOREIGN KEY (`id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-135', '2.0.5', '3:17af64a271de5d59da444e307e0649f0', 287);

--  Changeset changelog_master.groovy::1409268087922-136::rvsz (generated)::(Checksum: 3:3c8e09e6df0585dccbc5813b6ed69ff0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C128582548A4A` FOREIGN KEY (`rejection_listing_id`) REFERENCES `rejection_listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-136', '2.0.5', '3:3c8e09e6df0585dccbc5813b6ed69ff0', 288);

--  Changeset changelog_master.groovy::1409268087922-137::rvsz (generated)::(Checksum: 3:c789755760ba85d22170229257e27420)
ALTER TABLE `rejection_justification` ADD CONSTRAINT `FK12B0A53C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-137', '2.0.5', '3:c789755760ba85d22170229257e27420', 289);

--  Changeset changelog_master.groovy::1409268087922-138::rvsz (generated)::(Checksum: 3:c133b80c0e79f87d2774d50ae9ae913d)
ALTER TABLE `rejection_justification` ADD CONSTRAINT `FK12B0A53CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-138', '2.0.5', '3:c133b80c0e79f87d2774d50ae9ae913d', 290);

--  Changeset changelog_master.groovy::1409268087922-139::rvsz (generated)::(Checksum: 3:0ec52b0ffac45e2d8b8d25ecdd0b708a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E5A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-139', '2.0.5', '3:0ec52b0ffac45e2d8b8d25ecdd0b708a', 291);

--  Changeset changelog_master.groovy::1409268087922-140::rvsz (generated)::(Checksum: 3:c4b6c6b7843000ce7af769a43a00eada)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-140', '2.0.5', '3:c4b6c6b7843000ce7af769a43a00eada', 292);

--  Changeset changelog_master.groovy::1409268087922-141::rvsz (generated)::(Checksum: 3:a5a6551c740e542d7847e4c110846e8a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-141', '2.0.5', '3:a5a6551c740e542d7847e4c110846e8a', 293);

--  Changeset changelog_master.groovy::1409268087922-142::rvsz (generated)::(Checksum: 3:a4e272508b9e57b1bb808c09137603cd)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E19CEB614` FOREIGN KEY (`justification_id`) REFERENCES `rejection_justification` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-142', '2.0.5', '3:a4e272508b9e57b1bb808c09137603cd', 294);

--  Changeset changelog_master.groovy::1409268087922-143::rvsz (generated)::(Checksum: 3:2fa419ff4750218d35b68a34d8c3da7b)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-143', '2.0.5', '3:2fa419ff4750218d35b68a34d8c3da7b', 295);

--  Changeset changelog_master.groovy::1409268087922-144::rvsz (generated)::(Checksum: 3:b07ddeec1bdade32f15ca8148ca1f984)
ALTER TABLE `relationship` ADD CONSTRAINT `FKF06476389D70DD39` FOREIGN KEY (`owning_entity_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-144', '2.0.5', '3:b07ddeec1bdade32f15ca8148ca1f984', 296);

--  Changeset changelog_master.groovy::1409268087922-145::rvsz (generated)::(Checksum: 3:52fa8b8938c8b9c84ae74abbb0c410a7)
ALTER TABLE `relationship_activity_log` ADD CONSTRAINT `FK594974BB25A20F9D` FOREIGN KEY (`service_item_snapshot_id`) REFERENCES `service_item_snapshot` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-145', '2.0.5', '3:52fa8b8938c8b9c84ae74abbb0c410a7', 297);

--  Changeset changelog_master.groovy::1409268087922-146::rvsz (generated)::(Checksum: 3:9bbf25bf2c4101144e5dddb1f81e06f1)
ALTER TABLE `relationship_service_item` ADD CONSTRAINT `FKDA02504C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-146', '2.0.5', '3:9bbf25bf2c4101144e5dddb1f81e06f1', 298);

--  Changeset changelog_master.groovy::1409268087922-147::rvsz (generated)::(Checksum: 3:62ebbecfd4877631ccde6515ed314fc8)
ALTER TABLE `score_card_item` ADD CONSTRAINT `FKE51CCD757666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-147', '2.0.5', '3:62ebbecfd4877631ccde6515ed314fc8', 299);

--  Changeset changelog_master.groovy::1409268087922-148::rvsz (generated)::(Checksum: 3:ae783dc6290ffe3a26343f83d557b016)
ALTER TABLE `score_card_item` ADD CONSTRAINT `FKE51CCD75E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-148', '2.0.5', '3:ae783dc6290ffe3a26343f83d557b016', 300);

--  Changeset changelog_master.groovy::1409268087922-149::rvsz (generated)::(Checksum: 3:f6eba1782ecc96476aaeb2674f93d056)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D85667666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-149', '2.0.5', '3:f6eba1782ecc96476aaeb2674f93d056', 301);

--  Changeset changelog_master.groovy::1409268087922-150::rvsz (generated)::(Checksum: 3:5e3bd661f76ea9ab42001333930a315f)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-150', '2.0.5', '3:5e3bd661f76ea9ab42001333930a315f', 302);

--  Changeset changelog_master.groovy::1409268087922-151::rvsz (generated)::(Checksum: 3:eedfff3fc77f6b2d0781b36e4cba6fe6)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-151', '2.0.5', '3:eedfff3fc77f6b2d0781b36e4cba6fe6', 303);

--  Changeset changelog_master.groovy::1409268087922-152::rvsz (generated)::(Checksum: 3:d316ba33a1fcfd9218ff525e7d793c6b)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D143B24BD` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-152', '2.0.5', '3:d316ba33a1fcfd9218ff525e7d793c6b', 304);

--  Changeset changelog_master.groovy::1409268087922-153::rvsz (generated)::(Checksum: 3:fff97300dc2f8677145823d36c5bbd31)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-153', '2.0.5', '3:fff97300dc2f8677145823d36c5bbd31', 305);

--  Changeset changelog_master.groovy::1409268087922-154::rvsz (generated)::(Checksum: 3:5941250db3aedcd46e620dde3dd7a1aa)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565DE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-154', '2.0.5', '3:5941250db3aedcd46e620dde3dd7a1aa', 306);

--  Changeset changelog_master.groovy::1409268087922-155::rvsz (generated)::(Checksum: 3:2eddcdfbdecfb39d6526c001c9dfb658)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D2746B676` FOREIGN KEY (`last_activity_id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-155', '2.0.5', '3:2eddcdfbdecfb39d6526c001c9dfb658', 307);

--  Changeset changelog_master.groovy::1409268087922-156::rvsz (generated)::(Checksum: 3:b550b7744e46c376b21f95f52be94741)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D904D6974` FOREIGN KEY (`owf_properties_id`) REFERENCES `owf_properties` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-156', '2.0.5', '3:b550b7744e46c376b21f95f52be94741', 308);

--  Changeset changelog_master.groovy::1409268087922-157::rvsz (generated)::(Checksum: 3:f85f96b19885ddb87f776cccbad69643)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D6928D597` FOREIGN KEY (`types_id`) REFERENCES `types` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-157', '2.0.5', '3:f85f96b19885ddb87f776cccbad69643', 309);

--  Changeset changelog_master.groovy::1409268087922-158::rvsz (generated)::(Checksum: 3:d936c54eef6b6e964fa5c69c63fbbf67)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B15A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-158', '2.0.5', '3:d936c54eef6b6e964fa5c69c63fbbf67', 310);

--  Changeset changelog_master.groovy::1409268087922-159::rvsz (generated)::(Checksum: 3:54a152fc18eb6134afd5a80599d7d81c)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B17666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-159', '2.0.5', '3:54a152fc18eb6134afd5a80599d7d81c', 311);

--  Changeset changelog_master.groovy::1409268087922-160::rvsz (generated)::(Checksum: 3:c7e121efc0ffad4b010d8e0ab4c383fe)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B1E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-160', '2.0.5', '3:c7e121efc0ffad4b010d8e0ab4c383fe', 312);

--  Changeset changelog_master.groovy::1409268087922-161::rvsz (generated)::(Checksum: 3:7419d815453d39e96aff8aa4369c9adf)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B1C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-161', '2.0.5', '3:7419d815453d39e96aff8aa4369c9adf', 313);

--  Changeset changelog_master.groovy::1409268087922-162::rvsz (generated)::(Checksum: 3:79052fcbd1e5106b6ac399b700788437)
ALTER TABLE `service_item_category` ADD CONSTRAINT `FKECC570A0DA41995D` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-162', '2.0.5', '3:79052fcbd1e5106b6ac399b700788437', 314);

--  Changeset changelog_master.groovy::1409268087922-163::rvsz (generated)::(Checksum: 3:8a39f02794a0bbf87347bfad8f84b0e9)
ALTER TABLE `service_item_custom_field` ADD CONSTRAINT `FK46E9894E7B56E054` FOREIGN KEY (`custom_field_id`) REFERENCES `custom_field` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-163', '2.0.5', '3:8a39f02794a0bbf87347bfad8f84b0e9', 315);

--  Changeset changelog_master.groovy::1409268087922-164::rvsz (generated)::(Checksum: 3:4d420ccbd0ca5606d2adf5d7aac8a36c)
ALTER TABLE `service_item_documentation_url` ADD CONSTRAINT `FK24572D08C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-164', '2.0.5', '3:4d420ccbd0ca5606d2adf5d7aac8a36c', 316);

--  Changeset changelog_master.groovy::1409268087922-165::rvsz (generated)::(Checksum: 3:59b059175d04680e3e92319c1c79acfc)
ALTER TABLE `service_item_profile` ADD CONSTRAINT `FK68B5D9C7C0565C57` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-165', '2.0.5', '3:59b059175d04680e3e92319c1c79acfc', 317);

--  Changeset changelog_master.groovy::1409268087922-166::rvsz (generated)::(Checksum: 3:62065e81eb20b63d55a48d9ab351efce)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F93EF469C97` FOREIGN KEY (`score_card_item_id`) REFERENCES `score_card_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-166', '2.0.5', '3:62065e81eb20b63d55a48d9ab351efce', 318);

--  Changeset changelog_master.groovy::1409268087922-167::rvsz (generated)::(Checksum: 3:0a2d929b0c81ecb716c2135f8a0e73d4)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F93C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-167', '2.0.5', '3:0a2d929b0c81ecb716c2135f8a0e73d4', 319);

--  Changeset changelog_master.groovy::1409268087922-168::rvsz (generated)::(Checksum: 3:d633ffb580e53186e21ad6bfc6e0f1bd)
ALTER TABLE `service_item_snapshot` ADD CONSTRAINT `FKFABD8966C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-168', '2.0.5', '3:d633ffb580e53186e21ad6bfc6e0f1bd', 320);

--  Changeset changelog_master.groovy::1409268087922-169::rvsz (generated)::(Checksum: 3:5c07ccda7d132407c1a0a37a4187d936)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB87666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-169', '2.0.5', '3:5c07ccda7d132407c1a0a37a4187d936', 321);

--  Changeset changelog_master.groovy::1409268087922-170::rvsz (generated)::(Checksum: 3:6c7200bc4927a0e147c68170e94b2013)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB8C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-170', '2.0.5', '3:6c7200bc4927a0e147c68170e94b2013', 322);

--  Changeset changelog_master.groovy::1409268087922-171::rvsz (generated)::(Checksum: 3:ac6dd24a2661ca11105ead8109083fca)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB8EACAF137` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-171', '2.0.5', '3:ac6dd24a2661ca11105ead8109083fca', 323);

--  Changeset changelog_master.groovy::1409268087922-172::rvsz (generated)::(Checksum: 3:5f9d9a8f96b880c9dbec38391f6a0bb3)
ALTER TABLE `service_item_tags` ADD CONSTRAINT `FKE1808BBC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-172', '2.0.5', '3:5f9d9a8f96b880c9dbec38391f6a0bb3', 324);

--  Changeset changelog_master.groovy::1409268087922-173::rvsz (generated)::(Checksum: 3:e9aa98b1fb28a5cd533d94d016e3d5e2)
ALTER TABLE `service_item_tech_pocs` ADD CONSTRAINT `FKA55CFB56C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-173', '2.0.5', '3:e9aa98b1fb28a5cd533d94d016e3d5e2', 325);

--  Changeset changelog_master.groovy::1409268087922-174::rvsz (generated)::(Checksum: 3:201f8bdc487570cf35d198837c85c7ca)
ALTER TABLE `si_recommended_layouts` ADD CONSTRAINT `FK863C793CC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-174', '2.0.5', '3:201f8bdc487570cf35d198837c85c7ca', 326);

--  Changeset changelog_master.groovy::1409268087922-175::rvsz (generated)::(Checksum: 3:60918a55052083abdd77445be8ba80da)
ALTER TABLE `state` ADD CONSTRAINT `FK68AC4917666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-175', '2.0.5', '3:60918a55052083abdd77445be8ba80da', 327);

--  Changeset changelog_master.groovy::1409268087922-176::rvsz (generated)::(Checksum: 3:c916874b62d9973b2b60b6ed4a97b5e4)
ALTER TABLE `state` ADD CONSTRAINT `FK68AC491E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-176', '2.0.5', '3:c916874b62d9973b2b60b6ed4a97b5e4', 328);

--  Changeset changelog_master.groovy::1409268087922-177::rvsz (generated)::(Checksum: 3:bde34c0ea37cc97ff5077237a4a9a9c3)
ALTER TABLE `tag` ADD CONSTRAINT `FK1BF9A7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-177', '2.0.5', '3:bde34c0ea37cc97ff5077237a4a9a9c3', 329);

--  Changeset changelog_master.groovy::1409268087922-178::rvsz (generated)::(Checksum: 3:1670611fe1b80b5a0c40ce47dd33208f)
ALTER TABLE `tag` ADD CONSTRAINT `FK1BF9AE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-178', '2.0.5', '3:1670611fe1b80b5a0c40ce47dd33208f', 330);

--  Changeset changelog_master.groovy::1409268087922-179::rvsz (generated)::(Checksum: 3:81ef703250a936c5cf096dab7fb46321)
ALTER TABLE `text` ADD CONSTRAINT `FK36452D7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-179', '2.0.5', '3:81ef703250a936c5cf096dab7fb46321', 331);

--  Changeset changelog_master.groovy::1409268087922-180::rvsz (generated)::(Checksum: 3:c430a16c91202cb579c5f985cd639eab)
ALTER TABLE `text` ADD CONSTRAINT `FK36452DE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-180', '2.0.5', '3:c430a16c91202cb579c5f985cd639eab', 332);

--  Changeset changelog_master.groovy::1409268087922-181::rvsz (generated)::(Checksum: 3:e715a3d0eda472bff1fd5d723e346e2c)
ALTER TABLE `text_area_cf` ADD CONSTRAINT `FK4C3A28437F5081E1` FOREIGN KEY (`id`) REFERENCES `custom_field` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-181', '2.0.5', '3:e715a3d0eda472bff1fd5d723e346e2c', 333);

--  Changeset changelog_master.groovy::1409268087922-182::rvsz (generated)::(Checksum: 3:a0d3950f2617d7378e216c1d69f9c59c)
ALTER TABLE `text_area_cfd` ADD CONSTRAINT `FK3B0AE0819F8CD3D4` FOREIGN KEY (`id`) REFERENCES `custom_field_definition` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-182', '2.0.5', '3:a0d3950f2617d7378e216c1d69f9c59c', 334);

--  Changeset changelog_master.groovy::1409268087922-183::rvsz (generated)::(Checksum: 3:c90eb3e940de14ee5e5bb7575f0b6cc6)
ALTER TABLE `text_cf` ADD CONSTRAINT `FKAB7D80B57F5081E1` FOREIGN KEY (`id`) REFERENCES `custom_field` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-183', '2.0.5', '3:c90eb3e940de14ee5e5bb7575f0b6cc6', 335);

--  Changeset changelog_master.groovy::1409268087922-184::rvsz (generated)::(Checksum: 3:c9772b75b4eb95aecf8fa81bff56b247)
ALTER TABLE `text_cfd` ADD CONSTRAINT `FKC432964F9F8CD3D4` FOREIGN KEY (`id`) REFERENCES `custom_field_definition` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-184', '2.0.5', '3:c9772b75b4eb95aecf8fa81bff56b247', 336);

--  Changeset changelog_master.groovy::1409268087922-185::rvsz (generated)::(Checksum: 3:f9354f4a00ffd1125f4aa8cf8c27f848)
ALTER TABLE `types` ADD CONSTRAINT `FK69B58797666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-185', '2.0.5', '3:f9354f4a00ffd1125f4aa8cf8c27f848', 337);

--  Changeset changelog_master.groovy::1409268087922-186::rvsz (generated)::(Checksum: 3:83c281fe67e5292b39a09a2c7dc236ef)
ALTER TABLE `types` ADD CONSTRAINT `FK69B5879E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-186', '2.0.5', '3:83c281fe67e5292b39a09a2c7dc236ef', 338);

--  Changeset changelog_master.groovy::1409268087922-187::rvsz (generated)::(Checksum: 3:038742c298b4d3893f6fd6b1f08dcd53)
ALTER TABLE `types` ADD CONSTRAINT `FK69B5879553AF61A` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-187', '2.0.5', '3:038742c298b4d3893f6fd6b1f08dcd53', 339);

--  Changeset changelog_master.groovy::1409268087922-188::rvsz (generated)::(Checksum: 3:f729f552ceca36a137f3769f51bc6664)
ALTER TABLE `U_DOMAIN` ADD CONSTRAINT `FK97BAABEE7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-188', '2.0.5', '3:f729f552ceca36a137f3769f51bc6664', 340);

--  Changeset changelog_master.groovy::1409268087922-189::rvsz (generated)::(Checksum: 3:cf2276052d5b3f4e52206e93bb35b220)
ALTER TABLE `U_DOMAIN` ADD CONSTRAINT `FK97BAABEEE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-189', '2.0.5', '3:cf2276052d5b3f4e52206e93bb35b220', 341);

--  Changeset changelog_master.groovy::1409268087922-190::rvsz (generated)::(Checksum: 3:be39f1d0b8f0b0b33d2742e2005a9d11)
ALTER TABLE `user_account` ADD CONSTRAINT `FK14C321B97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-190', '2.0.5', '3:be39f1d0b8f0b0b33d2742e2005a9d11', 342);

--  Changeset changelog_master.groovy::1409268087922-191::rvsz (generated)::(Checksum: 3:28e21ae37aab6377d77dba5b05bdea43)
ALTER TABLE `user_account` ADD CONSTRAINT `FK14C321B9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog_master.groovy', '1409268087922-191', '2.0.5', '3:28e21ae37aab6377d77dba5b05bdea43', 343);

