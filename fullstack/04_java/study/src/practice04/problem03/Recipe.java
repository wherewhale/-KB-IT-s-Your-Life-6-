package practice04.problem03;

//Recipe 클래스에 다음과 같은 필드를 선언하세요:
//String title (레시피 제목, protected)
//int cookTime (조리 시간, protected)
//boolean isVegan (비건 여부, protected)
//Recipe 클래스는 getDescription()과 toString() 메소드를 정의하세요.
//KoreanRecipe, VeganRecipe 클래스는 Recipe를 상속받고,
//생성자에서 필드 초기화, getDescription()을 오버라이딩 하세요.

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
