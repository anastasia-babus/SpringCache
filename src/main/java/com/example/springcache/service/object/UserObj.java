package com.example.springcache.service.object;

import com.example.springcache.repository.User;
import lombok.Data;

@Data
public class UserObj {
    private Long id;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String address;

    public boolean testMethod(){
        return true;
    }
    public static User userObjToUser(UserObj userObj){
        User user = new User();
        user.setId(userObj.getId());
        user.setFirstName(userObj.getFirstName());
        user.setLastName(userObj.getLastName());
        user.setDateOfBirth(userObj.getDateOfBirth());
        user.setAddress(userObj.getAddress());
        return user;
    }

    public static UserObj userToUserObj(User user){
        UserObj userObj = new UserObj();
        userObj.setId(user.getId());
        userObj.setFirstName(user.getFirstName());
        userObj.setLastName(user.getLastName());
        userObj.setDateOfBirth(user.getDateOfBirth());
        userObj.setAddress(user.getAddress());
        return userObj;
    }

}
