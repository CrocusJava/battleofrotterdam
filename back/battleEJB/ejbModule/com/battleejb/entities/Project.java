package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Project database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Project.findProjectsByUser", query = "SELECT p FROM Project p WHERE p.user = :user")
	})
@NamedNativeQueries({
	@NamedNativeQuery(name = "Project.findApprovedByCompetitionIdAndOrderByRating",
			query="SELECT *,(SELECT COUNT(`level`) FROM battledb.Voice AS v" +
					" WHERE v.project_id=p.id) as r FROM battledb.Project AS p WHERE " +
					"p.competition_id = :competitionId AND p.approved=1 ORDER BY r DESC LIMIT :firstPosition, :size",
					resultClass = Project.class)
})
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean approved;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	private String description;

	private String name;

	@OneToMany(mappedBy = "project",cascade= {CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private List<Comment> comments;

	@OneToMany(mappedBy = "project",cascade=CascadeType.ALL)
	private List<Photo> photos;

	@ManyToOne(fetch = FetchType.EAGER,cascade= {CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private User user;

	@ManyToOne(fetch = FetchType.EAGER,cascade= {CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private Competition competition;

	@OneToMany(mappedBy = "project",cascade=CascadeType.ALL)
	private List<Voice> voices;

	// -----------------------------------

	public Project() {
	}

	// -----------------------------------

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Voice> getVoices() {
		return this.voices;
	}

	public void setVoices(List<Voice> voices) {
		this.voices = voices;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [id=");
		builder.append(id);
		builder.append(", approved=");
		builder.append(approved);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}