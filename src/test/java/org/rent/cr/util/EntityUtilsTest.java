package org.rent.cr.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.Assert.*;

public class EntityUtilsTest {

    public class TestObject {
        private String name = null;
        private Integer age = null;
        private String sex = null;
        private String jod = null;

        public TestObject() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getJod() {
            return jod;
        }

        public void setJod(String jod) {
            this.jod = jod;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestObject that = (TestObject) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(age, that.age) &&
                    Objects.equals(sex, that.sex) &&
                    Objects.equals(jod, that.jod);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex, jod);
        }
    }

    @Test
    public void copyNonNullProperties() {
        TestObject objectSource = new TestObject();
        objectSource.setName("Jon");
        objectSource.setAge(null);
        objectSource.setSex("male");
        objectSource.setJod("driver");
        TestObject objectDestination = new TestObject();
        objectDestination.setName("Tom");
        objectDestination.setAge(43);
        objectDestination.setSex(null);
        objectDestination.setJod("doctor");
        TestObject objectResult = new TestObject();
        objectResult.setName("Jon");
        objectResult.setAge(43);
        objectResult.setSex("male");
        objectResult.setJod("driver");

        EntityUtils.copyNonNullProperties(objectSource, objectDestination);
        Assert.assertEquals(objectResult, objectDestination);
    }

    @Test
    public void periodsIsCrossedTrue() {
        LocalDateTime sourceStart = LocalDateTime.of(2020, 2, 5, 0, 0);
        LocalDateTime sourceEnd = LocalDateTime.of(2020, 2, 12, 0, 0);
        LocalDateTime sourceSecondStart = LocalDateTime.of(2020, 2, 8, 0, 0);
        LocalDateTime sourceSecondEnd = LocalDateTime.of(2020, 2, 23, 0, 0);
        Assert.assertTrue(EntityUtils.periodsIsCrossed(sourceStart, sourceEnd, sourceSecondStart, sourceSecondEnd));
    }

    @Test
    public void periodsIsCrossedFalse() {
        LocalDateTime sourceStart = LocalDateTime.of(2020, 2, 5, 0, 0);
        LocalDateTime sourceEnd = LocalDateTime.of(2020, 2, 12, 0, 0);
        LocalDateTime sourceSecondStart = LocalDateTime.of(2020, 2, 13, 0, 0);
        LocalDateTime sourceSecondEnd = LocalDateTime.of(2020, 2, 23, 0, 0);
        Assert.assertFalse(EntityUtils.periodsIsCrossed(sourceStart, sourceEnd, sourceSecondStart, sourceSecondEnd));
    }

    @Test
    public void periodIsCrossCurrentTimeTrue() {
        LocalDateTime start = LocalDateTime.of(2020, 2, 5, 0, 0);
        LocalDateTime end = LocalDateTime.of(2020, 2, 12, 0, 0);
        LocalDateTime time = LocalDateTime.of(2020, 2, 11, 0, 0);
        EntityUtils.periodIsCrossCurrentTime(start, end, time);
    }

    @Test
    public void periodIsCrossCurrentTimeFalse() {
        LocalDateTime start = LocalDateTime.of(2020, 2, 5, 0, 0);
        LocalDateTime end = LocalDateTime.of(2020, 2, 12, 0, 0);
        LocalDateTime time = LocalDateTime.of(2020, 2, 12, 0, 0);
        EntityUtils.periodIsCrossCurrentTime(start, end, time);
    }
}