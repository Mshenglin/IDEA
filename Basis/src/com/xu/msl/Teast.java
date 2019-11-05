package com.xu.msl;

public class Teast {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Sound sound = new Sound();
        Sound dogSound = new DogSound();
        animal.talk(sound); //animal:" + "无声
        animal.talk(dogSound); //animal:" + "无声
        dog.talk(sound); //"dog:" + "无声"
        dog.talk(dogSound);// "dog:" + "无声")
    }
}
