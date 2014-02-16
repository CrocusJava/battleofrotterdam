package com.battleweb.beans;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Text;
import com.battleweb.controller.Constants;

/**
 * @author Lukashchuk Ivan
 * 
 */

@ManagedBean
@RequestScoped
public class TermsAndConditionsBean {

	@EJB
	private TextBean textBean;

	String termsAndConditionsEn;
	String termsAndConditionsNl;

	@PostConstruct
	public void init() {
		termsAndConditionsEn = textBean.findLocaleTextByKey(
				Constants.TEXT_TERMS, Constants.PARAMETER_LOCALE_EN);
		termsAndConditionsNl = textBean.findLocaleTextByKey(
				Constants.TEXT_TERMS, Constants.PARAMETER_LOCALE_NL);		
	}

	public String apply() {		
		Text text = textBean.findByKey(Constants.TEXT_TERMS);
		text.setValueEn(termsAndConditionsEn);
		text.setValueNl(termsAndConditionsNl);
		textBean.edit(text);
		return "administration";
	}
	public void cancel() {
		init();
	}

	public String getTermsAndConditionsEn() {
		return termsAndConditionsEn;
	}

	public void setTermsAndConditionsEn(String termsAndConditionsEn) {
		this.termsAndConditionsEn = termsAndConditionsEn;
	}

	public String getTermsAndConditionsNl() {
		return termsAndConditionsNl;
	}

	public void setTermsAndConditionsNl(String termsAndConditionsNl) {
		this.termsAndConditionsNl = termsAndConditionsNl;
	}
}
