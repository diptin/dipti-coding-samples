package org.diptin.serialized;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class StudentDriver {

	/**
	 * This class serializes Student object to read/write into file
	 * @author Dipti
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Student student1 = new Student("101");
		student1.setFirstName("FIRSTNAME");
		student1.setLastName("LASTNAME");
		
		FileOutputStream fos = new FileOutputStream("studentdb_object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(student1);
		oos.close();
		
		Student student2;
		
		FileInputStream fis = new FileInputStream("studentdb_object.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		student2 = (Student) ois.readObject();
		System.out.println(student2.studentId() + "\t" + student2.firstName());
		ois.close();
	}

}
