package my.springboot.lap6_springdatajpa.common;

import my.springboot.lap6_springdatajpa.entities.SinhVien;
import my.springboot.lap6_springdatajpa.impl.SinhVienDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
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
                else if (ch == 2) {
                    findStudentById(sinhVienDaoImpl);
                } else if (ch == 3) {
                    findAllStudent(sinhVienDaoImpl);
                } else if (ch == 4) {
                    findStudentByName(sinhVienDaoImpl);
                } else if (ch == 5) {
                    updateSinhVienTheoId(sinhVienDaoImpl);
                } else if (ch == 6) {
                    updateSinhVienTheoTen(sinhVienDaoImpl);
                } else if(ch == 7) {
                    removeSinhVienById(sinhVienDaoImpl);
                }
            }


        };
    }

    private void printMenu() {
        System.out.println("=============================MENU=================");
        System.out.println("MENU:\n"+
                            "1. Them sinh vien.\n" +
                            "2. find student by id.\n" +
                            "3. find all student. \n" +
                            "4. find student by name.\n" +
                            "5. update sinh vien by id.\n" +
                            "6. update sinh vien theo ten.\n" +
                            "7. delete sinh vien theo id.\n"
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

    private void findStudentById(SinhVienDaoImpl sinhVienDaoImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id Sinh vien: ");
        int id = scanner.nextInt();

        SinhVien sv = sinhVienDaoImpl.findById(id);

        if(sv == null) {
            System.out.println("sinh vien not found!!");
        } else {
            System.out.println(sv.toString());
        }
    }

    private void findAllStudent(SinhVienDaoImpl sinhVienDaoImpl) {
        List<SinhVien> svs = sinhVienDaoImpl.findAll();

        svs.forEach(s -> System.out.println(s));
    }

    private void findStudentByName(SinhVienDaoImpl sinhVienDaoImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Ten Sinh vien: ");
        String ten = scanner.nextLine();
        SinhVien sv = sinhVienDaoImpl.findByTen(ten);
        if(sv == null) {
            System.out.println("sinh vien not found!!");
        } else {
            System.out.println(sv.toString());
        }
    }

    /** update student by name */
    private void updateSinhVienTheoId(SinhVienDaoImpl sinhVienDaoImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id Sinh vien: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        SinhVien sv = sinhVienDaoImpl.findById(id);

        if(sv == null) {
            System.out.println("sinh vien not found!!");
        } else {
            System.out.println("nhap ten sinh vien: ");
            String ten = scanner.nextLine();
            System.out.println("Nhap ho dem: ");
            String hoDem = scanner.nextLine();
            System.out.println("Nhap email: ");
            String email = scanner.nextLine();
            sv.setTen(ten);
            sv.setHoDem(hoDem);
            sv.setEmail(email);
            sinhVienDaoImpl.update(sv);
            System.out.println("update sinh vien success!");
            System.out.println(sv.toString());
        }
    }

    private void updateSinhVienTheoTen(SinhVienDaoImpl sinhVienDaoImpl) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap Ten Sinh vien: ");
//        String ten = scanner.nextLine();
//        SinhVien sv = sinhVienDaoImpl.findByTen(ten);
//        if (sv == null) {
//            System.out.println("sinh vien not found!!");
//        } else {
//            System.out.println("--------enter changed student:-------- ");
//            System.out.println("Nhap ten sinh vien: ");
//            String name = scanner.nextLine();
//            System.out.println("Nhap ho dem: ");
//            String hoDem = scanner.nextLine();
//            System.out.println("Nhap email: ");
//            String email = scanner.nextLine();
//            sv.setTen(name);
//            sv.setHoDem(hoDem);
//            sv.setEmail(email);
//            sinhVienDaoImpl.updateAllTen(sv);
//            System.out.println("update sinh vien success!");
//            System.out.println(sv.toString());
//        }
    }


    private void removeSinhVienById(SinhVienDaoImpl sinhVienDaoImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id Sinh vien: ");
        int id = scanner.nextInt();
        sinhVienDaoImpl.deleteById(id);
        System.out.println("delete sinh vien success!");
    }

}
