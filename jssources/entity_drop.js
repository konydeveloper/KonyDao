	/**
	Drops Entity Database Table.
	*/
	this.initDropTableEntity = function(dbId) {
		kony.print("initDropTableEntity");

		initDropTableEntityError = function(error) {
			kony.print("initDropTableEntityError");		
			kony.print(" Error code:: " + error);
			kony.print(" Error message:: " + error.message);
		}

		initDropTableEntitySuccess = function(transactionId, resultset) {
			kony.print("initDropTableEntitySuccess");		
		}

		var sqlStatement = "DROP TABLE IF EXISTS Entity";
		kony.db.executeSql(dbId, sqlStatement, null, initDropTableEntitySuccess, initDropTableEntityError);		
	}