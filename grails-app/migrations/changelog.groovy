databaseChangeLog = {

	changeSet(author: "rvsz (generated)", id: "1411396286906-1") {
		createTable(tableName: "affiliated_marketplace") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "affiliated_maPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "integer") {
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

			column(name: "icon_id", type: "bigint")

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "server_url", type: "varchar(2083)") {
				constraints(nullable: "false")
			}

			column(name: "timeout", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-2") {
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

			column(name: "icon_url", type: "varchar(2000)")

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-3") {
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

			column(name: "owner_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "application_library_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-4") {
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

			column(name: "description", type: "varchar(250)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-5") {
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

	changeSet(author: "rvsz (generated)", id: "1411396286906-6") {
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

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "organization", type: "varchar(100)")

			column(name: "secure_phone", type: "varchar(50)")

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "unsecure_phone", type: "varchar(50)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-7") {
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

	changeSet(author: "rvsz (generated)", id: "1411396286906-8") {
		createTable(tableName: "default_images") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "default_imagePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "defined_default_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "image_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-9") {
		createTable(tableName: "images") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imagesPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "bytes", type: "mediumblob") {
				constraints(nullable: "false")
			}

			column(name: "content_type", type: "varchar(255)")

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "image_size", type: "double precision")

			column(name: "is_default", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-10") {
		createTable(tableName: "import_task") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "import_taskPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "cron_exp", type: "varchar(255)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "exec_interval", type: "integer")

			column(name: "extra_url_params", type: "varchar(512)")

			column(name: "interface_config_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "keystore_pass", type: "varchar(2048)")

			column(name: "keystore_path", type: "varchar(2048)")

			column(name: "last_run_result_id", type: "bigint")

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "truststore_path", type: "varchar(2048)")

			column(name: "update_type", type: "varchar(7)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(255)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-11") {
		createTable(tableName: "import_task_result") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "import_task_rPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(4000)") {
				constraints(nullable: "false")
			}

			column(name: "result", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "run_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "task_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-12") {
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

	changeSet(author: "rvsz (generated)", id: "1411396286906-13") {
		createTable(tableName: "interface_configuration") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interface_conPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "allow_truncate", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "auto_create_meta_data", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "default_large_icon_url", type: "varchar(2048)")

			column(name: "default_small_icon_url", type: "varchar(2048)")

			column(name: "delta_since_time_param", type: "varchar(64)")

			column(name: "delta_static_parameters", type: "varchar(2048)")

			column(name: "download_images", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "full_static_parameters", type: "varchar(2048)")

			column(name: "loose_match", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(256)") {
				constraints(nullable: "false")
			}

			column(name: "query_date_format", type: "varchar(32)")

			column(name: "response_date_format", type: "varchar(32)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-14") {
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

			column(name: "rate", type: "float")

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "text", type: "varchar(4000)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-15") {
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

			column(name: "entity", type: "varchar(255)")

			column(name: "key", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-16") {
		createTable(tableName: "modify_relationship_activity") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "modify_relatiPK")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-17") {
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

			column(name: "display_name", type: "varchar(256)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(256)")

			column(name: "highest_role", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_login", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(256)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-18") {
		createTable(tableName: "profile_agency") {
			column(name: "profile_organizations_id", type: "bigint")

			column(name: "agency_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-19") {
		createTable(tableName: "rejection_activity") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rejection_actPK")
			}

			column(name: "rejection_listing_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-20") {
		createTable(tableName: "rejection_justification") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rejection_jusPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(250)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-21") {
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

			column(name: "justification_id", type: "bigint")

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-22") {
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

	changeSet(author: "rvsz (generated)", id: "1411396286906-23") {
		createTable(tableName: "relationship_activity_log") {
			column(name: "mod_rel_activity_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "service_item_snapshot_id", type: "bigint")

			column(name: "items_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-24") {
		createTable(tableName: "relationship_service_item") {
			column(name: "relationship_related_items_id", type: "bigint")

			column(name: "service_item_id", type: "bigint")

			column(name: "related_items_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-25") {
		createTable(tableName: "score_card_item") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "score_card_itPK")
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

			column(name: "image", type: "varchar(250)")

			column(name: "question", type: "varchar(250)") {
				constraints(nullable: "false")
			}

			column(name: "show_on_listing", type: "bit")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-26") {
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

	changeSet(author: "rvsz (generated)", id: "1411396286906-27") {
		createTable(tableName: "service_item") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "service_itemPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "agency_id", type: "bigint")

			column(name: "approval_status", type: "varchar(11)") {
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

			column(name: "title", type: "varchar(256)") {
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

			column(name: "version_name", type: "varchar(256)")

			column(name: "what_is_new", type: "varchar(250)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-28") {
		createTable(tableName: "service_item_activity") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "service_item_PK")
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

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "service_item_activities_idx", type: "integer")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-29") {
		createTable(tableName: "service_item_category") {
			column(name: "service_item_categories_id", type: "bigint")

			column(name: "category_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-30") {
		createTable(tableName: "service_item_documentation_url") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "service_item_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(2083)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-31") {
		createTable(tableName: "service_item_intents") {
			column(name: "intent_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-32") {
		createTable(tableName: "service_item_profile") {
			column(name: "service_item_owners_id", type: "bigint")

			column(name: "profile_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-33") {
		createTable(tableName: "service_item_score_card_item") {
			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "score_card_item_id", type: "bigint")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-34") {
		createTable(tableName: "service_item_snapshot") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "service_item_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "service_item_id", type: "bigint")

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-35") {
		createTable(tableName: "service_item_tag") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "service_item_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "service_item_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "tag_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-36") {
		createTable(tableName: "service_item_tags") {
			column(name: "service_item_id", type: "bigint")

			column(name: "tags_string", type: "varchar(255)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-37") {
		createTable(tableName: "tag") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tagPK")
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

			column(name: "title", type: "varchar(16)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-38") {
		createTable(tableName: "types") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "typesPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint")

			column(name: "created_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(250)")

			column(name: "edited_by_id", type: "bigint")

			column(name: "edited_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "has_icons", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "has_launch_url", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "image_id", type: "bigint")

			column(name: "is_permanent", type: "bit")

			column(name: "ozone_aware", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-39") {
		addPrimaryKey(columnNames: "service_item_id, intent_id", tableName: "service_item_intents")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-125") {
		createIndex(indexName: "FKA6EB2C37666C6D2", tableName: "affiliated_marketplace") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-126") {
		createIndex(indexName: "FKA6EB2C3E31CB353", tableName: "affiliated_marketplace") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-127") {
		createIndex(indexName: "FKA6EB2C3EA25263C", tableName: "affiliated_marketplace") {
			column(name: "icon_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-128") {
		createIndex(indexName: "FKAB611C057666C6D2", tableName: "agency") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-129") {
		createIndex(indexName: "FKAB611C05E31CB353", tableName: "agency") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-130") {
		createIndex(indexName: "FK44E0233F6530DF0D", tableName: "application_library_entry") {
			column(name: "owner_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-131") {
		createIndex(indexName: "FK44E0233F7666C6D2", tableName: "application_library_entry") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-132") {
		createIndex(indexName: "FK44E0233FC7E5C662", tableName: "application_library_entry") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-133") {
		createIndex(indexName: "FK44E0233FE31CB353", tableName: "application_library_entry") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-134") {
		createIndex(indexName: "unique_service_item_id", tableName: "application_library_entry", unique: "true") {
			column(name: "owner_id")

			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-135") {
		createIndex(indexName: "FK302BCFE7666C6D2", tableName: "category") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-136") {
		createIndex(indexName: "FK302BCFEE31CB353", tableName: "category") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-137") {
		createIndex(indexName: "uuid_uniq_1411396286730", tableName: "category", unique: "true") {
			column(name: "uuid")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-138") {
		createIndex(indexName: "FKB4467BC0855307BD", tableName: "change_detail") {
			column(name: "service_item_activity_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-139") {
		createIndex(indexName: "FK38B724207666C6D2", tableName: "contact") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-140") {
		createIndex(indexName: "FK38B72420BA3FC877", tableName: "contact") {
			column(name: "type_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-141") {
		createIndex(indexName: "FK38B72420C7E5C662", tableName: "contact") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-142") {
		createIndex(indexName: "FK38B72420E31CB353", tableName: "contact") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-143") {
		createIndex(indexName: "FK4C2BB7F97666C6D2", tableName: "contact_type") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-144") {
		createIndex(indexName: "FK4C2BB7F9E31CB353", tableName: "contact_type") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-145") {
		createIndex(indexName: "title_uniq_1411396286735", tableName: "contact_type", unique: "true") {
			column(name: "title")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-146") {
		createIndex(indexName: "FK6F064E36553AF61A", tableName: "default_images") {
			column(name: "image_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-147") {
		createIndex(indexName: "FK6F064E367666C6D2", tableName: "default_images") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-148") {
		createIndex(indexName: "FK6F064E36E31CB353", tableName: "default_images") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-149") {
		createIndex(indexName: "FKB95A82787666C6D2", tableName: "images") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-150") {
		createIndex(indexName: "FKB95A8278E31CB353", tableName: "images") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-151") {
		createIndex(indexName: "FK578EF9DF7666C6D2", tableName: "import_task") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-152") {
		createIndex(indexName: "FK578EF9DF919216CA", tableName: "import_task") {
			column(name: "last_run_result_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-153") {
		createIndex(indexName: "FK578EF9DFA31F8712", tableName: "import_task") {
			column(name: "interface_config_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-154") {
		createIndex(indexName: "FK578EF9DFE31CB353", tableName: "import_task") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-155") {
		createIndex(indexName: "name_uniq_1411396286740", tableName: "import_task", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-156") {
		createIndex(indexName: "FK983AC27D11D7F882", tableName: "import_task_result") {
			column(name: "task_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-157") {
		createIndex(indexName: "FKB971369C7666C6D2", tableName: "intent") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-158") {
		createIndex(indexName: "FKB971369CE31CB353", tableName: "intent") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-159") {
		createIndex(indexName: "UKc7042bb056f010832f67f6c69a3e", tableName: "intent", unique: "true") {
			column(name: "type")

			column(name: "action")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-160") {
		createIndex(indexName: "FKE6D04D335A032135", tableName: "item_comment") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-161") {
		createIndex(indexName: "FKE6D04D337666C6D2", tableName: "item_comment") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-162") {
		createIndex(indexName: "FKE6D04D33C7E5C662", tableName: "item_comment") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-163") {
		createIndex(indexName: "FKE6D04D33E31CB353", tableName: "item_comment") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-164") {
		createIndex(indexName: "itm_cmnt_author_id_idx", tableName: "item_comment") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-165") {
		createIndex(indexName: "itm_cmnt_svc_item_id_idx", tableName: "item_comment") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-166") {
		createIndex(indexName: "FK999DCD2AC0565C57", tableName: "iwc_data_object") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-167") {
		createIndex(indexName: "UKe1b86bb7cb89802b84044c6be65a", tableName: "iwc_data_object", unique: "true") {
			column(name: "key")

			column(name: "profile_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-168") {
		createIndex(indexName: "FKE68D3F71C359936F", tableName: "modify_relationship_activity") {
			column(name: "id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-169") {
		createIndex(indexName: "FKED8E89A97666C6D2", tableName: "profile") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-170") {
		createIndex(indexName: "FKED8E89A9E31CB353", tableName: "profile") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-171") {
		createIndex(indexName: "username_uniq_1411396286759", tableName: "profile", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-172") {
		createIndex(indexName: "uuid_uniq_1411396286760", tableName: "profile", unique: "true") {
			column(name: "uuid")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-173") {
		createIndex(indexName: "FKB82D0F5B143B24BD", tableName: "profile_agency") {
			column(name: "agency_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-174") {
		createIndex(indexName: "FKB82D0F5B7AA654D6", tableName: "profile_agency") {
			column(name: "profile_organizations_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-175") {
		createIndex(indexName: "FKF35C128582548A4A", tableName: "rejection_activity") {
			column(name: "rejection_listing_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-176") {
		createIndex(indexName: "FKF35C1285C359936F", tableName: "rejection_activity") {
			column(name: "id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-177") {
		createIndex(indexName: "FK12B0A53C7666C6D2", tableName: "rejection_justification") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-178") {
		createIndex(indexName: "FK12B0A53CE31CB353", tableName: "rejection_justification") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-179") {
		createIndex(indexName: "FK3F2BD44E19CEB614", tableName: "rejection_listing") {
			column(name: "justification_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-180") {
		createIndex(indexName: "FK3F2BD44E5A032135", tableName: "rejection_listing") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-181") {
		createIndex(indexName: "FK3F2BD44E7666C6D2", tableName: "rejection_listing") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-182") {
		createIndex(indexName: "FK3F2BD44EC7E5C662", tableName: "rejection_listing") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-183") {
		createIndex(indexName: "FK3F2BD44EE31CB353", tableName: "rejection_listing") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-184") {
		createIndex(indexName: "rej_lst_author_id_idx", tableName: "rejection_listing") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-185") {
		createIndex(indexName: "rej_lst_svc_item_id_idx", tableName: "rejection_listing") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-186") {
		createIndex(indexName: "FKF06476389D70DD39", tableName: "relationship") {
			column(name: "owning_entity_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-187") {
		createIndex(indexName: "FK594974BB25A20F9D", tableName: "relationship_activity_log") {
			column(name: "service_item_snapshot_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-188") {
		createIndex(indexName: "FKDA02504C7E5C662", tableName: "relationship_service_item") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-189") {
		createIndex(indexName: "FKE51CCD757666C6D2", tableName: "score_card_item") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-190") {
		createIndex(indexName: "FKE51CCD75E31CB353", tableName: "score_card_item") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-191") {
		createIndex(indexName: "FKE72D85667666C6D2", tableName: "screenshot") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-192") {
		createIndex(indexName: "FKE72D8566C7E5C662", tableName: "screenshot") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-193") {
		createIndex(indexName: "FKE72D8566E31CB353", tableName: "screenshot") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-194") {
		createIndex(indexName: "FK1571565D143B24BD", tableName: "service_item") {
			column(name: "agency_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-195") {
		createIndex(indexName: "FK1571565D2746B676", tableName: "service_item") {
			column(name: "last_activity_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-196") {
		createIndex(indexName: "FK1571565D5E919B36", tableName: "service_item") {
			column(name: "type_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-197") {
		createIndex(indexName: "FK1571565D7666C6D2", tableName: "service_item") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-198") {
		createIndex(indexName: "FK1571565DE31CB353", tableName: "service_item") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-199") {
		createIndex(indexName: "FK870EA6B15A032135", tableName: "service_item_activity") {
			column(name: "author_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-200") {
		createIndex(indexName: "FK870EA6B17666C6D2", tableName: "service_item_activity") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-201") {
		createIndex(indexName: "FK870EA6B1C7E5C662", tableName: "service_item_activity") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-202") {
		createIndex(indexName: "FK870EA6B1E31CB353", tableName: "service_item_activity") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-203") {
		createIndex(indexName: "svc_item_act_svc_item_id_idx", tableName: "service_item_activity") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-204") {
		createIndex(indexName: "FKECC570A0D8528BE1", tableName: "service_item_category") {
			column(name: "service_item_categories_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-205") {
		createIndex(indexName: "FKECC570A0DA41995D", tableName: "service_item_category") {
			column(name: "category_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-206") {
		createIndex(indexName: "FK24572D08C7E5C662", tableName: "service_item_documentation_url") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-207") {
		createIndex(indexName: "FKEFDCED75A651895D", tableName: "service_item_intents") {
			column(name: "intent_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-208") {
		createIndex(indexName: "FKEFDCED75C7E5C662", tableName: "service_item_intents") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-209") {
		createIndex(indexName: "FK68B5D9C7C0565C57", tableName: "service_item_profile") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-210") {
		createIndex(indexName: "FK68B5D9C7C761FE5D", tableName: "service_item_profile") {
			column(name: "service_item_owners_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-211") {
		createIndex(indexName: "FKBF91F93C7E5C662", tableName: "service_item_score_card_item") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-212") {
		createIndex(indexName: "FKBF91F93EF469C97", tableName: "service_item_score_card_item") {
			column(name: "score_card_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-213") {
		createIndex(indexName: "FKFABD8966C7E5C662", tableName: "service_item_snapshot") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-214") {
		createIndex(indexName: "FKB621CEB87666C6D2", tableName: "service_item_tag") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-215") {
		createIndex(indexName: "FKB621CEB8C7E5C662", tableName: "service_item_tag") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-216") {
		createIndex(indexName: "FKB621CEB8EACAF137", tableName: "service_item_tag") {
			column(name: "tag_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-217") {
		createIndex(indexName: "service_item_tag_si_idx", tableName: "service_item_tag") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-218") {
		createIndex(indexName: "service_item_tag_tag_idx", tableName: "service_item_tag") {
			column(name: "tag_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-219") {
		createIndex(indexName: "FKE1808BBC7E5C662", tableName: "service_item_tags") {
			column(name: "service_item_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-220") {
		createIndex(indexName: "FK1BF9A7666C6D2", tableName: "tag") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-221") {
		createIndex(indexName: "FK1BF9AE31CB353", tableName: "tag") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-222") {
		createIndex(indexName: "tag_title_idx", tableName: "tag") {
			column(name: "title")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-223") {
		createIndex(indexName: "FK69B5879553AF61A", tableName: "types") {
			column(name: "image_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-224") {
		createIndex(indexName: "FK69B58797666C6D2", tableName: "types") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-225") {
		createIndex(indexName: "FK69B5879E31CB353", tableName: "types") {
			column(name: "edited_by_id")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-226") {
		createIndex(indexName: "uuid_uniq_1411396286783", tableName: "types", unique: "true") {
			column(name: "uuid")
		}
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-40") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "affiliated_marketplace", constraintName: "FKA6EB2C37666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-41") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "affiliated_marketplace", constraintName: "FKA6EB2C3E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-42") {
		addForeignKeyConstraint(baseColumnNames: "icon_id", baseTableName: "affiliated_marketplace", constraintName: "FKA6EB2C3EA25263C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "images", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-43") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "agency", constraintName: "FKAB611C057666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-44") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "agency", constraintName: "FKAB611C05E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-45") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "application_library_entry", constraintName: "FK44E0233F7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-46") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "application_library_entry", constraintName: "FK44E0233FE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-47") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "application_library_entry", constraintName: "FK44E0233F6530DF0D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-48") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "application_library_entry", constraintName: "FK44E0233FC7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-49") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "category", constraintName: "FK302BCFE7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-50") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "category", constraintName: "FK302BCFEE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-51") {
		addForeignKeyConstraint(baseColumnNames: "service_item_activity_id", baseTableName: "change_detail", constraintName: "FKB4467BC0855307BD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-52") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "contact", constraintName: "FK38B724207666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-53") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "contact", constraintName: "FK38B72420E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-54") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "contact", constraintName: "FK38B72420C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-55") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "contact", constraintName: "FK38B72420BA3FC877", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact_type", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-56") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "contact_type", constraintName: "FK4C2BB7F97666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-57") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "contact_type", constraintName: "FK4C2BB7F9E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-58") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "default_images", constraintName: "FK6F064E367666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-59") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "default_images", constraintName: "FK6F064E36E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-60") {
		addForeignKeyConstraint(baseColumnNames: "image_id", baseTableName: "default_images", constraintName: "FK6F064E36553AF61A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "images", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-61") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "images", constraintName: "FKB95A82787666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-62") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "images", constraintName: "FKB95A8278E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-63") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "import_task", constraintName: "FK578EF9DF7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-64") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "import_task", constraintName: "FK578EF9DFE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-65") {
		addForeignKeyConstraint(baseColumnNames: "interface_config_id", baseTableName: "import_task", constraintName: "FK578EF9DFA31F8712", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "interface_configuration", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-66") {
		addForeignKeyConstraint(baseColumnNames: "last_run_result_id", baseTableName: "import_task", constraintName: "FK578EF9DF919216CA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "import_task_result", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-67") {
		addForeignKeyConstraint(baseColumnNames: "task_id", baseTableName: "import_task_result", constraintName: "FK983AC27D11D7F882", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "import_task", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-68") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "intent", constraintName: "FKB971369C7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-69") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "intent", constraintName: "FKB971369CE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-70") {
		addForeignKeyConstraint(baseColumnNames: "author_id", baseTableName: "item_comment", constraintName: "FKE6D04D335A032135", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-71") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "item_comment", constraintName: "FKE6D04D337666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-72") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "item_comment", constraintName: "FKE6D04D33E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-73") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "item_comment", constraintName: "FKE6D04D33C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-74") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "iwc_data_object", constraintName: "FK999DCD2AC0565C57", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-75") {
		addForeignKeyConstraint(baseColumnNames: "id", baseTableName: "modify_relationship_activity", constraintName: "FKE68D3F71C359936F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-76") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "profile", constraintName: "FKED8E89A97666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-77") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "profile", constraintName: "FKED8E89A9E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-78") {
		addForeignKeyConstraint(baseColumnNames: "agency_id", baseTableName: "profile_agency", constraintName: "FKB82D0F5B143B24BD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agency", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-79") {
		addForeignKeyConstraint(baseColumnNames: "profile_organizations_id", baseTableName: "profile_agency", constraintName: "FKB82D0F5B7AA654D6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-80") {
		addForeignKeyConstraint(baseColumnNames: "id", baseTableName: "rejection_activity", constraintName: "FKF35C1285C359936F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-81") {
		addForeignKeyConstraint(baseColumnNames: "rejection_listing_id", baseTableName: "rejection_activity", constraintName: "FKF35C128582548A4A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rejection_listing", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-82") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "rejection_justification", constraintName: "FK12B0A53C7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-83") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "rejection_justification", constraintName: "FK12B0A53CE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-84") {
		addForeignKeyConstraint(baseColumnNames: "author_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44E5A032135", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-85") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44E7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-86") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44EE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-87") {
		addForeignKeyConstraint(baseColumnNames: "justification_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44E19CEB614", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rejection_justification", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-88") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "rejection_listing", constraintName: "FK3F2BD44EC7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-89") {
		addForeignKeyConstraint(baseColumnNames: "owning_entity_id", baseTableName: "relationship", constraintName: "FKF06476389D70DD39", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-90") {
		addForeignKeyConstraint(baseColumnNames: "service_item_snapshot_id", baseTableName: "relationship_activity_log", constraintName: "FK594974BB25A20F9D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item_snapshot", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-91") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "relationship_service_item", constraintName: "FKDA02504C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-92") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "score_card_item", constraintName: "FKE51CCD757666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-93") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "score_card_item", constraintName: "FKE51CCD75E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-94") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "screenshot", constraintName: "FKE72D85667666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-95") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "screenshot", constraintName: "FKE72D8566E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-96") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "screenshot", constraintName: "FKE72D8566C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-97") {
		addForeignKeyConstraint(baseColumnNames: "agency_id", baseTableName: "service_item", constraintName: "FK1571565D143B24BD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agency", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-98") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "service_item", constraintName: "FK1571565D7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-99") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "service_item", constraintName: "FK1571565DE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-100") {
		addForeignKeyConstraint(baseColumnNames: "last_activity_id", baseTableName: "service_item", constraintName: "FK1571565D2746B676", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-101") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "service_item", constraintName: "FK1571565D5E919B36", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "types", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-102") {
		addForeignKeyConstraint(baseColumnNames: "author_id", baseTableName: "service_item_activity", constraintName: "FK870EA6B15A032135", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-103") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "service_item_activity", constraintName: "FK870EA6B17666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-104") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "service_item_activity", constraintName: "FK870EA6B1E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-105") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_activity", constraintName: "FK870EA6B1C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-106") {
		addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "service_item_category", constraintName: "FKECC570A0DA41995D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "category", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-107") {
		addForeignKeyConstraint(baseColumnNames: "service_item_categories_id", baseTableName: "service_item_category", constraintName: "FKECC570A0D8528BE1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-108") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_documentation_url", constraintName: "FK24572D08C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-109") {
		addForeignKeyConstraint(baseColumnNames: "intent_id", baseTableName: "service_item_intents", constraintName: "FKEFDCED75A651895D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "intent", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-110") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_intents", constraintName: "FKEFDCED75C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-111") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "service_item_profile", constraintName: "FK68B5D9C7C0565C57", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-112") {
		addForeignKeyConstraint(baseColumnNames: "service_item_owners_id", baseTableName: "service_item_profile", constraintName: "FK68B5D9C7C761FE5D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-113") {
		addForeignKeyConstraint(baseColumnNames: "score_card_item_id", baseTableName: "service_item_score_card_item", constraintName: "FKBF91F93EF469C97", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "score_card_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-114") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_score_card_item", constraintName: "FKBF91F93C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-115") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_snapshot", constraintName: "FKFABD8966C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-116") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "service_item_tag", constraintName: "FKB621CEB87666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-117") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_tag", constraintName: "FKB621CEB8C7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-118") {
		addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "service_item_tag", constraintName: "FKB621CEB8EACAF137", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tag", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-119") {
		addForeignKeyConstraint(baseColumnNames: "service_item_id", baseTableName: "service_item_tags", constraintName: "FKE1808BBC7E5C662", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "service_item", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-120") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "tag", constraintName: "FK1BF9A7666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-121") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "tag", constraintName: "FK1BF9AE31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-122") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "types", constraintName: "FK69B58797666C6D2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-123") {
		addForeignKeyConstraint(baseColumnNames: "edited_by_id", baseTableName: "types", constraintName: "FK69B5879E31CB353", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rvsz (generated)", id: "1411396286906-124") {
		addForeignKeyConstraint(baseColumnNames: "image_id", baseTableName: "types", constraintName: "FK69B5879553AF61A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "images", referencesUniqueColumn: "false")
	}
}
