package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Text database table.
 * @author rtkachuk
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Text.findByKey", query = "SELECT t FROM Text t WHERE t.keyval = :keyval") })
public class Text implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer keyval;
	
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

	public Integer getKeyval() {
		return keyval;
	}

	public void setKey(Integer keyval) {
		this.keyval = keyval;
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