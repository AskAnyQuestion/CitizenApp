package com.example.application.exception;

import org.jetbrains.annotations.NotNull;

public enum SERVER {
    NOT_ACCESS("Не удаётся получить доступ к серверу"),
    WRONG_COMBINATION("Неправильный номер телефона или пароль"),
    USER_ALREADY_ACCESS("Пользователь с данным логином уже существует"),
    NOT_ACCESS_NOTIFICATION("Не удаётся получить доступ к последним уведомлениям"),

    SAVE("Сохранено");
    final String s;
    SERVER(String s) {
        this.s = s;
    }

    @NotNull
    @Override
    public String toString() {
        return s;
    }
}
