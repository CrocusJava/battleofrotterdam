package com.battleejb.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.battleejb.entities.Competition;

@StaticMetamodel(CompetitionType.class)
public class CompetitionType_ {

	public static volatile SingularAttribute<CompetitionType, Integer> id;
	public static volatile SingularAttribute<CompetitionType, String> name;
	public static volatile ListAttribute<CompetitionType, Competition> competitions;
}
