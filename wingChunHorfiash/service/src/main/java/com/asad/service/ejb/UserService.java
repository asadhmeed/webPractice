package com.asad.service.ejb;

import javax.ejb.Local;
import com.asad.service.UserEntity;

@Local
public interface UserService {

	UserEntity addUser(String userName, String email, String password, boolean emailIsConfirmed);

	UserEntity findUserByEmail(String email, String password);

	UserEntity findUserByUserName(String userName, String password);

	boolean removeUser(UserEntity user);

}