public class CaesarCrypt extends ROT13{

    public CaesarCrypt() {
        this.value = 3;
    }

    @Override
    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'd' && currentChar <= 'z') { currentChar -= value; }
            else if (currentChar >= 'a' && currentChar <= 'c') { currentChar += (value + 20); }
            else if (currentChar >= 'D' && currentChar <= 'Z') { currentChar -= value; }
            else if (currentChar >= 'A' && currentChar <= 'C') { currentChar += (value + 20); }
            message.append(currentChar);
        }
        return message.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'w') { currentChar += value; }
            else if (currentChar >= 'x' && currentChar <= 'z') { currentChar -= (value + 20); }
            else if (currentChar >= 'A' && currentChar <= 'W') { currentChar += value; }
            else if (currentChar >= 'X' && currentChar <= 'Z') { currentChar -= (value + 20); }
            message.append(currentChar);
        }
        return message.toString();
    }
}
