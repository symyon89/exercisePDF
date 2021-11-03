
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class BookService {
    private List<Book> bookList;

    public void addBook(Book book){
        bookList.add(book);
    }
    public void removeBook(int index){
        bookList.remove(index);
    }
    public void showBooks(){
        bookList.forEach(book -> System.out.println(book));
    }

    public void fantasyBooks(){
        bookList.stream()
                .filter(book -> book.getGenere().equals(Genere.FANTASY))
                .forEach(book -> System.out.println(book));
    }
    public void booksAfter1999(){
        LocalDate date = LocalDate.parse("1999-01-01");

        bookList.stream()
                .filter(book -> book.getYearOfRelease().isAfter(date))
                .forEach(book -> System.out.println(book));
    }
    public void mostExpensiveBook(){
        int maxPrice = bookList.get(0).getPrice();
        Book maxBook = new Book();
        for (Book book : bookList) {
            if (book.getPrice() > maxPrice) {
                maxBook = book;
                maxPrice = book.getPrice();
            }
        }
        System.out.println(maxBook);
    }

    public void cheepestBook(){
        int minPrice = bookList.get(0).getPrice();
        Book maxBook = new Book();
        for (Book book : bookList) {
            if (book.getPrice() < minPrice) {
                maxBook = book;
                minPrice = book.getPrice();
            }
        }
        System.out.println(maxBook);
    }

    public void showBooksWrittenBy3Authors(){
        bookList.stream()
                .filter(book -> book.getAuthorList().size() == 3)
                .forEach(book -> System.out.println(book));
    }
    public List<Book> ascending(){
        Collections.sort(bookList,new ComparaAsc());
        return bookList;
    }
    public List<Book> descending(){
        Collections.sort(bookList,new ComparaDesc());
        return bookList;
    }

    class ComparaAsc implements Comparator<Book>{
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
    class ComparaDesc implements Comparator<Book>{
        @Override
        public int compare(Book o1, Book o2) {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    }
    public void showIfABookisOnTheList(String bookName){
        bookList.stream()
                .filter(book -> book.getTitle().equals(bookName))
                .forEach(book -> System.out.println(book));
    }
    public void showByAuthor(String author){
        bookList.stream()
                .filter(book -> book.getAuthorList().contains(author))
                .forEach(book -> System.out.println(book));

    }


}
