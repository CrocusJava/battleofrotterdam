package com.battleejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Comment database table.
 * @author marina
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Comment.findLast", query="SELECT c FROM Comment AS c ORDER BY c.commentDate DESC"),
	@NamedQuery(name = "Comment.findByProjectId", query="SELECT c FROM Comment AS c WHERE c.project.id=:projectId ORDER BY c.commentDate DESC"),
	@NamedQuery(name = "Comment.findByPhotoId", query="SELECT c FROM Comment AS c WHERE c.photo.id=:photoId ORDER BY c.commentDate DESC"),
	@NamedQuery(name = "Comment.getCountByProjectId", query="SELECT COUNT(c) FROM Comment AS c WHERE c.project.id=:projectId"),
	@NamedQuery(name = "Comment.getCountByPhotoId", query="SELECT COUNT(c) FROM Comment AS c WHERE c.photo.id=:photoId")
})
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;

	private String commentText;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private User user;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Project project;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
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

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
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