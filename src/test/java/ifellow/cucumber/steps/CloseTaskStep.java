package ifellow.cucumber.steps;

import ifellow.pages.BugRepoPage;
import ifellow.pages.CloseTaskPage;
import io.cucumber.java.ru.Тогда;

public class CloseTaskStep {
    private final BugRepoPage bugRepoPage = new BugRepoPage();
    private final CloseTaskPage closeTaskPage = new CloseTaskPage();

    @Тогда("открываем созданную задачу")
    public void openCreatedTask() {
        bugRepoPage.openCustomBugRepoPage();
    }

    @Тогда("вводим задачу в состояние 'В работе' и проверяем")
    public void taskInProgress() {
        closeTaskPage.closeTaskInProgressState();
    }

    @Тогда("вводим задачу в состояние 'Готово' и проверяем")
    public void taskDone() {
        closeTaskPage.closeTaskDone();
    }
}
