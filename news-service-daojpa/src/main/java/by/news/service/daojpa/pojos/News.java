package by.news.service.daojpa.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "news")
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "publication_date")
    private String publicationDate;

    @Column(name = "news_text")
    private String newsText;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "news_tag",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    public News() {

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (userId != news.userId) return false;
        if (newsText != null ? !newsText.equals(news.newsText) : news.newsText != null) return false;
        if (publicationDate != null ? !publicationDate.equals(news.publicationDate) : news.publicationDate != null)
            return false;
        if (tags != null ? !tags.equals(news.tags) : news.tags != null) return false;
        if (topic != null ? !topic.equals(news.topic) : news.topic != null) return false;
        if (user != null ? !user.equals(news.user) : news.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (newsText != null ? newsText.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", newsText='" + newsText + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                ", tags=" + tags +
                '}';
    }
}
