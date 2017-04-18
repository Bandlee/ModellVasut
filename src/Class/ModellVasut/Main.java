package Class.ModellVasut;

import java.io.*;

/**
 * Created by Timi on 2017. 04. 18..
 */
public class Main {

    public static void main(String[] args){

        PályaGeneráló pg = PályaGeneráló.getInstance();

        for(int i=0;i<8;i++){

            System.out.println("Teszteset"+(i+1));
            Idõzítõ idõ = pg.kezdés();

        }

        for(int i=0;i<8;i++){
            try{
                File minta = new File("kimenet/Kimenet" + String.valueOf(i+1) + ".txt");
                BufferedReader br_m=new BufferedReader(new FileReader(minta));
                File kimenet = new File("mintakimenet/MintaKimenet" + String.valueOf(i+1) + ".txt");
                BufferedReader br_k=new BufferedReader(new FileReader(kimenet));
                String sor_m =  br_m.readLine();
                String sor_k = br_k.readLine();
                boolean siker = true;
                while(sor_m!=null && sor_k!=null && siker){
                    if(sor_m.equals(sor_k)){
                        siker = true;
                        sor_m =  br_m.readLine();
                        sor_k = br_k.readLine();
                    }else siker = false;

                }
                br_k.close();
                br_m.close();
                if(siker) System.out.println("Teszteset"+(i+1)+" sikeres volt.");
                else System.out.println("Teszteset"+(i+1)+" sikertelen volt.");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

}
