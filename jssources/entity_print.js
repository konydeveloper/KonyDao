	/**
	Prints all Entitys to commandline.
	*/
	this.printEntitys = function() {
		onGetAllEntitysSuccess = function(result) {
			entityToString = function(entity) {
				return T_ENTITY_PRINT_STRING
			}
			for (var i = 0; i < result.length; i++) {
				kony.print(entityToString(result[i]));
			}		
		}

		onGetAllEntitysFail = function() {
			kony.print("onGetAllEntitysFail");
		}

		databaseMaster.getEntitys(onGetAllEntitysSuccess, onGetAllEntitysFail);
	}