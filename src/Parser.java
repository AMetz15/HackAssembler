import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abrammetzgar on 4/22/15.
 */
public class Parser {

    static final int A_COMMAND = 0;
    static final int C_COMMAND = 1;
    static final int L_COMMAND = 2;

    String splitArray[];
    List<String> commands;
    int currentCommandCounter;

    //Parses file: removes whitespace and comments
    public Parser(String filePath) {

        commands = new ArrayList<String>();
        currentCommandCounter = -1;

        //Read in file
        try {
            File inFile = new File(filePath);
            Scanner in = new Scanner(inFile);

            while (in.hasNextLine()) {
                String line = in.nextLine();

                //remove comments
                line = line.replaceAll("//.*$", "");

                //remove whitespace
                line = line.replaceAll(" ", "");
                line = line.replaceAll("\t", "");

                if (line.length() > 0) {
                    commands.add(line);
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Test function to print out all commands after parsing
    public void dumpCommands() {

        for (int i = 0; i < commands.size(); i++) {
            System.out.println(commands.get(i));
        }
    }

    //Determines if file has more commands
    public boolean hasMoreCommands() {

        if (currentCommandCounter < commands.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    //Moves through the file
    public void advance() {

        currentCommandCounter = currentCommandCounter + 1;
    }

    //Resets counter to start at beginning of file again
    public void rewind() {

        currentCommandCounter = 0;
    }

    //Determines what command type the current line of the file is
    public int commandType() {

        if (commands.get(currentCommandCounter).startsWith("@")) {
            return A_COMMAND;

        } else if (commands.get(currentCommandCounter).startsWith("(")) {
            return L_COMMAND;

        } else {
            return C_COMMAND;

        }
    }

    //Returns the command on the current line in the file
    public String currentCommand() {

        return commands.get(currentCommandCounter);
    }

    //Returns the A or L command minus the symbols...e.g. (, ), @
    public String symbol() {

        String symbol = commands.get(currentCommandCounter);

        symbol = symbol.replace("(", "");
        symbol = symbol.replace(")", "");
        symbol = symbol.replace("@", "");

        //System.out.println(symbol);

        return symbol;
    }

    //If C command, returns the destination portion to convert
    public String dest() {
        String dest = commands.get(currentCommandCounter);
        String dst = "";

        if (!dest.startsWith("@")) {
            if (dest.contains(";")) {
                splitArray = dest.split(";");
                dst = splitArray[0];
            } else if (dest.contains("=")) {
                splitArray = dest.split("=");
                dst = splitArray[0];
            }
        }
        return dst;
    }

    //If C command, returns the computation portion to convert
    public String comp() {
        String comp = commands.get(currentCommandCounter);
        String cmp = "";

        if (!comp.startsWith("@")) {
            if (comp.contains(";")) {
                cmp = "0";
            } else if (comp.contains("=")) {
                splitArray = comp.split("=");
                cmp = splitArray[1];
            }
        }

        return cmp;
    }

    //If C command, returns the jump portion to convert
    public String jump() {
        String jump = commands.get(currentCommandCounter);
        String jmp = "";

        if (!jump.startsWith("@")) {
            if (jump.contains(";")) {
                splitArray = jump.split(";");
                jmp = splitArray[1];
            } else if (jump.contains("=")) {
                jmp = null;
            }
        }

        return jmp;
    }
}