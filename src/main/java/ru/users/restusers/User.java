package ru.users.restusers;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "Фамилия не может быть пустой")
    private String surname;

    @Column(name = "birth_date", nullable = false)
    @NotNull(message = "Дата рождения не может быть пустой")
    @PastOrPresent(message = "Дата рождения указана неверно")
    private LocalDate localDate;

    @Column(name = "login", nullable = false)
    @Size(max = 20, message = "Логин должен содержать менее 20 символов")
    @NotBlank(message = "Логин не может быть пустым")
    private String login;

    @Column(name = "password", nullable = false)
    @Size(min = 5, max = 100, message = "Пароль должен содержать от 5 до 100 символов")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @Column(name = "description", nullable = false)
    @Size(max = 300, message = "Описание должно содержать менее 300 символов")
    @NotBlank(message = "Описание не может быть пустым")
    private String description;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Адрес не может быть пустым")
    private String address;

    public User() {
    }

    public User(@NotBlank(message = "Имя не может быть пустым") String name,
                @NotBlank(message = "Фамилия не может быть пустой") String surname,
                @NotNull(message = "Дата рождения не может быть пустой")
                @PastOrPresent(message = "Дата рождения указана неверно") LocalDate localDate,
                @Size(max = 20, message = "Логин должен содержать менее 20 символов") @NotBlank(message = "Логин не может быть пустым") String login,
                @Size(min = 5, max = 100, message = "Пароль должен содержать от 5 до 100 символов") @NotBlank(message = "Пароль не может быть пустым") String password,
                @Size(max = 300, message = "Описание должно содержать менее 300 символов") @NotBlank(message = "Описание не может быть пустым") String description,
                @NotBlank(message = "Адрес не может быть пустым") String address) {
        this.name = name;
        this.surname = surname;
        this.localDate = localDate;
        this.login = login;
        this.password = password;
        this.description = description;
        this.address = address;
    }

    public User(Long id,
                @NotBlank(message = "Имя не может быть пустым") String name,
                @NotBlank(message = "Фамилия не может быть пустой") String surname,
                @NotNull(message = "Дата рождения не может быть пустой")
                @PastOrPresent(message = "Дата рождения указана неверно") LocalDate localDate,
                @Size(max = 20, message = "Логин должен содержать менее 20 символов") @NotBlank(message = "Логин не может быть пустым") String login,
                @Size(min = 5, max = 100, message = "Пароль должен содержать от 5 до 100 символов") @NotBlank(message = "Пароль не может быть пустым") String password,
                @Size(max = 300, message = "Описание должно содержать менее 300 символов") @NotBlank(message = "Описание не может быть пустым") String description,
                @NotBlank(message = "Адрес не может быть пустым") String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.localDate = localDate;
        this.login = login;
        this.password = password;
        this.description = description;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
