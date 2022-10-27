package com.payroll.constants;

public enum Salutation {
    Dr(0),
    Mr(1),
    Ms(2),
    Mrs(3),
    Mx(4);

    private int id;

    Salutation(int id) {
        this.id = id;
    }

    public int getID()
    {
        return this.id;
    }

    public static Salutation findByValue(String value){
        for(Salutation v : values()){
            if( v.equals(value)){
                return v;
            }
        }
        return null;
    }

}
