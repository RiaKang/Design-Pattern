package template;

import java.util.HashMap;
import java.util.Map;

public class CheckoutManager {
    private Map<LibraryItem, LibraryRegister> checkoutStatus;
    private LibraryRegister resetRegister;

    public CheckoutManager(){
        this.checkoutStatus = new HashMap<LibraryItem, LibraryRegister>();
        this.resetRegister = new LibraryRegister("none");
    }

    public void checkOutItem(LibraryItem item, LibraryRegister name) {
        checkoutStatus.put(item, name);
        //chekcOut 하면 해당 item의 boolean을 false로 설정
    }

    public void returnItem(LibraryItem item) {
        checkoutStatus.put(item, resetRegister);
        //returnItem(반납) 하면 해당 item의 boolean을 false로 설정
    }

    public String isCheckedOut(LibraryItem item){
        LibraryRegister ischeckedout = checkoutStatus.get(item);
        return ischeckedout.getName();
    }

}
