package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATIONS")
public class Notification {

	private int id_user;
	private int id_task;
	private boolean notificat;
	
	public Notification (int id_user, int id_task, boolean notificat){
		id_user = this.id_user;
		id_task = this.id_task;
		notificat = this.notificat;
	}
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_task() {
		return id_task;
	}
	public void setId_task(int id_task) {
		this.id_task = id_task;
	}
	public boolean isNotificat() {
		return notificat;
	}
	public void setNotificat(boolean notificat) {
		this.notificat = notificat;
	}
	
	
}
