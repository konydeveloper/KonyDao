		entity.getTargets = function(getTargetsSuccessCallback, getTargetsFailCallback) {
			var where = "ORIGIN_PRIMARY_KEY_IN_TARGETS = " + entity.ORIGIN_PRIMARY_KEY;
		 
			return databaseMaster.getTargets(getTargetSuccessCallback, getTargetFailCallback, where);
		};	