public class ROT13  {
    public int value;

    ROT13(Character cs, Character cf) {
        if(cf - cs > 0) { this.value = cf - cs; }
        else if(cf - cs < 0) { this.value = -(cf - cs); }
    }

    ROT13() {
        this.value = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'm') { currentChar += value; }
            else if (currentChar >= 'n' && currentChar <= 'z') { currentChar -= value; }
            else if (currentChar >= 'A' && currentChar <= 'M') { currentChar += value; }
            else if (currentChar >= 'N' && currentChar <= 'Z') { currentChar -= value; }
            message.append(currentChar);
        }
        return message.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        return s.substring(s.indexOf(c)) + s.substring(0, s.indexOf(c));
    }

}
