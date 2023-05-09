package SAXDemo;

import javax.xml.crypto.Data;

/**
 * @Author Zhixiang Shang
 * @Date 09.05.2023 18:25
 * @Version 1.0
 */
public class BookEntity {
    private String author;
    private String title;
    private String genre;
    private Double price;
    private String publish_date;
    private String description;

    @Override
    public String toString() {
        return "BookEntity{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookEntity() {
    }

    public BookEntity(String author, String title, String genre, Double price, String publish_date, String description) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publish_date = publish_date;
        this.description = description;
    }


}
