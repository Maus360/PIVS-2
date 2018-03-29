package sample;

public class Exam{
    private String name;
    private int score;

    Exam(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return String.valueOf(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) throws Exception {
        if (score >= 0){
            if (score <= 10) this.score = score;
            else throw new Exception("ERROR");
        }
        else throw new Exception("ERROR");
    }
}
