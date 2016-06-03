	/**
	Inserts Entitys into DB.
	*/
	this.insertEntity = function(entity, successCallback, failCallback) {
		kony.print("insertEntity");

		insertEntityTransactionSuccess = function() {
			kony.print("insertEntityTransactionSuccess");
			if (typeof(successCallback) != "undefined") {
				successCallback();
			}			
		}

		insertEntityTransactionError = function() {
			kony.print("insertEntityTransactionError");	
			if (typeof(failCallback) != "undefined") {
				failCallback();
			}
		}

		insertEntityTransaction = function(dbId) {
			kony.print("insertEntityTransaction");

			insertEntitySuccess = function(trasactionId, resultset) {
				kony.print("insertEntitySuccess");
			}

			insertEntityError = function(error) {
				kony.print("insertEntityError");
				kony.print(" Error code:: " + error);
				kony.print(" Error message:: " + error.message);
			}

			var sqlStatement = T_ENTITY_INSERT_SQL_STMT;
			kony.db.executeSql(dbId, sqlStatement, null, insertEntitySuccess, insertEntityError)
		}
		
		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, insertEntityTransaction, insertEntityTransactionError, insertEntityTransactionSuccess);
	}
