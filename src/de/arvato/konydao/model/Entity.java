package de.arvato.konydao.model;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	private String name;
	private Schema schema;

	private List<Property> properties = new ArrayList<Property>();
	private List<RelationToOne> relationsToOne = new ArrayList<RelationToOne>();
	private List<RelationToMany> relationsToMany = new ArrayList<RelationToMany>();

	public Entity(Schema schema, String name) {
		super();
		this.name = name;
		this.schema = schema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<RelationToOne> getRelationsToOne() {
		return relationsToOne;
	}

	public void setRelationsToOne(List<RelationToOne> relationsToOne) {
		this.relationsToOne = relationsToOne;
	}

	public List<RelationToMany> getRelationsToMany() {
		return relationsToMany;
	}

	public void setRelationsToMany(List<RelationToMany> relationsToMany) {
		this.relationsToMany = relationsToMany;
	}

	public Property addProperty(int type, String name) {
		Property property = new Property(this, type, name);

		this.properties.add(property);

		return property;
	}

	public RelationToOne addToOneRelation(Property targetPrimaryKeyInOrigin, Entity target) {
		RelationToOne relation = new RelationToOne(targetPrimaryKeyInOrigin, target);

		this.relationsToOne.add(relation);

		return relation;
	}

	public RelationToMany addToManyRelation(Property originPrimaryKey, Property originPrimaryKeyInTargets) {
		RelationToMany relation = new RelationToMany(originPrimaryKey, originPrimaryKeyInTargets);

		this.relationsToMany.add(relation);

		return relation;
	}

	public Property getPropertyByName(String propertyName) {
		for (Property p : properties) {
			if (p.getName().equals(propertyName)) {
				return p;
			}
		}

		throw new IllegalArgumentException("Property " + propertyName + " does not exist in " + this.name);
	}

	public Property getPrimaryKey() {
		for (Property p : properties) {
			if (p.isPrimaryKey()) {
				return p;
			}
		}
		return null;
	}

}
