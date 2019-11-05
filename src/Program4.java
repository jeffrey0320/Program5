import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) throws FileNotFoundException
    {
        Bank bankObj = new Bank();

        char choice;
        boolean notDone = true;

        Scanner kybd = new Scanner(System.in);
        PrintWriter outputFile = new PrintWriter("myoutput.txt");

        readAccts(bankObj);
        printAccts(bankObj, kybd, outputFile);

        do{
            menu();
            choice = kybd.next(".").charAt(0);
            switch (choice) {
                case 'q':
                case 'Q':
                    notDone = false;
                    printAccts(bankObj, kybd, outputFile);
                    break;
                case 'b':
                case 'B':
                    balance(bankObj, kybd, outputFile);
                    break;
                case 'i':
                case 'I':
                    acctInfo(bankObj, kybd, outputFile);
                    break;
                case 'd':
                case 'D':
                    deposit(bankObj, kybd, outputFile);
                    break;
                case 'w':
                case 'W':
                    withdrawal(bankObj, kybd, outputFile);
                    break;
                case 'c':
                case 'C':
                    clearCheck(bankObj, kybd, outputFile);
                    break;
                case 'n':
                case 'N':
                    //newAcct(myAcct, Key, output);
                    break;
                case 'x':
                case 'X':
                    //deleteAcct(myAcct, Key, output);
                    break;
                default:
                    outputFile.println("Error: " + choice + " is an invalid selection -  try again");
                    outputFile.println();
                    outputFile.flush();
                    break;
            }
        } while (notDone);
        kybd.close();
        outputFile.close();
        System.out.println();
        System.out.println("The program is terminating");
    }

    public static void readAccts(Bank bankObj) throws FileNotFoundException {

        String line;
        File myFile = new File("myinput.txt");
        Scanner cin = new Scanner(myFile);

        while(cin.hasNext()){
            line = cin.nextLine();
            String[] tokens = line.split(" ");

            Name acctName = new Name(tokens[0],tokens[1]);
            Depositor acctInfo = new Depositor(tokens[2],acctName);
            Account allInfo = new Account(Integer.parseInt(tokens[3]),tokens[4],Double.parseDouble(tokens[5]),acctInfo);
            //bankObj.openNewAccount(allInfo);
        }
    }

    public static void printAccts(Bank bank, Scanner key, PrintWriter output){

        Name clientName;
        Depositor clientSSName;
        Account clientInfo;

        output.println("\t\tClients in the Database");
        output.println();output.printf("%-27s%-9s%-16s%-8s%13s", "Name", "SSN",
                "Account Number", " Account Type", " Balance");
        output.println();

        for (int count = 0; count < bank.getNumAccts(); count++) {
            clientInfo = bank.getAccts(count);
            clientSSName = clientInfo.getPersonInfo();
            clientName = clientSSName.getPersonName();
            output.printf("%-12s", clientName.getFirst());
            output.printf("%-12s", clientName.getLast());
            output.printf("%-9s", clientSSName.getSSN());

            output.printf("%13s", clientInfo.getAccountNumber());
            output.printf("%19s%-3s", clientInfo.getAccountType(), "");
            output.printf("$%9.2f", clientInfo.getAccountBalance());
            output.println();
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("Select one of the following transactions:");
        System.out.println("\t****************************");
        System.out.println("\t    List of Choices         ");
        System.out.println("\t****************************");
        System.out.println("\t     W -- Withdrawal");
        System.out.println("\t     D -- Deposit");
        System.out.println("\t     C -- Clear Check");
        System.out.println("\t     N -- New Account");
        System.out.println("\t     B -- Balance Inquiry");
        System.out.println("\t     I -- Account Info");
        System.out.println("\t     X -- Delete Account");
        System.out.println("\t     Q -- Quit");
        System.out.println();
        System.out.print("\tEnter your selection: ");
    }

    public static void balance(Bank bankObj, Scanner kybd, PrintWriter outputFile){

    }

    public static void deposit(Bank bankObj, Scanner kybd, PrintWriter outputFile){

    }

    public static void withdrawal(Bank bankObj, Scanner kybd, PrintWriter outputFile){

    }

    public static void clearCheck(Bank bankObj, Scanner kybd, PrintWriter outputFile){

    }

    public static void acctInfo(Bank bankObj, Scanner kybd, PrintWriter outputFile){

    }

    public static void acctInfoHistory(){

    }

    public static void newAccount(){

    }

    public static void closeAccount(){

    }

    public static void reopenAccount(){

    }

    public static void deleteAccount(){

    }
}
