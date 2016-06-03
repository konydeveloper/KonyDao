package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;

public class EntityDropCode {

	String content;
	
	public EntityDropCode(Entity entity) {
		content = FileUtils.getEntityDrop();
		
		content = content.replace("Entity", entity.getName());
	}
	
	@Override
	public String toString() {
		return content + "\n\n";
	}

}
