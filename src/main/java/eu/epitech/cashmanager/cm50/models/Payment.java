package eu.epitech.cashmanager.cm50.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {


    private long id;
    private enum type{};
    private type paymentType;
    private float total;
    private String status;
    private Date date;

    public Payment() { }

    public Payment(type t, float total, String status, Date date)
    {
        paymentType = t;
        this.total = total;
        this.status = status;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId() { this.id = id; }

    public type getType() { return paymentType; }
    @Column(name = "type", nullable = false)
    public void setType(type input) { paymentType = input; }

    public float getTotal() { return total; }
    @Column(name = "total", nullable = false)
    public void setTotal(float total) { this.total = total; }

    public String getStatus() { return status; }
    @Column(name = "status", nullable = false)
    public void setStatus(String status) { this.status = status; }

    public Date getDate() { return date; }
    @Column(name = "date", nullable = false)
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString()
    {
        return "Payment [id=" + id + ", Type=" + paymentType + ", Total=" + total + ", Status=" + status +
                ", Date=" + date + "]";
    }

}
