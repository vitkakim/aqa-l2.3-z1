package ru.netology.registration;

import lombok.Data;

@Data
public class RegistrationInfo {
    private final String city;
    private final String dateOne;
    private final String dateTwo;
    private final String name;
    private final String phone;
}
