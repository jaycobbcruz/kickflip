package com.jaycobb.kickflip.common.util;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ObjectUtilsTest {

    @Test public void testJsonToObject() {

        final String json = "{\"myNumber\":1,\"myString\":\"A String\"}";
        final TestClass object = ObjectUtils.jsonToObject(json, TestClass.class);
        assertEquals(Integer.valueOf(1), object.getMyNumber());
        assertEquals("A String", object.getMyString());
        assertEquals(json, ObjectUtils.jsonToObject(json, String.class));
    }

    @Test public void testJsonToObjectList() {

        final String json = "[{\"myNumber\":1,\"myString\":\"A String\"}]";
        final List<TestClass> objects = ObjectUtils.jsonToObjectList(json, TestClass.class);
        assertEquals(1, objects.size());
        assertEquals(Integer.valueOf(1), objects.get(0).getMyNumber());
        assertEquals("A String", objects.get(0).getMyString());
    }

    @Test public void testObjectToJson() {
        final TestClass testClass = new TestClass();
        testClass.setMyNumber(1);
        testClass.setMyString("A String");
        assertEquals("{\"parentString\":null,\"anotherTestClass\":null,\"myNumber\":1,\"myString\":\"A String\"}", ObjectUtils.objectToJson(testClass));
    }

    @Test public void testCopyProperties() {

        final TestClass obj1 = new TestClass(1, "A String");
        final TestClass obj2 = new TestClass();
        ObjectUtils.copyProperties(obj1, obj2);
        assertEquals(obj1.getMyString(), obj2.getMyString());
        assertEquals(obj1.getMyNumber(), obj2.getMyNumber());
    }

    @Test public void testCopyPropertiesWithInclude() {

        final TestClass obj1 = new TestClass(1, "A String");
        final TestClass obj2 = new TestClass();
        ObjectUtils.copyProperties(obj1, obj2, Collections.singletonList("myNumber"));
        assertNotEquals(obj1.getMyString(), obj2.getMyString());
        assertEquals(obj1.getMyNumber(), obj2.getMyNumber());
    }

    @Test public void testCopyPropertiesWithIgnore() {

        final TestClass obj1 = new TestClass(1, "A String");
        final TestClass obj2 = new TestClass();
        ObjectUtils.copyPropertiesWithIgnore(obj1, obj2, Collections.singletonList("myNumber"));
        assertEquals(obj1.getMyString(), obj2.getMyString());
        assertNotEquals(obj1.getMyNumber(), obj2.getMyNumber());
        ObjectUtils.copyPropertiesWithIgnore(null, obj2, Collections.singletonList("myNumber"));
        assertNull(obj2.getMyNumber());
    }

    @Test public void testConvert() {

        final LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("myString", "A String");
        assertEquals("A String", ObjectUtils.convert(map, TestClass.class).getMyString());
    }

    @Test public void testSetIfNotNull() {

        final TestClass obj1 = new TestClass(1, "A String");
        final TestClass obj2 = new TestClass();
        ObjectUtils.setIfNotNull(obj1::getMyString, obj2::setMyString);
        assertEquals("A String", obj2.getMyString());

        final TestClass obj3 = new TestClass();
        final TestClass obj4 = new TestClass();
        ObjectUtils.setIfNotNull(obj3::getMyString, obj4::setMyString);
        assertNull(obj4.getMyString());
    }

    @Test public void testSetIfNotEmpty() {

        final TestClass obj1 = new TestClass(1, "A String");
        final TestClass obj2 = new TestClass();
        ObjectUtils.setIfNotEmpty(obj1.getMyString(), obj2::setMyString);
        assertEquals("A String", obj2.getMyString());

        final TestClass obj3 = new TestClass();
        final TestClass obj4 = new TestClass();
        ObjectUtils.setIfNotEmpty(obj3.getMyString(), obj4::setMyString);
        assertNull(obj4.getMyString());
    }

    @Test public void testSetIfNotPresent() {

        final TestClass obj1 = new TestClass(1, "A String");
        final TestClass obj2 = new TestClass();
        ObjectUtils.setIfPresent(Optional.of(obj1.getMyString()), obj2::setMyString);
        assertEquals("A String", obj2.getMyString());

        final TestClass obj4 = new TestClass(1, "Another String");
        ObjectUtils.setIfPresent(Optional.empty(), obj4::setMyString);
        assertEquals("Another String", obj4.getMyString());
    }

    @Test public void testSetDefaultIfNull() {

        final TestClass obj1 = new TestClass();
        final TestClass obj2 = new TestClass();
        ObjectUtils.setDefaultIfNull(obj1::getMyString, "Another String", obj2::setMyString);
        assertEquals("Another String", obj2.getMyString());
    }

    @Test public void testSetDefaultIfEmpty() {

        final TestClass obj1 = new TestClass(1, "");
        final TestClass obj2 = new TestClass();
        ObjectUtils.setDefaultIfEmpty(obj1::getMyString, "Another String", obj2::setMyString);
        assertEquals("Another String", obj2.getMyString());
    }

    @Test public void testGetPropertyValue() {

        final TestClass obj = new TestClass(1, "A String");
        assertEquals("A String", ObjectUtils.getPropertyValue(obj, "myString"));
    }

    @Test public void testGetPropertyValueOrDefault() {

        final TestClass obj = new TestClass(null, null);
        final String defaultString = "DEFAULT";
        final long defaultLong = 1;
        assertEquals(defaultString, ObjectUtils.getPropertyValueOrDefault(obj, "myString", defaultString));
        assertEquals(defaultLong, ObjectUtils.getPropertyValueOrDefault(obj, "myNumber", (Object)defaultLong));
    }

    @Test public void testSetPropertyValue() {

        final TestClass obj = new TestClass();
        ObjectUtils.setPropertyValue(obj, "myString", "A String");
        assertEquals("A String", obj.getMyString());
    }

    @Test public void testValuesAreSame() {
        assertFalse(ObjectUtils.valuesAreSame(1, null));
        assertFalse(ObjectUtils.valuesAreSame(null, 1));
        assertTrue(ObjectUtils.valuesAreSame(null, null));
        assertTrue(ObjectUtils.valuesAreSame(1, 1));
    }

    @Test public void testContainsProperty() {

        assertFalse(ObjectUtils.containsProperty(TestClass.class, null));
        assertFalse(ObjectUtils.containsProperty(TestClass.class, "voltesv"));
        assertTrue(ObjectUtils.containsProperty(TestClass.class, "myNumber"));
    }

    @Test public void testGetPropertyFromPath() {

        final TestClass obj = new TestClass();
        obj.setParentString("A Parent String");
        obj.setAnotherTestClass(new AnotherTestClass("Another Test String"));
        assertEquals("A Parent String", ObjectUtils.getPropertyValue(obj, "parentString"));
        assertEquals("Another Test String",
                ObjectUtils.getPropertyValue(obj, "anotherTestClass.anotherString"));
        assertEquals("Another Test String",
                ObjectUtils.<AnotherTestClass>getPropertyValue(obj, "anotherTestClass") != null ?
                        ObjectUtils.<AnotherTestClass>getPropertyValue(obj, "anotherTestClass").getAnotherString() : "");
    }

    private static class ParentTestClass {

        private String parentString;
        private AnotherTestClass anotherTestClass;

        ParentTestClass() { }

        public String getParentString() { return parentString; }
        public void setParentString(String parentString) { this.parentString = parentString; }

        public AnotherTestClass getAnotherTestClass() { return anotherTestClass; }
        public void setAnotherTestClass(AnotherTestClass anotherTestClass) { this.anotherTestClass = anotherTestClass; }
    }

    private static class TestClass extends ParentTestClass {

        private Integer myNumber;
        private String myString;

        public TestClass() {}

        public TestClass(final Integer myNumber, final String myString) {
            this.myNumber = myNumber;
            this.myString = myString;
        }

        public Integer getMyNumber() { return myNumber; }
        public void setMyNumber(final Integer myNumber) { this.myNumber = myNumber; }

        public String getMyString() { return myString; }
        public void setMyString(final String myString) { this.myString = myString; }
    }

    private static class AnotherTestClass {

        private String anotherString;

        public AnotherTestClass(String anotherString) {
            this.anotherString = anotherString;
        }

        public String getAnotherString() { return anotherString; }

        public void setAnotherString(String anotherString) { this.anotherString = anotherString; }
    }
}
