package practice07.problem03;

public class AppMain {
    public static void main(String[] args) {
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영")
        };

        MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
        FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
        maleGame.printCandidates();
        femaleGame.printCandidates();

    }
}
