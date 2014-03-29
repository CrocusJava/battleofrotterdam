package com.battleweb.beans;

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

@ManagedBean(name = "faq")
@ViewScoped
public class FAQBean {

	@EJB
	private TextBean textBean;
	
	private Text text_q1;
	private Text text_a1;
	private Text text_q2;
	private Text text_a2;
	private Text text_q3;
	private Text text_a3;
	private Text text_q4;
	private Text text_a4;
	private Text text_q5;
	private Text text_a5;
	private Text text_q6;
	private Text text_a6;
	private Text text_q7;
	private Text text_a7;
	private Text text_q8;
	private Text text_a8;
	private Text text_q9;
	private Text text_a9;
	private Text text_q10;
	private Text text_a10;
	
	private Boolean qaView1 = false;
	private Boolean qaView2 = false;
	private Boolean qaView3 = false;
	private Boolean qaView4 = false;
	private Boolean qaView5 = false;
	private Boolean qaView6 = false;
	private Boolean qaView7 = false;
	private Boolean qaView8 = false;
	private Boolean qaView9 = false;
	private Boolean qaView10 = false;
	
	public void apply(Long qaNum){
		switch (qaNum.intValue()) {
		case (1): {
			textBean.edit(text_a1);
			textBean.edit(text_q1);
			qaView1=false;
			break;
		}
		case (2): {
			textBean.edit(text_a2);
			textBean.edit(text_q2);
			qaView2=false;
			break;
		}
		case (3): {
			textBean.edit(text_a3);
			textBean.edit(text_q3);
			qaView3=false;
			break;
		}
		case (4): {
			textBean.edit(text_a4);
			textBean.edit(text_q4);
			qaView4=false;
			break;
		}
		case (5): {
			textBean.edit(text_a5);
			textBean.edit(text_q5);
			qaView5=false;
			break;
		}
		case (6): {
			textBean.edit(text_a6);
			textBean.edit(text_q6);
			qaView6=false;
			break;
		}
		case (7): {
			textBean.edit(text_a7);
			textBean.edit(text_q7);
			qaView7=false;
			break;
		}
		case (8): {
			textBean.edit(text_a8);
			textBean.edit(text_q8);
			qaView8=false;
			break;
		}
		case (9): {
			textBean.edit(text_a9);
			textBean.edit(text_q9);
			qaView9=false;
			break;
		}
		case (10): {
			textBean.edit(text_a10);
			textBean.edit(text_q10);
			qaView10=false;
			break;
		}
		}
	}
	
	public void cancel(Long qaNum){
		initQA(qaNum);
	}
	
	public void changeView(Long qaNum) {
		switch (qaNum.intValue()) {
		case (1): {
			if(qaView1==false){
				initQA(qaNum);
			}
			qaView1=!qaView1;
			break;
			}
		case (2): {
			if(qaView2==false){
				initQA(qaNum);
			}
			qaView2=!qaView2;
			break;
		}
		case (3): {
			if(qaView3==false){
				initQA(qaNum);
			}
			qaView3=!qaView3;
			break;
		}
		case (4): {
			if(qaView4==false){
				initQA(qaNum);
			}
			qaView4=!qaView4;
			break;
		}
		case (5): {
			if(qaView5==false){
				initQA(qaNum);
			}
			qaView5=!qaView5;
			break;
		}
		case (6): {
			if(qaView6==false){
				initQA(qaNum);
			}
			qaView6=!qaView6;
			break;
		}
		case (7): {
			if(qaView7==false){
				initQA(qaNum);
			}
			qaView7=!qaView7;
			break;
		}
		case (8): {
			if(qaView8==false){
				initQA(qaNum);
			}
			qaView8=!qaView8;
			break;
		}
		case (9): {
			if(qaView9==false){
				initQA(qaNum);
			}
			qaView9=!qaView9;
			break;
		}
		case (10): {
			if(qaView10==false){
				initQA(qaNum);
			}
			qaView10=!qaView10;
			break;
		}
		}
	}

	public void initQA(Long qaNum) {
		switch (qaNum.intValue()) {
		case (1): {
			text_q1 = textBean.findByKey(Constants.TEXT_Q1);
			text_a1 = textBean.findByKey(Constants.TEXT_A1);
			qaView1=false;
			break;
		}
		case (2): {
			text_q2 = textBean.findByKey(Constants.TEXT_Q2);
			text_a2 = textBean.findByKey(Constants.TEXT_A2);
			qaView2=false;
			break;
		}
		case (3): {
			text_q3 = textBean.findByKey(Constants.TEXT_Q3);
			text_a3 = textBean.findByKey(Constants.TEXT_A3);
			qaView3=false;
			break;
		}
		case (4): {
			text_q4 = textBean.findByKey(Constants.TEXT_Q4);
			text_a4 = textBean.findByKey(Constants.TEXT_A4);
			qaView4=false;
			break;
		}
		case (5): {
			text_q5 = textBean.findByKey(Constants.TEXT_Q5);
			text_a5 = textBean.findByKey(Constants.TEXT_A5);
			qaView5=false;
			break;
		}
		case (6): {
			text_q6 = textBean.findByKey(Constants.TEXT_Q6);
			text_a6 = textBean.findByKey(Constants.TEXT_A6);
			qaView6=false;
			break;
		}
		case (7): {
			text_q7 = textBean.findByKey(Constants.TEXT_Q7);
			text_a7 = textBean.findByKey(Constants.TEXT_A7);
			qaView7=false;
			break;
		}
		case (8): {
			text_q8 = textBean.findByKey(Constants.TEXT_Q8);
			text_a8 = textBean.findByKey(Constants.TEXT_A8);
			qaView8=false;
			break;
		}
		case (9): {
			text_q9 = textBean.findByKey(Constants.TEXT_Q9);
			text_a9 = textBean.findByKey(Constants.TEXT_A9);
			qaView9=false;
			break;
		}
		case (10): {
			text_q10 = textBean.findByKey(Constants.TEXT_Q10);
			text_a10 = textBean.findByKey(Constants.TEXT_A10);
			qaView10=false;
			break;
		}
		}
	}


	public Boolean getQaView1() {
		return qaView1;
	}

	public void setQaView1(Boolean qaView1) {
		this.qaView1 = qaView1;
	}

	public Boolean getQaView2() {
		return qaView2;
	}

	public void setQaView2(Boolean qaView2) {
		this.qaView2 = qaView2;
	}

	public Boolean getQaView3() {
		return qaView3;
	}

	public void setQaView3(Boolean qaView3) {
		this.qaView3 = qaView3;
	}

	public Boolean getQaView4() {
		return qaView4;
	}

	public void setQaView4(Boolean qaView4) {
		this.qaView4 = qaView4;
	}

	public Boolean getQaView5() {
		return qaView5;
	}

	public void setQaView5(Boolean qaView5) {
		this.qaView5 = qaView5;
	}

	public Boolean getQaView6() {
		return qaView6;
	}

	public void setQaView6(Boolean qaView6) {
		this.qaView6 = qaView6;
	}

	public Boolean getQaView7() {
		return qaView7;
	}

	public void setQaView7(Boolean qaView7) {
		this.qaView7 = qaView7;
	}

	public Boolean getQaView8() {
		return qaView8;
	}

	public void setQaView8(Boolean qaView8) {
		this.qaView8 = qaView8;
	}

	public Boolean getQaView9() {
		return qaView9;
	}

	public void setQaView9(Boolean qaView9) {
		this.qaView9 = qaView9;
	}

	public Boolean getQaView10() {
		return qaView10;
	}

	public void setQaView10(Boolean qaView10) {
		this.qaView10 = qaView10;
	}

	public Text getText_q1() {
		return text_q1;
	}

	public void setText_q1(Text text_q1) {
		this.text_q1 = text_q1;
	}

	public Text getText_a1() {
		return text_a1;
	}

	public void setText_a1(Text text_a1) {
		this.text_a1 = text_a1;
	}

	public Text getText_q2() {
		return text_q2;
	}

	public void setText_q2(Text text_q2) {
		this.text_q2 = text_q2;
	}

	public Text getText_a2() {
		return text_a2;
	}

	public void setText_a2(Text text_a2) {
		this.text_a2 = text_a2;
	}

	public Text getText_q3() {
		return text_q3;
	}

	public void setText_q3(Text text_q3) {
		this.text_q3 = text_q3;
	}

	public Text getText_a3() {
		return text_a3;
	}

	public void setText_a3(Text text_a3) {
		this.text_a3 = text_a3;
	}

	public Text getText_q4() {
		return text_q4;
	}

	public void setText_q4(Text text_q4) {
		this.text_q4 = text_q4;
	}

	public Text getText_a4() {
		return text_a4;
	}

	public void setText_a4(Text text_a4) {
		this.text_a4 = text_a4;
	}

	public Text getText_q5() {
		return text_q5;
	}

	public void setText_q5(Text text_q5) {
		this.text_q5 = text_q5;
	}

	public Text getText_a5() {
		return text_a5;
	}

	public void setText_a5(Text text_a5) {
		this.text_a5 = text_a5;
	}

	public Text getText_q6() {
		return text_q6;
	}

	public void setText_q6(Text text_q6) {
		this.text_q6 = text_q6;
	}

	public Text getText_a6() {
		return text_a6;
	}

	public void setText_a6(Text text_a6) {
		this.text_a6 = text_a6;
	}

	public Text getText_q7() {
		return text_q7;
	}

	public void setText_q7(Text text_q7) {
		this.text_q7 = text_q7;
	}

	public Text getText_a7() {
		return text_a7;
	}

	public void setText_a7(Text text_a7) {
		this.text_a7 = text_a7;
	}

	public Text getText_q8() {
		return text_q8;
	}

	public void setText_q8(Text text_q8) {
		this.text_q8 = text_q8;
	}

	public Text getText_a8() {
		return text_a8;
	}

	public void setText_a8(Text text_a8) {
		this.text_a8 = text_a8;
	}

	public Text getText_q9() {
		return text_q9;
	}

	public void setText_q9(Text text_q9) {
		this.text_q9 = text_q9;
	}

	public Text getText_a9() {
		return text_a9;
	}

	public void setText_a9(Text text_a9) {
		this.text_a9 = text_a9;
	}

	public Text getText_q10() {
		return text_q10;
	}

	public void setText_q10(Text text_q10) {
		this.text_q10 = text_q10;
	}

	public Text getText_a10() {
		return text_a10;
	}

	public void setText_a10(Text text_a10) {
		this.text_a10 = text_a10;
	}

	
	
	
}
