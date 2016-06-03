	/**
	Updates one Entity in DB using Object with Primary Key.
	*/
	this.updateEntity = function(entity, successCallback, failCallback) {

		updateEntityTransactionSuccess = function() {
			kony.print("updateEntityTransactionSuccess");
			if (typeof(successCallback) != "undefined") {
				successCallback();
			}
		}

		updateEntityTransactionError = function() {
			kony.print("updateEntityTransactionError");
			if (typeof(failCallback) != "undefined") {
				failCallback();
			}
		}

		updateEntityTransaction = function(dbId) {

			updateEntitySuccess = function(transactionId, resultset) {		
				kony.print("updateEntitySuccess");
			}
			
			updateEntityError = function(error) {
				kony.print("updateEntityError");
				kony.print(" Error code:: " + error);
				kony.print(" Error message:: " + error.message);
			}	

			var sqlStatement = T_ENTITY_UPDATE_SQL_STMT;
			kony.db.executeSql(dbId, sqlStatement, null, updateEntitySuccess, updateEntityError);
		}

		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, updateEntityTransaction, updateEntityTransactionError, updateEntityTransactionSuccess);
	}