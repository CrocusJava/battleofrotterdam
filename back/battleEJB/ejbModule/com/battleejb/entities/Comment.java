package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the Comment database table.
 * @author marina
 */
@Entity
@NamedQueries({
//	@NamedQuery(name = "Comment.findLast", query="SELECT c FROM Comment AS c ORDER BY c.commentDate DESC LIMIT :n ")
	@NamedQuery(name = "Comment.findLast", query="SELECT c FROM Comment AS c ORDER BY c.commentDate DESC ")
})
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Timestamp commentDate;

	private String commentText;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private User user;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private Project project;

	//bi-directional many-to-one association to Photo
	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private Photo photo;

//---------------------------------------------	
	
    public Comment() {
    }

//----------------------------------------------    
    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
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
	
	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result
				+ ((commentText == null) ? 0 : commentText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentDate=" + commentDate
				+ ", commentText=" + commentText + ", user=" + user
				+ ", project=" + project + ", photo=" + photo + "]";
	}
	
}