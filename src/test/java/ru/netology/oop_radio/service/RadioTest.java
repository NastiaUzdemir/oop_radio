package ru.netology.oop_radio.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testSetCurrentNumberStation() {
        Radio radio = new Radio(10);

        radio.setCurrentNumberStation(5);
        Assertions.assertEquals(5, radio.getCurrentNumberStation());

        // Проверка, что если номер станции больше, чем количество радиостанций, ничего не происходит
        radio.setCurrentNumberStation(15);
        Assertions.assertEquals(5, radio.getCurrentNumberStation());

        // Проверка, что если номер станции меньше нуля, ничего не происходит
        radio.setCurrentNumberStation(-1);
        Assertions.assertEquals(5, radio.getCurrentNumberStation());

    }

    @Test
    public void testNext() {
        Radio radio = new Radio();


        // Проверка переключения на следующую станцию
        radio.next();
        Assertions.assertEquals(1, radio.getCurrentNumberStation());

        // Проверка переключения через конечные значения (граничащие значения)
        radio.setCurrentNumberStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentNumberStation());

    }

    @Test
    public void testPrev() {
        Radio radio = new Radio();

        // Проверка переключения на предыдущую станцию
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentNumberStation());

        // Граничащие значения
        radio.setCurrentNumberStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentNumberStation());

    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();

        // Проверка увеличения громкости
        radio.increaseVolume();
        assert radio.getVolume() == 1;

        // Проверка увеличения громкости до максимального значения
        for (int i = 1; i < 100; i++) {
            radio.increaseVolume();
        }
        assert radio.getVolume() == 100;

        radio.setVolume(-1);
        radio.increaseVolume();
        assert radio.getVolume() == 0;

        radio.setVolume(150);
        radio.increaseVolume();
        assert radio.getVolume() == 150;

    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();

        // Проверка уменьшения громкости
        radio.decreaseVolume();
        assert radio.getVolume() == 0;

        // Проверка уменьшения громкости до минимального значения
        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume();
        }
        assert radio.getVolume() == 0;


        radio.setVolume(1);
        radio.decreaseVolume();
        int actualVolume = radio.getVolume();
        Assertions.assertEquals(0, actualVolume);

    }

    @Test
    public void testSetVolume() {
        Radio radio = new Radio();

        radio.setVolume(5);
        int actualVolume = radio.getVolume();
        Assertions.assertEquals(5, actualVolume);
    }

    @Test
    public void testPrevDown() {

        Radio radio = new Radio();
        radio.setCurrentNumberStation(4);

        radio.prev();
        int actualNumberStation = radio.getCurrentNumberStation();

        Assertions.assertEquals(3, actualNumberStation);
    }
}