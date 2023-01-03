public class Main {
    public static void main(String[] args) {
        Model.readProductFromFile();
        View myView = new View();
        myView.setTableValues();
    }
}
