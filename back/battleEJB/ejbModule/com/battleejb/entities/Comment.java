package entities;

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
public class Comment implements Serializable {
	
	private static final long serialVersionUID = -6468381738099368432L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String commentText;
	private Date loadDate;	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "photo_id")
	private Photo photo;
	
	public Comment(){}
	
	public Comment(Long id, String commentText, Date loadDate,
			String description, User user, Project project, Photo photo) {
		super();
		this.id = id;
		this.commentText = commentText;
		this.loadDate = loadDate;
		this.description = description;
		this.user = user;
		this.project = project;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentText == null) ? 0 : commentText.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loadDate == null) ? 0 : loadDate.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Comment))
			return false;
		Comment other = (Comment) obj;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loadDate == null) {
			if (other.loadDate != null)
				return false;
		} else if (!loadDate.equals(other.loadDate))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [id=");
		builder.append(id);
		builder.append(", commentText=");
		builder.append(commentText);
		builder.append(", loadDate=");
		builder.append(loadDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", user=");
		builder.append(user);
		builder.append(", project=");
		builder.append(project);
		builder.append(", photo=");
		builder.append(photo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
