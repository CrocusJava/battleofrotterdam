package com.battleejb.entities;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.battleejb.entities.Comment;
import com.battleejb.entities.Competition;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleejb.entities.Voice;

@StaticMetamodel(Project.class)
public class Project_ {

	public static volatile SingularAttribute<Project, Integer> id;
	public static volatile SingularAttribute<Project, Boolean> approved;
	public static volatile SingularAttribute<Project, Date> creationDate;
	public static volatile SingularAttribute<Project, String> name;
	public static volatile SingularAttribute<Project, String> description;
	public static volatile ListAttribute<Project, Comment> comments;
	public static volatile ListAttribute<Project, Photo> photos;
	public static volatile SingularAttribute<Project, User> user;
	public static volatile SingularAttribute<Project, Competition> competition;
	public static volatile ListAttribute<Project, Voice> voices;
}
