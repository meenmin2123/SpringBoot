package com.ss.restful.dto;

import java.sql.Timestamp;

import javax.persistence.Column;

import com.ss.restful.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

	private int no;
	private String id;
	private String password;
	private String role;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String gender;
	private int age;
	private String hobbies;
	private String status;
	private Timestamp enrollDate;
	private Timestamp modifyDate;
	
	public Member toEntity() {
		return new Member(no, id, password,role, name, phone, email, address, age, gender, hobbies ,status, enrollDate, modifyDate);
	}

}
