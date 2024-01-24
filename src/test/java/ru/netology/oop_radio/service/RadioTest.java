package ru.netology.oop_radio.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testNext() {
        Radio radio = new Radio();

        // Проверка переключения на следующую станцию
        radio.next();
        assert radio.getCurrentNumberStation() == 1;

        // Проверка переключения через конечные значения (граничащие значения)
        radio.setCurrentNumberStation(9);
        radio.next();
        assert radio.getCurrentNumberStation() == 0;

    }

    @Test
    public void testPrev() {
        Radio radio = new Radio();

        // Проверка переключения на предыдущую станцию
        radio.prev();
        assert radio.getCurrentNumberStation() == 9;

        // Граничащие значения
        radio.setCurrentNumberStation(0);
        radio.prev();
        assert radio.getCurrentNumberStation() == 9;

    }

    @Test
    public void testSetStation() {
        Radio radio = new Radio();

        // Проверка установки станции в пределах допустимых значений
        radio.setStation(5);
        assert radio.getCurrentNumberStation() == 5;


        // Проверка установки станции за пределами допустимых значений
        radio.setStation(10);
        assert radio.getCurrentNumberStation() == 5;

        radio.setStation(-10);
        assert radio.getCurrentNumberStation() == 5;

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