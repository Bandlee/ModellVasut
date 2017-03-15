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

                        break;
                    case "20":
                        System.out.println(">>Akciókezelo::akció(AlagútSzáj a)");
                        System.out.println(">>Akciókezelo::akció(AlagútSzáj a)");
                        Akciókezelõ ak2= new Akciókezelõ();
                        AlagútSzáj aj_epit = new AlagútSzáj();
                        ak2.akció(aj_epit);
                        break;
                    case "21":
                        System.out.println(">>Akciókezelo::akció(AlagútSzáj a)");
                        Akciókezelõ ak3= new Akciókezelõ();
                        AlagútSzáj aj_rombol = new AlagútSzáj();
                        ak3.akció(aj_rombol);
                        break;
                    case "30":

                        System.out.println(">>Akciókezelo::akció(Váltó v)");
                        Akciókezelõ ak= new Akciókezelõ();
                        Váltó v = new Váltó();
                        ak.akció(v);
                        break;
                    case "40":

                        break;
                    case "50":
                        break;
                    case "51":

                        break;
                    case "52":

                        break;
                    case "53":
                        break;
                    case "60":

                        break;
                    case "61":

                        break;
                    case "70":

                        break;
                    case "71":

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