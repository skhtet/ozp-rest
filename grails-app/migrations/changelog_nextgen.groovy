databaseChangeLog = {

	changeSet(author: "rfpuder (generated)", id: "1409052431765-1") {
		createTable(tableName: "profile_user_data_map") {
			column(name: "user_data_map", type: "bigint")

			column(name: "user_data_map_idx", type: "varchar(255)")

			column(name: "user_data_map_elt", type: "longvarchar") {
				constraints(nullable: "false")
			}
		}
	}
}
