package Lesson22.Task1.Runners;

import Lesson22.Task1.*;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Categories.IncludeCategory
@Suite.SuiteClasses({
        TestDeviding.class,
        TestSum.class,
        TestMultiplying.class,
        TestWithStrings.class,
        UsingAttributes.class
})


public class MainSuitRunner {


}
