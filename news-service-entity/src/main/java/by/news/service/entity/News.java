package by.news.service.entity;

public class News {
	private int newsID;
	private String topic;
	private String publicationDate;
	private String newsText;
	private int userID;

	public News(int newsID, String topic, String publicationDate, String newsText, int userID) {
		super();
		this.newsID = newsID;
		this.topic = topic;
		this.publicationDate = publicationDate;
		this.newsText = newsText;
		this.userID = userID;
	}

	public News(String topic, String publicationDate, String newsText, int userID) {
		super();
		this.topic = topic;
		this.publicationDate = publicationDate;
		this.newsText = newsText;
		this.userID = userID;
	}

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + newsID;
		result = prime * result + ((newsText == null) ? 0 : newsText.hashCode());
		result = prime * result + ((publicationDate == null) ? 0 : publicationDate.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + userID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (newsID != other.newsID)
			return false;
		if (newsText == null) {
			if (other.newsText != null)
				return false;
		} else if (!newsText.equals(other.newsText))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [newsID=" + newsID + ", topic=" + topic + ", publicationDate=" + publicationDate + ", newsText="
				+ newsText + ", userID=" + userID + "]";
	}
}
