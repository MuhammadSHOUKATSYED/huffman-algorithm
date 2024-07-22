package Data_Structures_Final_Project;
import java.util.*;
public class codeChar {
   String code;
   char character;
    public codeChar(String code, char character) {
	super();
	this.code = code;
	this.character = character;
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	@Override
	public String toString() {
		return "codeChar [code=" + code + ", character=" + character + "]";
	}
    
}
