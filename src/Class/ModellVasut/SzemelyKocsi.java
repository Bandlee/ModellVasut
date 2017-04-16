package Class.ModellVasut;

/**
 * Created by rolac on 2017. 04. 15..
 */
public class SzemelyKocsi extends Kocsi {
    private String szín;

    public SzemelyKocsi(String _szin) {
        szín = _szin;
    }

    @Override
    public boolean ellenõriz(String s){
        System.out.println("<<Kocsi::ellenõriz(String s)::boolean");

        return (szín.equals(s));
    }


}
