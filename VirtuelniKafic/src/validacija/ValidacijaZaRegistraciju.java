package validacija;

public class ValidacijaZaRegistraciju {

	public static boolean proveraPasworda (String password, String repeatPassword) {
		
		if (password.equals(repeatPassword)) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	// pu daLiJeAdmin
	
	
}
