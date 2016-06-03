		entity.getTarget = function(getTargetSuccessCallback, getTargetFailCallback) {
			return databaseMaster.getTarget(entity.TARGET_PK, getTargetSuccessCallback, getTargetFailCallback);
		};	