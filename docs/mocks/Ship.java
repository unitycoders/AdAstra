class Ship{
	Power slot0;
	Sheild slot1;
	Weapon slot2;
	Weapon slot3;
	private hp;	
	public ship(){
		hp = 50000000;	
	}
	public void setSlot0(Power power){
		slot0 = power;
	}
	public void setSlot1(Sheild sheild){
		slot1 = sheild;
	}
	public void setSlot2(Weapon weapon){
		slot2 = weapon;
	}
	public void setSlot3(Weapon weapon){
		slot3 = weapon;
	}
	public void damage(int damage){
		for(int i = 0;i<damage;i++){
			if(slot1==null){
				hp-=1;
			}else if(slot1.getShield()==0){
				slot1=null;
			}else{
				slot1.damage(1);
			}
		}
	}
}

interface Power{
	public void makePower();
	public int getPower();
	public boolean checkPower(int drain);
	public void drainPower(int drain);
}

class SmallGenerator implements Power{
	private powerCollected;
	private rate; 
	public SmallGenerator(){
		rate = 2;
		powerCollected = 0;
	}
	public void makePower(){
		powerCollected+=rate;
	}
	public int getPower(){
		return powerCollected;
	}
	public boolean checkPower(int drain){
		if((powerCollected - drain)<0){
			return false;
		}
		return true;
	}
	public void drainPower(int drain){
		powerCollected-=drain;
	}
}

interface Sheild{
	//public void setSheild();
	public int getSheild();
	public void damage(int damage);
}

class LowSheild{
	private level;
		
	public LowSheild(){
		level = 1000;
	}
	public int getSheild(){
		return level;
	}
	public void damage(int damage){
		level-=damage;
	}
}

interface Weapon{
	public void reload(int ammo);
	public void fire(Ship target);
}

class BigWeapon{
	private strength;
	private ammoBelt;
	private power;
	public BigWeapon(){
		strength = 9001;
		ammo = 255;
		power = 20;
	}
	public void reload(int ammo){
		ammoBelt+=ammo;
	}
	public void fire(Ship target){
		if(ammo>0){
			//insert check power
			target.damage(strength);
		}
	}
}
