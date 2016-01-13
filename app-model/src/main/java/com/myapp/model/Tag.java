package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tag;
	private int id_task;
	private String tag;
	
	public Tag (){}
	public Tag (int id_tag, int id_task, String tag){
		id_tag = this.id_tag;
		id_task = this.id_task;
		tag = this.tag;
	}
	
	public int getId_tag() {
		return id_tag;
	}
	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}
	public int getId_task() {
		return id_task;
	}
	public void setId_task(int id_task) {
		this.id_task = id_task;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString(){
		return "id_tag = " + id_tag +  "id_task = "+ id_task + 
				"tag = " + tag;
	}

	
}
