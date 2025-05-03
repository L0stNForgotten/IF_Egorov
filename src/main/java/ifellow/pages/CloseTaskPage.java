package ifellow.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CloseTaskPage {
    private final SelenideElement onTaskSwitch = $x("//div[contains(@class,'message-success')]//a")
            .as("Кнопка перехода на страницу созданного задания");

    private final SelenideElement taskInProgress = $x("//a[@id='action_id_21']")
            .as("Кнопка 'В работе'");

    private final SelenideElement taskStatusCheck = $x("//span[@id='status-val']//span[contains(@class, 'issue-status')]")
            .as("Проверка статуса");

    private final SelenideElement taskBusinessProcess = $x("//span[text()='Бизнес-процесс']")
            .as("Кнопка бизнес процесс");

    private final SelenideElement taskBusinessProcessListItem = $x("//aui-item-link//a[@role='menuitem']//span[text()='Выполнено']")
            .as("Элемент из списка 'Выполнено'");

    public void closeTaskFromBugRepo() {
        onTaskSwitch
                .shouldBe(interactable, Duration.ofSeconds(15))
                .click();
        taskInProgress
                .shouldBe(interactable, Duration.ofSeconds(15))
                .click();
        taskStatusCheck.shouldBe(interactable, Duration.ofSeconds(15)).shouldHave(text("В работе"));
        taskBusinessProcess.shouldBe(interactable, Duration.ofSeconds(15)).click();
        taskBusinessProcessListItem.shouldBe(interactable, Duration.ofSeconds(10)).click();
        taskStatusCheck.shouldBe(interactable, Duration.ofSeconds(15));
        taskStatusCheck.shouldBe(interactable, Duration.ofSeconds(15)).shouldHave(text("Готово"));

    }
}
