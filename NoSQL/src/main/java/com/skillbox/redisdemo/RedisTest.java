package com.skillbox.redisdemo;

import org.redisson.api.RScoredSortedSet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class RedisTest {


    // Всего на сайте зарегистрировалось 20 пользователей
    private static final int USERS = 20;

    // Также мы добавим задержку между посещениями
    private static final int SLEEP = 100; // 100 миллисекунд


    private static void log(Integer user) {
        String log = String.format("— На главной странице показываем пользователя " + user);
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        // регистрируем пользователей

        for (int user = 0; user < USERS; user++) {
            redis.registrVisit(user);

        }

        // получили отсортированный список
        RScoredSortedSet<Integer> registerUsers = redis.getRegisterUsers();

        while (true) {
            //получаем значение ПЕРВОГО пользователя
            int firstUser = registerUsers.first();
            //получаем оценку ПЕРВОГО пользователя
            double scoreUser = registerUsers.firstScore();
            log(firstUser);
            registerUsers.remove(firstUser);
            registerUsers.add(scoreUser + 0.1, firstUser);

            if (new Random().nextInt(10) == 1) {
                int paidUser = new Random().nextInt(20);
                out.println("> Пользователь " + paidUser + " оплатил платную услугу ");
                log(paidUser);
                double scorePaidUser = registerUsers.getScore(paidUser);
                registerUsers.remove(paidUser);
                registerUsers.add(scorePaidUser + 0.1, paidUser);

            }

            Thread.sleep(SLEEP);

        }
    }

}