package main.model.product_model;

public class ExProduct extends Product {
    private String exportedPrice; //i
    private String buyingCountry; //j

    public ExProduct() {
    }

    public ExProduct(String id, String productCode, String productName, String productPrice,
                     String productQuantity, String productProducer, String exportedPrice, String buyingCountry) {
        super(id, productCode, productName, productPrice, productQuantity, productProducer);
        this.exportedPrice = exportedPrice;
        this.buyingCountry = buyingCountry;
    }

    public String getExportedPrice() {
        return exportedPrice;
    }

    public void setExportedPrice(String exportedPrice) {
        this.exportedPrice = exportedPrice;
    }

    public String getBuyingCountry() {
        return buyingCountry;
    }

    public void setBuyingCountry(String buyingCountry) {
        this.buyingCountry = buyingCountry;
    }
}
