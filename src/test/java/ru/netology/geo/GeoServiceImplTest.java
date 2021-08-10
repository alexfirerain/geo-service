package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    private final GeoServiceImpl geoService = new GeoServiceImpl();

    private String fakeIPv4startingWith(int prefix) {
        StringBuilder randomIP = new StringBuilder(String.valueOf(prefix));
        for (int i = 0; i < 3; i++)
            randomIP.append(".").append(new Random().nextInt(256));
        return randomIP.toString();
    }


    @Test
    void when_172_returns_rus() {
        String any172ip = fakeIPv4startingWith(172);
        assertEquals(Country.RUSSIA,
                geoService.byIp(any172ip).getCountry());
    }

    @Test
    void when_96_returns_usa() {
        String any96ip = fakeIPv4startingWith(96);
        assertEquals(Country.USA,
                geoService.byIp(any96ip).getCountry());
    }
    


}