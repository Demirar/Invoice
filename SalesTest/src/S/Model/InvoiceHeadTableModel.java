package S.Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HAMDY
 */
public class InvoiceHeadTableModel extends AbstractTableModel{
    private ArrayList<InvoiceHeader> data;
    private String[] cols = {"ID","Invoice Date","Customer"};
    
    public InvoiceHeadTableModel (ArrayList<InvoiceHeader> data){
        this.data = data;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader header = data.get(rowIndex);
        switch (columnIndex)
        {
            case 0 :
                return header.getNum( );      
            case 1 :
                return header.getCustomer();
            case 2 :
                return header.getDate();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return cols[column]; 
    }
    
}
