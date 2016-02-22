package logic;

import java.util.ArrayList;

public class CustomPizza_Singleton {

	private static CustomPizza_Singleton custom =null;
// dont want multiple instance for the same session to be invoked here	
	public ArrayList<String> customPizza= new ArrayList<String>();
	
	private CustomPizza_Singleton() {
		
	}
	public static CustomPizza_Singleton getInstance(){
		if(custom==null){
			custom = new CustomPizza_Singleton();
		}
		
		else{
			return custom;
		}
		
		return custom;
		
	}
	
	
}
