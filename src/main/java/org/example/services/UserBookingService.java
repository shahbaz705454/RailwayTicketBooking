package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;
import org.example.entities.User;
import org.example.util.UserServiceUtil;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private  User user;



    private List<User> userList ;
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<User> getUserList() {
        return userList;
    }

    private static final String USER_PATH ="app/src/main/java/org/example/localDb/users.json";



    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        File users = new File(USER_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
        });



    }

    public UserBookingService() throws IOException {
        File users = new File(USER_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
        });


    }



    public boolean loginUser (){
        Optional<User> foundUser = userList.stream().filter(user1 ->{
            return  user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword());
        }).findFirst();
       return foundUser.isPresent();
    }

    public boolean signUp(User user1){
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE ;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }


    private void saveUserListToFile() throws IOException{
        File userFile = new File(USER_PATH);
        objectMapper.writeValue(userFile,userList);
    }


//    Json--> Object (User)--> Deserialization
//    Object (User)=-->Json --> Serialization



    public void fetchBooking(){
        user.printTickets();
    }

    public Boolean cancelBooking(String tickedId){
//        todo:
        return Boolean.FALSE;
    }




}
