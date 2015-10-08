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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView viewAddNews(Model model) {
        NewsVO newsVO = new NewsVO();
        List<TagVO> tagsVO = tagLocalService.getAllTags();
        model.addAttribute("newsVOParam", newsVO);
        model.addAttribute("tagsVOParam", tagsVO);
        return new ModelAndView("addnews", "newsVO", newsVO);
    }

    @RequestMapping(value = {"/addnews", "/editnews"}, method = RequestMethod.POST)
    public ModelAndView addingNews(@ModelAttribute("newsVOParam") NewsVO newsVO,
                                   BindingResult result, SessionStatus status,
                                   @AuthenticationPrincipal UserVO userVO) {
        newsValidator.validate(newsVO, result);
        if (result.hasErrors()) {
            Log.error(result.getAllErrors());
            List<TagVO> tagsVO = tagLocalService.getAllTags();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addnews");
            modelAndView.addObject("newsVOParam", newsVO);
            modelAndView.addObject("tagsVOParam", tagsVO);
            return modelAndView;
        } else {
            status.setComplete();
            newsVO.setUserId(userVO.getId());
            newsLocalService.addNews(newsVO);
        }
        return new ModelAndView("redirect:/newsfeed", "newsVOParam", newsVO);
    }

    @RequestMapping(value = "{newsId}/delete", method = RequestMethod.GET)
    public String deleteNews(@PathVariable("newsId") int newsId) {
        newsLocalService.deleteNews(newsId);
        return "redirect:/newsfeed";
    }

    @RequestMapping(value = "{newsId}/edit", method = RequestMethod.GET)
    public ModelAndView viewEditNews(@PathVariable("newsId") int newsId, Model model) {
        NewsVO newsVO = newsLocalService.getNewsById(newsId);
        List<TagVO> tagsVO = tagLocalService.getAllTags();
        model.addAttribute("newsVOParam", newsVO);
        model.addAttribute("tagsVOParam", tagsVO);
        return new ModelAndView("editnews", "newsVO", newsVO);
    }

    @RequestMapping(value = "{tagName}/newsfeed", method = RequestMethod.GET)
    public String viewNewsesByTagName(@PathVariable("tagName") String tagName, Model model) {
        List<NewsVO> newsesByTagName = tagLocalService.getNewsesByTagName(tagName);
        model.addAttribute("newsFeed", newsesByTagName);
        return "newsfeed";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "tagsVO", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                String[] tagsVoIds = text.split(",");
                List<TagVO> tagsVO = new ArrayList<>();
                for (String id : tagsVoIds) {
                    TagVO tag = tagLocalService.getTagById(Integer.valueOf(id));
                    tagsVO.add(tag);
                }
                setValue(tagsVO);
            }
        });
    }
}
