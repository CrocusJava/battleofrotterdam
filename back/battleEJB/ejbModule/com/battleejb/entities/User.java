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
	private Integer id;

	private byte active;

	private byte commentAble;
	
	private byte approveregistration;

	private String email;

	private String login;

	private String name;

	private String password;

	private String photoPath;

	private String surname;

	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	@OneToMany(mappedBy="user")
	private List<Competition> competitions;

	@OneToMany(mappedBy="user")
	private List<Project> projects;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Address address;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Role role;

	@OneToMany(mappedBy="user")
	private List<Voice> voices;

    public User() {
    }
    
	public User(String email, String login, String name, String password,
			String photoPath, String surname, Address address, Role role) {
		super();
		this.email = email;
		this.login = login;
		this.name = name;
		this.password = password;
		this.photoPath = photoPath;
		this.surname = surname;
		this.address = address;
		this.role = role;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public byte getApproveregistration() {
		return this.approveregistration;
	}

	public void setApproveregistration(byte approveregistration) {
		this.approveregistration = approveregistration;
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