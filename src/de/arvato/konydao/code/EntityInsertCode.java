package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.Property;

public class EntityInsertCode {
	private static final String T_ENTITY_INSERT_SQL_STMT  = "T_ENTITY_INSERT_SQL_STMT";

	String content;
	
	public EntityInsertCode(Entity entity) {
		content = FileUtils.getEntityInsert();
				
		content = content.replace("Entity", entity.getName());
		
		content = content.replace(T_ENTITY_INSERT_SQL_STMT, createSqlInsertStatement(entity));		
	}	
	
	private String createSqlInsertStatement(Entity entity) {
		StringBuffer buffer = new StringBuffer();
				
		buffer.append("\"INSERT INTO " + entity.getName() + " VALUES (\" + ");
		for (Property p : entity.getProperties()) {
			if (Property.isText(p)) {
				buffer.append("\"\\'\" + ");
			}
			buffer.append("entity." + p.getName() + " + ");
			
			if (Property.isText(p)) {
				buffer.append("\"\\'\" + ");
			}
			
			buffer.append("\",\" + ");

		}
		
		buffer.delete(buffer.length()-6, buffer.length());
		buffer.append("\")\"");
		
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}
}
