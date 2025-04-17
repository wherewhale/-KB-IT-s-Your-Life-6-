package practice04.problem04;

public class Recipe {
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public String getDescription() {
        return "요리를 추천합니다!";
    }

    //"제목(조리시간분) - 비건여부" 형태
    public String toString() {
        return this.title + "(" + cookTime + "분)" + "- 비건" + (isVegan ? "" : " 아님");
    }

}

