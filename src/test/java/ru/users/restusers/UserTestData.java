package ru.users.restusers;

import java.time.LocalDate;

public class UserTestData {

    public static final User USER1 = new User(
                    1L,
                    "John",
                    "Smith",
                    "JohnnS91",
                    "123456789",
                    "Some guy named Smith",
                    "Some house in Chicago");

    public static final User USER2 = new User(
            2L,
            "Jack",
            "Anderson",
            "xx_JaAn",
            "asdfg",
            "Some guy named Jack",
            "Some house in Colorado");

    public static User getNew() {
        return new User(
                "Arthur",
                "Winston",
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
                "JohnnS91",
                "123456789",
                "Some guy named Smith 2",
                "Some house in New York");
    }
}
