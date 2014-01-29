package com.battleweb.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.battleejb.ejbbeans.NewsBean;
import com.battleejb.entities.News;

/**
 * 
 * @author Lukashchuk Ivan
 * 
 */
@ManagedBean
@ViewScoped
public class NewBean {

	@EJB
	private NewsBean newsBean;

	private LazyDataModel<News> dataModel;
	
	private News news = new News();
	
	private News newNews = new News();

	@PostConstruct
	private void init() {
		setDataModel(new LazyDataModel<News>() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<News> load(int first, int pageSize, String sortField,
					SortOrder sortOrder, Map<String, String> filters) {
				setRowCount((int) newsBean.getCount());
				return newsBean.findLimit(first, pageSize);
			}
		});
	}
	
	public void create(){
		String photoPath = "I don't know!";
		newNews.setPhotoPath(photoPath);
		newsBean.create(newNews);
		RequestContext.getCurrentInstance().closeDialog(null);
	}
	
	public void edit(){
		newsBean.edit(news);   // + photo
	}

	public LazyDataModel<News> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<News> dataModel) {
		this.dataModel = dataModel;
	}

	public void newNews(){
		newNews = new News();
		RequestContext.getCurrentInstance().openDialog("adminCreateNews");
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public News getNewNews() {
		return newNews;
	}

	public void setNewNews(News newNews) {
		this.newNews = newNews;
	}
}
