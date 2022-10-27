package com.marjan.controllers;

import com.marjan.dao.UsersDao;
import com.marjan.entities.Users;
import com.marjan.helpers.EnumValues;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersControllerTest {

    private final Users user ;

    public UsersControllerTest() {
        user = new Users();
    }

    @Test
    void addUserRoleManager(){
        user.setRole(EnumValues.role.MANAGER.toString());
        user.setEmail("saadchaay27@gmail.com");
        user.setPassword("saad1234");
        user.setStoreId(2);
        assertNotNull(UsersController.addUser(user.getRole(),
                user.getEmail(),
                user.getPassword(),
                (long) user.getStoreId()));
    }

    @Test
    void addUserRoleAdmin(){
        user.setRole(EnumValues.role.ADMIN.toString());
        user.setEmail("chaaysaad@gmail.com");
        user.setPassword("saad1234");
        user.setStoreId(3);
        assertNotNull(UsersController.addUser(user.getRole(),
                user.getEmail(),
                user.getPassword(),
                (long) user.getStoreId()));
    }

    @Test
    void listAllUsers(){
        assertNotNull(new UsersDao().all());
    }

    @Test
    void getTheFirstUserRole(){
        assertEquals("MANAGER", new UsersDao().all().get(0).getRole());
    }

}