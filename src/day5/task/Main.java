package day5.task;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);

        //학생 등록
        Classroom classroom = new Classroom();

        classroom.addStudent(1, "김하나", 87);
        classroom.addStudent(2, "이도윤", 92);
        classroom.addStudent(3, "박서준", 58);

        //전체 학생 출력
        System.out.println("==전체 학생 출력==");
        System.out.println(classroom.getStudents());

        //id 조회
        System.out.println("점수를 수정할 학생 id를 입력하세요: ");
        int id = scan.nextInt();
        Optional<Student> idstd = classroom.findById(id);

        if (idstd.isEmpty()) {
            System.out.println("찾는 학생이 없습니다.");
            return;
        }

        //점수 수정
        System.out.println("새 점수를 입력하세요: ");
        int score = scan.nextInt();
        idstd.get().updateScore(score);
        System.out.println(idstd.get());

        scan.nextLine();

        //이름 조회
        System.out.println("찾는 학생의 이름을 입력하세요: ");
        String name = scan.nextLine();
        List<Student> namestd = classroom.searchByName(name);

        if (namestd.isEmpty()) {
            System.out.println("찾는 학생이 없습니다.");
            return;
        }
        System.out.println(namestd.getFirst());

        //합격자 목록 출력
        System.out.println("==합격자 목록==");
        System.out.println(classroom.getPassedStudents());

        //최고 점수 학생 출력
        System.out.println("==최고점 학생==");
        classroom.findTopStudent().ifPresent(System.out::println);
    }
}
