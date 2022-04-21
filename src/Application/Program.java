package Application;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        int n;


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (ch == 'i'){
                System.out.print("Customs free: ");
                Double customsFree = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFree);
                list.add(product);
            }
            if (ch == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                Product product = new UsedProduct(name, price, manufactureDate);
                list.add(product);
            }
            if (ch == 'c'){
                Product product = new Product(name, price);
                list.add(product);
            }

        }
        System.out.println("PRICE TAGS:");
        for (Product product : list){
            System.out.println(product.priceTag());
        }
    }
}
