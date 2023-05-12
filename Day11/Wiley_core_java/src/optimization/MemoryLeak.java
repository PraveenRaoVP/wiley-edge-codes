package optimization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MemoryLeak {
	public static void main(String[] args) {
		//inefficient way
//		FileInputStream fin = null;
//		try {
//			fin = new FileInputStream("myFile.txt");
//		} catch(FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if(fin!=null) {
//				try {
//					fin.close();
//				} catch(IOException e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
		try (FileInputStream fin = new FileInputStream("myText.txt")){
			//logic
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
