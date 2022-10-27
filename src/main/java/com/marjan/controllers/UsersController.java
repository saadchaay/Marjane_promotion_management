package com.marjan.controllers;

import com.marjan.dao.UsersDao;
import com.marjan.entities.Users;
import com.marjan.helpers.EnumValues;
import com.marjan.helpers.Hash;
import com.marjan.helpers.SendMail;

import java.util.List;
import java.util.Objects;

public class UsersController {

    private static final UsersDao usersDao = new UsersDao();
//    private final Users user = new Users();

    public static Boolean addUser(String role, String email, String password, Long storeId){
        List<Users> users = usersDao.all();
        if(checkEmailExists(users, email)){
            return null;
        } else {
            for (Users user: users){
                if(Objects.equals(role, EnumValues.role.ADMIN.toString()) && user.getStoreId() == storeId)
                    return null;
            }
            Users newUser = new Users();
            newUser.setEmail(email);
            newUser.setPassword(Hash.getHashedPassword(password));
            newUser.setStoreId(Math.toIntExact(storeId));
            newUser.setRole(role);
            // sending email .....
            SendMail.sendAccountInfos(email, customMessage(email, password));
            return usersDao.save(newUser) != null;
        }
    }

    public static Boolean checkEmailExists(List<Users> users, String email){
        for (Users user: users){
            if (Objects.equals(email, user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public static String customMessage(String email, String password){
        return  "Well, your account has created successfully. \n" +
                "\n\tAccount information to login: \n\n" +
                "\t\tEmail:   "+ email + "\n\t\tPassword:   " + password + "\n\n\nMarjan Service.\nThanks.";
    }
}
