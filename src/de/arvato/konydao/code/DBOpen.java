package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Schema;

public class DBOpen {
	private static final String T_DB_OPEN_SCHEMA_NAME = "T_DB_OPEN_SCHEMA_NAME";
	private static final String T_DB_OPEN_SCHEMA_DISPLAY_NAME = "T_DB_OPEN_SCHEMA_DISPLAY_NAME";
	
	String content;
	
	public DBOpen(Schema schema) {
		content = FileUtils.getDBOpen();
		content = content.replace(T_DB_OPEN_SCHEMA_NAME, schema.getName());
		content = content.replace(T_DB_OPEN_SCHEMA_DISPLAY_NAME, schema.getDisplayName());
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}

}
