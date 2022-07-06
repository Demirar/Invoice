package S.Controller;

import S.Model.InvoiceHeader;
import S.Model.InvoiceLine;
import S.Model.RightTableModel;
import SER.SalesReport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author HAMDY
 */
public class ActionHandle implements ActionListener, ListSelectionListener {

    private SalesReport frame;

    public ActionHandle(SalesReport frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Action Handling");
        String actionCommand = ae.getActionCommand();
        switch (actionCommand) {
            case "Create New Invoice":
                System.out.println("NewInvoice");
                newInv();
                break;
            case "Delete Invoice":
                System.out.println("DeleteInvoice");
                deleteInv();
                break;
            case "Load File":
                System.out.println("LoadTHEFILE");
                loadFile();
                break;
            case "Save File":
                System.out.println("save");
                saveFile();
        }
    }

    private void newInv() {

    }

    private void deleteInv() {
         JFileChooser a1 = new JFileChooser();
    }

    private void loadFile() {
        
        try {
            ArrayList<InvoiceHeader> invoiceHeadersList = new ArrayList<>();
            JFileChooser f1 = new JFileChooser();
            int result = f1.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = f1.getSelectedFile();
                String headerStrPath = headerFile.getAbsolutePath();
                Path headerPath = Paths.get(headerStrPath);
                List<String> headerLines = Files.lines(headerPath).collect(Collectors.toList());
                
                for (String headerLine : headerLines) {
                    String[] parts = headerLine.split(",");
                    int id = Integer.parseInt(parts[0]);
                    InvoiceHeader invHeader = new InvoiceHeader(id, parts[1], parts[2]);
                    invoiceHeadersList.add(invHeader);
                }
                
                System.out.println("check");
                result = f1.showOpenDialog(frame);
            }
            if (result == JFileChooser.APPROVE_OPTION) {
                String lineStrPath = f1.getSelectedFile().getAbsolutePath();
                Path linePath = Paths.get(lineStrPath);
                List<String> linesLines = Files.lines(linePath).collect(Collectors.toList());
                //[1,mobile,3200,1],"[1,cover,20,2],[1,Headephone,130,1], "[2,laptop,4000,1]"

                for (String lineLine : linesLines) {
                    String[] parts = lineLine.split(",");
                    //part1=[1,mobile,3200,1]
                    //parrt2
                    int invId = Integer.parseInt(parts[0]);
                    double price = Double.parseDouble(parts[2]);
                    int count = Integer.parseInt(parts[3]);
                    InvoiceHeader header = getHeaderId(invoiceHeadersList, invId);
                    InvoiceLine invLine = new InvoiceLine(header,parts[1], price , count);
                    header.getLines().add(invLine);
                }
                frame.setInvoiceHeadersList(invoiceHeadersList);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private InvoiceHeader getHeaderId(ArrayList<InvoiceHeader> invoices, int id) {
        for (InvoiceHeader invoice : invoices) {
            if (invoice.getNum() == id) {
                return invoice;
            }
        }
        return null;
    }

    private void saveFile() {
        JFileChooser fs = new JFileChooser();
            int result = fs.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fs.getSelectedFile();
                //List<String> headerLines = Files.lines(headerPath).collect(Collectors.toList());
                int a = fs.showSaveDialog(fs);
       
                }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //System.out.println("Selected Row");
        int selectedRow = frame.getInvHeaderTable().getSelectedRow();
        //System.out.println(selectedRow);
        ArrayList<InvoiceLine> lines = frame.getInvoiceHeadersList().get(selectedRow).getLines();
        frame.setValue(frame.getInvoiceHeadersList().get(selectedRow));
        frame.getInvLineTable().setModel(new RightTableModel(lines));
        
        
        
    }
}
