package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;

public class EntityGetByPkCode {
	private static final String T_ENTITY_GET_BY_PK_PRIMAR_KEY  = "T_ENTITY_GET_BY_PK_PRIMAR_KEY";
	
	String content;
	
	public EntityGetByPkCode(Entity entity) {
		content = FileUtils.getEntityGetByPk();
				
		content = content.replace("Entity", entity.getName());
		
		content = content.replace(T_ENTITY_GET_BY_PK_PRIMAR_KEY, getEntityPrimaryKey(entity));		
	}	
	
	private String getEntityPrimaryKey(Entity entity) {		
		return entity.getPrimaryKey().getName();
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}
}
