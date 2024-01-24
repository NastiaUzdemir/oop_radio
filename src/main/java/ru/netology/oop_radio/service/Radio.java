package ru.netology.oop_radio.service;

public class Radio {

    private int currentNumberStation;
    private int volume;

    public int getCurrentNumberStation() {
        return currentNumberStation;
    }
    public void setCurrentNumberStation(int currentNumberStation) {
        this.currentNumberStation = currentNumberStation;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void next(){
        if (currentNumberStation == 9) {
            currentNumberStation = 0;
        } else {
            currentNumberStation++;
        }
    }

    public void prev(){
        if (currentNumberStation == 0){
            currentNumberStation = 9;
        } else{
            currentNumberStation--;
        }
    }

    public void setStation(int station) {
        if (station >= 0 && station <= 9) {
            currentNumberStation = station;
        }
    }


    public void increaseVolume(){
        if (volume <= 100) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }
}
