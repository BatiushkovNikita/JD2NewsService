package by.news.service.web.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class RoleTag extends TagSupport {

	private String role;

	public void setRole(String role) {
		this.role = role;
	}

	/*public int doStartTag() {
		if(role.equalsIgnoreCase("admin")) {
			pageContext.include
		}
	}*/

}
