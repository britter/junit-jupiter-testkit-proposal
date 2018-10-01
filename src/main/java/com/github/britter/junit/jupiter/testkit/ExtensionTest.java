package com.github.britter.junit.jupiter.testkit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtensionTest {

    Class<?> value();

    String[] methods() default {};
}
