package template;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private CheckoutManager checkoutManager;
    private List<LibraryRegister> registers;

    public Library() {
        this.items = new ArrayList<>();
        this.checkoutManager = new CheckoutManager();
        this.registers = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        checkoutManager.returnItem(item);
    }

    public void checkOutItem(LibraryItem item, LibraryRegister name) {
        checkoutManager.checkOutItem(item, name);
        name.addStamp(); //checkout할 때 마다 스탬프 적립
    }

    public void returnItem(LibraryItem item) {
        checkoutManager.returnItem(item);
    }

    public void generateReport() {
        System.out.println("Library generateReport");
        for (LibraryItem item : items) {
            item.generateReport();
            System.out.println(item.getTitle() + " was checked out by " + checkoutManager.isCheckedOut(item));
        }
    }

    public void addRegister(LibraryRegister name) {
        registers.add(name);
    }

    public void viewStamp(){
        for (LibraryRegister register : registers) {
            register.viewStamp();
        }
    } 
}
