/**
 * Created by abrammetzgar on 4/22/15.
 */

public class Assembler {

    public static void main(String[] args) {

        String filePath = "MaxL.asm";

        Parser parser = new Parser(filePath);
        SymbolTable st = new SymbolTable();
        Coder coder = new Coder();

        //parser.dumpCommands();

        //pass 1, load labels into symbol table
        int romIndex = 0;

        while (parser.hasMoreCommands()) {
            parser.advance();

            if (parser.commandType() == parser.L_COMMAND) {
                st.addEntry(parser.symbol(), romIndex);
//                System.out.println(parser.symbol() + "; " + romIndex);
            } else {
                romIndex++;
            }

//            System.out.println(parser.currentCommand());
        }
        //Prints out the symbol table
        //st.dumpTable();

        //Resets counter to start at beginning of table
        parser.rewind();

        //pass 2,
        int ramIndex = 16;
        while (parser.hasMoreCommands()) {
            parser.advance();
            //if A_COMMAND
            if (parser.commandType() == parser.A_COMMAND) {
                //add symbol to symbol table if not already there
                if (!st.contains(parser.symbol())) {
                    st.addEntry(parser.symbol(), ramIndex);
                    ramIndex++;
                }
                //print out A_COMMAND, convert integer to binary
                System.out.println("0" + String.format("%15s", Integer.toBinaryString(st.getAddress(parser.symbol()))).replace(' ', '0'));
            } else if (parser.commandType() == parser.C_COMMAND) {
                //print out C command
                System.out.println("1110" + coder.comp(parser.comp()) + coder.dest(parser.dest()) + coder.jump(parser.jump()));
            }
        }
    }
}
