package com.battleejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="User.findByLogin", query="SELECT u FROM User u WHERE u.login = :login")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte active;

	private byte commentAble;

	private String email;

	private String login;

	private String name;

	private String password;

	private String photoPath;

	private String surname;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Competition
	@OneToMany(mappedBy="user")
	private List<Competition> competitions;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="user")
	private List<Project> projects;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	private Address address;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	private Role role;

	//bi-directional many-to-one association to Voice
	@OneToMany(mappedBy="user")
	private List<Voice> voices;

    public User() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public byte getCommentAble() {
		return this.commentAble;
	}

	public void setCommentAble(byte commentAble) {
		this.commentAble = commentAble;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public List<Competition> getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}
	
	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Voice> getVoices() {
		return this.voices;
	}

	public void setVoices(List<Voice> voices) {
		this.voices = voices;
	}
	
}