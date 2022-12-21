package com.won;

import java.io.Serializable;

public class Jet implements Serializable{
	String name; // plane name
	int HP; // plane의 HP
	int bulletPower; // plane bullet power
	char design;
	int price; // plane price
	String description;
}

class F4K extends Jet{
	public F4K() {
		this.name = "F4K";
		this.HP = 20;
		this.bulletPower = 1;
		this.price = 500;
		this.description = "standard plane.";
	}
}

class F15K extends Jet{
	public F15K() {
		this.name = "F15K";
		this.HP = 25;
		this.bulletPower = 2;
		this.price = 1000;
		this.description = "bullet 세 발 + 지원사격skill";
	}
}

class F35K extends Jet{
	public F35K() {
		this.name = "F35K";
		this.HP = 30;
		this.bulletPower = 2;
		this.price = 2000;
		this.description = "bullet 세 발 + 지우기skill";
	}
}
