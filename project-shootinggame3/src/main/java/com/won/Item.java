package com.won;

import java.io.Serializable;

class Item implements Serializable{
	String name; // item들만의 name.
	int price; // item들만의 price.
	int HPPlus;
	String description;
}

class HPplus10 extends Item{
	public HPplus10() {
		this.name = "HPplus10";
		this.price = 300;
		this.HPPlus = 10;
		this.description = "can increase 10 HP";
	}
}

class HPplus30 extends Item{
	HPplus30(){
		this.name = "HPplus30";
		this.price = 700;
		this.HPPlus = 30;
		this.description = "can increase 30 HP";
	}
}
