package Bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {

    private int id;
    private double balance;
    private String name;
    private User acaounholder;
    public static List<Transaction> transactions = new ArrayList<>();

    public Account(double balance, String name, User acaounhold) {
        this.id = Bank11.genUniqueId();
        this.balance = balance;
        this.name = name;
        this.acaounholder = acaounhold;
    }

    public static void getinfo() {
        System.out.println(" | Имя --> " + Mainbank.logged.getFirstName()
                + "\n" + " | Фамилия --> " + Mainbank.logged.getLastName()
                + "\n" + " | Логин --> " + Mainbank.logged.getLogin()
                + "\n" + " | ID --> " + Mainbank.logged.getId()
                + "\n" + " | Баланс в сомах --> " + Mainbank.logged.getAccountList().get(0).getBalance()
                + "\n" + " | Баланс в долларах --> " + Mainbank.logged.getAccountList().get(1).getBalance());

        Vernuty();

//        while (true) {
//            System.out.println("Вернутьс в главное меню нажмите --> 1");
//            System.out.println("Завершить процесс --> 3");
//            try {
//                int x = Integer.parseInt(Mainbank.scanner.nextLine());
//                switch (x) {
//                    case 1:
//                        Mainbank.mainMenu();
//                        break;
//                    case 3:
//                        Mainbank.Vyhod();
//                        break;
//                }
//            } catch (Exception e) {
//                System.out.println("Не правильный формат ввода");
//            }
//        }


    }

    public static void Vernuty(){
        while (true) {
            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            System.out.println("Вернутьс в главное меню нажмите --> 1");
            System.out.println("Завершить процесс --> 3");
            try {
                int x = Integer.parseInt(Mainbank.scanner.nextLine());
                switch (x) {
                    case 1:
                        Mainbank.mainMenu();
                        break;
                    case 3:
                        Mainbank.Vyhod();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Не правильный формат ввода");
            }
        }
    }

    public static void СhangeProfile() {

        boolean temp = true;


        while (temp) {
            System.out.println("Выберите что хотя ли бы поменять");
            System.out.println("1. Изменить имя");
            System.out.println("2. Изменить фамилию");
            System.out.println("3. Изменить логин");
            System.out.println("4. Изменить пароль");

            try {
                int x = Integer.parseInt(Mainbank.scanner.nextLine());
                switch (x) {
                    case 1:
                        System.out.println("Введите свое новое имя");
                        String name = Mainbank.scanner.nextLine();
                        Mainbank.logged.setFirstName(name);
                        System.out.println("Изменения сохранены, ваше новое имя --> " + Mainbank.logged.getFirstName());
                        Vernuty();
                        temp = false;
                    case 2:
                        System.out.println("Введите свою новую фамилию");
                        String Fio = Mainbank.scanner.nextLine();
                        Mainbank.logged.setLastName(Fio);
                        System.out.println("Изменения сохранены, ваша новая фамилия --> " + Mainbank.logged.getLastName());
                        Vernuty();
                        temp = false;
                    case 3:
                        System.out.println("Введите свой новый логин");
                        String log = Mainbank.scanner.nextLine();
                        Mainbank.logged.setLogin(log);
                        System.out.println("Изменения сохранены, ваш новый логин --> " +Mainbank.logged.getLogin());
                        Vernuty();
                        temp = false;
                    case 4:
                        System.out.println("Введите свой новый пароль");
                        String par = Mainbank.scanner.nextLine();
                        Mainbank.logged.setParol(par);
                        System.out.println("Изменения сохранены, ваше новый пароль --> "+ Mainbank.logged.getParol());
                        Vernuty();
                        temp = false;
                }
            } catch (NumberFormatException exception) {
                System.out.println("*-*-*-*-*-!!!-*-*-*-*-*");
            }
//            if (temp) {
//                System.out.println("Введите правильно");
//            }
        }

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public User getAcaounholder() {
        return acaounholder;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions(Transaction transactions) {
        this.transactions.add(transactions);
    }
}
