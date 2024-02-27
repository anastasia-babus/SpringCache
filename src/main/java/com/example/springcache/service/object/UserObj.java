package com.example.springcache.service.object;

import com.example.springcache.repository.User;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserObj /*implements Serializable*/ {

//    @Serial
//    private static final long serialVersionUID = 8834133477714255084L;

    private Long id;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String address;

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
