import java.io.IOException;

public class EncryptionApp {
    public static void main(String[] args) throws IOException {
        ROT13 rot13 = new ROT13();
        CaesarCrypt caesarCrypt = new CaesarCrypt();
        XYuanCrypt xYuanCrypt = new XYuanCrypt();

        rot13.writeEncryptedFile();
        rot13.writeDecryptedFile();
        caesarCrypt.writeEncryptedFile();
        caesarCrypt.writeDecryptedFile();
        xYuanCrypt.writeEncryptedFile();
        xYuanCrypt.writeDecryptedFile();
    }
}
