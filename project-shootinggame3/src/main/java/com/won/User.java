package com.won;

import java.io.Serializable;
import java.util.ArrayList;

class User implements Serializable{
	
	String name;
	int userMoney;
	Jet currentplane = null;
	ArrayList<Jet> myplane = new ArrayList<Jet>();
	Item currentitem = null;
	ArrayList<Item> myitem = new ArrayList<Item>();
	boolean stage1 = false;
	boolean stage2 = false;
	boolean stage3 = false;
	
	User(String name) {
		this.name = name;
		this.userMoney = 1000;
		this.currentplane = new F4K();
	}
	
	void showItem() {
		
		if(this.myitem.isEmpty()) {
			System.out.print("no item in storage");
		}
		
		else {
			for(int i = 0; i < this.myitem.size(); i++) {
				Item item = this.myitem.get(i);
				System.out.print(item.name + " ");
			}
		}
		
		System.out.println();
		
	}
	
	
	void showFlight() {
		if(this.myplane.isEmpty()) {
			System.out.print("no plane in storage");
		}
		
		else {
			for(int i = 0; i < this.myplane.size(); i++) {
				System.out.print(this.myplane.get(i).name + " ");
			}
		}
		
		System.out.println();
		
	}
	
	
	
	void showUsedFlight() {
		if(this.currentplane == null) {
			System.out.print("current plane이 없습니다.");
		}
		else {
			System.out.print(this.currentplane.name);
		}
		System.out.println();
	}
	
	
	void showUsedItem() {
		if(this.currentitem == null) {
			System.out.print("no item ");
		}
		else {
			System.out.print(this.currentitem.name);
		}
		System.out.println();
	}
	
	
	
}
