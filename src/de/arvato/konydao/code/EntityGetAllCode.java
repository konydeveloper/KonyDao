package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.Property;

public class EntityGetAllCode {
	private static final String T_ENTITY_FROM_ROW_ITEM  = "T_ENTITY_FROM_ROW_ITEM";

	
	String content;
	
	public EntityGetAllCode(Entity entity) {
		content = FileUtils.getEntityGetAll();
				
		content = content.replace("Entity", entity.getName());
		
		content = content.replace(T_ENTITY_FROM_ROW_ITEM, createEntityFromRowElements(entity));		
	}	
	
	private String createEntityFromRowElements(Entity entity) {
		StringBuffer buffer = new StringBuffer();
		
		for (Property p : entity.getProperties()) {
			buffer.append("\t\t\t" + p.getName() + ":rowItem[\"" + p.getName() + "\"],\n");
		}
		
		buffer.deleteCharAt(buffer.length()-1); // delete last comma
		buffer.deleteCharAt(buffer.length()-1); // delete last comma
		
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}
}
