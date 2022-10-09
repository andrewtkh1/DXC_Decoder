public class OffsetTable {

    private static final String maskAZ = "[A-Z]";
    private static final String mask09 = "[0-9]";
    private static final String maskSpesh = "[()*+,\\-./]";

    private static final int ATOZASCII = 65;
    private static final int NUMBERASCII = 48;
    private static final int SPESHASCII = 40;
    private static final int NUMBERSTARTIDX = 26;
    private static final int SPECIALSTARTIDX = 36;

    protected static int getIndexAtChar(char ch) throws IllegalCharException {
        String chInStr = Character.toString(ch);
        int rawOffset = (int) ch;
        if (chInStr.matches(maskAZ)) {
            return rawOffset - ATOZASCII;
        } else if (chInStr.matches(mask09)) {
            return rawOffset - NUMBERASCII + 26;
        } else if (chInStr.matches(maskSpesh)) {
            return rawOffset - SPESHASCII + 36;
        } else {
            throw new IllegalCharException();
        }
    }

    protected static char getCharAtIndex(int idx) {
        assert (idx >= 0 && idx <= 43);
        if (idx <= 25) {
            idx += ATOZASCII;   // Start from ASCII A.
            return (char) idx;
        } else if (idx <= 35) { // 26 <= idx <= 35 | Start from ASCII 0
            idx = idx - NUMBERSTARTIDX + NUMBERASCII;
            return (char) idx;
        } else {                // 36 <= idx <= 43 | Start from ASCII Special chars
            idx = idx - SPECIALSTARTIDX + SPESHASCII;
            return (char) idx;
        }
    }
}
