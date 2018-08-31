package com.pointwest.sakila.bean;

public class ActorBean {

	String actorID;
	String actorFisrtName;
	String actorLastName;
	
	public String getActorID() {
		return actorID;
	}
	public String setActorIDStr(String actorID) {
		return this.actorID = actorID;
	}
	public void setActorID(String actorID) {
		this.actorID = actorID;
	}
	public String getActorFirstName() {
		return actorFisrtName;
	}
	public void setActorFisrtName(String actorFisrtName) {
		this.actorFisrtName = actorFisrtName;
	}
	public String getActorLastName() {
		return actorLastName;
	}
	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}
	
	
}
