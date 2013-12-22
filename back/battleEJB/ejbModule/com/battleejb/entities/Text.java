package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Text database table.
 * 
 */
@Entity
public class Text implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer key;
	
	private String valueEn;

	private String valueNl;
	
    public Text() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValueEn() {
		return valueEn;
	}

	public void setValueEn(String valueEn) {
		this.valueEn = valueEn;
	}

	public String getValueNl() {
		return valueNl;
	}

	public void setValueNl(String valueNl) {
		this.valueNl = valueNl;
	}
	
}