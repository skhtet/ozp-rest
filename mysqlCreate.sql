--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: changelog.groovy
--  Ran at: 10/22/14 1:03 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/ozp_empty
--  Liquibase version: 2.0.5
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE `DATABASECHANGELOGLOCK` (`ID` INT NOT NULL, `LOCKED` TINYINT(1) NOT NULL, `LOCKGRANTED` DATETIME NULL, `LOCKEDBY` VARCHAR(255) NULL, CONSTRAINT `PK_DATABASECHANGELOGLOCK` PRIMARY KEY (`ID`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`) VALUES (1, 0);

--  Lock Database
--  Create Database Change Log Table
CREATE TABLE `DATABASECHANGELOG` (`ID` VARCHAR(63) NOT NULL, `AUTHOR` VARCHAR(63) NOT NULL, `FILENAME` VARCHAR(200) NOT NULL, `DATEEXECUTED` DATETIME NOT NULL, `ORDEREXECUTED` INT NOT NULL, `EXECTYPE` VARCHAR(10) NOT NULL, `MD5SUM` VARCHAR(35) NULL, `DESCRIPTION` VARCHAR(255) NULL, `COMMENTS` VARCHAR(255) NULL, `TAG` VARCHAR(255) NULL, `LIQUIBASE` VARCHAR(20) NULL, CONSTRAINT `PK_DATABASECHANGELOG` PRIMARY KEY (`ID`, `AUTHOR`, `FILENAME`)) ENGINE=InnoDB;

--  Changeset changelog.groovy::1413996929527-1::rvsz (generated)::(Checksum: 3:52fddd2cf936db285bbb0c9da6829b1a)
CREATE TABLE `agency` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon_url` VARCHAR(2083) NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `agencyPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-1', '2.0.5', '3:52fddd2cf936db285bbb0c9da6829b1a', 1);

--  Changeset changelog.groovy::1413996929527-2::rvsz (generated)::(Checksum: 3:ef6300b60ec5ba15b2d608b1d6a85c5f)
CREATE TABLE `application_library_entry` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `folder` VARCHAR(256) NULL, `listing_id` BIGINT NOT NULL, `owner_id` BIGINT NOT NULL, `application_library_idx` INT NULL, CONSTRAINT `application_lPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-2', '2.0.5', '3:ef6300b60ec5ba15b2d608b1d6a85c5f', 2);

--  Changeset changelog.groovy::1413996929527-3::rvsz (generated)::(Checksum: 3:a6c2cc35436120a1897d939e59cd8161)
CREATE TABLE `category` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `categoryPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-3', '2.0.5', '3:a6c2cc35436120a1897d939e59cd8161', 3);

--  Changeset changelog.groovy::1413996929527-4::rvsz (generated)::(Checksum: 3:98e78239cb364b058aa28d438f0a6f3c)
CREATE TABLE `change_detail` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `field_name` VARCHAR(255) NOT NULL, `new_value` VARCHAR(4000) NULL, `old_value` VARCHAR(4000) NULL, `service_item_activity_id` BIGINT NOT NULL, CONSTRAINT `change_detailPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-4', '2.0.5', '3:98e78239cb364b058aa28d438f0a6f3c', 4);

--  Changeset changelog.groovy::1413996929527-5::rvsz (generated)::(Checksum: 3:09d69b1d6d8d37f0eeffd3911da50c85)
CREATE TABLE `contact` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(100) NOT NULL, `listing_id` BIGINT NOT NULL, `name` VARCHAR(100) NOT NULL, `organization` VARCHAR(100) NULL, `secure_phone` VARCHAR(50) NULL, `type_id` BIGINT NOT NULL, `unsecure_phone` VARCHAR(50) NULL, CONSTRAINT `contactPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-5', '2.0.5', '3:09d69b1d6d8d37f0eeffd3911da50c85', 5);

--  Changeset changelog.groovy::1413996929527-6::rvsz (generated)::(Checksum: 3:73e507e6e52c79361a2c768bb9c118df)
CREATE TABLE `contact_type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `required` bit NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `contact_typePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-6', '2.0.5', '3:73e507e6e52c79361a2c768bb9c118df', 6);

--  Changeset changelog.groovy::1413996929527-7::rvsz (generated)::(Checksum: 3:76d193207b4d25772056bd6016c585b3)
CREATE TABLE `doc_url` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `listing_id` BIGINT NOT NULL, `name` VARCHAR(255) NOT NULL, `url` VARCHAR(2083) NOT NULL, CONSTRAINT `doc_urlPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-7', '2.0.5', '3:76d193207b4d25772056bd6016c585b3', 7);

--  Changeset changelog.groovy::1413996929527-8::rvsz (generated)::(Checksum: 3:bc251f9b773fe8295224a09818a7f313)
CREATE TABLE `intent` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action` VARCHAR(64) NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `icon` VARCHAR(2083) NULL, `label` VARCHAR(255) NULL, `type` VARCHAR(129) NOT NULL, CONSTRAINT `intentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-8', '2.0.5', '3:bc251f9b773fe8295224a09818a7f313', 8);

--  Changeset changelog.groovy::1413996929527-9::rvsz (generated)::(Checksum: 3:f021e9f5da8f6496dacd4dbe7c07e452)
CREATE TABLE `item_comment` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `listing_id` BIGINT NOT NULL, `rate` INT NULL, `text` VARCHAR(4000) NULL, CONSTRAINT `item_commentPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-9', '2.0.5', '3:f021e9f5da8f6496dacd4dbe7c07e452', 9);

--  Changeset changelog.groovy::1413996929527-10::rvsz (generated)::(Checksum: 3:cda7bffb2af9d23692aed67866cc1903)
CREATE TABLE `iwc_data_object` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `content_type` VARCHAR(129) NOT NULL, `entity` longtext NULL, `key` VARCHAR(255) NOT NULL, `profile_id` BIGINT NOT NULL, CONSTRAINT `iwc_data_objePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-10', '2.0.5', '3:cda7bffb2af9d23692aed67866cc1903', 10);

--  Changeset changelog.groovy::1413996929527-11::rvsz (generated)::(Checksum: 3:a1a59c14f68d78333a5c8b7aa05ec158)
CREATE TABLE `listing` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `agency_id` BIGINT NULL, `approval_status` VARCHAR(255) NOT NULL, `approved_date` DATETIME NULL, `avg_rate` FLOAT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(4000) NULL, `description_short` VARCHAR(150) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image_large_url` VARCHAR(2083) NULL, `image_medium_url` VARCHAR(2083) NULL, `image_small_url` VARCHAR(2083) NULL, `image_xlarge_url` VARCHAR(2083) NULL, `is_enabled` bit NOT NULL, `is_featured` bit NULL, `last_activity_id` BIGINT NULL, `launch_url` VARCHAR(2083) NULL, `requirements` VARCHAR(1000) NULL, `title` VARCHAR(255) NOT NULL, `total_comments` INT NOT NULL, `total_rate1` INT NULL, `total_rate2` INT NULL, `total_rate3` INT NULL, `total_rate4` INT NULL, `total_rate5` INT NULL, `total_votes` INT NOT NULL, `type_id` BIGINT NOT NULL, `uuid` VARCHAR(255) NOT NULL, `version_name` VARCHAR(255) NULL, `what_is_new` VARCHAR(250) NULL, CONSTRAINT `listingPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-11', '2.0.5', '3:a1a59c14f68d78333a5c8b7aa05ec158', 11);

--  Changeset changelog.groovy::1413996929527-12::rvsz (generated)::(Checksum: 3:c6107eea2b99170818edc4f03b9a1f0e)
CREATE TABLE `listing_activity` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `action` VARCHAR(255) NOT NULL, `activity_date` DATETIME NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `listing_id` BIGINT NOT NULL, `listing_activities_idx` INT NULL, CONSTRAINT `listing_activPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-12', '2.0.5', '3:c6107eea2b99170818edc4f03b9a1f0e', 12);

--  Changeset changelog.groovy::1413996929527-13::rvsz (generated)::(Checksum: 3:a16fb1efc81c3ff8dd2709c67db1da3c)
CREATE TABLE `listing_category` (`listing_categories_id` BIGINT NULL, `category_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-13', '2.0.5', '3:a16fb1efc81c3ff8dd2709c67db1da3c', 13);

--  Changeset changelog.groovy::1413996929527-14::rvsz (generated)::(Checksum: 3:9d6325597c1e23a6eb773fc58e523e55)
CREATE TABLE `listing_intent` (`listing_intents_id` BIGINT NULL, `intent_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-14', '2.0.5', '3:9d6325597c1e23a6eb773fc58e523e55', 14);

--  Changeset changelog.groovy::1413996929527-15::rvsz (generated)::(Checksum: 3:87e6b459655d803053f955523a7ec7aa)
CREATE TABLE `listing_profile` (`listing_owners_id` BIGINT NULL, `profile_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-15', '2.0.5', '3:87e6b459655d803053f955523a7ec7aa', 15);

--  Changeset changelog.groovy::1413996929527-16::rvsz (generated)::(Checksum: 3:e8b8fa100ef1369ebf57661d9a27b7af)
CREATE TABLE `listing_snapshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `listing_id` BIGINT NULL, `title` VARCHAR(255) NOT NULL, CONSTRAINT `listing_snapsPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-16', '2.0.5', '3:e8b8fa100ef1369ebf57661d9a27b7af', 16);

--  Changeset changelog.groovy::1413996929527-17::rvsz (generated)::(Checksum: 3:a2db2d075c145b585d0faf2b498b0535)
CREATE TABLE `listing_tags` (`listing_id` BIGINT NULL, `tags_string` VARCHAR(255) NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-17', '2.0.5', '3:a2db2d075c145b585d0faf2b498b0535', 17);

--  Changeset changelog.groovy::1413996929527-18::rvsz (generated)::(Checksum: 3:b700c0fb68ed1e67cb011c8f9a3e81c7)
CREATE TABLE `modify_relationship_activity` (`id` BIGINT NOT NULL, CONSTRAINT `modify_relatiPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-18', '2.0.5', '3:b700c0fb68ed1e67cb011c8f9a3e81c7', 18);

--  Changeset changelog.groovy::1413996929527-19::rvsz (generated)::(Checksum: 3:2f2e1c545a8b493413f5929cb221fe4f)
CREATE TABLE `profile` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `bio` VARCHAR(1000) NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `display_name` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `email` VARCHAR(255) NULL, `highest_role` VARCHAR(255) NOT NULL, `last_login` DATETIME NOT NULL, `username` VARCHAR(255) NOT NULL, CONSTRAINT `profilePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-19', '2.0.5', '3:2f2e1c545a8b493413f5929cb221fe4f', 19);

--  Changeset changelog.groovy::1413996929527-20::rvsz (generated)::(Checksum: 3:1dd417e54f7c926955790676e9e79e44)
CREATE TABLE `profile_agency` (`profile_organizations_id` BIGINT NULL, `agency_id` BIGINT NULL, `profile_stewarded_organizations_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-20', '2.0.5', '3:1dd417e54f7c926955790676e9e79e44', 20);

--  Changeset changelog.groovy::1413996929527-21::rvsz (generated)::(Checksum: 3:68b34fdc60312d9ae718e899b7ed900a)
CREATE TABLE `rejection_activity` (`id` BIGINT NOT NULL, `rejection_listing_id` BIGINT NULL, CONSTRAINT `rejection_actPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-21', '2.0.5', '3:68b34fdc60312d9ae718e899b7ed900a', 21);

--  Changeset changelog.groovy::1413996929527-22::rvsz (generated)::(Checksum: 3:45bcc9e24897e21c5b314affd4bd6fe6)
CREATE TABLE `rejection_listing` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `author_id` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(2000) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `service_item_id` BIGINT NOT NULL, CONSTRAINT `rejection_lisPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-22', '2.0.5', '3:45bcc9e24897e21c5b314affd4bd6fe6', 22);

--  Changeset changelog.groovy::1413996929527-23::rvsz (generated)::(Checksum: 3:35de2004bba9f2010a19fae71c5caa1c)
CREATE TABLE `relationship` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `owning_entity_id` BIGINT NOT NULL, `relationship_type` VARCHAR(255) NOT NULL, CONSTRAINT `relationshipPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-23', '2.0.5', '3:35de2004bba9f2010a19fae71c5caa1c', 23);

--  Changeset changelog.groovy::1413996929527-24::rvsz (generated)::(Checksum: 3:2f79d7031a1c3e54170d9157d236e966)
CREATE TABLE `relationship_activity_log` (`mod_rel_activity_id` BIGINT NOT NULL, `listing_snapshot_id` BIGINT NULL, `items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-24', '2.0.5', '3:2f79d7031a1c3e54170d9157d236e966', 24);

--  Changeset changelog.groovy::1413996929527-25::rvsz (generated)::(Checksum: 3:21efb8bc72f3b3a64ff299aa9659d2cc)
CREATE TABLE `relationship_listing` (`relationship_related_items_id` BIGINT NULL, `listing_id` BIGINT NULL, `related_items_idx` INT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-25', '2.0.5', '3:21efb8bc72f3b3a64ff299aa9659d2cc', 25);

--  Changeset changelog.groovy::1413996929527-26::rvsz (generated)::(Checksum: 3:ee59d54cd2aaab1386f61c4b52640d72)
CREATE TABLE `scorecard` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(500) NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `image` VARCHAR(2083) NULL, `question` VARCHAR(250) NOT NULL, `show_on_listing` bit NULL, CONSTRAINT `scorecardPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-26', '2.0.5', '3:ee59d54cd2aaab1386f61c4b52640d72', 26);

--  Changeset changelog.groovy::1413996929527-27::rvsz (generated)::(Checksum: 3:569f18e5b3ee6de4159e8e5832d60fbd)
CREATE TABLE `screenshot` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `large_image_url` VARCHAR(2083) NULL, `service_item_id` BIGINT NOT NULL, `small_image_url` VARCHAR(2083) NOT NULL, `ordinal` INT NULL, CONSTRAINT `screenshotPK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-27', '2.0.5', '3:569f18e5b3ee6de4159e8e5832d60fbd', 27);

--  Changeset changelog.groovy::1413996929527-28::rvsz (generated)::(Checksum: 3:a9daca8ada2682389896226df8e5295f)
CREATE TABLE `service_item_score_card_item` (`service_item_id` BIGINT NOT NULL, `score_card_item_id` BIGINT NULL) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-28', '2.0.5', '3:a9daca8ada2682389896226df8e5295f', 28);

--  Changeset changelog.groovy::1413996929527-29::rvsz (generated)::(Checksum: 3:0d33bd70f91d4c96c08b410be6e3c9a0)
CREATE TABLE `type` (`id` BIGINT AUTO_INCREMENT NOT NULL, `version` BIGINT NOT NULL, `created_by_id` BIGINT NULL, `created_date` DATETIME NOT NULL, `description` VARCHAR(255) NULL, `edited_by_id` BIGINT NULL, `edited_date` DATETIME NOT NULL, `title` VARCHAR(50) NOT NULL, CONSTRAINT `typePK` PRIMARY KEY (`id`)) ENGINE=InnoDB;

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1413996929527-29', '2.0.5', '3:0d33bd70f91d4c96c08b410be6e3c9a0', 29);

--  Changeset changelog.groovy::1413996929527-94::rvsz (generated)::(Checksum: 3:6737c56d2d977a4fa0df3bfb9e8e3ba4)
CREATE INDEX `FKAB611C057666C6D2` ON `agency`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-94', '2.0.5', '3:6737c56d2d977a4fa0df3bfb9e8e3ba4', 30);

--  Changeset changelog.groovy::1413996929527-95::rvsz (generated)::(Checksum: 3:f95dceb464d93ea2e10653557b6c3bbd)
CREATE INDEX `FKAB611C05E31CB353` ON `agency`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-95', '2.0.5', '3:f95dceb464d93ea2e10653557b6c3bbd', 31);

--  Changeset changelog.groovy::1413996929527-96::rvsz (generated)::(Checksum: 3:ddff6e6a478621cf545fcf5fb9b209c9)
CREATE UNIQUE INDEX `UK492f940b0f57ca03abde64501045` ON `agency`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-96', '2.0.5', '3:ddff6e6a478621cf545fcf5fb9b209c9', 32);

--  Changeset changelog.groovy::1413996929527-97::rvsz (generated)::(Checksum: 3:d477020610ae742b5de0a786214dd4de)
CREATE UNIQUE INDEX `title_uniq_1413996929386` ON `agency`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-97', '2.0.5', '3:d477020610ae742b5de0a786214dd4de', 33);

--  Changeset changelog.groovy::1413996929527-98::rvsz (generated)::(Checksum: 3:6e1bf62a35d91d9fefd479c725a5cb6b)
CREATE INDEX `FK44E0233F5A4BEA77` ON `application_library_entry`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-98', '2.0.5', '3:6e1bf62a35d91d9fefd479c725a5cb6b', 34);

--  Changeset changelog.groovy::1413996929527-99::rvsz (generated)::(Checksum: 3:43852ba0e12d319c7343ce74a55a77e1)
CREATE INDEX `FK44E0233F6530DF0D` ON `application_library_entry`(`owner_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-99', '2.0.5', '3:43852ba0e12d319c7343ce74a55a77e1', 35);

--  Changeset changelog.groovy::1413996929527-100::rvsz (generated)::(Checksum: 3:fc97139fe6e217c507678b9b460f648d)
CREATE INDEX `FK44E0233F7666C6D2` ON `application_library_entry`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-100', '2.0.5', '3:fc97139fe6e217c507678b9b460f648d', 36);

--  Changeset changelog.groovy::1413996929527-101::rvsz (generated)::(Checksum: 3:dbfac6862b5ebc26511bda26e69de1fd)
CREATE INDEX `FK44E0233FE31CB353` ON `application_library_entry`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-101', '2.0.5', '3:dbfac6862b5ebc26511bda26e69de1fd', 37);

--  Changeset changelog.groovy::1413996929527-102::rvsz (generated)::(Checksum: 3:5b3527edff3695cbbeca1d9402980bb8)
CREATE UNIQUE INDEX `unique_listing_id` ON `application_library_entry`(`owner_id`, `listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-102', '2.0.5', '3:5b3527edff3695cbbeca1d9402980bb8', 38);

--  Changeset changelog.groovy::1413996929527-103::rvsz (generated)::(Checksum: 3:839c5edf03b5a4d78530bfe73c494a2b)
CREATE INDEX `FK302BCFE7666C6D2` ON `category`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-103', '2.0.5', '3:839c5edf03b5a4d78530bfe73c494a2b', 39);

--  Changeset changelog.groovy::1413996929527-104::rvsz (generated)::(Checksum: 3:abae98adf693d4c6e252c9635103b9ed)
CREATE INDEX `FK302BCFEE31CB353` ON `category`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-104', '2.0.5', '3:abae98adf693d4c6e252c9635103b9ed', 40);

--  Changeset changelog.groovy::1413996929527-105::rvsz (generated)::(Checksum: 3:d9bd09a8f4282231c6bb475504210221)
CREATE UNIQUE INDEX `UK7746033a611e7747013c9a9e2900` ON `category`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-105', '2.0.5', '3:d9bd09a8f4282231c6bb475504210221', 41);

--  Changeset changelog.groovy::1413996929527-106::rvsz (generated)::(Checksum: 3:645e9d03309555121e8b44c791907049)
CREATE INDEX `FKB4467BC0160FF959` ON `change_detail`(`service_item_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-106', '2.0.5', '3:645e9d03309555121e8b44c791907049', 42);

--  Changeset changelog.groovy::1413996929527-107::rvsz (generated)::(Checksum: 3:8a86eeca4c5db5aa8562d49320a74db0)
CREATE INDEX `FK38B724205A4BEA77` ON `contact`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-107', '2.0.5', '3:8a86eeca4c5db5aa8562d49320a74db0', 43);

--  Changeset changelog.groovy::1413996929527-108::rvsz (generated)::(Checksum: 3:5512d8b172d706ad23999f647e6422a6)
CREATE INDEX `FK38B724207666C6D2` ON `contact`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-108', '2.0.5', '3:5512d8b172d706ad23999f647e6422a6', 44);

--  Changeset changelog.groovy::1413996929527-109::rvsz (generated)::(Checksum: 3:e0cdb4ec69bba14939a8ce5e3947929b)
CREATE INDEX `FK38B72420BA3FC877` ON `contact`(`type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-109', '2.0.5', '3:e0cdb4ec69bba14939a8ce5e3947929b', 45);

--  Changeset changelog.groovy::1413996929527-110::rvsz (generated)::(Checksum: 3:ab223b6396345140982e4218210dd2a6)
CREATE INDEX `FK38B72420E31CB353` ON `contact`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-110', '2.0.5', '3:ab223b6396345140982e4218210dd2a6', 46);

--  Changeset changelog.groovy::1413996929527-111::rvsz (generated)::(Checksum: 3:7bf0f61e79c783505df26e909504d64e)
CREATE INDEX `FK4C2BB7F97666C6D2` ON `contact_type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-111', '2.0.5', '3:7bf0f61e79c783505df26e909504d64e', 47);

--  Changeset changelog.groovy::1413996929527-112::rvsz (generated)::(Checksum: 3:95d15016c324a6f6a9e954804abcc950)
CREATE INDEX `FK4C2BB7F9E31CB353` ON `contact_type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-112', '2.0.5', '3:95d15016c324a6f6a9e954804abcc950', 48);

--  Changeset changelog.groovy::1413996929527-113::rvsz (generated)::(Checksum: 3:3d18cc2ca1ae25d3c7dfa0a6483be271)
CREATE UNIQUE INDEX `UK9359433766496916df2b541ad47e` ON `contact_type`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-113', '2.0.5', '3:3d18cc2ca1ae25d3c7dfa0a6483be271', 49);

--  Changeset changelog.groovy::1413996929527-114::rvsz (generated)::(Checksum: 3:39c885b95c857cad2037ae9c39d009c1)
CREATE INDEX `FK6CF91DE85A4BEA77` ON `doc_url`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-114', '2.0.5', '3:39c885b95c857cad2037ae9c39d009c1', 50);

--  Changeset changelog.groovy::1413996929527-115::rvsz (generated)::(Checksum: 3:92fbb2f899780719b54ccc740c0cb0a0)
CREATE INDEX `FKB971369C7666C6D2` ON `intent`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-115', '2.0.5', '3:92fbb2f899780719b54ccc740c0cb0a0', 51);

--  Changeset changelog.groovy::1413996929527-116::rvsz (generated)::(Checksum: 3:6caefac8c527462edff8c85539c23fca)
CREATE INDEX `FKB971369CE31CB353` ON `intent`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-116', '2.0.5', '3:6caefac8c527462edff8c85539c23fca', 52);

--  Changeset changelog.groovy::1413996929527-117::rvsz (generated)::(Checksum: 3:05951fcc39aab622143a67676ba4b51e)
CREATE UNIQUE INDEX `UKc7042bb056f010832f67f6c69a3e` ON `intent`(`type`, `action`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-117', '2.0.5', '3:05951fcc39aab622143a67676ba4b51e', 53);

--  Changeset changelog.groovy::1413996929527-118::rvsz (generated)::(Checksum: 3:746e27fa81fd626ea797dc77b328d7bc)
CREATE INDEX `FKE6D04D335A032135` ON `item_comment`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-118', '2.0.5', '3:746e27fa81fd626ea797dc77b328d7bc', 54);

--  Changeset changelog.groovy::1413996929527-119::rvsz (generated)::(Checksum: 3:5f5fa61f667fbafc156c3c5e4d6d5f5f)
CREATE INDEX `FKE6D04D335A4BEA77` ON `item_comment`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-119', '2.0.5', '3:5f5fa61f667fbafc156c3c5e4d6d5f5f', 55);

--  Changeset changelog.groovy::1413996929527-120::rvsz (generated)::(Checksum: 3:1b1fd7174764d6af9ff51dbfbd268461)
CREATE INDEX `FKE6D04D337666C6D2` ON `item_comment`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-120', '2.0.5', '3:1b1fd7174764d6af9ff51dbfbd268461', 56);

--  Changeset changelog.groovy::1413996929527-121::rvsz (generated)::(Checksum: 3:d5b9eff22304b8c7744e69c46394e893)
CREATE INDEX `FKE6D04D33E31CB353` ON `item_comment`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-121', '2.0.5', '3:d5b9eff22304b8c7744e69c46394e893', 57);

--  Changeset changelog.groovy::1413996929527-122::rvsz (generated)::(Checksum: 3:70bd22d430f1c0b043be44e742fd5871)
CREATE UNIQUE INDEX `unique_listing_id` ON `item_comment`(`author_id`, `listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-122', '2.0.5', '3:70bd22d430f1c0b043be44e742fd5871', 58);

--  Changeset changelog.groovy::1413996929527-123::rvsz (generated)::(Checksum: 3:15a82e4f6a017553119b100b7cf21de0)
CREATE INDEX `FK999DCD2AC0565C57` ON `iwc_data_object`(`profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-123', '2.0.5', '3:15a82e4f6a017553119b100b7cf21de0', 59);

--  Changeset changelog.groovy::1413996929527-124::rvsz (generated)::(Checksum: 3:60a71c2d6c71ad1731a90545b241a302)
CREATE UNIQUE INDEX `UKe1b86bb7cb89802b84044c6be65a` ON `iwc_data_object`(`key`, `profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-124', '2.0.5', '3:60a71c2d6c71ad1731a90545b241a302', 60);

--  Changeset changelog.groovy::1413996929527-125::rvsz (generated)::(Checksum: 3:bacc5b6c81e3fd28a2d706c2b169796f)
CREATE INDEX `FKAD8BA84143B24BD` ON `listing`(`agency_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-125', '2.0.5', '3:bacc5b6c81e3fd28a2d706c2b169796f', 61);

--  Changeset changelog.groovy::1413996929527-126::rvsz (generated)::(Checksum: 3:a80b2f5dfd39fc712cb31bf5793fe10d)
CREATE INDEX `FKAD8BA847666C6D2` ON `listing`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-126', '2.0.5', '3:a80b2f5dfd39fc712cb31bf5793fe10d', 62);

--  Changeset changelog.groovy::1413996929527-127::rvsz (generated)::(Checksum: 3:515e8d4a34af3d84da83370bd35acbfe)
CREATE INDEX `FKAD8BA849809495D` ON `listing`(`type_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-127', '2.0.5', '3:515e8d4a34af3d84da83370bd35acbfe', 63);

--  Changeset changelog.groovy::1413996929527-128::rvsz (generated)::(Checksum: 3:6588550d088b575867be22e0617abd40)
CREATE INDEX `FKAD8BA84B803A812` ON `listing`(`last_activity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-128', '2.0.5', '3:6588550d088b575867be22e0617abd40', 64);

--  Changeset changelog.groovy::1413996929527-129::rvsz (generated)::(Checksum: 3:bce0298579893c292b082ad130804b37)
CREATE INDEX `FKAD8BA84E31CB353` ON `listing`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-129', '2.0.5', '3:bce0298579893c292b082ad130804b37', 65);

--  Changeset changelog.groovy::1413996929527-130::rvsz (generated)::(Checksum: 3:9e4d86f24b333424e7244d3fde456edd)
CREATE INDEX `FK9CE7FE6A5A032135` ON `listing_activity`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-130', '2.0.5', '3:9e4d86f24b333424e7244d3fde456edd', 66);

--  Changeset changelog.groovy::1413996929527-131::rvsz (generated)::(Checksum: 3:611b1ce941e0013075380c4594e0f365)
CREATE INDEX `FK9CE7FE6A5A4BEA77` ON `listing_activity`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-131', '2.0.5', '3:611b1ce941e0013075380c4594e0f365', 67);

--  Changeset changelog.groovy::1413996929527-132::rvsz (generated)::(Checksum: 3:97684019fbb01451c5ce6070929c0fd3)
CREATE INDEX `FK9CE7FE6A7666C6D2` ON `listing_activity`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-132', '2.0.5', '3:97684019fbb01451c5ce6070929c0fd3', 68);

--  Changeset changelog.groovy::1413996929527-133::rvsz (generated)::(Checksum: 3:a53715a0446a2da32841ec1a436f0121)
CREATE INDEX `FK9CE7FE6AE31CB353` ON `listing_activity`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-133', '2.0.5', '3:a53715a0446a2da32841ec1a436f0121', 69);

--  Changeset changelog.groovy::1413996929527-134::rvsz (generated)::(Checksum: 3:26493c88f94450c4f2a8f5082bd65058)
CREATE INDEX `FK29EC859DA41995D` ON `listing_category`(`category_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-134', '2.0.5', '3:26493c88f94450c4f2a8f5082bd65058', 70);

--  Changeset changelog.groovy::1413996929527-135::rvsz (generated)::(Checksum: 3:10b7c67376a27ec00f0377cf81ac892e)
CREATE INDEX `FK29EC859DB0E6D64` ON `listing_category`(`listing_categories_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-135', '2.0.5', '3:10b7c67376a27ec00f0377cf81ac892e', 71);

--  Changeset changelog.groovy::1413996929527-136::rvsz (generated)::(Checksum: 3:1dc73fc4ee5dda0d3de4275c27bdb4e9)
CREATE INDEX `FK17BE5CB742D2535F` ON `listing_intent`(`listing_intents_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-136', '2.0.5', '3:1dc73fc4ee5dda0d3de4275c27bdb4e9', 72);

--  Changeset changelog.groovy::1413996929527-137::rvsz (generated)::(Checksum: 3:df7aaddcd6ee574f0e60d1685bc868f5)
CREATE INDEX `FK17BE5CB7A651895D` ON `listing_intent`(`intent_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-137', '2.0.5', '3:df7aaddcd6ee574f0e60d1685bc868f5', 73);

--  Changeset changelog.groovy::1413996929527-138::rvsz (generated)::(Checksum: 3:36f723471daa75c7153650c9fb3aa81f)
CREATE INDEX `FK58E626EE1459EB60` ON `listing_profile`(`listing_owners_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-138', '2.0.5', '3:36f723471daa75c7153650c9fb3aa81f', 74);

--  Changeset changelog.groovy::1413996929527-139::rvsz (generated)::(Checksum: 3:d836100f7a8ea944af1eaac30aaa9eca)
CREATE INDEX `FK58E626EEC0565C57` ON `listing_profile`(`profile_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-139', '2.0.5', '3:d836100f7a8ea944af1eaac30aaa9eca', 75);

--  Changeset changelog.groovy::1413996929527-140::rvsz (generated)::(Checksum: 3:4c038fec95851dded01218445bb276ec)
CREATE INDEX `FK1096E11F5A4BEA77` ON `listing_snapshot`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-140', '2.0.5', '3:4c038fec95851dded01218445bb276ec', 76);

--  Changeset changelog.groovy::1413996929527-141::rvsz (generated)::(Checksum: 3:84553890668bcad8ac73a458fcc51f81)
CREATE INDEX `FK483C24F45A4BEA77` ON `listing_tags`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-141', '2.0.5', '3:84553890668bcad8ac73a458fcc51f81', 77);

--  Changeset changelog.groovy::1413996929527-142::rvsz (generated)::(Checksum: 3:e3d0d83bc70c09436b25879cec74d4f2)
CREATE INDEX `FKE68D3F715416850B` ON `modify_relationship_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-142', '2.0.5', '3:e3d0d83bc70c09436b25879cec74d4f2', 78);

--  Changeset changelog.groovy::1413996929527-143::rvsz (generated)::(Checksum: 3:5c87cefb070afe5245df49edcdf6d6bc)
CREATE INDEX `FKED8E89A97666C6D2` ON `profile`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-143', '2.0.5', '3:5c87cefb070afe5245df49edcdf6d6bc', 79);

--  Changeset changelog.groovy::1413996929527-144::rvsz (generated)::(Checksum: 3:0b1b62581a385869ec370e81caf41d45)
CREATE INDEX `FKED8E89A9E31CB353` ON `profile`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-144', '2.0.5', '3:0b1b62581a385869ec370e81caf41d45', 80);

--  Changeset changelog.groovy::1413996929527-145::rvsz (generated)::(Checksum: 3:f2a29fe86147e02a26bc712a9baf21d9)
CREATE UNIQUE INDEX `UK2e2af56bde6e9cad39c0f4ae1993` ON `profile`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-145', '2.0.5', '3:f2a29fe86147e02a26bc712a9baf21d9', 81);

--  Changeset changelog.groovy::1413996929527-146::rvsz (generated)::(Checksum: 3:c72a15973d364fe8edf89be7d6eb5f02)
CREATE UNIQUE INDEX `username_uniq_1413996929430` ON `profile`(`username`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-146', '2.0.5', '3:c72a15973d364fe8edf89be7d6eb5f02', 82);

--  Changeset changelog.groovy::1413996929527-147::rvsz (generated)::(Checksum: 3:09e58be94988e1f6565c24d41b386a7d)
CREATE INDEX `FKB82D0F5B143B24BD` ON `profile_agency`(`agency_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-147', '2.0.5', '3:09e58be94988e1f6565c24d41b386a7d', 83);

--  Changeset changelog.groovy::1413996929527-148::rvsz (generated)::(Checksum: 3:4ff9ec5a065ca410f260dca1c0f250d5)
CREATE INDEX `FKB82D0F5B4B3EE656` ON `profile_agency`(`profile_stewarded_organizations_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-148', '2.0.5', '3:4ff9ec5a065ca410f260dca1c0f250d5', 84);

--  Changeset changelog.groovy::1413996929527-149::rvsz (generated)::(Checksum: 3:b5a18621c3113ff14437c2f704dbd05d)
CREATE INDEX `FKB82D0F5B7AA654D6` ON `profile_agency`(`profile_organizations_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-149', '2.0.5', '3:b5a18621c3113ff14437c2f704dbd05d', 85);

--  Changeset changelog.groovy::1413996929527-150::rvsz (generated)::(Checksum: 3:e4502f471005d60bfba94e82da995def)
CREATE INDEX `FKF35C12855416850B` ON `rejection_activity`(`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-150', '2.0.5', '3:e4502f471005d60bfba94e82da995def', 86);

--  Changeset changelog.groovy::1413996929527-151::rvsz (generated)::(Checksum: 3:cca6c45c54b91151bc21e28f8459e6b5)
CREATE INDEX `FKF35C128582548A4A` ON `rejection_activity`(`rejection_listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-151', '2.0.5', '3:cca6c45c54b91151bc21e28f8459e6b5', 87);

--  Changeset changelog.groovy::1413996929527-152::rvsz (generated)::(Checksum: 3:66b6585c51649bacba538f21c706a430)
CREATE INDEX `FK3F2BD44E5A032135` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-152', '2.0.5', '3:66b6585c51649bacba538f21c706a430', 88);

--  Changeset changelog.groovy::1413996929527-153::rvsz (generated)::(Checksum: 3:e0dc6ea1e761e32fc3d32120c1a271b7)
CREATE INDEX `FK3F2BD44E6F8C13FE` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-153', '2.0.5', '3:e0dc6ea1e761e32fc3d32120c1a271b7', 89);

--  Changeset changelog.groovy::1413996929527-154::rvsz (generated)::(Checksum: 3:d1f5b33deb169eb9fb0458e7e8b64541)
CREATE INDEX `FK3F2BD44E7666C6D2` ON `rejection_listing`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-154', '2.0.5', '3:d1f5b33deb169eb9fb0458e7e8b64541', 90);

--  Changeset changelog.groovy::1413996929527-155::rvsz (generated)::(Checksum: 3:3ff4107bb95921b20fdbf01b1089ce2e)
CREATE INDEX `FK3F2BD44EE31CB353` ON `rejection_listing`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-155', '2.0.5', '3:3ff4107bb95921b20fdbf01b1089ce2e', 91);

--  Changeset changelog.groovy::1413996929527-156::rvsz (generated)::(Checksum: 3:43678308dc3a992c28f53b4efeb30268)
CREATE INDEX `rej_lst_author_id_idx` ON `rejection_listing`(`author_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-156', '2.0.5', '3:43678308dc3a992c28f53b4efeb30268', 92);

--  Changeset changelog.groovy::1413996929527-157::rvsz (generated)::(Checksum: 3:185f7cfc5e4834a552850a563be01129)
CREATE INDEX `rej_lst_svc_item_id_idx` ON `rejection_listing`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-157', '2.0.5', '3:185f7cfc5e4834a552850a563be01129', 93);

--  Changeset changelog.groovy::1413996929527-158::rvsz (generated)::(Checksum: 3:9474bf6742e6639259bf99e8200fd3b8)
CREATE INDEX `FKF064763845172AD5` ON `relationship`(`owning_entity_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-158', '2.0.5', '3:9474bf6742e6639259bf99e8200fd3b8', 94);

--  Changeset changelog.groovy::1413996929527-159::rvsz (generated)::(Checksum: 3:3aa4f1240ca8f0c11f39217268eb9a4a)
CREATE INDEX `FK594974BB4DC662E0` ON `relationship_activity_log`(`listing_snapshot_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-159', '2.0.5', '3:3aa4f1240ca8f0c11f39217268eb9a4a', 95);

--  Changeset changelog.groovy::1413996929527-160::rvsz (generated)::(Checksum: 3:5c82152762f1840c0e3c0e8992df7e84)
CREATE INDEX `FKDDEF1F7D5A4BEA77` ON `relationship_listing`(`listing_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-160', '2.0.5', '3:5c82152762f1840c0e3c0e8992df7e84', 96);

--  Changeset changelog.groovy::1413996929527-161::rvsz (generated)::(Checksum: 3:de3c1cd17a6696c6c7643184f4420d20)
CREATE INDEX `FK7EEC20A27666C6D2` ON `scorecard`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-161', '2.0.5', '3:de3c1cd17a6696c6c7643184f4420d20', 97);

--  Changeset changelog.groovy::1413996929527-162::rvsz (generated)::(Checksum: 3:1ad9b467e77307291ffe582d7b1831dc)
CREATE INDEX `FK7EEC20A2E31CB353` ON `scorecard`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-162', '2.0.5', '3:1ad9b467e77307291ffe582d7b1831dc', 98);

--  Changeset changelog.groovy::1413996929527-163::rvsz (generated)::(Checksum: 3:781bb6d061a12647c3b7bc82865077d2)
CREATE INDEX `FKE72D85666F8C13FE` ON `screenshot`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-163', '2.0.5', '3:781bb6d061a12647c3b7bc82865077d2', 99);

--  Changeset changelog.groovy::1413996929527-164::rvsz (generated)::(Checksum: 3:1aba62ac454620082692f1eaa640f99f)
CREATE INDEX `FKE72D85667666C6D2` ON `screenshot`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-164', '2.0.5', '3:1aba62ac454620082692f1eaa640f99f', 100);

--  Changeset changelog.groovy::1413996929527-165::rvsz (generated)::(Checksum: 3:07741cdcf1099bf19899e2737d826d46)
CREATE INDEX `FKE72D8566E31CB353` ON `screenshot`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-165', '2.0.5', '3:07741cdcf1099bf19899e2737d826d46', 101);

--  Changeset changelog.groovy::1413996929527-166::rvsz (generated)::(Checksum: 3:e946f16b376cc0c956a39e9300202191)
CREATE INDEX `FKBF91F936F8C13FE` ON `service_item_score_card_item`(`service_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-166', '2.0.5', '3:e946f16b376cc0c956a39e9300202191', 102);

--  Changeset changelog.groovy::1413996929527-167::rvsz (generated)::(Checksum: 3:3a3256392f267f005d2f66690a5a7f69)
CREATE INDEX `FKBF91F9388E6B0C4` ON `service_item_score_card_item`(`score_card_item_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-167', '2.0.5', '3:3a3256392f267f005d2f66690a5a7f69', 103);

--  Changeset changelog.groovy::1413996929527-168::rvsz (generated)::(Checksum: 3:78e9828d23008ee1b594eb6e04199ea1)
CREATE INDEX `FK368F3A7666C6D2` ON `type`(`created_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-168', '2.0.5', '3:78e9828d23008ee1b594eb6e04199ea1', 104);

--  Changeset changelog.groovy::1413996929527-169::rvsz (generated)::(Checksum: 3:ec4b5620d8c1ae257d60ad8035b4eb63)
CREATE INDEX `FK368F3AE31CB353` ON `type`(`edited_by_id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-169', '2.0.5', '3:ec4b5620d8c1ae257d60ad8035b4eb63', 105);

--  Changeset changelog.groovy::1413996929527-170::rvsz (generated)::(Checksum: 3:843fa0cacf00af8a122d89bc270317d8)
CREATE UNIQUE INDEX `UK57c992e1354f398a8f71f29226dc` ON `type`(`title`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1413996929527-170', '2.0.5', '3:843fa0cacf00af8a122d89bc270317d8', 106);

--  Changeset changelog.groovy::1413996929527-30::rvsz (generated)::(Checksum: 3:c0e9894b976dceb09fc43de299f992a7)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C057666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-30', '2.0.5', '3:c0e9894b976dceb09fc43de299f992a7', 107);

--  Changeset changelog.groovy::1413996929527-31::rvsz (generated)::(Checksum: 3:34b4d2a4851521abae8cfaa2fe8f4b9a)
ALTER TABLE `agency` ADD CONSTRAINT `FKAB611C05E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-31', '2.0.5', '3:34b4d2a4851521abae8cfaa2fe8f4b9a', 108);

--  Changeset changelog.groovy::1413996929527-32::rvsz (generated)::(Checksum: 3:2d69ea1f6f5ec06c1cec4b7e0cac0c5e)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-32', '2.0.5', '3:2d69ea1f6f5ec06c1cec4b7e0cac0c5e', 109);

--  Changeset changelog.groovy::1413996929527-33::rvsz (generated)::(Checksum: 3:9136a33397c8aed3476e08179ebdc62e)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233FE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-33', '2.0.5', '3:9136a33397c8aed3476e08179ebdc62e', 110);

--  Changeset changelog.groovy::1413996929527-34::rvsz (generated)::(Checksum: 3:83184d2f5457e8e18ccbb3e9ab9ad145)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F5A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-34', '2.0.5', '3:83184d2f5457e8e18ccbb3e9ab9ad145', 111);

--  Changeset changelog.groovy::1413996929527-35::rvsz (generated)::(Checksum: 3:5f80a5c2d662b3519c257c5b47e9eab2)
ALTER TABLE `application_library_entry` ADD CONSTRAINT `FK44E0233F6530DF0D` FOREIGN KEY (`owner_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-35', '2.0.5', '3:5f80a5c2d662b3519c257c5b47e9eab2', 112);

--  Changeset changelog.groovy::1413996929527-36::rvsz (generated)::(Checksum: 3:0919cac3b93d89e27f450a3f42822f00)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFE7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-36', '2.0.5', '3:0919cac3b93d89e27f450a3f42822f00', 113);

--  Changeset changelog.groovy::1413996929527-37::rvsz (generated)::(Checksum: 3:7f041c5ab327f9e6925e7d44efe00d89)
ALTER TABLE `category` ADD CONSTRAINT `FK302BCFEE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-37', '2.0.5', '3:7f041c5ab327f9e6925e7d44efe00d89', 114);

--  Changeset changelog.groovy::1413996929527-38::rvsz (generated)::(Checksum: 3:0e32a99d01344b465271ea6ff8cbe772)
ALTER TABLE `change_detail` ADD CONSTRAINT `FKB4467BC0160FF959` FOREIGN KEY (`service_item_activity_id`) REFERENCES `listing_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-38', '2.0.5', '3:0e32a99d01344b465271ea6ff8cbe772', 115);

--  Changeset changelog.groovy::1413996929527-39::rvsz (generated)::(Checksum: 3:f0906f0eb39b2202ecb84c2bca907d03)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B724207666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-39', '2.0.5', '3:f0906f0eb39b2202ecb84c2bca907d03', 116);

--  Changeset changelog.groovy::1413996929527-40::rvsz (generated)::(Checksum: 3:9ee958dc651da79e1462035ba353b6e0)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-40', '2.0.5', '3:9ee958dc651da79e1462035ba353b6e0', 117);

--  Changeset changelog.groovy::1413996929527-41::rvsz (generated)::(Checksum: 3:cef6c14037c4ed2b71fc2412378f718d)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B724205A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-41', '2.0.5', '3:cef6c14037c4ed2b71fc2412378f718d', 118);

--  Changeset changelog.groovy::1413996929527-42::rvsz (generated)::(Checksum: 3:432fc8bd066d7de72903ae07ec4536f8)
ALTER TABLE `contact` ADD CONSTRAINT `FK38B72420BA3FC877` FOREIGN KEY (`type_id`) REFERENCES `contact_type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-42', '2.0.5', '3:432fc8bd066d7de72903ae07ec4536f8', 119);

--  Changeset changelog.groovy::1413996929527-43::rvsz (generated)::(Checksum: 3:789dc9c339f5d808bbdaf6d72db916fe)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-43', '2.0.5', '3:789dc9c339f5d808bbdaf6d72db916fe', 120);

--  Changeset changelog.groovy::1413996929527-44::rvsz (generated)::(Checksum: 3:3225c8cbdce1d11887d89fd757132306)
ALTER TABLE `contact_type` ADD CONSTRAINT `FK4C2BB7F9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-44', '2.0.5', '3:3225c8cbdce1d11887d89fd757132306', 121);

--  Changeset changelog.groovy::1413996929527-45::rvsz (generated)::(Checksum: 3:c18a532f30cd58adcb57273b0f5e6938)
ALTER TABLE `doc_url` ADD CONSTRAINT `FK6CF91DE85A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-45', '2.0.5', '3:c18a532f30cd58adcb57273b0f5e6938', 122);

--  Changeset changelog.groovy::1413996929527-46::rvsz (generated)::(Checksum: 3:fde98c8a0d1e864c6a82ad6e6af9795e)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369C7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-46', '2.0.5', '3:fde98c8a0d1e864c6a82ad6e6af9795e', 123);

--  Changeset changelog.groovy::1413996929527-47::rvsz (generated)::(Checksum: 3:a96ec94441f5d31aff93ea7dc023d833)
ALTER TABLE `intent` ADD CONSTRAINT `FKB971369CE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-47', '2.0.5', '3:a96ec94441f5d31aff93ea7dc023d833', 124);

--  Changeset changelog.groovy::1413996929527-48::rvsz (generated)::(Checksum: 3:a44ccb86429d03ec4fea4a898375f590)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D335A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-48', '2.0.5', '3:a44ccb86429d03ec4fea4a898375f590', 125);

--  Changeset changelog.groovy::1413996929527-49::rvsz (generated)::(Checksum: 3:48e7833bd349bbe1a7a03a7c6d8246b0)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D337666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-49', '2.0.5', '3:48e7833bd349bbe1a7a03a7c6d8246b0', 126);

--  Changeset changelog.groovy::1413996929527-50::rvsz (generated)::(Checksum: 3:704e07f94eb1a0c534dd728f8c94cede)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D33E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-50', '2.0.5', '3:704e07f94eb1a0c534dd728f8c94cede', 127);

--  Changeset changelog.groovy::1413996929527-51::rvsz (generated)::(Checksum: 3:dea52779f0f47a0397500b6e5ba4c28f)
ALTER TABLE `item_comment` ADD CONSTRAINT `FKE6D04D335A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-51', '2.0.5', '3:dea52779f0f47a0397500b6e5ba4c28f', 128);

--  Changeset changelog.groovy::1413996929527-52::rvsz (generated)::(Checksum: 3:0af0fe1989c45366ca360b09e816f878)
ALTER TABLE `iwc_data_object` ADD CONSTRAINT `FK999DCD2AC0565C57` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-52', '2.0.5', '3:0af0fe1989c45366ca360b09e816f878', 129);

--  Changeset changelog.groovy::1413996929527-53::rvsz (generated)::(Checksum: 3:f31935dd52aa3c3b4c34644a9f5a6352)
ALTER TABLE `listing` ADD CONSTRAINT `FKAD8BA84143B24BD` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-53', '2.0.5', '3:f31935dd52aa3c3b4c34644a9f5a6352', 130);

--  Changeset changelog.groovy::1413996929527-54::rvsz (generated)::(Checksum: 3:d852c1455d09efd5684a35dedbad829b)
ALTER TABLE `listing` ADD CONSTRAINT `FKAD8BA847666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-54', '2.0.5', '3:d852c1455d09efd5684a35dedbad829b', 131);

--  Changeset changelog.groovy::1413996929527-55::rvsz (generated)::(Checksum: 3:71f37ffdfda2c6429d537979a6d5d9fa)
ALTER TABLE `listing` ADD CONSTRAINT `FKAD8BA84E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-55', '2.0.5', '3:71f37ffdfda2c6429d537979a6d5d9fa', 132);

--  Changeset changelog.groovy::1413996929527-56::rvsz (generated)::(Checksum: 3:13c81c934907cfe338ace6528dd2ed04)
ALTER TABLE `listing` ADD CONSTRAINT `FKAD8BA84B803A812` FOREIGN KEY (`last_activity_id`) REFERENCES `listing_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-56', '2.0.5', '3:13c81c934907cfe338ace6528dd2ed04', 133);

--  Changeset changelog.groovy::1413996929527-57::rvsz (generated)::(Checksum: 3:453a9e496153cce53dcb747d8e617cbc)
ALTER TABLE `listing` ADD CONSTRAINT `FKAD8BA849809495D` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-57', '2.0.5', '3:453a9e496153cce53dcb747d8e617cbc', 134);

--  Changeset changelog.groovy::1413996929527-58::rvsz (generated)::(Checksum: 3:da13301c10e52810bdcd22884f51b763)
ALTER TABLE `listing_activity` ADD CONSTRAINT `FK9CE7FE6A5A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-58', '2.0.5', '3:da13301c10e52810bdcd22884f51b763', 135);

--  Changeset changelog.groovy::1413996929527-59::rvsz (generated)::(Checksum: 3:4546354bbf6d214c98c58d480599b1cb)
ALTER TABLE `listing_activity` ADD CONSTRAINT `FK9CE7FE6A7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-59', '2.0.5', '3:4546354bbf6d214c98c58d480599b1cb', 136);

--  Changeset changelog.groovy::1413996929527-60::rvsz (generated)::(Checksum: 3:a0e922826240b1cc550305f75ba82fa8)
ALTER TABLE `listing_activity` ADD CONSTRAINT `FK9CE7FE6AE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-60', '2.0.5', '3:a0e922826240b1cc550305f75ba82fa8', 137);

--  Changeset changelog.groovy::1413996929527-61::rvsz (generated)::(Checksum: 3:a0942886780d1fbeea2da2fd7478ff31)
ALTER TABLE `listing_activity` ADD CONSTRAINT `FK9CE7FE6A5A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-61', '2.0.5', '3:a0942886780d1fbeea2da2fd7478ff31', 138);

--  Changeset changelog.groovy::1413996929527-62::rvsz (generated)::(Checksum: 3:b24e109c1b2dfbe7d1a84e054349977a)
ALTER TABLE `listing_category` ADD CONSTRAINT `FK29EC859DA41995D` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-62', '2.0.5', '3:b24e109c1b2dfbe7d1a84e054349977a', 139);

--  Changeset changelog.groovy::1413996929527-63::rvsz (generated)::(Checksum: 3:7ac42f0e37f345f95f9bc8b194440d4d)
ALTER TABLE `listing_category` ADD CONSTRAINT `FK29EC859DB0E6D64` FOREIGN KEY (`listing_categories_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-63', '2.0.5', '3:7ac42f0e37f345f95f9bc8b194440d4d', 140);

--  Changeset changelog.groovy::1413996929527-64::rvsz (generated)::(Checksum: 3:2714f3a5a9a15cd6a0b733f4b194d10e)
ALTER TABLE `listing_intent` ADD CONSTRAINT `FK17BE5CB7A651895D` FOREIGN KEY (`intent_id`) REFERENCES `intent` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-64', '2.0.5', '3:2714f3a5a9a15cd6a0b733f4b194d10e', 141);

--  Changeset changelog.groovy::1413996929527-65::rvsz (generated)::(Checksum: 3:a932bc30f6d4fbf57dbba0b2d113c6a1)
ALTER TABLE `listing_intent` ADD CONSTRAINT `FK17BE5CB742D2535F` FOREIGN KEY (`listing_intents_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-65', '2.0.5', '3:a932bc30f6d4fbf57dbba0b2d113c6a1', 142);

--  Changeset changelog.groovy::1413996929527-66::rvsz (generated)::(Checksum: 3:99481257d281ed405f037abdee285925)
ALTER TABLE `listing_profile` ADD CONSTRAINT `FK58E626EE1459EB60` FOREIGN KEY (`listing_owners_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-66', '2.0.5', '3:99481257d281ed405f037abdee285925', 143);

--  Changeset changelog.groovy::1413996929527-67::rvsz (generated)::(Checksum: 3:4355ed5e26c89a2655ff06c633177c24)
ALTER TABLE `listing_profile` ADD CONSTRAINT `FK58E626EEC0565C57` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-67', '2.0.5', '3:4355ed5e26c89a2655ff06c633177c24', 144);

--  Changeset changelog.groovy::1413996929527-68::rvsz (generated)::(Checksum: 3:2828ef18f845bdd32d2c1f245a7af04d)
ALTER TABLE `listing_snapshot` ADD CONSTRAINT `FK1096E11F5A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-68', '2.0.5', '3:2828ef18f845bdd32d2c1f245a7af04d', 145);

--  Changeset changelog.groovy::1413996929527-69::rvsz (generated)::(Checksum: 3:03eab0d6e6d8807845d4b014fda6935c)
ALTER TABLE `listing_tags` ADD CONSTRAINT `FK483C24F45A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-69', '2.0.5', '3:03eab0d6e6d8807845d4b014fda6935c', 146);

--  Changeset changelog.groovy::1413996929527-70::rvsz (generated)::(Checksum: 3:f498dd3937bd1835889a6db03eb3a019)
ALTER TABLE `modify_relationship_activity` ADD CONSTRAINT `FKE68D3F715416850B` FOREIGN KEY (`id`) REFERENCES `listing_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-70', '2.0.5', '3:f498dd3937bd1835889a6db03eb3a019', 147);

--  Changeset changelog.groovy::1413996929527-71::rvsz (generated)::(Checksum: 3:e86f16463585314b530be5e7573a9296)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A97666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-71', '2.0.5', '3:e86f16463585314b530be5e7573a9296', 148);

--  Changeset changelog.groovy::1413996929527-72::rvsz (generated)::(Checksum: 3:c5cba2edf4144c33b909623615472244)
ALTER TABLE `profile` ADD CONSTRAINT `FKED8E89A9E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-72', '2.0.5', '3:c5cba2edf4144c33b909623615472244', 149);

--  Changeset changelog.groovy::1413996929527-73::rvsz (generated)::(Checksum: 3:388eb5e35e6a01a8407f4dc7de2c5a86)
ALTER TABLE `profile_agency` ADD CONSTRAINT `FKB82D0F5B143B24BD` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-73', '2.0.5', '3:388eb5e35e6a01a8407f4dc7de2c5a86', 150);

--  Changeset changelog.groovy::1413996929527-74::rvsz (generated)::(Checksum: 3:7524af22a9e28010768d128883f2503d)
ALTER TABLE `profile_agency` ADD CONSTRAINT `FKB82D0F5B7AA654D6` FOREIGN KEY (`profile_organizations_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-74', '2.0.5', '3:7524af22a9e28010768d128883f2503d', 151);

--  Changeset changelog.groovy::1413996929527-75::rvsz (generated)::(Checksum: 3:f2f37e966f698fd6d0cc5636c41c0c72)
ALTER TABLE `profile_agency` ADD CONSTRAINT `FKB82D0F5B4B3EE656` FOREIGN KEY (`profile_stewarded_organizations_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-75', '2.0.5', '3:f2f37e966f698fd6d0cc5636c41c0c72', 152);

--  Changeset changelog.groovy::1413996929527-76::rvsz (generated)::(Checksum: 3:366f38e51c2020aed80aaf497ee8cb8e)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C12855416850B` FOREIGN KEY (`id`) REFERENCES `listing_activity` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-76', '2.0.5', '3:366f38e51c2020aed80aaf497ee8cb8e', 153);

--  Changeset changelog.groovy::1413996929527-77::rvsz (generated)::(Checksum: 3:3c8e09e6df0585dccbc5813b6ed69ff0)
ALTER TABLE `rejection_activity` ADD CONSTRAINT `FKF35C128582548A4A` FOREIGN KEY (`rejection_listing_id`) REFERENCES `rejection_listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-77', '2.0.5', '3:3c8e09e6df0585dccbc5813b6ed69ff0', 154);

--  Changeset changelog.groovy::1413996929527-78::rvsz (generated)::(Checksum: 3:0ec52b0ffac45e2d8b8d25ecdd0b708a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E5A032135` FOREIGN KEY (`author_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-78', '2.0.5', '3:0ec52b0ffac45e2d8b8d25ecdd0b708a', 155);

--  Changeset changelog.groovy::1413996929527-79::rvsz (generated)::(Checksum: 3:c4b6c6b7843000ce7af769a43a00eada)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-79', '2.0.5', '3:c4b6c6b7843000ce7af769a43a00eada', 156);

--  Changeset changelog.groovy::1413996929527-80::rvsz (generated)::(Checksum: 3:a5a6551c740e542d7847e4c110846e8a)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44EE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-80', '2.0.5', '3:a5a6551c740e542d7847e4c110846e8a', 157);

--  Changeset changelog.groovy::1413996929527-81::rvsz (generated)::(Checksum: 3:f5e4d9413877478e730c7311f8ac48df)
ALTER TABLE `rejection_listing` ADD CONSTRAINT `FK3F2BD44E6F8C13FE` FOREIGN KEY (`service_item_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-81', '2.0.5', '3:f5e4d9413877478e730c7311f8ac48df', 158);

--  Changeset changelog.groovy::1413996929527-82::rvsz (generated)::(Checksum: 3:5fc7daa0049757347abcc59e7db0534d)
ALTER TABLE `relationship` ADD CONSTRAINT `FKF064763845172AD5` FOREIGN KEY (`owning_entity_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-82', '2.0.5', '3:5fc7daa0049757347abcc59e7db0534d', 159);

--  Changeset changelog.groovy::1413996929527-83::rvsz (generated)::(Checksum: 3:ef063849bb92fc0019ac9b32efd57bd4)
ALTER TABLE `relationship_activity_log` ADD CONSTRAINT `FK594974BB4DC662E0` FOREIGN KEY (`listing_snapshot_id`) REFERENCES `listing_snapshot` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-83', '2.0.5', '3:ef063849bb92fc0019ac9b32efd57bd4', 160);

--  Changeset changelog.groovy::1413996929527-84::rvsz (generated)::(Checksum: 3:88c70562f3cf76f7225c7944b138ff9d)
ALTER TABLE `relationship_listing` ADD CONSTRAINT `FKDDEF1F7D5A4BEA77` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-84', '2.0.5', '3:88c70562f3cf76f7225c7944b138ff9d', 161);

--  Changeset changelog.groovy::1413996929527-85::rvsz (generated)::(Checksum: 3:a5a0350ecfffe9dee99fc6ac35e8215c)
ALTER TABLE `scorecard` ADD CONSTRAINT `FK7EEC20A27666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-85', '2.0.5', '3:a5a0350ecfffe9dee99fc6ac35e8215c', 162);

--  Changeset changelog.groovy::1413996929527-86::rvsz (generated)::(Checksum: 3:a696b925fd625174977f6f0d07972ecd)
ALTER TABLE `scorecard` ADD CONSTRAINT `FK7EEC20A2E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-86', '2.0.5', '3:a696b925fd625174977f6f0d07972ecd', 163);

--  Changeset changelog.groovy::1413996929527-87::rvsz (generated)::(Checksum: 3:f6eba1782ecc96476aaeb2674f93d056)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D85667666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-87', '2.0.5', '3:f6eba1782ecc96476aaeb2674f93d056', 164);

--  Changeset changelog.groovy::1413996929527-88::rvsz (generated)::(Checksum: 3:5e3bd661f76ea9ab42001333930a315f)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D8566E31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-88', '2.0.5', '3:5e3bd661f76ea9ab42001333930a315f', 165);

--  Changeset changelog.groovy::1413996929527-89::rvsz (generated)::(Checksum: 3:2735407001dec4274e4afca62608d115)
ALTER TABLE `screenshot` ADD CONSTRAINT `FKE72D85666F8C13FE` FOREIGN KEY (`service_item_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-89', '2.0.5', '3:2735407001dec4274e4afca62608d115', 166);

--  Changeset changelog.groovy::1413996929527-90::rvsz (generated)::(Checksum: 3:70207fa880c0eda8afd7dbe9a27fb58c)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F9388E6B0C4` FOREIGN KEY (`score_card_item_id`) REFERENCES `scorecard` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-90', '2.0.5', '3:70207fa880c0eda8afd7dbe9a27fb58c', 167);

--  Changeset changelog.groovy::1413996929527-91::rvsz (generated)::(Checksum: 3:72da2561cdce8cea6da6967dbffd6b4e)
ALTER TABLE `service_item_score_card_item` ADD CONSTRAINT `FKBF91F936F8C13FE` FOREIGN KEY (`service_item_id`) REFERENCES `listing` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-91', '2.0.5', '3:72da2561cdce8cea6da6967dbffd6b4e', 168);

--  Changeset changelog.groovy::1413996929527-92::rvsz (generated)::(Checksum: 3:ee2cfb0b6b0be590ad21445466455939)
ALTER TABLE `type` ADD CONSTRAINT `FK368F3A7666C6D2` FOREIGN KEY (`created_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-92', '2.0.5', '3:ee2cfb0b6b0be590ad21445466455939', 169);

--  Changeset changelog.groovy::1413996929527-93::rvsz (generated)::(Checksum: 3:4f9b8ed4a1833ad83d238b319835bf8c)
ALTER TABLE `type` ADD CONSTRAINT `FK368F3AE31CB353` FOREIGN KEY (`edited_by_id`) REFERENCES `profile` (`id`);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('rvsz (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1413996929527-93', '2.0.5', '3:4f9b8ed4a1833ad83d238b319835bf8c', 170);

