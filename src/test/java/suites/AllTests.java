package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testCase.TestCase;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        TestCase.class,
})
public class AllTests {

}