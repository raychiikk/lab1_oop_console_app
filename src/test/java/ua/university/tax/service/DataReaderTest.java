package ua.university.tax.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.university.tax.model.Taxpayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataReaderTest {

    @Test
    void testLoadAllIncomeTypes(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.csv");
        Files.writeString(file, "Oleg;2\nEMPLOYMENT;Job;10000;true\nGIFT;Gift;5000;CASH;0.05\n");
        
        Taxpayer taxpayer = DataReader.loadTaxpayerData(file.toString());
        
        assertEquals("Oleg", taxpayer.getName());
        assertEquals(2, taxpayer.getIncomes().size());
    }

    @Test
    void testFileDoesNotExist() {
        assertThrows(IOException.class, () -> DataReader.loadTaxpayerData("nonexistent.csv"));
    }

    @Test
    void testEmptyFileThrowsException(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("empty.csv");
        Files.createFile(file);
        
        assertThrows(IllegalArgumentException.class, () -> DataReader.loadTaxpayerData(file.toString()));
    }

    @Test
    void testUnknownTypeThrowsException(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("bad_type.csv");
        Files.writeString(file, "Oleg;2\nUNKNOWN;Job;10000;true\n");
        
        assertThrows(IllegalArgumentException.class, () -> DataReader.loadTaxpayerData(file.toString()));
    }
}