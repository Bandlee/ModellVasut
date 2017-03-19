package Class.ModellVasut;

import java.io.*;

/**
 * Created by desti on 2017. 03. 14..
 */
public class Main {
    public static void main(String[] args){
        String parancs;
        boolean vége=false;
        BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
        while(!vége){
            try{
                parancs=be.readLine();
                switch(parancs){
                    case "10":
                        /** Init */
                        System.out.println(">>PályaGeneráló::kezdés()");
                        PályaGeneráló pg_10 = new PályaGeneráló();
                        pg_10.kezdés();
                        break;
                    case "20":
                        System.out.println(">>Akciókezelõ::akció(AlagútSzáj a)");
                        Akciókezelõ ak2= new Akciókezelõ();
                        AlagútSzáj aj_epit = new AlagútSzáj();
                        ak2.akció(aj_epit);
                        break;
                    case "21":
                        System.out.println(">>Akciókezelõ::akció(AlagútSzáj a)");
                        Akciókezelõ ak3= new Akciókezelõ();
                        AlagútSzáj aj_rombol = new AlagútSzáj();
                        ak3.akció(aj_rombol);
                        break;
                    case "30":
                        System.out.println(">>Akciókezelõ::akció(Váltó v)");
                        Akciókezelõ ak= new Akciókezelõ();
                        Váltó v = new Váltó();
                        ak.akció(v);
                        break;
                    case "40":
                        /** Utasok leszállása */
                        System.out.println(">>Állomás::tovább(VonatElem v, SínElem s)");
                        Állomás áll_40 = new Állomás();
                        SínElem s_40 = new SínElem();
                        Kocsi k_40 = new Kocsi();
                        áll_40.tovább(k_40,s_40);
                        break;
                    case "50":
                        /** ütközés sínen */
                        Mozdony m_a = new Mozdony();
                        m_a.m_SínElem.setKövetkezõ();
                        m_a.mozgat();
                        break;
                    case "51":

                        /** kisiklás ha vége a sínnek */
                        Mozdony m = new Mozdony();
                        m.mozgat();
                        break;
                    case "52":

                        /** kisiklás inaktív alagútszájhelyen */
                        Mozdony m2 = new Mozdony();
                        m2.mozgat();
                        break;
                    case "53":
                        /** kisiklás váltóban */
                        Mozdony m3 = new Mozdony();
                        m3.mozgat();
                        break;
                    case "60":

                        break;
                    case "61":

                        break;
                    case "70":
                        /** Célba érés */
                        System.out.println(">>Állomás::leszáll(VonatElem v)");
                        Állomás áll_70 = new Állomás();
                        Kocsi k_70 = new Kocsi();
                        áll_70.leszáll(k_70);
                        break;
                    case "71":
                        /** tick */
                        Idõzítõ i = new Idõzítõ();
                        System.out.println(">>Idõzítõ::tick()");
                        i.tick();
                        break;
                    case "99":
                        vége=true;
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