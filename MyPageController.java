package jp.co.internous.wings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.wings.model.domain.MstUser;
import jp.co.internous.wings.model.mapper.MstUserMapper;
import jp.co.internous.wings.model.session.LoginSession;


//コントローラクラスと宣言
@Controller
@RequestMapping("/wings/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper mstUserMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		MstUser userList = mstUserMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
		
		m.addAttribute("userList", userList);
		m.addAttribute("loginSession", loginSession);
			
		return "my_page";
	}
}