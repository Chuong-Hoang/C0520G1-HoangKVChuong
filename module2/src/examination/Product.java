package examination;

public abstract class Product {
    private int id = 0;
    private String code;
    private String name;
    private String price;
    private String quantity;
    private String provider;

    public Product() {
    }

    public Product(String code, String name, String price, String quantity, String provider) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return  "Id = " + this.getId() +
                ", Code = '" + code + '\'' +
                ", Name = '" + name + '\'' +
                ", Price = " + price +
                ", Quantity = " + quantity +
                ", Provider = '" + provider + '\'';
    }
}

