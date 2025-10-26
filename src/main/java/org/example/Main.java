package org.example;

import org.example.entities.User;
import org.example.services.UserBookingService;

public class Main {

    public static void main(String[] args) {

        User u2 = new User();


        try
        {
            UserBookingService u1 = new UserBookingService(u2);

            System.out.println(u1.getUserList());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}