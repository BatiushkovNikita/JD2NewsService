package by.news.service.vo;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

public class NewsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @NotBlank(message = "{NotBlank.topic}")
    private String topic;

    private String publicationDate;

    @NotBlank(message = "{NotBlank.newsText}")
    private String newsText;
    
    private String authorFirsName;
    private String authorLastName;
    private String authorEmail;
    private int userId;

    private List<TagVO> tagsVO;

    public NewsVO() {

    }

    public NewsVO(int id, String topic, String publicationDate, String newsText, String authorFirsName, String authorLastName, List<TagVO> tagsVO) {
        this.id = id;
        this.topic = topic;
        this.publicationDate = publicationDate;
        this.newsText = newsText;
        this.authorFirsName = authorFirsName;
        this.authorLastName = authorLastName;
        this.tagsVO = tagsVO;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public String getAuthorFirsName() {
        return authorFirsName;
    }

    public void setAuthorFirsName(String authorFirsName) {
        this.authorFirsName = authorFirsName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public List<TagVO> getTagsVO() {
        return tagsVO;
    }

    public void setTagsVO(List<TagVO> tagsVO) {
        this.tagsVO = tagsVO;
    }

    @Override
    public String toString() {
        return "NewsVO{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", newsText='" + newsText + '\'' +
                ", authorFirsName='" + authorFirsName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", tagsVO=" + tagsVO +
                '}';
    }
}
