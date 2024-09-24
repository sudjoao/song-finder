package com.sudjoao.song_finder.models;

public enum Gender {
    POP(1),
    COUNTRY(2),
    ROCK(3),
    FUNK(4),
    REGGAE(5);

    int value;

    Gender(int value) {
        this.value = value;
    }

    public static void listGenders() {
        for(Gender gender : Gender.values()){
            System.out.printf("%d - %s\n", gender.value, gender);
        }
    }

    public static Gender fromValue(int value) {
        for(Gender gender : Gender.values()){
            if (value == gender.value)
                return gender;
        }
        throw new RuntimeException("Gender not found");
    }
}
