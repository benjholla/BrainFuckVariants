package bf.implementation.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * A Brainfuck Interpreter implementation using a computed jump table
 * to implement looping.
 * 
 * Looping strategy adapted from: http://stackoverflow.com/a/3041005/475329
 * 
 * Interpreter grammar from: http://en.wikipedia.org/wiki/Brainfuck
 * 
 * Assumptions: 
 * 1) The tape grows infinitely to the right
 * 2) The tape point resets to zero if moved past the leftmost cell
 * 3) A read cannot be made on input that does not exist
 */
public class BFInterpreterB {
	
	public static String execute(String program, String input){
		// initialize the tape to 1 cell with value 0
		// memory is unbounded in this implementation
		ArrayList<Byte> memory = new ArrayList<Byte>();
		memory.add((byte)0x00);
		
		// initialize the memory pointer (index into memory)
		int mp = 0;
		
		// initialize the instruction pointer (index into program)
		int ip = 0;
		
		// compute the jump table for given program
		LinkedList<Integer> stack = new LinkedList<Integer>();
		HashMap<Integer,Integer> jump = new HashMap<Integer,Integer>();
		
		for(int i=0; i<program.length(); i++){
			if(program.charAt(i) == '['){
				stack.push(i);
			} else if(program.charAt(i) == ']'){
				jump.put(i, stack.pop()); // jump from ] to [
				jump.put(jump.get(i), i); // jump from [ to ]
			}
		}
		
		// using a string as an output stream
		String output = "";
		
		do {
			char instruction = program.charAt(ip);
			switch(instruction){
				case '+':
					byte incrementValue = memory.remove(mp);
					memory.add(mp, ++incrementValue);
					break;
				case '-':
					byte decrementValue = memory.remove(mp);
					memory.add(mp, --decrementValue);
					break;
				case '>':
					mp++;
					if(mp == memory.size()){
						// we have reached the end of the tape, grow by one cell
						memory.add((byte)0x00);
					}
					break;
				case '<':
					mp = (mp>0) ? mp-1 : 0;
					break;
				case ',':
					memory.remove(mp);
					memory.add(mp, (byte)input.charAt(0));
					input = input.substring(1,input.length());
					break;
				case '.':
					// debug and live output stream
					//System.out.print(new String(new byte[] {memory.get(mp)}));
					output += new String(new byte[] {memory.get(mp)});
					break;
				case '[':
					if (memory.get(mp) == 0) {
						ip = jump.get(ip);
					}
					break;
				case ']':
					if (memory.get(mp) != 0) {
						ip = jump.get(ip);
					}
					break;
				default:
					break;
			}
		} while (++ip < program.length());
		
		return output;
	}

}
