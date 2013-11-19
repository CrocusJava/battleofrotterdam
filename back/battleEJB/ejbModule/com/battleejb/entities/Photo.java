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
public class Photo implements Serializable {
		
	private static final long serialVersionUID = -8249117514774949605L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String path;
	private Date loadDate;	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "project_id")
	private Project project;
	
	public Photo(){}

	public Photo(Long id, String path, Date loadDate, String description,
			Project project) {
		super();
		this.id = id;
		this.path = path;
		this.loadDate = loadDate;
		this.description = description;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loadDate == null) ? 0 : loadDate.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Photo))
			return false;
		Photo other = (Photo) obj;
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
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Photo [id=");
		builder.append(id);
		builder.append(", path=");
		builder.append(path);
		builder.append(", loadDate=");
		builder.append(loadDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", project=");
		builder.append(project);
		builder.append("]");
		return builder.toString();
	}
	
	
}
