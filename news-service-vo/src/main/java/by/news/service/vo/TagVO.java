package by.news.service.vo;

import java.util.Set;

public class TagVO {
    private int id;
    private String tagName;
    private Set<NewsVO> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<NewsVO> getTags() {
        return tags;
    }

    public void setTags(Set<NewsVO> tags) {
        this.tags = tags;
    }


}
