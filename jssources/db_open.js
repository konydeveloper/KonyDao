	/**
	Opens Database.
	*/
	this.openDatabase = function() {
		var dbName = "T_DB_OPEN_SCHEMA_NAME";
		var version = "1.0";
		var displayName = "T_DB_OPEN_SCHEMA_DISPLAY_NAME";
		var estimatedSize = 5 * 1024 * 1024; //5*1024*1024 indicates 5 MB: only for SPA
		var passphrase = null; // Android: Password for encryption, iOS: Pragma statements
		
		kony.print("openDatabase");
		databaseMaster.databaseObjectId = kony.db.openDatabase(dbName, version, displayName, estimatedSize, passphrase);
	}