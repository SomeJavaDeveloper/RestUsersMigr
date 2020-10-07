package ru.users.restusers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserTestData {

    public static final User USER1 = new User(
                    1L,
                    "John",
                    "Smith",
                    LocalDate.of(1991, 10, 3),
                    "JohnnS91",
                    "123456789",
                    "Some guy named Smith",
                    "Some house in Chicago");

    public static final User USER2 = new User(
            2L,
            "Jack",
            "Anderson",
            LocalDate.of(1998, 7, 21),
            "xx_JaAn",
            "asdfg",
            "Some guy named Jack",
            "Some house in Colorado");

    public static final List<User> USERS = Arrays.asList(USER1, USER2);

    public static User getNew() {
        return new User(
                "Arthur",
                "Winston",
                LocalDate.of(2000, 2, 11),
                "BlueW00",
                "qwerty",
                "Some guy named Arthur",
                "Some house in California");
    }

    public static User getUpdated() {
        return new User(
                1L,
                "John 2",
                "Smith",
                LocalDate.of(1991, 10, 3),
                "JohnnS91",
                "123456789",
                "Some guy named Smith 2",
                "Some house in New York");
    }
}
