import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

public class PrintableWoodTest {
	String str1="✿✿✿✿✿✿✿✿✿\r\n✿○○○○○✿✖✿\r\n✿✿✿✿✿○✿○✿\r\n✿○○○✿○✿○✿\r\n✿○✿○○○✿○✿\r\n✿○✿✿✿✿✿○✿\r\n✿○○○○○○♥✿\r\n✿✿✿✿✿✿✿✿✿\r\n♥ - life\r\n✖  - death";

	@Test
	public void testPrintWood() throws IOException, CodeException { //print wood
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.PrintWood();
		String s="✿✿✿✿✿✿✿✿✿\r\n" +
				 "✿○○○○○✿✖✿\r\n" +
				 "✿✿✿✿✿○✿○✿\r\n" +
				 "✿○○○✿○✿○✿\r\n" +
				 "✿○✿○○○✿○✿\r\n" +
				 "✿○✿✿✿✿✿○✿\r\n" +
				 "✿○○○○○○♥✿\r\n" +
				 "✿✿✿✿✿✿✿✿✿\r\n" +	
				 "\r\n" +
				 "♥ - life\r\n" +
				 "✖ - death\r\n" ;
		assertEquals(s, outstream.toString());
	}
	
	@Test
	public void testCreateWoodman1() throws IOException, CodeException { //createWoodman on a space
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Billy", new Point(4, 1));
		String s ="✿✿✿✿✿✿✿✿✿\r\n" +
				  "✿○○○B○✿✖✿\r\n" +
				  "✿✿✿✿✿○✿○✿\r\n" +
				  "✿○○○✿○✿○✿\r\n" +
				  "✿○✿○○○✿○✿\r\n" +
				  "✿○✿✿✿✿✿○✿\r\n" +
				  "✿○○○○○○♥✿\r\n" +
				  "✿✿✿✿✿✿✿✿✿\r\n" +	
				  "\r\n" +
				  "♥ - life\r\n" +
				  "✖ - death\r\n" +
				  "B - Billy(3 lives)\r\n";
		assertEquals(s, outstream.toString());
	}

	@Test(expected=CodeException.class)
	public void testException() throws IOException, CodeException { //createWoodman on a wall
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Vincent", new Point(0, 0));
	}

	@Test
	public void testCreateWoodman2() throws IOException, CodeException { //createWoodman on a trap
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Molly", new Point(7, 1));
		String s="✿✿✿✿✿✿✿✿✿\r\n" +
				 "✿○○○○○✿M✿\r\n" +
				 "✿✿✿✿✿○✿○✿\r\n" +
				 "✿○○○✿○✿○✿\r\n" +
				 "✿○✿○○○✿○✿\r\n" +
				 "✿○✿✿✿✿✿○✿\r\n" +
				 "✿○○○○○○♥✿\r\n" +
				 "✿✿✿✿✿✿✿✿✿\r\n" +	
				 "\r\n" +
				 "♥ - life\r\n" +
				 "✖ - death\r\n" +
				 "M - Molly(3 lives)\r\n";	
		assertEquals(s, outstream.toString());
	}

	@Test
	public void testCreateWoodman3() throws IOException, CodeException {  //createWoodman on a life
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Chris", new Point(7, 6));
		String s="✿✿✿✿✿✿✿✿✿\r\n" +
				 "✿○○○○○✿✖✿\r\n" +
				 "✿✿✿✿✿○✿○✿\r\n" +
				 "✿○○○✿○✿○✿\r\n" +
				 "✿○✿○○○✿○✿\r\n" +
				 "✿○✿✿✿✿✿○✿\r\n" +
				 "✿○○○○○○C✿\r\n" +
				 "✿✿✿✿✿✿✿✿✿\r\n" +	
				 "\r\n" +
				 "♥ - life\r\n" +
				 "✖ - death\r\n" +
				 "C - Chris(3 lives)\r\n";
		assertEquals(s, outstream.toString());
	}

	@Test
	public void testIncreaseLives() throws IOException, CodeException { //increase woodman's lives
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Alex", new Point(7, 6));
		wood.move("Alex",  Direction.Right);
		String s="✿✿✿✿✿✿✿✿✿\r\n" +
				 "✿○○○○○✿✖✿\r\n" +
				 "✿✿✿✿✿○✿○✿\r\n" +
				 "✿○○○✿○✿○✿\r\n" +
				 "✿○✿○○○✿○✿\r\n" +
				 "✿○✿✿✿✿✿○✿\r\n" +
				 "✿○○○○○○A✿\r\n" +
				 "✿✿✿✿✿✿✿✿✿\r\n" +	
				 "\r\n" +
				 "♥ - life\r\n" +
				 "✖ - death\r\n" +
				 "A - Alex(4 lives)\r\n";				
		assertEquals(s, outstream.toString());
	}

	@Test
	public void testDecreaseLives() throws IOException, CodeException { //decrease woodman's lives
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Jane", new Point(7, 1));
		wood.move("Jane", Direction.Up);	
		String s="✿✿✿✿✿✿✿✿✿\r\n" +
				 "✿○○○○○✿J✿\r\n" +
				 "✿✿✿✿✿○✿○✿\r\n" +
				 "✿○○○✿○✿○✿\r\n" +
				 "✿○✿○○○✿○✿\r\n" +
				 "✿○✿✿✿✿✿○✿\r\n" +
				 "✿○○○○○○♥✿\r\n" +
				 "✿✿✿✿✿✿✿✿✿\r\n" +	
				 "\r\n" +
				 "♥ - life\r\n" +
				 "✖ - death\r\n" +
				 "J - Jane(2 lives)\r\n";	
		assertEquals(s, outstream.toString());		
	}

	@Test
	public void testMove() throws IOException, CodeException { //simply move
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,outstream);
		wood.createWoodman("Dorian", new Point(3, 4));
		wood.move("Dorian", Direction.Left);	
		String s="✿✿✿✿✿✿✿✿✿\r\n" +
				 "✿○○○○○✿✖✿\r\n" +
				 "✿✿✿✿✿○✿○✿\r\n" +
				 "✿○○○✿○✿○✿\r\n" +
				 "✿○D○✿○✿○✿\r\n" +
				 "✿○✿✿✿✿✿○✿\r\n" +
				 "✿○○○○○○♥✿\r\n" +
				 "✿✿✿✿✿✿✿✿✿\r\n" +	
				 "\r\n" +
				 "♥ - life\r\n" +
				 "✖ - death\r\n" +
				 "D - Dorian(3 lives)\r\n";	
		assertEquals(s, outstream.toString());		
	}
}
