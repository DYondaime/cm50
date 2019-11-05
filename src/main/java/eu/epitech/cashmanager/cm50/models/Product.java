package eu.epitech.cashmanager.cm50.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Product")
public class Product {

    private long id;
    private String name;
    private long barcode;
    private float price;
    private int quantity;
    private enum category{};
    private category categoryType;

    public Product() { }

    public Product(String n, long bcode, float p, int q, category c)
    {
        name = n;
        barcode = bcode;
        price = p;
        quantity = q;
        categoryType = c;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    @Column(name = "productname", nullable = false)
    public void setName(String name) { this.name = name; }

    public long getBarcode() { return barcode; }
    @Column(name = "barcode", nullable = false)
    public void setBarcode(long barcode) { this.barcode = barcode; }

    public float getPrice() { return price; }
    @Column(name = "price", nullable = false)
    public void setPrice(float price) { this.price = price; }

    public int getQuantity() { return quantity; }
    @Column(name = "quantity", nullable = false)
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public category getCategory() { return categoryType; }
    @Column(name = "category", nullable = false)
    public void setCategory(category input) { categoryType = input; }

    @Override
    public String toString()
    {
        return "Product [id=" + id + ", Productname=" + name + ", Barcode=" + barcode + ", Price=" + price +
                ", Quantity=" + quantity + ", Category=" + categoryType + "]";
    }
}
