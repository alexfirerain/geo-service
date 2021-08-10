package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {
    static final String MSG_RUS = "Добро пожаловать", MSG_USA = "Welcome";
    static Map<String, String> headers = new HashMap<>();

    @Test
    void when_172_sends_RUS() {
        // IP "172.123.12.19" explicitly set to return Russian location:
        GeoService geoMock = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoMock.byIp("172.123.12.19")).thenReturn(new Location(null, Country.RUSSIA, null, 0));

        // localization guaranteed to speak Russian when invoked from RUSSIA:
        LocalizationServiceImpl localizationMock = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationMock.locale(Country.RUSSIA)).thenReturn(MSG_RUS);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoMock, localizationMock);

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        assertEquals(MSG_RUS, messageSender.send(headers));
    }

    @Test
    void when_96_sends_USA() {
        // IP "96.123.12.19" explicitly set to return United States location:
        GeoService geoMock = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoMock.byIp("96.123.12.19")).thenReturn(new Location(null, Country.USA, null, 0));

        // localization guaranteed to speak American when invoked from the USA:
        LocalizationServiceImpl localizationMock = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationMock.locale(Country.USA)).thenReturn(MSG_USA);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoMock, localizationMock);

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");

        assertEquals(MSG_USA, messageSender.send(headers));
    }
}