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
 * @author marina
 * 
 */

@ManagedBean(name="battle")
@RequestScoped
public class AboutBattleBean {

	@EJB
	private TextBean textBean;
//	@EJB
//	private URLBean urlBean;
	
	private String battleTitleEn; 
	private String battleTextEn; 
	private String battleTitleNl; 
	private String battleTextNl; 
	private String aboutUsTitleEn; 
	private String aboutUsTextEn; 
	private String aboutUsTitleNl; 
	private String aboutUsTextNl; 
	private String rulesTitleEn; 
	private String rulesTextEn; 
	private String rulesTitleNl; 
	private String rulesTextNl; 
	private String infoTitleEn; 
	private String infoTextEn; 
	private String infoTitleNl; 
	private String infoTextNl; 
	
	@PostConstruct
	public void init(){
		 battleTitleEn = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_DESCRIPTION, new Locale("en")); 
		 battleTextEn = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_FULL, new Locale("en")); 
		 battleTitleNl = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_DESCRIPTION, new Locale("nl")); 
		 battleTextNl = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_FULL, new Locale("nl")); 
		 
		 aboutUsTitleEn = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_ABOUT_US, new Locale("en")); 
		 aboutUsTextEn = textBean.findLocaleTextByKey(Constants.TEXT_ABOUT_US_DESCRIPTION, new Locale("en")); 
		 aboutUsTitleNl = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_ABOUT_US, new Locale("nl")); 
		 aboutUsTextNl = textBean.findLocaleTextByKey(Constants.TEXT_ABOUT_US_DESCRIPTION, new Locale("nl"));
		 
		 rulesTitleEn = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_RULES, new Locale("en")); 
		 rulesTextEn = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_RULES_DESCRIPTION, new Locale("en")); 
		 rulesTitleNl = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_RULES, new Locale("nl")); 
		 rulesTextNl = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_RULES_DESCRIPTION, new Locale("nl")); 
		 
		 infoTitleEn = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_INFO, new Locale("en")); 
		 infoTextEn = textBean.findLocaleTextByKey(Constants.TEXT_INFO_DESCRIPTION, new Locale("en"));  
		 infoTitleNl = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_INFO, new Locale("nl"));  
		 infoTextNl = textBean.findLocaleTextByKey(Constants.TEXT_INFO_DESCRIPTION, new Locale("nl"));  
	}
	
	public String apply(){
		Text text = textBean.findByKey(Constants.TEXT_TITLE_BATTLE_DESCRIPTION);
		text.setValueEn(battleTitleEn);
		text.setValueNl(battleTitleNl);
		textBean.edit(text);
		text = textBean.findByKey(Constants.TEXT_BATTLE_DESCRIPTION_FULL);
		text.setValueEn(battleTextEn);
		text.setValueNl(battleTextNl);
		textBean.edit(text);
		
		text = textBean.findByKey(Constants.TEXT_TITLE_ABOUT_US);
		text.setValueEn(aboutUsTitleEn);
		text.setValueNl(aboutUsTitleNl);
		textBean.edit(text);
		text = textBean.findByKey(Constants.TEXT_ABOUT_US_DESCRIPTION);
		text.setValueEn(aboutUsTextEn);
		text.setValueNl(aboutUsTextNl);
		textBean.edit(text);
		
		text = textBean.findByKey(Constants.TEXT_TITLE_BATTLE_RULES);
		text.setValueEn(rulesTitleEn);
		text.setValueNl(rulesTitleNl);
		textBean.edit(text);
		text = textBean.findByKey(Constants.TEXT_BATTLE_RULES_DESCRIPTION);
		text.setValueEn(rulesTextEn);
		text.setValueNl(rulesTextNl);
		textBean.edit(text);
		
		text = textBean.findByKey(Constants.TEXT_TITLE_INFO);
		text.setValueEn(infoTitleEn);
		text.setValueNl(infoTitleNl);
		textBean.edit(text);
		text = textBean.findByKey(Constants.TEXT_INFO_DESCRIPTION);
		text.setValueEn(infoTextEn);
		text.setValueNl(infoTextNl);
		textBean.edit(text);
		
		return "administration";
	}

	public void cancel(){
		init();
	}
	
	public String getBattleTitleEn() {
		return battleTitleEn;
	}

	public void setBattleTitleEn(String battleTitleEn) {
		this.battleTitleEn = battleTitleEn;
	}

	public String getBattleTextEn() {
		return battleTextEn;
	}

	public void setBattleTextEn(String battleTextEn) {
		this.battleTextEn = battleTextEn;
	}

	public String getBattleTitleNl() {
		return battleTitleNl;
	}

	public void setBattleTitleNl(String battleTitleNl) {
		this.battleTitleNl = battleTitleNl;
	}

	public String getBattleTextNl() {
		return battleTextNl;
	}

	public void setBattleTextNl(String battleTextNl) {
		this.battleTextNl = battleTextNl;
	}

	public String getAboutUsTitleEn() {
		return aboutUsTitleEn;
	}

	public void setAboutUsTitleEn(String aboutUsTitleEn) {
		this.aboutUsTitleEn = aboutUsTitleEn;
	}

	public String getAboutUsTextEn() {
		return aboutUsTextEn;
	}

	public void setAboutUsTextEn(String aboutUsTextEn) {
		this.aboutUsTextEn = aboutUsTextEn;
	}

	public String getAboutUsTitleNl() {
		return aboutUsTitleNl;
	}

	public void setAboutUsTitleNl(String aboutUsTitleNl) {
		this.aboutUsTitleNl = aboutUsTitleNl;
	}

	public String getAboutUsTextNl() {
		return aboutUsTextNl;
	}

	public void setAboutUsTextNl(String aboutUsTextNl) {
		this.aboutUsTextNl = aboutUsTextNl;
	}

	public String getRulesTitleEn() {
		return rulesTitleEn;
	}

	public void setRulesTitleEn(String rulesTitleEn) {
		this.rulesTitleEn = rulesTitleEn;
	}

	public String getRulesTextEn() {
		return rulesTextEn;
	}

	public void setRulesTextEn(String rulesTextEn) {
		this.rulesTextEn = rulesTextEn;
	}

	public String getRulesTitleNl() {
		return rulesTitleNl;
	}

	public void setRulesTitleNl(String rulesTitleNl) {
		this.rulesTitleNl = rulesTitleNl;
	}

	public String getRulesTextNl() {
		return rulesTextNl;
	}

	public void setRulesTextNl(String rulesTextNl) {
		this.rulesTextNl = rulesTextNl;
	}

	public String getInfoTitleEn() {
		return infoTitleEn;
	}

	public void setInfoTitleEn(String infoTitleEn) {
		this.infoTitleEn = infoTitleEn;
	}

	public String getInfoTextEn() {
		return infoTextEn;
	}

	public void setInfoTextEn(String infoTextEn) {
		this.infoTextEn = infoTextEn;
	}

	public String getInfoTitleNl() {
		return infoTitleNl;
	}

	public void setInfoTitleNl(String infoTitleNl) {
		this.infoTitleNl = infoTitleNl;
	}

	public String getInfoTextNl() {
		return infoTextNl;
	}

	public void setInfoTextNl(String infoTextNl) {
		this.infoTextNl = infoTextNl;
	}
	
	
	
	
	
}
