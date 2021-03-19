package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testCase.BookTicketsTestCase;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        BookTicketsTestCase.class,
})
public class AllTests {

}