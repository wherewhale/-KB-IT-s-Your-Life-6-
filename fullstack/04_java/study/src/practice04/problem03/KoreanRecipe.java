package practice04.problem03;

public class KoreanRecipe extends Recipe {
    KoreanRecipe() {
        super.title = "김치찌개";
        super.cookTime = 20;
        super.isVegan = false;
    }

    @Override
    public String getDescription() {
        return "매콤한 김치찌개를 추천합니다!";
    }
}
