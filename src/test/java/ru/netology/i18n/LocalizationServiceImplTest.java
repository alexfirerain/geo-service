package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    static final LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
    static final String MSG_RUS = "Добро пожаловать",
                        MSG_ENG = "Welcome";

    @ParameterizedTest
    @EnumSource(Country.class)
    void locally_greets(Country state) {

        if (Country.RUSSIA.equals(state))
            assertEquals(MSG_RUS, localizationService.locale(state));
        else
            assertEquals(MSG_ENG, localizationService.locale(state));

        // или так:
        assertEquals(state.equals(Country.RUSSIA) ?
                        MSG_RUS : MSG_ENG,
                localizationService.locale(state));
    }
}