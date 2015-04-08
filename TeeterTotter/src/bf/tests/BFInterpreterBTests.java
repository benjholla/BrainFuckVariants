package bf.tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bf.implementation.b.BFInterpreterB;

// Unit tests shameless copied from https://github.com/bogiebro/factor/blob/master/extra/brainfuck/brainfuck-tests.factor
// and http://esoteric.sange.fi/brainfuck/bf-source/prog/fibonacci.txt
public class BFInterpreterBTests {

	@Test
	public void helloWorldTest() {
		assertEquals(BFInterpreterB.execute("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++" +
				                           ".>.+++.------.--------.>+.>.",""), "Hello World!\n");
	}
	
	@Test
	public void invalidCharsTest() {
		assertEquals(BFInterpreterB.execute("++++++++++[>+++++++>+++++invalid+++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++" +
				                           ".>.+++.------.--invalid------.>+.>.",""), "Hello World!\n");
	}
	
	@Test
	public void additionTest() {
		assertEquals(BFInterpreterB.execute(",>++++++[<-------->-],[<+>-]<.","35"), "8");
	}
	
	@Test
	public void uppercaseTest() {
		assertEquals(BFInterpreterB.execute(",----------[----------------------.,----------]","a\n"), "A");
	}
	
	@Test
	public void catTest() {
		assertEquals(BFInterpreterB.execute(",[.,]","ABC\0"), "ABC");
	}
	
	@Test
	public void fibonacciNumberTest() {
		assertEquals(BFInterpreterB.execute("+++++++++++>+>>>>++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++" +
				                           "++++++++++<<<<<<[>[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-<-[>>+>" +
				                           "+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[" +
				                           ">[-]<[-]]>[<<+>>[-]]<<<<<<<]>>>>>[++++++++++++++++++++++++++++++++++++++++++++++++.[" +
				                           "-]]++++++++++<[->-<]>++++++++++++++++++++++++++++++++++++++++++++++++.[-]<<<<<<<<<<<" +
				                           "<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>" +
				                           "-]<<<-]",""), "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89");
	}
	
}
