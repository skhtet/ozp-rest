--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: changelog.groovy
--  Ran at: 9/24/14 10:05 AM
--  Against: root@localhost@jdbc:mysql://localhost:3306/ozp_empty
--  Liquibase version: 2.0.5
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE `DATABASECHANGELOGLOCK` (`ID` INT NOT NULL, `LOCKED` TINYINT(1) NOT NULL, `LOCKGRANTED` DATETIME NULL, `LOCKEDBY` VARCHAR(255) NULL, CONSTRAINT `PK_DATABASECHANGELOGLOCK` PRIMARY KEY (`ID`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`) VALUES (1, 0);

--  Lock Database
--  Create Database Change Log Table
CREATE TABLE `DATABASECHANGELOG` (`ID` VARCHAR(63) NOT NULL, `AUTHOR` VARCHAR(63) NOT NULL, `FILENAME` VARCHAR(200) NOT NULL, `DATEEXECUTED` DATETIME NOT NULL, `ORDEREXECUTED` INT NOT NULL, `EXECTYPE` VARCHAR(10) NOT NULL, `MD5SUM` VARCHAR(35) NULL, `DESCRIPTION` VARCHAR(255) NULL, `COMMENTS` VARCHAR(255) NULL, `TAG` VARCHAR(255) NULL, `LIQUIBASE` VARCHAR(20) NULL, CONSTRAINT `PK_DATABASECHANGELOG` PRIMARY KEY (`ID`, `AUTHOR`, `FILENAME`)) ENGINE=InnoDB;

--  Changeset changelog.groovy::1411567147723-1::rvsz (generated)::(Checksum: 3:1f5d38f6c5391dcc50cd9a53f0bd0a93)
CREATE TABLE `affiliated_marketplace` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `active` INT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_id` BIGINT NULL, `name` VARCHAR(50) NOT NULL, `server_url` VARCHAR(2083) NOT NULL, `timeout` BIGINT NULL, CONSTRAINT `affiliated_maPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-1', '2.0.5', '3:1f5d38f6c5391dcc50cd9a53f0bd0a93', 1);

--  Changeset changelog.groovy::1411567147723-2::rvsz (generated)::(Checksum: 3:8b934c46fe5a4bfdf27eab1b0296c47f)
CREATE TABLE `agency` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_url` VARCHAR(2000) NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `agencyPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-2', '2.0.5', '3:8b934c46fe5a4bfdf27eab1b0296c47f', 2);

--  Changeset changelog.groovy::1411567147723-3::rvsz (generated)::(Checksum: 3:3af7052e9a41d5147f84585402cba2fd)
CREATE TABLE `application_library_entry` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `folder` VARCHAR(256) NULL, `owner_id` BIGINT NOT NULL, `service_item_id` BIGINT NOT NULL, `application_library_idx` INT NULL, CONSTRAINT `application_lPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-3', '2.0.5', '3:3af7052e9a41d5147f84585402cba2fd', 3);

--  Changeset changelog.groovy::1411567147723-4::rvsz (generated)::(Checksum: 3:3c8612802ba92d864bcc75af84bc9bd0)
CREATE TABLE `category` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `categoryPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-4', '2.0.5', '3:3c8612802ba92d864bcc75af84bc9bd0', 4);

--  Changeset changelog.groovy::1411567147723-5::rvsz (generated)::(Checksum: 3:98e78239cb364b058aa28d438f0a6f3c)
CREATE TABLE `change_detail` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `field_name` VARCHAR(255) NOT NULL, `new_value` VARCHAR(4000) NULL, `old_value` VARCHAR(4000) NULL, `service_item_activity_id` BIGINT NOT NULL, CONSTRAINT `change_detailPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-5', '2.0.5', '3:98e78239cb364b058aa28d438f0a6f3c', 5);

--  Changeset changelog.groovy::1411567147723-6::rvsz (generated)::(Checksum: 3:2fd2da818906249dcf154d70b688320a)
CREATE TABLE `contact` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(100) NOT NULL, `name` VARCHAR(100) NOT NULL, `organization` VARCHAR(100) NULL, `secure_phone` VARCHAR(50) NULL, `service_item_id` BIGINT NOT NULL, `type_id` BIGINT NOT NULL, `unsecure_phone` VARCHAR(50) NULL, CONSTRAINT `contactPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-6', '2.0.5', '3:2fd2da818906249dcf154d70b688320a', 6);

--  Changeset changelog.groovy::1411567147723-7::rvsz (generated)::(Checksum: 3:73e507e6e52c79361a2c768bb9c118df)
CREATE TABLE `contact_type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `required` bit NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `contact_typePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-7', '2.0.5', '3:73e507e6e52c79361a2c768bb9c118df', 7);

--  Changeset changelog.groovy::1411567147723-8::rvsz (generated)::(Checksum: 3:8bad284909f640ab1b5a3bc225f2aae0)
CREATE TABLE `default_images` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `defined_default_type` VARCHAR(255) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_id` BIGINT NOT NULL, CONSTRAINT `default_imagePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-8', '2.0.5', '3:8bad284909f640ab1b5a3bc225f2aae0', 8);

--  Changeset changelog.groovy::1411567147723-9::rvsz (generated)::(Checksum: 3:cd7194106bc54a86b229a5a36543e41d)
CREATE TABLE `images` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `bytes` mediumblob NOT NULL, `content_type` VARCHAR(255) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_size` double precision NULL, `is_default` bit NOT NULL, `type` VARCHAR(255) NOT NULL, CONSTRAINT `imagesPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-9', '2.0.5', '3:cd7194106bc54a86b229a5a36543e41d', 9);

--  Changeset changelog.groovy::1411567147723-10::rvsz (generated)::(Checksum: 3:ab10ac2aed1beb1454addfca3aa05ea0)
CREATE TABLE `import_task` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `cron_exp` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `enabled` bit NOT NULL, `exec_interval` INT NULL, `extra_url_params` VARCHAR(512) NULL, `interface_config_id` BIGINT NOT NULL, `keystore_pass` VARCHAR(2048) NULL, `keystore_path` VARCHAR(2048) NULL, `last_run_result_id` BIGINT NULL, `name` VARCHAR(50) NOT NULL, `truststore_path` VARCHAR(2048) NULL, `update_type` VARCHAR(7) NOT NULL, `url` VARCHAR(255) NULL, CONSTRAINT `import_taskPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-10', '2.0.5', '3:ab10ac2aed1beb1454addfca3aa05ea0', 10);

--  Changeset changelog.groovy::1411567147723-11::rvsz (generated)::(Checksum: 3:2c4db683b45130f9966f2cf458679d9e)
CREATE TABLE `import_task_result` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `message` VARCHAR(4000) NOT NULL, `result` bit NOT NULL, `run_date` DATETIME NOT NULL, `task_id` BIGINT NOT NULL, CONSTRAINT `import_task_rPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-11', '2.0.5', '3:2c4db683b45130f9966f2cf458679d9e', 11);

--  Changeset changelog.groovy::1411567147723-12::rvsz (generated)::(Checksum: 3:bc251f9b773fe8295224a09818a7f313)
CREATE TABLE `intent` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action` VARCHAR(64) NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon` VARCHAR(2083) NULL, `label` VARCHAR(255) NULL, `type` VARCHAR(129) NOT NULL, CONSTRAINT `intentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-12', '2.0.5', '3:bc251f9b773fe8295224a09818a7f313', 12);

--  Changeset changelog.groovy::1411567147723-13::rvsz (generated)::(Checksum: 3:cff3f65d09133dba3925f79a95a7fdd5)
CREATE TABLE `interface_configuration` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `allow_truncate` bit NOT NULL, `auto_create_meta_data` bit NOT NULL, `default_large_icon_url` VARCHAR(2048) NULL, `default_small_icon_url` VARCHAR(2048) NULL, `delta_since_time_param` VARCHAR(64) NULL, `delta_static_parameters` VARCHAR(2048) NULL, `download_images` bit NOT NULL, `full_static_parameters` VARCHAR(2048) NULL, `loose_match` bit NOT NULL, `name` VARCHAR(256) NOT NULL, `query_date_format` VARCHAR(32) NULL, `response_date_format` VARCHAR(32) NULL, CONSTRAINT `interface_conPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-13', '2.0.5', '3:cff3f65d09133dba3925f79a95a7fdd5', 13);

--  Changeset changelog.groovy::1411567147723-14::rvsz (generated)::(Checksum: 3:656ef6835c8374c290ca788221b3a463)
CREATE TABLE `item_comment` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `rate` FLOAT NULL, `service_item_id` BIGINT NOT NULL, `text` VARCHAR(4000) NULL, CONSTRAINT `item_commentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-14', '2.0.5', '3:656ef6835c8374c290ca788221b3a463', 14);

--  Changeset changelog.groovy::1411567147723-15::rvsz (generated)::(Checksum: 3:8239f1d9f0eab24ad7b5155eee986d8b)
CREATE TABLE `iwc_data_object` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `content_type` VARCHAR(129) NOT NULL, `entity` VARCHAR(255) NULL, `key` VARCHAR(255) NOT NULL, `profile_id` BIGINT NOT NULL, CONSTRAINT `iwc_data_objePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-15', '2.0.5', '3:8239f1d9f0eab24ad7b5155eee986d8b', 15);

--  Changeset changelog.groovy::1411567147723-16::rvsz (generated)::(Checksum: 3:b700c0fb68ed1e67cb011c8f9a3e81c7)
CREATE TABLE `modify_relationship_activity` (`id` BIGINT NOT NULL, CONSTRAINT `modify_relatiPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-16', '2.0.5', '3:b700c0fb68ed1e67cb011c8f9a3e81c7', 16);

--  Changeset changelog.groovy::1411567147723-17::rvsz (generated)::(Checksum: 3:55016253d87443da11df92dee7d5cd5d)
CREATE TABLE `profile` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `bio` VARCHAR(1000) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `display_name` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(255) NULL, `highest_role` VARCHAR(255) NOT NULL, `last_login` DATETIME NOT NULL, `username` VARCHAR(255) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `profilePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-17', '2.0.5', '3:55016253d87443da11df92dee7d5cd5d', 17);

--  Changeset changelog.groovy::1411567147723-18::rvsz (generated)::(Checksum: 3:9fe447a3fad73eea40d5afd927488bdf)
CREATE TABLE `profile_agency` (`profile_organizations_id` BIGINT NULL, `agency_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-18', '2.0.5', '3:9fe447a3fad73eea40d5afd927488bdf', 18);

--  Changeset changelog.groovy::1411567147723-19::rvsz (generated)::(Checksum: 3:68b34fdc60312d9ae718e899b7ed900a)
CREATE TABLE `rejection_activity` (`id` BIGINT NOT NULL, `rejection_listing_id` BIGINT NULL, CONSTRAINT `rejection_actPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-19', '2.0.5', '3:68b34fdc60312d9ae718e899b7ed900a', 19);

--  Changeset changelog.groovy::1411567147723-20::rvsz (generated)::(Checksum: 3:5dff13cffd0e02292154f45a2be3aa4f)
CREATE TABLE `rejection_justification` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `rejection_jusPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-20', '2.0.5', '3:5dff13cffd0e02292154f45a2be3aa4f', 20);

--  Changeset changelog.groovy::1411567147723-21::rvsz (generated)::(Checksum: 3:73999ab49978c811debcc63163528418)
CREATE TABLE `rejection_listing` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(2000) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `justification_id` BIGINT NULL, `service_item_id` BIGINT NOT NULL, CONSTRAINT `rejection_lisPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-21', '2.0.5', '3:73999ab49978c811debcc63163528418', 21);

--  Changeset changelog.groovy::1411567147723-22::rvsz (generated)::(Checksum: 3:35de2004bba9f2010a19fae71c5caa1c)
CREATE TABLE `relationship` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `owning_entity_id` BIGINT NOT NULL, `relationship_type` VARCHAR(255) NOT NULL, CONSTRAINT `relationshipPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-22', '2.0.5', '3:35de2004bba9f2010a19fae71c5caa1c', 22);

--  Changeset changelog.groovy::1411567147723-23::rvsz (generated)::(Checksum: 3:ccbc00586b719fb2cd9e95552f14a51e)
CREATE TABLE `relationship_activity_log` (`mod_rel_activity_id` BIGINT NOT NULL, `service_item_snapshot_id` BIGINT NULL, `items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-23', '2.0.5', '3:ccbc00586b719fb2cd9e95552f14a51e', 23);

--  Changeset changelog.groovy::1411567147723-24::rvsz (generated)::(Checksum: 3:3353ece6d39474face902dc7cb745ae5)
CREATE TABLE `relationship_service_item` (`relationship_related_items_id` BIGINT NULL, `service_item_id` BIGINT NULL, `related_items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-24', '2.0.5', '3:3353ece6d39474face902dc7cb745ae5', 24);

--  Changeset changelog.groovy::1411567147723-25::rvsz (generated)::(Checksum: 3:2fe6f76873fca5a11804f8f1b5c510e4)
CREATE TABLE `score_card_item` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(500) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image` VARCHAR(250) NULL, `question` VARCHAR(250) NOT NULL, `show_on_listing` bit NULL, CONSTRAINT `score_card_itPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-25', '2.0.5', '3:2fe6f76873fca5a11804f8f1b5c510e4', 25);

--  Changeset changelog.groovy::1411567147723-26::rvsz (generated)::(Checksum: 3:569f18e5b3ee6de4159e8e5832d60fbd)
CREATE TABLE `screenshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `large_image_url` VARCHAR(2083) NULL, `service_item_id` BIGINT NOT NULL, `small_image_url` VARCHAR(2083) NOT NULL, `ordinal` INT NULL, CONSTRAINT `screenshotPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-26', '2.0.5', '3:569f18e5b3ee6de4159e8e5832d60fbd', 26);

--  Changeset changelog.groovy::1411567147723-27::rvsz (generated)::(Checksum: 3:cca9065db67df59bff2441138604e66d)
CREATE TABLE `service_item` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `agency_id` BIGINT NULL, `approval_status` VARCHAR(11) NOT NULL, `approved_date` DATETIME NULL, `avg_rate` FLOAT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(4000) NULL, `description_short` VARCHAR(150) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_large_url` VARCHAR(2083) NULL, `image_medium_url` VARCHAR(2083) NULL, `image_small_url` VARCHAR(2083) NULL, `image_xlarge_url` VARCHAR(2083) NULL, `is_enabled` bit NOT NULL, `is_featured` bit NULL, `last_activity_id` BIGINT NULL, `launch_url` VARCHAR(2083) NULL, `requirements` VARCHAR(1000) NULL, `title` VARCHAR(256) NOT NULL, `total_comments` INT NOT NULL, `total_rate1` INT NULL, `total_rate2` INT NULL, `total_rate3` INT NULL, `total_rate4` INT NULL, `total_rate5` INT NULL, `total_votes` INT NOT NULL, `type_id` BIGINT NOT NULL, `uuid` VARCHAR(255) NOT NULL, `version_name` VARCHAR(256) NULL, `what_is_new` VARCHAR(250) NULL, CONSTRAINT `service_itemPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-27', '2.0.5', '3:cca9065db67df59bff2441138604e66d', 27);

--  Changeset changelog.groovy::1411567147723-28::rvsz (generated)::(Checksum: 3:df721953caa6b8f438fd7dc2b63f6fc7)
CREATE TABLE `service_item_activity` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action` VARCHAR(255) NOT NULL, `activity_date` DATETIME NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `service_item_id` BIGINT NOT NULL, `service_item_activities_idx` INT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-28', '2.0.5', '3:df721953caa6b8f438fd7dc2b63f6fc7', 28);

--  Changeset changelog.groovy::1411567147723-29::rvsz (generated)::(Checksum: 3:dc983910256e700f1caf9f4a7ec291de)
CREATE TABLE `service_item_category` (`service_item_categories_id` BIGINT NULL, `category_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-29', '2.0.5', '3:dc983910256e700f1caf9f4a7ec291de', 29);

--  Changeset changelog.groovy::1411567147723-30::rvsz (generated)::(Checksum: 3:a16fda6903cd6797a6d1496735dab339)
CREATE TABLE `service_item_documentation_url` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `name` VARCHAR(255) NOT NULL, `service_item_id` BIGINT NOT NULL, `url` VARCHAR(2083) NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-30', '2.0.5', '3:a16fda6903cd6797a6d1496735dab339', 30);

--  Changeset changelog.groovy::1411567147723-31::rvsz (generated)::(Checksum: 3:45d938ef76ddf5bef338ab6049e67adf)
CREATE TABLE `service_item_intents` (`intent_id` BIGINT NOT NULL, `service_item_id` BIGINT NOT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-31', '2.0.5', '3:45d938ef76ddf5bef338ab6049e67adf', 31);

--  Changeset changelog.groovy::1411567147723-32::rvsz (generated)::(Checksum: 3:c99118647bda2362be2220989fa6e770)
CREATE TABLE `service_item_profile` (`service_item_owners_id` BIGINT NULL, `profile_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-32', '2.0.5', '3:c99118647bda2362be2220989fa6e770', 32);

--  Changeset changelog.groovy::1411567147723-33::rvsz (generated)::(Checksum: 3:a9daca8ada2682389896226df8e5295f)
CREATE TABLE `service_item_score_card_item` (`service_item_id` BIGINT NOT NULL, `score_card_item_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-33', '2.0.5', '3:a9daca8ada2682389896226df8e5295f', 33);

--  Changeset changelog.groovy::1411567147723-34::rvsz (generated)::(Checksum: 3:c3d11c80280b277df15391fb13b425c5)
CREATE TABLE `service_item_snapshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `service_item_id` BIGINT NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-34', '2.0.5', '3:c3d11c80280b277df15391fb13b425c5', 34);

--  Changeset changelog.groovy::1411567147723-35::rvsz (generated)::(Checksum: 3:8285959ed18a118af62cfab9724fcfa3)
CREATE TABLE `service_item_tag` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NOT NULL, `service_item_id` BIGINT NOT NULL, `tag_id` BIGINT NOT NULL, CONSTRAINT `service_item_PK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-35', '2.0.5', '3:8285959ed18a118af62cfab9724fcfa3', 35);

--  Changeset changelog.groovy::1411567147723-36::rvsz (generated)::(Checksum: 3:b62d4c33b02092c509f954a549d1e55a)
CREATE TABLE `service_item_tags` (`service_item_id` BIGINT NULL, `tags_string` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-36', '2.0.5', '3:b62d4c33b02092c509f954a549d1e55a', 36);

--  Changeset changelog.groovy::1411567147723-37::rvsz (generated)::(Checksum: 3:45814e4253446757713edf56b8da0e6b)
CREATE TABLE `tag` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(16) NOT NULL, CONSTRAINT `tagPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-37', '2.0.5', '3:45814e4253446757713edf56b8da0e6b', 37);

--  Changeset changelog.groovy::1411567147723-38::rvsz (generated)::(Checksum: 3:19e17e607d75f85503dc1f06bf9a8911)
CREATE TABLE `types` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(250) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `has_icons` bit NOT NULL, `has_launch_url` bit NOT NULL, `image_id` BIGINT NULL, `is_permanent` bit NULL, `ozone_aware` bit NOT NULL, `title` VARCHAR(50) NOT NULL, `uuid` VARCHAR(255) NULL, CONSTRAINT `typesPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1411567147723-38', '2.0.5', '3:19e17e607d75f85503dc1f06bf9a8911', 38);

--  Changeset changelog.groovy::1411567147723-39::rvsz (generated)::(Checksum: 3:31053cbf4e4e9b7fba71a2782a026deb)
ALTER TABLE `service_item_intents` ADD PRIMARY KEY (`service_item_id`, `intent_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Primary Key', 'EXECUTED', 'changelog.groovy', '1411567147723-39', '2.0.5', '3:31053cbf4e4e9b7fba71a2782a026deb', 39);

--  Changeset changelog.groovy::1411567147723-125::rvsz (generated)::(Checksum: 3:1d8d829f17c93a29e297aec596b28543)
CREATE INDEX `FKA6EB2C37666C6D2` ON `affiliated_marketplace`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-125', '2.0.5', '3:1d8d829f17c93a29e297aec596b28543', 40);

--  Changeset changelog.groovy::1411567147723-126::rvsz (generated)::(Checksum: 3:5c655bec643a153e1a7f44c0e4fdd048)
CREATE INDEX `FKA6EB2C3E31CB353` ON `affiliated_marketplace`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-126', '2.0.5', '3:5c655bec643a153e1a7f44c0e4fdd048', 41);

--  Changeset changelog.groovy::1411567147723-127::rvsz (generated)::(Checksum: 3:342abe96fa572cb5dc8e695160d2679c)
CREATE INDEX `FKA6EB2C3EA25263C` ON `affiliated_marketplace`(`icon_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-127', '2.0.5', '3:342abe96fa572cb5dc8e695160d2679c', 42);

--  Changeset changelog.groovy::1411567147723-128::rvsz (generated)::(Checksum: 3:6737c56d2d977a4fa0df3bfb9e8e3ba4)
CREATE INDEX `FKAB611C057666C6D2` ON `agency`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-128', '2.0.5', '3:6737c56d2d977a4fa0df3bfb9e8e3ba4', 43);

--  Changeset changelog.groovy::1411567147723-129::rvsz (generated)::(Checksum: 3:f95dceb464d93ea2e10653557b6c3bbd)
CREATE INDEX `FKAB611C05E31CB353` ON `agency`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-129', '2.0.5', '3:f95dceb464d93ea2e10653557b6c3bbd', 44);

--  Changeset changelog.groovy::1411567147723-130::rvsz (generated)::(Checksum: 3:43852ba0e12d319c7343ce74a55a77e1)
CREATE INDEX `FK44E0233F6530DF0D` ON `application_library_entry`(`owner_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-130', '2.0.5', '3:43852ba0e12d319c7343ce74a55a77e1', 45);

--  Changeset changelog.groovy::1411567147723-131::rvsz (generated)::(Checksum: 3:fc97139fe6e217c507678b9b460f648d)
CREATE INDEX `FK44E0233F7666C6D2` ON `application_library_entry`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-131', '2.0.5', '3:fc97139fe6e217c507678b9b460f648d', 46);

--  Changeset changelog.groovy::1411567147723-132::rvsz (generated)::(Checksum: 3:729b648114d7ac376b217d9c72168a1c)
CREATE INDEX `FK44E0233FC7E5C662` ON `application_library_entry`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-132', '2.0.5', '3:729b648114d7ac376b217d9c72168a1c', 47);

--  Changeset changelog.groovy::1411567147723-133::rvsz (generated)::(Checksum: 3:dbfac6862b5ebc26511bda26e69de1fd)
CREATE INDEX `FK44E0233FE31CB353` ON `application_library_entry`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-133', '2.0.5', '3:dbfac6862b5ebc26511bda26e69de1fd', 48);

--  Changeset changelog.groovy::1411567147723-134::rvsz (generated)::(Checksum: 3:be80ab78942592a1426712a07fc07e45)
CREATE UNIQUE INDEX `unique_service_item_id` ON `application_library_entry`(`owner_id`, `service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-134', '2.0.5', '3:be80ab78942592a1426712a07fc07e45', 49);

--  Changeset changelog.groovy::1411567147723-135::rvsz (generated)::(Checksum: 3:839c5edf03b5a4d78530bfe73c494a2b)
CREATE INDEX `FK302BCFE7666C6D2` ON `category`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-135', '2.0.5', '3:839c5edf03b5a4d78530bfe73c494a2b', 50);

--  Changeset changelog.groovy::1411567147723-136::rvsz (generated)::(Checksum: 3:abae98adf693d4c6e252c9635103b9ed)
CREATE INDEX `FK302BCFEE31CB353` ON `category`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-136', '2.0.5', '3:abae98adf693d4c6e252c9635103b9ed', 51);

--  Changeset changelog.groovy::1411567147723-137::rvsz (generated)::(Checksum: 3:016a8bc0a416498033a2f63b06071452)
CREATE UNIQUE INDEX `uuid_uniq_1411567147582` ON `category`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-137', '2.0.5', '3:016a8bc0a416498033a2f63b06071452', 52);

--  Changeset changelog.groovy::1411567147723-138::rvsz (generated)::(Checksum: 3:47d39028d2fa936ddfb522da6bd67a5d)
CREATE INDEX `FKB4467BC0855307BD` ON `change_detail`(`service_item_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-138', '2.0.5', '3:47d39028d2fa936ddfb522da6bd67a5d', 53);

--  Changeset changelog.groovy::1411567147723-139::rvsz (generated)::(Checksum: 3:5512d8b172d706ad23999f647e6422a6)
CREATE INDEX `FK38B724207666C6D2` ON `contact`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-139', '2.0.5', '3:5512d8b172d706ad23999f647e6422a6', 54);

--  Changeset changelog.groovy::1411567147723-140::rvsz (generated)::(Checksum: 3:e0cdb4ec69bba14939a8ce5e3947929b)
CREATE INDEX `FK38B72420BA3FC877` ON `contact`(`type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-140', '2.0.5', '3:e0cdb4ec69bba14939a8ce5e3947929b', 55);

--  Changeset changelog.groovy::1411567147723-141::rvsz (generated)::(Checksum: 3:c94ee2a89e758bc2395921cdca2fd603)
CREATE INDEX `FK38B72420C7E5C662` ON `contact`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-141', '2.0.5', '3:c94ee2a89e758bc2395921cdca2fd603', 56);

--  Changeset changelog.groovy::1411567147723-142::rvsz (generated)::(Checksum: 3:ab223b6396345140982e4218210dd2a6)
CREATE INDEX `FK38B72420E31CB353` ON `contact`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-142', '2.0.5', '3:ab223b6396345140982e4218210dd2a6', 57);

--  Changeset changelog.groovy::1411567147723-143::rvsz (generated)::(Checksum: 3:7bf0f61e79c783505df26e909504d64e)
CREATE INDEX `FK4C2BB7F97666C6D2` ON `contact_type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-143', '2.0.5', '3:7bf0f61e79c783505df26e909504d64e', 58);

--  Changeset changelog.groovy::1411567147723-144::rvsz (generated)::(Checksum: 3:95d15016c324a6f6a9e954804abcc950)
CREATE INDEX `FK4C2BB7F9E31CB353` ON `contact_type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-144', '2.0.5', '3:95d15016c324a6f6a9e954804abcc950', 59);

--  Changeset changelog.groovy::1411567147723-145::rvsz (generated)::(Checksum: 3:02184e74c24ab077987e7a651161b1c6)
CREATE UNIQUE INDEX `title_uniq_1411567147586` ON `contact_type`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-145', '2.0.5', '3:02184e74c24ab077987e7a651161b1c6', 60);

--  Changeset changelog.groovy::1411567147723-146::rvsz (generated)::(Checksum: 3:ee4410c10ef3b6175b9ec7ffd400090a)
CREATE INDEX `FK6F064E36553AF61A` ON `default_images`(`image_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-146', '2.0.5', '3:ee4410c10ef3b6175b9ec7ffd400090a', 61);

--  Changeset changelog.groovy::1411567147723-147::rvsz (generated)::(Checksum: 3:8a8976611132a8eec70e72aa8344e25a)
CREATE INDEX `FK6F064E367666C6D2` ON `default_images`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-147', '2.0.5', '3:8a8976611132a8eec70e72aa8344e25a', 62);

--  Changeset changelog.groovy::1411567147723-148::rvsz (generated)::(Checksum: 3:368c92bde52df7596c1884cc17eb9dbd)
CREATE INDEX `FK6F064E36E31CB353` ON `default_images`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-148', '2.0.5', '3:368c92bde52df7596c1884cc17eb9dbd', 63);

--  Changeset changelog.groovy::1411567147723-149::rvsz (generated)::(Checksum: 3:c20e3fcbf94b7ee34bafa868f5ff532e)
CREATE INDEX `FKB95A82787666C6D2` ON `images`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-149', '2.0.5', '3:c20e3fcbf94b7ee34bafa868f5ff532e', 64);

--  Changeset changelog.groovy::1411567147723-150::rvsz (generated)::(Checksum: 3:46dab07a3d1de65cbf5b2956e3a2ee01)
CREATE INDEX `FKB95A8278E31CB353` ON `images`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-150', '2.0.5', '3:46dab07a3d1de65cbf5b2956e3a2ee01', 65);

--  Changeset changelog.groovy::1411567147723-151::rvsz (generated)::(Checksum: 3:e475b5a5ca65790a54c912c5cd65a287)
CREATE INDEX `FK578EF9DF7666C6D2` ON `import_task`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-151', '2.0.5', '3:e475b5a5ca65790a54c912c5cd65a287', 66);

--  Changeset changelog.groovy::1411567147723-152::rvsz (generated)::(Checksum: 3:d773200555e5793c5e27a8c6fa8d54e0)
CREATE INDEX `FK578EF9DF919216CA` ON `import_task`(`last_run_result_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-152', '2.0.5', '3:d773200555e5793c5e27a8c6fa8d54e0', 67);

--  Changeset changelog.groovy::1411567147723-153::rvsz (generated)::(Checksum: 3:f6d85e029b667280369a6867789c5ccf)
CREATE INDEX `FK578EF9DFA31F8712` ON `import_task`(`interface_config_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-153', '2.0.5', '3:f6d85e029b667280369a6867789c5ccf', 68);

--  Changeset changelog.groovy::1411567147723-154::rvsz (generated)::(Checksum: 3:48d37681ca109e398516905127ed656f)
CREATE INDEX `FK578EF9DFE31CB353` ON `import_task`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-154', '2.0.5', '3:48d37681ca109e398516905127ed656f', 69);

--  Changeset changelog.groovy::1411567147723-155::rvsz (generated)::(Checksum: 3:3805ec25cf8f12538ef64122bfbdf9bd)
CREATE UNIQUE INDEX `name_uniq_1411567147591` ON `import_task`(`name`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-155', '2.0.5', '3:3805ec25cf8f12538ef64122bfbdf9bd', 70);

--  Changeset changelog.groovy::1411567147723-156::rvsz (generated)::(Checksum: 3:29ff752ab0cdf12650641dc76818f414)
CREATE INDEX `FK983AC27D11D7F882` ON `import_task_result`(`task_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-156', '2.0.5', '3:29ff752ab0cdf12650641dc76818f414', 71);

--  Changeset changelog.groovy::1411567147723-157::rvsz (generated)::(Checksum: 3:92fbb2f899780719b54ccc740c0cb0a0)
CREATE INDEX `FKB971369C7666C6D2` ON `intent`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-157', '2.0.5', '3:92fbb2f899780719b54ccc740c0cb0a0', 72);

--  Changeset changelog.groovy::1411567147723-158::rvsz (generated)::(Checksum: 3:6caefac8c527462edff8c85539c23fca)
CREATE INDEX `FKB971369CE31CB353` ON `intent`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-158', '2.0.5', '3:6caefac8c527462edff8c85539c23fca', 73);

--  Changeset changelog.groovy::1411567147723-159::rvsz (generated)::(Checksum: 3:05951fcc39aab622143a67676ba4b51e)
CREATE UNIQUE INDEX `UKc7042bb056f010832f67f6c69a3e` ON `intent`(`type`, `action`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-159', '2.0.5', '3:05951fcc39aab622143a67676ba4b51e', 74);

--  Changeset changelog.groovy::1411567147723-160::rvsz (generated)::(Checksum: 3:746e27fa81fd626ea797dc77b328d7bc)
CREATE INDEX `FKE6D04D335A032135` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-160', '2.0.5', '3:746e27fa81fd626ea797dc77b328d7bc', 75);

--  Changeset changelog.groovy::1411567147723-161::rvsz (generated)::(Checksum: 3:1b1fd7174764d6af9ff51dbfbd268461)
CREATE INDEX `FKE6D04D337666C6D2` ON `item_comment`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-161', '2.0.5', '3:1b1fd7174764d6af9ff51dbfbd268461', 76);

--  Changeset changelog.groovy::1411567147723-162::rvsz (generated)::(Checksum: 3:5e7c7f7f791d99b2ec4f4b1d602ddc9d)
CREATE INDEX `FKE6D04D33C7E5C662` ON `item_comment`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-162', '2.0.5', '3:5e7c7f7f791d99b2ec4f4b1d602ddc9d', 77);

--  Changeset changelog.groovy::1411567147723-163::rvsz (generated)::(Checksum: 3:d5b9eff22304b8c7744e69c46394e893)
CREATE INDEX `FKE6D04D33E31CB353` ON `item_comment`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-163', '2.0.5', '3:d5b9eff22304b8c7744e69c46394e893', 78);

--  Changeset changelog.groovy::1411567147723-164::rvsz (generated)::(Checksum: 3:53e54435435f21a79bf181d81074de52)
CREATE INDEX `itm_cmnt_author_id_idx` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-164', '2.0.5', '3:53e54435435f21a79bf181d81074de52', 79);

--  Changeset changelog.groovy::1411567147723-165::rvsz (generated)::(Checksum: 3:4606fad8fc3f6b329467524f6fa00df7)
CREATE INDEX `itm_cmnt_svc_item_id_idx` ON `item_comment`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-165', '2.0.5', '3:4606fad8fc3f6b329467524f6fa00df7', 80);

--  Changeset changelog.groovy::1411567147723-166::rvsz (generated)::(Checksum: 3:15a82e4f6a017553119b100b7cf21de0)
CREATE INDEX `FK999DCD2AC0565C57` ON `iwc_data_object`(`profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-166', '2.0.5', '3:15a82e4f6a017553119b100b7cf21de0', 81);

--  Changeset changelog.groovy::1411567147723-167::rvsz (generated)::(Checksum: 3:60a71c2d6c71ad1731a90545b241a302)
CREATE UNIQUE INDEX `UKe1b86bb7cb89802b84044c6be65a` ON `iwc_data_object`(`key`, `profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-167', '2.0.5', '3:60a71c2d6c71ad1731a90545b241a302', 82);

--  Changeset changelog.groovy::1411567147723-168::rvsz (generated)::(Checksum: 3:3b17dd5dad914166672e096855ce8323)
CREATE INDEX `FKE68D3F71C359936F` ON `modify_relationship_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-168', '2.0.5', '3:3b17dd5dad914166672e096855ce8323', 83);

--  Changeset changelog.groovy::1411567147723-169::rvsz (generated)::(Checksum: 3:5c87cefb070afe5245df49edcdf6d6bc)
CREATE INDEX `FKED8E89A97666C6D2` ON `profile`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-169', '2.0.5', '3:5c87cefb070afe5245df49edcdf6d6bc', 84);

--  Changeset changelog.groovy::1411567147723-170::rvsz (generated)::(Checksum: 3:0b1b62581a385869ec370e81caf41d45)
CREATE INDEX `FKED8E89A9E31CB353` ON `profile`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-170', '2.0.5', '3:0b1b62581a385869ec370e81caf41d45', 85);

--  Changeset changelog.groovy::1411567147723-171::rvsz (generated)::(Checksum: 3:9c0dd9d9b76b8f9ae765c0afa83a77de)
CREATE UNIQUE INDEX `username_uniq_1411567147609` ON `profile`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-171', '2.0.5', '3:9c0dd9d9b76b8f9ae765c0afa83a77de', 86);

--  Changeset changelog.groovy::1411567147723-172::rvsz (generated)::(Checksum: 3:84cd018aad5d29ed7a1e3cbf6a53bf20)
CREATE UNIQUE INDEX `uuid_uniq_1411567147609` ON `profile`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-172', '2.0.5', '3:84cd018aad5d29ed7a1e3cbf6a53bf20', 87);

--  Changeset changelog.groovy::1411567147723-173::rvsz (generated)::(Checksum: 3:09e58be94988e1f6565c24d41b386a7d)
CREATE INDEX `FKB82D0F5B143B24BD` ON `profile_agency`(`agency_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-173', '2.0.5', '3:09e58be94988e1f6565c24d41b386a7d', 88);

--  Changeset changelog.groovy::1411567147723-174::rvsz (generated)::(Checksum: 3:b5a18621c3113ff14437c2f704dbd05d)
CREATE INDEX `FKB82D0F5B7AA654D6` ON `profile_agency`(`profile_organizations_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-174', '2.0.5', '3:b5a18621c3113ff14437c2f704dbd05d', 89);

--  Changeset changelog.groovy::1411567147723-175::rvsz (generated)::(Checksum: 3:cca6c45c54b91151bc21e28f8459e6b5)
CREATE INDEX `FKF35C128582548A4A` ON `rejection_activity`(`rejection_listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-175', '2.0.5', '3:cca6c45c54b91151bc21e28f8459e6b5', 90);

--  Changeset changelog.groovy::1411567147723-176::rvsz (generated)::(Checksum: 3:81e04eaf534d41090afd6f3e5f333ba6)
CREATE INDEX `FKF35C1285C359936F` ON `rejection_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-176', '2.0.5', '3:81e04eaf534d41090afd6f3e5f333ba6', 91);

--  Changeset changelog.groovy::1411567147723-177::rvsz (generated)::(Checksum: 3:83bf85c9a6c11a66907396db59b6627c)
CREATE INDEX `FK12B0A53C7666C6D2` ON `rejection_justification`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-177', '2.0.5', '3:83bf85c9a6c11a66907396db59b6627c', 92);

--  Changeset changelog.groovy::1411567147723-178::rvsz (generated)::(Checksum: 3:7fbdaa45ba2134fba5cf706566f0ddae)
CREATE INDEX `FK12B0A53CE31CB353` ON `rejection_justification`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-178', '2.0.5', '3:7fbdaa45ba2134fba5cf706566f0ddae', 93);

--  Changeset changelog.groovy::1411567147723-179::rvsz (generated)::(Checksum: 3:ebe7a93726788a3caaf908927e019a5b)
CREATE INDEX `FK3F2BD44E19CEB614` ON `rejection_listing`(`justification_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-179', '2.0.5', '3:ebe7a93726788a3caaf908927e019a5b', 94);

--  Changeset changelog.groovy::1411567147723-180::rvsz (generated)::(Checksum: 3:66b6585c51649bacba538f21c706a430)
CREATE INDEX `FK3F2BD44E5A032135` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-180', '2.0.5', '3:66b6585c51649bacba538f21c706a430', 95);

--  Changeset changelog.groovy::1411567147723-181::rvsz (generated)::(Checksum: 3:d1f5b33deb169eb9fb0458e7e8b64541)
CREATE INDEX `FK3F2BD44E7666C6D2` ON `rejection_listing`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-181', '2.0.5', '3:d1f5b33deb169eb9fb0458e7e8b64541', 96);

--  Changeset changelog.groovy::1411567147723-182::rvsz (generated)::(Checksum: 3:8a6952f66b99f36f0c78e74b3f399f60)
CREATE INDEX `FK3F2BD44EC7E5C662` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-182', '2.0.5', '3:8a6952f66b99f36f0c78e74b3f399f60', 97);

--  Changeset changelog.groovy::1411567147723-183::rvsz (generated)::(Checksum: 3:3ff4107bb95921b20fdbf01b1089ce2e)
CREATE INDEX `FK3F2BD44EE31CB353` ON `rejection_listing`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-183', '2.0.5', '3:3ff4107bb95921b20fdbf01b1089ce2e', 98);

--  Changeset changelog.groovy::1411567147723-184::rvsz (generated)::(Checksum: 3:43678308dc3a992c28f53b4efeb30268)
CREATE INDEX `rej_lst_author_id_idx` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-184', '2.0.5', '3:43678308dc3a992c28f53b4efeb30268', 99);

--  Changeset changelog.groovy::1411567147723-185::rvsz (generated)::(Checksum: 3:185f7cfc5e4834a552850a563be01129)
CREATE INDEX `rej_lst_svc_item_id_idx` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-185', '2.0.5', '3:185f7cfc5e4834a552850a563be01129', 100);

--  Changeset changelog.groovy::1411567147723-186::rvsz (generated)::(Checksum: 3:e531cf4217a675f3d14c4e90f894861c)
CREATE INDEX `FKF06476389D70DD39` ON `relationship`(`owning_entity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-186', '2.0.5', '3:e531cf4217a675f3d14c4e90f894861c', 101);

--  Changeset changelog.groovy::1411567147723-187::rvsz (generated)::(Checksum: 3:1faa9525346fa580489e9fd365af971c)
CREATE INDEX `FK594974BB25A20F9D` ON `relationship_activity_log`(`service_item_snapshot_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-187', '2.0.5', '3:1faa9525346fa580489e9fd365af971c', 102);

--  Changeset changelog.groovy::1411567147723-188::rvsz (generated)::(Checksum: 3:eec26c4329ec72cbffdd562127545f6e)
CREATE INDEX `FKDA02504C7E5C662` ON `relationship_service_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-188', '2.0.5', '3:eec26c4329ec72cbffdd562127545f6e', 103);

--  Changeset changelog.groovy::1411567147723-189::rvsz (generated)::(Checksum: 3:17c02086fe38b487303c08354f695f76)
CREATE INDEX `FKE51CCD757666C6D2` ON `score_card_item`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-189', '2.0.5', '3:17c02086fe38b487303c08354f695f76', 104);

--  Changeset changelog.groovy::1411567147723-190::rvsz (generated)::(Checksum: 3:cacaa1fa165b5dc021388e8e5e10cc27)
CREATE INDEX `FKE51CCD75E31CB353` ON `score_card_item`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-190', '2.0.5', '3:cacaa1fa165b5dc021388e8e5e10cc27', 105);

--  Changeset changelog.groovy::1411567147723-191::rvsz (generated)::(Checksum: 3:1aba62ac454620082692f1eaa640f99f)
CREATE INDEX `FKE72D85667666C6D2` ON `screenshot`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-191', '2.0.5', '3:1aba62ac454620082692f1eaa640f99f', 106);

--  Changeset changelog.groovy::1411567147723-192::rvsz (generated)::(Checksum: 3:2cc546119189c2df9dde5afff248114d)
CREATE INDEX `FKE72D8566C7E5C662` ON `screenshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-192', '2.0.5', '3:2cc546119189c2df9dde5afff248114d', 107);

--  Changeset changelog.groovy::1411567147723-193::rvsz (generated)::(Checksum: 3:07741cdcf1099bf19899e2737d826d46)
CREATE INDEX `FKE72D8566E31CB353` ON `screenshot`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-193', '2.0.5', '3:07741cdcf1099bf19899e2737d826d46', 108);

--  Changeset changelog.groovy::1411567147723-194::rvsz (generated)::(Checksum: 3:d15412c9f28d673fc8d213e522b6cdfb)
CREATE INDEX `FK1571565D143B24BD` ON `service_item`(`agency_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-194', '2.0.5', '3:d15412c9f28d673fc8d213e522b6cdfb', 109);

--  Changeset changelog.groovy::1411567147723-195::rvsz (generated)::(Checksum: 3:b5af36144e5852c582747a2fcad614ca)
CREATE INDEX `FK1571565D2746B676` ON `service_item`(`last_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-195', '2.0.5', '3:b5af36144e5852c582747a2fcad614ca', 110);

--  Changeset changelog.groovy::1411567147723-196::rvsz (generated)::(Checksum: 3:30f6bc4f2460377ef735477afe4d5cc3)
CREATE INDEX `FK1571565D5E919B36` ON `service_item`(`type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-196', '2.0.5', '3:30f6bc4f2460377ef735477afe4d5cc3', 111);

--  Changeset changelog.groovy::1411567147723-197::rvsz (generated)::(Checksum: 3:22143e9523ef163f696b8b0d6715e928)
CREATE INDEX `FK1571565D7666C6D2` ON `service_item`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-197', '2.0.5', '3:22143e9523ef163f696b8b0d6715e928', 112);

--  Changeset changelog.groovy::1411567147723-198::rvsz (generated)::(Checksum: 3:a689381710b81e66e508d4431066249e)
CREATE INDEX `FK1571565DE31CB353` ON `service_item`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-198', '2.0.5', '3:a689381710b81e66e508d4431066249e', 113);

--  Changeset changelog.groovy::1411567147723-199::rvsz (generated)::(Checksum: 3:6004d165f74d01f95d179c70bfdf4da9)
CREATE INDEX `FK870EA6B15A032135` ON `service_item_activity`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-199', '2.0.5', '3:6004d165f74d01f95d179c70bfdf4da9', 114);

--  Changeset changelog.groovy::1411567147723-200::rvsz (generated)::(Checksum: 3:1f03b1ee01724c9a3fe8a8ff2830b510)
CREATE INDEX `FK870EA6B17666C6D2` ON `service_item_activity`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-200', '2.0.5', '3:1f03b1ee01724c9a3fe8a8ff2830b510', 115);

--  Changeset changelog.groovy::1411567147723-201::rvsz (generated)::(Checksum: 3:bdce4184a5244cd4570fcb5d3ce73a89)
CREATE INDEX `FK870EA6B1C7E5C662` ON `service_item_activity`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-201', '2.0.5', '3:bdce4184a5244cd4570fcb5d3ce73a89', 116);

--  Changeset changelog.groovy::1411567147723-202::rvsz (generated)::(Checksum: 3:dc06d43ca4f59b935996549e400ca07e)
CREATE INDEX `FK870EA6B1E31CB353` ON `service_item_activity`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-202', '2.0.5', '3:dc06d43ca4f59b935996549e400ca07e', 117);

--  Changeset changelog.groovy::1411567147723-203::rvsz (generated)::(Checksum: 3:ada5f8ad85b60287a404e1176b07500d)
CREATE INDEX `svc_item_act_svc_item_id_idx` ON `service_item_activity`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-203', '2.0.5', '3:ada5f8ad85b60287a404e1176b07500d', 118);

--  Changeset changelog.groovy::1411567147723-204::rvsz (generated)::(Checksum: 3:d6a74149c6c3c682c80a4e0f6c0b02da)
CREATE INDEX `FKECC570A0D8528BE1` ON `service_item_category`(`service_item_categories_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-204', '2.0.5', '3:d6a74149c6c3c682c80a4e0f6c0b02da', 119);

--  Changeset changelog.groovy::1411567147723-205::rvsz (generated)::(Checksum: 3:a2ca461c41d1b5693ab2ef4b2094f123)
CREATE INDEX `FKECC570A0DA41995D` ON `service_item_category`(`category_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-205', '2.0.5', '3:a2ca461c41d1b5693ab2ef4b2094f123', 120);

--  Changeset changelog.groovy::1411567147723-206::rvsz (generated)::(Checksum: 3:ec179899b5e9feb38497778d3cda2843)
CREATE INDEX `FK24572D08C7E5C662` ON `service_item_documentation_url`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-206', '2.0.5', '3:ec179899b5e9feb38497778d3cda2843', 121);

--  Changeset changelog.groovy::1411567147723-207::rvsz (generated)::(Checksum: 3:7c46612517657a80a58f247e9649991e)
CREATE INDEX `FKEFDCED75A651895D` ON `service_item_intents`(`intent_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-207', '2.0.5', '3:7c46612517657a80a58f247e9649991e', 122);

--  Changeset changelog.groovy::1411567147723-208::rvsz (generated)::(Checksum: 3:323621cc55435c222d21499c58a05d4e)
CREATE INDEX `FKEFDCED75C7E5C662` ON `service_item_intents`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-208', '2.0.5', '3:323621cc55435c222d21499c58a05d4e', 123);

--  Changeset changelog.groovy::1411567147723-209::rvsz (generated)::(Checksum: 3:388cccadd42e1ecc564a22f1fa17cb62)
CREATE INDEX `FK68B5D9C7C0565C57` ON `service_item_profile`(`profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-209', '2.0.5', '3:388cccadd42e1ecc564a22f1fa17cb62', 124);

--  Changeset changelog.groovy::1411567147723-210::rvsz (generated)::(Checksum: 3:a8a1f0d5f87c10abc33e1884fb78839f)
CREATE INDEX `FK68B5D9C7C761FE5D` ON `service_item_profile`(`service_item_owners_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-210', '2.0.5', '3:a8a1f0d5f87c10abc33e1884fb78839f', 125);

--  Changeset changelog.groovy::1411567147723-211::rvsz (generated)::(Checksum: 3:ea1926e5c79b5a033cffde87f8aa26ff)
CREATE INDEX `FKBF91F93C7E5C662` ON `service_item_score_card_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-211', '2.0.5', '3:ea1926e5c79b5a033cffde87f8aa26ff', 126);

--  Changeset changelog.groovy::1411567147723-212::rvsz (generated)::(Checksum: 3:be4de13c1852275e6fff82ba79a8dd73)
CREATE INDEX `FKBF91F93EF469C97` ON `service_item_score_card_item`(`score_card_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-212', '2.0.5', '3:be4de13c1852275e6fff82ba79a8dd73', 127);

--  Changeset changelog.groovy::1411567147723-213::rvsz (generated)::(Checksum: 3:141e9c5ecb54e8040b6ec121228d240f)
CREATE INDEX `FKFABD8966C7E5C662` ON `service_item_snapshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-213', '2.0.5', '3:141e9c5ecb54e8040b6ec121228d240f', 128);

--  Changeset changelog.groovy::1411567147723-214::rvsz (generated)::(Checksum: 3:a8f6191ffd749f20bebf9ad01e772a2a)
CREATE INDEX `FKB621CEB87666C6D2` ON `service_item_tag`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-214', '2.0.5', '3:a8f6191ffd749f20bebf9ad01e772a2a', 129);

--  Changeset changelog.groovy::1411567147723-215::rvsz (generated)::(Checksum: 3:fc4ea713c366d3ccb6ed9caad9277cff)
CREATE INDEX `FKB621CEB8C7E5C662` ON `service_item_tag`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-215', '2.0.5', '3:fc4ea713c366d3ccb6ed9caad9277cff', 130);

--  Changeset changelog.groovy::1411567147723-216::rvsz (generated)::(Checksum: 3:4ecb4043bf1621226f26f0211c0e1d57)
CREATE INDEX `FKB621CEB8EACAF137` ON `service_item_tag`(`tag_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-216', '2.0.5', '3:4ecb4043bf1621226f26f0211c0e1d57', 131);

--  Changeset changelog.groovy::1411567147723-217::rvsz (generated)::(Checksum: 3:a2bf898fbf28dd52154b91af99ce8816)
CREATE INDEX `service_item_tag_si_idx` ON `service_item_tag`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-217', '2.0.5', '3:a2bf898fbf28dd52154b91af99ce8816', 132);

--  Changeset changelog.groovy::1411567147723-218::rvsz (generated)::(Checksum: 3:9f8b05253fb908abeb7b99d7e9ccbd70)
CREATE INDEX `service_item_tag_tag_idx` ON `service_item_tag`(`tag_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-218', '2.0.5', '3:9f8b05253fb908abeb7b99d7e9ccbd70', 133);

--  Changeset changelog.groovy::1411567147723-219::rvsz (generated)::(Checksum: 3:626d6d510df5a61ab65cdbacccb51282)
CREATE INDEX `FKE1808BBC7E5C662` ON `service_item_tags`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-219', '2.0.5', '3:626d6d510df5a61ab65cdbacccb51282', 134);

--  Changeset changelog.groovy::1411567147723-220::rvsz (generated)::(Checksum: 3:a3cba4f130b80b40bedb769eaa4ee13c)
CREATE INDEX `FK1BF9A7666C6D2` ON `tag`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-220', '2.0.5', '3:a3cba4f130b80b40bedb769eaa4ee13c', 135);

--  Changeset changelog.groovy::1411567147723-221::rvsz (generated)::(Checksum: 3:f5b5e5ee65a5550134c610491eea06ba)
CREATE INDEX `FK1BF9AE31CB353` ON `tag`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-221', '2.0.5', '3:f5b5e5ee65a5550134c610491eea06ba', 136);

--  Changeset changelog.groovy::1411567147723-222::rvsz (generated)::(Checksum: 3:d0c633c5b1178d842b342f18069da043)
CREATE INDEX `tag_title_idx` ON `tag`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-222', '2.0.5', '3:d0c633c5b1178d842b342f18069da043', 137);

--  Changeset changelog.groovy::1411567147723-223::rvsz (generated)::(Checksum: 3:709665e6e4014859030edbb911f7051a)
CREATE INDEX `FK69B5879553AF61A` ON `types`(`image_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-223', '2.0.5', '3:709665e6e4014859030edbb911f7051a', 138);

--  Changeset changelog.groovy::1411567147723-224::rvsz (generated)::(Checksum: 3:a5f7dd6bfb32a1292256946a54571082)
CREATE INDEX `FK69B58797666C6D2` ON `types`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-224', '2.0.5', '3:a5f7dd6bfb32a1292256946a54571082', 139);

--  Changeset changelog.groovy::1411567147723-225::rvsz (generated)::(Checksum: 3:9681cebbda3cad5a4da8675b975b01b5)
CREATE INDEX `FK69B5879E31CB353` ON `types`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-225', '2.0.5', '3:9681cebbda3cad5a4da8675b975b01b5', 140);

--  Changeset changelog.groovy::1411567147723-226::rvsz (generated)::(Checksum: 3:4ed5a241646ebbc1b8a4db149a55a06b)
CREATE UNIQUE INDEX `uuid_uniq_1411567147632` ON `types`(`uuid`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1411567147723-226', '2.0.5', '3:4ed5a241646ebbc1b8a4db149a55a06b', 141);

--  Changeset changelog.groovy::1411567147723-40::rvsz (generated)::(Checksum: 3:012c519b42c92bf84f67dd2a9e3cbf61)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C37666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-40', '2.0.5', '3:012c519b42c92bf84f67dd2a9e3cbf61', 142);

--  Changeset changelog.groovy::1411567147723-41::rvsz (generated)::(Checksum: 3:fd91bd2d780f57b6090c3fca7918e9f1)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C3E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-41', '2.0.5', '3:fd91bd2d780f57b6090c3fca7918e9f1', 143);

--  Changeset changelog.groovy::1411567147723-42::rvsz (generated)::(Checksum: 3:d0718262545ecb537e4494bbe1692c0e)
ALTER TABLE `affiliated_marketplace` ADD CONSTRAINT `FKA6EB2C3EA25263C` FOREIGN KEY (`icon_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-42', '2.0.5', '3:d0718262545ecb537e4494bbe1692c0e', 144);

--  Changeset changelog.groovy::1411567147723-43::rvsz (generated)::(Checksum: 3:c0e9894b976dceb09fc43de299f992a7)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C057666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-43', '2.0.5', '3:c0e9894b976dceb09fc43de299f992a7', 145);

--  Changeset changelog.groovy::1411567147723-44::rvsz (generated)::(Checksum: 3:34b4d2a4851521abae8cfaa2fe8f4b9a)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C05E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-44', '2.0.5', '3:34b4d2a4851521abae8cfaa2fe8f4b9a', 146);

--  Changeset changelog.groovy::1411567147723-45::rvsz (generated)::(Checksum: 3:2d69ea1f6f5ec06c1cec4b7e0cac0c5e)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-45', '2.0.5', '3:2d69ea1f6f5ec06c1cec4b7e0cac0c5e', 147);

--  Changeset changelog.groovy::1411567147723-46::rvsz (generated)::(Checksum: 3:9136a33397c8aed3476e08179ebdc62e)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233FE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-46', '2.0.5', '3:9136a33397c8aed3476e08179ebdc62e', 148);

--  Changeset changelog.groovy::1411567147723-47::rvsz (generated)::(Checksum: 3:5f80a5c2d662b3519c257c5b47e9eab2)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F6530DF0D` FOREIGN KEY (`owner_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-47', '2.0.5', '3:5f80a5c2d662b3519c257c5b47e9eab2', 149);

--  Changeset changelog.groovy::1411567147723-48::rvsz (generated)::(Checksum: 3:212e46190588a8f6acabfd35c30965a6)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233FC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-48', '2.0.5', '3:212e46190588a8f6acabfd35c30965a6', 150);

--  Changeset changelog.groovy::1411567147723-49::rvsz (generated)::(Checksum: 3:0919cac3b93d89e27f450a3f42822f00)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFE7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-49', '2.0.5', '3:0919cac3b93d89e27f450a3f42822f00', 151);

--  Changeset changelog.groovy::1411567147723-50::rvsz (generated)::(Checksum: 3:7f041c5ab327f9e6925e7d44efe00d89)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFEE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-50', '2.0.5', '3:7f041c5ab327f9e6925e7d44efe00d89', 152);

--  Changeset changelog.groovy::1411567147723-51::rvsz (generated)::(Checksum: 3:ce8d88a6a0824410fe1e2e2951f36f9f)
ALTER TABLE `change_detail` ADD CONSTRAINT `FKB4467BC0855307BD` FOREIGN KEY (`service_item_activity_id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-51', '2.0.5', '3:ce8d88a6a0824410fe1e2e2951f36f9f', 153);

--  Changeset changelog.groovy::1411567147723-52::rvsz (generated)::(Checksum: 3:f0906f0eb39b2202ecb84c2bca907d03)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B724207666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-52', '2.0.5', '3:f0906f0eb39b2202ecb84c2bca907d03', 154);

--  Changeset changelog.groovy::1411567147723-53::rvsz (generated)::(Checksum: 3:9ee958dc651da79e1462035ba353b6e0)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-53', '2.0.5', '3:9ee958dc651da79e1462035ba353b6e0', 155);

--  Changeset changelog.groovy::1411567147723-54::rvsz (generated)::(Checksum: 3:71e66a1509610c829680c54601e03968)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-54', '2.0.5', '3:71e66a1509610c829680c54601e03968', 156);

--  Changeset changelog.groovy::1411567147723-55::rvsz (generated)::(Checksum: 3:432fc8bd066d7de72903ae07ec4536f8)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420BA3FC877` FOREIGN KEY (`type_id`) REFERENCES `contact_type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-55', '2.0.5', '3:432fc8bd066d7de72903ae07ec4536f8', 157);

--  Changeset changelog.groovy::1411567147723-56::rvsz (generated)::(Checksum: 3:789dc9c339f5d808bbdaf6d72db916fe)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-56', '2.0.5', '3:789dc9c339f5d808bbdaf6d72db916fe', 158);

--  Changeset changelog.groovy::1411567147723-57::rvsz (generated)::(Checksum: 3:3225c8cbdce1d11887d89fd757132306)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-57', '2.0.5', '3:3225c8cbdce1d11887d89fd757132306', 159);

--  Changeset changelog.groovy::1411567147723-58::rvsz (generated)::(Checksum: 3:f388279add0481baf5b16aae01eb7caf)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E367666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-58', '2.0.5', '3:f388279add0481baf5b16aae01eb7caf', 160);

--  Changeset changelog.groovy::1411567147723-59::rvsz (generated)::(Checksum: 3:81a126fb14af66e94b9a936a519c746a)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E36E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-59', '2.0.5', '3:81a126fb14af66e94b9a936a519c746a', 161);

--  Changeset changelog.groovy::1411567147723-60::rvsz (generated)::(Checksum: 3:b6d10278dcdd65a228aa56ac8eb98130)
ALTER TABLE `default_images` ADD CONSTRAINT `FK6F064E36553AF61A` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-60', '2.0.5', '3:b6d10278dcdd65a228aa56ac8eb98130', 162);

--  Changeset changelog.groovy::1411567147723-61::rvsz (generated)::(Checksum: 3:ee236b44ab2604a6b9e4dab9d16f6776)
ALTER TABLE `images` ADD CONSTRAINT `FKB95A82787666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-61', '2.0.5', '3:ee236b44ab2604a6b9e4dab9d16f6776', 163);

--  Changeset changelog.groovy::1411567147723-62::rvsz (generated)::(Checksum: 3:d71a96f57177f3c83d8443003f0762d3)
ALTER TABLE `images` ADD CONSTRAINT `FKB95A8278E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-62', '2.0.5', '3:d71a96f57177f3c83d8443003f0762d3', 164);

--  Changeset changelog.groovy::1411567147723-63::rvsz (generated)::(Checksum: 3:ab74cd9c2a3eb6f9202405f2a97c77f3)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DF7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-63', '2.0.5', '3:ab74cd9c2a3eb6f9202405f2a97c77f3', 165);

--  Changeset changelog.groovy::1411567147723-64::rvsz (generated)::(Checksum: 3:d4c54fc15156503d313674ee383964d6)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DFE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-64', '2.0.5', '3:d4c54fc15156503d313674ee383964d6', 166);

--  Changeset changelog.groovy::1411567147723-65::rvsz (generated)::(Checksum: 3:d587bb9a0b5867061074afb55d11e6e4)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DFA31F8712` FOREIGN KEY (`interface_config_id`) REFERENCES `interface_configuration` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-65', '2.0.5', '3:d587bb9a0b5867061074afb55d11e6e4', 167);

--  Changeset changelog.groovy::1411567147723-66::rvsz (generated)::(Checksum: 3:5c0e970a1863f996de204b720c49c413)
ALTER TABLE `import_task` ADD CONSTRAINT `FK578EF9DF919216CA` FOREIGN KEY (`last_run_result_id`) REFERENCES `import_task_result` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-66', '2.0.5', '3:5c0e970a1863f996de204b720c49c413', 168);

--  Changeset changelog.groovy::1411567147723-67::rvsz (generated)::(Checksum: 3:a053bceea35c1cbd0f4a17b486466d55)
ALTER TABLE `import_task_result` ADD CONSTRAINT `FK983AC27D11D7F882` FOREIGN KEY (`task_id`) REFERENCES `import_task` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-67', '2.0.5', '3:a053bceea35c1cbd0f4a17b486466d55', 169);

--  Changeset changelog.groovy::1411567147723-68::rvsz (generated)::(Checksum: 3:fde98c8a0d1e864c6a82ad6e6af9795e)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-68', '2.0.5', '3:fde98c8a0d1e864c6a82ad6e6af9795e', 170);

--  Changeset changelog.groovy::1411567147723-69::rvsz (generated)::(Checksum: 3:a96ec94441f5d31aff93ea7dc023d833)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-69', '2.0.5', '3:a96ec94441f5d31aff93ea7dc023d833', 171);

--  Changeset changelog.groovy::1411567147723-70::rvsz (generated)::(Checksum: 3:a44ccb86429d03ec4fea4a898375f590)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D335A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-70', '2.0.5', '3:a44ccb86429d03ec4fea4a898375f590', 172);

--  Changeset changelog.groovy::1411567147723-71::rvsz (generated)::(Checksum: 3:48e7833bd349bbe1a7a03a7c6d8246b0)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D337666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-71', '2.0.5', '3:48e7833bd349bbe1a7a03a7c6d8246b0', 173);

--  Changeset changelog.groovy::1411567147723-72::rvsz (generated)::(Checksum: 3:704e07f94eb1a0c534dd728f8c94cede)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-72', '2.0.5', '3:704e07f94eb1a0c534dd728f8c94cede', 174);

--  Changeset changelog.groovy::1411567147723-73::rvsz (generated)::(Checksum: 3:e75f65a25771c68ccb85c095a5bb6c66)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-73', '2.0.5', '3:e75f65a25771c68ccb85c095a5bb6c66', 175);

--  Changeset changelog.groovy::1411567147723-74::rvsz (generated)::(Checksum: 3:0af0fe1989c45366ca360b09e816f878)
ALTER TABLE `iwc_data_object` ADD CONSTRAINT `FK999DCD2AC0565C57` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-74', '2.0.5', '3:0af0fe1989c45366ca360b09e816f878', 176);

--  Changeset changelog.groovy::1411567147723-75::rvsz (generated)::(Checksum: 3:39ddedf5e6c93bded7890f9b5d858211)
ALTER TABLE `modify_relationship_activity` ADD CONSTRAINT `FKE68D3F71C359936F` FOREIGN KEY (`id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-75', '2.0.5', '3:39ddedf5e6c93bded7890f9b5d858211', 177);

--  Changeset changelog.groovy::1411567147723-76::rvsz (generated)::(Checksum: 3:e86f16463585314b530be5e7573a9296)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-76', '2.0.5', '3:e86f16463585314b530be5e7573a9296', 178);

--  Changeset changelog.groovy::1411567147723-77::rvsz (generated)::(Checksum: 3:c5cba2edf4144c33b909623615472244)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-77', '2.0.5', '3:c5cba2edf4144c33b909623615472244', 179);

--  Changeset changelog.groovy::1411567147723-78::rvsz (generated)::(Checksum: 3:388eb5e35e6a01a8407f4dc7de2c5a86)
ALTER TABLE `profile_agency` ADD CONSTRAINT `FKB82D0F5B143B24BD` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-78', '2.0.5', '3:388eb5e35e6a01a8407f4dc7de2c5a86', 180);

--  Changeset changelog.groovy::1411567147723-79::rvsz (generated)::(Checksum: 3:7524af22a9e28010768d128883f2503d)
ALTER TABLE `profile_agency` ADD CONSTRAINT `FKB82D0F5B7AA654D6` FOREIGN KEY (`profile_organizations_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-79', '2.0.5', '3:7524af22a9e28010768d128883f2503d', 181);

--  Changeset changelog.groovy::1411567147723-80::rvsz (generated)::(Checksum: 3:17af64a271de5d59da444e307e0649f0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C1285C359936F` FOREIGN KEY (`id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-80', '2.0.5', '3:17af64a271de5d59da444e307e0649f0', 182);

--  Changeset changelog.groovy::1411567147723-81::rvsz (generated)::(Checksum: 3:3c8e09e6df0585dccbc5813b6ed69ff0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C128582548A4A` FOREIGN KEY (`rejection_listing_id`) REFERENCES `rejection_listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-81', '2.0.5', '3:3c8e09e6df0585dccbc5813b6ed69ff0', 183);

--  Changeset changelog.groovy::1411567147723-82::rvsz (generated)::(Checksum: 3:c789755760ba85d22170229257e27420)
ALTER TABLE `rejection_justification` ADD CONSTRAINT `FK12B0A53C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-82', '2.0.5', '3:c789755760ba85d22170229257e27420', 184);

--  Changeset changelog.groovy::1411567147723-83::rvsz (generated)::(Checksum: 3:c133b80c0e79f87d2774d50ae9ae913d)
ALTER TABLE `rejection_justification` ADD CONSTRAINT `FK12B0A53CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-83', '2.0.5', '3:c133b80c0e79f87d2774d50ae9ae913d', 185);

--  Changeset changelog.groovy::1411567147723-84::rvsz (generated)::(Checksum: 3:0ec52b0ffac45e2d8b8d25ecdd0b708a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E5A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-84', '2.0.5', '3:0ec52b0ffac45e2d8b8d25ecdd0b708a', 186);

--  Changeset changelog.groovy::1411567147723-85::rvsz (generated)::(Checksum: 3:c4b6c6b7843000ce7af769a43a00eada)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-85', '2.0.5', '3:c4b6c6b7843000ce7af769a43a00eada', 187);

--  Changeset changelog.groovy::1411567147723-86::rvsz (generated)::(Checksum: 3:a5a6551c740e542d7847e4c110846e8a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-86', '2.0.5', '3:a5a6551c740e542d7847e4c110846e8a', 188);

--  Changeset changelog.groovy::1411567147723-87::rvsz (generated)::(Checksum: 3:a4e272508b9e57b1bb808c09137603cd)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E19CEB614` FOREIGN KEY (`justification_id`) REFERENCES `rejection_justification` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-87', '2.0.5', '3:a4e272508b9e57b1bb808c09137603cd', 189);

--  Changeset changelog.groovy::1411567147723-88::rvsz (generated)::(Checksum: 3:2fa419ff4750218d35b68a34d8c3da7b)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-88', '2.0.5', '3:2fa419ff4750218d35b68a34d8c3da7b', 190);

--  Changeset changelog.groovy::1411567147723-89::rvsz (generated)::(Checksum: 3:b07ddeec1bdade32f15ca8148ca1f984)
ALTER TABLE `relationship` ADD CONSTRAINT `FKF06476389D70DD39` FOREIGN KEY (`owning_entity_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-89', '2.0.5', '3:b07ddeec1bdade32f15ca8148ca1f984', 191);

--  Changeset changelog.groovy::1411567147723-90::rvsz (generated)::(Checksum: 3:52fa8b8938c8b9c84ae74abbb0c410a7)
ALTER TABLE `relationship_activity_log` ADD CONSTRAINT `FK594974BB25A20F9D` FOREIGN KEY (`service_item_snapshot_id`) REFERENCES `service_item_snapshot` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-90', '2.0.5', '3:52fa8b8938c8b9c84ae74abbb0c410a7', 192);

--  Changeset changelog.groovy::1411567147723-91::rvsz (generated)::(Checksum: 3:9bbf25bf2c4101144e5dddb1f81e06f1)
ALTER TABLE `relationship_service_item` ADD CONSTRAINT `FKDA02504C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-91', '2.0.5', '3:9bbf25bf2c4101144e5dddb1f81e06f1', 193);

--  Changeset changelog.groovy::1411567147723-92::rvsz (generated)::(Checksum: 3:62ebbecfd4877631ccde6515ed314fc8)
ALTER TABLE `score_card_item` ADD CONSTRAINT `FKE51CCD757666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-92', '2.0.5', '3:62ebbecfd4877631ccde6515ed314fc8', 194);

--  Changeset changelog.groovy::1411567147723-93::rvsz (generated)::(Checksum: 3:ae783dc6290ffe3a26343f83d557b016)
ALTER TABLE `score_card_item` ADD CONSTRAINT `FKE51CCD75E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-93', '2.0.5', '3:ae783dc6290ffe3a26343f83d557b016', 195);

--  Changeset changelog.groovy::1411567147723-94::rvsz (generated)::(Checksum: 3:f6eba1782ecc96476aaeb2674f93d056)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D85667666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-94', '2.0.5', '3:f6eba1782ecc96476aaeb2674f93d056', 196);

--  Changeset changelog.groovy::1411567147723-95::rvsz (generated)::(Checksum: 3:5e3bd661f76ea9ab42001333930a315f)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-95', '2.0.5', '3:5e3bd661f76ea9ab42001333930a315f', 197);

--  Changeset changelog.groovy::1411567147723-96::rvsz (generated)::(Checksum: 3:eedfff3fc77f6b2d0781b36e4cba6fe6)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-96', '2.0.5', '3:eedfff3fc77f6b2d0781b36e4cba6fe6', 198);

--  Changeset changelog.groovy::1411567147723-97::rvsz (generated)::(Checksum: 3:d316ba33a1fcfd9218ff525e7d793c6b)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D143B24BD` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-97', '2.0.5', '3:d316ba33a1fcfd9218ff525e7d793c6b', 199);

--  Changeset changelog.groovy::1411567147723-98::rvsz (generated)::(Checksum: 3:fff97300dc2f8677145823d36c5bbd31)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-98', '2.0.5', '3:fff97300dc2f8677145823d36c5bbd31', 200);

--  Changeset changelog.groovy::1411567147723-99::rvsz (generated)::(Checksum: 3:5941250db3aedcd46e620dde3dd7a1aa)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565DE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-99', '2.0.5', '3:5941250db3aedcd46e620dde3dd7a1aa', 201);

--  Changeset changelog.groovy::1411567147723-100::rvsz (generated)::(Checksum: 3:2eddcdfbdecfb39d6526c001c9dfb658)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D2746B676` FOREIGN KEY (`last_activity_id`) REFERENCES `service_item_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-100', '2.0.5', '3:2eddcdfbdecfb39d6526c001c9dfb658', 202);

--  Changeset changelog.groovy::1411567147723-101::rvsz (generated)::(Checksum: 3:7c0ea5d59bc37787b473dabaa60e4058)
ALTER TABLE `service_item` ADD CONSTRAINT `FK1571565D5E919B36` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-101', '2.0.5', '3:7c0ea5d59bc37787b473dabaa60e4058', 203);

--  Changeset changelog.groovy::1411567147723-102::rvsz (generated)::(Checksum: 3:d936c54eef6b6e964fa5c69c63fbbf67)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B15A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-102', '2.0.5', '3:d936c54eef6b6e964fa5c69c63fbbf67', 204);

--  Changeset changelog.groovy::1411567147723-103::rvsz (generated)::(Checksum: 3:54a152fc18eb6134afd5a80599d7d81c)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B17666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-103', '2.0.5', '3:54a152fc18eb6134afd5a80599d7d81c', 205);

--  Changeset changelog.groovy::1411567147723-104::rvsz (generated)::(Checksum: 3:c7e121efc0ffad4b010d8e0ab4c383fe)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B1E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-104', '2.0.5', '3:c7e121efc0ffad4b010d8e0ab4c383fe', 206);

--  Changeset changelog.groovy::1411567147723-105::rvsz (generated)::(Checksum: 3:7419d815453d39e96aff8aa4369c9adf)
ALTER TABLE `service_item_activity` ADD CONSTRAINT `FK870EA6B1C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-105', '2.0.5', '3:7419d815453d39e96aff8aa4369c9adf', 207);

--  Changeset changelog.groovy::1411567147723-106::rvsz (generated)::(Checksum: 3:79052fcbd1e5106b6ac399b700788437)
ALTER TABLE `service_item_category` ADD CONSTRAINT `FKECC570A0DA41995D` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-106', '2.0.5', '3:79052fcbd1e5106b6ac399b700788437', 208);

--  Changeset changelog.groovy::1411567147723-107::rvsz (generated)::(Checksum: 3:30245c3e05b18c5c335eba5ba4f80834)
ALTER TABLE `service_item_category` ADD CONSTRAINT `FKECC570A0D8528BE1` FOREIGN KEY (`service_item_categories_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-107', '2.0.5', '3:30245c3e05b18c5c335eba5ba4f80834', 209);

--  Changeset changelog.groovy::1411567147723-108::rvsz (generated)::(Checksum: 3:4d420ccbd0ca5606d2adf5d7aac8a36c)
ALTER TABLE `service_item_documentation_url` ADD CONSTRAINT `FK24572D08C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-108', '2.0.5', '3:4d420ccbd0ca5606d2adf5d7aac8a36c', 210);

--  Changeset changelog.groovy::1411567147723-109::rvsz (generated)::(Checksum: 3:a0de5f2d87980a08c4d796f564dfb350)
ALTER TABLE `service_item_intents` ADD CONSTRAINT `FKEFDCED75A651895D` FOREIGN KEY (`intent_id`) REFERENCES `intent` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-109', '2.0.5', '3:a0de5f2d87980a08c4d796f564dfb350', 211);

--  Changeset changelog.groovy::1411567147723-110::rvsz (generated)::(Checksum: 3:3c417255526612fe7231de4e6ce03b1e)
ALTER TABLE `service_item_intents` ADD CONSTRAINT `FKEFDCED75C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-110', '2.0.5', '3:3c417255526612fe7231de4e6ce03b1e', 212);

--  Changeset changelog.groovy::1411567147723-111::rvsz (generated)::(Checksum: 3:59b059175d04680e3e92319c1c79acfc)
ALTER TABLE `service_item_profile` ADD CONSTRAINT `FK68B5D9C7C0565C57` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-111', '2.0.5', '3:59b059175d04680e3e92319c1c79acfc', 213);

--  Changeset changelog.groovy::1411567147723-112::rvsz (generated)::(Checksum: 3:356774cf7229d550cc8ed6e40e0e499e)
ALTER TABLE `service_item_profile` ADD CONSTRAINT `FK68B5D9C7C761FE5D` FOREIGN KEY (`service_item_owners_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-112', '2.0.5', '3:356774cf7229d550cc8ed6e40e0e499e', 214);

--  Changeset changelog.groovy::1411567147723-113::rvsz (generated)::(Checksum: 3:62065e81eb20b63d55a48d9ab351efce)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F93EF469C97` FOREIGN KEY (`score_card_item_id`) REFERENCES `score_card_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-113', '2.0.5', '3:62065e81eb20b63d55a48d9ab351efce', 215);

--  Changeset changelog.groovy::1411567147723-114::rvsz (generated)::(Checksum: 3:0a2d929b0c81ecb716c2135f8a0e73d4)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F93C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-114', '2.0.5', '3:0a2d929b0c81ecb716c2135f8a0e73d4', 216);

--  Changeset changelog.groovy::1411567147723-115::rvsz (generated)::(Checksum: 3:d633ffb580e53186e21ad6bfc6e0f1bd)
ALTER TABLE `service_item_snapshot` ADD CONSTRAINT `FKFABD8966C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-115', '2.0.5', '3:d633ffb580e53186e21ad6bfc6e0f1bd', 217);

--  Changeset changelog.groovy::1411567147723-116::rvsz (generated)::(Checksum: 3:5c07ccda7d132407c1a0a37a4187d936)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB87666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-116', '2.0.5', '3:5c07ccda7d132407c1a0a37a4187d936', 218);

--  Changeset changelog.groovy::1411567147723-117::rvsz (generated)::(Checksum: 3:6c7200bc4927a0e147c68170e94b2013)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB8C7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-117', '2.0.5', '3:6c7200bc4927a0e147c68170e94b2013', 219);

--  Changeset changelog.groovy::1411567147723-118::rvsz (generated)::(Checksum: 3:ac6dd24a2661ca11105ead8109083fca)
ALTER TABLE `service_item_tag` ADD CONSTRAINT `FKB621CEB8EACAF137` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-118', '2.0.5', '3:ac6dd24a2661ca11105ead8109083fca', 220);

--  Changeset changelog.groovy::1411567147723-119::rvsz (generated)::(Checksum: 3:5f9d9a8f96b880c9dbec38391f6a0bb3)
ALTER TABLE `service_item_tags` ADD CONSTRAINT `FKE1808BBC7E5C662` FOREIGN KEY (`service_item_id`) REFERENCES `service_item` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-119', '2.0.5', '3:5f9d9a8f96b880c9dbec38391f6a0bb3', 221);

--  Changeset changelog.groovy::1411567147723-120::rvsz (generated)::(Checksum: 3:bde34c0ea37cc97ff5077237a4a9a9c3)
ALTER TABLE `tag` ADD CONSTRAINT `FK1BF9A7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-120', '2.0.5', '3:bde34c0ea37cc97ff5077237a4a9a9c3', 222);

--  Changeset changelog.groovy::1411567147723-121::rvsz (generated)::(Checksum: 3:1670611fe1b80b5a0c40ce47dd33208f)
ALTER TABLE `tag` ADD CONSTRAINT `FK1BF9AE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-121', '2.0.5', '3:1670611fe1b80b5a0c40ce47dd33208f', 223);

--  Changeset changelog.groovy::1411567147723-122::rvsz (generated)::(Checksum: 3:f9354f4a00ffd1125f4aa8cf8c27f848)
ALTER TABLE `types` ADD CONSTRAINT `FK69B58797666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-122', '2.0.5', '3:f9354f4a00ffd1125f4aa8cf8c27f848', 224);

--  Changeset changelog.groovy::1411567147723-123::rvsz (generated)::(Checksum: 3:83c281fe67e5292b39a09a2c7dc236ef)
ALTER TABLE `types` ADD CONSTRAINT `FK69B5879E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-123', '2.0.5', '3:83c281fe67e5292b39a09a2c7dc236ef', 225);

--  Changeset changelog.groovy::1411567147723-124::rvsz (generated)::(Checksum: 3:038742c298b4d3893f6fd6b1f08dcd53)
ALTER TABLE `types` ADD CONSTRAINT `FK69B5879553AF61A` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1411567147723-124', '2.0.5', '3:038742c298b4d3893f6fd6b1f08dcd53', 226);

