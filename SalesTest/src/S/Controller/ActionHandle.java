package S.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author HAMDY
 */
public class ActionHandle implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
      
        System.out.println("Action Handling");
        
        switch (ae.getActionCommand()){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadFile() {
        JFileChooser f1 = new JFileChooser ();
        int result;
        /*if (result == JFileChooser.APPROVE_OPTION{
            String path = f1.getSelectedFile().getPath();
            FileInputStream fis = null ;
            try{
                fis = new FileInputStream(path);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                ts.setText(new String(b));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            } finally {
                try {fis.close();} catch (IOException e){}
        })*/
        result = f1.showOpenDialog(f1);
    }

    private void saveFile() {
        JFileChooser fs = new JFileChooser ();
        int a;
        a = fs.showSaveDialog(fs);
        /*if (a == JFileChooser.APPROVE_OPTION)
        {
            String path;
            path = fs.getselectedFile().getPath();
            FileOutputStream fos = null;
            
            fos = new FileOutputStream(path);
        }**/
    }
    
}
