package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {
    private static GeoService geoMock = Mockito.mock(GeoServiceImpl.class);


    private static LocalizationServiceImpl localizationMock = Mockito.mock(LocalizationServiceImpl.class);

    private static final MessageSenderImpl messageSender
            = new MessageSenderImpl(geoMock, localizationMock);

    @Test
    void send() {
    }
}