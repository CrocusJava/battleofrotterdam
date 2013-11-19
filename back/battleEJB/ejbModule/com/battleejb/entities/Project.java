package com.battleejb.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Project implements Serializable{
		
	private static final long serialVersionUID = 1254644473785284346L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String desctiption;
	private Date creationDate;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "user_id")	
	private User user;
	private boolean appeoved;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "competition_id")	
	private Competition competition;
	
	@OneToMany(mappedBy = "project_id")
	@Basic (fetch = FetchType.LAZY) 
	private Set<Voice> voices = new HashSet<Voice>();
	
	@OneToMany(mappedBy = "project_id")
	@Basic (fetch = FetchType.LAZY) 
	private Set<Comment> comments = new HashSet<Comment>();
	
	@OneToMany(mappedBy = "project_id")
	@Basic (fetch = FetchType.LAZY) 
	private Set<Photo> photos = new HashSet<Photo>();
	
	public Project(){}

	public Project(Long id, String name, String desctiption, Date creationDate,
			User user, boolean appeoved, Competition competition) {
		super();
		this.id = id;
		this.name = name;
		this.desctiption = desctiption;
		this.creationDate = creationDate;
		this.user = user;
		this.appeoved = appeoved;
		this.competition = competition;
	}

	public Project(Long id, String name, String desctiption, Date creationDate,
			User user, boolean appeoved, Competition competition, Set<Voice> voices,
			Set<Comment> comments, Set<Photo> photos) {
		this(id, name, desctiption, creationDate, user, appeoved, competition);
		this.voices = voices;
		this.comments = comments;
		this.photos = photos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAppeoved() {
		return appeoved;
	}

	public void setAppeoved(boolean appeoved) {
		this.appeoved = appeoved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (appeoved ? 1231 : 1237);
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((desctiption == null) ? 0 : desctiption.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Project))
			return false;
		Project other = (Project) obj;
		if (appeoved != other.appeoved)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (desctiption == null) {
			if (other.desctiption != null)
				return false;
		} else if (!desctiption.equals(other.desctiption))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", desctiption=");
		builder.append(desctiption);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", user=");
		builder.append(user);
		builder.append(", appeoved=");
		builder.append(appeoved);
		builder.append("]");
		return builder.toString();
	}
	
	
}
