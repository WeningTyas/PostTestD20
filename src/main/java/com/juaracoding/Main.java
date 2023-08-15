package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
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

        //Halaman Dashboard
        MobileElement btnTambahTransaksi = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnTambahTransaksi.click();
        System.out.println("Tambah Transaksi");

        // ======================== Transaksi Kredit ================== //
        MobileElement tabKredit = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
        tabKredit.click();
        //Halaman Buat Transaksi
        MobileElement inputKalender = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        inputKalender.click();
        MobileElement btnOkeKalender = (MobileElement) driver.findElementById("android:id/button1");
        btnOkeKalender.click();
        System.out.println("Input kalender");

        MobileElement inputKategori = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        inputKategori.click();
        String kategori = "/hierarchy//android.widget.LinearLayout[1]//android.widget.TextView";
        ///hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView
        MobileElement pilihKategori = (MobileElement) driver.findElementByXPath(kategori);
        pilihKategori.click();
        System.out.println("Input kategori");

        MobileElement inputJumlah = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        inputJumlah.setValue("100000");
        System.out.println("Input nominal");
        MobileElement inputKeterangan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        inputKeterangan.setValue("Belanja");
        String keterangan = inputKeterangan.getText();
        System.out.println("Input keterangan");

        MobileElement btnSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSimpan.click();
        System.out.println("Simpan");

        //verifikasi
        String hasil = "/hierarchy//android.view.ViewGroup[2]//android.widget.ExpandableListView/android.widget.LinearLayout[1]//android.widget.TextView[2]";
        ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]
        MobileElement listDashboard = (MobileElement) driver.findElementByXPath(hasil);

        //verifikasi
        System.out.println("list " + listDashboard.getText());
        System.out.println("input "+ keterangan);

        if (listDashboard.getText().equals(keterangan)){
            System.out.println("oke");
        } else {
            System.out.println("False");
        }

        delay(5);

        //Halaman Dashboard
        btnTambahTransaksi.click();
        System.out.println("Tambah Transaksi");

        MobileElement tabDeposit = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        tabDeposit.click();
        System.out.println("Pindah ke pemasukan");

        // ======================== Transaksi Debit ================== //
        //Halaman Buat Transaksi
        MobileElement inputKalender2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        inputKalender2.click();
        MobileElement btnOkeKalender2 = (MobileElement) driver.findElementById("android:id/button1");
        btnOkeKalender2.click();
        System.out.println("Input kalender");

        MobileElement inputKategori2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        inputKategori2.click();
        String kategori2 = "/hierarchy//android.widget.LinearLayout[1]//android.widget.TextView";
        ///hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView
        MobileElement pilihKategori2 = (MobileElement) driver.findElementByXPath(kategori2);
        pilihKategori2.click();
        System.out.println("Input kategori");

        MobileElement inputJumlah2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        inputJumlah2.setValue("2000000");
        System.out.println("Input nominal");
        MobileElement inputKeterangan2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        inputKeterangan2.setValue("Gajian");
        String keterangan2 = inputKeterangan2.getText();
        System.out.println("Input keterangan");

        MobileElement btnSimpan2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSimpan2.click();
        System.out.println("Simpan");

        //verifikasi
        String hasil2 = "/hierarchy//android.view.ViewGroup[2]//android.widget.ExpandableListView/android.widget.LinearLayout[1]//android.widget.TextView[2]";
        ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]
        MobileElement listDashboard2 = (MobileElement) driver.findElementByXPath(hasil2);

        //verifikasi
        System.out.println("list " + listDashboard2.getText());
        System.out.println("input "+ keterangan2);

        if (listDashboard2.getText().equals(keterangan2)){
            System.out.println("oke");
        } else {
            System.out.println("False");
        }

        // Tutup driver
        driver.quit();

    }
    public static void delay(long sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}


/*
* Aplikasi Android Catatan Keuangan:
* https://play.google.com/store/apps/details?id=com.chad.financialrecord

Buat automation testing menggunakan appium pada aplikasi android tersebut.
* Test case type positive:
* - tambah transaksi 1 pengeluaran dan 1 pemasukan,
*   kemudian lakukan validasi test.
*
*
* Kredit = uang keluar
* Debit = Uang masuk
* */