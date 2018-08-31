package ProgramTest;

import Program.minCat;
import org.junit.Test;
import org.junit.Assert;

public class minCatTest {

	minCat mincat = new minCat();
	
	@Test
	public void checkIfCorrectOutputHelloHi() {
		Assert.assertEquals("loHi", mincat.mixString("Hello", "Hi") );
	}
	
	@Test
	public void checkIfCorrectOutputHelloJava() {
		Assert.assertEquals("ellojava", mincat.mixString("Hello", "java") );
	}
	
	@Test
	public void checkIfCorrectOutputJavaHello() {
		Assert.assertEquals("javaello", mincat.mixString( "java", "Hello") );
	}
	
	@Test
	public void checkIfCorrectOutputabcx() {
		Assert.assertEquals("cx", mincat.mixString( "abc", "x") );
	}
	
	@Test
	public void checkIfCorrectOutputxabc() {
		Assert.assertEquals("xc", mincat.mixString( "x", "abc") );
	}
	
	@Test
	public void checkIfCorrectOutputabc() {
		Assert.assertEquals("", mincat.mixString( "abc", "") );
	}
	
}
