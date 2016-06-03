package de.arvato.konydao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import de.arvato.konydao.code.DBInit;
import de.arvato.konydao.code.DBOpen;
import de.arvato.konydao.code.EntityClearCode;
import de.arvato.konydao.code.EntityCountCode;
import de.arvato.konydao.code.EntityCreateCode;
import de.arvato.konydao.code.EntityDeleteCode;
import de.arvato.konydao.code.EntityDropCode;
import de.arvato.konydao.code.EntityGetAllCode;
import de.arvato.konydao.code.EntityGetByPkCode;
import de.arvato.konydao.code.EntityInsertCode;
import de.arvato.konydao.code.EntityPrintCode;
import de.arvato.konydao.code.EntityRelationsCode;
import de.arvato.konydao.code.EntityUpdateCode;
import de.arvato.konydao.generator.FileUtils;
import de.arvato.konydao.model.Entity;
import de.arvato.konydao.model.Schema;

public class KonyDaoGenerator {

	private static final String T_BODY = "T_BODY";

	private static final String T_KEEP_START = "// KEEP START";
	private static final String T_KEEP_END = "// KEEP END";

	public void generate(File target, Schema schema) {
		// validateTargetDir(target);

		String master = FileUtils.getDatabaseMaster();

		StringBuffer body = new StringBuffer();

		// DB Open
		DBOpen openCode = new DBOpen(schema);
		body.append(openCode.toString());

		// DB init
		DBInit initCode = new DBInit(schema.getEntities());
		body.append(initCode.toString());

		// Entity Drops
		for (Entity entity : schema.getEntities()) {
			EntityDropCode entityDropCode = new EntityDropCode(entity);
			body.append(entityDropCode.toString());
		}

		// Entity Creates
		for (Entity entity : schema.getEntities()) {
			EntityCreateCode entityCreateCode = new EntityCreateCode(entity);
			body.append(entityCreateCode.toString());
		}

		// Handle Entity
		for (Entity entity : schema.getEntities()) {
			body.append("\t// ######## " + entity.getName().toUpperCase() + "########\n\n");

			// Clear
			EntityClearCode entityClearCode = new EntityClearCode(entity);
			body.append(entityClearCode.toString());

			// Count
			EntityCountCode entityCountCode = new EntityCountCode(entity);
			body.append(entityCountCode.toString());

			// Print
			EntityPrintCode entityPrintCode = new EntityPrintCode(entity);
			body.append(entityPrintCode.toString());

			// Insert
			EntityInsertCode entityInsertCode = new EntityInsertCode(entity);
			body.append(entityInsertCode.toString());

			// Delete
			EntityDeleteCode entityDeleteCode = new EntityDeleteCode(entity);
			body.append(entityDeleteCode.toString());

			// Get All
			EntityGetAllCode entityGetAllCode = new EntityGetAllCode(entity);
			body.append(entityGetAllCode.toString());

			// Relationships
			EntityRelationsCode entityRelationsCode = new EntityRelationsCode(entity);
			body.append(entityRelationsCode.toString());

			// Get By Pk
			if (entity.getPrimaryKey() != null) {
				EntityGetByPkCode entityGetByPkCode = new EntityGetByPkCode(entity);
				body.append(entityGetByPkCode.toString());

				EntityUpdateCode entityUpdateCode = new EntityUpdateCode(entity);
				body.append(entityUpdateCode.toString());
			}

		}

		// simplify string concatination
		String bodyText = body.toString();
		bodyText = bodyText.replace("\" + \"", "");

		// insert body
		master = master.replace(T_BODY, bodyText);

		// write database master file
		writeDatabaseMaster(target, master, schema);
	}

	private void writeDatabaseMaster(File target, String content, Schema schema) {
		PrintWriter out = null;
		try {

			// Handle Keep
			String keep = retrieveKeepSection(target);
			content = insertKeepSection(content, keep);

			// Output String to File
			out = new PrintWriter(target);
			out.print(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private String retrieveKeepSection(File target) {
		String keep = "";
		System.out.println("Retrieving Keep section");

		if (target.exists() && !target.isDirectory()) {
			String targetFileContent = FileUtils.getFileAsString(target);
			int keepStart = targetFileContent.indexOf(T_KEEP_START);
			int keepEnd = targetFileContent.indexOf(T_KEEP_END);
			if (keepStart != -1 && keepEnd != -1) {
				keep = targetFileContent.substring(keepStart + T_KEEP_START.length(), keepEnd);
			}
		}

		return keep;

	}

	private String insertKeepSection(String content, String keep) {
		System.out.println("Inserting Keep section of length: " + keep.length());
		int keepStart = content.indexOf(T_KEEP_START);
		if (keepStart != -1) {
			content = new StringBuffer(content).insert(keepStart + T_KEEP_START.length(), "\n\t" + keep.trim()).toString();
		}

		return content;
	}

}
