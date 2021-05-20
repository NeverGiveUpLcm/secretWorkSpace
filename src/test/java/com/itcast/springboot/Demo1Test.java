package com.itcast.springboot;

import com.itcast.springboot.entity.People;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author lichunmiao
 * @date 2021/5/13
 */
@SpringBootTest
public class Demo1Test {

    @ParameterizedTest(name = "123")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @MethodSource(value = {"get"})
    public void test4(String i) {
        System.out.println(i);
    }

    static Stream<String> get() {
        return Arrays.stream(new String[]{"a", "b", "c", "d"});
    }


    @Test
    public void test2() {
        People people = new People();
        int result = 2 + 3;
        assertEquals(6, result, "计算结果不符合预期");
        assertTrue("a".equals("b"));
        Assertions.assertNotNull(people);
    }

    @Test
    public void test3() {
        int[] int1 = {1, 2, 3, 4, 5};
        int[] int2 = {1, 2, 3, 4, 5};
        //assertArrayEquals是通过equals来比较的
        Assertions.assertArrayEquals(int1, int2);
        //assertEquals就是来比较两个数组的地址值是否一致
        assertEquals(int1, int2);
    }

    @Test
    public void test4() {
        int result = 999 / 5;
        //assertAll:当里面的条件全部成立才会断言成功
        Assertions.assertAll("math", () -> assertTrue(result > 10),
                () -> assertTrue(result < 200));
    }


    @Test
    public void test5() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 999 / 0;
        });
        Assertions.assertDoesNotThrow(() -> {
            int i = 999 / 1;
        });
    }

    @Test
    public void test6() {
        Assertions.assertTimeout(Duration.ofMillis(5000), () -> TimeUnit.SECONDS.sleep(4));
    }

    @Test
    public void test7() {
        int result = 10 / 2;
        if (result > 4) {
            Assertions.fail();
        }
    }

    @Test
    public void test8() {
        /**
         * Assumptions作为前置条件,如果没有通过的话就跳过此次测试。
         * Assertions的话是在多个测试条件下,如果前面的测试条件失败了,后面的测试也不会执行。
         * 这两个的结果是一样的。但是在意义上又不同。
         */
        Assumptions.assumeTrue(10 / 2 != 5);
        /**
         * assumingThat只有当参数条件为true时后面的Executable才会执行。
         * 但是不管assumingThat的参数条件是true或者false,后面的测试都会正常执行。
         * 所以参数的boolean值影响的只是Executable的执行与否。
         */
        Assumptions.assumingThat(true, () -> System.out.println("111"));
        System.out.println("测试结束了");
    }

    @DisplayName("A stack")
    class TestingAStackDemo {

        Stack<Object> stack;

        @Test
        @DisplayName("is instantiated with new Stack()")
        void isInstantiatedWithNew() {
            new Stack<>();
            //嵌套测试情况下,外层的Test不能驱动内层的@BeforeEach/All之类的方法
            assertNull(stack);
        }

        @Nested
        @DisplayName("when new")
        class WhenNew {

            @BeforeEach
            void createNewStack() {
                stack = new Stack<>();
            }

            @Test
            @DisplayName("is empty")
                //嵌套测试情况下,内层的Test可以驱动内层的@BeforeEach/All之类的方法
            void isEmpty() {
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("throws EmptyStackException when popped")
            void throwsExceptionWhenPopped() {
                assertThrows(EmptyStackException.class, stack::pop);
            }

            @Test
            @DisplayName("throws EmptyStackException when peeked")
            void throwsExceptionWhenPeeked() {
                assertThrows(EmptyStackException.class, stack::peek);
            }

            @Nested
            @DisplayName("after pushing an element")
            class AfterPushing {

                String anElement = "an element";

                @BeforeEach
                void pushAnElement() {
                    stack.push(anElement);
                }

                @Test
                @DisplayName("it is no longer empty")
                void isNotEmpty() {
                    assertFalse(stack.isEmpty());
                }

                @Test
                @DisplayName("returns the element when popped and is empty")
                void returnElementWhenPopped() {
                    assertEquals(anElement, stack.pop());
                    assertTrue(stack.isEmpty());
                }

                @Test
                @DisplayName("returns the element when peeked but remains not empty")
                void returnElementWhenPeeked() {
                    assertEquals(anElement, stack.peek());
                    assertFalse(stack.isEmpty());
                }
            }
        }
    }

}
