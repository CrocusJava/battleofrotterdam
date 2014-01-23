package com.battleejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the Text database table.
 * @author marina
 * 
 */
@Entity

@NamedQueries({
	 @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n ORDER BY n.loadDate DESC"),
	 @NamedQuery(name = "News.findLast", query = "SELECT n FROM News n ORDER BY n.loadDate DESC"),
	 @NamedQuery(name = "News.findOlder", query = "SELECT n FROM News n WHERE n.loadDate=(SELECT MIN(n.loadDate) FROM n)")
	 //@NamedQuery(name = "News.findOlder", query = "SELECT n FROM News n ORDER BY n.loadDate ASC")
})
public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer keyval;
	
	@Temporal(TemporalType.DATE)
	private Date loadDate;

	private String photoPath;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Text text;
	
//----------------------------------
	
	public News() {
	}
//----------------------------------	

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

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	
	
	
	
}
