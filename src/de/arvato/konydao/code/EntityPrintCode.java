package de.arvato.konydao.code;

import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.Property;

public class EntityPrintCode {
	private static final String T_ENTITY_PRINT_STRING = "T_ENTITY_PRINT_STRING";

	String content;

	public EntityPrintCode(Entity entity) {
		content = FileUtils.getEntityPrint();

		content = content.replace("Entity", entity.getName());

		content = content.replace(T_ENTITY_PRINT_STRING, createEntityPrintString(entity));

		content = content.replace("entity", entity.getName().toLowerCase());
	}

	private String createEntityPrintString(Entity entity) {
		StringBuffer buffer = new StringBuffer();

		for (Property p : entity.getProperties()) {
			buffer.append("\"" + p.getName() + ": \" + entity." + p.getName() + " + \", \" + ");
		}

		buffer.deleteCharAt(buffer.length() - 1); // delete last comma and space
		buffer.deleteCharAt(buffer.length() - 1); // delete last comma and space

		buffer.append(";");

		return buffer.toString();
	}

	@Override
	public String toString() {
		return content + "\n\n";
	}

}
