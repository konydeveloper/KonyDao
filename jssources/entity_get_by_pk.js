	/**
	Gets one Entity from DB using Primary Key.

	SuccessCallback is called with an Entity Object, if there is a results. 
	FailCallback is called, if there are no results or an error occurred.
	*/
	this.getEntity = function(pk, successCallback, failCallback) {
		kony.print("getEntity");
		var entity;

		getEntityTransactionSuccess = function() {
			kony.print("getEntityTransactionSuccess");
			if (typeof(entity) != "undefined") {
				if (typeof(successCallback) != "undefined") {
					successCallback(entity);
				}				
			} else {		
				if (typeof(failCallback) != "undefined") {
					failCallback();
				}
			}
		}

		getEntityTransactionError = function() {
			kony.print("getEntityTransactionError");		
			if (typeof(failCallback) != "undefined") {
				failCallback();
			}
		}

		getEntityTransaction = function(dbId) {

			getEntitySuccess = function(transactionId, resultset) {		
				kony.print("getEntitySuccess");
				if (resultset != null && resultset.rows.length > 0) {
					var rowItem = kony.db.sqlResultsetRowItem(transactionId, resultset, 0);
					entity = databaseMaster.getEntityFromRowItem(rowItem);
					databaseMaster.setEntityRelationships(entity);
				} else {
					kony.print("Table contains no entries");
				}
			}
			
			getEntityError = function(error) {
				kony.print("getEntityError");
				kony.print(" Error code:: " + error);
				kony.print(" Error message:: " + error.message);
			}	

			var sqlStatement = "SELECT * FROM Entity WHERE T_ENTITY_GET_BY_PK_PRIMAR_KEY = " + pk;
			kony.db.executeSql(dbId, sqlStatement, null, getEntitySuccess, getEntityError)
		}

		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, getEntityTransaction, getEntityTransactionError, getEntityTransactionSuccess);
	}