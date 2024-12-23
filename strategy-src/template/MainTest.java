package template;

public class MainTest {

    public MainTest() {
        Library library1 = new Library();
        LibraryItem[] items1 = { 
            new Book("The Little Prince", "Antoine Marie Jean-Baptiste Roger de Saint-Exupéry"),
            new CD("We Are the World", "Roger Emerson, Michael Jackson, Lionel Richie"),
            new DVD("Star Wars: A New Hope", "George Lucas", 12),
            new Ebook("Onepiece", "EIICHIRO ODA")
        };

        LibraryRegister[] registers1 = {
            new NormalRegister("NormalRegister"),
            new SpecialRegister("SpecialRegister")
        };

        for (var item : items1) {
            library1.addItem(item);
        }
        for (var register : registers1) {
            library1.addRegister(register);
        }

        System.out.println("==================After CheckOut==================");
        library1.checkOutItem(items1[0], registers1[0]);
        library1.checkOutItem(items1[1], registers1[1]);
        library1.generateReport();

        System.out.println("==================View Stamp==================");
        library1.viewStamp();
        
        System.out.println("==================After ReturnItem==================");
        library1.returnItem(items1[1]);
        library1.generateReport();
    }
}
