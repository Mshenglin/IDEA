package com.xu.msl;

class Animal {
    public void talk(Sound sound) {
        System.out.println("animal:" + "无声");
    }

    public void talk(DogSound sound) {
        System.out.println("animal:" + "汪汪汪");
    }
}

class Dog extends Animal {

    public void talk(Sound sound) {
        System.out.println("dog:" + "无声");
    }

    public void talk(DogSound sound) {
        System.out.println("dog:" + "汪汪汪");
    }
}

class Sound {
}

class DogSound extends Sound{

}




