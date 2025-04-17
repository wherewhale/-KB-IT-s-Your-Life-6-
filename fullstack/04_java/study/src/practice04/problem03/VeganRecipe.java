package practice04.problem03;


public class VeganRecipe extends Recipe {
    VeganRecipe() {
        super.title = "두부 샐러드";
        super.cookTime = 10;
        super.isVegan = true;
    }

    @Override
    public String getDescription() {
        return "신선한 두부 샐러드를 추천합니다!";
    }
}
