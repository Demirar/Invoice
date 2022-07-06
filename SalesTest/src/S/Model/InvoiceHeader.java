package S.Model;

import java.util.ArrayList;

/**
 *
 * @author HAMDY
 */
public class InvoiceHeader {
    
    private int num;
    private String date;
    private String Customer;
    private ArrayList<InvoiceLine> lines;
    
    public InvoiceHeader(int num, String date, String Customer) {
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
    
    public double getInvoiceTotal()
    {
        double total = 0 ;
        for (InvoiceLine line : getLines())
        {
            total += line.getLineTotal();
        }
        return total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public ArrayList<InvoiceLine> getLines() {
        if (lines == null)
        { lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", date=" + date + ", Customer=" + Customer + '}';
    }
      
}
