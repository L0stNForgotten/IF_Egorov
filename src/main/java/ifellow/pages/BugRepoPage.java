package ifellow.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


public class BugRepoPage {
    private final SelenideElement repoCreateIssueButton = $x("//a[@id='create_link']").as("Кнопка создать");
    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']").as("Поле ввода типа ошибки");
    private final SelenideElement issueTopicInput = $x("//input[@id='summary']").as("Тема задачи");
    private final SelenideElement issueDescriptionVisualButton = $x("//div[@id='description-wiki-edit']//nav//li[@data-mode='wysiwyg']//button");
    private final SelenideElement issueDescriptionInput = $x("//div[@id='description-wiki-edit']//iframe").as("Поле ввода описания");
    private final SelenideElement issueDescriptionVersion = $x("//label[text()['Исправить в версиях']]/following::select[@id='fixVersions']");
    private final SelenideElement issuePriorityField = $x("//input[@aria-label='Приоритет']");
    private final SelenideElement issueMarksField = $x("//label[text()='Метки']/following-sibling::div//textarea");
    private final SelenideElement issueEnvironmentVisualButton = $x("//div[@id='environment-wiki-edit']//nav//li[@data-mode='wysiwyg']//button");
    private final SelenideElement issueEnvironmentInput = $x("//div[@id='environment-wiki-edit']//iframe");
    private final SelenideElement getIssueEnvironmentVersion = $x("//label[text()['Затронуты версии']]/following::select[@id='versions']");
    private final SelenideElement issueRelatedTasks = $x("//label[text()='Связанные задачи']/following-sibling::select[@name='issuelinks-linktype']");
    private final SelenideElement issueTaskChoice = $x("//textarea[@id='issuelinks-issues-textarea']");
    private final SelenideElement issueAssignToMe = $x("//button[text()='Назначить меня']");
    private final SelenideElement issueEpicChoice = $x("//input[@id='customfield_10100-field']");
    private final SelenideElement issueSprintChoice = $x("//input[@id='customfield_10104-field']");
    private final SelenideElement issueSeverity = $x("//select[@id='customfield_10400']");
    private final SelenideElement issueCreateButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement issueCreatedCheck = $x("//div[contains(@class,'aui-message-success')]");

    public void bugRepoGeneration() {
        repoCreateIssueButton.shouldBe(interactable).click();
        issueTypeField.shouldBe(visible).click();
        issueTypeField.sendKeys("Ошибка", Keys.ENTER);
        issueTopicInput.sendKeys("HW3_AutoTest");
        issueDescriptionVisualButton.shouldBe(visible);
        issueDescriptionVisualButton.click();
        switchTo().frame(issueDescriptionInput);
        SelenideElement descriptionBody = $(byTagName("body"));
        descriptionBody.shouldBe(visible).setValue("Under test");
        switchTo().defaultContent();
        issueDescriptionVersion.shouldBe(interactable).sendKeys("v");
        issuePriorityField.shouldBe(visible).click();
        issuePriorityField.sendKeys("Lowest", Keys.ENTER);
        issueMarksField.shouldBe(visible).click();
        issueMarksField.sendKeys("test");
        issueMarksField.pressEnter();
        issueEnvironmentVisualButton.shouldBe(visible);
        issueEnvironmentVisualButton.click();
        switchTo().frame(issueEnvironmentInput);
        SelenideElement environmentBody = $(byTagName("body"));
        environmentBody.shouldBe(visible).setValue("Under test");
        switchTo().defaultContent();
        getIssueEnvironmentVersion.shouldBe(interactable).sendKeys("v");
        issueRelatedTasks.shouldBe(interactable).selectOption(1);
        issueTaskChoice.shouldBe(interactable).sendKeys("IF_HW3_ManualTest");
        Selenide.sleep(500);
        issueTaskChoice.sendKeys(Keys.ENTER);
        issueAssignToMe.shouldBe(visible).click();
        issueEpicChoice.shouldBe(visible).click();
        Selenide.sleep(500);
        issueEpicChoice.sendKeys(Keys.DOWN, Keys.ENTER);
        issueSprintChoice.shouldBe(visible).click();
        Selenide.sleep(500);
        issueSprintChoice.sendKeys(Keys.DOWN, Keys.ENTER);
        issueSeverity.shouldBe(interactable).selectOption(2);
        issueCreateButton.click();
    }

    public void repoIssueWasMade() {
        Assertions.assertTrue(issueCreatedCheck.shouldBe(visible, Duration.ofSeconds(15)).isDisplayed());
    }
}