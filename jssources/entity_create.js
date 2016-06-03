	/**
	Creates Entity Database Table.
	*/
	this.initCreateTableEntity = function(dbId) {
		kony.print("initCreateTableEntity");

		initCreateTableEntityError = function(error) {
			kony.print("initCreateTableEntityError");
			kony.print(" Error code:: " + error);
			kony.print(" Error message:: " + error.message);
		}
		
		initCreateTableEntitySuccess = function(trasactionId, resultset) {
			kony.print("initCreateTableEntitySuccess");
		}

		var sqlStatement = "T_ENTITY_CREATE_SQL_STMT";
		kony.db.executeSql(dbId, sqlStatement, null, initCreateTableEntitySuccess, initCreateTableEntityError);
	}