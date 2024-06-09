package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class cal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean existsFile(String filename) {
		File file = new File(filename);
        return file.exists();
	}

	public static void saveFile(String filename, Object o) {
		try {
			System.out.println("寫入"+filename);
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static Object readFile(String filename) {
		Object o = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return o;
	}
	public static void deletdFile(String filename) {
		File file = new File(filename);
		if(file.delete()) {
			System.out.println("刪除成功");
		}else {
			System.out.println("刪除失敗");
		}
	}

}
