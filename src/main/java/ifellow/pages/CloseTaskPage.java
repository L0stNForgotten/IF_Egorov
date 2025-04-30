package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Condition.*;

public class CloseTaskPage {
    private final SelenideElement onTaskSwitch = $x("//div[contains(@class,'message-success')]//a")
            .as("Кнопка перехода на страницу созданного задания");

    private final SelenideElement taskInProgress = $x("//a[@id='action_id_21']")
            .as("Кнопка 'В работе'");

    private final SelenideElement taskStatusCheck = $x("//span[@id='status-val']//span[contains(@class, 'issue-status')]")
            .as("Проверка статуса");

    private final SelenideElement taskBusinessProcess = $x("//span[text()='Бизнес-процесс']")
            .as("Кнопка бизнес процесс");

    public void closeTaskFromBugRepo () {
        onTaskSwitch
                .shouldBe(interactable, Duration.ofSeconds(15))
                .click();

        taskInProgress
                .shouldBe(interactable, Duration.ofSeconds(15))
                .click();

// Проверяем статус "В работе" с помощью Selenide условий
        taskStatusCheck.shouldBe(interactable, Duration.ofSeconds(15)).shouldHave(text("В работе"));

// Работаем с бизнес-процессом
        taskBusinessProcess.shouldBe(interactable, Duration.ofSeconds(15)).click();
        taskBusinessProcess.sendKeys(Keys.DOWN, Keys.ENTER);

// Проверяем статус "Готово"
        taskStatusCheck.shouldBe(interactable, Duration.ofSeconds(15));
        taskStatusCheck.shouldBe(interactable, Duration.ofSeconds(15)).shouldHave(text("Готово"));

    }
}
