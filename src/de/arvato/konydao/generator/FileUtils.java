package de.arvato.konydao.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

	public static String getDatabaseMaster() {
		File file = new File(getJsSourcesPath() + "database.js");
		return getFileAsString(file);
	}

	public static String getDBOpen() {
		File file = new File(getJsSourcesPath() + "db_open.js");
		return getFileAsString(file);
	}

	public static String getDBInit() {
		File file = new File(getJsSourcesPath() + "db_init.js");
		return getFileAsString(file);
	}

	public static String getEntityDrop() {
		File file = new File(getJsSourcesPath() + "entity_drop.js");
		return getFileAsString(file);
	}

	public static String getEntityDelete() {
		File file = new File(getJsSourcesPath() + "entity_delete.js");
		return getFileAsString(file);
	}

	public static String getEntityCreate() {
		File file = new File(getJsSourcesPath() + "entity_create.js");
		return getFileAsString(file);
	}

	public static String getEntityClear() {
		File file = new File(getJsSourcesPath() + "entity_clear.js");
		return getFileAsString(file);
	}

	public static String getEntityCount() {
		File file = new File(getJsSourcesPath() + "entity_count.js");
		return getFileAsString(file);
	}

	public static String getEntityPrint() {
		File file = new File(getJsSourcesPath() + "entity_print.js");
		return getFileAsString(file);
	}

	public static String getEntityGetAll() {
		File file = new File(getJsSourcesPath() + "entity_get_all.js");
		return getFileAsString(file);
	}

	public static String getEntityInsert() {
		File file = new File(getJsSourcesPath() + "entity_insert.js");
		return getFileAsString(file);
	}

	public static String getEntityGetByPk() {
		File file = new File(getJsSourcesPath() + "entity_get_by_pk.js");
		return getFileAsString(file);
	}

	public static String getEntityUpdate() {
		File file = new File(getJsSourcesPath() + "entity_update.js");
		return getFileAsString(file);
	}

	public static String getEntityRelations() {
		File file = new File(getJsSourcesPath() + "entity_relations.js");
		return getFileAsString(file);
	}

	public static String getEntityRelationToOne() {
		File file = new File(getJsSourcesPath() + "entity_relation_to_one.js");
		return getFileAsString(file);
	}

	public static String getEntityRelationToMany() {
		File file = new File(getJsSourcesPath() + "entity_relation_to_many.js");
		return getFileAsString(file);
	}

	private static String getJsSourcesPath() {
		return FileUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile() + ".." + File.separator + "jssources"
				+ File.separator;
	}

	public static String getFileAsString(File file) {
		try {
			return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
