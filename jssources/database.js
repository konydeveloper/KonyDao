/**
		WARNING: THIS FILE WAS AUTO GENERATED - DO NOT MODIFY
		
		If you want to add Logic, do so within the "Keep" section at the end of the File! 
 */

if (typeof(databaseMaster) === "undefined") {
	databaseMaster = new DatabaseMaster();
	databaseMaster.self = databaseMaster;
}

function DatabaseMaster() {

	var databaseObjectId;
		
T_BODY

	// Thread Safe Transactions - freak'n kony doesn't handle this...
	var transactions = []; 
	var transactionCounter = 0;
	
	this.fireSafeTransaction = function(dbIdParam, transactionParam, errorCallbackParam, successCallbackParam) {
		transactionCounter = transactionCounter++;
		
		transactionFinishedSuccess = function() {
			successCallbackParam();
			databaseMaster.removeTransactionAndFireNext(transactionCounter);
		}
		
		transactionFinishedError = function() {
			errorCallbackParam()
			databaseMaster.removeTransactionAndFireNext(transactionCounter);
		}
	
		var transaction = {
			counter:transactionCounter,
			dbId:dbIdParam, 
			transaction:transactionParam, 
			errorCallback:transactionFinishedError, 
			successCallback:transactionFinishedSuccess
		};
		
		transactions.push(transaction);
		
		if (transactions.length == 1) {
			databaseMaster.fireCurrentTransaction();
		} else {
			kony.print("WARNING: another transaction running. waiting.");
		}
	}
	
	this.fireCurrentTransaction = function() {
		kony.db.transaction(transactions[0].dbId, transactions[0].transaction, transactions[0].errorCallback, transactions[0].successCallback);
	}
	
	
	this.removeTransactionAndFireNext = function(counterParam) {
		var index = -1;
		for (var i = 0; i < transactions.length; ++i) {
			if (transactions[i].counter == counterParam) {
				index = i;
				break;
			}
		}
		
		if (index > -1) {
			transactions.splice(index, 1);
		}
		
		if (transactions.length > 0) {
			kony.print("WARNING: transaction left in pipe. firing.");
			databaseMaster.fireCurrentTransaction();		
		}
		
	}

	// KEEP START

	// KEEP END
}