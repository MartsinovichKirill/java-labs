package org.example;

public class Singer extends Artist {
    private String voiceType;

    public Singer(String name, int age, String genre, String voiceType) {
        super(name, age, genre);
        this.voiceType = voiceType;
    }

    public String getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(String voiceType) {
        this.voiceType = voiceType;
    }

    @Override
    public void perform() {
        System.out.println("Поет песню");
    }

    public void singSong() {
        System.out.println(getName() + " исполняет сольную песню голосом " + voiceType);
    }
}
