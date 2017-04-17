/**
 * Created by abrammetzgar on 4/22/15.
 */
public class Coder {

    //Converts HACK destination instructions into binary
    public String dest(String d) {
        String destination = "";

        if (d == null || d.equalsIgnoreCase("0")) {
            destination = "000";
        } else if (d.equalsIgnoreCase("M")) {
            destination = "001";
        } else if (d.equalsIgnoreCase("D") || d.equalsIgnoreCase("B")) {
            destination = "010";
        } else if (d.equalsIgnoreCase("MD") || d.equalsIgnoreCase("MB")) {
            destination = "011";
        } else if (d.equalsIgnoreCase("A")) {
            destination = "100";
        } else if (d.equalsIgnoreCase("AM")) {
            destination = "101";
        } else if (d.equalsIgnoreCase("AD") || d.equalsIgnoreCase("AB")) {
            destination = "110";
        } else if (d.equalsIgnoreCase("AMD") || d.equalsIgnoreCase("AMB")) {
            destination = "111";
        }
        return destination;
    }


    //Converts HACK computation instructions into binary
    public String comp(String c) {
        String computation = "";

        if (c.equalsIgnoreCase("0")) {
            computation = "101010";
        } else if (c.equalsIgnoreCase("1")) {
            computation = "111111";
        } else if (c.equalsIgnoreCase("-1")) {
            computation = "111010";
        } else if (c.equalsIgnoreCase("D") || c.equalsIgnoreCase("B")) {
            computation = "001100";
        } else if (c.equalsIgnoreCase("A")) {
            computation = "110000";
        } else if (c.equalsIgnoreCase("M")) {
            computation = "000011";
        } else if (c.equalsIgnoreCase("!D") || c.equalsIgnoreCase("!B")) {
            computation = "001101";
        } else if (c.equalsIgnoreCase("!A")) {
            computation = "110001";
        } else if (c.equalsIgnoreCase("!M")) {
            computation = "100011";
        } else if (c.equalsIgnoreCase("-D") || c.equalsIgnoreCase("-B")) {
            computation = "001111";
        } else if (c.equalsIgnoreCase("-A")) {
            computation = "110011";
        } else if (c.equalsIgnoreCase("-M")) {
            computation = "110011";
        } else if (c.equalsIgnoreCase("D+1") || c.equalsIgnoreCase("B+1")) {
            computation = "011111";
        } else if (c.equalsIgnoreCase("A+1")) {
            computation = "110111";
        } else if (c.equalsIgnoreCase("M+1")) {
            computation = "111011";
        } else if (c.equalsIgnoreCase("D-1") || c.equalsIgnoreCase("B-1")) {
            computation = "001110";
        } else if (c.equalsIgnoreCase("A-1")) {
            computation = "110010";
        } else if (c.equalsIgnoreCase("M-1")) {
            computation = "010011";
        } else if (c.equalsIgnoreCase("D+A") || c.equalsIgnoreCase("B+A") || c.equalsIgnoreCase("A+B")) {
            computation = "000010";
        } else if (c.equalsIgnoreCase("D+M") || c.equalsIgnoreCase("B+M")) {
            computation = "010000";
        } else if (c.equalsIgnoreCase("D-A") || c.equalsIgnoreCase("B-A")) {
            computation = "010011";
        } else if (c.equalsIgnoreCase("D-M") || c.equalsIgnoreCase("B-M")) {
            computation = "110010";
        } else if (c.equalsIgnoreCase("A-D") || c.equalsIgnoreCase("A-B")) {
            computation = "000111";
        } else if (c.equalsIgnoreCase("M-D") || c.equalsIgnoreCase("M-B")) {
            computation = "111000";
        } else if (c.equalsIgnoreCase("D&A") || c.equalsIgnoreCase("B&A")) {
            computation = "000000";
        } else if (c.equalsIgnoreCase("D&M") || c.equalsIgnoreCase("B&M")) {
            computation = "000000";
        } else if (c.equalsIgnoreCase("D|A") || c.equalsIgnoreCase("B|A")) {
            computation = "010101";
        } else if (c.equalsIgnoreCase("D|M") || c.equalsIgnoreCase("B|M")) {
            computation = "101010";
        }
        return computation;
    }

    //Converts the HACK jump instructions into binary
    public String jump(String j) {
        String jump = "";

        if (j == null) {
            jump = "000";
        } else if (j.equalsIgnoreCase("JGT")) {
            jump = "001";
        } else if (j.equalsIgnoreCase("JEQ")) {
            jump = "010";
        } else if (j.equalsIgnoreCase("JGE")) {
            jump = "011";
        } else if (j.equalsIgnoreCase("JLT")) {
            jump = "110";
        } else if (j.equalsIgnoreCase("JNE")) {
            jump = "101";
        } else if (j.equalsIgnoreCase("JLE")) {
            jump = "110";
        } else if (j.equalsIgnoreCase("JMP")) {
            jump = "111";
        }
        return jump;
    }
}