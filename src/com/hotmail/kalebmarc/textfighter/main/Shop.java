package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class Shop{
    private Shop(){}

    public static void menu() {
        while (true) {
            Action.cls();
			Ui.println("-------------------------------------------------------------------");
			Ui.println("                        Welcome to the shop!                       ");
			Ui.println();
			Ui.println("Coins: " + com.hotmail.kalebmarc.textfighter.player.Coins.get());
			Ui.println("First-Aid kits: " + com.hotmail.kalebmarc.textfighter.item.FirstAid.get());
			Ui.println("Ammo: " + Weapon.getAmmo());
			Ui.println();
			Ui.println("-------------------------------------------------------------------");
			Ui.println("1) Health");
			Ui.println("2) Weapons/Ammo");
			Ui.println("3) XP");
			Ui.println("4) Back");
			Ui.println("-------------------------------------------------------------------");
			switch(Action.getValidInt()){
			case 1:
				health();
				break;
			case 2:
				weapons();
				break;
			case 3:
				xp();
				break;
			case 4:
				return;
			default:
				break;
			}
        }
    }
    private static void health(){

        while(true){
            Action.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                               Health                              ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("First-Aid kits: " + FirstAid.get());
            Ui.println("Insta-Healths: " + InstaHealth.get());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("1) FIRST-AID KIT");
            Ui.println("   Price - " + FirstAid.price + " coins");
            Ui.println("   Level - " + FirstAid.level);
            Ui.println();
            Ui.println("2) INSTA-HEALTH");
            Ui.println("   Price - " + InstaHealth.price + " coins");
            Ui.println("   Level - " + InstaHealth.level);
            Ui.println();
            Ui.println("3) Back");
            Ui.println("-------------------------------------------------------------------");
            switch(Action.getValidInt()){
                case 1:
                    FirstAid.buy();
                    break;
                case 2:
                    InstaHealth.buy();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    private static void weapons(){
        while(true) {
            Action.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                              Weapons                              ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
                if(!Weapon.arrayWeapon.get(i).isBuyable()){
                    Ui.println((i + 1) + ") [NOT AVAILABLE FOR PURCHASE]");//TODO Make it so it just skips
                }else{
                    Ui.println((i + 1) + ") " + Weapon.arrayWeapon.get(i).getName());
                    Ui.println("   Price: " + Weapon.arrayWeapon.get(i).price);
                    Ui.println("   Level: " + Weapon.arrayWeapon.get(i).level);
                }
                Ui.println();
            }
            Ui.println((Weapon.arrayWeapon.size() + 1) + ") POWER");
            Ui.println("   Price: " + Power.price);
            Ui.println("   Level: " + Power.level);
            Ui.println();
            Ui.println((Weapon.arrayWeapon.size() + 2) + ") AMMO (10)");
            Ui.println("   Price: " + Weapon.AMMO_10_PRICE);
            Ui.println("   Level: " + Weapon.AMMO_LEVEL);
            Ui.println();
            Ui.println((Weapon.arrayWeapon.size() + 3) + ") AMMO (50)");
            Ui.println("   Price: " + Weapon.AMMO_50_PRICE);
            Ui.println("   Level: " + Weapon.AMMO_LEVEL);
            Ui.println();
            Ui.println((Weapon.arrayWeapon.size() + 4) + ") AMMO (100)");
            Ui.println("   Price: " + Weapon.AMMO_100_PRICE);
            Ui.println("   Level: " + Weapon.AMMO_LEVEL);
            Ui.println();
            Ui.println((Weapon.arrayWeapon.size() + 5) + ") Back");


            while(true) {//Make it easy to break, without going back to main store menu

                int menuItem = Action.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!

                    Weapon.arrayWeapon.get(menuItem - 1).buy();
                    break;

                } catch (Exception e) {

                    if (menuItem == (Weapon.arrayWeapon.size() + 1)) {
                        Power.buy();
                        break;
                    }
                    if (menuItem == (Weapon.arrayWeapon.size() + 2)) {
                        Weapon.buyAmmo10();
                        break;
                    }
                    if (menuItem == (Weapon.arrayWeapon.size() + 3)) {
                        Weapon.buyAmmo50();
                        break;
                    }
                    if (menuItem == (Weapon.arrayWeapon.size() + 4)) {
                        Weapon.buyAmmo100();
                        break;
                    }
                    if (menuItem == (Weapon.arrayWeapon.size() + 5)) {
                        return;
                    }
                    Ui.println();
                    if (menuItem == (Weapon.arrayWeapon.size() + 2)) return;
                    Ui.println(menuItem + " is not an option.");
                    Action.pause();
                    Action.cls();

                }
            }

        }
    }
    private static void xp(){

		//Makes sure player has enough money
		boolean valid;

		while(true){

            //Makes sure player isn't level 10 already
            if(Xp.getLevel() == 100){
                Action.cls();
                Ui.println("You're already level 100! You cannot buy any more xp.");
                Action.pause();
                return;
            }

            Action.cls();
			Ui.println("-------------------------------------------------------------------");
			Ui.println("                                 XP                                ");
			Ui.println();
			Ui.println("Level: " + Xp.getLevel());
			Ui.println("XP: " + Xp.getFull());
			Ui.println("Coins: " + Coins.get());
			Ui.println();
			Ui.println("You can buy XP for 1 coin per XP. How much would you like to buy?");
			Ui.println("**Enter 0 to go back**");
			Ui.println("-------------------------------------------------------------------");

			int buy = Action.getValidInt();
			valid = true;

			//Tests
			if (buy > Coins.get()){
				//Not enough coins
				Action.cls();
				Ui.println("You don't have enough coins to buy this much xp.");
				valid = false;
				Action.pause();
			}
            if (Xp.getLevel() == 100){
                Action.cls();
                Ui.println("You are already level 100; which is the maximum level.");
                valid = false;
                Action.pause();
            }
			if (buy < 0){
				Action.cls();
				Ui.println("You can't buy a negative amount of Xp.. Nice try though ;)");
				valid = false;
				Action.pause();
			}
			if (buy == 0){
				return;
			}

			if (valid){
				Action.cls();
				Ui.println("You have bought " + buy + " xp.");
				Action.pause();

				//Results
				Xp.set(buy, true);
				Coins.set(-buy, true);
                Stats.xpBought += buy;
            }

		}
	}

}