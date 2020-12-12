package com.example.dbmsSpring.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class customerEmbed implements Serializable {
    private String customerEmail;

    public customerEmbed(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
