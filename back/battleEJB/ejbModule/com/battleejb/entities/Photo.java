package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Photo database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Photo.findLast", query = "SELECT p FROM Photo AS p WHERE p.project.approved=true ORDER BY p.loadDate DESC"),
		@NamedQuery(name = "Photo.findLastByProject", query = "SELECT p FROM Photo AS p WHERE p.project=:project ORDER BY p.loadDate DESC"),
		@NamedQuery(name = "Photo.findRendom", query = "SELECT p FROM Photo p WHERE p.project.approved=true ORDER BY RAND()"),
		@NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p WHERE p.project.approved=true"),
		@NamedQuery(name = "Photo.findByProjectId", query = "SELECT p FROM Photo AS p WHERE p.project.id=:projectId AND p.project.approved=true ORDER BY p.loadDate DESC"),
		@NamedQuery(name = "Photo.getCountByProjectId", query = "SELECT COUNT(p) FROM Photo AS p WHERE p.project.id=:projectId AND p.project.approved=true"),
		@NamedQuery(name = "Photo.getCount", query = "SELECT COUNT(p) FROM Photo p WHERE p.project.approved=true") })
		@NamedQuery(name = "Photo.findPhotosByProject", query = "SELECT p FROM Photo p WHERE project = :project")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date loadDate;

	private String path;

	@OneToMany(mappedBy = "photo")
	private List<Comment> comments;

	@ManyToOne(fetch = FetchType.EAGER)
	private Project project;

	// --------------------------------------------

	public Photo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Photo [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append(", loadDate=");
		builder.append(loadDate);
		builder.append(", path=");
		builder.append(path);
		builder.append("]");
		return builder.toString();
	}

}