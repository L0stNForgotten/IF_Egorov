package ifellow.cucumber.steps;

import ifellow.pages.BugRepoPage;
import io.cucumber.java.ru.Тогда;

public class BugRepoStep {
    BugRepoPage bugRepoPage = new BugRepoPage();

    @Тогда("нажимаем кнопку полного создания задачи")
    public void openCreatorIssue() {
        bugRepoPage.createIssueButtonClick();
    }

    @Тогда("нажимаем на выбор типа задачи и вводим 'Ошибка'")
    public void chooseType() {
        bugRepoPage.issueTypeFieldInput();
    }

    @Тогда("вводим тему задачи - {string}")
    public void inputTopic(String topic) {
        bugRepoPage.issueTopicInput(topic);
    }

    @Тогда("вписываем в описание задачи {string}")
    public void inputDescription(String text) {
        bugRepoPage.issueDescriptionInput(text);
    }

    @Тогда("выбираем версию в 'Исправить в версиях'")
    public void chooseFixVersion() {
        bugRepoPage.issueFixVersionChoice();
    }

    @Тогда("меняем приоритет")
    public void changePriority() {
        bugRepoPage.changeIssuePriority();
    }

    @Тогда("выбираем метку задачи")
    public void chooseMark() {
        bugRepoPage.issueMarksFieldChoice();
    }

    @Тогда("вписываем в описание окружения {string}")
    public void inputEnvironment(String text) {
        bugRepoPage.issueEnvironmentDescriptionInput(text);
    }

    @Тогда("выбираем затронутую версию")
    public void chooseEnvVersion() {
        bugRepoPage.issueEnvironmentVersionChoice();
    }

    @Тогда("выбираем связанные задачи")
    public void chooseRelatedTasks() {
        bugRepoPage.issueRelatedTaskChoice();
    }

    @Тогда("выбираем задачу")
    public void chooseTask() {
        bugRepoPage.issueTaskChoiceInput();
    }

    @Тогда("выбираем себя исполнителем задачи")
    public void chooseAssignment() {
        bugRepoPage.issueAssignment();
    }

    @Тогда("выбираем ссылку на эпик")
    public void chooseEpic() {
        bugRepoPage.issueEpicChoiceClick();
    }

    @Тогда("выбираем спринт")
    public void chooseSprint() {
        bugRepoPage.issueSprintChoiceClick();
    }

    @Тогда("меняем серьёзность")
    public void changeSeverity() {
        bugRepoPage.changeIssueSeverity();
    }

    @Тогда("нажимаем на создание задачи")
    public void createTask() {
        bugRepoPage.createIssueBugRepo();
    }

    @Тогда("проверяем, что задача была создана")
    public void checkCreation() {
        bugRepoPage.checkIssueCreate();
    }
}
