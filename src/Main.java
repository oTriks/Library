import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book("golf", "kajsa", 2000, 1.2);
        Book book2 = new Book("tennis", "anna", 2003, 1.8);
        Book book3 = new Book("fotboll", "pär", 2002, 1.2);
        Book book4 = new Book("hockey", "emil", 2001, 1.5);
        Book book5 = new Book("bandy", "olof", 2006, 1.2);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);


//        System.out.println(book1.loan());
//        System.out.println(book1.toSTring());
//        book1.returnBook();
//        System.out.println(book1.toSTring());

        do {
            System.out.println("1. Lägg till en bok \n2. Sök efter en bok \n3. Se tillgängliga böcker \n4. Returnera en bok \n5. Låna en bok\n6. Avsluta");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Ange namn:");
                    String name = sc.nextLine();
                    System.out.println("Ange författare:");
                    String author = sc.nextLine();
                    System.out.println("Ange årtal:");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ange upplaga:");
                    int edition = sc.nextInt();
                    sc.nextLine();
                    Book newBook = new Book(name, author, year, edition);
                    books.add(newBook);
                    break;

                case 2:
                    System.out.println("Vilken bok söker du?");
                    String input = sc.nextLine();
                    boolean found = false;    // sätts direkt till false
                    for (Book i : books) {      // inte samma i som innan, kan kalla den vad jag vill
                        if (i.getName().equals(input)) {
                            System.out.println("Boken hittades, dess information är:");
                            System.out.println(i.toSTring());
                            found = true;
                        }
                    }
                    if (found == false) {        // görs efter hela biblioteket är genomsökt, efter for loopen dvs
                        System.out.println("Boken hittades inte!");
                    }
                    break;
                case 3:
                    for (Book i : books) {    // kallar varje bok i nu i vår lista
                        System.out.println(i.toSTring());
//                        String bookInfo = i.toSTring();    // annat sätt att skriva på
//                        System.out.println(bookInfo);      // annat sätt att skriva på, bättre om vi vill spara det och använda senare i programmet
                    }
                    break;
                case 4:
                    System.out.println("Vilken bok vill du lämna tillbaka?");
                    String bookName = sc.nextLine();
                    boolean bookReturn = false;
                    for (Book i : books) {
                        if (i.getName().equals(bookName)) {
                            //kollar status på boken om den går att returnera ( är utlånad )
                            boolean status = i.isAvailable();
                            if (!status) {
                                i.returnBook();
                                System.out.println("Tack för att du returnerat!");
                                bookReturn = true;
                             //   i.changeAvailable();    // görs automatiskt i returnBook
                            } else {
                                System.out.println("Boken är inte utlånad och kan därför inte lämnas tillbaka!");
                                bookReturn = true; // för att undvika nästa kods if sats
                            }
                        }
                    }
                    if (!bookReturn) {    // annat sätt att skriva bookReturn == false;
                        System.out.println("Boken finns inte i vårt system!");
                    }
                    break;

                    case 5:
                        System.out.println("Vilken bok vill du låna?");
                        String loanName = sc.nextLine();
                        for (Book i : books) {
                            if (i.getName().equals(loanName)) {
                                boolean status = i.isAvailable();
                                if (status) {
                                    i.loan();
                                    System.out.println("Tack för att du lånat!");
                                  //  i.changeAvailable();   // görs automatiskt i loan funktionen
                                } else {
                                    System.out.println("Boken är redan utlånad!");
                                }
                            }
                        }
                        break;

                case 6:
                    System.out.println("Hejdå!");
                    break;
            }
    }while(choice !=6);  //betyder inte =


}
}