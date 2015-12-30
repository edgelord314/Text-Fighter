package com.hotmail.kalebmarc.textfighter.main;

import java.util.Scanner;

public class Action {
	
	private static Scanner in = new Scanner(System.in);
	
	private Action(){}

	public static int getValidInt(){
						
		while(!in.hasNextInt()) {
			in.nextLine();
		}

		return in.nextInt();
		
	}
	
	/*
	 * Stops the program until the user presses enter, then continues
	 */
	public static void pause(){
		
		try{

		    Scanner pauseScan = new Scanner(System.in);
    		String temp = pauseScan.nextLine();
	    	Ui.println(temp);
		
		}catch (Exception e){
			//Blank for a reason - Not supposed to do anything.
		}
	}

	public static void displayAmmo(){
		if(Weapon.get().melee){
			//No gun equipped, so no need to do anything
			//TODO Get rid of empty block
		}else if(Weapon.get().getName().equals("Shotgun")){
			Ui.println("     Shotgun Ammo: " + Weapon.getSgAmmo());
		}else{
			Ui.println("     Ammo: " + Weapon.getAmmo());
		}
	}
	/*
	 * Clears the console 
	 */
	public static void cls(){
		for (int i = 1; i < 50; i++){
			Ui.println("\n");
		}
	}
}