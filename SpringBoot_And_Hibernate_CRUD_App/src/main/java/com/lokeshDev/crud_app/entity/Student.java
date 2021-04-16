package com.lokeshDev.crud_app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SCHOOL_TABLE")
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String subject;
	private double score;
	
	//id
	public int getId()
	{
		return id;
	}
	public void SetId(int id)
	{
		this.id = id;
	}
	
	//name
	public String getName()
	{
		return name;
	}
	public void SetName(String name)
	{
		this.name = name;
	}
	
	//subject
	public String getSubject()
	{
		return subject;
	}
	public void SetSubject(String subject)
	{
		this.subject = subject;
	}
	
	//
	public double getScore()
	{
		return score;
	}
	public void SetScore(double score)
	{
		this.score = score;
	}
}
