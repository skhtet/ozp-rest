--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: changelog.groovy
--  Ran at: 9/8/14 9:20 AM
--  Against: root@localhost@jdbc:mysql://localhost:3306/mpcreate
--  Liquibase version: 2.0.5
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE `DATABASECHANGELOGLOCK` (`ID` INT NOT NULL, `LOCKED` TINYINT(1) NOT NULL, `LOCKGRANTED` DATETIME NULL, `LOCKEDBY` VARCHAR(255) NULL, CONSTRAINT `PK_DATABASECHANGELOGLOCK` PRIMARY KEY (`ID`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`) VALUES (1, 0);

--  Lock Database
--  Create Database Change Log Table
CREATE TABLE `DATABASECHANGELOG` (`ID` VARCHAR(63) NOT NULL, `AUTHOR` VARCHAR(63) NOT NULL, `FILENAME` VARCHAR(200) NOT NULL, `DATEEXECUTED` DATETIME NOT NULL, `ORDEREXECUTED` INT NOT NULL, `EXECTYPE` VARCHAR(10) NOT NULL, `MD5SUM` VARCHAR(35) NULL, `DESCRIPTION` VARCHAR(255) NULL, `COMMENTS` VARCHAR(255) NULL, `TAG` VARCHAR(255) NULL, `LIQUIBASE` VARCHAR(20) NULL, CONSTRAINT `PK_DATABASECHANGELOG` PRIMARY KEY (`ID`, `AUTHOR`, `FILENAME`)) ENGINE=InnoDB;

--  Changeset changelog.groovy::1410181719105-1::rvsz (generated)::(Checksum: 3:1f5d38f6c5391dcc50cd9a53f0bd0a93)
CREATE TABLE `affiliated_marketplace` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `active` INT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_id` BIGINT NULL, `name` VARCHAR(50) NOT NULL, `server_url` VARCHAR(2083) NOT NULL, `timeout` BIGINT NULL, CONSTRAINT `affiliated_maPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-1', '2.0.5', '3:1f5d38f6c5391dcc50cd9a53f0bd0a93', 1);

--  Changeset changelog.groovy::1410181719105-2::rvsz (generated)::(Checksum: 3:e413eee7f1c670e57ccabaf3041c0cf2)
CREATE TABLE `agency` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_url` VARCHAR(2000) NOT NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `agencyPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-2', '2.0.5', '3:e413eee7f1c670e57ccabaf3041c0cf2', 2);

--  Changeset changelog.groovy::1410181719105-3::rvsz (generated)::(Checksum: 3:5c6deb83395f336990f8965076491fab)
CREATE TABLE `application_library_entry` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `folder` VARCHAR(255) NULL, `owner_id` BIGINT NOT NULL, `service_item_id` BIGINT NOT NULL, `application_library_idx` INT NULL, CONSTRAINT `application_lPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-3', '2.0.5', '3:5c6deb83395f336990f8965076491fab', 3);

--  Changeset changelog.groovy::1410181719105-4::rvsz (generated)::(Checksum: 3:e7e6e0d82829f03c13f2c90878afbfe7)
CREATE TABLE `avatar` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `content_type` VARCHAR(255) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `is_default` bit NOT NULL, `pic` mediumblob NULL, CONSTRAINT `avatarPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-4', '2.0.5', '3:e7e6e0d82829f03c13f2c90878afbfe7', 4);

--  Changeset changelog.groovy::1410181719105-5::rvsz (generated)::(Checksum: 3:3c8612802ba92d864bcc75af84bc9bd0)
CREATE TABLE `category` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `categoryPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-5', '2.0.5', '3:3c8612802ba92d864bcc75af84bc9bd0', 5);

--  Changeset changelog.groovy::1410181719105-6::rvsz (generated)::(Checksum: 3:98e78239cb364b058aa28d438f0a6f3c)
CREATE TABLE `change_detail` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `field_name` VARCHAR(255) NOT NULL, `new_value` VARCHAR(4000) NULL, `old_value` VARCHAR(4000) NULL, `service_item_activity_id` BIGINT NOT NULL, CONSTRAINT `change_detailPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-6', '2.0.5', '3:98e78239cb364b058aa28d438f0a6f3c', 6);

--  Changeset changelog.groovy::1410181719105-7::rvsz (generated)::(Checksum: 3:2fd2da818906249dcf154d70b688320a)
CREATE TABLE `contact` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(100) NOT NULL, `name` VARCHAR(100) NOT NULL, `organization` VARCHAR(100) NULL, `secure_phone` VARCHAR(50) NULL, `service_item_id` BIGINT NOT NULL, `type_id` BIGINT NOT NULL, `unsecure_phone` VARCHAR(50) NULL, CONSTRAINT `contactPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-7', '2.0.5', '3:2fd2da818906249dcf154d70b688320a', 7);

--  Changeset changelog.groovy::1410181719105-8::rvsz (generated)::(Checksum: 3:73e507e6e52c79361a2c768bb9c118df)
CREATE TABLE `contact_type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `required` bit NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `contact_typePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-8', '2.0.5', '3:73e507e6e52c79361a2c768bb9c118df', 8);

--  Changeset changelog.groovy::1410181719105-9::rvsz (generated)::(Checksum: 3:8bad284909f640ab1b5a3bc225f2aae0)
CREATE TABLE `default_images` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `defined_default_type` VARCHAR(255) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_id` BIGINT NOT NULL, CONSTRAINT `default_imagePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-9', '2.0.5', '3:8bad284909f640ab1b5a3bc225f2aae0', 9);

--  Changeset changelog.groovy::1410181719105-10::rvsz (generated)::(Checksum: 3:5a925436362f010afc7c68f3a3592fe5)
CREATE TABLE `ext_profile` (`id` BIGINT NOT NULL, `external_edit_url` VARCHAR(2083) NULL, `external_id` VARCHAR(255) NULL, `external_view_url` VARCHAR(2083) NULL, `system_uri` VARCHAR(255) NOT NULL, CONSTRAINT `ext_profilePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-10', '2.0.5', '3:5a925436362f010afc7c68f3a3592fe5', 10);

--  Changeset changelog.groovy::1410181719105-11::rvsz (generated)::(Checksum: 3:cd7194106bc54a86b229a5a36543e41d)
CREATE TABLE `images` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `bytes` mediumblob NOT NULL, `content_type` VARCHAR(255) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_size` double precision NULL, `is_default` bit NOT NULL, `type` VARCHAR(255) NOT NULL, CONSTRAINT `imagesPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-11', '2.0.5', '3:cd7194106bc54a86b229a5a36543e41d', 11);

--  Changeset changelog.groovy::1410181719105-12::rvsz (generated)::(Checksum: 3:ab10ac2aed1beb1454addfca3aa05ea0)
CREATE TABLE `import_task` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `cron_exp` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `enabled` bit NOT NULL, `exec_interval` INT NULL, `extra_url_params` VARCHAR(512) NULL, `interface_config_id` BIGINT NOT NULL, `keystore_pass` VARCHAR(2048) NULL, `keystore_path` VARCHAR(2048) NULL, `last_run_result_id` BIGINT NULL, `name` VARCHAR(50) NOT NULL, `truststore_path` VARCHAR(2048) NULL, `update_type` VARCHAR(7) NOT NULL, `url` VARCHAR(255) NULL, CONSTRAINT `import_taskPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-12', '2.0.5', '3:ab10ac2aed1beb1454addfca3aa05ea0', 12);

--  Changeset changelog.groovy::1410181719105-13::rvsz (generated)::(Checksum: 3:2c4db683b45130f9966f2cf458679d9e)
CREATE TABLE `import_task_result` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `message` VARCHAR(4000) NOT NULL, `result` bit NOT NULL, `run_date` DATETIME NOT NULL, `task_id` BIGINT NOT NULL, CONSTRAINT `import_task_rPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-13', '2.0.5', '3:2c4db683b45130f9966f2cf458679d9e', 13);

--  Changeset changelog.groovy::1410181719105-14::rvsz (generated)::(Checksum: 3:76fabfbed05f6795a7960413c825cf57)
CREATE TABLE `intent` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `data_type_id` BIGINT NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `receive` bit NOT NULL, `send` bit NOT NULL, `service_item_id` BIGINT NOT NULL, CONSTRAINT `intentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-14', '2.0.5', '3:76fabfbed05f6795a7960413c825cf57', 14);

--  Changeset changelog.groovy::1410181719105-15::rvsz (generated)::(Checksum: 3:365527042d2437a24dae64170b83f1ad)
CREATE TABLE `intent_action` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(256) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(256) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `intent_actionPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-15', '2.0.5', '3:365527042d2437a24dae64170b83f1ad', 15);

--  Changeset changelog.groovy::1410181719105-16::rvsz (generated)::(Checksum: 3:7caa8271888d7b331581eb007be57633)
CREATE TABLE `intent_data_type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(256) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(256) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `intent_data_tPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-16', '2.0.5', '3:7caa8271888d7b331581eb007be57633', 16);

--  Changeset changelog.groovy::1410181719105-17::rvsz (generated)::(Checksum: 3:cff3f65d09133dba3925f79a95a7fdd5)
CREATE TABLE `interface_configuration` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `allow_truncate` bit NOT NULL, `auto_create_meta_data` bit NOT NULL, `default_large_icon_url` VARCHAR(2048) NULL, `default_small_icon_url` VARCHAR(2048) NULL, `delta_since_time_param` VARCHAR(64) NULL, `delta_static_parameters` VARCHAR(2048) NULL, `download_images` bit NOT NULL, `full_static_parameters` VARCHAR(2048) NULL, `loose_match` bit NOT NULL, `name` VARCHAR(256) NOT NULL, `query_date_format` VARCHAR(32) NULL, `response_date_format` VARCHAR(32) NULL, CONSTRAINT `interface_conPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-17', '2.0.5', '3:cff3f65d09133dba3925f79a95a7fdd5', 17);

--  Changeset changelog.groovy::1410181719105-18::rvsz (generated)::(Checksum: 3:656ef6835c8374c290ca788221b3a463)
CREATE TABLE `item_comment` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `rate` FLOAT NULL, `service_item_id` BIGINT NOT NULL, `text` VARCHAR(4000) NULL, CONSTRAINT `item_commentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-18', '2.0.5', '3:656ef6835c8374c290ca788221b3a463', 18);

--  Changeset changelog.groovy::1410181719105-19::rvsz (generated)::(Checksum: 3:b700c0fb68ed1e67cb011c8f9a3e81c7)
CREATE TABLE `modify_relationship_activity` (`id` BIGINT NOT NULL, CONSTRAINT `modify_relatiPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-19', '2.0.5', '3:b700c0fb68ed1e67cb011c8f9a3e81c7', 19);

--  Changeset changelog.groovy::1410181719105-20::rvsz (generated)::(Checksum: 3:568710cc27e6ff15f0595d529efe53ff)
CREATE TABLE `profile` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `avatar_id` BIGINT NULL, `bio` VARCHAR(1000) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `display_name` VARCHAR(256) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(256) NULL, `user_roles` VARCHAR(255) NULL, `username` VARCHAR(256) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `profilePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-20', '2.0.5', '3:568710cc27e6ff15f0595d529efe53ff', 20);

--  Changeset changelog.groovy::1410181719105-21::rvsz (generated)::(Checksum: 3:9177e8cf93f3b574433f3281d3673e8c)
CREATE TABLE `profile_user_data_map` (`user_data_map` BIGINT NULL, `user_data_map_idx` VARCHAR(255) NULL, `user_data_map_elt` longtext NOT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-21', '2.0.5', '3:9177e8cf93f3b574433f3281d3673e8c', 21);

--  Changeset changelog.groovy::1410181719105-22::rvsz (generated)::(Checksum: 3:68b34fdc60312d9ae718e899b7ed900a)
CREATE TABLE `rejection_activity` (`id` BIGINT NOT NULL, `rejection_listing_id` BIGINT NULL, CONSTRAINT `rejection_actPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-22', '2.0.5', '3:68b34fdc60312d9ae718e899b7ed900a', 22);

--  Changeset changelog.groovy::1410181719105-23::rvsz (generated)::(Checksum: 3:5dff13cffd0e02292154f45a2be3aa4f)
CREATE TABLE `rejection_justification` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `rejection_jusPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-23', '2.0.5', '3:5dff13cffd0e02292154f45a2be3aa4f', 23);

--  Changeset changelog.groovy::1410181719105-24::rvsz (generated)::(Checksum: 3:73999ab49978c811debcc63163528418)
CREATE TABLE `rejection_listing` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(2000) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `justification_id` BIGINT NULL, `service_item_id` BIGINT NOT NULL, CONSTRAINT `rejection_lisPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-24', '2.0.5', '3:73999ab49978c811debcc63163528418', 24);

--  Changeset changelog.groovy::1410181719105-25::rvsz (generated)::(Checksum: 3:35de2004bba9f2010a19fae71c5caa1c)
CREATE TABLE `relationship` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `owning_entity_id` BIGINT NOT NULL, `relationship_type` VARCHAR(255) NOT NULL, CONSTRAINT `relationshipPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-25', '2.0.5', '3:35de2004bba9f2010a19fae71c5caa1c', 25);

--  Changeset changelog.groovy::1410181719105-26::rvsz (generated)::(Checksum: 3:ccbc00586b719fb2cd9e95552f14a51e)
CREATE TABLE `relationship_activity_log` (`mod_rel_activity_id` BIGINT NOT NULL, `service_item_snapshot_id` BIGINT NULL, `items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-26', '2.0.5', '3:ccbc00586b719fb2cd9e95552f14a51e', 26);

--  Changeset changelog.groovy::1410181719105-27::rvsz (generated)::(Checksum: 3:3353ece6d39474face902dc7cb745ae5)
CREATE TABLE `relationship_service_item` (`relationship_related_items_id` BIGINT NULL, `service_item_id` BIGINT NULL, `related_items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-27', '2.0.5', '3:3353ece6d39474face902dc7cb745ae5', 27);

--  Changeset changelog.groovy::1410181719105-28::rvsz (generated)::(Checksum: 3:2fe6f76873fca5a11804f8f1b5c510e4)
CREATE TABLE `score_card_item` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(500) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image` VARCHAR(250) NULL, `question` VARCHAR(250) NOT NULL, `show_on_listing` bit NULL, CONSTRAINT `score_card_itPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-28', '2.0.5', '3:2fe6f76873fca5a11804f8f1b5c510e4', 28);

--  Changeset changelog.groovy::1410181719105-29::rvsz (generated)::(Checksum: 3:569f18e5b3ee6de4159e8e5832d60fbd)
CREATE TABLE `screenshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `large_image_url` VARCHAR(2083) NULL, `service_item_id` BIGINT NOT NULL, `small_image_url` VARCHAR(2083) NOT NULL, `ordinal` INT NULL, CONSTRAINT `screenshotPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-29', '2.0.5', '3:569f18e5b3ee6de4159e8e5832d60fbd', 29);

--  Changeset changelog.groovy::1410181719105-30::rvsz (generated)::(Checksum: 3:24f78a954228e628707a36e66d038fee)
CREATE TABLE `service_item` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `agency_id` BIGINT NULL, `approval_status` VARCHAR(11) NOT NULL, `approved_date` DATETIME NULL, `avg_rate` FLOAT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `dependencies` VARCHAR(1000) NULL, `description` VARCHAR(4000) NULL, `description_short` VARCHAR(150) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_large_url` VARCHAR(2083) NULL, `image_medium_url` VARCHAR(2083) NULL, `image_small_url` VARCHAR(2083) NULL, `image_xlarge_url` VARCHAR(2083) NULL, `install_url` VARCHAR(2083) NULL, `is_featured` bit NULL, `is_hidden` INT NOT NULL, `is_outside` bit NULL, `last_activity_id` BIGINT NULL, `launch_url` VARCHAR(2083) NULL, `opens_in_new_browser_tab` bit NOT NULL, `organization` VARCHAR(256) NULL, `release_date` DATETIME NULL, `requirements` VARCHAR(1000) NULL, `title` VARCHAR(256) NOT NULL, `total_comments` INT NOT NULL, `total_rate1` INT NULL, `total_rate2` INT NULL, `total_rate3` INT NULL, `total_rate4` INT NULL, `total_rate5` INT NULL, `total_votes` INT NOT NULL, `types_id` BIGINT NOT NULL, `uuid` VARCHAR(255) NOT NULL, `version_name` VARCHAR(256) NULL, `what_is_new` VARCHAR(250) NULL, CONSTRAINT `service_itemPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-30', '2.0.5', '3:24f78a954228e628707a36e66d038fee', 30);

--  Changeset changelog.groovy::1410181719105-31::rvsz (generated)::(Checksum: 3:df721953caa6b8f438fd7dc2b63f6fc7)
CREATE TABLE `service_item_activity` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action` VARCHAR(255) NOT NULL, `activity_date` DATETIME NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `service_item_id` BIGINT NOT NULL, `service_item_activities_idx` INT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-31', '2.0.5', '3:df721953caa6b8f438fd7dc2b63f6fc7', 31);

--  Changeset changelog.groovy::1410181719105-32::rvsz (generated)::(Checksum: 3:8b1dfcd6e47b92de2c867b3d52eaf24f)
CREATE TABLE `service_item_category` (`service_item_categories_id` BIGINT NULL, `category_id` BIGINT NULL, `categories_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-32', '2.0.5', '3:8b1dfcd6e47b92de2c867b3d52eaf24f', 32);

--  Changeset changelog.groovy::1410181719105-33::rvsz (generated)::(Checksum: 3:a16fda6903cd6797a6d1496735dab339)
CREATE TABLE `service_item_documentation_url` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `name` VARCHAR(255) NOT NULL, `service_item_id` BIGINT NOT NULL, `url` VARCHAR(2083) NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-33', '2.0.5', '3:a16fda6903cd6797a6d1496735dab339', 33);

--  Changeset changelog.groovy::1410181719105-34::rvsz (generated)::(Checksum: 3:81da42021cf40d5046b0d45387730d23)
CREATE TABLE `service_item_profile` (`service_item_owners_id` BIGINT NULL, `profile_id` BIGINT NULL, `owners_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-34', '2.0.5', '3:81da42021cf40d5046b0d45387730d23', 34);

--  Changeset changelog.groovy::1410181719105-35::rvsz (generated)::(Checksum: 3:a9daca8ada2682389896226df8e5295f)
CREATE TABLE `service_item_score_card_item` (`service_item_id` BIGINT NOT NULL, `score_card_item_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-35', '2.0.5', '3:a9daca8ada2682389896226df8e5295f', 35);

--  Changeset changelog.groovy::1410181719105-36::rvsz (generated)::(Checksum: 3:c3d11c80280b277df15391fb13b425c5)
CREATE TABLE `service_item_snapshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `service_item_id` BIGINT NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-36', '2.0.5', '3:c3d11c80280b277df15391fb13b425c5', 36);

--  Changeset changelog.groovy::1410181719105-37::rvsz (generated)::(Checksum: 3:8285959ed18a118af62cfab9724fcfa3)
CREATE TABLE `service_item_tag` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NOT NULL, `service_item_id` BIGINT NOT NULL, `tag_id` BIGINT NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-37', '2.0.5', '3:8285959ed18a118af62cfab9724fcfa3', 37);

--  Changeset changelog.groovy::1410181719105-38::rvsz (generated)::(Checksum: 3:b62d4c33b02092c509f954a549d1e55a)
CREATE TABLE `service_item_tags` (`service_item_id` BIGINT NULL, `tags_string` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-38', '2.0.5', '3:b62d4c33b02092c509f954a549d1e55a', 38);

--  Changeset changelog.groovy::1410181719105-39::rvsz (generated)::(Checksum: 3:cd9a3fa7b42e7cc522c0889767053875)
CREATE TABLE `service_item_tech_pocs` (`service_item_id` BIGINT NULL, `tech_poc` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-39', '2.0.5', '3:cd9a3fa7b42e7cc522c0889767053875', 39);

--  Changeset changelog.groovy::1410181719105-40::rvsz (generated)::(Checksum: 3:74935fc64670b3fb5ed627f58cfc1980)
CREATE TABLE `si_recommended_layouts` (`service_item_id` BIGINT NULL, `recommended_layout` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-40', '2.0.5', '3:74935fc64670b3fb5ed627f58cfc1980', 40);

--  Changeset changelog.groovy::1410181719105-41::rvsz (generated)::(Checksum: 3:45814e4253446757713edf56b8da0e6b)
CREATE TABLE `tag` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(16) NOT NULL, CONSTRAINT `tagPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-41', '2.0.5', '3:45814e4253446757713edf56b8da0e6b', 41);

--  Changeset changelog.groovy::1410181719105-42::rvsz (generated)::(Checksum: 3:19e17e607d75f85503dc1f06bf9a8911)
CREATE TABLE `types` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `has_icons` bit NOT NULL, `has_launch_url` bit NOT NULL, `image_id` BIGINT NULL, `is_permanent` bit NULL, `ozone_aware` bit NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `typesPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-42', '2.0.5', '3:19e17e607d75f85503dc1f06bf9a8911', 42);

--  Changeset changelog.groovy::1410181719105-43::rvsz (generated)::(Checksum: 3:642c260c7574ccc3903836a0d3b36f15)
CREATE TABLE `U_DOMAIN` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `username` VARCHAR(255) NOT NULL, CONSTRAINT `U_DOMAINPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-43', '2.0.5', '3:642c260c7574ccc3903836a0d3b36f15', 43);

--  Changeset changelog.groovy::1410181719105-44::rvsz (generated)::(Checksum: 3:815195668eea3910f62b0066af6b8236)
CREATE TABLE `u_domain_preferences` (`preferences` BIGINT NULL, `preferences_idx` VARCHAR(255) NULL, `preferences_elt` VARCHAR(255) NOT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-44', '2.0.5', '3:815195668eea3910f62b0066af6b8236', 44);

--  Changeset changelog.groovy::1410181719105-45::rvsz (generated)::(Checksum: 3:82c9d114ac37145fa4a52ba56f791b53)
CREATE TABLE `user_account` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `last_login` DATETIME NULL, `username` VARCHAR(250) NOT NULL, CONSTRAINT `user_accountPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1410181719105-45', '2.0.5', '3:82c9d114ac37145fa4a52ba56f791b53', 45);

--  Changeset changelog.groovy::1410181719105-141::rvsz (generated)::(Checksum: 3:3ef8e38d411fa3475e7716e12a35d1bf)
CREATE INDEX `FK97BAABEE7666C6D2` ON `U_DOMAIN`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-141', '2.0.5', '3:3ef8e38d411fa3475e7716e12a35d1bf', 46);

--  Changeset changelog.groovy::1410181719105-142::rvsz (generated)::(Checksum: 3:07c12da8960187d863742cca0007c561)
CREATE INDEX `FK97BAABEEE31CB353` ON `U_DOMAIN`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-142', '2.0.5', '3:07c12da8960187d863742cca0007c561', 47);

--  Changeset changelog.groovy::1410181719105-143::rvsz (generated)::(Checksum: 3:1d8d829f17c93a29e297aec596b28543)
CREATE INDEX `FKA6EB2C37666C6D2` ON `affiliated_marketplace`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-143', '2.0.5', '3:1d8d829f17c93a29e297aec596b28543', 48);

--  Changeset changelog.groovy::1410181719105-144::rvsz (generated)::(Checksum: 3:5c655bec643a153e1a7f44c0e4fdd048)
CREATE INDEX `FKA6EB2C3E31CB353` ON `affiliated_marketplace`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-144', '2.0.5', '3:5c655bec643a153e1a7f44c0e4fdd048', 49);

--  Changeset changelog.groovy::1410181719105-145::rvsz (generated)::(Checksum: 3:342abe96fa572cb5dc8e695160d2679c)
CREATE INDEX `FKA6EB2C3EA25263C` ON `affiliated_marketplace`(`icon_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-145', '2.0.5', '3:342abe96fa572cb5dc8e695160d2679c', 50);

--  Changeset changelog.groovy::1410181719105-146::rvsz (generated)::(Checksum: 3:6737c56d2d977a4fa0df3bfb9e8e3ba4)
CREATE INDEX `FKAB611C057666C6D2` ON `agency`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-146', '2.0.5', '3:6737c56d2d977a4fa0df3bfb9e8e3ba4', 51);

--  Changeset changelog.groovy::1410181719105-147::rvsz (generated)::(Checksum: 3:f95dceb464d93ea2e10653557b6c3bbd)
CREATE INDEX `FKAB611C05E31CB353` ON `agency`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-147', '2.0.5', '3:f95dceb464d93ea2e10653557b6c3bbd', 52);

--  Changeset changelog.groovy::1410181719105-148::rvsz (generated)::(Checksum: 3:43852ba0e12d319c7343ce74a55a77e1)
CREATE INDEX `FK44E0233F6530DF0D` ON `application_library_entry`(`owner_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-148', '2.0.5', '3:43852ba0e12d319c7343ce74a55a77e1', 53);

--  Changeset changelog.groovy::1410181719105-149::rvsz (generated)::(Checksum: 3:fc97139fe6e217c507678b9b460f648d)
CREATE INDEX `FK44E0233F7666C6D2` ON `application_library_entry`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-149', '2.0.5', '3:fc97139fe6e217c507678b9b460f648d', 54);

--  Changeset changelog.groovy::1410181719105-150::rvsz (generated)::(Checksum: 3:729b648114d7ac376b217d9c72168a1c)
CREATE INDEX `FK44E0233FC7E5C662` ON `application_library_entry`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-150', '2.0.5', '3:729b648114d7ac376b217d9c72168a1c', 55);

--  Changeset changelog.groovy::1410181719105-151::rvsz (generated)::(Checksum: 3:dbfac6862b5ebc26511bda26e69de1fd)
CREATE INDEX `FK44E0233FE31CB353` ON `application_library_entry`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-151', '2.0.5', '3:dbfac6862b5ebc26511bda26e69de1fd', 56);

--  Changeset changelog.groovy::1410181719105-152::rvsz (generated)::(Checksum: 3:580f266d61508b4e6b8ebd1c3ad113bf)
CREATE UNIQUE INDEX `unique_owner_id` ON `application_library_entry`(`service_item_id`, `folder`, `owner_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-152', '2.0.5', '3:580f266d61508b4e6b8ebd1c3ad113bf', 57);

--  Changeset changelog.groovy::1410181719105-153::rvsz (generated)::(Checksum: 3:978202bf4a76e175c9806b9c8902f3c5)
CREATE INDEX `FKAC32C1597666C6D2` ON `avatar`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-153', '2.0.5', '3:978202bf4a76e175c9806b9c8902f3c5', 58);

--  Changeset changelog.groovy::1410181719105-154::rvsz (generated)::(Checksum: 3:ff535f0d3ebf587b8ce45d8518171745)
CREATE INDEX `FKAC32C159E31CB353` ON `avatar`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-154', '2.0.5', '3:ff535f0d3ebf587b8ce45d8518171745', 59);

--  Changeset changelog.groovy::1410181719105-155::rvsz (generated)::(Checksum: 3:839c5edf03b5a4d78530bfe73c494a2b)
CREATE INDEX `FK302BCFE7666C6D2` ON `category`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-155', '2.0.5', '3:839c5edf03b5a4d78530bfe73c494a2b', 60);

--  Changeset changelog.groovy::1410181719105-156::rvsz (generated)::(Checksum: 3:abae98adf693d4c6e252c9635103b9ed)
CREATE INDEX `FK302BCFEE31CB353` ON `category`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-156', '2.0.5', '3:abae98adf693d4c6e252c9635103b9ed', 61);

--  Changeset changelog.groovy::1410181719105-157::rvsz (generated)::(Checksum: 3:3359dd41bfe502ec506a19423c399e72)
CREATE UNIQUE INDEX `uuid_uniq_1410181718938` ON `category`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-157', '2.0.5', '3:3359dd41bfe502ec506a19423c399e72', 62);

--  Changeset changelog.groovy::1410181719105-158::rvsz (generated)::(Checksum: 3:47d39028d2fa936ddfb522da6bd67a5d)
CREATE INDEX `FKB4467BC0855307BD` ON `change_detail`(`service_item_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-158', '2.0.5', '3:47d39028d2fa936ddfb522da6bd67a5d', 63);

--  Changeset changelog.groovy::1410181719105-159::rvsz (generated)::(Checksum: 3:5512d8b172d706ad23999f647e6422a6)
CREATE INDEX `FK38B724207666C6D2` ON `contact`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-159', '2.0.5', '3:5512d8b172d706ad23999f647e6422a6', 64);

--  Changeset changelog.groovy::1410181719105-160::rvsz (generated)::(Checksum: 3:e0cdb4ec69bba14939a8ce5e3947929b)
CREATE INDEX `FK38B72420BA3FC877` ON `contact`(`type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-160', '2.0.5', '3:e0cdb4ec69bba14939a8ce5e3947929b', 65);

--  Changeset changelog.groovy::1410181719105-161::rvsz (generated)::(Checksum: 3:c94ee2a89e758bc2395921cdca2fd603)
CREATE INDEX `FK38B72420C7E5C662` ON `contact`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-161', '2.0.5', '3:c94ee2a89e758bc2395921cdca2fd603', 66);

--  Changeset changelog.groovy::1410181719105-162::rvsz (generated)::(Checksum: 3:ab223b6396345140982e4218210dd2a6)
CREATE INDEX `FK38B72420E31CB353` ON `contact`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-162', '2.0.5', '3:ab223b6396345140982e4218210dd2a6', 67);

--  Changeset changelog.groovy::1410181719105-163::rvsz (generated)::(Checksum: 3:7bf0f61e79c783505df26e909504d64e)
CREATE INDEX `FK4C2BB7F97666C6D2` ON `contact_type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-163', '2.0.5', '3:7bf0f61e79c783505df26e909504d64e', 68);

--  Changeset changelog.groovy::1410181719105-164::rvsz (generated)::(Checksum: 3:95d15016c324a6f6a9e954804abcc950)
CREATE INDEX `FK4C2BB7F9E31CB353` ON `contact_type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-164', '2.0.5', '3:95d15016c324a6f6a9e954804abcc950', 69);

--  Changeset changelog.groovy::1410181719105-165::rvsz (generated)::(Checksum: 3:73fd810297dc5d201c0068991a229adf)
CREATE UNIQUE INDEX `title_uniq_1410181718943` ON `contact_type`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-165', '2.0.5', '3:73fd810297dc5d201c0068991a229adf', 70);

--  Changeset changelog.groovy::1410181719105-166::rvsz (generated)::(Checksum: 3:ee4410c10ef3b6175b9ec7ffd400090a)
CREATE INDEX `FK6F064E36553AF61A` ON `default_images`(`image_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-166', '2.0.5', '3:ee4410c10ef3b6175b9ec7ffd400090a', 71);

--  Changeset changelog.groovy::1410181719105-167::rvsz (generated)::(Checksum: 3:8a8976611132a8eec70e72aa8344e25a)
CREATE INDEX `FK6F064E367666C6D2` ON `default_images`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-167', '2.0.5', '3:8a8976611132a8eec70e72aa8344e25a', 72);

--  Changeset changelog.groovy::1410181719105-168::rvsz (generated)::(Checksum: 3:368c92bde52df7596c1884cc17eb9dbd)
CREATE INDEX `FK6F064E36E31CB353` ON `default_images`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-168', '2.0.5', '3:368c92bde52df7596c1884cc17eb9dbd', 73);

--  Changeset changelog.groovy::1410181719105-169::rvsz (generated)::(Checksum: 3:f9d7ed7c3bef3086b2046d9a79fdfc2c)
CREATE INDEX `FKE9C8098B20F4E01` ON `ext_profile`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-169', '2.0.5', '3:f9d7ed7c3bef3086b2046d9a79fdfc2c', 74);

--  Changeset changelog.groovy::1410181719105-170::rvsz (generated)::(Checksum: 3:4338f93ffd90839bbc8915e0799316f4)
CREATE UNIQUE INDEX `unique_external_id` ON `ext_profile`(`system_uri`, `external_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-170', '2.0.5', '3:4338f93ffd90839bbc8915e0799316f4', 75);

--  Changeset changelog.groovy::1410181719105-171::rvsz (generated)::(Checksum: 3:c20e3fcbf94b7ee34bafa868f5ff532e)
CREATE INDEX `FKB95A82787666C6D2` ON `images`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-171', '2.0.5', '3:c20e3fcbf94b7ee34bafa868f5ff532e', 76);

--  Changeset changelog.groovy::1410181719105-172::rvsz (generated)::(Checksum: 3:46dab07a3d1de65cbf5b2956e3a2ee01)
CREATE INDEX `FKB95A8278E31CB353` ON `images`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-172', '2.0.5', '3:46dab07a3d1de65cbf5b2956e3a2ee01', 77);

--  Changeset changelog.groovy::1410181719105-173::rvsz (generated)::(Checksum: 3:e475b5a5ca65790a54c912c5cd65a287)
CREATE INDEX `FK578EF9DF7666C6D2` ON `import_task`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-173', '2.0.5', '3:e475b5a5ca65790a54c912c5cd65a287', 78);

--  Changeset changelog.groovy::1410181719105-174::rvsz (generated)::(Checksum: 3:d773200555e5793c5e27a8c6fa8d54e0)
CREATE INDEX `FK578EF9DF919216CA` ON `import_task`(`last_run_result_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-174', '2.0.5', '3:d773200555e5793c5e27a8c6fa8d54e0', 79);

--  Changeset changelog.groovy::1410181719105-175::rvsz (generated)::(Checksum: 3:f6d85e029b667280369a6867789c5ccf)
CREATE INDEX `FK578EF9DFA31F8712` ON `import_task`(`interface_config_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-175', '2.0.5', '3:f6d85e029b667280369a6867789c5ccf', 80);

--  Changeset changelog.groovy::1410181719105-176::rvsz (generated)::(Checksum: 3:48d37681ca109e398516905127ed656f)
CREATE INDEX `FK578EF9DFE31CB353` ON `import_task`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-176', '2.0.5', '3:48d37681ca109e398516905127ed656f', 81);

--  Changeset changelog.groovy::1410181719105-177::rvsz (generated)::(Checksum: 3:6814386d47ee9e6fce55ee2e67eb24ba)
CREATE UNIQUE INDEX `name_uniq_1410181718953` ON `import_task`(`name`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-177', '2.0.5', '3:6814386d47ee9e6fce55ee2e67eb24ba', 82);

--  Changeset changelog.groovy::1410181719105-178::rvsz (generated)::(Checksum: 3:29ff752ab0cdf12650641dc76818f414)
CREATE INDEX `FK983AC27D11D7F882` ON `import_task_result`(`task_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-178', '2.0.5', '3:29ff752ab0cdf12650641dc76818f414', 83);

--  Changeset changelog.groovy::1410181719105-179::rvsz (generated)::(Checksum: 3:da14f99f470b8f0740917b2db6ee3ddb)
CREATE INDEX `FKB971369C283F938E` ON `intent`(`data_type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-179', '2.0.5', '3:da14f99f470b8f0740917b2db6ee3ddb', 84);

--  Changeset changelog.groovy::1410181719105-180::rvsz (generated)::(Checksum: 3:92fbb2f899780719b54ccc740c0cb0a0)
CREATE INDEX `FKB971369C7666C6D2` ON `intent`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-180', '2.0.5', '3:92fbb2f899780719b54ccc740c0cb0a0', 85);

--  Changeset changelog.groovy::1410181719105-181::rvsz (generated)::(Checksum: 3:d911a416412d1bb03fb469da8123979e)
CREATE INDEX `FKB971369CC7E5C662` ON `intent`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-181', '2.0.5', '3:d911a416412d1bb03fb469da8123979e', 86);

--  Changeset changelog.groovy::1410181719105-182::rvsz (generated)::(Checksum: 3:802af6e6aee90434f30ba25741c998d9)
CREATE INDEX `FKB971369CD8544299` ON `intent`(`action_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-182', '2.0.5', '3:802af6e6aee90434f30ba25741c998d9', 87);

--  Changeset changelog.groovy::1410181719105-183::rvsz (generated)::(Checksum: 3:6caefac8c527462edff8c85539c23fca)
CREATE INDEX `FKB971369CE31CB353` ON `intent`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-183', '2.0.5', '3:6caefac8c527462edff8c85539c23fca', 88);

--  Changeset changelog.groovy::1410181719105-184::rvsz (generated)::(Checksum: 3:408b3989feb3cebeda351838a7cb7934)
CREATE INDEX `FKEBCDD397666C6D2` ON `intent_action`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-184', '2.0.5', '3:408b3989feb3cebeda351838a7cb7934', 89);

--  Changeset changelog.groovy::1410181719105-185::rvsz (generated)::(Checksum: 3:32a922b22b3fc432ad57d3df047a93fe)
CREATE INDEX `FKEBCDD39E31CB353` ON `intent_action`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-185', '2.0.5', '3:32a922b22b3fc432ad57d3df047a93fe', 90);

--  Changeset changelog.groovy::1410181719105-186::rvsz (generated)::(Checksum: 3:4f63b12adef0a1222bee1fed2b0959f5)
CREATE UNIQUE INDEX `uuid_uniq_1410181718961` ON `intent_action`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-186', '2.0.5', '3:4f63b12adef0a1222bee1fed2b0959f5', 91);

--  Changeset changelog.groovy::1410181719105-187::rvsz (generated)::(Checksum: 3:d3e51812e5a2b6c63f5a6eee57ac3903)
CREATE INDEX `FKEADB30CC7666C6D2` ON `intent_data_type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-187', '2.0.5', '3:d3e51812e5a2b6c63f5a6eee57ac3903', 92);

--  Changeset changelog.groovy::1410181719105-188::rvsz (generated)::(Checksum: 3:e34567d0543543393c7c10ac62c5e3df)
CREATE INDEX `FKEADB30CCE31CB353` ON `intent_data_type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-188', '2.0.5', '3:e34567d0543543393c7c10ac62c5e3df', 93);

--  Changeset changelog.groovy::1410181719105-189::rvsz (generated)::(Checksum: 3:f228a02624202431516983ac43dd9f4a)
CREATE UNIQUE INDEX `uuid_uniq_1410181718963` ON `intent_data_type`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-189', '2.0.5', '3:f228a02624202431516983ac43dd9f4a', 94);

--  Changeset changelog.groovy::1410181719105-190::rvsz (generated)::(Checksum: 3:746e27fa81fd626ea797dc77b328d7bc)
CREATE INDEX `FKE6D04D335A032135` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-190', '2.0.5', '3:746e27fa81fd626ea797dc77b328d7bc', 95);

--  Changeset changelog.groovy::1410181719105-191::rvsz (generated)::(Checksum: 3:1b1fd7174764d6af9ff51dbfbd268461)
CREATE INDEX `FKE6D04D337666C6D2` ON `item_comment`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-191', '2.0.5', '3:1b1fd7174764d6af9ff51dbfbd268461', 96);

--  Changeset changelog.groovy::1410181719105-192::rvsz (generated)::(Checksum: 3:5e7c7f7f791d99b2ec4f4b1d602ddc9d)
CREATE INDEX `FKE6D04D33C7E5C662` ON `item_comment`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-192', '2.0.5', '3:5e7c7f7f791d99b2ec4f4b1d602ddc9d', 97);

--  Changeset changelog.groovy::1410181719105-193::rvsz (generated)::(Checksum: 3:d5b9eff22304b8c7744e69c46394e893)
CREATE INDEX `FKE6D04D33E31CB353` ON `item_comment`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-193', '2.0.5', '3:d5b9eff22304b8c7744e69c46394e893', 98);

--  Changeset changelog.groovy::1410181719105-194::rvsz (generated)::(Checksum: 3:53e54435435f21a79bf181d81074de52)
CREATE INDEX `itm_cmnt_author_id_idx` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-194', '2.0.5', '3:53e54435435f21a79bf181d81074de52', 99);

--  Changeset changelog.groovy::1410181719105-195::rvsz (generated)::(Checksum: 3:4606fad8fc3f6b329467524f6fa00df7)
CREATE INDEX `itm_cmnt_svc_item_id_idx` ON `item_comment`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-195', '2.0.5', '3:4606fad8fc3f6b329467524f6fa00df7', 100);

--  Changeset changelog.groovy::1410181719105-196::rvsz (generated)::(Checksum: 3:3b17dd5dad914166672e096855ce8323)
CREATE INDEX `FKE68D3F71C359936F` ON `modify_relationship_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-196', '2.0.5', '3:3b17dd5dad914166672e096855ce8323', 101);

--  Changeset changelog.groovy::1410181719105-197::rvsz (generated)::(Checksum: 3:824416833084575baab72152689bcf08)
CREATE INDEX `FKED8E89A961C3343D` ON `profile`(`avatar_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-197', '2.0.5', '3:824416833084575baab72152689bcf08', 102);

--  Changeset changelog.groovy::1410181719105-198::rvsz (generated)::(Checksum: 3:5c87cefb070afe5245df49edcdf6d6bc)
CREATE INDEX `FKED8E89A97666C6D2` ON `profile`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-198', '2.0.5', '3:5c87cefb070afe5245df49edcdf6d6bc', 103);

--  Changeset changelog.groovy::1410181719105-199::rvsz (generated)::(Checksum: 3:0b1b62581a385869ec370e81caf41d45)
CREATE INDEX `FKED8E89A9E31CB353` ON `profile`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-199', '2.0.5', '3:0b1b62581a385869ec370e81caf41d45', 104);

--  Changeset changelog.groovy::1410181719105-200::rvsz (generated)::(Checksum: 3:3edf7c6ede18477fffa210606de12beb)
CREATE UNIQUE INDEX `username_uniq_1410181718973` ON `profile`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-200', '2.0.5', '3:3edf7c6ede18477fffa210606de12beb', 105);

--  Changeset changelog.groovy::1410181719105-201::rvsz (generated)::(Checksum: 3:f43c8c30aed217b97888e0748014e1dc)
CREATE UNIQUE INDEX `uuid_uniq_1410181718973` ON `profile`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-201', '2.0.5', '3:f43c8c30aed217b97888e0748014e1dc', 106);

--  Changeset changelog.groovy::1410181719105-202::rvsz (generated)::(Checksum: 3:cca6c45c54b91151bc21e28f8459e6b5)
CREATE INDEX `FKF35C128582548A4A` ON `rejection_activity`(`rejection_listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-202', '2.0.5', '3:cca6c45c54b91151bc21e28f8459e6b5', 107);

--  Changeset changelog.groovy::1410181719105-203::rvsz (generated)::(Checksum: 3:81e04eaf534d41090afd6f3e5f333ba6)
CREATE INDEX `FKF35C1285C359936F` ON `rejection_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-203', '2.0.5', '3:81e04eaf534d41090afd6f3e5f333ba6', 108);

--  Changeset changelog.groovy::1410181719105-204::rvsz (generated)::(Checksum: 3:83bf85c9a6c11a66907396db59b6627c)
CREATE INDEX `FK12B0A53C7666C6D2` ON `rejection_justification`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-204', '2.0.5', '3:83bf85c9a6c11a66907396db59b6627c', 109);

--  Changeset changelog.groovy::1410181719105-205::rvsz (generated)::(Checksum: 3:7fbdaa45ba2134fba5cf706566f0ddae)
CREATE INDEX `FK12B0A53CE31CB353` ON `rejection_justification`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-205', '2.0.5', '3:7fbdaa45ba2134fba5cf706566f0ddae', 110);

--  Changeset changelog.groovy::1410181719105-206::rvsz (generated)::(Checksum: 3:ebe7a93726788a3caaf908927e019a5b)
CREATE INDEX `FK3F2BD44E19CEB614` ON `rejection_listing`(`justification_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-206', '2.0.5', '3:ebe7a93726788a3caaf908927e019a5b', 111);

--  Changeset changelog.groovy::1410181719105-207::rvsz (generated)::(Checksum: 3:66b6585c51649bacba538f21c706a430)
CREATE INDEX `FK3F2BD44E5A032135` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-207', '2.0.5', '3:66b6585c51649bacba538f21c706a430', 112);

--  Changeset changelog.groovy::1410181719105-208::rvsz (generated)::(Checksum: 3:d1f5b33deb169eb9fb0458e7e8b64541)
CREATE INDEX `FK3F2BD44E7666C6D2` ON `rejection_listing`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-208', '2.0.5', '3:d1f5b33deb169eb9fb0458e7e8b64541', 113);

--  Changeset changelog.groovy::1410181719105-209::rvsz (generated)::(Checksum: 3:8a6952f66b99f36f0c78e74b3f399f60)
CREATE INDEX `FK3F2BD44EC7E5C662` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-209', '2.0.5', '3:8a6952f66b99f36f0c78e74b3f399f60', 114);

--  Changeset changelog.groovy::1410181719105-210::rvsz (generated)::(Checksum: 3:3ff4107bb95921b20fdbf01b1089ce2e)
CREATE INDEX `FK3F2BD44EE31CB353` ON `rejection_listing`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-210', '2.0.5', '3:3ff4107bb95921b20fdbf01b1089ce2e', 115);

--  Changeset changelog.groovy::1410181719105-211::rvsz (generated)::(Checksum: 3:43678308dc3a992c28f53b4efeb30268)
CREATE INDEX `rej_lst_author_id_idx` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-211', '2.0.5', '3:43678308dc3a992c28f53b4efeb30268', 116);

--  Changeset changelog.groovy::1410181719105-212::rvsz (generated)::(Checksum: 3:185f7cfc5e4834a552850a563be01129)
CREATE INDEX `rej_lst_svc_item_id_idx` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-212', '2.0.5', '3:185f7cfc5e4834a552850a563be01129', 117);

--  Changeset changelog.groovy::1410181719105-213::rvsz (generated)::(Checksum: 3:e531cf4217a675f3d14c4e90f894861c)
CREATE INDEX `FKF06476389D70DD39` ON `relationship`(`owning_entity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-213', '2.0.5', '3:e531cf4217a675f3d14c4e90f894861c', 118);

--  Changeset changelog.groovy::1410181719105-214::rvsz (generated)::(Checksum: 3:1faa9525346fa580489e9fd365af971c)
CREATE INDEX `FK594974BB25A20F9D` ON `relationship_activity_log`(`service_item_snapshot_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-214', '2.0.5', '3:1faa9525346fa580489e9fd365af971c', 119);

--  Changeset changelog.groovy::1410181719105-215::rvsz (generated)::(Checksum: 3:eec26c4329ec72cbffdd562127545f6e)
CREATE INDEX `FKDA02504C7E5C662` ON `relationship_service_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-215', '2.0.5', '3:eec26c4329ec72cbffdd562127545f6e', 120);

--  Changeset changelog.groovy::1410181719105-216::rvsz (generated)::(Checksum: 3:17c02086fe38b487303c08354f695f76)
CREATE INDEX `FKE51CCD757666C6D2` ON `score_card_item`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-216', '2.0.5', '3:17c02086fe38b487303c08354f695f76', 121);

--  Changeset changelog.groovy::1410181719105-217::rvsz (generated)::(Checksum: 3:cacaa1fa165b5dc021388e8e5e10cc27)
CREATE INDEX `FKE51CCD75E31CB353` ON `score_card_item`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-217', '2.0.5', '3:cacaa1fa165b5dc021388e8e5e10cc27', 122);

--  Changeset changelog.groovy::1410181719105-218::rvsz (generated)::(Checksum: 3:1aba62ac454620082692f1eaa640f99f)
CREATE INDEX `FKE72D85667666C6D2` ON `screenshot`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-218', '2.0.5', '3:1aba62ac454620082692f1eaa640f99f', 123);

--  Changeset changelog.groovy::1410181719105-219::rvsz (generated)::(Checksum: 3:2cc546119189c2df9dde5afff248114d)
CREATE INDEX `FKE72D8566C7E5C662` ON `screenshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-219', '2.0.5', '3:2cc546119189c2df9dde5afff248114d', 124);

--  Changeset changelog.groovy::1410181719105-220::rvsz (generated)::(Checksum: 3:07741cdcf1099bf19899e2737d826d46)
CREATE INDEX `FKE72D8566E31CB353` ON `screenshot`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-220', '2.0.5', '3:07741cdcf1099bf19899e2737d826d46', 125);

--  Changeset changelog.groovy::1410181719105-221::rvsz (generated)::(Checksum: 3:d15412c9f28d673fc8d213e522b6cdfb)
CREATE INDEX `FK1571565D143B24BD` ON `service_item`(`agency_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-221', '2.0.5', '3:d15412c9f28d673fc8d213e522b6cdfb', 126);

--  Changeset changelog.groovy::1410181719105-222::rvsz (generated)::(Checksum: 3:b5af36144e5852c582747a2fcad614ca)
CREATE INDEX `FK1571565D2746B676` ON `service_item`(`last_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-222', '2.0.5', '3:b5af36144e5852c582747a2fcad614ca', 127);

--  Changeset changelog.groovy::1410181719105-223::rvsz (generated)::(Checksum: 3:5b2e89bfe1d7c1e1b95b7ff49f9d53e3)
CREATE INDEX `FK1571565D6928D597` ON `service_item`(`types_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-223', '2.0.5', '3:5b2e89bfe1d7c1e1b95b7ff49f9d53e3', 128);

--  Changeset changelog.groovy::1410181719105-224::rvsz (generated)::(Checksum: 3:22143e9523ef163f696b8b0d6715e928)
CREATE INDEX `FK1571565D7666C6D2` ON `service_item`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-224', '2.0.5', '3:22143e9523ef163f696b8b0d6715e928', 129);

--  Changeset changelog.groovy::1410181719105-225::rvsz (generated)::(Checksum: 3:a689381710b81e66e508d4431066249e)
CREATE INDEX `FK1571565DE31CB353` ON `service_item`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-225', '2.0.5', '3:a689381710b81e66e508d4431066249e', 130);

--  Changeset changelog.groovy::1410181719105-226::rvsz (generated)::(Checksum: 3:6004d165f74d01f95d179c70bfdf4da9)
CREATE INDEX `FK870EA6B15A032135` ON `service_item_activity`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-226', '2.0.5', '3:6004d165f74d01f95d179c70bfdf4da9', 131);

--  Changeset changelog.groovy::1410181719105-227::rvsz (generated)::(Checksum: 3:1f03b1ee01724c9a3fe8a8ff2830b510)
CREATE INDEX `FK870EA6B17666C6D2` ON `service_item_activity`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-227', '2.0.5', '3:1f03b1ee01724c9a3fe8a8ff2830b510', 132);

--  Changeset changelog.groovy::1410181719105-228::rvsz (generated)::(Checksum: 3:bdce4184a5244cd4570fcb5d3ce73a89)
CREATE INDEX `FK870EA6B1C7E5C662` ON `service_item_activity`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-228', '2.0.5', '3:bdce4184a5244cd4570fcb5d3ce73a89', 133);

--  Changeset changelog.groovy::1410181719105-229::rvsz (generated)::(Checksum: 3:dc06d43ca4f59b935996549e400ca07e)
CREATE INDEX `FK870EA6B1E31CB353` ON `service_item_activity`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-229', '2.0.5', '3:dc06d43ca4f59b935996549e400ca07e', 134);

--  Changeset changelog.groovy::1410181719105-230::rvsz (generated)::(Checksum: 3:ada5f8ad85b60287a404e1176b07500d)
CREATE INDEX `svc_item_act_svc_item_id_idx` ON `service_item_activity`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-230', '2.0.5', '3:ada5f8ad85b60287a404e1176b07500d', 135);

--  Changeset changelog.groovy::1410181719105-231::rvsz (generated)::(Checksum: 3:a2ca461c41d1b5693ab2ef4b2094f123)
CREATE INDEX `FKECC570A0DA41995D` ON `service_item_category`(`category_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-231', '2.0.5', '3:a2ca461c41d1b5693ab2ef4b2094f123', 136);

--  Changeset changelog.groovy::1410181719105-232::rvsz (generated)::(Checksum: 3:e0b3adf38923675bede0ea55f9c7db80)
CREATE INDEX `svc_item_cat_id_idx` ON `service_item_category`(`service_item_categories_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-232', '2.0.5', '3:e0b3adf38923675bede0ea55f9c7db80', 137);

--  Changeset changelog.groovy::1410181719105-233::rvsz (generated)::(Checksum: 3:ec179899b5e9feb38497778d3cda2843)
CREATE INDEX `FK24572D08C7E5C662` ON `service_item_documentation_url`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-233', '2.0.5', '3:ec179899b5e9feb38497778d3cda2843', 138);

--  Changeset changelog.groovy::1410181719105-234::rvsz (generated)::(Checksum: 3:388cccadd42e1ecc564a22f1fa17cb62)
CREATE INDEX `FK68B5D9C7C0565C57` ON `service_item_profile`(`profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-234', '2.0.5', '3:388cccadd42e1ecc564a22f1fa17cb62', 139);

--  Changeset changelog.groovy::1410181719105-235::rvsz (generated)::(Checksum: 3:ea1926e5c79b5a033cffde87f8aa26ff)
CREATE INDEX `FKBF91F93C7E5C662` ON `service_item_score_card_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-235', '2.0.5', '3:ea1926e5c79b5a033cffde87f8aa26ff', 140);

--  Changeset changelog.groovy::1410181719105-236::rvsz (generated)::(Checksum: 3:be4de13c1852275e6fff82ba79a8dd73)
CREATE INDEX `FKBF91F93EF469C97` ON `service_item_score_card_item`(`score_card_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-236', '2.0.5', '3:be4de13c1852275e6fff82ba79a8dd73', 141);

--  Changeset changelog.groovy::1410181719105-237::rvsz (generated)::(Checksum: 3:141e9c5ecb54e8040b6ec121228d240f)
CREATE INDEX `FKFABD8966C7E5C662` ON `service_item_snapshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-237', '2.0.5', '3:141e9c5ecb54e8040b6ec121228d240f', 142);

--  Changeset changelog.groovy::1410181719105-238::rvsz (generated)::(Checksum: 3:a8f6191ffd749f20bebf9ad01e772a2a)
CREATE INDEX `FKB621CEB87666C6D2` ON `service_item_tag`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-238', '2.0.5', '3:a8f6191ffd749f20bebf9ad01e772a2a', 143);

--  Changeset changelog.groovy::1410181719105-239::rvsz (generated)::(Checksum: 3:fc4ea713c366d3ccb6ed9caad9277cff)
CREATE INDEX `FKB621CEB8C7E5C662` ON `service_item_tag`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-239', '2.0.5', '3:fc4ea713c366d3ccb6ed9caad9277cff', 144);

--  Changeset changelog.groovy::1410181719105-240::rvsz (generated)::(Checksum: 3:4ecb4043bf1621226f26f0211c0e1d57)
CREATE INDEX `FKB621CEB8EACAF137` ON `service_item_tag`(`tag_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-240', '2.0.5', '3:4ecb4043bf1621226f26f0211c0e1d57', 145);

--  Changeset changelog.groovy::1410181719105-241::rvsz (generated)::(Checksum: 3:a2bf898fbf28dd52154b91af99ce8816)
CREATE INDEX `service_item_tag_si_idx` ON `service_item_tag`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-241', '2.0.5', '3:a2bf898fbf28dd52154b91af99ce8816', 146);

--  Changeset changelog.groovy::1410181719105-242::rvsz (generated)::(Checksum: 3:9f8b05253fb908abeb7b99d7e9ccbd70)
CREATE INDEX `service_item_tag_tag_idx` ON `service_item_tag`(`tag_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-242', '2.0.5', '3:9f8b05253fb908abeb7b99d7e9ccbd70', 147);

--  Changeset changelog.groovy::1410181719105-243::rvsz (generated)::(Checksum: 3:626d6d510df5a61ab65cdbacccb51282)
CREATE INDEX `FKE1808BBC7E5C662` ON `service_item_tags`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-243', '2.0.5', '3:626d6d510df5a61ab65cdbacccb51282', 148);

--  Changeset changelog.groovy::1410181719105-244::rvsz (generated)::(Checksum: 3:ac8d0902b5ea1d7ad9d4ad101349ca9f)
CREATE INDEX `FKA55CFB56C7E5C662` ON `service_item_tech_pocs`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-244', '2.0.5', '3:ac8d0902b5ea1d7ad9d4ad101349ca9f', 149);

--  Changeset changelog.groovy::1410181719105-245::rvsz (generated)::(Checksum: 3:49086205c9b6649cdc38a5fd839448ef)
CREATE INDEX `FK863C793CC7E5C662` ON `si_recommended_layouts`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-245', '2.0.5', '3:49086205c9b6649cdc38a5fd839448ef', 150);

--  Changeset changelog.groovy::1410181719105-246::rvsz (generated)::(Checksum: 3:a3cba4f130b80b40bedb769eaa4ee13c)
CREATE INDEX `FK1BF9A7666C6D2` ON `tag`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-246', '2.0.5', '3:a3cba4f130b80b40bedb769eaa4ee13c', 151);

--  Changeset changelog.groovy::1410181719105-247::rvsz (generated)::(Checksum: 3:f5b5e5ee65a5550134c610491eea06ba)
CREATE INDEX `FK1BF9AE31CB353` ON `tag`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-247', '2.0.5', '3:f5b5e5ee65a5550134c610491eea06ba', 152);

--  Changeset changelog.groovy::1410181719105-248::rvsz (generated)::(Checksum: 3:d0c633c5b1178d842b342f18069da043)
CREATE INDEX `tag_title_idx` ON `tag`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-248', '2.0.5', '3:d0c633c5b1178d842b342f18069da043', 153);

--  Changeset changelog.groovy::1410181719105-249::rvsz (generated)::(Checksum: 3:709665e6e4014859030edbb911f7051a)
CREATE INDEX `FK69B5879553AF61A` ON `types`(`image_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-249', '2.0.5', '3:709665e6e4014859030edbb911f7051a', 154);

--  Changeset changelog.groovy::1410181719105-250::rvsz (generated)::(Checksum: 3:a5f7dd6bfb32a1292256946a54571082)
CREATE INDEX `FK69B58797666C6D2` ON `types`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-250', '2.0.5', '3:a5f7dd6bfb32a1292256946a54571082', 155);

--  Changeset changelog.groovy::1410181719105-251::rvsz (generated)::(Checksum: 3:9681cebbda3cad5a4da8675b975b01b5)
CREATE INDEX `FK69B5879E31CB353` ON `types`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-251', '2.0.5', '3:9681cebbda3cad5a4da8675b975b01b5', 156);

--  Changeset changelog.groovy::1410181719105-252::rvsz (generated)::(Checksum: 3:5f278fde412e104ff7485510f74222ff)
CREATE UNIQUE INDEX `uuid_uniq_1410181719002` ON `types`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-252', '2.0.5', '3:5f278fde412e104ff7485510f74222ff', 157);

--  Changeset changelog.groovy::1410181719105-253::rvsz (generated)::(Checksum: 3:a1f8d35041be8b00003a053512132ff3)
CREATE INDEX `FK14C321B97666C6D2` ON `user_account`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-253', '2.0.5', '3:a1f8d35041be8b00003a053512132ff3', 158);

--  Changeset changelog.groovy::1410181719105-254::rvsz (generated)::(Checksum: 3:4da22521c3b93264bf9fb2054d633016)
CREATE INDEX `FK14C321B9E31CB353` ON `user_account`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-254', '2.0.5', '3:4da22521c3b93264bf9fb2054d633016', 159);

--  Changeset changelog.groovy::1410181719105-255::rvsz (generated)::(Checksum: 3:ecfb45e0204c14fdd148338a42d4f76e)
CREATE UNIQUE INDEX `username_uniq_1410181719004` ON `user_account`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1410181719105-255', '2.0.5', '3:ecfb45e0204c14fdd148338a42d4f76e', 160);

--  Changeset changelog.groovy::1410181719105-46::rvsz (generated)::(Checksum: 3:012c519b42c92bf84f67dd2a9e3cbf61)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C37666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-46', '2.0.5', '3:012c519b42c92bf84f67dd2a9e3cbf61', 161);

--  Changeset changelog.groovy::1410181719105-47::rvsz (generated)::(Checksum: 3:fd91bd2d780f57b6090c3fca7918e9f1)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C3E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-47', '2.0.5', '3:fd91bd2d780f57b6090c3fca7918e9f1', 162);

--  Changeset changelog.groovy::1410181719105-48::rvsz (generated)::(Checksum: 3:d0718262545ecb537e4494bbe1692c0e)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C3EA25263C` FOREIGN KEY (`icon_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-48', '2.0.5', '3:d0718262545ecb537e4494bbe1692c0e', 163);

--  Changeset changelog.groovy::1410181719105-49::rvsz (generated)::(Checksum: 3:c0e9894b976dceb09fc43de299f992a7)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C057666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-49', '2.0.5', '3:c0e9894b976dceb09fc43de299f992a7', 164);

--  Changeset changelog.groovy::1410181719105-50::rvsz (generated)::(Checksum: 3:34b4d2a4851521abae8cfaa2fe8f4b9a)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C05E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-50', '2.0.5', '3:34b4d2a4851521abae8cfaa2fe8f4b9a', 165);

--  Changeset changelog.groovy::1410181719105-51::rvsz (generated)::(Checksum: 3:2d69ea1f6f5ec06c1cec4b7e0cac0c5e)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-51', '2.0.5', '3:2d69ea1f6f5ec06c1cec4b7e0cac0c5e', 166);

--  Changeset changelog.groovy::1410181719105-52::rvsz (generated)::(Checksum: 3:9136a33397c8aed3476e08179ebdc62e)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233FE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-52', '2.0.5', '3:9136a33397c8aed3476e08179ebdc62e', 167);

--  Changeset changelog.groovy::1410181719105-53::rvsz (generated)::(Checksum: 3:5f80a5c2d662b3519c257c5b47e9eab2)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F6530DF0D` FOREIGN KEY (`owner_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-53', '2.0.5', '3:5f80a5c2d662b3519c257c5b47e9eab2', 168);

--  Changeset changelog.groovy::1410181719105-54::rvsz (generated)::(Checksum: 3:212e46190588a8f6acabfd35c30965a6)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233FC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-54', '2.0.5', '3:212e46190588a8f6acabfd35c30965a6', 169);

--  Changeset changelog.groovy::1410181719105-55::rvsz (generated)::(Checksum: 3:f5966e29d1ddc655bbaf907c82428247)
ALTER TABLE `avatar` ADD CONSTRAINT `FKAC32C1597666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-55', '2.0.5', '3:f5966e29d1ddc655bbaf907c82428247', 170);

--  Changeset changelog.groovy::1410181719105-56::rvsz (generated)::(Checksum: 3:397fa2359ca7216e2ae847451e70b0a6)
ALTER TABLE `avatar` ADD CONSTRAINT `FKAC32C159E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-56', '2.0.5', '3:397fa2359ca7216e2ae847451e70b0a6', 171);

--  Changeset changelog.groovy::1410181719105-57::rvsz (generated)::(Checksum: 3:0919cac3b93d89e27f450a3f42822f00)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFE7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-57', '2.0.5', '3:0919cac3b93d89e27f450a3f42822f00', 172);

--  Changeset changelog.groovy::1410181719105-58::rvsz (generated)::(Checksum: 3:7f041c5ab327f9e6925e7d44efe00d89)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFEE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-58', '2.0.5', '3:7f041c5ab327f9e6925e7d44efe00d89', 173);

--  Changeset changelog.groovy::1410181719105-59::rvsz (generated)::(Checksum: 3:ce8d88a6a0824410fe1e2e2951f36f9f)
ALTER TABLE `change_detail` ADD CONSTRAINT `FKB4467BC0855307BD` FOREIGN KEY (`service_item_activity_id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-59', '2.0.5', '3:ce8d88a6a0824410fe1e2e2951f36f9f', 174);

--  Changeset changelog.groovy::1410181719105-60::rvsz (generated)::(Checksum: 3:f0906f0eb39b2202ecb84c2bca907d03)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B724207666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-60', '2.0.5', '3:f0906f0eb39b2202ecb84c2bca907d03', 175);

--  Changeset changelog.groovy::1410181719105-61::rvsz (generated)::(Checksum: 3:9ee958dc651da79e1462035ba353b6e0)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-61', '2.0.5', '3:9ee958dc651da79e1462035ba353b6e0', 176);

--  Changeset changelog.groovy::1410181719105-62::rvsz (generated)::(Checksum: 3:71e66a1509610c829680c54601e03968)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-62', '2.0.5', '3:71e66a1509610c829680c54601e03968', 177);

--  Changeset changelog.groovy::1410181719105-63::rvsz (generated)::(Checksum: 3:432fc8bd066d7de72903ae07ec4536f8)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420BA3FC877` FOREIGN KEY (`type_id`) REFERENCES `contact_type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-63', '2.0.5', '3:432fc8bd066d7de72903ae07ec4536f8', 178);

--  Changeset changelog.groovy::1410181719105-64::rvsz (generated)::(Checksum: 3:789dc9c339f5d808bbdaf6d72db916fe)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-64', '2.0.5', '3:789dc9c339f5d808bbdaf6d72db916fe', 179);

--  Changeset changelog.groovy::1410181719105-65::rvsz (generated)::(Checksum: 3:3225c8cbdce1d11887d89fd757132306)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-65', '2.0.5', '3:3225c8cbdce1d11887d89fd757132306', 180);

--  Changeset changelog.groovy::1410181719105-66::rvsz (generated)::(Checksum: 3:f388279add0481baf5b16aae01eb7caf)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E367666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-66', '2.0.5', '3:f388279add0481baf5b16aae01eb7caf', 181);

--  Changeset changelog.groovy::1410181719105-67::rvsz (generated)::(Checksum: 3:81a126fb14af66e94b9a936a519c746a)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E36E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-67', '2.0.5', '3:81a126fb14af66e94b9a936a519c746a', 182);

--  Changeset changelog.groovy::1410181719105-68::rvsz (generated)::(Checksum: 3:b6d10278dcdd65a228aa56ac8eb98130)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E36553AF61A` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-68', '2.0.5', '3:b6d10278dcdd65a228aa56ac8eb98130', 183);

--  Changeset changelog.groovy::1410181719105-69::rvsz (generated)::(Checksum: 3:c39b74423678854769207d31634f0862)
ALTER TABLE `ext_profile` ADD CONSTRAINT `FKE9C8098B20F4E01` FOREIGN KEY (`id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-69', '2.0.5', '3:c39b74423678854769207d31634f0862', 184);

--  Changeset changelog.groovy::1410181719105-70::rvsz (generated)::(Checksum: 3:ee236b44ab2604a6b9e4dab9d16f6776)
ALTER TABLE `images` ADD CONSTRAINT `FKB95A82787666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-70', '2.0.5', '3:ee236b44ab2604a6b9e4dab9d16f6776', 185);

--  Changeset changelog.groovy::1410181719105-71::rvsz (generated)::(Checksum: 3:d71a96f57177f3c83d8443003f0762d3)
ALTER TABLE `images` ADD CONSTRAINT `FKB95A8278E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-71', '2.0.5', '3:d71a96f57177f3c83d8443003f0762d3', 186);

--  Changeset changelog.groovy::1410181719105-72::rvsz (generated)::(Checksum: 3:ab74cd9c2a3eb6f9202405f2a97c77f3)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DF7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-72', '2.0.5', '3:ab74cd9c2a3eb6f9202405f2a97c77f3', 187);

--  Changeset changelog.groovy::1410181719105-73::rvsz (generated)::(Checksum: 3:d4c54fc15156503d313674ee383964d6)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DFE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-73', '2.0.5', '3:d4c54fc15156503d313674ee383964d6', 188);

--  Changeset changelog.groovy::1410181719105-74::rvsz (generated)::(Checksum: 3:d587bb9a0b5867061074afb55d11e6e4)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DFA31F8712` FOREIGN KEY (`interface_config_id`) REFERENCES `interface_configuration` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-74', '2.0.5', '3:d587bb9a0b5867061074afb55d11e6e4', 189);

--  Changeset changelog.groovy::1410181719105-75::rvsz (generated)::(Checksum: 3:5c0e970a1863f996de204b720c49c413)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DF919216CA` FOREIGN KEY (`last_run_result_id`) REFERENCES `import_task_result` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-75', '2.0.5', '3:5c0e970a1863f996de204b720c49c413', 190);

--  Changeset changelog.groovy::1410181719105-76::rvsz (generated)::(Checksum: 3:a053bceea35c1cbd0f4a17b486466d55)
ALTER TABLE `import_task_result` ADD CONSTRAINT `FK983AC27D11D7F882` FOREIGN KEY (`task_id`) REFERENCES `import_task` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-76', '2.0.5', '3:a053bceea35c1cbd0f4a17b486466d55', 191);

--  Changeset changelog.groovy::1410181719105-77::rvsz (generated)::(Checksum: 3:46fae3ba2e33eaa68952b0e55e848fe3)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CD8544299` FOREIGN KEY (`action_id`) REFERENCES `intent_action` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-77', '2.0.5', '3:46fae3ba2e33eaa68952b0e55e848fe3', 192);

--  Changeset changelog.groovy::1410181719105-78::rvsz (generated)::(Checksum: 3:fde98c8a0d1e864c6a82ad6e6af9795e)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-78', '2.0.5', '3:fde98c8a0d1e864c6a82ad6e6af9795e', 193);

--  Changeset changelog.groovy::1410181719105-79::rvsz (generated)::(Checksum: 3:fdbc8c4972d0f9c18602cc6757e1baee)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369C283F938E` FOREIGN KEY (`data_type_id`) REFERENCES `intent_data_type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-79', '2.0.5', '3:fdbc8c4972d0f9c18602cc6757e1baee', 194);

--  Changeset changelog.groovy::1410181719105-80::rvsz (generated)::(Checksum: 3:a96ec94441f5d31aff93ea7dc023d833)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-80', '2.0.5', '3:a96ec94441f5d31aff93ea7dc023d833', 195);

--  Changeset changelog.groovy::1410181719105-81::rvsz (generated)::(Checksum: 3:93a8306148b3b4d325e4daa6320d2ca0)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-81', '2.0.5', '3:93a8306148b3b4d325e4daa6320d2ca0', 196);

--  Changeset changelog.groovy::1410181719105-82::rvsz (generated)::(Checksum: 3:abb7940e2269ec8036649b6d7f075cbf)
ALTER TABLE `intent_action` ADD CONSTRAINT `FKEBCDD397666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-82', '2.0.5', '3:abb7940e2269ec8036649b6d7f075cbf', 197);

--  Changeset changelog.groovy::1410181719105-83::rvsz (generated)::(Checksum: 3:48df11e51f607f71ab3d78d77c8e862f)
ALTER TABLE `intent_action` ADD CONSTRAINT `FKEBCDD39E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-83', '2.0.5', '3:48df11e51f607f71ab3d78d77c8e862f', 198);

--  Changeset changelog.groovy::1410181719105-84::rvsz (generated)::(Checksum: 3:3490f48956316012f6c32eebb1066863)
ALTER TABLE `intent_data_type` ADD CONSTRAINT `FKEADB30CC7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-84', '2.0.5', '3:3490f48956316012f6c32eebb1066863', 199);

--  Changeset changelog.groovy::1410181719105-85::rvsz (generated)::(Checksum: 3:bda01aa389d75a04fc6fb48ebabc74b3)
ALTER TABLE `intent_data_type` ADD CONSTRAINT `FKEADB30CCE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-85', '2.0.5', '3:bda01aa389d75a04fc6fb48ebabc74b3', 200);

--  Changeset changelog.groovy::1410181719105-86::rvsz (generated)::(Checksum: 3:a44ccb86429d03ec4fea4a898375f590)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D335A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-86', '2.0.5', '3:a44ccb86429d03ec4fea4a898375f590', 201);

--  Changeset changelog.groovy::1410181719105-87::rvsz (generated)::(Checksum: 3:48e7833bd349bbe1a7a03a7c6d8246b0)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D337666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-87', '2.0.5', '3:48e7833bd349bbe1a7a03a7c6d8246b0', 202);

--  Changeset changelog.groovy::1410181719105-88::rvsz (generated)::(Checksum: 3:704e07f94eb1a0c534dd728f8c94cede)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-88', '2.0.5', '3:704e07f94eb1a0c534dd728f8c94cede', 203);

--  Changeset changelog.groovy::1410181719105-89::rvsz (generated)::(Checksum: 3:e75f65a25771c68ccb85c095a5bb6c66)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-89', '2.0.5', '3:e75f65a25771c68ccb85c095a5bb6c66', 204);

--  Changeset changelog.groovy::1410181719105-90::rvsz (generated)::(Checksum: 3:39ddedf5e6c93bded7890f9b5d858211)
ALTER TABLE `modify_relationship_activity` ADD CONSTRAINT `FKE68D3F71C359936F` FOREIGN KEY (`id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-90', '2.0.5', '3:39ddedf5e6c93bded7890f9b5d858211', 205);

--  Changeset changelog.groovy::1410181719105-91::rvsz (generated)::(Checksum: 3:d18161f4381ebc7d93497532e4e28567)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A961C3343D` FOREIGN KEY (`avatar_id`) REFERENCES `avatar` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-91', '2.0.5', '3:d18161f4381ebc7d93497532e4e28567', 206);

--  Changeset changelog.groovy::1410181719105-92::rvsz (generated)::(Checksum: 3:e86f16463585314b530be5e7573a9296)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-92', '2.0.5', '3:e86f16463585314b530be5e7573a9296', 207);

--  Changeset changelog.groovy::1410181719105-93::rvsz (generated)::(Checksum: 3:c5cba2edf4144c33b909623615472244)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-93', '2.0.5', '3:c5cba2edf4144c33b909623615472244', 208);

--  Changeset changelog.groovy::1410181719105-94::rvsz (generated)::(Checksum: 3:17af64a271de5d59da444e307e0649f0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C1285C359936F` FOREIGN KEY (`id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-94', '2.0.5', '3:17af64a271de5d59da444e307e0649f0', 209);

--  Changeset changelog.groovy::1410181719105-95::rvsz (generated)::(Checksum: 3:3c8e09e6df0585dccbc5813b6ed69ff0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C128582548A4A` FOREIGN KEY (`rejection_listing_id`) REFERENCES `rejection_listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-95', '2.0.5', '3:3c8e09e6df0585dccbc5813b6ed69ff0', 210);

--  Changeset changelog.groovy::1410181719105-96::rvsz (generated)::(Checksum: 3:c789755760ba85d22170229257e27420)
ALTER TABLE `rejection_justification` ADD CONSTRAINT `FK12B0A53C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-96', '2.0.5', '3:c789755760ba85d22170229257e27420', 211);

--  Changeset changelog.groovy::1410181719105-97::rvsz (generated)::(Checksum: 3:c133b80c0e79f87d2774d50ae9ae913d)
ALTER TABLE `rejection_justification` ADD CONSTRAINT `FK12B0A53CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-97', '2.0.5', '3:c133b80c0e79f87d2774d50ae9ae913d', 212);

--  Changeset changelog.groovy::1410181719105-98::rvsz (generated)::(Checksum: 3:0ec52b0ffac45e2d8b8d25ecdd0b708a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E5A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-98', '2.0.5', '3:0ec52b0ffac45e2d8b8d25ecdd0b708a', 213);

--  Changeset changelog.groovy::1410181719105-99::rvsz (generated)::(Checksum: 3:c4b6c6b7843000ce7af769a43a00eada)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-99', '2.0.5', '3:c4b6c6b7843000ce7af769a43a00eada', 214);

--  Changeset changelog.groovy::1410181719105-100::rvsz (generated)::(Checksum: 3:a5a6551c740e542d7847e4c110846e8a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-100', '2.0.5', '3:a5a6551c740e542d7847e4c110846e8a', 215);

--  Changeset changelog.groovy::1410181719105-101::rvsz (generated)::(Checksum: 3:a4e272508b9e57b1bb808c09137603cd)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E19CEB614` FOREIGN KEY (`justification_id`) REFERENCES `rejection_justification` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-101', '2.0.5', '3:a4e272508b9e57b1bb808c09137603cd', 216);

--  Changeset changelog.groovy::1410181719105-102::rvsz (generated)::(Checksum: 3:2fa419ff4750218d35b68a34d8c3da7b)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-102', '2.0.5', '3:2fa419ff4750218d35b68a34d8c3da7b', 217);

--  Changeset changelog.groovy::1410181719105-103::rvsz (generated)::(Checksum: 3:b07ddeec1bdade32f15ca8148ca1f984)
ALTER TABLE `relationship` ADD CONSTRAINT `FKF06476389D70DD39` FOREIGN KEY (`owning_entity_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-103', '2.0.5', '3:b07ddeec1bdade32f15ca8148ca1f984', 218);

--  Changeset changelog.groovy::1410181719105-104::rvsz (generated)::(Checksum: 3:52fa8b8938c8b9c84ae74abbb0c410a7)
ALTER TABLE `relationship_activity_log` ADD CONSTRAINT `FK594974BB25A20F9D` FOREIGN KEY (`service_item_snapshot_id`) REFERENCES `service_item_snapshot` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-104', '2.0.5', '3:52fa8b8938c8b9c84ae74abbb0c410a7', 219);

--  Changeset changelog.groovy::1410181719105-105::rvsz (generated)::(Checksum: 3:9bbf25bf2c4101144e5dddb1f81e06f1)
ALTER TABLE `relationship_service_item` ADD CONSTRAINT `FKDA02504C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-105', '2.0.5', '3:9bbf25bf2c4101144e5dddb1f81e06f1', 220);

--  Changeset changelog.groovy::1410181719105-106::rvsz (generated)::(Checksum: 3:62ebbecfd4877631ccde6515ed314fc8)
ALTER TABLE `score_card_item` ADD CONSTRAINT `FKE51CCD757666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-106', '2.0.5', '3:62ebbecfd4877631ccde6515ed314fc8', 221);

--  Changeset changelog.groovy::1410181719105-107::rvsz (generated)::(Checksum: 3:ae783dc6290ffe3a26343f83d557b016)
ALTER TABLE `score_card_item` ADD CONSTRAINT `FKE51CCD75E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-107', '2.0.5', '3:ae783dc6290ffe3a26343f83d557b016', 222);

--  Changeset changelog.groovy::1410181719105-108::rvsz (generated)::(Checksum: 3:f6eba1782ecc96476aaeb2674f93d056)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D85667666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-108', '2.0.5', '3:f6eba1782ecc96476aaeb2674f93d056', 223);

--  Changeset changelog.groovy::1410181719105-109::rvsz (generated)::(Checksum: 3:5e3bd661f76ea9ab42001333930a315f)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-109', '2.0.5', '3:5e3bd661f76ea9ab42001333930a315f', 224);

--  Changeset changelog.groovy::1410181719105-110::rvsz (generated)::(Checksum: 3:eedfff3fc77f6b2d0781b36e4cba6fe6)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-110', '2.0.5', '3:eedfff3fc77f6b2d0781b36e4cba6fe6', 225);

--  Changeset changelog.groovy::1410181719105-111::rvsz (generated)::(Checksum: 3:d316ba33a1fcfd9218ff525e7d793c6b)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D143B24BD` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-111', '2.0.5', '3:d316ba33a1fcfd9218ff525e7d793c6b', 226);

--  Changeset changelog.groovy::1410181719105-112::rvsz (generated)::(Checksum: 3:fff97300dc2f8677145823d36c5bbd31)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-112', '2.0.5', '3:fff97300dc2f8677145823d36c5bbd31', 227);

--  Changeset changelog.groovy::1410181719105-113::rvsz (generated)::(Checksum: 3:5941250db3aedcd46e620dde3dd7a1aa)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565DE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-113', '2.0.5', '3:5941250db3aedcd46e620dde3dd7a1aa', 228);

--  Changeset changelog.groovy::1410181719105-114::rvsz (generated)::(Checksum: 3:2eddcdfbdecfb39d6526c001c9dfb658)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D2746B676` FOREIGN KEY (`last_activity_id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-114', '2.0.5', '3:2eddcdfbdecfb39d6526c001c9dfb658', 229);

--  Changeset changelog.groovy::1410181719105-115::rvsz (generated)::(Checksum: 3:f85f96b19885ddb87f776cccbad69643)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D6928D597` FOREIGN KEY (`types_id`) REFERENCES `types` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-115', '2.0.5', '3:f85f96b19885ddb87f776cccbad69643', 230);

--  Changeset changelog.groovy::1410181719105-116::rvsz (generated)::(Checksum: 3:d936c54eef6b6e964fa5c69c63fbbf67)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B15A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-116', '2.0.5', '3:d936c54eef6b6e964fa5c69c63fbbf67', 231);

--  Changeset changelog.groovy::1410181719105-117::rvsz (generated)::(Checksum: 3:54a152fc18eb6134afd5a80599d7d81c)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B17666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-117', '2.0.5', '3:54a152fc18eb6134afd5a80599d7d81c', 232);

--  Changeset changelog.groovy::1410181719105-118::rvsz (generated)::(Checksum: 3:c7e121efc0ffad4b010d8e0ab4c383fe)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B1E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-118', '2.0.5', '3:c7e121efc0ffad4b010d8e0ab4c383fe', 233);

--  Changeset changelog.groovy::1410181719105-119::rvsz (generated)::(Checksum: 3:7419d815453d39e96aff8aa4369c9adf)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B1C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-119', '2.0.5', '3:7419d815453d39e96aff8aa4369c9adf', 234);

--  Changeset changelog.groovy::1410181719105-120::rvsz (generated)::(Checksum: 3:79052fcbd1e5106b6ac399b700788437)
ALTER TABLE `service_item_category` ADD CONSTRAINT `FKECC570A0DA41995D` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-120', '2.0.5', '3:79052fcbd1e5106b6ac399b700788437', 235);

--  Changeset changelog.groovy::1410181719105-121::rvsz (generated)::(Checksum: 3:4d420ccbd0ca5606d2adf5d7aac8a36c)
ALTER TABLE `service_item_documentation_url` ADD CONSTRAINT `FK24572D08C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-121', '2.0.5', '3:4d420ccbd0ca5606d2adf5d7aac8a36c', 236);

--  Changeset changelog.groovy::1410181719105-122::rvsz (generated)::(Checksum: 3:59b059175d04680e3e92319c1c79acfc)
ALTER TABLE `service_item_profile` ADD CONSTRAINT `FK68B5D9C7C0565C57` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-122', '2.0.5', '3:59b059175d04680e3e92319c1c79acfc', 237);

--  Changeset changelog.groovy::1410181719105-123::rvsz (generated)::(Checksum: 3:62065e81eb20b63d55a48d9ab351efce)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F93EF469C97` FOREIGN KEY (`score_card_item_id`) REFERENCES `score_card_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-123', '2.0.5', '3:62065e81eb20b63d55a48d9ab351efce', 238);

--  Changeset changelog.groovy::1410181719105-124::rvsz (generated)::(Checksum: 3:0a2d929b0c81ecb716c2135f8a0e73d4)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F93C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-124', '2.0.5', '3:0a2d929b0c81ecb716c2135f8a0e73d4', 239);

--  Changeset changelog.groovy::1410181719105-125::rvsz (generated)::(Checksum: 3:d633ffb580e53186e21ad6bfc6e0f1bd)
ALTER TABLE `service_item_snapshot` ADD CONSTRAINT `FKFABD8966C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-125', '2.0.5', '3:d633ffb580e53186e21ad6bfc6e0f1bd', 240);

--  Changeset changelog.groovy::1410181719105-126::rvsz (generated)::(Checksum: 3:5c07ccda7d132407c1a0a37a4187d936)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB87666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-126', '2.0.5', '3:5c07ccda7d132407c1a0a37a4187d936', 241);

--  Changeset changelog.groovy::1410181719105-127::rvsz (generated)::(Checksum: 3:6c7200bc4927a0e147c68170e94b2013)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB8C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-127', '2.0.5', '3:6c7200bc4927a0e147c68170e94b2013', 242);

--  Changeset changelog.groovy::1410181719105-128::rvsz (generated)::(Checksum: 3:ac6dd24a2661ca11105ead8109083fca)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB8EACAF137` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-128', '2.0.5', '3:ac6dd24a2661ca11105ead8109083fca', 243);

--  Changeset changelog.groovy::1410181719105-129::rvsz (generated)::(Checksum: 3:5f9d9a8f96b880c9dbec38391f6a0bb3)
ALTER TABLE `service_item_tags` ADD CONSTRAINT `FKE1808BBC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-129', '2.0.5', '3:5f9d9a8f96b880c9dbec38391f6a0bb3', 244);

--  Changeset changelog.groovy::1410181719105-130::rvsz (generated)::(Checksum: 3:e9aa98b1fb28a5cd533d94d016e3d5e2)
ALTER TABLE `service_item_tech_pocs` ADD CONSTRAINT `FKA55CFB56C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-130', '2.0.5', '3:e9aa98b1fb28a5cd533d94d016e3d5e2', 245);

--  Changeset changelog.groovy::1410181719105-131::rvsz (generated)::(Checksum: 3:201f8bdc487570cf35d198837c85c7ca)
ALTER TABLE `si_recommended_layouts` ADD CONSTRAINT `FK863C793CC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-131', '2.0.5', '3:201f8bdc487570cf35d198837c85c7ca', 246);

--  Changeset changelog.groovy::1410181719105-132::rvsz (generated)::(Checksum: 3:bde34c0ea37cc97ff5077237a4a9a9c3)
ALTER TABLE `tag` ADD CONSTRAINT `FK1BF9A7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-132', '2.0.5', '3:bde34c0ea37cc97ff5077237a4a9a9c3', 247);

--  Changeset changelog.groovy::1410181719105-133::rvsz (generated)::(Checksum: 3:1670611fe1b80b5a0c40ce47dd33208f)
ALTER TABLE `tag` ADD CONSTRAINT `FK1BF9AE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-133', '2.0.5', '3:1670611fe1b80b5a0c40ce47dd33208f', 248);

--  Changeset changelog.groovy::1410181719105-134::rvsz (generated)::(Checksum: 3:f9354f4a00ffd1125f4aa8cf8c27f848)
ALTER TABLE `types` ADD CONSTRAINT `FK69B58797666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-134', '2.0.5', '3:f9354f4a00ffd1125f4aa8cf8c27f848', 249);

--  Changeset changelog.groovy::1410181719105-135::rvsz (generated)::(Checksum: 3:83c281fe67e5292b39a09a2c7dc236ef)
ALTER TABLE `types` ADD CONSTRAINT `FK69B5879E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-135', '2.0.5', '3:83c281fe67e5292b39a09a2c7dc236ef', 250);

--  Changeset changelog.groovy::1410181719105-136::rvsz (generated)::(Checksum: 3:038742c298b4d3893f6fd6b1f08dcd53)
ALTER TABLE `types` ADD CONSTRAINT `FK69B5879553AF61A` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-136', '2.0.5', '3:038742c298b4d3893f6fd6b1f08dcd53', 251);

--  Changeset changelog.groovy::1410181719105-137::rvsz (generated)::(Checksum: 3:f729f552ceca36a137f3769f51bc6664)
ALTER TABLE `U_DOMAIN` ADD CONSTRAINT `FK97BAABEE7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-137', '2.0.5', '3:f729f552ceca36a137f3769f51bc6664', 252);

--  Changeset changelog.groovy::1410181719105-138::rvsz (generated)::(Checksum: 3:cf2276052d5b3f4e52206e93bb35b220)
ALTER TABLE `U_DOMAIN` ADD CONSTRAINT `FK97BAABEEE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-138', '2.0.5', '3:cf2276052d5b3f4e52206e93bb35b220', 253);

--  Changeset changelog.groovy::1410181719105-139::rvsz (generated)::(Checksum: 3:be39f1d0b8f0b0b33d2742e2005a9d11)
ALTER TABLE `user_account` ADD CONSTRAINT `FK14C321B97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-139', '2.0.5', '3:be39f1d0b8f0b0b33d2742e2005a9d11', 254);

--  Changeset changelog.groovy::1410181719105-140::rvsz (generated)::(Checksum: 3:28e21ae37aab6377d77dba5b05bdea43)
ALTER TABLE `user_account` ADD CONSTRAINT `FK14C321B9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1410181719105-140', '2.0.5', '3:28e21ae37aab6377d77dba5b05bdea43', 255);

