	/**
	Clears Entity table by droping and creating table.
	*/
	this.clearEntitys = function(successCallback, failCallback) {
		kony.print("clearing Entity table");
		
		clearEntityTransaction = function(dbId) {
			kony.print("clearEntityTransaction");
			
			databaseMaster.initDropTableEntity(dbId);
			databaseMaster.initCreateTableEntity(dbId)
		}
		
		clearEntityTransactionSuccess = function() {
			kony.print("clearEntityTransactionSuccess");
			if (typeof(successCallback) != "undefined") {
				successCallback();
			}	
		}
		
		clearEntityTransactionError = function() {
			kony.print("clearEntityTransactionError");	
			if (typeof(failCallback) != "undefined") {
				failCallback();
			}
		}

		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, clearEntityTransaction, clearEntityTransactionError, clearEntityTransactionSuccess);
	}