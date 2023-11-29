package model.test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import model.HashedPW;

public class HashPassTest {

    @Test
    public void testHashPass() throws NoSuchAlgorithmException {
        // Arrange
        String password = "taiga";
        // SHA-256 hash of "myPassword123" for comparison
        String expectedHash = "1128aeaa8e15f7f4b139cd6cf44e7d2a4e4cdf43056ec93bb15774499850aedc";

        // Act
        String actualHash = HashedPW.hashPass(password);

        // Assert
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHashPassWithEmptyString() throws NoSuchAlgorithmException {
        // Arrange
        String password = "";
        // SHA-256 hash of "" (empty string) for comparison
        String expectedHash = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";

        // Act
        String actualHash = HashedPW.hashPass(password);

        // Assert
        assertEquals(expectedHash, actualHash);
    }
}
