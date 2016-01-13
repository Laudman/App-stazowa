package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_notification;
	private int id_user;
	private int id_task;
	private boolean notificat;
	
	public Notification (){}
	public Notification (int id_notification, int id_user, int id_task, boolean notificat){
		id_notification = this.id_notification;
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

	public int getId_notification() {
		return id_notification;
	}

	public void setId_notification(int id_notification) {
		this.id_notification = id_notification;
	}
	
	
}
