package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Oppo A12");
        dc.setCapability("udid", "EEOZJR59DACELZD6");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        System.out.println("Appium Online");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Dashboard");

//        kelolaIzin(driver); // ini kalau appnya di Hapus data pakai ini, atau
        delay(5); // ini yg manual aja
        // ======================== Transaksi Kredit ================== //
        tambahTransaksi(driver);

        pilihJenisTransaksi(driver,"Pengeluaran");

        transaksi(driver, "1","30000", "Beli makan siang");

        delay(5);

        // ======================== Transaksi Debit ================== //
        tambahTransaksi(driver);

        pilihJenisTransaksi(driver,"Pemasukan");

        transaksi(driver, "3","2000000", "Gajian Agustus 2023");

        delay(5);

        // Tutup driver
        exit(driver);
    }
    public static void delay(long sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public static void exit(AndroidDriver driver){
        driver.quit();
        System.out.println("Exit");
    }
    public static void kelolaIzin(AndroidDriver driver){
        try {
            String izin = "com.android.packageinstaller:id/permission_allow_button";
            MobileElement izinkan = (MobileElement) driver.findElementById(izin);
            if (izinkan != null) {
                izinkan.click();
                System.out.println("Tombol Izinkan diklik.");
            } else {
                System.out.println("Tombol Izinkan tidak ditemukan.");
            }
            MobileElement tutup = (MobileElement) driver.findElementById("android:id/button2");
            if (tutup != null) {
                tutup.click();
                System.out.println("Tutup pencadangan");
            } else {
                System.out.println("Tombol pencadangan tidak ditemukan.");
            }
        } catch (Exception e) {
            driver.quit();
            System.out.println("Terjadi kesalahan saat mencoba mengklik tombol Izinkan: " + e.getMessage());
        }
    }
    public static void tambahTransaksi(AndroidDriver driver){
        MobileElement btnTambahTransaksi = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnTambahTransaksi.click();
        System.out.println("Tambah Transaksi");
    }
    public static void pilihJenisTransaksi(AndroidDriver driver, String jenis){
        switch (jenis){
            case "Pemasukan":
                MobileElement tabDeposit = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
                tabDeposit.click();
                System.out.println("Pindah ke pemasukan");
                break;
            case "Pengeluaran":
                MobileElement tabKredit = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
                tabKredit.click();
                System.out.println("Pindah ke pengeluaran");
                break;
            default:
                break;
        }
    }
    public static void transaksi(AndroidDriver driver, String idxKategori, String jumlah, String keterangan){
        //Halaman Buat Transaksi
        MobileElement inputKalender = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        inputKalender.click();
        MobileElement btnOkeKalender = (MobileElement) driver.findElementById("android:id/button1");
        btnOkeKalender.click();
        System.out.println("Input kalender");

        MobileElement inputKategori = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        inputKategori.click();
        String kategori = "/hierarchy//android.widget.LinearLayout["+ idxKategori +"]//android.widget.TextView";
        MobileElement pilihKategori = (MobileElement) driver.findElementByXPath(kategori);
        pilihKategori.click();
        System.out.println("Input kategori");

        MobileElement inputJumlah = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        inputJumlah.setValue(jumlah);
        System.out.println("Input nominal");
        MobileElement inputKeterangan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        inputKeterangan.setValue(keterangan);
        String note = inputKeterangan.getText();
        System.out.println("Input keterangan");

        MobileElement btnSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSimpan.click();
        System.out.println("Simpan");

        //============verifikasi ===========//
        //Di halaman Dashboard
        String hasil = "/hierarchy//android.view.ViewGroup[2]//android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]";
        MobileElement listDashboard = (MobileElement) driver.findElementByXPath(hasil);

        String actual = listDashboard.getText();
        String expect = note;

        if (actual.equals(expect)){
            System.out.println("Berhasil ditambahkan!");
        } else {
            System.out.println("Gagal nih gan...");
        }
    }
}
