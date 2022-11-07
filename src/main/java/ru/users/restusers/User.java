package ru.users.restusers;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    public User() {
    }

    public User(@NotBlank(message = "Имя не может быть пустым") String name,
                @NotBlank(message = "Фамилия не может быть пустой") String surname,
                @NotBlank(message = "Логин не может быть пустым") String login,
                @NotBlank(message = "Пароль не может быть пустым") String password,
                @NotBlank(message = "Описание не может быть пустым") String description,
                @NotBlank(message = "Адрес не может быть пустым") String address) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.description = description;
        this.address = address;
    }

    public User(Long id,
                @NotBlank(message = "Имя не может быть пустым") String name,
                @NotBlank(message = "Фамилия не может быть пустой") String surname,
                @NotBlank(message = "Логин не может быть пустым") String login,
                @NotBlank(message = "Пароль не может быть пустым") String password,
                @NotBlank(message = "Описание не может быть пустым") String description,
                @NotBlank(message = "Адрес не может быть пустым") String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.description = description;
        this.address = address;
    }
}
