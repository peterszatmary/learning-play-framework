package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by nue on 1.9.2015.
 */
@Embeddable
public class UserContact {

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserContact{" +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
