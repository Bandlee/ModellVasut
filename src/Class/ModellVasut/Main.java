package Class.ModellVasut;

import java.io.*;

/**
 * Created by desti on 2017. 03. 14..
 */
public class Main {
    public static void main(String[] args){
        String parancs;
        boolean v�ge=false;
        BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
        while(!v�ge){
            try{
                parancs=be.readLine();
                switch(parancs){
                    case "10":
                        /** Init */
                        System.out.println(">>P�lyaGener�l�::kezd�s()");
                        P�lyaGener�l� pg_10 = new P�lyaGener�l�();
                        pg_10.kezd�s();
                        break;
                    case "20":
                        System.out.println(">>Akci�kezel�::akci�(Alag�tSz�j a)");
                        Akci�kezel� ak2= new Akci�kezel�();
                        Alag�tSz�j aj_epit = new Alag�tSz�j();
                        ak2.akci�(aj_epit);
                        break;
                    case "21":
                        System.out.println(">>Akci�kezel�::akci�(Alag�tSz�j a)");
                        Akci�kezel� ak3= new Akci�kezel�();
                        Alag�tSz�j aj_rombol = new Alag�tSz�j();
                        ak3.akci�(aj_rombol);
                        break;
                    case "30":
                        System.out.println(">>Akci�kezel�::akci�(V�lt� v)");
                        Akci�kezel� ak= new Akci�kezel�();
                        V�lt� v = new V�lt�();
                        ak.akci�(v);
                        break;
                    case "40":
                        /** Utasok lesz�ll�sa */
                        System.out.println(">>�llom�s::tov�bb(VonatElem v, S�nElem s)");
                        �llom�s �ll_40 = new �llom�s();
                        S�nElem s_40 = new S�nElem();
                        Kocsi k_40 = new Kocsi();
                        �ll_40.tov�bb(k_40,s_40);
                        break;
                    case "50":
                        /** �tk�z�s s�nen */
                        Mozdony m_a = new Mozdony();
                        m_a.m_S�nElem.setK�vetkez�();
                        m_a.mozgat();
                        break;
                    case "51":

                        /** kisikl�s ha v�ge a s�nnek */
                        Mozdony m = new Mozdony();
                        m.mozgat();
                        break;
                    case "52":

                        /** kisikl�s inakt�v alag�tsz�jhelyen */
                        Mozdony m2 = new Mozdony();
                        m2.mozgat();
                        break;
                    case "53":
                        /** kisikl�s v�lt�ban */
                        Mozdony m3 = new Mozdony();
                        m3.mozgat();
                        break;
                    case "60":

                        break;
                    case "61":

                        break;
                    case "70":
                        /** C�lba �r�s */
                        System.out.println(">>�llom�s::lesz�ll(VonatElem v)");
                        �llom�s �ll_70 = new �llom�s();
                        Kocsi k_70 = new Kocsi();
                        �ll_70.lesz�ll(k_70);
                        break;
                    case "71":
                        /** tick */
                        Id�z�t� i = new Id�z�t�();
                        System.out.println(">>Id�z�t�::tick()");
                        i.tick();
                        break;
                    case "99":
                        v�ge=true;
                        break;
                    default:
                        System.out.println("Nem megfelelo bemenet.");
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}