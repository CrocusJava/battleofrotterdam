package com.battleejb.entities;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.battleejb.entities.Comment;
import com.battleejb.entities.Competition;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleejb.entities.Voice;

/**
 * 
 * @author Lukashch Ivan
 * 
 */
@StaticMetamodel(User.class)
public class User_ {

	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Boolean> active;
	public static volatile SingularAttribute<User, Boolean> commentAble;
	public static volatile SingularAttribute<User, Boolean> approveregistration;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> firstname;
	public static volatile SingularAttribute<User, String> middlename;
	public static volatile SingularAttribute<User, String> lastname;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> photoPath;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, Date> birthday;	
	public static volatile ListAttribute<User, Comment> comments;
	public static volatile ListAttribute<User, Competition> competitions;
	public static volatile ListAttribute<User, Project> projects;
	public static volatile SingularAttribute<User, Address> address;
	public static volatile SingularAttribute<User, Role> role;
	public static volatile ListAttribute<User, Voice> voices;
}
