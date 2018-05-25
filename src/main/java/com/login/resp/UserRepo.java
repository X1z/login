package com.login.resp;

import com.login.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by X1z on 24.05.2018.
 */
public interface UserRepo extends CrudRepository<User, Long> {

}
