public class Main {
    public static void main(String[] args) {
        RSA rsa = new RSA();

        // Example values for p, q, and e
        int p = 7;
        int q = 11;
        int e = 17;

        // Check if e is a valid public key
        int check = rsa.checkPublicKey(p, q, e);
        System.out.println("Check Public Key: " + (check == 1 ? "Valid" : "Invalid"));

        // Calculate the private key
        int d = rsa.calculatePrivateKey(p, q, e);
        System.out.println("Calculated Private Key: " + d);

        // Encrypt a message
        int message = 13;
        int encryptedMessage = rsa.encryptMessage(message, e, p * q);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        int decryptedMessage = rsa.decryptMessage(encryptedMessage, d, p * q);
        System.out.println("Decrypted Message: " + decryptedMessage);

        // Create a digital signature
        int s = 5; // example hash mod value
        int signature = rsa.createSignature(message, d, p * q, s);
        System.out.println("Digital Signature: " + signature);

        // Validate the digital signature
        int validation = rsa.validateSignature(signature, message, e, p * q, s);
        System.out.println("Signature Validation: " + (validation == 1 ? "Valid" : "Invalid"));
    }
}
