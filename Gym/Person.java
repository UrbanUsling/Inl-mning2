package Gym;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class Person {
    private static LinkedList<Person> gymLista = new LinkedList<>();
    private  String personNr;
    private  String namn;
    private LocalDate datum;
    public Person(String nr, String n, String d){
        skapaPerson(nr, n, d);
    }
    public void skapaPerson(String nr, String n, String d){
        try{
            nr= nr.substring(0, 10);
        }catch (StringIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, n + "har felaktigt skrivet personnummer",
                    "Error", JOptionPane.PLAIN_MESSAGE);
            System.exit(1);
        }
        if (nr.matches("[0-9]+"))
            personNr=nr;
        else {
            JOptionPane.showMessageDialog(null, n + "har felaktigt skrivet personnummer",
                    "Error", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        n = n.trim();
        if(n.matches("[ a-öA-Ö]+"))
            namn = n;
        else{
            JOptionPane.showMessageDialog(null, n + " innehåller otillåtna tecken",
                    "Error", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        try {
            datum = LocalDate.parse(d);
        }catch (java.time.format.DateTimeParseException e){
            JOptionPane.showMessageDialog(null, n + " har felaktigt skrivet startdatum",
                    "Error", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
        }
    }

    public String getNamn() {
        return namn;
    }
    public String getPersonNr(){
        return personNr;
    }
    public LocalDate getDatum(){
        return datum;
    }
    public static void addGymLista(Person p){
        gymLista.add(p);
    }
    public static LinkedList<Person> getGymLista(){
        return gymLista;
    }
}
