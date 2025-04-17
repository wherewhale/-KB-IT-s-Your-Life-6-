package practice04.problem04;

public class FusionRecipe extends Recipe {
    FusionRecipe() {
        super.title = "김치찌개";
        super.cookTime = 20;
        super.isVegan = false;
    }

    @Override
    public String getDescription() {
        return "매콤달콤한 불닭파스타를 추천합니다!";
    }
}
