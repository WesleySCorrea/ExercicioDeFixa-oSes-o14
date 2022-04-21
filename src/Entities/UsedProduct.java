package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{

    private String manufactureDate;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct(){

    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = sdf.format(manufactureDate);
    }

    public Date getManufactureDate() throws ParseException {
        return sdf.parse(manufactureDate);
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = sdf.format(manufactureDate);
    }

    @Override
    public String priceTag() throws ParseException {
        return super.priceTag() + " (Manufacture date: " +  sdf.format(getManufactureDate()) + ")";
    }
}
