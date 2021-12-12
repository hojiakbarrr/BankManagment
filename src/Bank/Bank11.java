package Bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank11 implements Serializable {
    String bankName ;
    private List<User> customer;
    private List<Account> accounts;
    private List<Transaction>transactions;
    static List<Integer> ids = new ArrayList<>();

    public Bank11(String bankName, List<User> customer, List<Account> accounts,List<Transaction>transactions) {
        this.bankName = bankName;
        this.customer = customer;
        this.accounts = accounts;
    }

    ////////////////////////////////////////////////////////////////////////проверка уни кода
    public static int genUniqueId() {
        int id;
        while (true) {
            id = (int) (Math.random() * 899) + 100000;
            if (checkForDuplicates(id)) {
                ids.add(id);
                break;
            }
        }
        return id;
    }

    ///////////////////////////////////проверка кода
    private static boolean checkForDuplicates(int id) {
        for (int i : ids) {
            if (i == id) {
                return false;
            }
        }
        return true;


    }

    public String getBankName() {
        return bankName;
    }

    public List<User> getCustomer() {
        return customer;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public static List<Integer> getIds() {
        return ids;
    }
}
