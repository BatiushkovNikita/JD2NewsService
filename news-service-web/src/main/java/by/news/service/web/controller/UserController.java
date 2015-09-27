package by.news.service.web.controller;

import by.news.service.service.interf.UserLocalService;
import by.news.service.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class UserController {

    @Inject
    private UserLocalService userLocalService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        model.addAttribute("userAttribute", new UserVO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userAttribute") UserVO userVO) {
        userLocalService.registerUser(userVO);
        return "redirect:/newsfeed";
    }
}
