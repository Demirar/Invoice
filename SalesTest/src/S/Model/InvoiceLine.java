package S.Model;

/**
 *
 * @author HAMDY
 */
public class InvoiceLine {
    private String name;
    private double price;
    private int count;
    private InvoiceHeader header;   
    
    public InvoiceLine(InvoiceHeader header, String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.header = header;
    }

    public int getCount() {
        return count;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getLineTotal(){
        return count * price;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "header=" + header + ", name=" + name + ", Total=" + getLineTotal() + ", count=" + count + '}';
    }
 

}
