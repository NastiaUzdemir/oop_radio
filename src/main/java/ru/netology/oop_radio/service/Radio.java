package ru.netology.oop_radio.service;

public class Radio {
    private int totalStation;

    private int currentNumberStation;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;
    private int volume;

    public Radio() {
        totalStation = 10;
        currentNumberStation = 0;
    }

    public Radio(int totalStation) {
        this.totalStation = totalStation;
        currentNumberStation = 0;
    }

    public int getCurrentNumberStation() {
        return currentNumberStation;
    }

    public void setCurrentNumberStation(int station) {
        if (station >= 0 && station < totalStation) {
            currentNumberStation = station;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void next() {
        currentNumberStation = (currentNumberStation + 1) % totalStation;
    }

    public void prev() {
        currentNumberStation--;
        if (currentNumberStation < 0) {
            currentNumberStation = totalStation - 1;
        }
    }

    public void increaseVolume() {
        if (volume <= MAX_VOLUME) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > MIN_VOLUME) {
            volume--;
        }
    }

}
