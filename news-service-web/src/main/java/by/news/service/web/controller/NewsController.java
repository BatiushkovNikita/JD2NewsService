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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/addnews", method = RequestMethod.POST)
    public ModelAndView addingNews(@ModelAttribute("newsVOParam") NewsVO newsVO,
                                   BindingResult result, SessionStatus status,
                                   @AuthenticationPrincipal UserVO userVO) {
        newsValidator.validate(newsVO, result);
        Log.error("Tags returned to controller: " + newsVO.getTagsVO());

        if (result.hasErrors()) {
            Log.error(result.getAllErrors());
            return new ModelAndView("addnews", "newsVOParam", newsVO);
        } else {
            status.setComplete();
            newsVO.setUserId(userVO.getId());
            newsLocalService.addNews(newsVO);
        }
        return new ModelAndView("redirect:/newsfeed", "newsVOParam", newsVO);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "tagsVO", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                String[] ids = text.split(",");
                List<TagVO> tags = null;
                for (String id : ids) {
                    if (tags == null)
                        tags = new ArrayList<TagVO>();
                    TagVO tag = tagLocalService.getAllTags().get(0);
                    if (tag != null)
                        tags.add(tag);

                }
                if(tags!=null)
                    setValue(tags);
            }
        });
    }
}
