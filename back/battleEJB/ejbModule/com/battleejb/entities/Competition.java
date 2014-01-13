package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Competition database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Competition.findCurrentYearCompetition", 
							query = "SELECT c FROM Competition c WHERE c.type = :type AND c.dateStart <= :currentDate AND c.dateEnd >= :currentDate") })
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Temporal( TemporalType.DATE)
	private Date dateEnd;

    @Temporal( TemporalType.DATE)
	private Date dateStart;

	private String description;

	private String name;

    @Temporal( TemporalType.DATE)
	private Date registerDeadline;

	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	private CompetitionType type;

	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	private User winner;

	@OneToMany(mappedBy="competition")
	private List<Project> projects;

//---------------------------------------	
	
    public Competition() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDeadline() {
		return this.registerDeadline;
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

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public CompetitionType getType() {
		return type;
	}

	public void setType(CompetitionType type) {
		this.type = type;
	}

}
