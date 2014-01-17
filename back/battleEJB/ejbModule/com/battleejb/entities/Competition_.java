package com.battleejb.entities;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.battleejb.entities.Competition;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;

@StaticMetamodel(Competition.class)
public class Competition_ {

	public static volatile SingularAttribute<Competition, Integer> id;
	public static volatile SingularAttribute<Competition, Date> dateEnd;
	public static volatile SingularAttribute<Competition, Date> dateStart;
	public static volatile SingularAttribute<Competition, String> description;
	public static volatile SingularAttribute<Competition, String> name;
	public static volatile SingularAttribute<Competition, Date> registerDeadline;
	public static volatile SingularAttribute<Competition, CompetitionType> type;
	public static volatile SingularAttribute<Competition, User> user;
	public static volatile ListAttribute<Competition, Project> projects;
	
}
