--rename service_item to listing
RENAME TABLE service_item TO listing;
RENAME TABLE service_item_category TO listing_category;
RENAME TABLE service_item_profile TO listing_profile;

-- Convert is_hidden to is_enabled boolean
ALTER TABLE listing CHANGE is_hidden is_enabled BOOLEAN;

-- Convert approval_status
ALTER TABLE listing MODIFY approval_status varchar(255);
UPDATE listing SET approval_status = "IN_PROGRESS";

-- Rename types to type
RENAME TABLE types to type;

-- Drop columns from service_item table
ALTER TABLE listing DROP release_date;
ALTER TABLE listing DROP is_outside;
ALTER TABLE listing DROP opens_in_new_browser_tab;

-- rename service_item_activity to listing_activity
RENAME TABLE service_item_activity to listing_activity;

-- delete relationship table
ALTER TABLE listing ADD COLUMN relationship varchar(255);
UPDATE listing, relationship SET listing.relationship = relationship.relationship_type where listing.id = relationship.owning_entity_id;
DROP TABLE relationship;
DROP TABLE relationship_service_item;
DROP TABLE relationship_activity_log;

-- remove state table
ALTER TABLE state DROP FOREIGN KEY `FK68AC4917666C6D2`;
ALTER TABLE state DROP FOREIGN KEY `FK68AC491E31CB353`;
ALTER TABLE state DROP created_by_id;
ALTER TABLE state DROP edited_by_id;
ALTER TABLE listing DROP FOREIGN KEY `KF1571565DDFEC3E97`;
ALTER TABLE listing DROP state_id;
DROP TABLE state;

-- remove custom_field and related tables
DROP TABLE service_item_custom_field;
DROP TABLE custom_field, custom_field_definition, custom_field_definition_types;

-- remove affiliated_marketplace table
DROP TABLE affiliated_marketplace;

-- remove avatar table
ALTER TABLE avatar DROP FOREIGN KEY `FKAC32C1597666C6D2`;
ALTER TABLE avatar DROP created_by_id;
ALTER TABLE avatar DROP FOREIGN KEY `FKAC32C159E31CB353`;
ALTER TABLE avatar DROP edited_by_id;
ALTER TABLE profile DROP FOREIGN KEY `FKED8E89A861C3343D`;
ALTER TABLE profile DROP avatar_id;
DROP TABLE avatar;

-- remove uuid from category table
ALTER TABLE category DROP uuid;

