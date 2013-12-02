package com.battleejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Project database table.
 * 
 */
@Entity
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private byte approved;

	private Timestamp creationDate;

    @Lob()
	private String description;

	private String name;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="project")
	private List<Comment> comments;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="project")
	private List<Photo> photos;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	//bi-directional many-to-one association to Competition
	@ManyToOne(fetch=FetchType.LAZY)
	private Competition competition;

	//bi-directional many-to-one association to Voice
	@OneToMany(mappedBy="project")
	private List<Voice> voices;

    public Project() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte getApproved() {
		return this.approved;
	}

	public void setApproved(byte approved) {
		this.approved = approved;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
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
	
}