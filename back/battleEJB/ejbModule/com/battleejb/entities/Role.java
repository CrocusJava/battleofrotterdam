package entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Role implements Serializable{
	
	private static final long serialVersionUID = -3067220738281025600L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToOne(mappedBy = "address")
	@Basic (fetch = FetchType.LAZY) 
	private User user;
	
	public Role(){}

	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Role(Long id, String name, User user) {
		this(id, name);
		this.user = user;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	
	
}
