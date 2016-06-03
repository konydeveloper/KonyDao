package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.RelationToMany;
import de.arvato.konydao.model.RelationToOne;

public class EntityRelationsCode {

	private static final String TO_ONE_RELATIONS = "TO_ONE_RELATIONS";
	private static final String TO_MANY_RELATIONS = "TO_MANY_RELATIONS";

	String content;

	public EntityRelationsCode(Entity entity) {
		content = FileUtils.getEntityRelations();

		content = content.replace("Entity", entity.getName());

		StringBuffer toOneRelationsContent = new StringBuffer("");
		for (RelationToOne relation : entity.getRelationsToOne()) {
			EntityRelationToOneCode relationToOneCode = new EntityRelationToOneCode(relation);
			toOneRelationsContent.append(relationToOneCode.toString());
		}
		content = content.replace(TO_ONE_RELATIONS, toOneRelationsContent.toString());

		StringBuffer toManyRelationshipsContent = new StringBuffer("");
		for (RelationToMany relation : entity.getRelationsToMany()) {
			EntityRelationToManyCode relationToManyCode = new EntityRelationToManyCode(relation);
			toManyRelationshipsContent.append(relationToManyCode.toString());
		}
		content = content.replace(TO_MANY_RELATIONS, toManyRelationshipsContent.toString());

	}

	@Override
	public String toString() {
		return content + "\n\n";
	}

}
