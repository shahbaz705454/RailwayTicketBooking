package org.example;

import org.example.entities.User;
import org.example.services.UserBookingService;
import org.example.util.UserServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        System.out.println("Running Train Booking System....");
        Scanner sc = new Scanner(System.in);

        int option = 0;

        UserBookingService userBookingService;

        try{

            userBookingService = new UserBookingService();

        }catch (Exception ex){
            System.out.println("There is Something Wrong...");
            System.out.println(ex.getMessage());
            return;
        }

        while(option!=7){
            System.out.println("Choose Your Options");
            System.out.println("1. SignUp");
            System.out.println("2. Login");
            System.out.println("3. Fetch bookings");
            System.out.println("4. Search Train");
            System.out.println("5. Book a Seat");
            System.out.println("6. Cancel My Booking");
            System.out.println("7. Exit The App");
            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter The UserName to Signup");
                    String nameToSignUp = sc.next();
                    System.out.println("Enter the Password To Signup");
                    String passwordToSignup = sc.next();
                    User userToSignup = new User(nameToSignUp,passwordToSignup, UserServiceUtil.hashPassword(passwordToSignup),
                            new ArrayList<>(), UUID.randomUUID().toString());
                    userBookingService.signUp(userToSignup);
                    break;
                case 2:
                    System.out.println("Enter the userName to Login");
                    String nametoLogin = sc.next();
                    System.out.println("Enter the Password to Signup");
                    String passwordToLogin = sc.next();
                    User userToLogin = new User(nametoLogin,passwordToLogin,
                            UserServiceUtil.hashPassword(passwordToLogin),
                            new ArrayList<>(),UUID.randomUUID().toString());
                    try{
                        userBookingService = new UserBookingService(userToLogin);

                    }catch (IOException ex) {
                        System.out.println("SomeThing Wrong while Login...");
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Fetching Your Booking Details...");
                    userBookingService.fetchBooking();
                    break;
                case 4:


            }

        }




    }
}