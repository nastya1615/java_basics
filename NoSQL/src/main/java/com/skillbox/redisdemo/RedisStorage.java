package com.skillbox.redisdemo;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Date;

import static java.lang.System.out;

public class RedisStorage {

    // переменная redissonClient инициализируется как клиент Redis, 
    // который используется для выполнения операций на Redis-сервере
    private RedissonClient redisson;

    // Объект для работы с ключами
    private RKeys rKeys;

    // RScoredSortedSet объектом, который представляет собой упорядоченное множество
    // с числовыми оценками (рейтингом, Score),
    // связанными с каждым элементом и по которым элементы сортируются
    private RScoredSortedSet<Integer> registerUsers;

    //ключ для создания этого множества
    private final static String KEY = "USERS";

    //Метод getTimeStamp(), где мы будем получать текущую метку времени,
    // которую в дальнейшем будем использовать в качестве рейтинга (Score) в нашем множестве RScoredSortedSet
    private double getTs() {
        return new Date().getTime() / 1000;
    }


    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        registerUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }


    // Регистрирует пользователей на сайте
    //getTS - рейтинг пользователя, по которому происходит сортировка
    //user_id -id клиента


    void registrVisit(int user_id)
    {
        //ZADD ONLINE_USERS
        registerUsers.add(getTs(),user_id);
    }

    public RScoredSortedSet<Integer> getRegisterUsers() {
        return registerUsers;
    }

//    // Удаляет
//    void deleteOldEntries(int usersIndex)
//    {
//        //ZREVRANGEBYSCORE ONLINE_USERS 0 <time_5_seconds_ago>
//        registerUsers.remove(usersIndex);
//    }
//
//   Integer showLastUserAdded()
//    {
//        //ZCOUNT ONLINE_USERS
//        return registerUsers.readAll();
//    }
}
