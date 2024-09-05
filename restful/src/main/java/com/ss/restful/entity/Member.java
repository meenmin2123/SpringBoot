package com.ss.restful.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
	
	public Member(int no2, String id2, String password2, String role2, String name2, String phone2, String email2,
			String address2, int age2, String gender2, String hobbies2, String status2, Timestamp enrollDate2,
			Timestamp modifyDate2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column
	private Long id;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Column
	private String name;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	private String gender;
	
	@Column
	private int age;
	
	@Column
	private String hobbies;
	
	@Column
	private String status;
	
	@Column
	private Timestamp enrollDate;
	
	@Column
	private Timestamp modifyDate;

}
