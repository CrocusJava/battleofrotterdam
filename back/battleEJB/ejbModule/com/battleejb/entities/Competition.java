package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Competition implements Serializable {
		
	private static final long serialVersionUID = 5362699777476363765L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String desctiption;
	private Date dateStart;
	private Date DateEnd;
	private Date registerDeadline;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "user_id")
	private User winner;
	
	@OneToMany(mappedBy = "competition_id")
	@Basic (fetch = FetchType.LAZY) 
	private Set<Project> projects = new HashSet<Project>();
	
	public Competition(){}

	public Competition(Long id, String name, String desctiption,
			Date dateStart, Date dateEnd, Date registerDeadline, User winner) {
		super();
		this.id = id;
		this.name = name;
		this.desctiption = desctiption;
		this.dateStart = dateStart;
		DateEnd = dateEnd;
		this.registerDeadline = registerDeadline;
		this.winner = winner;
	}
	
	

	public Competition(Long id, String name, String desctiption,
			Date dateStart, Date dateEnd, Date registerDeadline, User winner,
			Set<Project> projects) {
		this(id, name, desctiption, dateStart, dateEnd, registerDeadline, winner);
		this.projects = projects;
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

	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		DateEnd = dateEnd;
	}

	public Date getRegisterDeadline() {
		return registerDeadline;
	}

	public void setRegisterDeadline(Date registerDeadline) {
		this.registerDeadline = registerDeadline;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateEnd == null) ? 0 : DateEnd.hashCode());
		result = prime * result
				+ ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result
				+ ((desctiption == null) ? 0 : desctiption.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((registerDeadline == null) ? 0 : registerDeadline.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Competition))
			return false;
		Competition other = (Competition) obj;
		if (DateEnd == null) {
			if (other.DateEnd != null)
				return false;
		} else if (!DateEnd.equals(other.DateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (desctiption == null) {
			if (other.desctiption != null)
				return false;
		} else if (!desctiption.equals(other.desctiption))
			return false;
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
		if (registerDeadline == null) {
			if (other.registerDeadline != null)
				return false;
		} else if (!registerDeadline.equals(other.registerDeadline))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Competition [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", desctiption=");
		builder.append(desctiption);
		builder.append(", dateStart=");
		builder.append(dateStart);
		builder.append(", DateEnd=");
		builder.append(DateEnd);
		builder.append(", registerDeadline=");
		builder.append(registerDeadline);
		builder.append(", winner=");
		builder.append(winner);
		builder.append("]");
		return builder.toString();
	}
	
	
}
