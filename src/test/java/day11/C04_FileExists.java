package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test1() {
        // Şuanki içinde bulundugum dosyayı gösterir
        System.out.println(System.getProperty("user.dir"));

        // Gecerli kullanıcının ana dizinini verir.
        System.out.println(System.getProperty("user.home"));

        String dosyaYolu="C:\\Users\\pc\\OneDrive\\Masaüstü\\Yeni Metin Belgesi.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
