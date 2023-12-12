import java.util.*;

class hillcipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String to encrypt: ");
        String plaintext = input.nextLine().toUpperCase(); 
        System.out.println("Enter the 3x3 Key Matrix (9 integers separated by spaces):");
        int[][] keyMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = input.nextInt();
            }
        }

        
        int padding = 3 - (plaintext.length() % 3);
        if (padding > 0) {
            for (int i = 0; i < padding; i++) {
                plaintext += 'X';
            }
        }

       
        String encryptedText = encrypt(plaintext, keyMatrix);

        System.out.println("Encrypted Text: " + encryptedText);

        input.close();
    }

    static String encrypt(String plaintext, int[][] keyMatrix) {
        StringBuilder encryptedText = new StringBuilder();
        int[] vector = new int[3];

        for (int i = 0; i < plaintext.length(); i += 3) {
            for (int j = 0; j < 3; j++) {
                vector[j] = plaintext.charAt(i + j) - 'A';
            }

            for (int j = 0; j < 3; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += keyMatrix[j][k] * vector[k];
                }
                encryptedText.append((char) ((sum % 26) + 'A'));
            }
        }

        return encryptedText.toString();
    }
}
