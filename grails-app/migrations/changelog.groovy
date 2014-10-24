databaseChangeLog = {

	changeSet(author: "rvsz (generated)", id: "1414157183570-1") {
		createTable(tableName: "agency") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "agencyPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "icon_url", type: "varchar(2083)")

			column(name: "short_name", type: "varchar(8)") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-2") {
		createTable(tableName: "application_library_entry") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "application_lPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "folder", type: "varchar(256)")

			column(name: "listing_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "owner_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "application_library_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-3") {
		createTable(tableName: "category") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "categoryPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-4") {
		createTable(tableName: "change_detail") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "change_detailPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "field_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "new_value", type: "varchar(4000)")

			column(name: "old_value", type: "varchar(4000)")

			column(name: "service_item_activity_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-5") {
		createTable(tableName: "contact") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "contactPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "listing_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "organization", type: "varchar(100)")

			column(name: "secure_phone", type: "varchar(50)")

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "unsecure_phone", type: "varchar(50)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-6") {
		createTable(tableName: "contact_type") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "contact_typePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "required", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-7") {
		createTable(tableName: "doc_url") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "doc_urlPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "listing_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(2083)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-8") {
		createTable(tableName: "intent") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "intentPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "action", type: "varchar(64)") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "icon", type: "varchar(2083)")

			column(name: "label", type: "varchar(255)")

			column(name: "type", type: "varchar(129)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-9") {
		createTable(tableName: "item_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "item_commentPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "author_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "listing_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "rate", type: "integer")

			column(name: "text", type: "varchar(4000)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-10") {
		createTable(tableName: "iwc_data_object") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "iwc_data_objePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "content_type", type: "varchar(129)") {
				constraints(nullable: "false")
			}

			column(name: "entity", type: "longtext")

			column(name: "key", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-11") {
		createTable(tableName: "listing") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "listingPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "agency_id", type: "bigint")

			column(name: "approval_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "approved_date", type: "datetime")

			column(name: "avg_rate", type: "float") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(4000)")

			column(name: "description_short", type: "varchar(150)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "image_large_url", type: "varchar(2083)")

			column(name: "image_medium_url", type: "varchar(2083)")

			column(name: "image_small_url", type: "varchar(2083)")

			column(name: "image_xlarge_url", type: "varchar(2083)")

			column(name: "is_enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "is_featured", type: "bit")

			column(name: "last_activity_id", type: "bigint")

			column(name: "launch_url", type: "varchar(2083)")

			column(name: "requirements", type: "varchar(1000)")

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "total_comments", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "total_rate1", type: "integer")

			column(name: "total_rate2", type: "integer")

			column(name: "total_rate3", type: "integer")

			column(name: "total_rate4", type: "integer")

			column(name: "total_rate5", type: "integer")

			column(name: "total_votes", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "version_name", type: "varchar(255)")

			column(name: "what_is_new", type: "varchar(250)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-12") {
		createTable(tableName: "listing_activity") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "listing_activPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "action", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "activity_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "author_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "listing_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "listing_activities_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-13") {
		createTable(tableName: "listing_category") {
			column(name: "listing_categories_id", type: "bigint")

			column(name: "category_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-14") {
		createTable(tableName: "listing_intent") {
			column(name: "listing_intents_id", type: "bigint")

			column(name: "intent_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-15") {
		createTable(tableName: "listing_profile") {
			column(name: "listing_owners_id", type: "bigint")

			column(name: "profile_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-16") {
		createTable(tableName: "listing_snapshot") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "listing_snapsPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "listing_id", type: "bigint")

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-17") {
		createTable(tableName: "listing_tags") {
			column(name: "listing_id", type: "bigint")

			column(name: "tags_string", type: "varchar(255)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-18") {
		createTable(tableName: "modify_relationship_activity") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "modify_relatiPK")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-19") {
		createTable(tableName: "profile") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "bio", type: "varchar(1000)")

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "display_name", type: "varchar(255)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)")

			column(name: "highest_role", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_login", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-20") {
		createTable(tableName: "profile_agency") {
			column(name: "profile_organizations_id", type: "bigint")

			column(name: "agency_id", type: "bigint")

			column(name: "profile_stewarded_organizations_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-21") {
		createTable(tableName: "rejection_activity") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rejection_actPK")
			}

			column(name: "rejection_listing_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-22") {
		createTable(tableName: "rejection_listing") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rejection_lisPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "author_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(2000)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-23") {
		createTable(tableName: "relationship") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "relationshipPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "owning_entity_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "relationship_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-24") {
		createTable(tableName: "relationship_activity_log") {
			column(name: "mod_rel_activity_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "listing_snapshot_id", type: "bigint")

			column(name: "items_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-25") {
		createTable(tableName: "relationship_listing") {
			column(name: "relationship_related_items_id", type: "bigint")

			column(name: "listing_id", type: "bigint")

			column(name: "related_items_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-26") {
		createTable(tableName: "scorecard") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "scorecardPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(500)") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "image", type: "varchar(2083)")

			column(name: "question", type: "varchar(250)") {
				constraints(nullable: "false")
			}

			column(name: "show_on_listing", type: "bit")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-27") {
		createTable(tableName: "screenshot") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "screenshotPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "large_image_url", type: "varchar(2083)")

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "small_image_url", type: "varchar(2083)") {
				constraints(nullable: "false")
			}

			column(name: "ordinal", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-28") {
		createTable(tableName: "service_item_score_card_item") {
			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "score_card_item_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-29") {
		createTable(tableName: "type") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "typePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-94") {
		createIndex(indexName: "FKAB611C057666C6D2", tableName: "agency") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-95") {
		createIndex(indexName: "FKAB611C05E31CB353", tableName: "agency") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-96") {
		createIndex(indexName: "UK492f940b0f57ca03abde64501045", tableName: "agency", unique: "true") {
			column(name: "title")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-97") {
		createIndex(indexName: "short_name_uniq_1414157183392", tableName: "agency", unique: "true") {
			column(name: "short_name")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-98") {
		createIndex(indexName: "FK44E0233F5A4BEA77", tableName: "application_library_entry") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-99") {
		createIndex(indexName: "FK44E0233F6530DF0D", tableName: "application_library_entry") {
			column(name: "owner_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-100") {
		createIndex(indexName: "FK44E0233F7666C6D2", tableName: "application_library_entry") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-101") {
		createIndex(indexName: "FK44E0233FE31CB353", tableName: "application_library_entry") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-102") {
		createIndex(indexName: "unique_listing_id", tableName: "application_library_entry", unique: "true") {
			column(name: "owner_id")

			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-103") {
		createIndex(indexName: "FK302BCFE7666C6D2", tableName: "category") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-104") {
		createIndex(indexName: "FK302BCFEE31CB353", tableName: "category") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-105") {
		createIndex(indexName: "UK7746033a611e7747013c9a9e2900", tableName: "category", unique: "true") {
			column(name: "title")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-106") {
		createIndex(indexName: "FKB4467BC0160FF959", tableName: "change_detail") {
			column(name: "service_item_activity_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-107") {
		createIndex(indexName: "FK38B724205A4BEA77", tableName: "contact") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-108") {
		createIndex(indexName: "FK38B724207666C6D2", tableName: "contact") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-109") {
		createIndex(indexName: "FK38B72420BA3FC877", tableName: "contact") {
			column(name: "type_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-110") {
		createIndex(indexName: "FK38B72420E31CB353", tableName: "contact") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-111") {
		createIndex(indexName: "FK4C2BB7F97666C6D2", tableName: "contact_type") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-112") {
		createIndex(indexName: "FK4C2BB7F9E31CB353", tableName: "contact_type") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-113") {
		createIndex(indexName: "UK9359433766496916df2b541ad47e", tableName: "contact_type", unique: "true") {
			column(name: "title")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-114") {
		createIndex(indexName: "FK6CF91DE85A4BEA77", tableName: "doc_url") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-115") {
		createIndex(indexName: "FKB971369C7666C6D2", tableName: "intent") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-116") {
		createIndex(indexName: "FKB971369CE31CB353", tableName: "intent") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-117") {
		createIndex(indexName: "UKc7042bb056f010832f67f6c69a3e", tableName: "intent", unique: "true") {
			column(name: "type")

			column(name: "action")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-118") {
		createIndex(indexName: "FKE6D04D335A032135", tableName: "item_comment") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-119") {
		createIndex(indexName: "FKE6D04D335A4BEA77", tableName: "item_comment") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-120") {
		createIndex(indexName: "FKE6D04D337666C6D2", tableName: "item_comment") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-121") {
		createIndex(indexName: "FKE6D04D33E31CB353", tableName: "item_comment") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-122") {
		createIndex(indexName: "unique_listing_id", tableName: "item_comment", unique: "true") {
			column(name: "author_id")

			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-123") {
		createIndex(indexName: "FK999DCD2AC0565C57", tableName: "iwc_data_object") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-124") {
		createIndex(indexName: "UKe1b86bb7cb89802b84044c6be65a", tableName: "iwc_data_object", unique: "true") {
			column(name: "key")

			column(name: "profile_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-125") {
		createIndex(indexName: "FKAD8BA84143B24BD", tableName: "listing") {
			column(name: "agency_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-126") {
		createIndex(indexName: "FKAD8BA847666C6D2", tableName: "listing") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-127") {
		createIndex(indexName: "FKAD8BA849809495D", tableName: "listing") {
			column(name: "type_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-128") {
		createIndex(indexName: "FKAD8BA84B803A812", tableName: "listing") {
			column(name: "last_activity_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-129") {
		createIndex(indexName: "FKAD8BA84E31CB353", tableName: "listing") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-130") {
		createIndex(indexName: "FK9CE7FE6A5A032135", tableName: "listing_activity") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-131") {
		createIndex(indexName: "FK9CE7FE6A5A4BEA77", tableName: "listing_activity") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-132") {
		createIndex(indexName: "FK9CE7FE6A7666C6D2", tableName: "listing_activity") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-133") {
		createIndex(indexName: "FK9CE7FE6AE31CB353", tableName: "listing_activity") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-134") {
		createIndex(indexName: "FK29EC859DA41995D", tableName: "listing_category") {
			column(name: "category_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-135") {
		createIndex(indexName: "FK29EC859DB0E6D64", tableName: "listing_category") {
			column(name: "listing_categories_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-136") {
		createIndex(indexName: "FK17BE5CB742D2535F", tableName: "listing_intent") {
			column(name: "listing_intents_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-137") {
		createIndex(indexName: "FK17BE5CB7A651895D", tableName: "listing_intent") {
			column(name: "intent_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-138") {
		createIndex(indexName: "FK58E626EE1459EB60", tableName: "listing_profile") {
			column(name: "listing_owners_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-139") {
		createIndex(indexName: "FK58E626EEC0565C57", tableName: "listing_profile") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-140") {
		createIndex(indexName: "FK1096E11F5A4BEA77", tableName: "listing_snapshot") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-141") {
		createIndex(indexName: "FK483C24F45A4BEA77", tableName: "listing_tags") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-142") {
		createIndex(indexName: "FKE68D3F715416850B", tableName: "modify_relationship_activity") {
			column(name: "id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-143") {
		createIndex(indexName: "FKED8E89A97666C6D2", tableName: "profile") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-144") {
		createIndex(indexName: "FKED8E89A9E31CB353", tableName: "profile") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-145") {
		createIndex(indexName: "UK2e2af56bde6e9cad39c0f4ae1993", tableName: "profile", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-146") {
		createIndex(indexName: "username_uniq_1414157183435", tableName: "profile", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-147") {
		createIndex(indexName: "FKB82D0F5B143B24BD", tableName: "profile_agency") {
			column(name: "agency_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-148") {
		createIndex(indexName: "FKB82D0F5B4B3EE656", tableName: "profile_agency") {
			column(name: "profile_stewarded_organizations_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-149") {
		createIndex(indexName: "FKB82D0F5B7AA654D6", tableName: "profile_agency") {
			column(name: "profile_organizations_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-150") {
		createIndex(indexName: "FKF35C12855416850B", tableName: "rejection_activity") {
			column(name: "id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-151") {
		createIndex(indexName: "FKF35C128582548A4A", tableName: "rejection_activity") {
			column(name: "rejection_listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-152") {
		createIndex(indexName: "FK3F2BD44E5A032135", tableName: "rejection_listing") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-153") {
		createIndex(indexName: "FK3F2BD44E6F8C13FE", tableName: "rejection_listing") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-154") {
		createIndex(indexName: "FK3F2BD44E7666C6D2", tableName: "rejection_listing") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-155") {
		createIndex(indexName: "FK3F2BD44EE31CB353", tableName: "rejection_listing") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-156") {
		createIndex(indexName: "rej_lst_author_id_idx", tableName: "rejection_listing") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-157") {
		createIndex(indexName: "rej_lst_svc_item_id_idx", tableName: "rejection_listing") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-158") {
		createIndex(indexName: "FKF064763845172AD5", tableName: "relationship") {
			column(name: "owning_entity_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-159") {
		createIndex(indexName: "FK594974BB4DC662E0", tableName: "relationship_activity_log") {
			column(name: "listing_snapshot_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-160") {
		createIndex(indexName: "FKDDEF1F7D5A4BEA77", tableName: "relationship_listing") {
			column(name: "listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-161") {
		createIndex(indexName: "FK7EEC20A27666C6D2", tableName: "scorecard") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-162") {
		createIndex(indexName: "FK7EEC20A2E31CB353", tableName: "scorecard") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-163") {
		createIndex(indexName: "FKE72D85666F8C13FE", tableName: "screenshot") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-164") {
		createIndex(indexName: "FKE72D85667666C6D2", tableName: "screenshot") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-165") {
		createIndex(indexName: "FKE72D8566E31CB353", tableName: "screenshot") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-166") {
		createIndex(indexName: "FKBF91F936F8C13FE", tableName: "service_item_score_card_item") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-167") {
		createIndex(indexName: "FKBF91F9388E6B0C4", tableName: "service_item_score_card_item") {
			column(name: "score_card_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-168") {
		createIndex(indexName: "FK368F3A7666C6D2", tableName: "type") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-169") {
		createIndex(indexName: "FK368F3AE31CB353", tableName: "type") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-170") {
		createIndex(indexName: "UK57c992e1354f398a8f71f29226dc", tableName: "type", unique: "true") {
			column(name: "title")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-30") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "agency", constraintName: "FKAB611C057666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-31") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "agency", constraintName: "FKAB611C05E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-32") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "application_library_entry", constraintName: "FK44E0233F7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-33") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "application_library_entry", constraintName: "FK44E0233FE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-34") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "application_library_entry", constraintName: "FK44E0233F5A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-35") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "application_library_entry", constraintName: "FK44E0233F6530DF0D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-36") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "category", constraintName: "FK302BCFE7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-37") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "category", constraintName: "FK302BCFEE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-38") {
		addForeignKeyConstraint(baseColumnNames: "service_item_activity_id", baseTableName: "change_detail", constraintName: "FKB4467BC0160FF959", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-39") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "contact", constraintName: "FK38B724207666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-40") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "contact", constraintName: "FK38B72420E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-41") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "contact", constraintName: "FK38B724205A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-42") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "contact", constraintName: "FK38B72420BA3FC877", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact_type", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-43") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "contact_type", constraintName: "FK4C2BB7F97666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-44") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "contact_type", constraintName: "FK4C2BB7F9E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-45") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "doc_url", constraintName: "FK6CF91DE85A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-46") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "intent", constraintName: "FKB971369C7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-47") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "intent", constraintName: "FKB971369CE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-48") {
		addForeignKeyConstraint(baseColumnNames: "author_id", baseTableName: "item_comment", constraintName: "FKE6D04D335A032135", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-49") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "item_comment", constraintName: "FKE6D04D337666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-50") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "item_comment", constraintName: "FKE6D04D33E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-51") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "item_comment", constraintName: "FKE6D04D335A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-52") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "iwc_data_object", constraintName: "FK999DCD2AC0565C57", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-53") {
		addForeignKeyConstraint(baseColumnNames: "agency_id", baseTableName: "listing", constraintName: "FKAD8BA84143B24BD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agency", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-54") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "listing", constraintName: "FKAD8BA847666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-55") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "listing", constraintName: "FKAD8BA84E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-56") {
		addForeignKeyConstraint(baseColumnNames: "last_activity_id", baseTableName: "listing", constraintName: "FKAD8BA84B803A812", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-57") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "listing", constraintName: "FKAD8BA849809495D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "type", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-58") {
		addForeignKeyConstraint(baseColumnNames: "author_id", baseTableName: "listing_activity", constraintName: "FK9CE7FE6A5A032135", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-59") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "listing_activity", constraintName: "FK9CE7FE6A7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-60") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "listing_activity", constraintName: "FK9CE7FE6AE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-61") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "listing_activity", constraintName: "FK9CE7FE6A5A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-62") {
		addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "listing_category", constraintName: "FK29EC859DA41995D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "category", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-63") {
		addForeignKeyConstraint(baseColumnNames: "listing_categories_id", baseTableName: "listing_category", constraintName: "FK29EC859DB0E6D64", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-64") {
		addForeignKeyConstraint(baseColumnNames: "intent_id", baseTableName: "listing_intent", constraintName: "FK17BE5CB7A651895D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "intent", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-65") {
		addForeignKeyConstraint(baseColumnNames: "listing_intents_id", baseTableName: "listing_intent", constraintName: "FK17BE5CB742D2535F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-66") {
		addForeignKeyConstraint(baseColumnNames: "listing_owners_id", baseTableName: "listing_profile", constraintName: "FK58E626EE1459EB60", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-67") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "listing_profile", constraintName: "FK58E626EEC0565C57", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-68") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "listing_snapshot", constraintName: "FK1096E11F5A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-69") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "listing_tags", constraintName: "FK483C24F45A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-70") {
		addForeignKeyConstraint(baseColumnNames: "id", baseTableName: "modify_relationship_activity", constraintName: "FKE68D3F715416850B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-71") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "profile", constraintName: "FKED8E89A97666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-72") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "profile", constraintName: "FKED8E89A9E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-73") {
		addForeignKeyConstraint(baseColumnNames: "agency_id", baseTableName: "profile_agency", constraintName: "FKB82D0F5B143B24BD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agency", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-74") {
		addForeignKeyConstraint(baseColumnNames: "profile_organizations_id", baseTableName: "profile_agency", constraintName: "FKB82D0F5B7AA654D6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-75") {
		addForeignKeyConstraint(baseColumnNames: "profile_stewarded_organizations_id", baseTableName: "profile_agency", constraintName: "FKB82D0F5B4B3EE656", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-76") {
		addForeignKeyConstraint(baseColumnNames: "id", baseTableName: "rejection_activity", constraintName: "FKF35C12855416850B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-77") {
		addForeignKeyConstraint(baseColumnNames: "rejection_listing_id", baseTableName: "rejection_activity", constraintName: "FKF35C128582548A4A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rejection_listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-78") {
		addForeignKeyConstraint(baseColumnNames: "author_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44E5A032135", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-79") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44E7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-80") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44EE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-81") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44E6F8C13FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-82") {
		addForeignKeyConstraint(baseColumnNames: "owning_entity_id", baseTableName: "relationship", constraintName: "FKF064763845172AD5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-83") {
		addForeignKeyConstraint(baseColumnNames: "listing_snapshot_id", baseTableName: "relationship_activity_log", constraintName: "FK594974BB4DC662E0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing_snapshot", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-84") {
		addForeignKeyConstraint(baseColumnNames: "listing_id", baseTableName: "relationship_listing", constraintName: "FKDDEF1F7D5A4BEA77", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-85") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "scorecard", constraintName: "FK7EEC20A27666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-86") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "scorecard", constraintName: "FK7EEC20A2E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-87") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "screenshot", constraintName: "FKE72D85667666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-88") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "screenshot", constraintName: "FKE72D8566E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-89") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "screenshot", constraintName: "FKE72D85666F8C13FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-90") {
		addForeignKeyConstraint(baseColumnNames: "score_card_item_id", baseTableName: "service_item_score_card_item", constraintName: "FKBF91F9388E6B0C4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "scorecard", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-91") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_score_card_item", constraintName: "FKBF91F936F8C13FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-92") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "type", constraintName: "FK368F3A7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1414157183570-93") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "type", constraintName: "FK368F3AE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}
}
