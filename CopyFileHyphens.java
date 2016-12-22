import java.io.*;

public class CopyFileHyphens {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("testcopy1.txt");
		FileOutputStream fout = new FileOutputStream("testcopy2.txt");
		int i;
		
		try {
			do {
				i = fin.read();
				if(i != -1) {
					if(i == (char) ' ') {
						fout.write((char) '-');
					} else {
						fout.write(i);
					}
					
				}
			} while(i != -1);
		} catch(IOException exc) {
			System.out.println("Error");
		} finally {
			try {
				if(fin != null) fin.close();
			} catch(IOException exc) {
				System.out.println("Error Closing Input");
			}
			try {
				if(fout != null) fout.close();
			} catch(IOException exc) {
				System.out.println("Error closing Output");
			}
		}
	}

}
