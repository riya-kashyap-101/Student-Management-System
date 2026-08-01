package org.example.main;

import org.example.dao.StudentDao;
import org.example.model.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:

                    sc.nextLine();   // Buffer clear karega

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    Student student = new Student(0, name, email, course, age);

                    studentDao.addStudent(student);

                    break;
                case 2:
                    studentDao.getAllStudents();
                    break;
                case 3:

                    System.out.println("Enter Student ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter newCourse : ");
                    String newCourse = sc.nextLine();

                    System.out.println("Enter newAge : ");
                    int newAge = sc.nextInt();

                    studentDao.updateStudent(id,newCourse,newAge);
                    break;
                case 4:
                    System.out.println("Enter Student ID : ");
                    int DeleteId = sc.nextInt();

                    studentDao.dltStudent(DeleteId);

                    break;
                case 5:
                    System.out.println("Thank you");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;

            }
        }

    }
}