package com.payroll.constants;

public enum Gender {

    Unspecified(0),
    Male(1),
    Female(2);

    private int genderValue;
    Gender(int genderValue) {
        this.genderValue = genderValue;
    }

    public int getValue()
    {
        return this.genderValue;
    }

    public static Gender findByValue(String value){
        for(Gender v : values()){
            if( v.equals(value)){
                return v;
            }
        }
        return null;
    }
}
