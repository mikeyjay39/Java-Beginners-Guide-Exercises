import java.io.*;

public class SelfTestQuestion8 {

	public static void main(String[] args) {
		
		int i;
		
		try (FileReader frdr = new FileReader("testcopy1.txt");
				FileWriter fwtr = new FileWriter("testcopy2.txt")){
			do {
				i = frdr.read();
				if(i != -1) {
					if(i == ' ') {
						fwtr.write('-');
					} else {
						fwtr.write(i);
					}
					
				}
			} while(i != -1);
		} catch(IOException exc) {
			System.out.println("Error");
		
		}
	}

}
