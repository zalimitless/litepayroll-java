package com.payroll.constants;

public enum ProfileColour {
    Default(0),
    Green(1),
    Blue(2),
    Red(3);

    private int colourID;
    ProfileColour(int colourID)
    {
        this.colourID = colourID;
    }

    public int getColourID()
    {
        return colourID;
    }

    public static ProfileColour findByValue(String value){
        for(ProfileColour v : values()){
            if( v.equals(value)){
                return v;
            }
        }
        return null;
    }
}
