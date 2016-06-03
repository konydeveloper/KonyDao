	/**
	Gets Entitys from DB. Optional where statement to filter. e.g. where = "type=10"

	SuccessCallback is called with an array of Entity Objects, if there are results. 
	FailCallback is called, if there are no results or an error occurred.
	*/
	this.getEntitys = function(successCallback, failCallback, where) {
		kony.print("getEntitys");
		var result = [];

		getEntitysTransactionSuccess = function() {
			kony.print("getEntitysTransactionSuccess");			
			if (typeof(successCallback) != "undefined") {
				successCallback(result);
			}	
		}

		getEntitysTransactionError = function() {
			kony.print("getEntitysTransactionError");
			if (typeof(failCallback) != "undefined") {
				failCallback();
			}
		}
			
		getEntitysTransaction = function(dbId) {

			getEntitysSuccess = function(transactionId, resultset) {
		
				kony.print("getEntitysSuccess");
				if (resultset != null && resultset.rows.length > 0) {					

					for (var i = 0; i < resultset.rows.length; i++) {
						var rowItem = kony.db.sqlResultsetRowItem(transactionId, resultset, i);
						var entity = databaseMaster.getEntityFromRowItem(rowItem);
						databaseMaster.setEntityRelationships(entity);

						result.push(entity);									
					}

				} else {
					kony.print("Table contains no entries");
				}
			}
			
			getEntitysError = function(error) {
				kony.print("getEntitysError");
				kony.print(" Error code:: " + error);
				kony.print(" Error message:: " + error.message);
			}	

			var sqlStatement = "SELECT * FROM Entity";
			
			if (typeof(where) != "undefined") {
				sqlStatement = sqlStatement + " WHERE " + where;
			}
			
			kony.db.executeSql(dbId, sqlStatement, null, getEntitysSuccess, getEntitysError)
		}

		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, getEntitysTransaction, getEntitysTransactionError, getEntitysTransactionSuccess);
	}
	
	this.getEntityFromRowItem = function(rowItem) {
		var entity = {
T_ENTITY_FROM_ROW_ITEM
		};

		return entity;
	}