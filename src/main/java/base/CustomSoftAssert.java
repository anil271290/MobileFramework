package base;

import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CustomSoftAssert extends SoftAssert {
    private final List<Throwable> errors = new ArrayList<>();

    @Override
    public void assertAll() {
        try {
            super.assertAll();
        } catch (AssertionError e) {
            errors.add(e);
        }
    }

    public List<Throwable> getErrors() {
        return errors;
    }
}
