package org.lendi.umtapo.entity;

import org.lendi.umtapo.enumeration.Condition;

import javax.persistence.*;
import java.util.List;

/**
 * Item entity.
 *
 * Created by axel on 29/11/16.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private String internalId;
    private Integer purchasePrice;
    private Boolean loanable;
    @OneToMany(mappedBy = "item")
    private List<Loan> loan;
    @Enumerated(EnumType.STRING)
    private Condition condition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<Loan> getLoan() {
        return loan;
    }

    public void setLoan(List<Loan> loan) {
        this.loan = loan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Boolean getLoanable() {
        return loanable;
    }

    public void setLoanable(Boolean loanable) {
        this.loanable = loanable;
    }
}
