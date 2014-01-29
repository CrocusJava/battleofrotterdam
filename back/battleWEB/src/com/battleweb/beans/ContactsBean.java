package com.battleweb.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Text;
import com.battleweb.controller.Constants;


/**
 * @author marina
 * 
 */

@ManagedBean(name = "contacts")
@ViewScoped
public class ContactsBean {
	
	@EJB
	private TextBean textBean;
	
	private Text info;
	private Text address;
	private Text email;
	private Text phone;
	private Text fax;
	private Text skype;
	
	@PostConstruct
	private void init(){
		info = textBean.findByKey(Constants.TEXT_CONTACTS_INFO_ON_INDEX);
		address = textBean.findByKey(Constants.TEXT_CONTACTS_ADDRESS);
		email = textBean.findByKey(Constants.TEXT_CONTACTS_EMAIL);
		phone = textBean.findByKey(Constants.TEXT_CONTACTS_PHONE);
		fax = textBean.findByKey(Constants.TEXT_CONTACTS_FAX);
		skype = textBean.findByKey(Constants.TEXT_CONTACTS_SKYPE);
	}

	public String apply(){
		textBean.edit(info);
		textBean.edit(address);
		textBean.edit(email);
		textBean.edit(phone);
		textBean.edit(fax);
		textBean.edit(skype);
		return "administration";
	}
	
	public void cancel(){
		init();
	}
	
	public Text getInfo() {
		return info;
	}

	public void setInfo(Text info) {
		this.info = info;
	}

	public Text getAddress() {
		return address;
	}

	public void setAddress(Text address) {
		this.address = address;
	}

	public Text getEmail() {
		return email;
	}

	public void setEmail(Text email) {
		this.email = email;
	}

	public Text getPhone() {
		return phone;
	}

	public void setPhone(Text phone) {
		this.phone = phone;
	}

	public Text getFax() {
		return fax;
	}

	public void setFax(Text fax) {
		this.fax = fax;
	}

	public Text getSkype() {
		return skype;
	}

	public void setSkype(Text skype) {
		this.skype = skype;
	}
	
	
	
}
