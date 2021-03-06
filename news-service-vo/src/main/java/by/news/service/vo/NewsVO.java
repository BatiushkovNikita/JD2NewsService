package by.news.service.vo;


import java.util.Set;

public class NewsVO {
    private int id;
    private String topic;
    private String publicationDate;
    private String newsText;
    private String authorFirsName;
    private String authorLastName;
    private Set<TagVO> tagsVO;

    public NewsVO() {

    }

    public NewsVO(int id, String topic, String publicationDate, String newsText, String authorFirsName, String authorLastName, Set<TagVO> tagsVO) {
        this.id = id;
        this.topic = topic;
        this.publicationDate = publicationDate;
        this.newsText = newsText;
        this.authorFirsName = authorFirsName;
        this.authorLastName = authorLastName;
        this.tagsVO = tagsVO;
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

    public Set<TagVO> getTagsVO() {
        return tagsVO;
    }

    public void setTagsVO(Set<TagVO> tagsVO) {
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
