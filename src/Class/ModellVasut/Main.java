package Class.ModellVasut;

import java.io.*;

/**
 * Created by Timi on 2017. 04. 18..
 */
public class Main {

    public static void main(String[] args){

        P�lyaGener�l� pg = P�lyaGener�l�.getInstance();

        for(int i=0;i<23;i++){

            System.out.println("Teszteset"+(i+1));
            Id�z�t� id� = pg.kezd�s();

        }


    }

}
