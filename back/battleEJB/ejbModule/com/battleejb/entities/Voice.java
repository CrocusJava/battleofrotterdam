package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the Voice database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Voice.getCountByProjectId", query="SELECT COUNT(v) FROM Voice AS v WHERE v.project.id=:projectId"),
	@NamedQuery(name = "Voice.findByProjectAndUser", query="SELECT v FROM Voice AS v WHERE v.project=:project AND v.user=:user")
})
public class Voice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int level;

	@Temporal( TemporalType.DATE)
	private Date voiceDate;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private User user;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Project project;

//---------------------------------------------------	
	
    public Voice() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Date getVoiceDate() {
		return voiceDate;
	}

	public void setVoiceDate(Date voiceDate) {
		this.voiceDate = voiceDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}