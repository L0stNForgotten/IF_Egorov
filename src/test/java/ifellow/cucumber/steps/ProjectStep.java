package ifellow.cucumber.steps;

import ifellow.pages.ProjectPage;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public class ProjectStep {
    private final ProjectPage projectPage = new ProjectPage();
    private int before;

    @Тогда("выбираем фильтр на полный список")
    public void projectFilterListChoice() {
        projectPage.projectCheckFilter();
    }

    @Тогда("запоминаем, сколько всего задач было")
    public void projectCount() {
        this.before = projectPage.projectTasksCountCheck();
    }

    @Тогда("создаём новую задачу под названием {string}")
    public void createTask(String name) {
        projectPage.projectTaskCreator(name);
    }

    @Тогда("сравниваем с тем, сколько задач стало")
    public void comparisonOfValues() {
        int after = projectPage.projectTasksCountCheck();
        Assertions.assertEquals(before, after - 1);
    }
}
