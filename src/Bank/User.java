package Bank;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {


    private int id;
    private String FirstName;
    private String LastName;
    private String login;
    private String parol;
    private List<Account> accountList;
    private int personNumber;

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getLogin() {
        return login;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getParol() {
        return parol;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public User(String firstName, String lastName, String login, String parol, List<Account> accountList) {
        this.id = Bank11.genUniqueId();
        FirstName = firstName;
        LastName = lastName;
        this.login = login;
        this.parol = parol;
        this.accountList = accountList;
        this.personNumber = personNumber;
    }
}