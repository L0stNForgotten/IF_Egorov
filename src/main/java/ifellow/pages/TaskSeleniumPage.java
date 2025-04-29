package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class TaskSeleniumPage {
    private final SelenideElement tasksListButton = $x("//div[@class='aui-sidebar-body']//ul[@class='aui-nav']//a[contains(@data-link-id,'plan-scrum')]").as("Кнопка списка всех задач");
    private final SelenideElement taskTitleCheck = $x("//span[@id]//span[@title='Список задач']").as("Заголовок страницы");
    private final SelenideElement taskInputField = $x("//input[@aria-label='Поиск задач']").as("Строка поиска");
    private final SelenideElement taskSeleniumTask = $x("//div//div[@title='TestSeleniumATHomework']/preceding-sibling::div[@class='ghx-key']").as("Задача 'TestSeleniumATHomework'");
    private final SelenideElement taskTaskTab = $x("//div[@id='ghx-detail-nav']").as("Панель информации задания");
    private final SelenideElement taskSeleniumTaskStatus = $x("//li[@class='item item-right']//span[contains(@class,'issue-status')]").as("Статус задачи");
    private final SelenideElement taskSeleniumVersion = $x("//li[@class='item item-right']//a[contains(@href,'/issues/')]").as("Версия задачи");

    public void taskInfoCheck() {
        tasksListButton.shouldBe(Condition.interactable).click();
        taskTitleCheck.shouldBe(Condition.visible);
        taskInputField.shouldBe(Condition.interactable).sendKeys("TestSeleniumATHomework", Keys.ENTER);
        taskSeleniumTask.shouldBe(Condition.exist).shouldBe(Condition.interactable).click();
        taskTaskTab.shouldBe(Condition.visible);
    }

    public String[] taskInfoGet() {
        return new String[]{
                taskSeleniumTaskStatus.shouldBe(Condition.visible).getText(),
                taskSeleniumVersion.shouldBe(Condition.visible).getText()
        };
    }
}
