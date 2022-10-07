package lundegaard.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @Column(name="policyNumber")
    private String policyNumber;

    @Column(name="type")
    private String type;

    @Column(name="firstName")
    private String firstName;

    @Column(name="surname")
    private String surname;

    @Column(name="text")
    private String text;

    public Request(String policyNumber, String type, String firstName, String surname, String text) {
        this.policyNumber = policyNumber;
        this.type = type;
        this.firstName = firstName;
        this.surname = surname;
        this.text = text;
    }

    public Request() {
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}