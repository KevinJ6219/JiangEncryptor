public class Encryptor {
    /**
     * A two-dimensional array of single-character strings, instantiated in the constructor
     */
    private String[][] letterBlock;

    /**
     * The number of rows of letterBlock, set by the constructor
     */
    private int numRows;

    /**
     * The number of columns of letterBlock, set by the constructor
     */
    private int numCols;

    /**
     * Constructor
     */
    public Encryptor(int r, int c) {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock() {
        return letterBlock;
    }

    /**
     * Places a string into letterBlock in row-major order.
     *
     * @param str the string to be processed
     *            <p>
     *            Postcondition:
     *            if str.length() < numRows * numCols, "A" in each unfilled cell
     *            if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str) {
        int length = str.length();
        int letterIndx = 0;
        if (length < numRows * numCols) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (letterIndx <= length - 1) {
                        letterBlock[i][j] = str.substring(letterIndx, letterIndx + 1);
                        letterIndx++;
                    }
                    else {
                        letterBlock[i][j] = "A";
                    }
                }
            }
        } else {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    letterBlock[i][j] = str.substring(letterIndx, letterIndx + 1);
                    letterIndx++;
                }
            }
        }
    }

    /**
     * Extracts encrypted string from letterBlock in column-major order.
     * <p>
     * Precondition: letterBlock has been filled
     *
     * @return the encrypted string from letterBlock
     */
    public String encryptBlock() {
        String encrypt = "";
        for (int j = 0; j < letterBlock[0].length; j++) {
            for (int i = 0; i < letterBlock.length; i++) {
                encrypt += letterBlock[i][j];
            }
        }
        return encrypt;
    }

    /**
     * Encrypts a message.
     *
     * @param message the string to be encrypted
     * @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message) {
        int chunkSize = numCols + numRows;
        int letterIndex = 0;
        String encryptMessage = "";
        while (letterIndex < message.length() - chunkSize) {
            fillBlock(message.substring(letterIndex, letterIndex + chunkSize));
            encryptMessage += encryptBlock();
            System.out.println(encryptMessage);
            letterIndex += chunkSize;
        }
        return encryptMessage;
    }


    /**
     * Decrypts an encrypted message. All filler 'A's that may have been
     * added during encryption will be removed, so this assumes that the
     * original message (BEFORE it was encrypted) did NOT end in a capital A!
     * <p>
     * NOTE! When you are decrypting an encrypted message,
     * be sure that you have initialized your Encryptor object
     * with the same row/column used to encrypted the message! (i.e.
     * the “encryption key” that is necessary for successful decryption)
     * This is outlined in the precondition below.
     * <p>
     * Precondition: the Encryptor object being used for decryption has been
     * initialized with the same number of rows and columns
     * as was used for the Encryptor object used for encryption.
     *
     * @param encryptedMessage the encrypted message to decrypt
     * @return the decrypted, original message (which had been encrypted)
     * <p>
     * TIP: You are encouraged to create other helper methods as you see fit
     * (e.g. a method to decrypt each section of the decrypted message,
     * similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage) {
        return "";
    }
}
