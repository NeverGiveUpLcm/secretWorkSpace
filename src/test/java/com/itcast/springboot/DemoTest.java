package com.itcast.springboot;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author lichunmiao
 * @date 2021/5/12
 */

/**
 * @DisplayName可以用在类上或者方法上
 */
@SpringBootTest
@DisplayName("练习Junit")
public class DemoTest {

    /**
     * 每个测试方法之前都会执行,相当于Junit4的@Before
     */
    @BeforeEach
    public void beforeEachTest() {
        System.out.println("每个测试方法前执行");
    }

    /**
     * @Tag:可以指定哪些标签的测试方法运行
     * @RepeatedTest: 可以指定测试方法的运行次数
     * @Disabled: 跳过此测试方法的执行
     */
    @Test
    @DisplayName("简单测试111")
    @Tag("fast")
    @RepeatedTest(2)
    @Disabled
    public void test1() {
        System.out.println("1111");
    }

    @Test
    @DisplayName("简单测试222")
    @Tag("slow")
    public void test2() {
        System.out.println("2222");
    }

    /**
     * 每个测试方法之后都会执行,相当于Junit4的@After
     */
    @AfterEach
    public void afterEachTest() {
        System.out.println("每个测试方法后执行");
    }

    /**
     * 这个测试类中执行所有的测试方法时只执行一次,相当于Junit4中的@BeforeClass,一般方法用static修饰
     */
    @BeforeAll
    static void beforeAllTest() {
        System.out.println("测试方法开始执行了-----只执行一次");
    }

    /**
     * 这个测试类中执行所有的测试方法时只执行一次,相当于Junit4中的@AfterClass,一般方法用static修饰
     */
    @AfterAll
    static void AfterAllTest() {
        System.out.println("测试方法执行结束了-----只执行一次");
    }

    /**
     * @Timeout: 测试方法的执行时间
     */
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void test3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }


}
