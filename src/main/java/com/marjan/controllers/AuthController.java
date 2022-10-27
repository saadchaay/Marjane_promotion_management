package com.marjan.controllers;

import com.marjan.dao.AdminDao;
import com.marjan.dao.UsersDao;
import com.marjan.entities.SupAdmin;
import com.marjan.entities.Users;
import com.marjan.helpers.Hash;

import java.util.Objects;

public class AuthController {

    public static SupAdmin isAdminAuth(String username, String password){
        for (SupAdmin admin: new AdminDao().all()){
            if(Objects.equals(admin.getUsername(), username) && Hash.verifiedPassword(admin.getPassword(), password)){
                return admin;
            }
        }
        return null;
    }
    public static Users isUserAuth(String email, String password){
        for (Users user: new UsersDao().all()){
            if(Objects.equals(user.getEmail(), email) && Hash.verifiedPassword(user.getPassword(), password)){
                return user;
            }
        }
        return null;
    }
}
