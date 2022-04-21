package Entities;

import java.text.ParseException;

public class ImportedProduct extends Product{

    private Double customsFree;

    public ImportedProduct(){

    }

    public ImportedProduct(Double customsFree) {
        this.customsFree = customsFree;
    }

    public ImportedProduct(String name, Double price, Double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public Double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(Double customsFree) {
        this.customsFree = customsFree;
    }

    @Override
    public String priceTag() throws ParseException {
        return super.getName() + " $ " + totalPrice() + " (Customs free: $ " + String.format("%.2f", getCustomsFree()) + ")";
    }
    public Double totalPrice(){
       return getPrice() + getCustomsFree();
    }
}
