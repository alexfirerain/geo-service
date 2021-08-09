package ru.netology.geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    private final GeoServiceImpl geoService = new GeoServiceImpl();

    private String generateRandIpStartingWith(int prefix) {
        StringBuilder randomIP = new StringBuilder(String.valueOf(prefix));
        for (int i = 0; i < 3; i++)
            randomIP.append(".").append(new Random().nextInt(256));
        return randomIP.toString();
    }


    @Test
    void returns_rus_when_172() {
        String any172IP = generateRandIpStartingWith(172);
        System.out.println(any172IP);
        assertEquals(Country.RUSSIA,
                geoService.byIp(any172IP).getCountry());
    }

    @Test
    void returns_usa_when_96() {
        String any96IP = generateRandIpStartingWith(96);
        System.out.println(any96IP);
        assertEquals(Country.USA,
                geoService.byIp(any96IP).getCountry());
    }

}