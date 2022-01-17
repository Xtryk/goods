package tokenizacja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar {


    private double cena;
    private String nazwa;
    private Date dataWydania;

    public Towar(){
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
    }

    public Towar(double cena, String nazwa) {
        this();
        this.cena = cena;
        this.nazwa = nazwa;
    }

    public Towar(double cena, String nazwa, int rok, int m, int dz) {
        this(cena, nazwa);
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);
        dataWydania = kalendarz.getTime();
    }

    public double getCena() {
        return cena;
    }

    public void setCena(final double cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(final String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(final Date dataWydania) {
        this.dataWydania = dataWydania;
    }

    public String toSteing() {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena+" zł; \nnazwa: "+this.nazwa+" "+kalendarz.get(Calendar.YEAR)+" rok "+kalendarz.get(Calendar.MONTH)+" miesiąc "+kalendarz.get(Calendar.DAY_OF_MONTH)+ " dzień.";
    }
    public static void zapiszDopliku(Towar[] towar, PrintWriter outS)
    {
    outS.println(towar.length);
    GregorianCalendar kalendarz = new GregorianCalendar();
    for(int i=0; i<towar.length; i++)
    {
        kalendarz.setTime(towar[i].getDataWydania());
        outS.println(towar[i].getNazwa()+"|"+towar[i].getCena()+"|"+kalendarz.get(Calendar.YEAR)+"|"+(kalendarz.get(Calendar.MONTH)+1)+"|"+kalendarz.get(Calendar.DAY_OF_MONTH)+ "|");
    }
    }
    public static Towar[] odczytajZPliku(BufferedReader inS) throws IOException
    {
        int dl = Integer.parseInt(inS.readLine());
        Towar[] towar = new Towar[dl];
        for(int i=0; i<dl; i++)
        {
            String line = inS.readLine();
            StringTokenizer tokeny = new StringTokenizer(line, "|");
            double cena = Double.parseDouble(tokeny.nextToken());
            String nazwa = tokeny.nextToken();
            int rok = Integer.parseInt(tokeny.nextToken());
            int m = Integer.parseInt(tokeny.nextToken());
            int dz = Integer.parseInt(tokeny.nextToken());
            towar[i] = new Towar(cena,nazwa,rok,m,dz);
        }
        return towar;
    }
}
