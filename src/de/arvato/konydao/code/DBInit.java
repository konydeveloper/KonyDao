package de.arvato.konydao.code;

import java.util.List;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;

public class DBInit {
	private static final String T_DB_INIT_DROP_CALLS = "T_DB_INIT_DROP_CALLS";
	private static final String T_DB_INIT_CREATE_CALLS = "T_DB_INIT_CREATE_CALLS";
	
	String content;
	
	public DBInit(List<Entity> entities) {
		content = FileUtils.getDBInit();
		
		StringBuffer dropCalls = new StringBuffer();
		StringBuffer createCalls = new StringBuffer();
		
		for (Entity entity : entities) {
			dropCalls.append("\t\t\t" + "databaseMaster.initDropTableEntity(dbId);".replace("Entity", entity.getName()) + "\n");
			createCalls.append("\t\t\t" + "databaseMaster.initCreateTableEntity(dbId);".replace("Entity", entity.getName()) + "\n");
		}

		content = content.replace(T_DB_INIT_DROP_CALLS, dropCalls);
		content = content.replace(T_DB_INIT_CREATE_CALLS, createCalls);
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}

}
