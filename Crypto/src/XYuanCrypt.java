public class XYuanCrypt extends ROT13{

    public XYuanCrypt() {
        this.value = 1;
    }

    @Override
    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'y') { currentChar += value; }
            else if (currentChar == 'z') { currentChar -= (value + 24); }
            else if (currentChar >= 'A' && currentChar <= 'Y') { currentChar += value; }
            else if (currentChar == 'Z') { currentChar -= (value + 24); }
            message.append(currentChar);
        }
        return message.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar >= 'b' && currentChar <= 'z') { currentChar -= value; }
            else if (currentChar == 'a') { currentChar += (value + 24); }
            else if (currentChar >= 'B' && currentChar <= 'Z') { currentChar -= value; }
            else if (currentChar == 'A') { currentChar += (value + 24); }
            message.append(currentChar);
        }
        return message.toString();
    }
}
