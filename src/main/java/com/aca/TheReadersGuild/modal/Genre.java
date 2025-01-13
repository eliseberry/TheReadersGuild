package com.aca.TheReadersGuild.modal;

public enum Genre {
    Fantasy, SciFi, Romance, Suspense,  Biography, SelfHelp, Historic, Spirituality;

    public static Genre convertStringToGenre(String value){
        Genre myGenre = null;

        for(Genre genre : Genre.values()){
            if (genre.toString().equalsIgnoreCase(value)){
                myGenre = genre;
                break;
            }
        }

        return myGenre;
    }
}
