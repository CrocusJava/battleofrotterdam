package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the Text database table.
 * @author rtkachuk
 * @author Lukashchuk Ivan
 * 
 */
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "User.findEnTextByKey", query="SELECT `valueEn` FROM `Text` WHERE `keyval`=:keyval", resultSetMapping="valueEn"),
	@NamedNativeQuery(name = "User.findNlTextByKey", query="SELECT `valueNl` FROM `Text` WHERE `keyval`=:keyval", resultSetMapping="valueNl")
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name = "valueEn", columns ={@ColumnResult(name = "valueEn") }),
	@SqlResultSetMapping(name = "valueNl", columns ={@ColumnResult(name = "valueNl") })
})
@NamedQueries({ @NamedQuery(name = "Text.findByKey", query = "SELECT t FROM Text t WHERE t.keyval = :keyval") })
public class Text implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer keyval;
	
	private String valueEn;

	private String valueNl;
		
	@Transient
	private Long num;
	@Transient
	private Boolean viewOnEdit;
	
//-----------------------------	
	
    public Text() {
    }
//-----------------------------
    
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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Boolean getViewOnEdit() {
		return viewOnEdit;
	}

	public void setViewOnEdit(Boolean viewOnEdit) {
		this.viewOnEdit = viewOnEdit;
	}

	public void setKeyval(Integer keyval) {
		this.keyval = keyval;
	}
	
}