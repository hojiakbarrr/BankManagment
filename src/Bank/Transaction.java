package Bank;

import com.sun.tools.javac.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction implements Serializable {

    private static double sum;

    private double amount;
    private Date timestamp;
    private Account account;
    private String operation;
//    private static List<Transaction> transactions = new ArrayList<>();

    public Transaction(double amount, Date timestamp, Account account, String operation) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.account = account;
        this.operation = operation;
    }

    public static void getPay() {

        while (true) {
            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            System.out.println("1. Пополнить счет в долларах");
            System.out.println("2. Пополнить счет в сомах");

            try {
                int x = Integer.parseInt(Mainbank.scanner.nextLine());
                switch (x) {

                    case 1:

                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Ваш долларовый счет на текущий момент _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(1).getBalance());
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Введите сумму на которую хотите пополнить");

                        while (true) {
                            try {
                                int ww = Integer.parseInt(Mainbank.scanner.nextLine());
                                Mainbank.logged.getAccountList().get(1).setBalance(Mainbank.logged.getAccountList().get(1).getBalance() + ww);
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                Transaction transaction = new Transaction(ww, new Date(), Mainbank.logged.getAccountList().get(1), "Пополнение");

                                Mainbank.logged.getAccountList().get(1).addTransactions(transaction);
                                System.out.println("Операция -(- пополнение счета -)- сохранена в истории транзакции");

                                break;
                            } catch (NumberFormatException exception) {
                                System.out.println("*-*-*-*-*--> ЦИФРЫ <--*-*-*-*-*");
                            }
                        }
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Ваш долларовый счет после пополнения _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(1).getBalance());
                        Account.Vernuty();
                        break;
                    case 2:

                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Ваш сомовый счет на текущий момент _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(0).getBalance());
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Введите сумму на которую хотите пополнить");
                        while (true) {

                            try {
                                int rr = Integer.parseInt(Mainbank.scanner.nextLine());
                                Mainbank.logged.getAccountList().get(0).setBalance(Mainbank.logged.getAccountList().get(0).getBalance() + rr);
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                Transaction transaction = new Transaction(rr, new Date(), Mainbank.logged.getAccountList().get(0), "Пополнение");

                                Mainbank.logged.getAccountList().get(0).addTransactions(transaction);
                                System.out.println("Операция -(- пополнение счета -)- сохранена в истории транзакции");
                                break;
                            } catch (NumberFormatException exception) {
                                System.out.println("*-*-*-*-*--> ЦИФРЫ <--*-*-*-*-*");
                            }

                        }
                        System.out.println("Ваш сомовый счет после пополнения _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(0).getBalance());
                        Account.Vernuty();
                        break;

                }

            } catch (NumberFormatException exception) {
                System.out.println("=-=-=-=-=-=-!!!-=-=-=-=-=-=-=");
            }
        }
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Account getAccount() {
        return account;
    }

    public static void WithDrawMoney() {


        while (true) {

            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            System.out.println("1. Снять сомы со счета");
            System.out.println("2. Снять доллары со счета");

            try {
                int x = Integer.parseInt(Mainbank.scanner.nextLine());
                switch (x) {
                    case 1:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Ваш сомовый счет на текущий момент _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(0).getBalance());
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Введите сумму которую хотите ВЗЯТЬ");

                        while (true) {
                            boolean tt = true;
                            try {
                                double ss = Integer.parseInt(Mainbank.scanner.nextLine());
                                sum = ss;
                                if (ss > Mainbank.logged.getAccountList().get(0).getBalance()) {
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("*-*-*-*-*--> Введите доступную сумму <--*-*-*-*-*");
                                } else {
                                    Mainbank.logged.getAccountList().get(0).setBalance(Mainbank.logged.getAccountList().get(0).getBalance() - ss);
                                    Transaction transaction = new Transaction(sum, new Date(), Mainbank.logged.getAccountList().get(0), " Снятие денег ");

                                    Mainbank.logged.getAccountList().get(0).addTransactions(transaction);
                                    System.out.println("Операция -(-снятие денег-)- сохранена в истории транзакции");
                                    break;


                                }
                            } catch (NumberFormatException exception) {
                                System.out.println("*-*-*-*-*--> Обойдемся без букв <--*-*-*-*-*");
                            }

                        }

                        System.out.println("Ваш сомовый счет после С_Н_Я_Т_И_Я _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(0).getBalance());
                        Account.Vernuty();
                        break;

                    case 2:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Ваш $$$ счет на текущий момент _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(1).getBalance());
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Введите сумму которую хотите ВЗЯТЬ");

                        while (true) {

                            try {
                                double ee = Integer.parseInt(Mainbank.scanner.nextLine());
                                if (ee > Mainbank.logged.getAccountList().get(1).getBalance()) {
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("*-*-*-*-*--> Введите доступную сумму <--*-*-*-*-*");
                                } else {
                                    Mainbank.logged.getAccountList().get(1).setBalance(Mainbank.logged.getAccountList().get(1).getBalance() - ee);
                                    Transaction transaction = new Transaction(ee, new Date(), Mainbank.logged.getAccountList().get(1), " Снятие денег ");

                                    Mainbank.logged.getAccountList().get(1).addTransactions(transaction);
                                    System.out.println("Операция -(- снятие денег -)- сохранена в истории транзакции");
                                    break;
                                }
                            } catch (NumberFormatException exception) {
                                System.out.println("*-*-*-*-*--> Обойдемся без букв <--*-*-*-*-*");
                            }
                        }
                        System.out.println("Ваш $$$ счет после С_Н_Я_Т_И_Я _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(1).getBalance());
                        Account.Vernuty();
                        break;

                }
            } catch (NumberFormatException exception) {
                System.out.println("=-=-=-=-=-=-!!!-=-=-=-=-=-=-=");
            }
        }


    }

    public static void TransferMoney() {

        boolean temp = true;

        while (temp) {


            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Для перевода введите его ID (или по FirstName так как программа еще не завершена)");


            String ss = Mainbank.scanner.nextLine();
            for (int i = 0; i < Mainbank.bank11.getCustomer().size(); i++) {
                if (Mainbank.bank11.getCustomer().get(i).getFirstName().equals(ss)) {
                    System.out.println("Найден пользователь --> " + Mainbank.bank11.getCustomer().get(i).getFirstName());
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    temp = false;
                    while (true) {
                        System.out.println("Из какого счета ему отправить???");
                        System.out.println("`'`'`'1. KGZ`'`'`'`'`'`'`'`'`2.USD'`'`'`'");
                        String vv = Mainbank.scanner.nextLine();
                        if (vv.equals("1")) {
                            while (true) {
                                System.out.println("Ваш личный счет в составляет СОМАХ *--> " + Mainbank.logged.getAccountList().get(0).getBalance());
                                System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                System.out.println("Сколько ему отправить???");
                                int ull = 0;
                                try {
                                    ull = Integer.parseInt(Mainbank.scanner.nextLine());

                                    if (ull > Mainbank.logged.getAccountList().get(0).getBalance()) {
                                        System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                        System.out.println("Перевод невозможен из за отсутствия недостаточных денег на счету ------>>> Попробуйте еще раЗ <<<------");
                                    } else {
                                        Mainbank.bank11.getCustomer().get(i).getAccountList().get(0).setBalance(Mainbank.bank11.getCustomer().get(i).getAccountList().get(0).getBalance() + ull);
                                        Mainbank.logged.getAccountList().get(0).setBalance(Mainbank.logged.getAccountList().get(0).getBalance() - ull);
                                        System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                        Transaction transaction = new Transaction(ull, new Date(), Mainbank.logged.getAccountList().get(0), "(-Перевод-)");

                                        Mainbank.logged.getAccountList().get(0).addTransactions(transaction);
                                        System.out.println("Операция - (-Перевод-) - сохранена в истории транзакции");
                                        System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                        System.out.println("Ваш сомовый счет после П_Е_Р_Е_В_О_Д_А_-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(0).getBalance());
                                        Account.Vernuty();
                                        break;
                                    }

                                } catch (NumberFormatException exception) {
                                    System.out.println("*-*-*-*-*--> Обойдемся без букв <--*-*-*-*-*");
                                }
                            }
                            break;

                        } else if (vv.equals("2")) {
                            while (true) {
                                System.out.println("Ваш личный счет в составляет $$$ *--> " + Mainbank.logged.getAccountList().get(1).getBalance());
                                System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                System.out.println("Сколько ему отправить???");


                                try {
                                    int uff = Integer.parseInt(Mainbank.scanner.nextLine());

                                    if (uff > Mainbank.logged.getAccountList().get(1).getBalance()) {
                                        System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                        System.out.println("Перевод невозможен из за отсутствия недостаточных денег на счету ------>>> Попробуйте еще раЗ <<<------");
                                    } else {
                                        Mainbank.bank11.getCustomer().get(i).getAccountList().get(1).setBalance(Mainbank.bank11.getCustomer().get(i).getAccountList().get(1).getBalance() + uff);
                                        Mainbank.logged.getAccountList().get(1).setBalance(Mainbank.logged.getAccountList().get(1).getBalance() - uff);
                                        System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                        Transaction transaction = new Transaction(uff, new Date(), Mainbank.logged.getAccountList().get(1), "(-Перевод-)");

                                        Mainbank.logged.getAccountList().get(1).addTransactions(transaction);
                                        System.out.println("Операция - (-Перевод-) - сохранена в истории транзакции");
                                        System.out.println("`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'`'``'`'`'`'`'`'`'`'`'`'`'`'`'`'`'");
                                        System.out.println("Ваш $$$ счет после П_Е_Р_Е_В_О_Д_А _-_-_-_-_-_--> " + Mainbank.logged.getAccountList().get(1).getBalance());
                                        Account.Vernuty();
                                        break;
                                    }

                                } catch (NumberFormatException exception) {
                                    System.out.println("*-*-*-*-*--> Обойдемся без букв <--*-*-*-*-*");
                                }
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Поиск пока не удачен");
                }
            }
        }
    }


    public String getOperation() {
        return operation;
    }

    public static void History() {
            if(Account.transactions.size() == 0){
                    System.out.println("История транзакций пока пуста");
                    Account.Vernuty();
            }
            else {
                try {
                    for (int j = 0; j < Account.transactions.size(); j++) {
//                        System.out.println(" Ваше имя --> " + Mainbank.logged.getAccountList().get(j).getAcaounholder().getFirstName());
                        System.out.println("---------------------------------------------------------------");
                        System.out.println(" Тип операции --> " + Account.transactions.get(j).getOperation());
                        System.out.println(" Время проведения операций --> " + Account.transactions.get(j).getTimestamp());
//                        System.out.println("---------------------------------------------------------------");
                        System.out.println(" Количество используемых средств --> " + Account.transactions.get(j).getAmount());
//                        System.out.println("---------------------------------------------------------------");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Account.Vernuty();


            }


//        while (true) {
//            for (int i = 0; i < Mainbank.logged.getAccountList().size(); i++) {
//                if (Mainbank.logged.getAccountList().get(0).getTransactions().size() == 0) {
//                    System.out.println("У вас пока отсутствует операцию с этим счетом!!!");
//                    Account.Vernuty();
//                } else {
//                    System.out.println(" Ваше имя --> " + Mainbank.logged.getAccountList().get(i).getAcaounholder().getFirstName()
//                            + "\n" + "---------------------------------------------------------------"
//                            + "\n" + " Тип операции --> " + Mainbank.logged.getAccountList().get(i).getTransactions().get(i).getOperation()
//                            + "\n" + "---------------------------------------------------------------"
//                            + "\n" + " Количество используемых средств --> " + Mainbank.logged.getAccountList().get(i).getTransactions().get(i).getAmount()
//                            + "\n" + "---------------------------------------------------------------"
//                            + "\n" + " Время проведения операций --> " + Mainbank.logged.getAccountList().get(i).getTransactions().get(i).getTimestamp());
//                    Account.Vernuty();
//                    break;
//                }
//
//            }
//        }

    }
}
