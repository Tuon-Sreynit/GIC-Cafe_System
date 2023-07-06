package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Long invoiceId;

    private Double cash_received;

    private Double cash_change;

    @CreationTimestamp
    private LocalDateTime created_at;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCash_received() {
        return this.cash_received;
    }

    public void setCash_received(Double cash_received) {
        this.cash_received = cash_received;
    }

    public Double getCash_change() {
        return this.cash_change;
    }

    public void setCash_change(Double cash_change) {
        this.cash_change = cash_change;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Long getInvoiceId() {
        return this.invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

}
