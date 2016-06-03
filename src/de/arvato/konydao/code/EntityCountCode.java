package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;

public class EntityCountCode {
	String content;

	public EntityCountCode(Entity entity) {
		content = FileUtils.getEntityCount();

		content = content.replace("Entity", entity.getName());
	}

	@Override
	public String toString() {
		return content + "\n\n";
	}
}
