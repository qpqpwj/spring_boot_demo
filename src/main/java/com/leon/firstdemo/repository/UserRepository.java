package com.leon.firstdemo.repository;

import com.leon.firstdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ${DESCRIPTION}
 *
 * @author jian.wang03@owitho.com
 * @create 2018-04-02 下午4:25
 * ${DESCRIPTION}
 **/
@Repository
public class UserRepository {

    private ConcurrentMap<Integer , User> repository = new ConcurrentHashMap<Integer , User>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * @param user
     * @return
     */
    public boolean save(User user){
        Integer id = idGenerator.getAndIncrement();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    /**
     * @param
     * @return
     */
    public Collection<User> findAll(){
        return repository.values();
    }

}
