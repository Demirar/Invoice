package S.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HAMDY
 */
public class InvoiceHeader {
    
    private int num;
    private Date date;
    private String Customer;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int num, Date date, String Customer) {
        this.num = num;
        this.date = date;
        this.Customer = Customer;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
      
}
