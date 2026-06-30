class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibrarySearch {

    static Book linearSearch(Book[] books, String title) {

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title))
                return b;
        }

        return null;
    }

    static int binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(title);

            if (result == 0)
                return mid;
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {

        Book[] books = {
                new Book(1, "Algorithms", "CLRS"),
                new Book(2, "Java Programming", "Herbert Schildt"),
                new Book(3, "Operating Systems", "Galvin")
        };

        System.out.println("Linear Search:");

        Book result = linearSearch(books, "Java Programming");

        if (result != null) {
            System.out.println(result.title + " by " + result.author);
        }

        System.out.println("\nBinary Search:");

        int index = binarySearch(books, "Java Programming");

        if (index != -1) {
            System.out.println(books[index].title + " by " + books[index].author);
        }
    }
}