package com.ilexiconn.jurassicraft.data.entity2.gender;

public enum Gender
{
    MALE,
    FEMALE;

    public boolean isMale()
    {
        return this == MALE;
    }

    public boolean isFemale()
    {
        return !isMale();
    }
}
