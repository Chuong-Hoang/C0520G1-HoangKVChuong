package examination;

public class ImportProduct extends Product {
    private String importPrice;
    private String importProvince;
    private String importTax;

    public ImportProduct() {
        super();
    }

    public ImportProduct(String importPrice, String importProvince, String importTax) {
        this();
        this.importPrice = importPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public ImportProduct(String code, String name, String price, String quantity, String provider,
                        String importPrice, String importProvince, String importTax) {
        super(code, name, price, quantity, provider);
        this.importPrice = importPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public String getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(String importPrice) {
        this.importPrice = importPrice;
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

    @Override
    public String toString() {
        return super.toString() +
                ", Import_Price = " + importPrice +
                ", Import_Province = '" + importProvince + '\'' +
                ", Import_Tax = " + importTax;
    }
}
