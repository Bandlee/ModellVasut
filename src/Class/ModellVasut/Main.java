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

                        break;
                    case "20":
                        System.out.println(">>Akci�kezelo::akci�(Alag�tSz�j a)");
                        System.out.println(">>Akci�kezelo::akci�(Alag�tSz�j a)");
                        Akci�kezel� ak2= new Akci�kezel�();
                        Alag�tSz�j aj_epit = new Alag�tSz�j();
                        ak2.akci�(aj_epit);
                        break;
                    case "21":
                        System.out.println(">>Akci�kezelo::akci�(Alag�tSz�j a)");
                        Akci�kezel� ak3= new Akci�kezel�();
                        Alag�tSz�j aj_rombol = new Alag�tSz�j();
                        ak3.akci�(aj_rombol);
                        break;
                    case "30":

                        System.out.println(">>Akci�kezelo::akci�(V�lt� v)");
                        Akci�kezel� ak= new Akci�kezel�();
                        V�lt� v = new V�lt�();
                        ak.akci�(v);
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