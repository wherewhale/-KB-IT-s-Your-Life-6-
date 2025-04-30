package practice10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import practice10.popularity.DollPopularityManager;

@AllArgsConstructor
@NoArgsConstructor
public class ShowRankingCommand implements Command {
    DollPopularityManager popularityManager;


    @Override
    public void execute() {
        popularityManager.showRanking();
    }
}
