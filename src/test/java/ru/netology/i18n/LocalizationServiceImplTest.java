package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    static final LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
    static final String msgRus = "Добро пожаловать",
                        msgEng = "Welcome";

    @ParameterizedTest
    @EnumSource(Country.class)
    void locally_greets(Country state) {
        if (Country.RUSSIA.equals(state))
            assertEquals(msgRus, localizationService.locale(state));
        else
            assertEquals(msgEng, localizationService.locale(state));
    }
}