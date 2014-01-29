package com.battleweb.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;

import com.battleejb.ejbbeans.NewsBean;
import com.battleejb.entities.News;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolUpload;

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
	@EJB
	private ToolUpload toolUpload;

	private LazyDataModel<News> dataModel;

	private News news = new News();

	private News newNews = new News();

	private UploadedFile photo;

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

	public void closeDialog() {
		RequestContext.getCurrentInstance().closeDialog(null);
	}

	public void handleFileUpload(FileUploadEvent event) {
		photo = event.getFile();
		FacesMessage msg = new FacesMessage("Succesful", photo.getFileName()
				+ " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	private String uploadPhoto(String photoName) {
		String path = null;
		String fileNameCorrect;
		if (photoName == null) {
			int count = newsBean.count();
			String fileName = "photonews" + (count + 1) + ".";
			String fileNameUser = photo.getFileName();
			String[] fileNameUserSplit = fileNameUser.split("\\.");
			fileNameCorrect = fileName
					+ fileNameUserSplit[fileNameUserSplit.length - 1];
		} else {
			fileNameCorrect = photoName;
		}
		String filePath = "";// Constants.PATH_SAVE_PHOTO_NEWS;
		File file = new File(filePath, fileNameCorrect);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			InputStream inputStream = photo.getInputstream();
			byte[] buf = new byte[1024];
			int c = 0;
			while ((c = inputStream.read(buf)) >= 0) {
				fileOutputStream.write(buf, 0, c);
			}
			photo = null;
			path = "controller?command=getphoto&photoname=" + fileNameCorrect;
			fileOutputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			photo = null;
			e.printStackTrace();
		} catch (IOException e) {
			photo = null;
			e.printStackTrace();
		}
		return path;
	}

	public void create() {
		String photoPath = uploadPhoto(null);
		newNews.setPhotoPath(photoPath);
		newsBean.create(newNews);
		RequestContext.getCurrentInstance().closeDialog(null);
	}

	public void edit() {
		if (photo != null) {
			uploadPhoto(news.getPhotoPath());
		}
		newsBean.edit(news);
	}

	public LazyDataModel<News> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<News> dataModel) {
		this.dataModel = dataModel;
	}

	public void newNews() {
		newNews = new News();
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		RequestContext.getCurrentInstance().openDialog("adminCreateNews",
				options, null);
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

	public UploadedFile getPhoto() {
		return photo;
	}

	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}
}
