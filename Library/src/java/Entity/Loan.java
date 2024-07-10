/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.persistence.*;
import org.hibernate.Session;

/**
 *
 * @author The user
 */
@Entity
public class Loan {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String loanMonth;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    boolean activeLoan = true;

    public boolean isActiveLoan() {
        return activeLoan;
    }

    public void setActiveLoan(boolean activeLoan) {
        this.activeLoan = activeLoan;
    }

    public int getId() {
        return id;
    }

    public String getLoanMonth() {
        return loanMonth;
    }

    public void setLoanMonth(String loanMonth) {
        this.loanMonth = loanMonth;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Loan() {
    }

    public Loan(String loanMonth, Customer customer) {
        this.loanMonth = loanMonth;
        this.customer = customer;
    }

 
}
