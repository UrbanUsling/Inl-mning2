package Gym;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;

public class KollaKund {
    private Person pr;
    private boolean medlem = false;
    private boolean aktivMedlem = false;
    private Period tidVall;

    public KollaKund() throws IOException {
        namnInmatning();
        if (medlem)
            tidsBeräkning();
        else{
            JOptionPane.showMessageDialog(null, "Denna person har aldrig varit medlem",
                    "Ej medlem", JOptionPane.PLAIN_MESSAGE);
        }

        if (aktivMedlem)
            sparaKundinfo(pr.getNamn());

    }

    public void namnInmatning() {
        String namn = (JOptionPane.showInputDialog(null,
                "Vilken medlem söker du? Ange namn eller 10siffrigt personnummer",
                "Medlemssökning", JOptionPane.QUESTION_MESSAGE));
        namn = namn.toLowerCase();
        for (Person p : Person.getGymLista()) {
            if (p.getNamn().toLowerCase().equals(namn) || p.getPersonNr().equals(namn)) {
                LocalDate t = p.getDatum();
                tidVall = Period.between(t, LocalDate.now());
                pr = p;
                medlem = true;
            }
        }
    }
    public void tidsBeräkning() {
        int år = tidVall.getYears();
        if (år < 1) {
            aktivMedlem = true;
            JOptionPane.showMessageDialog(null, pr.getNamn() + " är välkommen att gymma!",
                    "Aktiv medlem", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, pr.getNamn()+ " måste betala avgiften då ett år passerats",
                    "Gammal medlem", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void sparaKundinfo(String namn) throws IOException {
        try (
            FileWriter writer = new FileWriter("src\\textfil\\" + namn + ".txt", true);

        ) {
                writer.write(namn + " tränade " + LocalDate.now());
                writer.write("\n");


            }

        }
    }
