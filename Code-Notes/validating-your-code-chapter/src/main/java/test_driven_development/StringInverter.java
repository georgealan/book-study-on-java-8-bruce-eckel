package test_driven_development;

public interface StringInverter {
    String invert(String str);
}

/*
This example is different from standard TDD because it’s designed to accept different
implementations of the StringInverter, showing the evolution of the class as we
satisfy the tests step-by-step.
 */
