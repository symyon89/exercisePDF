import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

enum Genere{
    ADEVENTURE,
    TRAVELING,
    FANTASY
}


public class Book {
    private String title;
    private int price;
    private LocalDate yearOfRelease;
    private List<Author> authorList;
    private Genere genere;

    public Book(String title, int price, LocalDate yearOfRelease, List<Author> authorList, Genere genere) {
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.authorList = authorList;
        this.genere = genere;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(LocalDate yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", yearOfRelease=" + yearOfRelease +
                ", authorList=" + authorList +
                ", genere=" + genere + "}";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && Objects.equals(title, book.title) && Objects.equals(yearOfRelease, book.yearOfRelease) && Objects.equals(authorList, book.authorList) && genere == book.genere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, yearOfRelease, authorList, genere);
    }
}


