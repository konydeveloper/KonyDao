package de.arvato.konydao.model;

public class RelationToOne {

	private Property targetPrimaryKeyInOrigin;
	private Entity target;

	public RelationToOne(Property targetPrimaryKeyInOrigin, Entity target) {
		super();
		this.targetPrimaryKeyInOrigin = targetPrimaryKeyInOrigin;
		this.target = target;
	}

	public Property getTargetPrimaryKeyInOrigin() {
		return targetPrimaryKeyInOrigin;
	}

	public void setTargetPrimaryKeyInOrigin(Property targetPrimaryKeyInOrigin) {
		this.targetPrimaryKeyInOrigin = targetPrimaryKeyInOrigin;
	}

	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}

}
