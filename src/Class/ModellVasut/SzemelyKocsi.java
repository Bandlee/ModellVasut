package Class.ModellVasut;

/**
 * Created by rolac on 2017. 04. 15..
 */
public class SzemelyKocsi extends Kocsi {
    private String sz�n;

    public SzemelyKocsi(String _szin) {
        sz�n = _szin;
    }

    @Override
    public boolean ellen�riz(String s){
        System.out.println("<<Kocsi::ellen�riz(String s)::boolean");

        return (sz�n.equals(s));
    }


}
