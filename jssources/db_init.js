	/**
	Initializes all Database tables.
	*/
	this.initDatabase = function() {
		kony.print("creating tables");
		
		initDatabaseTransaction = function(dbId) {
			kony.print("initDatabaseTransaction");	
			
T_DB_INIT_DROP_CALLS
T_DB_INIT_CREATE_CALLS
		}
		
		initDatabaseTransactionSuccess = function() {
			kony.print("initDatabaseSuccess");	
		}
		
		initDatabaseTransactionError = function() {
			kony.print("initDatabaseError");	
		}

		databaseMaster.fireSafeTransaction(databaseMaster.databaseObjectId, initDatabaseTransaction, initDatabaseTransactionError, initDatabaseTransactionSuccess);
	}