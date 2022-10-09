
public class Encoder extends OffsetTable implements Encode{

    private static final int TOTAL_CHARS = 44;

    public Encoder(){
    }

    @Override
    public String encode(String plainText) {
        int offSetValue = 0;

        try {
            offSetValue = getIndexAtChar(plainText.charAt(0));
            String shiftedData = shiftString(plainText.substring(1), offSetValue, true);
            String encodedString = plainText.substring(0,1);
            return encodedString.concat(shiftedData);
        } catch (IllegalCharException e) {
            return "INVALID OFFSET CHARACTER!";
        }
    }

    @Override
    public String decode(String encodedText) {
        int offSetValue = 0;

        try {
            offSetValue = getIndexAtChar(encodedText.charAt(0));
            String shiftedData = shiftString(encodedText.substring(1), offSetValue, false);
            String encodedString = encodedText.substring(0,1);
            return encodedString.concat(shiftedData);
        } catch (IllegalCharException e) {
            return "INVALID OFFSET CHARACTER!";
        }
    };

    private String shiftString(String textToShift, int shiftAmount, boolean isForward) throws IllegalCharException{
        int strLen = textToShift.length();
        String newString = "";

        for (int i = 0; i < strLen; i++) {
            char curChar = textToShift.charAt(i);
            if (Character.toString(curChar).isBlank())  {
                newString = newString.concat(" ");
                continue;
            }
            int curIdx = getIndexAtChar(curChar);
            if (isForward) {
                curIdx = (curIdx - shiftAmount);
                if (curIdx < 0) {
                    curIdx += TOTAL_CHARS;
                }
            } else {
                curIdx = (curIdx + shiftAmount) % TOTAL_CHARS;
            }

            String newCharInSting = Character.toString(getCharAtIndex(curIdx));
            newString = newString.concat(newCharInSting);
        }
        return newString;
    };


}
