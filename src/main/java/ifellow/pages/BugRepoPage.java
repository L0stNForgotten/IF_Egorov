package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class BugRepoPage {
    private final SelenideElement repoCreateIssueButton = $x("//a[@id='create_link']")
            .as("Кнопка создать");

    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']")
            .as("Поле ввода типа ошибки");

    private final SelenideElement issueTopicInput = $x("//input[@id='summary']")
            .as("Тема задачи");

    private final SelenideElement issueDescriptionVisualButton = $x("//div[@id='description-wiki-edit']//nav//li[@data-mode='wysiwyg']//button")
            .as("Кнопка 'Визуально' под описанием");

    private final SelenideElement issueDescriptionInput = $x("//div[@id='description-wiki-edit']//iframe")
            .as("Поле ввода описания");

    private final SelenideElement issueDescriptionVersion = $x("//label[text()['Исправить в версиях']]/following::select[@id='fixVersions']")
            .as("Исправить в версиях");

    private final SelenideElement issuePriorityField = $x("//input[@aria-label='Приоритет']")
            .as("Приоритет");

    private final SelenideElement issueMarksField = $x("//label[text()='Метки']/following-sibling::div//textarea")
            .as("Метки");

    private final SelenideElement issueEnvironmentVisualButton = $x("//div[@id='environment-wiki-edit']//nav//li[@data-mode='wysiwyg']//button")
            .as("Кнопка 'Визуально' под описанием окружения");

    private final SelenideElement issueEnvironmentInput = $x("//div[@id='environment-wiki-edit']//iframe")
            .as("Поле ввода описания окружения");

    private final SelenideElement getIssueEnvironmentVersion = $x("//label[text()['Затронуты версии']]/following::select[@id='versions']")
            .as("Затронутые версии");

    private final SelenideElement issueRelatedTasks = $x("//label[text()='Связанные задачи']/following-sibling::select[@name='issuelinks-linktype']")
            .as("Связанные задачи");

    private final SelenideElement issueTaskChoice = $x("//textarea[@id='issuelinks-issues-textarea']")
            .as("Выбор задачи");

    private final SelenideElement issueAssignToMe = $x("//button[text()='Назначить меня']")
            .as("Назначение исполнителя");

    private final SelenideElement issueEpicChoice = $x("//input[@id='customfield_10100-field']")
            .as("Выбор Эпика");

    private final SelenideElement issueSprintChoice = $x("//input[@id='customfield_10104-field']")
            .as("Выбор спринта");

    private final SelenideElement issueSeverity = $x("//select[@id='customfield_10400']")
            .as("Серьёзность задания");

    private final SelenideElement issueCreateButton = $x("//input[@id='create-issue-submit']")
            .as("Кнопка создания задач");

    private final SelenideElement issueCreatedCheck = $x("//div[contains(@class,'aui-message-success')]")
            .as("Проверка создано ли задание");

    public void bugRepoGeneration() {
        repoCreateIssueButton.shouldBe(interactable, Duration.ofSeconds(15)).click();
        issueTypeField.shouldBe(visible, Duration.ofSeconds(15)).click();
        issueTypeField.sendKeys("Ошибка", Keys.ENTER);
        issueTopicInput.shouldBe(visible).sendKeys("HW3_AutoTest_1");

        issueDescriptionVisualButton.shouldBe(visible, Duration.ofSeconds(15)).click();
        switchTo().frame(issueDescriptionInput);
        $(byTagName("body")).shouldBe(visible).setValue("Under test1");
        switchTo().defaultContent();

        issueDescriptionVersion.shouldBe(interactable, Duration.ofSeconds(15)).sendKeys("v");
        issuePriorityField.shouldBe(visible, Duration.ofSeconds(15)).click();
        issuePriorityField.sendKeys("Lowest", Keys.ENTER);

        issueMarksField.shouldBe(visible, Duration.ofSeconds(15)).click();
        issueMarksField.sendKeys("test");
        issueMarksField.pressEnter();

        issueEnvironmentVisualButton.shouldBe(visible, Duration.ofSeconds(15)).click();
        switchTo().frame(issueEnvironmentInput);
        $(byTagName("body")).shouldBe(visible).setValue("Under test");
        switchTo().defaultContent();

        getIssueEnvironmentVersion.shouldBe(interactable, Duration.ofSeconds(15)).sendKeys("v");
        issueRelatedTasks.shouldBe(interactable, Duration.ofSeconds(15)).selectOption(1);

        issueTaskChoice.shouldBe(visible).sendKeys("IF_HW3_ManualTest1");
        issueTaskChoice.shouldHave(attribute("aria-expanded", "true"), Duration.ofSeconds(15));
        issueTaskChoice.pressEnter();

        issueAssignToMe.shouldBe(visible, Duration.ofSeconds(15)).click();

        issueEpicChoice.shouldBe(visible, Duration.ofSeconds(15)).click();
        issueEpicChoice.sendKeys(Keys.DOWN, Keys.ENTER);

        issueSprintChoice.shouldBe(visible).click();
        issueSprintChoice.shouldBe(interactable, Duration.ofSeconds(15)).sendKeys(Keys.DOWN, Keys.ENTER);

        issueSeverity.shouldBe(interactable, Duration.ofSeconds(15)).selectOption(2);
        issueCreateButton.shouldBe(interactable, Duration.ofSeconds(15)).click();

        Assertions.assertTrue(issueCreatedCheck.shouldBe(visible, Duration.ofSeconds(15)).isDisplayed());
    }
}