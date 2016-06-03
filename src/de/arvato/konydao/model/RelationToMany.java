package de.arvato.konydao.model;

public class RelationToMany {

	private Property originPrimaryKey;
	private Property originPrimaryKeyInTargets;

	public RelationToMany(Property originPrimaryKey, Property originPrimaryKeyInTargets) {
		super();
		this.originPrimaryKey = originPrimaryKey;
		this.originPrimaryKeyInTargets = originPrimaryKeyInTargets;
	}

	public Property getOriginPrimaryKeyInTargets() {
		return originPrimaryKeyInTargets;
	}

	public void setOriginPrimaryKeyInTargets(Property originPrimaryKeyInTargets) {
		this.originPrimaryKeyInTargets = originPrimaryKeyInTargets;
	}

	public Property getOriginPrimaryKey() {
		return originPrimaryKey;
	}

	public void setOriginPrimaryKey(Property originPrimaryKey) {
		this.originPrimaryKey = originPrimaryKey;
	}

}
