import java.util.Scanner;

public class Marks{
    public static void main(String[] args){

        System.out.print("Enter number of student: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        int[][] marks = new int[noOfStudents][3];
        String[] subjectName = {"Mathematics", "Chemistry", "Physics"};
        for(int studentID = 0; studentID < noOfStudents; studentID++){
            for(int subjectID = 0; subjectID < 3; subjectID++){
                System.out.print("Enter marks for " + subjectName[subjectID] + " of student " + (studentID+1) + ": ");
                marks[studentID][subjectID] = scanner.nextInt();
            }
        }
        scanner.nextLine();

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Get average for a subject");
            System.out.println("2. Get average for a student");
            System.out.println("3. Get total marks for a student");
            System.out.println("4. Display grades");
            System.out.println("5. Exit");
            System.out.print("Enter your choice(1-5): ");
            int choice = scanner.nextInt();

            if(choice == 5){
                break;
            }


            switch(choice){
                case 1:
                    System.out.print("Enter Subject ID (1-Math, 2-Chemistry, 3-Physics): ");
                    int subjectID = scanner.nextInt() - 1;
                    if(subjectID >= 0 && subjectID < 3){
                        double sum_s = 0;
                        for(int i = 0; i < noOfStudents; i++){
                            sum_s += marks[i][subjectID];
                        }
                        double average_s = sum_s / noOfStudents;
                        System.out.println("Average for " + subjectName[subjectID] + ": " + average_s);
                    }
                    else{
                        System.out.println("Invalid subject ID.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID(1 to " + noOfStudents + "): ");
                    int studentID = scanner.nextInt() - 1;
                    if(studentID >= 0 && studentID < noOfStudents){
                        double sum = 0;
                        for(int i = 0; i < 3; i++){
                            sum += marks[studentID][i];
                        }
                        double average = sum / 3;
                        System.out.println("Average for Student " + (studentID + 1) + ": " + average);
                    }
                    else{
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID (1 to " + noOfStudents + "): ");
                    int totalID = scanner.nextInt() - 1;
                    if(totalID >= 0 && totalID < noOfStudents){
                        int total = 0;
                        for(int i = 0; i < 3; i++){
                            total += marks[totalID][i];
                        }
                        System.out.println("Total marks for Student " + (totalID + 1) + ": " + total);
                    }
                    else{
                        System.out.println("Invalid student ID.");
                    }
                    break;
                case 4:
                    System.out.println("\nStudent Grades:");
                    System.out.printf("%-10s%-15s%-15s%-15s%n", "Student", "Mathematics", "Chemistry", "Physics");
                    for(int i = 0; i < noOfStudents; i++){
                        System.out.printf("%-10s", "Student " + (i + 1));
                        for(int j = 0; j < 3; j++){
                            String grade;
                            if(marks[i][j] >= 90){
                                grade = "Grade A";
                            }
                            else if(marks[i][j] >= 80){
                                grade = "Grade B";
                            }
                            else if(marks[i][j] >= 70){
                                grade = "Grade C";
                            }
                            else if(marks[i][j] >= 60){
                                grade = "Grade D";
                            }
                            else{
                                grade = "Fail";
                            }
                            System.out.printf("%-15s", grade);
                        }
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }
        scanner.close();
    }
}
