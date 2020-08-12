package examination;

public class ExportProduct extends Product {
    private String exportPrice;
    private String buyingCountry;

    public ExportProduct() {
        super();
    }

    public ExportProduct(String exportPrice, String buyingCountry) {
        this();
        this.exportPrice = exportPrice;
        this.buyingCountry = buyingCountry;
    }

    public ExportProduct(String code, String name, String price, String quantity, String provider,
                         String exportPrice, String buyingCountry) {
        super(code, name, price, quantity, provider);
        this.exportPrice = exportPrice;
        this.buyingCountry = buyingCountry;
    }

    public String getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(String exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getBuyingCountry() {
        return buyingCountry;
    }

    public void setBuyingCountry(String buyingCountry) {
        this.buyingCountry = buyingCountry;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", Export_Price = " + exportPrice +
                ", Buying_Country = '" + buyingCountry + '\'';
    }
}
