package practiceMehmetHoca;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02  {
    @Test
    public void test1() throws FileNotFoundException {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String dosyaYolu="pom.xml";

      // FileInputStream fis = new FileInputStream(dosyaYolu);
       // Assert.assertNotNull(fis);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
