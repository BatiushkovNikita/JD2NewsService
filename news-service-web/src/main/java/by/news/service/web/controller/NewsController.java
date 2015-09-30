package by.news.service.web.controller;


import by.news.service.service.interf.NewsLocalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class NewsController {

    @Inject
    private NewsLocalService newsLocalService;

    @RequestMapping(value = "/newsfeed", method = {RequestMethod.GET, RequestMethod.POST})
    public String viewNewsFeed(Model model) {
        model.addAttribute("newsFeed", newsLocalService.getAllNews());
        return "newsfeed";
    }

    @RequestMapping(value = "/addnews", method = RequestMethod.GET)
    public String viewAddNews(Model model) {
        return "addnews";
    }
}
