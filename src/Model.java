import javax.swing.*;
import java.io.*;

public class Model {

    public static void addProductToFIle(){
        try{
            File outFile = new File("gunData.txt");
            FileOutputStream outputStream = new FileOutputStream(outFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            for(Product product : View.products){
                objectOutputStream.writeObject(product);
            }
            objectOutputStream.close();
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "File isn't found, a new file will be created");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Can't save the file");
        }
    }

    public static void readProductFromFile(){
        try{
            File infile = new File("gunData.txt");
            FileInputStream inputStream = new FileInputStream(infile);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            while (true){
                Product product = (Product) objectInputStream.readObject();
                View.products.add(product);
                if(product==null){
                    break;
                }
            }
            objectInputStream.close();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "The file is not found,a new file will be created!");
        }  catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Class isn't found");
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Successfully loaded the file");
        }
    }
}
