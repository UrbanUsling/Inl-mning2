package Gym;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HuvudGym {
    public HuvudGym() throws FileNotFoundException {
        var scan = new Scanner(new File("src\\textfil\\customers.txt"));
        while (scan.hasNext()) {
            String nr = scan.next();
            String namn = scan.nextLine();
            String datum  = scan.nextLine();
            Person.addGymLista(new Person(nr, namn, datum));
        }
        for (Person p : Person.getGymLista())
            System.out.println(p.getPersonNr() + " " + p.getNamn());
    }

    public static void main(String[] args) throws IOException {
        HuvudGym hej = new HuvudGym();
        KollaKund heja = new KollaKund();
    }
}