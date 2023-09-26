import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OBS_FINAL{
    public static void main(String[] args) throws IOException {
        /*Main Method that creates 4 files for book, customer, sale and booksales
        Enters into methods Admin sign-in, Customer Sign-in, Customer Sign-up and Terminates program according to User Choice
        */
        Scanner input = new Scanner(System.in);
            
        File book_file = new File("book.txt");
        book_file.createNewFile();

        File customer_file = new File("customerfile.txt");
        customer_file.createNewFile();
        
        File sale_file = new File("sale.txt");
        sale_file.createNewFile();

        File buy_file = new File("booksales.txt");
        buy_file.createNewFile(); 

        String number = "";
        boolean b = true;
        System.out.println("\n\n");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("*  *   *  *     *   *     *          %%%%%                       %%%%          *    *   *  *     *   *     *");
        System.out.println("   *   *     *  *    *  *          %%%%      %%%%         %%%%      %%%%        *   *   *     *   *      *");
        System.out.println("*   *   *     *     *     *        %  %             %%%             %  %       *    *     *   *      *    *");
        System.out.println("   *   *     *  *     *   *        %  %              %              %  %          *  *     *   *     *   *");
        System.out.println("*   *     *   *     *  *           %  %              %              %  %            *  *   *     *   *     *");
        System.out.println("  *     *   *     *    *           %  %              %              %  %       *     *   *     *    *    *");
        System.out.println("*  *      *     *   *     *        %  %     BOOK     %     SHOP     %  %            *     *     *    *     *");
        System.out.println("   *   *     *  *    *  *          %  %              %              %  %        *    *   *     *   *      *");
        System.out.println("*   *   *     *     *     *        %  %              %              %  %       *      *     *   *      *    *");
        System.out.println("   *   *     *  *     *   *        %  %              %              %  %         *   *     *   *   *   *   *");
        System.out.println("*   *     *   *     *  *           %  %%%            %            %%%  %       *    *  *   *     *   *     *");
        System.out.println("  *     *   *     *    *           %%%%%%.  %%%%.    %    .%%%%  .%%%%%%          *   *   *     *    *    *");
        System.out.println("*  *   *  *     *   *     *                      %%%%%%%%%                     *     *     *     *    *     *");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("\n\n");
        while(b){
            System.out.println("\n\n                                      *********************************");
            System.out.println("                                      *********************************");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      ****       LOGIN PAGE        ****");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      *********************************");
            System.out.println("                                      *********************************");
            System.out.println("\n1-Admin Sign in.\n2-Customer Sign in.\n3-Customer Sign up.\n4-Exit application.\n");
            System.out.print("Choose your option: ");
            number = input.nextLine();
            if(number.charAt(0) == '4' && number.length() == 1){
                System.out.println("You exit from book shop.");
                break;
            }
            switch(number){
                case "1":
                System.out.print("Enter UserName: ");
                String U_name = input.nextLine();
                boolean isValidUserName;
                do{
                    if(U_name.equals("admin")){
                        isValidUserName = false;
                    } else{
                        System.out.println("Invalid User Name! Please enter valid User Name");
                            U_name = input.nextLine();
                            isValidUserName = true;
                        }
                    }while(isValidUserName);
                    System.out.print("Enter Password: ");
                    String p_ward = input.nextLine();
                    boolean isValidPassword;
                    do{
                        if(p_ward.equals("123")){
                        isValidPassword = false;
                        }
                        else{
                            System.out.println("Invalid Password! Please enter Valid Password");
                            p_ward = input.nextLine();
                            isValidPassword = true;
                        }
                    }while(isValidPassword);
                    main_menu(book_file, customer_file, sale_file,buy_file);
                    break;
                case "2":
                    customer_login(book_file, customer_file,buy_file);
                    break;
                case "3":
                    add_customer(customer_file);
                    break;
                default:
                    System.out.println("Choose correct option.");
                    continue;
            }
        b = true;
        }
    } 
    public static void customer_login(File book, File customer,File buy) throws IOException{
        /*Creates a new Cart file, Login to Customer If he/she enters correct data */
        try{
            File cart1 = new File("");
            Scanner input = new Scanner(System.in);
            System.out.print("Enter UserID: ");
            String c_Name = input.nextLine();
            String pass_check = "";
            boolean isValidCustomerName;
            do{
                if (c_Name.equals("35")) {
                    pass_check = "12";
                    cart1 = new File("AhsanCart.txt");
                    cart1.createNewFile();
                    isValidCustomerName = false;
                } else if (c_Name.equals("989")) {
                    pass_check = "23";
                    cart1 = new File("FarooqCart.txt");
                    cart1.createNewFile();
                    isValidCustomerName = false;
                } else if (c_Name.equals("565")) {
                    pass_check = "34";
                    cart1 = new File("ManahilCart.txt");
                    cart1.createNewFile();
                    isValidCustomerName = false;
                }
                else{
                    System.out.println("Invalid User ID, Please enter valid User ID: ");
                        c_Name = input.nextLine();
                        isValidCustomerName = true;
                    }
            }while(isValidCustomerName);

            System.out.print("Enter Password: ");
            String c_ward = input.nextLine();
            boolean isValidCustomerPassword;
            int pass_count = 0;

            do{
                if(c_ward.equals(pass_check)){
                    isValidCustomerPassword = false;
                    customer = customerMain(customer,book,cart1,buy);
                } else{
                    System.out.println("Invalid Password, Please enter Valid Password: ");
                    pass_count++;
                    c_ward = input.nextLine();
                    isValidCustomerPassword = true;
                }
                if(pass_count > 4){
                    System.out.println("\n-->You cant't login. If you forget your password, Send us an email on \"OBS@gmail.com\"");
                    isValidCustomerPassword = false;
                }
            }while(isValidCustomerPassword);
        } catch(FileNotFoundException e){
            System.out.print("");
        } 
    }
    public static void main_menu(File book, File customer, File sale,File buy) throws IOException{
        /* This method gives 4 choices to user and then call that respective method */
        Scanner input = new Scanner(System.in);
        String choice = "4";
        boolean b = true;
        while (b){
        System.out.println("\n\n                                      *********************************");
        System.out.println("                                      *********************************");
        System.out.println("                                      ****                         ****");
        System.out.println("                                      ****                         ****");
        System.out.println("                                      ****        MAIN MENU        ****");
        System.out.println("                                      ****                         ****");
        System.out.println("                                      ****                         ****");
        System.out.println("                                      *********************************");
        System.out.println("                                      *********************************");
        System.out.println("\n1) EDIT AND VIEW BOOK RECORD.\n2) EDIT AND VIEW CUSTOMER RECORD.\n3) EDIT AND VIEW SALE RECORD.\n4) SIGN OUT.\nEnter your choice:"); 
        choice = input.next();
        if (choice.charAt(0) == '4' && choice.length()== 1){
            System.out.println("Exiting main menu\n");
            return;}
        switch(choice){
            case "1":
                admin_main(book);
                break;
            case "2":
                customer = customerAdmin_main(customer,book);
                break;
            case "3":
                sale = sell_main(sale, book, customer, buy);
                break;
            default:
                System.out.println("Enter correct choice, from 1 to 4 \n");
                break;   
        }
    }  
}
    public static File admin_main(File book) throws IOException{
        /* Gives User 6 different Choices and call specific method according to choice */
        Scanner input = new Scanner(System.in);
        Scanner scan1 = new Scanner(book);
        int s1 = 1;
        String option = ""; 
        boolean b = true;
        while(b){
            System.out.println("\n\n                                      ************************");
            System.out.println("                                      ************************");
            System.out.println("                                      ****                ****");
            System.out.println("                                      ****  BOOK RECORDS  ****");
            System.out.println("                                      ****                ****");
            System.out.println("                                      ************************");
            System.out.println("                                      ************************");
            System.out.println("\nOptions\n1-ADD book\n2-VIEW book\n3-UPDATE book\n4-SEARCH any book\n5-DELETE book\n6-Back to main menu");
            System.out.println("Enter ur option: ");
            option = input.next();
            if (option.charAt(0) == '6' && option.length()==1){
                b = false;
                break;
            }
            switch(option){
                case "1":
                    book = add_book(book, s1);
                    break;
                case "2":
                    if(book.length()>0){
                        BufferedReader a = new BufferedReader(new FileReader(book.getAbsolutePath()));
                        Scanner in = new Scanner(book);
                        System.out.println("                                *************************************");
                        System.out.println("                                          VIEW BOOK RECORD");
                        System.out.println("                                *************************************");
                        System.out.println("==================================================================================================================");
                        System.out.println("BOOK ID\t\tBOOK NAME\tAUTHOR NAME\tBOOK TYPE\tPUBLISHED on\t\tPRICE/BOOK\tQUANTITY");
                        System.out.println("==================================================================================================================");
                        String string = a.readLine();
                        view(book, string, a);
                        in.close();
                    } else{
                        System.out.println("Currently no book was found or added in shop.");
                    }
                    break;
                case "3":
                    if(book.length()>0){
                        System.out.println("Enter book id to update book: ");
                        int book_id = bookid_valid(book);
                        book = update_book(book, book_id);
                    } else{
                        System.out.println("Currecntly no book was added or found in shop.");
                    }
                    break;
                case "4":
                    if(book.length()>0){
                        System.out.println("Enter book id to search: ");
                        int book_id = bookid_valid(book);
                        BufferedReader br = new BufferedReader(new FileReader(book.getAbsolutePath()));
                        String s2 = br.readLine();
                        search_book(book, s2, book_id, br);
                    } else{
                        System.out.println("Currently no book was found or added in shop.");
                    }
                    break;
                case "5":
                    if(book.length()>0){
                        System.out.print("Enter Book ID you want to delete:");
                        int book_id = bookid_valid(book);
                        book = delete_book(book, book_id);
                        System.out.println("Delete book succesfully from the shop.");   
                    } else{
                        System.out.println("Currently no book was found or added in shop.");
                    }
                    break;
                default:
                    System.out.println("\nEnter correct option, from 1 to 7\n");
                    continue;

            }
            b = true;
        } 
        return book;
    }
    public static int bookid_valid(File book) throws IOException{
        // Checks the valid book_ID from file.
        int book_id = 0;
        Scanner input = new Scanner(System.in);
        try {
            Scanner scan = new Scanner(book);
            boolean b = true;
            int check = 0;
            while(b){
                scan = new Scanner(book);
                book_id = check_input();
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == book_id){
                        check = Integer.parseInt(arr[0]);
                    }
                } 
                scan.close();
                if(check == book_id){
                    b = false;
                } else{
                    System.out.println("You enter Id " + book_id + " which was wrong, enter your ID again: ");
                    b = true;
                }
            } 
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. ");
        }
        return book_id;
    }
    public static File customerAdmin_main(File customer,File book) throws IOException{
        /* Main Menu of the Customer (Under Admin):
           in which admin can View, Update, Search, and Delete customer data by selecting a choice.
         */
        try{
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(customer);
            String option = ""; 
            boolean b = true;
            while(b){
                System.out.println("\n\n                                      ****************************");
                System.out.println("                                      ****************************");
                System.out.println("                                      ****                    ****");
                System.out.println("                                      ****  CUSTOMER RECORDS  ****");
                System.out.println("                                      ****                    ****");
                System.out.println("                                      ****************************");
                System.out.println("                                      ****************************");
                System.out.println("\nOptions\n1-VIEW customer\n2-UPDATE customer\n3-SEARCH customer\n4-DELETE customer\n5-Back to main menu");
                System.out.println("Choose option: ");
                option = input.next();
                if (option.charAt(0) == '5' && option.length()==1){
                    break;
                }
                switch(option){
                    case "1":
                        if(customer.length()>0){
                            BufferedReader a = new BufferedReader(new FileReader(customer.getAbsolutePath()));
                            Scanner in = new Scanner(customer);
                            System.out.println("                         *************************************");
                            System.out.println("                                  VIEW CUSTOMER RECORD");
                            System.out.println("                         *************************************");
                            System.out.println("=======================================================================================================================================================");
                            System.out.println("CUSTOMER ID\tNAME\t\tGENDER\t\tPHONE NO.\t\tEmail id\t\t\t\t\tAddress");
                            System.out.println("=======================================================================================================================================================");
                            String string = a.readLine();
                            view(customer, string, a);
                            in.close();
                        } else{
                            System.out.println("Currently there was no customer added or found in shop.");
                        }
                        break;
                    case "2":
                        if(customer.length()>0){
                            System.out.println("Enter Customer id to update customer: ");
                            int cus_id = cusid_valid(customer);
                            customer = update_customer(customer, cus_id);
                        } else{
                        System.out.println("Currently there was no customer added or found in shop.");
                        }                   
                        break;
                    case "3":
                        if(customer.length()>0){
                            System.out.println("Enter customer id to search data: ");
                            int cus_id = cusid_valid(customer);
                            BufferedReader br = new BufferedReader(new FileReader(customer.getAbsolutePath()));
                            String s2 = br.readLine();
                            search_customer(customer, s2, cus_id, br);
                        } else{
                            System.out.println("Currently there was no customer added or found in shop.");
                        }
                        break;
                    case "4":
                        if(customer.length()>0){
                            System.out.println("Enter customer id to delete: ");
                            int cus_id = cusid_valid(customer);
                            customer = delete_customer(customer, cus_id);
                            System.out.println("Customer whose id is " + cus_id + " was deleted successfully.");
                        } else{
                            System.out.println("Currently there was no customer added or found in shop.");
                        }
                        break;
                    default:
                        System.out.println("Enter correct option.\n");
                        continue;
                }
                b = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } 
        return customer;
    }
    public static int cusid_valid(File customer) throws IOException{
        /* Checks if the customer ID is valid or not.
        Checks that customer_ID entered by customer from the file.
         */
        int cus_id = 0;
        Scanner input = new Scanner(System.in);
        try {
            Scanner scan = new Scanner(customer);
            boolean b = true;
            int check = 0;
            while(b){
                scan = new Scanner(customer);
                cus_id = check_input();
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == cus_id){
                        check = Integer.parseInt(arr[0]);
                    }
                } 
                scan.close();
                if(check == cus_id){
                    b = false;
                } else{
                    System.out.println("You enter Id " + cus_id + " which was wrong, enter your ID again: ");
                    b = true;
                }
            } 
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. ");
        }
        return cus_id;
    }
    public static File add_book(File book, int s) throws IOException{
        /* Called by the method Book_main on user's Choice
        It's purpose is to add a book by the Admin
        Asks Admin to add all the details of that book  */
        try{ 
            Scanner input = new Scanner(System.in);
            FileWriter fw = new FileWriter(book, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String yes = "y";
            System.out.println("\n**************************************************************************");
            System.out.println("   --------------------------ADD BOOKS IN SHOP-----------------------");
            System.out.println("**************************************************************************");
            while((yes.charAt(0) == 'y' || yes.charAt(0) == 'Y') && (yes.length()==1)){
                fw = new FileWriter(book, true);
                bw = new BufferedWriter(fw);
                System.out.println("\nEnter book id:");
                int book_id = check_input();
                boolean check = true, check2 = true;
                while(check){
                    if(book_id > 0){
                        if(s==0){
                            bw.write(book_id + "\t");
                        } else{
                            while(check2){
                                if (unique(book_id, book) == true) {
                                    System.out.print("This book ID already exist, enter unique one: ");
                                    book_id = check_input();
                                    check2 = true;
                                } else {
                                    bw.write(book_id + "\t");
                                    check2 = false;
                                    break;
                                } 
                            }
                        }
                        check = false;
                        break;
                    } else{
                        System.out.println("\nYou enter book ID in negative, Enter again: ");
                        book_id = check_input();
                        check = true;
                    }
                }     
                System.out.println("Enter book name: ");
                String book_name = check_string();
                bw.write(book_name + "\t");
                System.out.println("Enter author's name: ");
                String author_name = check_string();
                bw.write(author_name +"\t");
                String book_type = book_type();
                bw.write(book_type +"\t");
                System.out.println();
                String publish_date = check_date();
                bw.write(publish_date +"\t");
                System.out.println("Enter book price:");
                int book_price= check_input();
                check = true;
                while(check){
                    if(book_price >=1){
                        bw.write(book_price +"\t");
                        check = false;
                        break;
                    } else{
                        System.out.println("You entered wrong book price\nEnter again: ");
                        book_price = check_input();
                        check = true;
                    }
                } 
                System.out.println("Enter book quantity: ");
                int book_quantity = check_input();
                check = true;
                while(check){
                    if(book_quantity >=1 && book_quantity <= 200){
                        bw.write(book_quantity +"\t");
                        check = false;
                        break;
                    } else{
                    System.out.println("Book quantity should be greater than 1 and less than 200\nEnter again: ");
                    book_quantity = check_input();
                    check = true;
                    }
                } 
                s++;
                bw.newLine();
                System.out.println("Book with id "+ book_id +" was added succesfully.\n");
                System.out.println("Want to add more Books in shop? (Y/n) ");
                yes = input.next();
                bw.close();
            } 
        }catch(Exception e){
            System.out.println(" ");
        }
        return book;
    }
    public static boolean unique(int id, File f) throws IOException, NullPointerException {
        // It will check weather the given ID is unique or not.
        try {
            boolean unique = false;
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.startsWith(String.valueOf(id))){
                    return unique = true;
                }
            }
            scan.close();
            return unique;
        } catch (FileNotFoundException e) {
            System.out.print(" ");
        }
        return false;
    }
    public static void view(File f, String s, BufferedReader a) throws IOException, NullPointerException {
        /* Method to Read the Data from the file */
        if (s == null) {
            return;
        }
        String[] array = s.split("\t");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t\t");
        }
        System.out.println();
        s = a.readLine();
        view(f, s, a);
        return;
    }
    public static File update_book(File book, int book_id) throws IOException{
        /* Method to Update the data of book
        Name, Aurthur's Name, Type, Date of Publish, Price and quantity on User's Choice */
        File myNewFile = new File("");
        try{ 
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(book);
            String data = "";
            boolean b = true;
            System.out.println("You can update data:-\n1)BOOK NAME\n2)AUTHOR'S NAME\n3)BOOK TYPE\n4)DATE OF PUBLISH\n5)BOOK PRICE\n6)BOOK QUANTITY\nChoose option to update: ");
            int option = 0;
            while (b) {
                option = check_input();
                if(option >=1 && option <=6){
                    b = false;
                } else{
                    System.out.println("choose correct option, Enter again:");
                    b = true;
                }
            }  
            if (option == 1 || option == 2) {
                if (option == 1) {
                    System.out.println("Enter new Book name: ");
                } else {
                    System.out.println("Enter new Author's name: ");
                }
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(book_id))){
                        String[] arr = line.split("\t");
                        arr[option] = check_string();
                        line = "";
                        for (int i = 0; i < 7; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                book.delete();
                //create new file with the same name
                myNewFile = new File("./book.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                if (option == 1) {
                    System.out.println("Book name updated. ");
                } else {
                    System.out.println("Author's name updated. ");
                }

            } else if (option == 3){
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(book_id))){
                        String[] arr = line.split("\t");
                        arr[3] = book_type();
                        line = "";
                        for (int i = 0; i < 7; i++){
                        line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                book.delete();
                //create new file with the same name
                myNewFile = new File("./book.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Book type updated.");
            } else if (option == 4){
                System.out.println("Enter new Book publish date:");
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(book_id))){
                        String[] arr = line.split("\t");
                        arr[4] = check_date();
                        line = "";
                        for (int i = 0; i < 7; i++){
                        line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                book.delete();
                //create new file with the same name
                myNewFile = new File("./book.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Book publish date updated.");
            }
             else if (option == 5 || option == 6) {
                if(option == 5){
                    System.out.println("Enter new Book price: ");
                }else{
                    System.out.println("Enter new Book quantity: ");
                }
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(book_id))){
                        String[] arr = line.split("\t");
                        arr[option] = input.next();
                        line = "";
                        for (int i = 0; i < 7; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                book.delete();
                //create new file with the same name
                myNewFile = new File("./book.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                if(option == 5){
                    System.out.println("Book price updated. ");
                }else{
                    System.out.println("Book quantity updated. ");
                }
            } 
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        return myNewFile;
    }
    public static void search_book(File book, String s, int book_id, BufferedReader br) throws IOException{
        /* Method to Search book according to user's choice e.g All details, by Name, by aurthor, type etc */
        try {
            if(s != null){
            String[] array = s.split("\t");
            if(Integer.toString(book_id).equals(array[0])){
                boolean b = true;
                while(b){
                    System.out.println("Enter choice you want to search\n1-All details\n2-Book name only\n3-Author name only\n4-Book type\n5-Publish date only\n6-Price only\n7-Quantity only\n8-Back to book records\nChoose option: ");
                    int choice = check_input();
                    if (choice == 8){
                        break;
                    }
                    switch (choice){
                        case 1:
                            System.out.println();
                            System.out.println("==================================================================================================================");
                            System.out.println("BOOK ID\t\tBOOK NAME\tAUTHOR NAME\tBOOK TYPE\tPUBLISHED on\t\tPRICE/BOOK\tQUANTITY");
                            System.out.println("==================================================================================================================");
                            for(int i = 0; i<array.length; i++){
                                System.out.print(array[i]+ "\t\t");
                            }
                            System.out.println(""); 
                            break;
                        case 2:
                            //As book Name is at index 1, This Statment will get Name using index "1". Same with all remaining cases.
                            System.out.println("Book name : " +array[1]);
                            break;
                        case 3:
                            System.out.println("Author name : " +array[2]);
                            break;
                        case 4:
                            System.out.println("Book type: " +array[3]);
                            break;
                        case 5:
                            System.out.println("Publish date: " +array[4]);
                            break;
                        case 6:
                            System.out.println("Book price: " +array[5]);
                            break;
                        case 7:
                            System.out.println("Quantity of book: " +array[6]);
                            break;
                        default:
                            System.out.println("Enter correct choice.");
                            continue;
                    }
                    System.out.println("");
                    continue;
                }
            }
            }else{
                return;
            }
            s = br.readLine();
            search_book(book, s, book_id, br);
        } catch (Exception e) {
            System.out.println("");
        }
    }
    public static File delete_book(File book, int id) throws IOException{
        /*This method is used to delete book from shop this method 
          save every line of book file in data except that line on
          which deleted book id was found and re-write that data in file.
         */
        File myNewFile = new File("");
        try{
            Scanner scan = new Scanner(book);
            String data = "";
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.startsWith(String.valueOf(id))){
                    line = "";
                }
                else
                    data += line + "\n";
            }
            scan.close();
            //delete previous file
            book.delete();
            //create new file with the same name
            myNewFile = new File("./book.txt");
            FileWriter writer = new FileWriter(myNewFile);
            writer.write(data);
            writer.close();
        }catch (IOException e) {
            System.out.print("File not found");
        }
        return myNewFile;
    }
    public static File add_customer(File customer) throws IOException{
        /*Method to Add Customer:
        It will asks user to add all his details.
         */
        try{ 
            FileWriter r = new FileWriter(customer, true);
            BufferedWriter ap = new BufferedWriter(r);
            String yes = "y";
            System.out.println("\n***********************************************************************");
            System.out.println("--------------------------ADD Your details-----------------------");
            System.out.println("***********************************************************************");
            Scanner scan = new Scanner(customer);
            /* Statements to generate a random Number from 10-999 and checks weather it's already in file or not
            If It's not in file, this will show the ID to User. Otherwise generate again
             */
            int id = (int)(10 + Math.random() * 999);
            String uId = String.valueOf(id);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] arr = line.split("\t");
                if(arr[0] == uId){
                    id = (int)(10 + Math.random() * 999);
                    uId = Integer.toString(id);
                }
            }
            scan.close();
            System.out.println("Your reg id no. is: " + uId );
            ap.write(uId + "\t");
            System.out.println("Enter your name: ");
            String customer_name = check_string();
            ap.write(customer_name + "\t");
            System.out.println("Enter your gender: ");
            String gender = check_gender();
            ap.write(gender +"\t");
            System.out.println("Enter your phone number(0000-0000000): ");
            String phone_no = check_mobNo();
            ap.write(phone_no +"\t");
            System.out.println("Enter your Gmail Id(Must be correct):");
            String email = check_email();
            ap.write(email +"\t");
            System.out.println("\nEnter your address:-");
            String address = address();
            ap.write(address + "\t");
            ap.newLine();
            ap.close();
            System.out.println("\nYour UserID is "+ uId +" and you will get your password on your email within 1 minutes. \n");
        } catch(IOException e){
            System.out.println(" ");
        } 
        return customer; 
    }
    public static File update_customer(File customer, int customer_id) throws IOException{
        /* Method to update customer data: Name, Gender, Contact, Email and Address:
         */
        File myNewFile = new File("");
        try{ 
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(customer);
            String data = "";
            boolean b = true;
            System.out.println("You can update:-\n1)Name\n2)Gender\n3)Phone no.\n4)Email\n5)Address");
            int option = 0;
            while (b) {
                option = check_input();
                if(option >=1 && option <=5){
                    b = false;
                } else{
                    System.out.println("choose correct option, Enter again:");
                    b = true;
                }
            }
            // If the User Enter "1" It will ask to add new name, Will write that new name in the file at Name Index.
            if (option == 1) {
                System.out.println("Enter new name: ");
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(customer_id))){
                        String[] arr = line.split("\t");
                        arr[option] = check_string();
                        line = "";
                        for (int i = 0; i < 6; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                customer.delete();
                //create new file with the same name
                myNewFile = new File("./customerfile.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Name updated.");
            // If the User Enter "2" It will ask to add new gender, Will write that new gender in the file at gender Index.
            } if (option == 2) {
                System.out.println("Enter updated gender: ");
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(customer_id))){
                        String[] arr = line.split("\t");
                        arr[option] = check_gender();
                        line = "";
                        for (int i = 0; i < 6; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                customer.delete();
                //create new file with the same name
                myNewFile = new File("./customerfile.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Gender updated.");
            // If the User Enter "3" It will ask to add new phone No. Will write that new number in the file at number Index.
            }if (option == 3) {
                System.out.println("Enter new phone number: ");
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(customer_id))){
                        String[] arr = line.split("\t");
                        arr[option] = check_mobNo();
                        line = "";
                        for (int i = 0; i < 6; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                customer.delete();
                //create new file with the same name
                myNewFile = new File("./customerfile.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Phone number updated.");
            // If the User Enter "4" It will ask to add new Email, Will write that new Email in the file at "Email" Index.
            }if (option == 4) {
                System.out.println("Enter new gmail id: ");
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(customer_id))){
                        String[] arr = line.split("\t");
                        arr[option] = check_email();
                        line = "";
                        for (int i = 0; i < 6; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                customer.delete();
                //create new file with the same name
                myNewFile = new File("./customerfile.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Gmail ID updated.");
            // If the User Enter "5" It will ask to add new address, Will write that new address in the file at "address" Index.
            }if (option == 5) {
                System.out.println("Enter new address: ");
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    if (line.startsWith(String.valueOf(customer_id))){
                        String[] arr = line.split("\t");
                        arr[option] = address();
                        line = "";
                        for (int i = 0; i < 6; i++){
                            line += arr[i] + "\t";	
                        }
                        data +=  line + "\n";
                    }
                    else
                        data += line + "\n";
                }
                scan.close();
                //delete previous file
                customer.delete();
                //create new file with the same name
                myNewFile = new File("./customerfile.txt");
                FileWriter writer = new FileWriter(myNewFile);
                writer.write(data);
                writer.close();
                System.out.println("Address updated.");

            }
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        return myNewFile;
    }
    public static void search_customer(File customer, String s, int customer_id, BufferedReader br) throws IOException{
        /* Method to Search book according to user's choice e.g All details, by Name, by aurthor, type etc
           Same Logic that applies to "Search_Book method" */
        try {
            Scanner input = new Scanner(System.in);
            if(s != null){
            String[] array = s.split("\t");
            if(String.valueOf(customer_id).equals(array[0])){
                boolean b = true;
                while(b){
                    System.out.println("\nEnter choice you want to search:-\n1-All details \n2-Customer name only\n3-Gender only\n4-Phone no. only\n5-Email only\n6-Address only\n7-Back to menu\nChoose option: ");
                    String choice = input.nextLine();
                    if (choice.charAt(0) == '7' && choice.length() == 1){
                        break;
                    } 
                    switch (choice){
                        case "1":
                            System.out.println();
                            System.out.println("=======================================================================================================================================================");
                            System.out.println("CUSTOMER ID\tNAME\t\tGENDER\t\tPHONE NO.\t\tEmail id\t\t\t\t\tAddress");
                            System.out.println("=======================================================================================================================================================");
                            for(int i = 0; i<array.length; i++){
                                System.out.print(array[i]+ "\t\t");
                            }
                            break;
                        //As Customer Name is at index 1, This Statment will print Name using index "1". Same with all remaining cases.
                        case "2":
                            System.out.println("Customer name: " + array[1]);
                            break;
                        case "3":
                            System.out.println("customer's gender : " + array[2]);
                            break;
                        case "4":
                            System.out.println("customer's phone number : " + array[3]);
                            break;
                        case "5":
                            System.out.println("customer's email: " + array[4]);
                            break;
                        case "6":
                            System.out.println("Customer address: " + array[5]);
                            break;
                        default:
                            System.out.println("enter correct choice");
                            continue;
                    }
                    b = true;
                }
            }
        } else{
            return;
        }
        s = br.readLine();
        search_customer(customer, s, customer_id, br);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public static File delete_customer(File customer, int id) throws IOException{
        /*This method is used to delete customer from shop this method 
          save every line of customer file in data except that line on
          which deleted customer id was found and re-write that data in file.
         */
        File myNewFile = new File("");
        try{
            Scanner scan = new Scanner(customer);
            String data = "";
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.startsWith(String.valueOf(id))){
                    line = "";
                }
                else
                    data += line + "\n";
            }
            scan.close();
            //delete previous file
            customer.delete();
            //create new file with the same name
            myNewFile = new File("./customerfile.txt");
            FileWriter writer = new FileWriter(myNewFile);
            writer.write(data);
            writer.close();
        }catch (IOException e) {
            System.out.print("File not found");
        }
        return myNewFile;
    }
    public static File sell_main(File sell_file, File book, File customer, File buy)throws IOException, FileNotFoundException{
        /* Book Sales Menu for Admin:
        He can check:
        1-SALE book by yourself
        2-RECORD of books sold by admin
        3-RECORD of book buy by customer
         */
        boolean b = true;
        String choice;
        Scanner input = new Scanner(System.in);
        try{
            while(b){
                System.out.println("\n\n                                      ************************");
                System.out.println("                                      ************************");
                System.out.println("                                      ****                ****");
                System.out.println("                                      ****   BOOK SALES   ****");
                System.out.println("                                      ****                ****");
                System.out.println("                                      ************************");
                System.out.println("                                      ************************");
                System.out.println("\nOptions:-\n1-SALE book by yourself\n2-RECORD of books sold by admin\n3-RECORD of book buy by customer\n4-BACK to main menu\nChoose option: ");
                choice = input.nextLine();
                if (choice.charAt(0) == '4' && (choice.length() == 1)){
                    break;
                }
                switch(choice){
                    case "1":
                        if(book.length()>0){
                            if(customer.length()>0){
                                sell_file = sale_book(book, customer, sell_file);
                            } else{
                                System.out.println("Currently no customer was found in shop.");
                            }
                        } else{
                            System.out.println("Currently no book was found in shop.");
                        }
                        break;
                    case "2":
                    if(sell_file.length()>0){
                        System.out.println("                         *************************************");
                        System.out.println("                                    BOOK SOLD RECORD");
                        System.out.println("                         *************************************");
                        System.out.println("==========================================================================================");
                        System.out.println("CUSTOMER ID\tCUSTOMER NAME\tBOOK ID\t\tBOOK NAME\tPRICE\t\tQUANTITY");
                        System.out.println("==========================================================================================");
                        BufferedReader a = new BufferedReader(new FileReader(sell_file.getAbsolutePath()));
                        String s1 = a.readLine();
                        view(sell_file, s1, a);
                        break;
                        
                    } else{
                        System.out.println("Currently no book was sale by admin to customer.");
                    }
                        break;
                    case "3":
                    if(buy.length()>0){
                        System.out.println("                         *************************************");
                        System.out.println("                                   BOOK BUY RECORD");
                        System.out.println("                         *************************************");
                        System.out.println("==========================================================================================");
                        System.out.println("CUSTOMER ID\tCUSTOMER NAME\tBOOK ID\t\tBOOK NAME\tPRICE\t\tQUANTITY");
                        System.out.println("==========================================================================================");
                        BufferedReader br = new BufferedReader(new FileReader(buy.getAbsolutePath()));
                        String line = br.readLine();
                        view(sell_file, line, br);
                    } else{
                        System.out.println("Currently no book was reserved by any customer.");
                    }
                        break;
                    default:
                        System.out.println("enter correct choice.");
                        continue;
                }
                b = true;
            }
        } catch(FileNotFoundException e){
            System.out.println(" ");
        }
        return sell_file;
    }
    public static File sale_book(File book, File customer,File sell) throws IOException{
            Scanner input = new Scanner(System.in);
            boolean b = true;
            int check1 = 0;
            String cus_name = "";
            Scanner scan1 = new Scanner(book);
            Scanner scan =new Scanner(customer);
            System.out.println("Enter Customer UserId to sale book: ");
            while(b){
                scan = new Scanner(customer);
                int cus_id = check_input();
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == cus_id){
                        check1 = Integer.parseInt(arr[0]);
                        cus_name = arr[1];
                    }
                } 
                scan.close();
                if(check1 == cus_id){
                    b = false;
                } else{
                    System.out.println("You enter Id " + cus_id + " which was wrong, enter UserID again: ");
                    b = true;
                }
            } 
            scan.close();
            System.out.println("Enter Book ID you want to sale from your shop:");
            b = true;
            int check2 = 0;
            String book_name = ""; 
            int quantity = 0, total_quantity = 0;
            int price = 0;
            int book_price = 0;
            while(b){
                scan1 = new Scanner(book);
                int bookid = check_input();
                while(scan1.hasNextLine()){
                    String line = scan1.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == bookid){
                        check2 = Integer.parseInt(arr[0]);
                        book_name = arr[1];
                        price = Integer.parseInt(arr[5]);
                        total_quantity =  Integer.parseInt(arr[6]);
                    }
                } 
                scan1.close();
                if(check2 == bookid){  
                    b = false;
                } else{
                    System.out.println("You enter book Id which was not found in your shop, enter again: ");
                    b = true;
                }
            } 
            scan1.close();
            if(total_quantity > 0){
                System.out.println("Enter quantity of book want to sale: ");
                b = true;
                while(b){
                    quantity = check_input();
                    if(quantity<=total_quantity){
                        book_price = price * quantity;
                        b = false;
                    } else{
                        System.out.println("There are only " + total_quantity + " books left in shop,\nyou have to enter less quanity: ");
                        b = true;
                    }
                }
                System.out.println("Name of book whose id is " + check2 + ": " + book_name);
                System.out.println("Total price of book with quantity " + quantity + " is: " + book_price);
                System.out.println("Want to sale this book? (Y/n)");
                String check = input.nextLine();
                if((check.charAt(0) == 'y' || check.charAt(0) == 'Y') && (check.length() == 1)){
                    Scanner scan2 = new Scanner(book);
                    FileWriter fw = new FileWriter(sell, true);
                    BufferedWriter bw = new BufferedWriter(fw);         
                    bw.write(check1 + "\t");
                    bw.write(cus_name + "\t");
                    bw.write(check2 + "\t");
                    bw.write(book_name + "\t");
                    bw.write(book_price + "\t");
                    bw.write(quantity + "\t");
                    scan2.close();
                    bw.newLine();
                    bw.close();
                    update_quantity(book,check2, quantity);
                    System.out.println("You sale the book to customer name: "+ cus_name  +" and back to book sales.\n");
                } else{
                    System.out.println("Back to sale record without sale the book.");
                }
            } else{
                System.out.println("You can't sale this because there was no stock of this book left in shop");
            }
            
        return sell;
    }
    public static void update_quantity(File book, int book_id,int quantity) throws IOException{
        /*Method called in Sale_book and Buy_book
        It update the quantity when the book is sold by admin or Customer buy a book:
         */

        try{
            Scanner scan = new Scanner(book);
            String data = "";
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.startsWith(String.valueOf(book_id))){
                    String[] arr = line.split("\t");
                    int takeQ = Integer.parseInt(arr[6]);
                    int upQ = takeQ - quantity;
                    arr[6] = String.valueOf(upQ);
                    line = "";
                    for (int i = 0; i < 7; i++){
                    line += arr[i] + "\t";	
                    }
                    data +=  line + "\n";
                }
                else
                    data += line + "\n";
            }
            scan.close();
            //delete previous file
            book.delete();
            //create new file with the same name
            File myNewFile = new File("./book.txt");
            FileWriter writer = new FileWriter(myNewFile);
            writer.write(data);
            writer.close();
        }catch (IOException e) {
            System.out.print("File not found");
        }
    }    
    public static File customerMain(File customer,File book,File cart,File buy) throws IOException , FileNotFoundException{
        /* Main Menu which will show to Customer:
            It will asks different choice and will call that respective Method.
         */
        Scanner input = new Scanner(System.in);
        String option = ""; 
        boolean b = true;
        while(b){
            System.out.println("\n\n                                      *********************************");
            System.out.println("                                      *********************************");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      ****        MAIN MENU        ****");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      ****                         ****");
            System.out.println("                                      *********************************");
            System.out.println("                                      *********************************");
            System.out.println("\nOptions\n1-VIEW BOOK SHOP\n2-VIEW AND EDIT YOUR CART\n3-VIEW AND EDIT YOUR DATA\n4-SIGN OUT\n");
            System.out.println("Enter ur option: ");
            option = input.next();
            if (option.charAt(0) == '4' && option.length()==1){
                break;
            } 
            switch(option){
                case "1":
                    customer_book(book);
                    break;
                case "2":
                    customer_cart(cart,book,buy,customer);
                    break;
                case "3":
                    customer_data(customer);
                    break;
                default:
                    System.out.println("Enter correct option \n");
                    break;
            }
        } 
        return customer;
    }
    public static void customer_book(File book) throws IOException{
        /* This method is for Customer to Find and view books that are present in Book shop
        It is called when the customer chooses "View Book Shop" in "Main Menu"
         */
        try {
            Scanner input = new Scanner(System.in);
            Scanner scan1 = new Scanner(book);
            String option = "";
            boolean b = true;
            while(b){
                System.out.println("\n\n                                      ************************");
                System.out.println("                                      ************************");
                System.out.println("                                      ****                ****");
                System.out.println("                                      ****   BOOKS MENU   ****");
                System.out.println("                                      ****                ****");
                System.out.println("                                      ************************");
                System.out.println("                                      ************************");
                System.out.println("\nOptions\n1-View Books\n2-Search any book\n3-Back to main menu\n");
                System.out.println("Enter ur option: ");
                option = input.next();
                if (option.charAt(0) == '3' && option.length()==1){
                    b=false;
                    break;
                }
                switch(option){
                    case "1":
                        if(book.length()>0){
                            BufferedReader a = new BufferedReader(new FileReader(book.getAbsolutePath()));
                            Scanner in = new Scanner(book);
                            System.out.println("                                *************************************");
                            System.out.println("                                           VIEW BOOK SHOP");
                            System.out.println("                                *************************************");
                            System.out.println("==================================================================================================================");
                            System.out.println("BOOK ID\t\tBOOK NAME\tAUTHOR NAME\tBOOK TYPE\tPUBLISHED on\t\tPRICE/BOOK\tQUANTITY");
                            System.out.println("==================================================================================================================");
                            String string = a.readLine();
                            view(book, string, a);
                            in.close();
                        } else{
                            System.out.println("Currently no book was found or added in shop.");
                        }
                        System.out.println("\nIf you want to buy any of these book, add the book in your cart first. ");
                        break;
                    case "2":
                        if(book.length()>0){
                            System.out.println("Enter book id to search: ");
                            int book_id = bookid_valid(book);
                            BufferedReader br = new BufferedReader(new FileReader(book.getAbsolutePath()));
                            String s2 = br.readLine();
                            search_book(book, s2, book_id, br);
                        } else{
                            System.out.println("Currently no book was found or added in shop.");
                        }
                        break;
                    default:
                        System.out.println("Enter correct option.\n");
                        continue;
                }
                System.out.println("");
                b = true;
            }  
        } catch(InputMismatchException e){
            System.out.println("You entered wrong input.");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
    public static File customer_cart(File cart,File book,File buy, File customer) throws IOException{
        /* This is Method is to handle cart of the Customer.
        He can View, Add,Delete and Buy book from the cart.
        It's called when the customer chooses "VIEW AND EDIT YOUR CART" from "Main Menu"
         */
        try {
            Scanner input = new Scanner(System.in);
            String option = "";
            boolean b = true;
            int chk = 0; 
            if(cart.length() != 0){
                chk++; 
            }
            while(b){
                if(cart.length() != 0){
                    chk++; 
                }
                System.out.println("\n\n                                      *************************");
                System.out.println("                                      *************************");
                System.out.println("                                      ****                 ****");
                System.out.println("                                      ****    YOUR CART    ****");
                System.out.println("                                      ****                 ****");
                System.out.println("                                      *************************");
                System.out.println("                                      *************************");
                System.out.println("\nOptions\n1-View your cart.\n2-Add book to cart.\n3-Delete book from cart\n4-Back to main menu\n");
                System.out.println("Enter ur option: ");
                option = input.nextLine();
                if (option.charAt(0) == '4' && option.length()==1){
                    break;
                } else if ((option.charAt(0)=='1') && (chk==0)){
                    System.out.println("Add book in your cart first before viewing.");
                    continue;
                }
                switch(option){
                    case "1":
                        BufferedReader a = new BufferedReader(new FileReader(cart.getAbsolutePath()));
                        if(cart.length()>0){
                            Scanner in = new Scanner(cart);
                            System.out.println("                                *************************************");
                            System.out.println("                                           VIEW YOUR CART");
                            System.out.println("                                *************************************");
                            System.out.println("==================================================================================================================");
                            System.out.println("BOOK ID\t\tBOOK NAME\tAUTHOR NAME\tBOOK TYPE\tPUBLISHED on\t\tPRICE/BOOK\tQUANTITY");
                            System.out.println("==================================================================================================================");
                            String string = a.readLine();
                            view(cart, string, a);
                            in.close();
                            int count = 0, book_price = 0;
                            System.out.println("\n");
                            in = new Scanner(cart);
                            while(in.hasNextLine()){
                                count++;
                                String line = in.nextLine();
                                String[] arr = line.split("\t");
                                book_price += Integer.parseInt(arr[5]) * Integer.parseInt(arr[6]);
                            }
                            in.close();
                            System.out.println("\n\nTotal books in cart: " + count);
                            System.out.println("Total price of books in cart: " + book_price);
                            System.out.println("\n");
                            System.out.println("Want to buy any book? (Y/n) ");
                            String check = input.nextLine();
                            if((check.charAt(0) == 'y' || check.charAt(0) == 'Y') && (check.length() == 1)){
                                buy = buy_book(book, buy, cart,customer);
                            } else{
                                System.out.println("Exited from cart.");
                            }
                        } else{
                            System.out.println("Currently you add no book in the cart.");
                        }
                        break;
                    case "2":
                        if(book.length()>0){
                            System.out.println("\n  BOOK ID\tBOOK NAME");
                            Scanner scan = new Scanner(book);
                            Scanner scan1 = new Scanner(cart);
                            while(scan.hasNextLine()){
                                String line = scan.nextLine();
                                String[] arr = line.split("\t");
                                System.out.println("  " + arr[0] +"\t\t"+ arr[1]);
                            }
                            scan.close();
                            System.out.println("Enter book id you want to add in cart: ");
                            b = true;
                            int check = 0;
                            int check2 = 0;
                            while(b){
                                scan1 = new Scanner(cart);
                                scan = new Scanner(book);
                                int id = check_input();
                                while(scan.hasNextLine()){
                                    String line = scan.nextLine();
                                    String[] arr = line.split("\t");
                                    if(Integer.parseInt(arr[0]) == id){
                                        check = Integer.parseInt(arr[0]);
                                    }
                                } 
                                scan.close();
                                while(scan1.hasNextLine()){
                                    String line1 = scan1.nextLine();
                                    String[] arr1 = line1.split("\t");
                                    if(Integer.parseInt(arr1[0]) == id){
                                        check2 = Integer.parseInt(arr1[0]);
                                    }
                                } 
                                scan1.close();
                                if(check == id && check2 != id) {
                                    String book_id = String.valueOf(id);
                                    addBook_cart(cart, book, book_id);
                                    chk++;
                                    b = false;
                                } else if(check != id){
                                    System.out.println("You enter book Id which was not exist, enter again: ");
                                    b = true;
                                } else if(check == id && check2 == id){
                                    System.out.println("You already add this book in your cart, you cannot add it again.\nPlease Enter book id which was not added in your cart: ");
                                    b = true;
                                }
                            } 
                            scan.close();
                            scan1.close();
                        } else{
                            System.out.println("Currently no book was added or found in shop.");
                        }
                        break;
                    case "3":
                        if(cart.length()>0){
                            System.out.println("Enter book id you want to delete from your cart: ");
                            int book_id = cart_valid(cart);
                            cart = delete_cart(cart, book_id);  
                            System.out.println("Book deleted succesfully from your cart.");
                        }else{
                            System.out.println("Currently you add no book the cart.");
                        }
                        break;
                    default:
                        System.out.println("Enter correct option.");
                        continue;
                }
                System.out.println("");
                b = true;
            } 
        } catch(InputMismatchException e){
            System.out.println("You entered wrong input.");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return cart;
    }
    public static int cart_valid(File cart) throws IOException{
        // Checks Validity of the cart from the file "Cart"
        // It's Called when the Customer wants to delete book from cart
        // Called in the Method "customer_cart"
        int book_id = 0;
        Scanner input = new Scanner(System.in);
        try {
            Scanner scan = new Scanner(cart);
            boolean b = true;
            int check = 0;
            while(b){
                scan = new Scanner(cart);
                book_id = check_input();
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == book_id){
                        check = Integer.parseInt(arr[0]);
                    }
                } 
                scan.close();
                if(check == book_id){
                    b = false;
                } else{
                    System.out.println("You enter book Id " + book_id + " which was not found in your cart, enter your ID again: ");
                    b = true;
                }
            } 
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. ");
        }
        return book_id;
    }
    public static File delete_cart(File cart, int id) throws IOException{
        /*This method is used to delete book from cart this method 
          save every line of cart file in data except that line on
          which deleted book id was found and re-write that data in file.
         */
        File myNewFile = new File("");
        try{
            String filename = cart.getName();
            Scanner scan = new Scanner(cart);
            String data = "";
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.startsWith(String.valueOf(id))){
                    line = "";
                }
                else
                    data += line + "\n";
            }
            scan.close();
            //delete previous file
            cart.delete();
            //create new file with the same name
            myNewFile = new File("./" + filename);
            FileWriter writer = new FileWriter(myNewFile);
            writer.write(data);
            writer.close();
        }catch (IOException e) {
            System.out.print("File not found");
        }
        return myNewFile;
    }
    public static File addBook_cart(File cart,File book, String book_id) throws IOException{
        /* This method is called when customer Chooses "Add book to cart" from Cart Menu.
        It will ask user to enter the quantity of specific book he wants to buy
        then it will add that book in cart if the required quantity of book is available in shop.
         */
        try { 
            Scanner scan = new Scanner(book);
            FileWriter fw = new FileWriter(cart, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String yes = "y";
            int quantity = 0, total_quantity = 0;
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.startsWith(String.valueOf(book_id))){
                    String[] arr = line.split("\t");
                    total_quantity = Integer.parseInt(arr[6]); 
                    if(total_quantity > 0){      
                        bw.write(arr[0] + "\t");
                        bw.write(arr[1] + "\t");
                        bw.write(arr[2] + "\t");
                        bw.write(arr[3] + "\t");
                        bw.write(arr[4] + "\t");
                        bw.write(arr[5] + "\t");
                        System.out.print("\nEnter book quantity you want to add in cart: ");
                        boolean b = true;
                        while(b){
                            quantity = check_input();
                            if(quantity<=total_quantity){
                                bw.write(quantity + "\t");
                                System.out.println("Book added in cart succesfully.\n");
                                b = false;
                            } else{
                            System.out.println("Sorry,there are only " + total_quantity + " quantity of books left in shop,\nyou have to enter less quanity: ");
                                b = true;
                            }
                        }
                        bw.newLine();
                        bw.close();
                    } else{
                        System.out.println("Sorry can't add this book in cart because there are no stock of this book left in shop.");
                    }
                }
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return cart;
    }
    public static File buy_book(File book,File buy,File cart,File customer)throws IOException{
        /* This Method is under customer cart.
        It's called when the customer wants to add a book in his cart
         */
        try {
            Scanner input = new Scanner(System.in);
            boolean b = true;
            int check1 = 0;
            String cus_name = "";
            Scanner scan1 = new Scanner(cart);
            Scanner scan =new Scanner(customer);
            // To confirm the customer ID:
            System.out.println("Enter your UserId to buy book: ");
            while(b){
                scan = new Scanner(customer);
                int cus_id = check_input();
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == cus_id){
                        check1 = Integer.parseInt(arr[0]);
                        cus_name = arr[1];
                    }
                } 
                scan.close();
                if(check1 == cus_id){
                    b = false;
                } else{
                    System.out.println("You enter Id " + cus_id + " which was wrong, enter your ID again: ");
                    b = true;
                }
            } 
            scan.close();
            System.out.println("Enter Book ID you want to buy from your cart:");
            b = true;
            int check2 = 0;
            String book_name = ""; 
            int quantity = 0, total_quantity = 0;
            int price = 0;
            int book_price = 0;
            while(b){
                scan1 = new Scanner(cart);
                int bookid = check_input();
                while(scan1.hasNextLine()){
                    String line = scan1.nextLine();
                    String[] arr = line.split("\t");
                    if(Integer.parseInt(arr[0]) == bookid){
                        check2 = Integer.parseInt(arr[0]);
                        book_name = arr[1];
                        price = Integer.parseInt(arr[5]);
                        total_quantity = Integer.parseInt(arr[6]);
                    }
                } 
                scan1.close();
                if(check2 == bookid){  
                    b = false;
                } else{
                    System.out.println("You enter book Id which was not found in your cart, enter again: ");
                    b = true;
                }
            } 
            scan1.close();
            System.out.println("Enter quantity of book want to buy: ");
            b = true;
            while(b){
                quantity = check_input();
                if(quantity<=total_quantity){
                    book_price = price * quantity;
                    b = false;
                } else{
                    System.out.println("There are only " + total_quantity + " quantity of books you added in your cart,\nyou have to enter less quanity: ");
                    b = true;
                }
            }
            System.out.println("Name of book whose id is " + check2 + ": " + book_name);
            System.out.println("Total price of book with quantity " + quantity + " is: " + book_price);
            System.out.println("Want to buy this book? (Y/n)");
            String check = input.nextLine();
            if((check.charAt(0) == 'y' || check.charAt(0) == 'Y') && (check.length() == 1)){
                Scanner scan2 = new Scanner(book);
                FileWriter fw = new FileWriter(buy, true);
                BufferedWriter bw = new BufferedWriter(fw);         
                bw.write(check1 + "\t");
                bw.write(cus_name + "\t");
                bw.write(check2 + "\t");
                bw.write(book_name + "\t");
                bw.write(book_price + "\t");
                bw.write(quantity + "\t");
                scan2.close();
                bw.newLine();
                bw.close();
                //prints when the book is successfully buy.
                System.out.println("You buy the book succesfully and back to cart section.\n");
                cart = delete_cart(cart, check2); 
                update_quantity(book, check2, quantity);
            } else{
                System.out.println("Exited from Buy section and back to cart section without buying.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return buy;
    }
    public static File customer_data(File customer)throws IOException{
        /* This method is called When customer chooses "VIEW AND EDIT YOUR DATA" From Main Menu.
        He can view & update his data.
         */
        try {
            Scanner input = new Scanner(System.in);
            boolean b = true;
            int cus_id = 0;
            while(b){
                System.out.println("\n\n                                      *************************");
                System.out.println("                                      *************************");
                System.out.println("                                      ****                 ****");
                System.out.println("                                      ****    YOUR DATA    ****");
                System.out.println("                                      ****                 ****");
                System.out.println("                                      *************************");
                System.out.println("                                      *************************");
                System.out.println("\nOptions\n1-View your data\n2-Update your data\n3-Back to main menu\nChoose option: ");
                String choice = input.next();
                if(choice.charAt(0) == '3' && choice.length() == 1){
                    break;
                }
                switch (choice) {
                    case "1":
                        System.out.println("Enter your UserId to view your data data: ");
                        cus_id = cusid_valid(customer);
                        BufferedReader br = new BufferedReader(new FileReader(customer.getAbsolutePath()));
                        String s2 = br.readLine();
                        search_customer(customer, s2, cus_id, br);
                        break;
                    case "2":
                        // If the Customer chooses "2" this is will call the Method "update_customer"
                        System.out.println("Enter your UserId to update data: ");
                        cus_id = cusid_valid(customer);
                        customer = update_customer(customer, cus_id);
                        break;
                    default:
                        System.out.println("Enter correct choice.");
                        continue;
                }
                b = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return customer;
    }
    public static String book_type(){
        /* This is used when the admin wants to add a new book and to add book type, this method will be called
        It will show different book type from which admin can choose the type of book he is adding.
         */
        Scanner input = new Scanner(System.in);
        String type = "";
        boolean b = true;
        System.out.println("\nBook type:-\n1-Informational(Study)\t2-Adventure story\t3-Novel");
        System.out.println("4-Crime book\t        5-Children story\t6-Science friction");
        System.out.println("7-Historical story\t8-Horror story\t        9-Mystery story");
        System.out.println("10-Poetry book          11-Someone biography\t12-Other\nChoose book type: ");
        while (b) {
            int option = check_input();
            if(option >= 1 && option <=11){
                switch(option){
                    case 1:
                        type = "Study";
                        b = false;
                        break;
                    case 2:
                        type = "Adventure";
                        b = false;
                        break;
                    case 3:
                        type = "Novel";
                        b = false;
                        break;
                    case 4:
                        type = "Crime";
                        b = false;
                        break;
                    case 5:
                        type = "Story";
                        b = false;
                        break;
                    case 6:
                        type = "Science";
                        b = false;
                        break;
                    case 7:
                        type = "History";
                        b = false;
                        break;
                    case 8:
                        type = "Horror";
                        b = false;
                        break;
                    case 9:
                        type = "Mystry";
                        b = false;
                        break;
                    case 10:
                        type = "Poetry";
                        b = false;
                        break;
                    case 11:
                        type = "Bio";
                        b = false;
                        break;
                }
            } else if(option == 12){
                System.out.println("Enter book type: ");
                type = check_string();
                b = false;
            }else{
                System.out.println("choose correct type, enter again: ");
                b = true; 
            }
        }
        return type;
    }
    public static int check_input(){
        /* This Method is Using at Various places when the program needs to get input from User
           (In Integer Only)
           It will kept on taking input until user enters interger value */
        Scanner input = new Scanner(System.in);
        String string;
        boolean check=true;
        int number = 0;
        do{
            string = input.next();
            try{
                number = Integer.parseInt(string);
                break;
            } catch(NumberFormatException e){
                System.out.print("You enter wrong input, Enter correct: ");
                check = true;
            }
        }while(check);
        check = true;
        while(check){
            if(number >=1){
                check = false; 
            } else{
                System.out.println("You entered wrong number,\nEnter again: ");
                number = check_input();
                check = true;
            }
        } 
        return number;
    }
    public static String check_gender(){
        /* Method that is called where we asks user to enter his Gender. (In Add-Customer)
         */
        Scanner input = new Scanner(System.in);
        boolean b = true;
        String gender = "";
        //Give Options to choose his gender:
        System.out.println("Options:-\n1.MALE\n2.FEMALE\n3.OTHER\nChoose option:");
        while(b){
            String option = input.nextLine();
            if (option.charAt(0) == '1' && option.length() == 1){
                gender = "Male"; 
                b = false;
            } else if (option.charAt(0) == '2' && option.length() == 1){
                gender = "Female"; 
                b = false;
            } else if (option.charAt(0) == '3' && option.length() == 1){
                gender = "Other"; 
                b = false;
            } else{
                System.out.println("Choose correct option: ");
                b = true;
            } 
        } 
        return gender;
    }
    public static String check_string(){
        /* This Method is Using at Various places when the program needs to get input from User
           (In String Only)
           It will kept on taking input until user enters String value */
        Scanner input = new Scanner(System.in);
        int count = 0;
        String string = input.nextLine();
		boolean check = true;
		while(check){
			count = 0;
			for (int i = 0; i < string.length(); i++){
				if ((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') || (string.charAt(i)>='a' && string.charAt(i)<='z') || (string.charAt(i) == ' ') || (string.charAt(i) == '.')){
					count++;
				}
			} 
			if (count != string.length()){
				System.out.println("You entered wrong input, Enter again: ");
				string = input.nextLine();
				check = true;
			} else{
				check = false;
			}
		}
		return string;
    }
    public static String check_date(){
        //Method to check weather the user enters correct date or not
        Scanner input = new Scanner(System.in);
	    String publishDate;
		int date,month,year,count;
	    System.out.println("Enter the Date (MM/DD/YYYY): ");
		while(true)	{
			publishDate = input.nextLine();
            //Checks the format of Date:
			if (!(publishDate.length() == 10 && publishDate.charAt(2) == '/' && publishDate.charAt(5) == '/')){
				System.out.println("You entered the date in wrong format, enter again(MM/DD/YYYY): ");
				continue;
			} else{
			    count = 0;
			    for(int i =0; i < publishDate.length(); i++){
				    if (!(Character.isDigit(publishDate.charAt(i)))){
					    if (i == 2 || i == 5){
					    	continue;	
                        }
					    System.out.println("You entered the date in wrong format, enter again(MM/DD/YYYY): ");
					    count++;
					    break;	
                    }
				}
				if (count != 0){
					continue;
            	}
			}
		    date = Integer.parseInt(publishDate.substring(3,5));
		    month = Integer.parseInt(publishDate.substring(0,2));
		    year = Integer.parseInt(publishDate.substring(6,10));
            //checks the correct month:
            if (month > 12 || month <= 0){
				System.out.println("You entered the wrong month, enter again(MM/DD/YYYY): ");
				continue;	
            }
            //checks the days if user enters (2)feb month:
			if (month == 2){
				if (date > 29 || date <= 0){
					System.out.println("You entered the wrong date of Month " + month + ", enter again(MM/DD/YYYY): ");	
					continue;		
                }
                //checks the correct days:
            } if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
				if (date > 31 || date <= 0){
					System.out.println("You entered the wrong date of Month " + month + ", enter again(MM/DD/YYYY): ");	
					continue;		
                }
                //checks the correct days:
			} if (month == 4 || month == 6 || month == 9 || month == 11){
				if (date > 30 || date <= 0){
					System.out.println("You entered the wrong date of Month " + month + ", enter again(MM/DD/YYYY): ");
					continue;		
                }
                //checks the correct Years:
			} if (year > 2023 || year < 1925){
				System.out.println("You entered the wrong year, enter again(MM/DD/YYYY): ");
				continue;	
            }
				break;
		}
        return publishDate;
    }
    public static String check_email(){
        /* method to check weather the User entered email is correct or not.
        Called in "Add_customer & update customer"
        Will only be true if user enters email which is ending with "@gmail.com"
         */
        Scanner input = new Scanner(System.in);
		String string = "";
		boolean check = true;
		while(check){
			//System.out.println("Enter email: ");
        	string = input.nextLine();
			if(string.endsWith("@gmail.com")) {
				check = false;
			} else {
				System.out.println("You enter wrong email,Enter again: ");
				check = true;
			} 
		}	
		return string;	
	}
    public static String check_mobNo(){
        /* Method to get correct Phone Number from user:
            Called in "Add_customer & update customer"
            Will only be true if user enters phone which is of 12 digits
            and contains hyphen at 4th index        */
        Scanner input = new Scanner(System.in);
        String phoneNo = " ";
        int number = 0;
        boolean b = true;
        while(b) {
            phoneNo = input.nextLine();
            if((phoneNo.length()==12) && (phoneNo.charAt(4) == '-')){
                b = false;
            } else {
                System.out.println("Enter Phone Number again in format(0000-0000000): ");
                b = true;
            }
            }
        return phoneNo;
    }
    public static String address(){
        /* Method to get address from user:
        Called in add_Cutomer
         */
        System.out.println("Enter House Number: ");
        int house = check_input();
        System.out.println("Enter Street Number: ");
        int street = check_input();
        System.out.println("Enter your sector: ");
        String sector = check_address();
        System.out.println("Enter Town/Area name: ");
        String town = check_address();
        System.out.println("Enter City name: ");
        String city = check_string();
        String string = "H no." + house + " St." + street + " Sec: " + sector + " " + town + "," + city + ".";
        return string;
    }
    public static String check_address(){
        Scanner input = new Scanner(System.in);
        int count = 0;
        String string = input.nextLine();
        boolean check = true;
        while(check){
            count = 0;
            for (int i = 0; i < string.length(); i++){
                if ((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') || (string.charAt(i)>='a' && string.charAt(i)<='z') || (string.charAt(i) == ' ' 
                || string.charAt(i) == '-' || string.charAt(i) == '.' || string.charAt(i) == '/') || (string.charAt(i) >= '0' && string.charAt(i) <= '9')){
                    count++;
                }
            } 
            if (count != string.length()){
                System.out.println("You can use only('-', '.', '/') while entering, Enter again: ");
                string = input.nextLine();
                check = true;
            } else{
                check = false;
            }
        }
    return string;
    }
}