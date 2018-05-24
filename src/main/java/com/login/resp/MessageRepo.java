package com.login.resp;

import com.login.domain.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by X1z on 23.05.2018.
 */
public interface MessageRepo extends CrudRepository<Message, Long> {

}
