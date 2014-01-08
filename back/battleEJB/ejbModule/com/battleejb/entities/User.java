package com.battleejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.battleejb.entities.Comment;
/**
 * The persistent class for the User database table.
 * @author rtkachuk
 * @author Lukashchuk Ivan
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
	@NamedQuery(name = "User.getCountOfUserByLogin", query = "SELECT COUNT(u) FROM User u WHERE u.login=:login"),
	@NamedQuery(name = "User.getCountOfUserByEmail", query = "SELECT COUNT(u) FROM User u WHERE u.email=:email")
	})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	private Boolean commentAble;

	private Boolean approveregistration;

	private String email;

	private String login;

	private String firstname;

	private String middlename;

	private String lastname;

	private String password;

	private String photoPath;

	private String phone;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@OneToMany(fetch=FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();

	@OneToMany(mappedBy = "user")
	private List<Competition> competitions;

	@OneToMany(mappedBy = "user")
	private List<Project> projects;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Address address;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<Voice> voices;

//--------------------------	
	
	public User() {
	}

//---------------------------	
		
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getCommentAble() {
		return commentAble;
	}

	public void setCommentAble(Boolean commentAble) {
		this.commentAble = commentAble;
	}

	public Boolean getApproveregistration() {
		return approveregistration;
	}

	public void setApproveregistration(Boolean approveregistration) {
		this.approveregistration = approveregistration;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime
				* result
				+ ((approveregistration == null) ? 0 : approveregistration
						.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((commentAble == null) ? 0 : commentAble.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((photoPath == null) ? 0 : photoPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (approveregistration == null) {
			if (other.approveregistration != null)
				return false;
		} else if (!approveregistration.equals(other.approveregistration))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (commentAble == null) {
			if (other.commentAble != null)
				return false;
		} else if (!commentAble.equals(other.commentAble))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", active=" + active + ", commentAble="
				+ commentAble + ", approveregistration=" + approveregistration
				+ ", email=" + email + ", login=" + login + ", firstname="
				+ firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", password=" + password + ", photoPath="
				+ photoPath + ", phone=" + phone + ", birthday=" + birthday
				+ "]";
	}

}