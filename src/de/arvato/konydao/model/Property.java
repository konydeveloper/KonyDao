package de.arvato.konydao.model;

public class Property {

	public static final int TEXT = 10;
	public static final int INTEGER = 20;
	public static final int REAL = 30;
	
	private Entity entity;
	private int type;
	private String name;
	
	public Property(Entity entity, int type, String name) {
		super();
		this.entity = entity;
		this.type = type;
		this.name = name;
	}

	private boolean primaryKey = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public Property primaryKey() {
		setPrimaryKey(true);
		return this;
	}
	
	
	public static String getTypeName(Property p) {
		switch (p.getType()) {
		case INTEGER:
			return "INTEGER";
		case REAL:
			return "REAL";
		case TEXT: 
			return "TEXT";
		default:
			throw new IllegalStateException("Type unknown");
		}
	}
	
	public static boolean isText(Property p) {
		return p.getType() == TEXT;
	}
	
	
}
