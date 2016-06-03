package de.arvato.konydao.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.arvato.konydao.KonyDaoGenerator;

public class Schema {
	private String name;
	private String displayName;
	private int version;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Schema(String name, String displayName, int version) {
		super();
		this.name = name;
		this.displayName = displayName;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
	public Entity addEntity(String name) {
		Entity entity = new Entity(this, name);
		
		this.entities.add(entity);
		
		return entity;
	}
	
	public void generate(File target) {
		validate();
		
		KonyDaoGenerator generator = new KonyDaoGenerator();
		generator.generate(target, this);
	}
	
	public void validate() {
		for (Entity e : getEntities()) {

			int primaryKeyCount = 0;
			for (Property p : e.getProperties()) {
				if (p.isPrimaryKey()) {
					primaryKeyCount++;
				}
			}
			
			if (primaryKeyCount > 1) {
				throw new IllegalStateException("Multiple Primary Keys on " + e.getName());
			}
		}
		
	}
}
