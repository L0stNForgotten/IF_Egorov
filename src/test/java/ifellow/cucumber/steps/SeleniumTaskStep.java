package ifellow.cucumber.steps;

import ifellow.pages.ProjectPage;
import ifellow.pages.TaskSeleniumPage;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public class SeleniumTaskStep {

    private final ProjectPage projectPage = new ProjectPage();
    private final TaskSeleniumPage taskSeleniumPage = new TaskSeleniumPage();

    @Тогда("нажимаем на кнопку списка задач")
    public void clickOnTaskList() {
        projectPage.taskListButtonClick();
    }

    @Тогда("проверяем, что список открылся")
    public void titleCheck() {
        taskSeleniumPage.taskTitleCheck();
    }

    @Тогда("ищем в поиске списка 'TestSeleniumATHomework'")
    public void searchTask() {
        taskSeleniumPage.taskInputField();
    }

    @Тогда("нажимаем на данную задачу")
    public void clickOnTask() {
        taskSeleniumPage.testingTaskInfoClick();
    }

    @Тогда("проверяем, что эта задача видна")
    public void taskInfoCheck() {
        taskSeleniumPage.testingTaskInfoCheck();
    }

    @Тогда("сравниваем статус и версию задачи с {string} и {string}")
    public void statusCheck(String status, String version) {
        String[] info = taskSeleniumPage.taskInfoGet();
        Assertions.assertTrue(info[0].equalsIgnoreCase(status));
        Assertions.assertTrue(info[1].equalsIgnoreCase(version));
    }
}
