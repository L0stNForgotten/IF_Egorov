package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class TaskSeleniumPage {
    private final SelenideElement tasksListButton = $x("//div[@class='aui-sidebar-body']//ul[@class='aui-nav']//a[contains(@data-link-id,'plan-scrum')]")
            .as("Кнопка списка всех задач");

    private final SelenideElement taskTitleCheck = $x("//span[@id]//span[@title='Список задач']")
            .as("Заголовок страницы");

    private final SelenideElement taskInputField = $x("//input[@aria-label='Поиск задач']")
            .as("Строка поиска");

    private final SelenideElement taskSeleniumTask = $x("//div//div[@title='TestSeleniumATHomework']/preceding-sibling::div[@class='ghx-key']")
            .as("Задача 'TestSeleniumATHomework'");

    private final SelenideElement taskTaskTab = $x("//div[@id='ghx-detail-nav']")
            .as("Панель информации задания");

    private final SelenideElement taskSeleniumTaskStatus = $x("//li[@class='item item-right']//span[contains(@class,'issue-status')]")
            .as("Статус задачи");

    private final SelenideElement taskSeleniumVersion = $x("//li[@class='item item-right']//a[contains(@href,'/issues/')]")
            .as("Версия задачи");

    public void taskInfoCheck() {
        tasksListButton.shouldBe(interactable).click();
        taskTitleCheck.shouldBe(visible);
        taskInputField.shouldBe(interactable).sendKeys("TestSeleniumATHomework", Keys.ENTER);
        taskSeleniumTask.shouldBe(exist).shouldBe(interactable).click();
        taskTaskTab.shouldBe(visible);
    }

    public String[] taskInfoGet() {
        return new String[]{
                taskSeleniumTaskStatus.shouldBe(visible).getText(),
                taskSeleniumVersion.shouldBe(visible).getText()
        };
    }
}
