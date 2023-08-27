import java.util.Scanner;

class dept {
    private static final int TOTAL_SUBJECTS = 4;
    private static final int NUM_STUDENTS = 1;
    private static final int int_Ext_Assign = 3;
    private int total = 0;
    private String[] names;
    private int[] sum;
    private int[][][] marks;
    private String[] typesOfMarks = { "Internal Marks", "Assignment", "External Marks" };
    private String[] subjects = { "Java", "DBMS", " SE ", " AI " };
    private static String username = "kulkarnishrinivas2001@gmail.com";
    private static String password = "Shri@123";

    dept() {
        names = new String[NUM_STUDENTS];
        marks = new int[NUM_STUDENTS][TOTAL_SUBJECTS][int_Ext_Assign];
        sum = new int[NUM_STUDENTS];
    }

    Scanner scanner = new Scanner(System.in);

    public boolean process() {
        try {
            System.out.println("----------------Login----------------");
            System.out.print("Enter Username : ");
            String user = scanner.next();
            System.out.print("\nEnter Username : ");
            String pass = scanner.next();
            if (user.equals(username) && pass.equals(password)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < NUM_STUDENTS; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Name: ");
                names[i] = scanner.nextLine();
                for (int j = 0; j < TOTAL_SUBJECTS; j++) {
                    System.out.print("\nEnter marks for subject " + subjects[j] + ": ");
                    for (int k = 0; k < int_Ext_Assign; k++) {
                        System.out.print("\n" + typesOfMarks[k] + ": ");
                        marks[i][j][k] = scanner.nextInt();
                    }
                }
                scanner.nextLine();
            }
            scanner.close();
        }
    }

    public void display() {
        System.out.print(
                "\n\n-------------------------------------------Students Mark Sheet--------------------------------------------------\n\n");
        System.out.print(
                "\n\n-------------------------------------------------------------------------------------------------------------\n");
        System.out.printf(
                "|  USN \t|  Student Name    \t|  Subject\t|    Internal\t|  Assignment\t|  External\t|   Total   |\n");
        System.out.print(
                "-------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < subjects.length; j++) {
                // System.out.printf("\n %d \t| %s \t| %s ",i,names[i],subjects[j]);
                System.out.printf("|   %d  \t|  %s  \t|     %s  ", (i + 1), names[i], subjects[j]);
                for (int k = 0; k < int_Ext_Assign; k++) {
                    System.out.printf("    |   \t%d  ", marks[i][j][k]);
                    total += marks[i][j][k];
                }
                sum[i] = total;
                System.out.printf("    |     %d    |\n", sum[i]);
                total = 0;
                System.out.print(
                        "-------------------------------------------------------------------------------------------------------------\n");
            }
        }
        System.out.println("\n");
    }

    public void calculate() {
        System.out.println("\nResults:");
        for (int i = 0; i < NUM_STUDENTS; i++) {
            int totalMarks = 0;
            for (int j = 0; j < TOTAL_SUBJECTS; j++) {
                for (int k = 0; k < typesOfMarks.length; k++) {
                    totalMarks += marks[i][j][k];
                }
            }

            double average = totalMarks / (double) TOTAL_SUBJECTS;
            String result = getResult(average);

            System.out.println(names[i] + ": " + result);
        }
    }

    private String getResult(double average) {
        if (average > 80) {
            return "Distinction";
        } else if (average > 60) {
            return "First class";
        } else if (average > 50) {
            return "Second class";
        } else if (average > 40) {
            return "Third class";
        } else {
            return "Fail";
        }
    }

}

public class Department extends dept {
    public static void main(String[] args) {
        dept d1 = new dept();
        boolean trial = true;
        while (trial) {
            boolean permision = d1.process();
            if (permision) {
                d1.input();
                d1.calculate();
            } else {
                System.out.println("Access denied..! login again..!");
            }
            // d1.display();
        }
    }
}
