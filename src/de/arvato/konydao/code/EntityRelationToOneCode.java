package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.RelationToOne;

public class EntityRelationToOneCode {
	private static final String TARGET_PK = "TARGET_PK";

	String content;

	public EntityRelationToOneCode(RelationToOne relationToOne) {
		content = FileUtils.getEntityRelationToOne();

		content = content.replace("Target", relationToOne.getTarget().getName());

		content = content.replace(TARGET_PK, relationToOne.getTargetPrimaryKeyInOrigin().getName());
	}

	@Override
	public String toString() {
		return content + "\n";
	}
}
