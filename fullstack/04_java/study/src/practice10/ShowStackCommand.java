package practice10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import practice10.stack.DollStackManager;

@AllArgsConstructor
@NoArgsConstructor
public class ShowStackCommand implements Command {
    DollStackManager dollStackManager;

    @Override
    public void execute() {
        dollStackManager.showStack();
    }
}
