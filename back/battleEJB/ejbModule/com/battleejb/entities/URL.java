package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author marina
 * 
 */

@Entity
@NamedQueries({ @NamedQuery(name = "URL.findByKey", query = "SELECT u FROM URL u WHERE u.keyval = :keyval") })
public class URL implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer keyval;
	
	private String name;

	private String value;

	public URL() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKeyval() {
		return keyval;
	}

	public void setKeyval(Integer keyval) {
		this.keyval = keyval;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
