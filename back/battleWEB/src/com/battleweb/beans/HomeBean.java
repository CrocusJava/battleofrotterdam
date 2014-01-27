package com.battleweb.beans;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.Text;
import com.battleejb.entities.URL;
import com.battleweb.controller.Constants;

/**
 * @author marina
 * 
 */

@ManagedBean(name="home")
@RequestScoped
public class HomeBean {

	@EJB
	private TextBean textBean;
	@EJB
	private URLBean urlBean;
	
	String battleDescriptionShortEn; 
	String battleDescriptionShortNl; 
	String battleAnimationDescriptionEn;
	String battleAnimationDescriptionNl; 
	String animationURL; 
	
	@PostConstruct
	public void init(){
		 battleDescriptionShortEn = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT, new Locale("en"));
		 battleDescriptionShortNl = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT, new Locale("nl"));
		 battleAnimationDescriptionEn = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION, new Locale("en"));
		 battleAnimationDescriptionNl = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION, new Locale("nl"));
		 animationURL = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION).getValue();

	}
	
	public String apply(){
		URL url = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION);
		url.setValue(animationURL);
		urlBean.edit(url);
		
		Text text = textBean.findByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT);
		text.setValueEn(battleDescriptionShortEn);
		text.setValueNl(battleDescriptionShortNl);
		textBean.edit(text);

		text = textBean.findByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION);
		text.setValueEn(battleAnimationDescriptionEn);
		text.setValueNl(battleAnimationDescriptionNl);
		textBean.edit(text);
		
		return "administration";
	}

	public void cancel(){
		init();
	}
	
	public String getBattleDescriptionShortEn() {
		return battleDescriptionShortEn;
	}
	public void setBattleDescriptionShortEn(String battleDescriptionShortEn) {
		this.battleDescriptionShortEn = battleDescriptionShortEn;
	}
	public String getBattleDescriptionShortNl() {
		return battleDescriptionShortNl;
	}
	public void setBattleDescriptionShortNl(String battleDescriptionShortNl) {
		this.battleDescriptionShortNl = battleDescriptionShortNl;
	}
	public String getBattleAnimationDescriptionEn() {
		return battleAnimationDescriptionEn;
	}
	public void setBattleAnimationDescriptionEn(String battleAnimationDescriptionEn) {
		this.battleAnimationDescriptionEn = battleAnimationDescriptionEn;
	}
	public String getBattleAnimationDescriptionNl() {
		return battleAnimationDescriptionNl;
	}
	public void setBattleAnimationDescriptionNl(String battleAnimationDescriptionNl) {
		this.battleAnimationDescriptionNl = battleAnimationDescriptionNl;
	}
	public String getAnimationURL() {
		return animationURL;
	}
	public void setAnimationURL(String animationURL) {
		this.animationURL = animationURL;
	}
	
	
}
