package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.RelationToMany;

public class EntityRelationToManyCode {

	String content;

	public EntityRelationToManyCode(RelationToMany relationToMany) {
		content = FileUtils.getEntityRelationToMany();

		content = content.replace("Target", relationToMany.getOriginPrimaryKeyInTargets().getEntity().getName());
		content = content.replace("ORIGIN_PRIMARY_KEY_IN_TARGETS", relationToMany.getOriginPrimaryKeyInTargets().getName());
		content = content.replace("ORIGIN_PRIMARY_KEY", relationToMany.getOriginPrimaryKey().getName());
	}

	@Override
	public String toString() {
		return content + "\n";
	}
}
