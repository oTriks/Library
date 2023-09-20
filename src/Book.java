public class Book {

    private String name;
    private String author;
    private int year;
    private double edition;
    private boolean available = true;

    public Book(String name, String author, int year, double edition) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.edition = edition;
    }

    public boolean loan() {
        if (available) {
            this.available = false;
            return true;
        } else {
            return false;
        }
    }

    public void returnBook() {
        this.available = true;
    }

    public String toSTring() {
        return ("Bokens namn: " + this.name + ". Författarens namn: " + this.author + ". Bokens år: " + this.year + ". Upplaga: " + this.edition + " Tillgänglig? " + this.available);

    }

    public String getName() {
        return name;
    }

    public void changeAvailable() {         //behöver inte använda denna då vi gjorde den i loan samt returnBook automatiskt
        if(available) {   //betyder sant
            this.available = false;
        } else{
            this.available = true;
        }
    }

    public boolean isAvailable() {
        return available;
    }
}
