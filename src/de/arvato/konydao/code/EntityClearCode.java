package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;

public class EntityClearCode {

	String content;

	public EntityClearCode(Entity entity) {
		content = FileUtils.getEntityClear();

		content = content.replace("Entity", entity.getName());
	}

	@Override
	public String toString() {
		return content + "\n\n";
	}

}
