package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/*home.jspからきたよん*/

public class HomeAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		String result = "login";
		if (session.containsKey("login_user_id")) {
//			buyIinformDAOをインスタンス化する

			BuyItemDAO buyItemDAO = new BuyItemDAO();
			//getItemdaoのgetbuyitemメソッドを処理する、その結果をgetitemdtoに代入する
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			//buyitemdtoのgetitemnameメソッド
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result = SUCCESS;
		}
		return result;

	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
