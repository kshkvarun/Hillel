package Lesson22;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({divTest.class, stringTest.class})
@Suite.SuiteClasses({
        TestDeviding.class,
        TestWithStrings.class

})




public class MainCategoryRunner {
}
