import java.math.BigInteger;

public class RSA {

    // Method to check that e is a proper parameter for a public key given p and q
    public int checkPublicKey(int p, int q, int e) {
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        return (BigInteger.valueOf(e).gcd(phi).equals(BigInteger.ONE)) ? 1 : 0;
    }

    // Method to calculate the parameter d of the private key given p, q, e
    public int calculatePrivateKey(int p, int q, int e) {
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        BigInteger d = BigInteger.valueOf(e).modInverse(phi);
        return d.intValue();
    }

    // Method to encrypt a message
    public int encryptMessage(int m, int k, int n) {
        return BigInteger.valueOf(m).modPow(BigInteger.valueOf(k), BigInteger.valueOf(n)).intValue();
    }

    // Method to decrypt a message
    public int decryptMessage(int c, int k, int n) {
        return BigInteger.valueOf(c).modPow(BigInteger.valueOf(k), BigInteger.valueOf(n)).intValue();
    }

    // Method to create a digital signature
    public int createSignature(int m, int k, int n, int s) {
        int hashedMessage = m % s;
        return encryptMessage(hashedMessage, k, n);
    }

    // Method to validate a digital signature
    public int validateSignature(int signature, int m, int k, int n, int s) {
        int decryptedHash = decryptMessage(signature, k, n);
        int hashedMessage = m % s;
        return (decryptedHash == hashedMessage) ? 1 : 0;
    }
}

