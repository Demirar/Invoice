package S.Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HAMDY
 */
public class RightTableModel extends AbstractTableModel {

    private ArrayList<InvoiceLine> data;

    public RightTableModel(ArrayList<InvoiceLine> data) {
        this.data = data;
    }
    private String[] cols = {"No.","Item Name", "Unit Price", "Count"};

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
        InvoiceLine line = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return rowIndex+1;
            case 1:
                return line.getName();
            case 2:
                return line.getPrice();
            case 3:
                return line.getCount();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
}