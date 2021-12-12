package Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainbank {
    static Scanner scanner;
    static Bank11 bank11;
    public static User logged;
    public static Account logg;

    public static void main(String[] args) {


        ArrayList<User> usersss = new ArrayList<>();
////////////////////////////////////
        ArrayList<Account> accountsss = new ArrayList<>();
////////////////////////////////////
        ArrayList<Transaction> transactions = new ArrayList<>();
//////////////////////////////////////
///////////////////////////////
 List<Account> sagynAccounts = new ArrayList<>();

        User sagyn = new User("Сагынбек","Кенжебаев", "s","s",sagynAccounts);

        Account kgzSagyn = new Account(25670,"KGZ",sagyn);
        Account usdSagyn = new Account(3450,"USD",sagyn);

        sagynAccounts.add(kgzSagyn);
        sagynAccounts.add(usdSagyn);

        accountsss.addAll(sagynAccounts);
        usersss.add(sagyn);
/////////////////////////////////////////////
        List<Account> bekAccounts = new ArrayList<>();

        User beksultan = new User("Бексултан","Ибадуллаев","b","b",bekAccounts);

        Account kgzBek = new Account(2110,"KGZ",beksultan);
        Account usdBek = new Account(3220,"USD",beksultan);

        bekAccounts.add(kgzBek);
        bekAccounts.add(usdBek);

        accountsss.addAll(bekAccounts);
        usersss.add(beksultan);
//////////////////////////////////////////////////////
        List<Account> ruslanAccounts = new ArrayList<>();

        User ruslan = new User("Руслан","Тухватшин","r","r",ruslanAccounts);

        Account kgzRus = new Account(1200,"KGZ",ruslan);
        Account usdRus = new Account(23000,"USD",ruslan);

        ruslanAccounts.add(kgzRus);
        ruslanAccounts.add(usdRus);

        accountsss.addAll(ruslanAccounts);
        usersss.add(ruslan);
///////////////////////////////////////
        List<Account> dastanAccounts = new ArrayList<>();

        User dastan = new User("Дастан","Алмазбек","d","d",dastanAccounts);

        Account kgzDos = new Account(21000,"KGZ",dastan);
        Account usdDos = new Account(2658,"USD",dastan);

        dastanAccounts.add(kgzDos);
        dastanAccounts.add(usdDos);

        accountsss.addAll(dastanAccounts);
        usersss.add(dastan);
/*/*************************////////////////////

        bank11 = new Bank11("Quick pay",usersss,accountsss,transactions);
        scanner = new Scanner(System.in);


        File();
        parol();

    }

    public static void File(){
        try {
            ObjectInputStream banking = new ObjectInputStream(new FileInputStream("banking"));
            bank11 = (Bank11) banking.readObject();
            banking.close();
        } catch (ClassNotFoundException e) {
            System.out.println("База данных повреждена или не найдена");
        } catch (FileNotFoundException e) {
            System.out.println("База данных   1222 2");
        } catch (IOException e) {
            System.out.println("База данных   1 2");
        }
    }

    public static void parol() {
        int count = 0;
        boolean temp = true;

        System.out.println("----------------------------Войти в личный кабинет-------------------------------------------" + "\n");

        while (temp) {
            count++;

            System.out.println("-------Ваш логин------");
            String login = scanner.nextLine();

            System.out.println("-------Введите ваш пароль-------");
            String pfrol = scanner.nextLine();
            for (int i = 0; i < bank11.getCustomer().size(); i++) {
                if (bank11.getCustomer().get(i).getLogin().equals(login) && bank11.getCustomer().get(i).getParol().equals(pfrol)) {
//                    for (Account ac:bank11.getCustomer().get(i).getAccountList()) {
//                        System.out.println(ac.getBalance());
//                    }
                    logged = bank11.getCustomer().get(i);
                    logg = bank11.getAccounts().get(i);
                    temp = false;
                    mainMenu();
                }

            } if (count >= 3) {
                System.out.println("----Обратись к администраору----"
                        + "\n" + "----попыток войти в систему :" + count);
                temp = false;
            }
            if (temp) {
                int x = 3 - count;
                System.out.println("------------Ваши данные не правильные, повторите ввод----------------"
                        + "\n" + "---------------попыток осталось --> " + x + " <----------------");
            }
        }
    }


    public static void mainMenu() {
        System.out.println("_-_-_-_-_-_Что будем делать, " + logged.getFirstName()+"_-_-_-_-_-_");
//        System.out.println("***********************************");
        System.out.println();


        while (true) {

            System.out.println("1. Вывести всю информацию об аккаунте.");
            System.out.println("2. Пополнить счет.");
            System.out.println("3. Снять деньги со счета.");
            System.out.println("4. Сделать перевод."); //digit6
            System.out.println("5. История транцакций.");
            System.out.println("6. Изменить свой профиль.");
            System.out.println("7. Выход.");


            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 9 && choice > 0) {
                    switch (choice) {
                        case 1:
                            Account.getinfo();
                            break;
                        case 2:
                            Transaction.getPay();
                            break;
                        case 3:
                            Transaction.WithDrawMoney();
                            break;
                        case 4:
                            Transaction.TransferMoney();
                            break;
                        case 5:
                            Transaction.History();
                            break;
                        case 6:
                            Account.СhangeProfile();
                            break;
                        case 7:
                            Vyhod();
                            break;
                    }
                } else {
                    System.err.println("Введите правильное число!");
                    System.out.println();
                }
            } catch (Exception e) {
                System.err.println("Неверный формат ввода: "+e.getMessage());
                System.out.println();

            }
        }
    }

    public static void Vyhod() {
        System.out.println();
        System.out.println("-----> Изменения сохранены <-----");
        System.out.println("...............Bye.............");
        try {
            ObjectOutputStream rfr = new ObjectOutputStream(new FileOutputStream("banking"));

            rfr.writeObject(bank11);
            rfr.close();


        } catch (IOException e) {
            System.out.println("Данные не сохранились !!!");
        }

        System.exit(0);
    }
}