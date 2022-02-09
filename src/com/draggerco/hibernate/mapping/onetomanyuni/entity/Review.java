package com.draggerco.hibernate.mapping.onetomanyuni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Column(name = "comment")
	private String comment;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	public Review() {
	}

	public Review(String comment) {
		super();
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public int getId() {
		return id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

}
