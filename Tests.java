import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class PrintableWoodTest {
	//тесты не доделаны,пока только вывод на консоль
	
	String str1="✿✿✿✿✿✿✿✿✿\r\n✿○○○○○✿✖✿\r\n✿✿✿✿✿○✿○✿\r\n✿○○○✿○✿○✿\r\n✿○✿○○○✿○✿\r\n✿○✿✿✿✿✿○✿\r\n✿○○○○○○♥✿\r\n✿✿✿✿✿✿✿✿✿\r\n♥ - life\r\n✖  - death";
	
	@Test
	public void testPrintWood1() throws IOException, CodeException { //wood
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		File file2=new File("out.txt");
		OutputStream outstream=new FileOutputStream(file2);
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
	    wood.PrintWood();
	}

	@Test
	public void testPrintWood2() throws IOException, CodeException { //trap
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		File file2=new File("out.txt");
		OutputStream outstream=new FileOutputStream(file2);
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Billy", new Point(7, 1));
		wood.move("Billy", Direction.Down);	
	}
	
	@Test
	public void testPrintWood3() throws IOException, CodeException {  //life
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		File file2=new File("out.txt");
		OutputStream outstream=new FileOutputStream(file2);
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Chris", new Point(7, 6));
		wood.move("Chris", Direction.Up);	
	}
	
	@Test
	public void testPrintWood4() throws IOException, CodeException { //increase lives
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		File file2=new File("out.txt");
		OutputStream outstream=new FileOutputStream(file2);
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Alex", new Point(7, 6));
		wood.move("Alex",  Direction.Right);
		wood.move("Alex",  Direction.Right);
		wood.move("Alex",  Direction.Right);
		wood.move("Alex",  Direction.Right);
	}
	
	@Test
	public void testPrintWood5() throws IOException, CodeException { //decrease your lives
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		File file2=new File("out.txt");
		OutputStream outstream=new FileOutputStream(file2);
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Billy", new Point(7, 1));
		wood.move("Billy", Direction.Down);	
		wood.move("Billy", Direction.Up);
		wood.move("Billy", Direction.Down);	
		wood.move("Billy", Direction.Up);
		wood.move("Billy", Direction.Down);	
		wood.move("Billy", Direction.Up);
	}
	
	@Test
	public void testPrintWood6() throws IOException, CodeException { //space
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		File file2=new File("out.txt");
		OutputStream outstream=new FileOutputStream(file2);
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Vincent", new Point(2, 1));
	}
	
}
