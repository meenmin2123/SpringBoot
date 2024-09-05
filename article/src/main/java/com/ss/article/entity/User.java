package com.ss.article.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity	
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private int birth;
	
	@Column
	private String phone;

}
