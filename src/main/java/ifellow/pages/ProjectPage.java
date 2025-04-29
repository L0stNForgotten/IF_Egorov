package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;


public class ProjectPage {
    private final SelenideElement projectsTaskListButton = $x("//div[@class='aui-sidebar-body']//a[contains(@href,'/issues')]").as("Список задач");
    private final SelenideElement projectSearchFilters = $x("//button[@id='subnav-trigger']").as("Фильтр поиска");
    private final SelenideElement projectAllTasks = $x("//ul[@class='aui-list-truncate']//a[contains(text(), 'Все задачи')]").as("Фильтр 'Все задачи'");
    private final SelenideElement projectTasksCounter = $x("//div[@class='pager']//span[contains(text(), 'из')]").as("Счётчик задач");
    private final SelenideElement taskCreatorButton = $x("//div[@class='iic']//button").as("Кнопка создания задачи");
    private final SelenideElement taskTypeChoice = $x("//div[@class='iic-widget']//button[@aria-label='Выбрать тип задачи']").as("Вбор типа задачи");
    private final SelenideElement taskTypeError = $x("//ul[@class='aui-list-truncate']//a[contains(text(),'Ошибка')]").as("Выбор типа 'Ошибка' для задачи");
    private final SelenideElement taskInputField = $x("//textarea[@name='summary']").as("Поле ввода задачи");

    public void projectCheckFilter() {
        projectsTaskListButton.shouldBe(Condition.interactable).click();
        projectSearchFilters.shouldBe(Condition.interactable).click();
        projectAllTasks.shouldBe(Condition.interactable).click();
    }

    public Integer projectTasksCountCheck() {
        return Integer.parseInt(projectTasksCounter.shouldBe(Condition.visible).getText().split(" из ")[1]);
    }

    public void projectTaskCreator(String task) {
        taskCreatorButton.shouldBe(Condition.interactable).click();
        taskTypeChoice.shouldBe(Condition.interactable).click();
        taskTypeError.shouldBe(Condition.interactable).click();
        taskInputField.shouldBe(Condition.interactable).sendKeys(task, Keys.ENTER);
    }
}
