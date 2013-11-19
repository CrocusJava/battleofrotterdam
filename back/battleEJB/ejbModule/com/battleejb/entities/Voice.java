package com.battleejb.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Voice implements Serializable {
		
	private static final long serialVersionUID = 4456911671906159593L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer level;
	private Date voiceDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "project_id")
	private Project project;
	
	public Voice(){}

	public Voice(Long id, Integer level, Date voiceDate, User user,
			Project project) {
		super();
		this.id = id;
		this.level = level;
		this.voiceDate = voiceDate;
		this.user = user;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getVoiceDate() {
		return voiceDate;
	}

	public void setVoiceDate(Date voiceDate) {
		this.voiceDate = voiceDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((voiceDate == null) ? 0 : voiceDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Voice))
			return false;
		Voice other = (Voice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (voiceDate == null) {
			if (other.voiceDate != null)
				return false;
		} else if (!voiceDate.equals(other.voiceDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Voice [id=");
		builder.append(id);
		builder.append(", level=");
		builder.append(level);
		builder.append(", voiceDate=");
		builder.append(voiceDate);
		builder.append(", user=");
		builder.append(user);
		builder.append(", project=");
		builder.append(project);
		builder.append("]");
		return builder.toString();
	}
	
	
}
