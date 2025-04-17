package practice04.problem05;

//main() 메소드
//Recipe[] 배열에 Korean, Vegan, Fusion 레시피 인스턴스 담기
//반복문과 instanceof, 다운캐스팅을 사용해 다음과 같은 출력이 나오도록 구현:

public class Main {
    public static void main(String[] args) {
        Recipe[] recipes = {
                new KoreanRecipe(),
                new VeganRecipe(),
                new FusionRecipe()
        };

        for (int i = 0; i < recipes.length; i++) {
            printRecipe(recipes[i]);
            System.out.println();
        }
    }

    public static void printRecipe(Recipe recipe) {
        System.out.println(recipe.getDescription());

        if (recipe instanceof KoreanRecipe) {
            System.out.println(((KoreanRecipe) recipe).getSpicinessLevel());
        }

    }
}
