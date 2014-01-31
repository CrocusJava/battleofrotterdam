package com.battleweb.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.URL;

/**
 * 
 * @author Lukashchuk Ivan
 *
 */
@ManagedBean
@ViewScoped
public class LinksBean {

	@EJB
	private URLBean urlBean;
	
	private LazyDataModel<URL> dataModel;
	
	private URL url = new URL();	
	private URL newUrl = new URL();
	
	@PostConstruct
	private void init(){
		dataModel = new LazyDataModel<URL>() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public List<URL> load(int first, int pageSize, String sortField,
					SortOrder sortOrder, Map<String, String> filters) {					
				setRowCount((int) urlBean.count());
				List<URL> links = urlBean.findRange(first, pageSize);
				if (links != null && links.get(0).getId().equals(1)){
					links.remove(0);
				}
				return links;
			}
		};
	}
	
	public void create(){
		urlBean.create(newUrl);
		RequestContext.getCurrentInstance().closeDialog(null);
	}
	
	public void edit(){
		urlBean.edit(url);
	}
	
	public void closeDialog(){
		RequestContext.getCurrentInstance().closeDialog(null);
	}
	
	public LazyDataModel<URL> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<URL> dataModel) {
		this.dataModel = dataModel;
	}
	
	public void newUrl(){
		newUrl = new URL();
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		RequestContext.getCurrentInstance().openDialog(
				"adminCreateLink", options, null);		
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public URL getNewUrl() {
		return newUrl;
	}

	public void setNewUrl(URL newUrl) {
		this.newUrl = newUrl;
	}

}
