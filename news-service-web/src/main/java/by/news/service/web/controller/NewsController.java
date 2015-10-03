package by.news.service.web.controller;


import by.news.service.service.interf.NewsLocalService;
import by.news.service.vo.NewsVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@Controller
public class NewsController {

    private Logger Log = LogManager.getLogger(NewsController.class.getName());

    @Inject
    private NewsLocalService newsLocalService;

    @RequestMapping(value = "/newsfeed", method = {RequestMethod.GET, RequestMethod.POST})
    public String viewNewsFeed(Model model) {
        model.addAttribute("newsFeed", newsLocalService.getAllNews());
        return "newsfeed";
    }

    @RequestMapping(value = "/addnews", method = RequestMethod.GET)
    public String viewAddNews(Model model) {
        model.addAttribute("newsAttribute", new NewsVO());
        return "addnew";
    }

    @RequestMapping(value = "/addnews", method = RequestMethod.POST)
    public ModelAndView addingNews(@ModelAttribute("newsAttribute") NewsVO newsVO,
                                   BindingResult result, SessionStatus status, Principal principal) {
        /*int newsId;
        Log.debug("Validation form input");
        newsValidator.validate(newsVO, result);
        if (result.hasErrors()) {
            Log.debug("Validation failed");
            return new ModelAndView("addnews", "newsAttribute", newsVO);
        } else {
            Log.debug("Validation passed");
            status.setComplete();
            Log.debug("Adding news");
            newsVO.setAuthorEmail(principal.getName());
            newsId = newsLocalService.addNews(newsVO);
        }
        Log.debug("News with id: " + newsId + " was added");*/
        return new ModelAndView("redirect:/newsfeed", "newsAttribute", newsVO);
    }
}
