package com.isep.hpah.core.wand;

public enum Core {
    Phoenix_Feather, Dragon_Heartstring;

    public static Core assignCore(){
        int Corenum = (int) (Math.random() * 4);
        if (Corenum == 0) {
            return Core.Phoenix_Feather;
        }
        else {
            return Core.Dragon_Heartstring;
        }
    }
}