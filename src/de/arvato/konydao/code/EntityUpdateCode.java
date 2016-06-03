package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.Property;

public class EntityUpdateCode {
	private static final String T_ENTITY_UPDATE_SQL_STMT = "T_ENTITY_UPDATE_SQL_STMT";

	String content;

	public EntityUpdateCode(Entity entity) {
		content = FileUtils.getEntityUpdate();

		content = content.replace("Entity", entity.getName());

		content = content.replace(T_ENTITY_UPDATE_SQL_STMT, createEntitySqlUpdateString(entity));
	}

	private String createEntitySqlUpdateString(Entity entity) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\"UPDATE " + entity.getName() + " SET \" + ");

		for (Property p : entity.getProperties()) {
			if (p.isPrimaryKey()) {
				continue;
			} else {
				buffer.append("\" " + p.getName() + " = \" + ");

				if (Property.isText(p)) {
					buffer.append("\"\\'\" + ");
				}

				buffer.append("entity." + p.getName() + " + ");

				if (Property.isText(p)) {
					buffer.append("\"\\'\" + ");
				}

				buffer.append("\",\" + ");
			}
		}
		buffer.delete(buffer.length() - 6, buffer.length());

		if (Property.isText((entity.getPrimaryKey()))) {
			buffer.append("\" WHERE " + entity.getPrimaryKey().getName() + " = \\'\" + entity." + entity.getPrimaryKey().getName()
					+ " + \"\\'\"");
		} else {
			buffer.append("\" WHERE " + entity.getPrimaryKey().getName() + " = \" + entity." + entity.getPrimaryKey().getName());
		}

		return buffer.toString();
	}

	@Override
	public String toString() {
		return content + "\n\n";
	}

}
