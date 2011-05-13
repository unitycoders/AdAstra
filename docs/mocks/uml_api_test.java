


Map<Piers,Integer>
List<Piers> (piers.amount)


class CargoBay{
int maxStorage;
List<Resource> contained;
}

Hardware h = new Cargobay();
ship.add(0, h);

void add(int pos, Hardware h){
	if(h.canStore()){
		List<
	}
}

void add(int pos, Cargobay b){
}

1 = Fire
2 = Move 
3 = explode
4 = stop

over = 50
metal = 200

over = 150
metal = 50
food = 400

private Map<String,Integer> properties;

power, health, cargo

public void use(int type){
	ship.addProperty("cargo.stored.metal", 100);
}

public void disable(){
	int free = ship.getProperty("cargo.freespace");
	if(free >= CARGO_MAX_VALUE){
		ship.addProperty("cargo.freespace", CARGO_MAX_VALUE*-1);
	} else {
		//find all cargo
		int overstored = CARGO_MAX_VALUE-free;
		String[] properties = ship.getAllProperties("cargo.stored.*");
		while(overspace > 0){
			int stored = ship.getProperty(properties[i]);
			if(stored < overspace){
				ship.setProperty(properties[i],stored-overspace);
			}else if(stored >= overspace){
				overspace -= stored;
				ship.setProperty(properties[i],0);
			}
		}
		//remove some cargo
		//profit
	}
