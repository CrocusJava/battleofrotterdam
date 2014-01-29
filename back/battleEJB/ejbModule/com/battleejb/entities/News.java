package com.battleejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
	 @NamedQuery(name = "News.findOlder", query = "SELECT n FROM News n ORDER BY n.loadDate ASC"),
	 @NamedQuery(name = "News.getCount", query = "SELECT COUNT(n) FROM News n"),
})
public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date loadDate;

	private String photoPath;
	
	private String titleEn;

	private String titleNl;
	
	private String valueEn;

	private String valueNl;
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

	public String getTitleEn() {
		return titleEn;
	}

	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}

	public String getTitleNl() {
		return titleNl;
	}

	public void setTitleNl(String titleNl) {
		this.titleNl = titleNl;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("News [id=");
		builder.append(id);
		builder.append(", loadDate=");
		builder.append(loadDate);
		builder.append(", photoPath=");
		builder.append(photoPath);
		builder.append(", titleEn=");
		builder.append(titleEn);
		builder.append(", titleNl=");
		builder.append(titleNl);
		builder.append(", valueEn=");
		builder.append(valueEn);
		builder.append(", valueNl=");
		builder.append(valueNl);
		builder.append("]");
		return builder.toString();
	}	
	
}
