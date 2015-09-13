package by.news.service.daojpa.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private Set<News> newses;

    public Tag() {
    }

    public Tag(int id, String tagName, Set<News> newses) {
        this.id = id;
        this.tagName = tagName;
        this.newses = newses;
    }

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

    public Set<News> getNewses() {
        return newses;
    }

    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (id != tag.id) return false;
        if (newses != null ? !newses.equals(tag.newses) : tag.newses != null) return false;
        if (tagName != null ? !tagName.equals(tag.tagName) : tag.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + (newses != null ? newses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", newses=" + newses +
                '}';
    }
}
