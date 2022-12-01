package Classes;

import com.mysql.cj.xdevapi.Schema.Validation;

public class SQL {

	
	public static Boolean validate(String input) {
		
		if (input.contains("DROP") || input.contains("drop")|| input.contains("UPDATE")||input.contains("update")||input.contains("SELECT")||input.contains("select")) {
			return false;
		}
		
		for(int i=0; i<input.length(); i++) {
			if( !Character.isLetter(input.charAt(i)) && !Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		System.out.print(SQL.validate("dsadadsad"));
		
		
	}
	
	
}
