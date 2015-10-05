package by.news.service.web.controller;


import by.news.service.service.interf.NewsLocalService;
import by.news.service.service.interf.TagLocalService;
import by.news.service.vo.NewsVO;
import by.news.service.vo.TagVO;
import by.news.service.vo.UserVO;
import by.news.service.web.validator.impl.AbstractValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.security.Principal;
import java.util.Set;

@Controller
public class NewsController {

    private Logger Log = LogManager.getLogger(NewsController.class.getName());

    @Inject
    private AbstractValidator newsValidator;

    @Inject
    private NewsLocalService newsLocalService;

    @Inject
    private TagLocalService tagLocalService;

    @RequestMapping(value = "/newsfeed", method = {RequestMethod.GET, RequestMethod.POST})
    public String viewNewsFeed(Model model) {
        model.addAttribute("newsFeed", newsLocalService.getAllNews());
        return "newsfeed";
    }

    @RequestMapping(value = "/addnews", method = RequestMethod.GET)
    public String viewAddNews(Model model) {
        model.addAttribute("newsAttribute", new NewsVO());
        Set<TagVO> allTags = tagLocalService.getAllTags();
        model.addAttribute("tags", allTags);
        return "addnews";
    }

    @RequestMapping(value = "/addnews", method = RequestMethod.POST)
    public ModelAndView addingNews(@ModelAttribute("newsAttribute") NewsVO newsVO,
                                   BindingResult result, SessionStatus status, Principal principal,
                                   @AuthenticationPrincipal UserVO userVO) {
        newsValidator.validate(newsVO, result);
        if (result.hasErrors()) {
            return new ModelAndView("addnews", "newsAttribute", newsVO);
        } else {
            status.setComplete();
            newsVO.setUserId(userVO.getId());
            newsLocalService.addNews(newsVO);
        }
        return new ModelAndView("redirect:/newsfeed", "newsAttribute", newsVO);
    }
}
