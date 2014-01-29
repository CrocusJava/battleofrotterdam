package com.battleweb.beans;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Text;
import com.battleweb.controller.Constants;

/**
 * @author marina
 * 
 */

@ManagedBean(name="battle")
@ViewScoped
public class AboutBattleBean {

	@EJB
	private TextBean textBean;
	
	private Boolean battleView = false;
	private Boolean usView = false;
	private Boolean rulesView = false;
	private Boolean infoView = false;
	
	private Text battleTitle;
	private Text battleText;
	private Text aboutUsTitle;
	private Text aboutUsText;
	private Text rulesTitle;
	private Text rulesText;
	private Text infoTitle;
	private Text infoText;
	 	
	public void apply(Long partNum){
		switch (partNum.intValue()) {
		case (1): {
			textBean.edit(battleTitle);
			textBean.edit(battleText);
			battleView=false;
			break;
		}
		case (2): {
			textBean.edit(aboutUsTitle);
			textBean.edit(aboutUsText);
			usView=false;
			break;
		}
		case (3): {
			textBean.edit(rulesTitle);
			textBean.edit(rulesText);
			rulesView=false;
			break;
		}
		case (4): {
			textBean.edit(infoTitle);
			textBean.edit(infoText);
			infoView=false;
			break;
		}
		}
	}
	
	public void cancel(Long partNum){
		initPart(partNum);
	}
	
	public void changeView(Long partNum) {
		switch (partNum.intValue()) {
		case (1): {
			if(battleView==false){
				initPart(partNum);
			}
			battleView=!battleView;
			break;
			}
		case (2): {
			if(usView==false){
				initPart(partNum);
			}
			usView=!usView;
			break;
		}
		case (3): {
			if(rulesView==false){
				initPart(partNum);
			}
			rulesView=!rulesView;
			break;
		}
		case (4): {
			if(infoView==false){
				initPart(partNum);
			}
			infoView=!infoView;
			break;
		}
		}
	}
	
	public void initPart(Long partNum) {
		switch (partNum.intValue()) {
		case (1): {
			battleTitle = textBean.findByKey(Constants.TEXT_TITLE_BATTLE_DESCRIPTION);
			battleText = textBean.findByKey(Constants.TEXT_BATTLE_DESCRIPTION_FULL);
		}
		case (2): {
			aboutUsTitle = textBean.findByKey(Constants.TEXT_TITLE_ABOUT_US);
			aboutUsText = textBean.findByKey(Constants.TEXT_ABOUT_US_DESCRIPTION);
		}
		case (3): {
			rulesTitle = textBean.findByKey(Constants.TEXT_TITLE_BATTLE_RULES);
			rulesText = textBean.findByKey(Constants.TEXT_BATTLE_RULES_DESCRIPTION);
		}
		case (4): {
			infoTitle = textBean.findByKey(Constants.TEXT_TITLE_INFO);
			infoText = textBean.findByKey(Constants.TEXT_INFO_DESCRIPTION);
		}
		}
	}
	
	public Text getBattleTitle() {
		return battleTitle;
	}

	public void setBattleTitle(Text battleTitle) {
		this.battleTitle = battleTitle;
	}

	public Text getBattleText() {
		return battleText;
	}

	public void setBattleText(Text battleText) {
		this.battleText = battleText;
	}

	public Text getAboutUsTitle() {
		return aboutUsTitle;
	}

	public void setAboutUsTitle(Text aboutUsTitle) {
		this.aboutUsTitle = aboutUsTitle;
	}

	public Text getAboutUsText() {
		return aboutUsText;
	}

	public void setAboutUsText(Text aboutUsText) {
		this.aboutUsText = aboutUsText;
	}

	public Text getRulesTitle() {
		return rulesTitle;
	}

	public void setRulesTitle(Text rulesTitle) {
		this.rulesTitle = rulesTitle;
	}

	public Text getRulesText() {
		return rulesText;
	}

	public void setRulesText(Text rulesText) {
		this.rulesText = rulesText;
	}

	public Text getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(Text infoTitle) {
		this.infoTitle = infoTitle;
	}

	public Text getInfoText() {
		return infoText;
	}

	public void setInfoText(Text infoText) {
		this.infoText = infoText;
	}

	public Boolean getBattleView() {
		return battleView;
	}

	public void setBattleView(Boolean battleView) {
		this.battleView = battleView;
	}

	public Boolean getUsView() {
		return usView;
	}

	public void setUsView(Boolean usView) {
		this.usView = usView;
	}

	public Boolean getRulesView() {
		return rulesView;
	}

	public void setRulesView(Boolean rulesView) {
		this.rulesView = rulesView;
	}

	public Boolean getInfoView() {
		return infoView;
	}

	public void setInfoView(Boolean infoView) {
		this.infoView = infoView;
	}
	
	
	
	
	
}
