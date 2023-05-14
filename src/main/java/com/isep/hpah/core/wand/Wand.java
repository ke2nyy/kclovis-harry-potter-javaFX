package com.isep.hpah.core.wand;

public class Wand {
    private int size;
    private Core core;

    public Wand (int size, Core core){
        this.size = size;
        this.core = core;
    }

    public int getSize() {
        return size;
    }

    public void setSize() {
        this.size = size;
    }

    public Core getCore() {
        return core;
    }

    public void setCore() {
        this.core = core;
    }
}