import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===Welcome to the Person Information App===");
        System.out.println("Please enter the following information:\n");

        Person person = new Person();

        // Input and validation for First Name
        System.out.print("First Name: ");
        while (true) {
            try {
                String firstName = scanner.nextLine();
                if (isString(firstName)) {
                    person.setFirstName(firstName);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid string for First Name.");
                    System.out.print("First Name: ");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Input and validation for Middle Name
        System.out.print("Middle Name: ");
        while (true) {
            try {
                String middleName = scanner.nextLine();
                if (isString(middleName)) {
                    person.setMiddleName(middleName);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid string for Middle Name.");
                    System.out.print("Middle Name: ");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Input and validation for Last Name
        System.out.print("Last Name: ");
        while (true) {
            try {
                String lastName = scanner.nextLine();
                if (isString(lastName)) {
                    person.setLastName(lastName);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid string for Last Name.");
                    System.out.print("Last Name: ");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        String birthdayInput;
        do {
            System.out.print("Birthday (yyyy/mm/dd): ");
            birthdayInput = scanner.nextLine();
        } while (!isValidBirthday(birthdayInput));

        person.setBirthday(birthdayInput);
        int age = calculateAge(birthdayInput);
        person.setAge(age);
        System.out.print("Age: " + person.getAge() + "\n");

        System.out.print("Address: ");
        person.setAddress(scanner.nextLine());

        // Display the entered information
        System.out.println("Personal Information:");
        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Middle Name: " + person.getMiddleName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Birthday: " + person.getBirthday());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());

        scanner.close();
    }

    public static boolean isValidBirthday(String birthday) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthday);
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid birthday format. Please use yyyy/mm/dd.");
            return false;
        }
    }

    public static int calculateAge(String birthday) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthDate = null;
        try {
            birthDate = dateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (birthDate != null) {
            Date currentDate = new Date();
            long ageInMillis = currentDate.getTime() - birthDate.getTime();
            return (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365.25));
        }
        return 0;
    }
    
    public static boolean isString(String str) {
        return str.matches("[a-z A-Z]+");
    }
}
