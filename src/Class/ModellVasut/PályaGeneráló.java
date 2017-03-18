package Class.ModellVasut;


import java.io.File;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class PályaGeneráló {

	private File bemenet;
	private int szint;

	public PályaGeneráló(){

	}

	public void finalize() throws Throwable {

	}

	public Idõzítõ kezdés(){
		System.out.println("<<Pályageneráló::kezdés()::Idõzítõ");
		return new Idõzítõ();
	}

}