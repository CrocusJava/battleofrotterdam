package com.battleejb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

/**
 * 
 * @author Lukashchuk Ivan
 * 
 */
@NamedNativeQuery(name = "Search.search", query = "SELECT 'project' AS type, id, name, description, MATCH(p.description, p.name) AGAINST(:text IN BOOLEAN MODE) as score "
		+ "FROM battledb.project AS p WHERE MATCH(p.description, p.name) AGAINST(:text IN BOOLEAN MODE) "
		+ "UNION "
		+ "SELECT 'competiton' AS type, id, name, description, MATCH(c.description, c.name) AGAINST(:text IN BOOLEAN MODE) as score "
		+ "FROM battledb.competition AS c WHERE MATCH(c.description, c.name) AGAINST(:text IN BOOLEAN MODE) "
		+ "UNION "
		+ "SELECT 'photo' AS type, id,'', description, MATCH(ph.description) AGAINST(:text IN BOOLEAN MODE) as score "
		+ "FROM battledb.photo AS ph WHERE MATCH(ph.description) AGAINST(:text IN BOOLEAN MODE) "
		+ "UNION "
		+ "SELECT 'comment' AS type, id,'', commentText as description, MATCH(co.commentText) AGAINST(:text IN BOOLEAN MODE) as score "
		+ "FROM battledb.`comment` AS co WHERE MATCH(co.commentText) AGAINST(:text IN BOOLEAN MODE) "
		+ "UNION "
		+ "SELECT 'news' AS type, n.id, t.valueEn , t.valueNl, MATCH(t.valueEn) AGAINST(:text IN BOOLEAN MODE) as score "
		+ "FROM battledb.`news` AS n CROSS JOIN battledb.`text` AS t WHERE n.text_id=t.id AND MATCH(t.valueEn) AGAINST(:text IN BOOLEAN MODE) "
		+ "ORDER BY score DESC", resultClass = Search.class)
@Entity
public class Search implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String type;

	private String name;

	private String description;

	// ----------------------------------

	public Search() {
	}

	// ----------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Search [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
