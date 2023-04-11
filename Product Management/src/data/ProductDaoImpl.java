package data;

import Tools.MyTool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author thien
 */
public class ProductDaoImpl implements ProductDao {

    private ArrayList<Product> proList;
    boolean changed = false;

    public ProductDaoImpl(String path) throws FileNotFoundException, IOException {
        proList = getAllProduct(path);
    }

    @Override
    public ArrayList<Product> getAllProduct(String filename) {//name,price,quantity,status
        String thisLine;
        Product pro = null;
        try {
            BufferedReader myInput = null;
            File f = new File(filename);
            String fullPath = f.getAbsolutePath();
            FileReader file = new FileReader(fullPath);
            myInput = new BufferedReader(file);
            while ((thisLine = myInput.readLine()) != null) {
                thisLine.trim();
                if (!thisLine.isEmpty()) {
                    String[] split = thisLine.split(",");
                    if (proList == null) {
                        proList = new ArrayList<>();
                    }
                    pro = new Product(split[0], split[1], Double.parseDouble(split[2]), Integer.parseInt(split[3]), split[4]);
                    proList.add(pro);
                }
            }
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return proList;
        }

    }

    @Override
    public int searchProduct(String nameProduct) {
        nameProduct = nameProduct.replaceAll(" ", "");
        try {
            int N = proList.size();
            for (int i = 0; i < N; i++) {
                if (proList.get(i).getProductName().equalsIgnoreCase(nameProduct)) {
                    return i;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public void searchProduct() {
        System.out.print("Input product's name: ");
        String id = MyTool.SC.nextLine();
        int pos = searchProduct(id);
        if (pos < 0) {
            System.out.println("Not Product Found!");
        } else {
            System.out.println(" Exist Product.");
            MyTool.printObject(proList.get(pos));
        }
    }

    @Override
    public int searchProductID(String IDProduct) {
        try {
            int N = proList.size();
            for (int i = 0; i < N; i++) {
                if (proList.get(i).getId().equalsIgnoreCase(IDProduct)) {
                    return i;
                }
            }

        } catch (Exception e) {
            System.out.println("Does not exist " + IDProduct + " in product list.");
        }
        return -1;
    }

    @Override
    public void addProduct() {
        String name;
        String price = "0.0";
        String quantity = "0";
        String status;
        boolean statusAN;
        String id;
        int pos;
        
         
         do{
              id=MyTool.readPattern("Enter ID's product: ", Product.ID_FORMAT);
             pos = searchProductID(id);
            if (pos >= 0) {//5
                System.out.println("ID is duplicated");
            }
         }while(pos>=0);//5
        
         name=MyTool.readPattern("Enter name's Product: ", Product.PRODUCT_FORMAT);
        do {
            price = MyTool.readNonBlank("Enter product's price: ");
            if (!MyTool.isDouble(price) || (Double.parseDouble(price) < 0 || Double.parseDouble(price) > 10000)) {
                System.out.println("-----Enter double number(0 to 10000) only-----");
            } else if (Double.parseDouble(price) > 0 && Double.parseDouble(price) <= 10000) {
                break;
            }
        } while (true);
        quantity = MyTool.readPattern("ENTER product's quantity(Integer number): ", Product.QUANTITY_FORMAT);

        do {
            statusAN = MyTool.readBoolStatus("Enter product's status(Available or Not Available):");
            if(statusAN){
                status = "Available";
            }else{
                status = "Not Available";
            }
//            status = MyTool.readNonBlank("Enter product's status(Available or Not Available): ");
            //sua parrsebool thêm phần đọc chữ A là true và chữ N là not
        } while (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Not Available"));
        //id = proList.size() + 1;
        Product e = new Product(id, name, Double.parseDouble(price), Integer.parseInt(quantity), status);
        proList.add(e);
        System.out.println("New dealer has been added");
        changed = true;
    }

    @Override
    public ArrayList<Product> SearchByName(String product) {
        if (proList == null) {
            return null;
        }
        ArrayList<Product> byName = new ArrayList<>();
        try {

            for (Product p1 : proList) {
                if (p1.getProductName().toLowerCase().contains(product.toLowerCase())) {
                    byName.add(p1);
                }

            }
            if (byName.isEmpty()) {
                System.out.println("Have no any Product");
            } else {
                System.out.println("List " + product + " is: ");
            }
        } catch (Exception e) {
            System.out.println("Have no any Product" );
        }
        return byName;
    }

    @Override
    public void updateProduct() {
        printAllProduct();
        System.out.println("");
        String id;
        System.out.println("Enter product's id: ");
        id = MyTool.SC.nextLine();
        int pos = searchProductID(id);
        if (pos < 0) {
            System.out.println(id+" does not exist");
        } else {
            Product p = proList.get(pos);
            String newName = "";
            System.out.print("new name, ENTER for omitting: ");
            newName = MyTool.readPatternSpace("Product's name: ", Product.PRODUCT_FORMAT);
            if (!newName.isEmpty()) {
                p.setProductName(newName);
                changed = true;
            }
            String price = "";
            do {
                System.out.println("Enter NEW product's price: ");
            price = MyTool.SC.nextLine();
            if(price.isEmpty()) break;
            if (!MyTool.isDouble(price) || (Double.parseDouble(price) < 0 || Double.parseDouble(price) > 10000)) {
                System.out.println("-----Enter double number(0 to 10000) only-----");
            } else if (Double.parseDouble(price) > 0 && Double.parseDouble(price) <= 10000) {
                break;
            }
        } while (true);
            if (!price.isEmpty()) {
                p.setUnitPrice(Double.parseDouble(price));
                changed = true;
            }
            String newQua = "";
            newQua = MyTool.readPatternSpace("ENTER product's quantity(Integer number): ", Product.QUANTITY_FORMAT);
            if (!newQua.isEmpty()) {
                p.setQuantity(Integer.parseInt(newQua));
                changed = true;
            }//
            String newSta = "";
            boolean statusAN;
            System.out.print("");
            statusAN = MyTool.readBoolStatus("new status, ENTER for omitting: (Available or Not Available):");
            if(statusAN){
                newSta = "Available";
            }else{
                newSta = "Not Available";
            }
            if (!newSta.isEmpty()) {
                p.setStatus(newSta);
                changed = true;
            }//

            System.out.println("Changed.");

        }
    }

    @Override
    public void deleteProduct() {
        printAllProduct();
        System.out.println("");
        System.out.print("ENTER product's ID to remove: ");
        String ID = MyTool.SC.nextLine();
        int pos = searchProductID(ID);
        if (pos < 0) {
            System.out.println(ID+" does not exist");
        } else {
            proList.get(pos).setStatus("Not Available");
            System.out.println("-----Removed-----");
            changed = true;
        }
    }

    @Override
    public void printAllProduct() {
        if (proList.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            MyTool.printAllProduct(proList);
        }
    }

    @Override
    public void saveToFile(String filename, List list) {
        if (changed == true) {
            try {
                if (list.isEmpty()) {
                    System.out.println("EMPTY LIST.");
                } else {
                    File f = new File(filename);
                    if (f.exists()) {
                        f.delete();
                    }
                    RandomAccessFile rf = new RandomAccessFile(f, "rw");
                    for (Object object : list) {
                        rf.writeBytes(object.toString() + "\r\n");
                    }
                    rf.close();

                    System.out.println("-----Successfully wrote to the file-----");
                }
                changed = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public ArrayList<Product> printAllList() {
        if (proList == null) {
            return null;
        }
        ArrayList<Product> sortList = null;
        sortList = (ArrayList<Product>) proList.clone();
        Comparator com = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if(p1.getQuantity()==p2.getQuantity()){
                    return (int) p1.getUnitPrice()- (int) p2.getUnitPrice();
                }else{
                  return  p2.getQuantity()- p1.getQuantity();
                }

            }

        };
        sortList.sort(com);
        return sortList;
    }

    @Override
    public int CreateLayout(String[] options, String title) {
        ArrayList<String> opList = new ArrayList<>();
        String s = "0";
        String[] optionTemp = {"Update product information",
            "Delet Product information"};
        for (String item : options) {
            opList.add(item);
        }

        do {
            if (MyTool.isInteger(s) == false) {
                System.out.println("");
                System.out.println("------Please, ENTER only numuber------");
                System.out.println("");
            }
            int sizeArr = opList.size();
            System.out.println(title);
            for (int i = 0; i < sizeArr; i++) {
                System.out.println((i + 1) + "-" + opList.get(i));
                if (opList.get(i).equalsIgnoreCase("Update Product")) {
                    for (int k = 0; k < optionTemp.length; k++) {
                        System.out.println("  " + (i + 1) + "." + (k + 1) + "-" + optionTemp[k]);
                    }
                }
            }
            System.out.println("Other for quit");
            System.out.print("Choose[1.." + sizeArr + "]: ");
            s = MyTool.SC.nextLine();
        } while (MyTool.isInteger(s) == false);
        return Integer.parseInt(s);

    }

    public ArrayList<Product> getProList() {
        return proList;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

}
