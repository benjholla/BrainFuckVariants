package bf.tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bf.implementation.a.BFInterpreterA;

// Unit tests shameless copied from https://github.com/bogiebro/factor/blob/master/extra/brainfuck/brainfuck-tests.factor
// and http://esoteric.sange.fi/brainfuck/bf-source/prog/fibonacci.txt
public class BFInterpreterATests {

	@Test
	public void helloWorldTest() {
		assertEquals(BFInterpreterA.execute("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++" +
				                           ".>.+++.------.--------.>+.>.",""), "Hello World!\n");
	}
	
	@Test
	public void invalidCharsTest() {
		assertEquals(BFInterpreterA.execute("++++++++++[>+++++++>+++++invalid+++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++" +
				                           ".>.+++.------.--invalid------.>+.>.",""), "Hello World!\n");
	}
	
	@Test
	public void additionTest() {
		assertEquals(BFInterpreterA.execute(",>++++++[<-------->-],[<+>-]<.","35"), "8");
	}
	
	@Test
	public void uppercaseTest() {
		assertEquals(BFInterpreterA.execute(",----------[----------------------.,----------]","a\n"), "A");
	}
	
	@Test
	public void catTest() {
		assertEquals(BFInterpreterA.execute(",[.,]","ABC\0"), "ABC");
	}
	
	@Test
	public void fibonacciNumberTest() {
		assertEquals(BFInterpreterA.execute("+++++++++++>+>>>>++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++" +
				                           "++++++++++<<<<<<[>[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-<-[>>+>" +
				                           "+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[" +
				                           ">[-]<[-]]>[<<+>>[-]]<<<<<<<]>>>>>[++++++++++++++++++++++++++++++++++++++++++++++++.[" +
				                           "-]]++++++++++<[->-<]>++++++++++++++++++++++++++++++++++++++++++++++++.[-]<<<<<<<<<<<" +
				                           "<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>" +
				                           "-]<<<-]",""), "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89");
	}
	
}
