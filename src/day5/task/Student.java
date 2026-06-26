package day5.task;

public class Student {
    private final int id;
    private final String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    //점수 수정
    public void updateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0점 이상, 100점 이하여야 합니다.");
        }
        this.score = score;
    }

    //합불
    public PassStatus getPassStatus() {
        return score >= 60 ? PassStatus.PASSED : PassStatus.FAILED;
    }

    @Override
    public String toString() {
        return id + " / " + name + " / " + score + " / " + getPassStatus().getLabel();
    }
}
