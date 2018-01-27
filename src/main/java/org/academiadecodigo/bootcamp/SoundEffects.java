package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.kuusisto.tinysound.Sound;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.TinySound;

public class SoundEffects {

    public static void gameTheme() {

        TinySound.init();
        Sound key = TinySound.loadSound("music2.wav");
        for (int i = 0; i < 1; i++) {
            key.play();

        }
    }
/*
    public static void getTheCoin() {

        TinySound.init();
        Sound key = TinySound.loadSound("coin.wav");
        for (int i = 0; i < 1; i++) {
            key.play();

        }
    }

    public static void goldDigger() {

        TinySound.init();
        Sound choke = TinySound.loadSound("goldigger.wav");
        for (int i = 0; i < 1; i++) {
            choke.play();

        }
    }

    public static void knocking() {

        TinySound.init();
        Sound clap = TinySound.loadSound("knocking.wav");
        for (int i = 0; i < 1; i++) {
            clap.play();

        }
    }

    public static void doorOpen(){
        TinySound.init();
        Sound theme = TinySound.loadSound("dooropen.wav");
        for (int i = 0; i < 1; i++) {
            theme.play();
        }
    }*/

    public static void cashRegister(){
        TinySound.init();
        Sound theme = TinySound.loadSound("cashRegister.wav");
        for (int i = 0; i < 1; i++) {
            theme.play();
        }
    }

    public static void espetaculo(){
        TinySound.init();
        Sound theme = TinySound.loadSound("espetaculo.wav");
        for (int i = 0; i < 1; i++) {
            theme.play();
        }
    }

    public static void keyboard(){
        TinySound.init();
        Sound theme = TinySound.loadSound("keyboard.wav");
        for (int i = 0; i < 1; i++) {
            theme.play();
        }
    }
/*
    public static void destroy(){
        TinySound.init();
        Sound theme = TinySound.loadSound("destroy.wav");
        for (int i = 0; i < 1; i++) {
            theme.play();
        }
    }
*/


}
