package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {
    private final SelenideElement projectsTaskListButton = $x("//div[@class='aui-sidebar-body']//a[contains(@href,'/issues')]")
            .as("Список задач");

    private final SelenideElement projectSearchFilters = $x("//button[@id='subnav-trigger']")
            .as("Фильтр поиска");

    private final SelenideElement projectAllTasks = $x("//ul[@class='aui-list-truncate']//a[contains(text(), 'Все задачи')]")
            .as("Фильтр 'Все задачи'");

    private final SelenideElement projectTasksCounter = $x("//div[@class='pager']//span[contains(text(), 'из')]")
            .as("Счётчик задач");

    private final SelenideElement taskCreatorButton = $x("//div[@class='iic']//button")
            .as("Кнопка создания задачи");

    private final SelenideElement taskTypeChoice = $x("//div[@class='iic-widget']//button[@aria-label='Выбрать тип задачи']")
            .as("Вбор типа задачи");

    private final SelenideElement taskTypeError = $x("//ul[@class='aui-list-truncate']//a[contains(text(),'Ошибка')]")
            .as("Выбор типа 'Ошибка' для задачи");

    private final SelenideElement taskInputField = $x("//textarea[@name='summary']")
            .as("Поле ввода задачи");

    private final SelenideElement taskRefreshCheck = $x("//div[@class='loading']")
            .as("Кнопка увеличения на весь экран для проверки обновления страницы");

    public void projectCheckFilter() {
        projectsTaskListButton.shouldBe(interactable).click();
        projectSearchFilters.shouldBe(interactable).click();
        projectAllTasks.shouldBe(interactable).click();
    }

    public Integer projectTasksCountCheck() {
        taskRefreshCheck.shouldBe(visible, Duration.ofSeconds(15));
        taskRefreshCheck.shouldNotBe(exist, Duration.ofSeconds(15));
        return Integer.parseInt(projectTasksCounter.shouldBe(visible, Duration.ofSeconds(15))
                .getText().split(" из ")[1]);
    }

    public void projectTaskCreator(String task) {
        taskCreatorButton.shouldBe(interactable).click();
        taskTypeChoice.shouldBe(interactable).click();
        taskTypeError.shouldBe(interactable).click();
        taskInputField.shouldBe(interactable).sendKeys(task, Keys.ENTER);
    }
}
