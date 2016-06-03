	/**
	Counts the amount of rows in the Entity table 
	*/
	this.getEntityCount = function(where, successCallback, failCallback) {
		kony.print("getting Entity count");
		
		var count = -1;
		
		countEntityTransaction = function(dbId) {
			kony.print("countEntityTransaction");
			
			countEntitySuccess = function(transactionId, resultset) {		
				kony.print("countEntitySuccess");
				
				var rowItem = kony.db.sqlResultsetRowItem(transactionId, resultset, 0);
				
				count = rowItem["COUNT (*)"];
			}
			
			countEntityError = function(error) {
				kony.print("countEntityError");
			}	

			var sqlStatement = "SELECT COUNT (*) FROM Entity WHERE " + where;
			kony.db.executeSql(dbId, sqlStatement, null, countEntitySuccess, countEntityError)
		}
		
		countEntityTransactionSuccess = function() {
			kony.print("countEntityTransactionSuccess");
			if (typeof(successCallback) != "undefined") {
				successCallback(count);
			}	
		}
		
		countEntityTransactionError = function() {
			kony.print("countEntityTransactionError");	
			if (typeof(failCallback) != "undefined") {
				failCallback(count);
			}
		}

		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, countEntityTransaction, countEntityTransactionError, countEntityTransactionSuccess);
	}