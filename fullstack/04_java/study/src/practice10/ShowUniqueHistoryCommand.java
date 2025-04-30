package practice10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import practice10.history.DollHistoryManager;

@NoArgsConstructor
@AllArgsConstructor
public class ShowUniqueHistoryCommand implements Command {
    DollHistoryManager dollHistoryManager;

    @Override
    public void execute() {
        dollHistoryManager.showAllUniqueHistory();
    }
}
