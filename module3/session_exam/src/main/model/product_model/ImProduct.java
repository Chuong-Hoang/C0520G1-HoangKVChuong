package main.model.product_model;

public class ImProduct extends Product {
    private String importedPrice;
    private String importProvince;
    private String importTax;

    public ImProduct() {
    }

    public ImProduct(String id, String productCode, String productName, String productPrice,
                     String productQuantity, String productProducer,
                     String importedPrice, String importProvince, String importTax) {
        super(id, productCode, productName, productPrice, productQuantity, productProducer);
        this.importedPrice = importedPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public String getImportedPrice() {
        return importedPrice;
    }

    public void setImportedPrice(String importedPrice) {
        this.importedPrice = importedPrice;
    }

    public String getImportProvince() {
        return importProvince;
    }

    public void setImportProvince(String importProvince) {
        this.importProvince = importProvince;
    }

    public String getImportTax() {
        return importTax;
    }

    public void setImportTax(String importTax) {
        this.importTax = importTax;
    }
}
