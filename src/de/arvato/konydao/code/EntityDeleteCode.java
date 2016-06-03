package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;

public class EntityDeleteCode {

	String content;

	public EntityDeleteCode(Entity entity) {
		content = FileUtils.getEntityDelete();

		content = content.replace("Entity", entity.getName());
	}

	@Override
	public String toString() {
		return content + "\n\n";
	}

}
