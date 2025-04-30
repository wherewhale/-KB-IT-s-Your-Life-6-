package practice10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import practice10.history.DollHistoryManager;

@AllArgsConstructor
@NoArgsConstructor
public class ShowAllHistoryCommand implements Command {
    DollHistoryManager dollHistoryManager;


    @Override
    public void execute() {
        dollHistoryManager.showAllHistory();
    }
}
