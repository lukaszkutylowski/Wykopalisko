package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout")
	public String logout(SessionStatus status, WebRequest request) {
		status.setComplete();
		request.removeAttribute("username", request.SCOPE_SESSION);
		return "index.jsp";
	}
}
