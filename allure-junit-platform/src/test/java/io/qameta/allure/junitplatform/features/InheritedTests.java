package io.qameta.allure.junitplatform.features;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InheritedTests {
    public static final String INHERITED_TEST_EPIC = "Inherited epic";
    public static final String INHERITED_TEST_FUTURE = "Inherited future";
    public static final String INHERITED_TEST_GRANDPARENT_STORY = "Inherited grandparent story";

    public static final String INHERITED_TEST_PARENT_STORY = "Inherited parent story";

    public static final String INHERITED_TEST_CHILD_STORY = "Inherited child story";

    public static final String TEST_DESCRIPTION = "Test description";

    public static final String TEST_LINK = "Test link";

    @Epic(INHERITED_TEST_EPIC)
    @Feature(INHERITED_TEST_FUTURE)
    public abstract static class GrandparentTest {
        @Test
        @Description(TEST_DESCRIPTION)
        @Story(INHERITED_TEST_GRANDPARENT_STORY)
        @Link(TEST_LINK)
        public void grandparentTest() {
        }
    }

    public abstract static class ParentTest extends GrandparentTest {
        @Test
        @Description(TEST_DESCRIPTION)
        @Story(INHERITED_TEST_PARENT_STORY)
        @Link(TEST_LINK)
        public void parentTest() {
        }

    }

    @Nested
    class ChildTest extends ParentTest {
        @Test
        @Description(TEST_DESCRIPTION)
        @Story(INHERITED_TEST_CHILD_STORY)
        @Link(TEST_LINK)
        public void childTest() {
        }
    }
}
