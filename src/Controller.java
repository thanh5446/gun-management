import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final View view;
    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Add":
                if (view.isNull()) {
                    JOptionPane.showMessageDialog(null, "Please enter text into all fields!");
                } else if (!(View.isCharacter(view.nameText.getText()))) {
                    JOptionPane.showMessageDialog(null, "Please use appropriate words in the name field!");
                } else if (!(View.isCharacter(view.categoryText.getText()))) {
                    JOptionPane.showMessageDialog(null, "Please use appropriate words in the category field!");
                } else if (!(View.isNumber(view.priceText.getText()))) {
                    JOptionPane.showMessageDialog(null, "Enter a number into the pricing field!");
                } else if (!(View.isNumber(view.quantityText.getText()))) {
                    JOptionPane.showMessageDialog(null, "Enter a number into the quantity field!");
                } else {

                    View.products.add(this.view.getValuesFromForm());
                    Model.addProductToFIle();
                    this.view.setEmptyText();
                    this.view.setTableValues();
                    this.view.id++;
                    this.view.setID();
                }
                break;
            case "Delete":
                try {
                    this.view.deleteProduct();
                } catch (IndexOutOfBoundsException exception) {
                    JOptionPane.showMessageDialog(null, "Please select a row from the table above!");
                }
                break;
            case "Retrieve":
                try {
                    this.view.retrieveProduct();
                    this.view.setUnEnable();
                } catch (IndexOutOfBoundsException exception) {
                    JOptionPane.showMessageDialog(null, "Please select a row from the table above!");
                }
                break;
            case "Update":
                if (!(view.isNull())) {
                    if ((View.checkExist(Integer.parseInt(this.view.IDText.getText())))) {
                        int id = Integer.parseInt(this.view.IDText.getText());
                        this.view.checkID(id);
                        View.products.set(this.view.counter, this.view.getValuesFromForm());
                        Model.addProductToFIle();
                        this.view.setTableValues();
                        this.view.setEmptyText();
                        this.view.setEnable();
                        this.view.setID();
                    } else {
                        JOptionPane.showMessageDialog(null, "This product doesn't exist, please" +
                                                                                     "press retrieve first");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please press retrieve first and" +
                                                                                 " input all the text fields");
                }
                break;
            case "Cancel":
                this.view.setEmptyText();
                this.view.setEnable();
                this.view.setID();
                break;
            case "Search":
                this.view.search();
                break;
            case "Return":
                this.view.setTableValues();
                this.view.searchText.setText("");
                break;
        }
    }
}
