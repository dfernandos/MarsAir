package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testCase.BookTicketsTest;
import testCase.BookTicketsUsingPromotionlCodeTest;
import testCase.ValidaLinksTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        BookTicketsTest.class,
        BookTicketsUsingPromotionlCodeTest.class,
        ValidaLinksTest.class
})
public class AllTests {

}