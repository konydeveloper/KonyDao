package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.Property;

public class EntityCreateCode {	
	private static final String T_ENTITY_CREATE_SQL_STMT = "T_ENTITY_CREATE_SQL_STMT";
	
	String content;
	
	public EntityCreateCode(Entity entity) {
		content = FileUtils.getEntityCreate();
		
		content = content.replace("Entity", entity.getName());
		
		content = content.replace(T_ENTITY_CREATE_SQL_STMT, createSqlCreateStatement(entity));
	}
	
	private String createSqlCreateStatement(Entity entity) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("CREATE TABLE IF NOT EXISTS ");
		buffer.append(entity.getName());
		buffer.append(" (");

		for (Property p : entity.getProperties()) {
			buffer.append(p.getName() + " " + Property.getTypeName(p));
			if (p.isPrimaryKey()) {
				buffer.append(" PRIMARY KEY");
			}
			buffer.append(", ");
		}
		buffer.deleteCharAt(buffer.length()-1); // delete last comma and space
		buffer.deleteCharAt(buffer.length()-1); // delete last comma and space
		
		buffer.append(")");
		
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}

}
