package de.jabsel.doroga.app;

/**
 * Created by Yashik on 22.05.2017.
 */

public class User {

    private long id;
    private String name;
    private int ort;
    // ...1...

    User(long id, String name, int ort){
        this.id = id;
        this.name = name;
        this.ort = ort;
        //...2...
    }
    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrt() {
        return ort;
    }

    public void setOrt(int ort) {
        this.ort = ort;
    }
    //...3...-DatbaseHelp
    @Override
    public String toString() {
        return this.name + ":" + this.ort;
    }
}
