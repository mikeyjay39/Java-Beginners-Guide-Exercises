enum Tools {
	SCREWDRIVER, WRENCH, HAMMER, PLIERS
}

public class selftestq3 {

	public static void main(String[] args) {
		
		
		//Tools allTools[] = Tools.values();
		
		for(Tools t : Tools.values())
			System.out.println(t + " " + t.ordinal());
			
	}

}
