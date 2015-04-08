package bf.implementation.a;
import java.util.ArrayList;

/**
 * A Brainfuck Interpreter implementation using forward and reverse seek
 * to implement looping.
 * 
 * Looping strategy adapted from: http://stackoverflow.com/a/1059162/475329
 * 
 * Interpreter grammar from: http://en.wikipedia.org/wiki/Brainfuck
 * 
 * Assumptions: 
 * 1) The tape grows infinitely to the right
 * 2) The tape point resets to zero if moved past the leftmost cell
 * 3) A read cannot be made on input that does not exist
 */
public class BFInterpreterA {
	
	public static String execute(String program, String input){
		// initialize the tape to 1 cell with value 0
		// memory is unbounded in this implementation
		ArrayList<Byte> memory = new ArrayList<Byte>();
		memory.add((byte)0x00);
		
		// initialize the memory pointer (index into memory)
		int mp = 0;
		
		// initialize the instruction pointer (index into program)
		int ip = 0;
		
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
						int depth = 0;
						while (true) {
							ip++;
							if (program.charAt(ip) == '[') {
								depth++;
								continue;
							} else if (program.charAt(ip) == ']') {
								if (depth == 0) {
									break;
								} else if (depth > 0) {
									depth--;
									continue;
								}
							}
						}
					}
					break;
				case ']':
					if (memory.get(mp) != 0) {
						int depth = 0;
						while (--ip > 0) {
							if (program.charAt(ip) == ']') {
								++depth;
								continue;
							} else if (program.charAt(ip) == '[') {
								if (depth == 0) {
									break;
								} else if (depth > 0) {
									depth--;
									continue;
								}
							}
						}
					}
					break;
				default:
					break;
			}
		} while (++ip < program.length());
		
		return output;
	}

}
