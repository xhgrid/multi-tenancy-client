package com.zamacloud.multitenancyclient;

import com.zamacloud.commons.multitenancy.tenant.TenantDetails;
import com.zamacloud.commons.multitenancy.tenant.TenantIdentifiable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Fact S Musingarimi
 * 4/27/19
 * 3:43 AM
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable, TenantIdentifiable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @NotNull
    private Double amount;
    @Embedded
    private Tenant tenant;

    public Order() {
        this.orderDate=new Date();
    }

    private Order(Double amount) {
        this();
        this.amount = amount;
    }

    public static Order of(Double amount) {
        return new Order(amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(TenantDetails tenant) {
        this.tenant = (Tenant) tenant;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                '}';
    }
}
