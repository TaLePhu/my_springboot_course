package my.springboot.lap6_springdatajpa.common;

import my.springboot.lap6_springdatajpa.entities.SinhVien;
import my.springboot.lap6_springdatajpa.impl.SinhVienDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    public CommandLineRunner getRunner(SinhVienDaoImpl sinhVienDaoImpl) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            while ( true) {
                printMenu();
                int ch = scanner.nextInt();
                scanner.nextLine();
                if (ch == 1) {
                    themSinhVien(sinhVienDaoImpl);
                }
            }


        };
    }

    private void printMenu() {
        System.out.println("=============================MENU=================");
        System.out.println("MENU:\n"+
                            "1. Them sinh vien.\n" +
                            "2. Tim Sinh vien.\n" +
                            "3. Xoa Sinh vien. \n"
                );
    }

    /* Them Sinh Vien*/
    private void themSinhVien(SinhVienDaoImpl sinhVienDaoImpl) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten sinh vien: ");
        String ten = scanner.nextLine();
        System.out.println("Nhap ho dem: ");
        String hoDem = scanner.nextLine();
        System.out.println("Nhap email: ");
        String email = scanner.nextLine();

        SinhVien sv = new SinhVien(hoDem,ten, email);

        sinhVienDaoImpl.save(sv);
    }


}
