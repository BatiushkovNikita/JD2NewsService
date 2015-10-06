package by.news.service.vo;

import java.io.Serializable;

public class TagVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String tagName;

    public TagVO() {
    }

    public TagVO(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagVO tagVO = (TagVO) o;

        if (id != tagVO.id) return false;
        if (tagName != null ? !tagName.equals(tagVO.tagName) : tagVO.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    /* @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TagVO tagVO = (TagVO) o;

            if (id != tagVO.id) return false;
            if (tagName != null ? !tagName.equals(tagVO.tagName) : tagVO.tagName != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
            return result;
        }
    */
    @Override
    public String toString() {
        return "TagVO{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
