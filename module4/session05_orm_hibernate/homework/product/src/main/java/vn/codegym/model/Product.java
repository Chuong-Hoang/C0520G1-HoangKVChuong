package vn.codegym.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;  //id

    @Column(name = "product_name")
    private String  productName;   //a

    @Column(name = "product_price")
    private String productPrice;  //b

    @Column(name = "product_quantity")
    private String productQuantity; //c

    @Column(name = "product_color")
    private String  productColor; //d

    @Column(name = "product_description")
     private String  productDescription; //e

    @Column(name = "product_category")
    private String productCategory;	 //f

    public Product() {
    }

    public Product(String productName, String productPrice, String productQuantity,
                   String productColor, String productDescription, String productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    public Product(String productId, String productName, String productPrice, String productQuantity,
                   String productColor, String productDescription, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
