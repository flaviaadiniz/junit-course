public class StringHelper {

    // AACD => CD  ACD => CD   CDEF => CDEF   CDAA => CDAA
    public String truncateAInFirst2Positions(String str) {
        if (str.length() <= 2)
            return str.replaceAll("A", "");

        String first2Chars = str.substring(0, 2); // gets the first 2 characters
        String stringMinusFirst2Chars = str.substring(2); // creates a new string starting from the index passed as a parameter

        return first2Chars.replaceAll("A", "")
                + stringMinusFirst2Chars;
    }

    public boolean areFirstAndLastTwoCharactersTheSame(String str) {

        if (str.length() <= 1)
            return false;
        if (str.length() == 2)
            return true;

        String first2Chars = str.substring(0, 2);

        String last2Chars = str.substring(str.length() - 2);

        return first2Chars.equals(last2Chars);
    }

}
