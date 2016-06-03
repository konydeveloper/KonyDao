	/**
	Deletes Entitys from DB using where condition.
	*/
	this.deleteEntity = function(where, successCallback, failCallback) {
		kony.print("deleteEntity");
		
		deleteEntityTransactionSuccess = function() {
			kony.print("deleteEntityTransactionSuccess");			
			if (typeof(successCallback) != "undefined") {
				successCallback();
			}	
		}

		deleteEntityTransactionError = function() {
			kony.print("deleteEntityTransactionError");		
			if (typeof(failCallback) != "undefined") {
				failCallback();
			}
		}

		deleteEntityTransaction = function(dbId) {

			deleteEntitySuccess = function(transactionId, resultset) {		
				kony.print("deleteEntitySuccess");
			}
			
			deleteEntityError = function(error) {
				kony.print("deleteEntityError");
			}	

			var sqlStatement = "DELETE FROM Entity WHERE " + where;
			kony.db.executeSql(dbId, sqlStatement, null, deleteEntitySuccess, deleteEntityError)
		}


		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, deleteEntityTransaction, deleteEntityTransactionError, deleteEntityTransactionSuccess);
	}