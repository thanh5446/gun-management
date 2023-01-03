import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    private final Model model;
    private JPanel panelTop, panelHeader, panelMid, panelBottom, IDPanel, namePanel, pricePanel, categoryPanel, sizePanel,
            quantityPanel, listPanel;
    private JButton addButton, editButton, deleteButton, cancelButton, retrieveButton, searchButton, returnButton;
    private JLabel IDLabel, nameLabel, priceLabel, categoryLabel, sizeLabel, quantityLabel,
            searchLabel, titleLabel, orderLabel;
    public JTextField nameText, priceText, categoryText, sizeText, quantityText;
    public JComboBox sizeBox, orderBox;
    public JTextField IDText, searchText;
    public JTable productTable;
    private static DefaultTableModel tableModel;
    protected static ArrayList<Product> products = new ArrayList<>();
    public int id = 1;
    public int counter = 1;

    public View() {
        this.model = new Model();
        this.init();
        this.setID();
        this.setVisible(true);
    }

    //set layout
    public void init() {
        this.setTitle("Gun Inventory Management " + "");
        this.setSize(1100, 800);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 0));

        panelHeader = new JPanel();
        panelHeader.setBackground(new Color(141, 149, 166, 255));
        panelHeader.setLayout(null);
        panelBottom = new JPanel();

        panelTop = new JPanel();
        panelTop.setBackground(new Color(236, 206, 173, 255));
        panelTop.setBounds(0,0,1100,145);
        panelTop.setLayout(null);

        panelMid = new JPanel();
        panelMid.setBounds(0,150,1100,227);

        panelHeader.add(panelTop);
        panelHeader.add(panelMid);

        addButton = new JButton("Add");
        editButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        cancelButton = new JButton("Cancel");
        retrieveButton = new JButton("Retrieve");

        Controller controller = new Controller(this);
        addButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        editButton.addActionListener(controller);
        cancelButton.addActionListener(controller);
        retrieveButton.addActionListener(controller);

        IDLabel = new JLabel("ID:");
        IDLabel.setBounds(60, 30, 120, 30);
        nameLabel = new JLabel("Name Gun:");
        nameLabel.setBounds(60, 30, 120, 30);
        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(60, 30, 120, 30);
        categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(60, 30, 120, 30);
        sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(60, 30, 120, 30);
        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(60, 30, 120, 30);

        IDPanel = new JPanel();
        quantityPanel = new JPanel();
        namePanel = new JPanel();
        pricePanel = new JPanel();
        categoryPanel = new JPanel();
        sizePanel = new JPanel();
        listPanel = new JPanel(new FlowLayout());

        //layout below
        IDPanel.setBounds(80, 30, 500, 60);
        IDPanel.setLayout(null);
        namePanel.setBounds(550, 30, 500, 60);
        namePanel.setLayout(null);
        pricePanel.setBounds(80, 90, 500, 60);
        pricePanel.setLayout(null);
        categoryPanel.setBounds(550, 90, 500, 60);
        categoryPanel.setLayout(null);
        sizePanel.setBounds(80, 150, 500, 60);
        sizePanel.setLayout(null);
        quantityPanel.setBounds(550, 150, 600, 60);
        quantityPanel.setLayout(null);
        listPanel.setBounds(0, 300, 1100, 190);
        listPanel.setBackground(new Color(236, 206, 173, 255));

        IDText = new JTextField();
        IDText.setBounds(120, 30, 250, 30);
        IDText.setEditable(false);
        nameText = new JTextField();
        nameText.setBounds(170, 30, 250, 30);
        priceText = new JTextField();
        priceText.setBounds(120, 30, 250, 30);
        categoryText = new JTextField();
        categoryText.setBounds(170, 30, 250, 30);
        String[] size = {"", "Small", "Medium", "Big"};
        sizeBox = new JComboBox<>(size);
        sizeBox.setBounds(120, 30, 250, 30);
        quantityText = new JTextField();
        quantityText.setBounds(170, 30, 250, 30);


        panelBottom.setLayout(null);
        panelBottom.add(IDPanel);
        panelBottom.add(namePanel);
        panelBottom.add(pricePanel);
        panelBottom.add(categoryPanel);
        panelBottom.add(sizePanel);
        panelBottom.add(quantityPanel);
        panelBottom.add(listPanel);

        IDPanel.add(IDLabel);
        IDPanel.add(IDText);
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        pricePanel.add(priceLabel);
        pricePanel.add(priceText);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryText);
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeBox);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantityText);
        listPanel.add(addButton);
        listPanel.add(editButton);
        listPanel.add(deleteButton);
        listPanel.add(retrieveButton);
        listPanel.add(cancelButton);

        tableModel = new DefaultTableModel();
        headerTable();
        productTable = new JTable(tableModel);
        setTableValues();
        productTable.setBounds(0, 0, 220, 300);
        productTable.setBackground(new Color(238, 225, 153));
        JScrollPane sp = new JScrollPane(productTable);



        searchLabel = new JLabel("Enter name of gun:");
        searchLabel.setFont(new Font("Abercrombie & Fitch", Font.PLAIN, 18));
        searchLabel.setBounds(70, 30, 200, 30);
        searchText = new JTextField();
        searchText.setBounds(70, 70, 290, 30);

        searchButton = new JButton("Search");
        searchButton.setBounds(650, 70, 80, 30);
        searchButton.addActionListener(controller);

        returnButton = new JButton("Return");
        returnButton.setBounds(750, 70, 80, 30);
        returnButton.addActionListener(controller);

        orderLabel = new JLabel("Order by:");
        orderLabel.setBounds(430, 30, 80, 30);
        orderLabel.setFont(new Font("Abercrombie & Fitch", Font.PLAIN, 18));
        String[] order = {" ", "Price increase", "Price decrease"};
        orderBox = new JComboBox(order);
        orderBox.setBounds(430, 70, 140, 30);

        panelTop.add(searchLabel);
        panelTop.add(searchText);
        panelTop.add(searchButton);
        panelTop.add(returnButton);
        panelTop.add(orderLabel);
        panelTop.add(orderBox);
        panelMid.add(sp);
        this.add(panelHeader);
        this.add(panelBottom);

    }

    public void headerTable() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Price");
        tableModel.addColumn("Category");
        tableModel.addColumn("Size");
    }

    public Product getValuesFromForm() {
        int ID = Integer.parseInt(IDText.getText());
        String name = nameText.getText();
        String price = priceText.getText();
        String quantity = quantityText.getText();
        String category = categoryText.getText();
        String size = (String) sizeBox.getSelectedItem();
        return new Product(ID, name, quantity, price, category, size);
    }

    public void setTableValues() {
        Object[] data = new Object[6];
        tableModel.setRowCount(0);
        for (Product product : products) {
            data[0] = product.ID;
            data[1] = product.nameProduct;
            data[2] = product.quantity;
            data[3] = product.price;
            data[4] = product.category;
            data[5] = product.sizeProduct;
            tableModel.addRow(data);
        }
    }

    public void setEmptyText() {
        nameText.setText("");
        priceText.setText("");
        quantityText.setText("");
        categoryText.setText("");
        sizeBox.setSelectedIndex(-1);
    }
    public void deleteProduct() {
        int row = productTable.getSelectedRow();
        if (row != -1) {
            int choice = JOptionPane.showConfirmDialog(this, "Would you like to remove this product?");
            if (choice == JOptionPane.YES_OPTION) {
                this.products.remove(products.get(row));
                Model.addProductToFIle();
                tableModel.removeRow(row);
            }
        }
        else {
           throw new IndexOutOfBoundsException();
        }
    }

    public void retrieveProduct() {
        int row = productTable.getSelectedRow();
        IDText.setText(tableModel.getValueAt(row, 0) + "");
        nameText.setText(tableModel.getValueAt(row, 1) + "");
        quantityText.setText(tableModel.getValueAt(row, 2) + "");
        priceText.setText(tableModel.getValueAt(row, 3) + "");
        categoryText.setText(tableModel.getValueAt(row, 4) + "");
        sizeBox.setSelectedItem(tableModel.getValueAt(row, 5).toString());
    }

    public void search() {
        Object[] data = new Object[6];
        tableModel.setRowCount(0);
        String search = this.searchText.getText();
        ArrayList<Product> searchProduct;
        ArrayList<Product> searchProduct2 = new ArrayList<>();
        if (orderBox.getSelectedItem() == "Price increase") {
            searchProduct = increasePrice();
        } else if (orderBox.getSelectedItem() == "Price decrease") {
            searchProduct = decreasePrice();
        } else {
            searchProduct = new ArrayList<>(products);
        }
        for (Product product : searchProduct) {
            if (product.nameProduct.contains(search)) {
                searchProduct2.add(product);
            }
        }
        for (Product product2 : searchProduct2) {
            data[0] = product2.ID;
            data[1] = product2.nameProduct;
            data[2] = product2.quantity;
            data[3] = product2.price;
            data[4] = product2.category;
            data[5] = product2.sizeProduct;
            tableModel.addRow(data);
        }
    }

    public static ArrayList<Product> increasePrice() {
        ArrayList<Product> increaseProduct = new ArrayList<>();
        increaseProduct.addAll(products);
        Product swapProduct;
        for (int i = 0; i < increaseProduct.size() - 1; i++) {
            for (int j = i + 1; j < increaseProduct.size(); j++) {
                if (Integer.parseInt(increaseProduct.get(j).price) < Integer.parseInt(increaseProduct.get(i).price)) {
                    swapProduct = increaseProduct.get(j);
                    increaseProduct.set(j, increaseProduct.get(i));
                    increaseProduct.set(i, swapProduct);
                }
            }
        }
        return increaseProduct;
    }

    public ArrayList<Product> decreasePrice() {
        ArrayList<Product> decreaseProduct = new ArrayList<>();
        decreaseProduct.addAll(products);
        Product swapProduct;
        for (int i = 0; i < decreaseProduct.size() - 1; i++) {
            for (int j = i + 1; j < decreaseProduct.size(); j++) {
                if (Integer.parseInt(decreaseProduct.get(j).price) > Integer.parseInt(decreaseProduct.get(i).price)) {
                    swapProduct = decreaseProduct.get(j);
                    decreaseProduct.set(j, decreaseProduct.get(i));
                    decreaseProduct.set(i, swapProduct);
                }
            }
        }
        return decreaseProduct;
    }

    public void setID() {
        try {
            id = (products.get(products.size() - 1).ID + 1);
            this.IDText.setText(String.valueOf(id));
        } catch (IndexOutOfBoundsException e) {
            this.IDText.setText(String.valueOf(id));
        }
    }

    public void checkID(int ID) {
        for (int i = 0; i < products.size(); ) {
            if (ID == products.get(i).ID) {
                counter = i;
                break;
            }
            i++;
        }
    }

    public void setUnEnable() {
        addButton.setEnabled(false);
        retrieveButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    public void setEnable() {
        addButton.setEnabled(true);
        retrieveButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    public Boolean isNull() {
        return nameText.getText().equals("") || quantityText.getText().equals("") || priceText.getText().equals("")
                || categoryText.getText().equals("") || sizeBox.getSelectedIndex() == 0;
    }

    public static boolean isCharacter(String fieldText) {
        String str = fieldText.toLowerCase();
        str = str.replaceAll(" ","");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }
    public static boolean isNumber(String fieldText) {
        for (int i = 0; i < fieldText.length(); i++) {
            if (fieldText.charAt(i) <'0' || fieldText.charAt(i) >'9') {
                return false;
            }
        }
        return true;
    }
    public static boolean checkExist(int id){
        for(Product product:products){
            if(product.ID==id){
                return true;
            }
        }
        return false;
    }

    public Model getModel() {
        return model;
    }
}