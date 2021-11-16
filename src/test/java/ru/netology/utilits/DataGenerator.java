package ru.netology.utilits;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import ru.netology.registration.RegistrationInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return new RegistrationInfo(faker.address().city(),
                    format.format(LocalDate.now().plusDays(3)),
                    format.format(LocalDate.now().plusDays(10)),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }
    }
}
