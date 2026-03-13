package guc.supermarket.tests;

import guc.supermarket.products.Beverage;
import guc.supermarket.products.DairyProduct;
import guc.supermarket.products.Fat;
import guc.supermarket.products.GroceryProduct;
import guc.supermarket.products.SugarLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lab3AllTests {

	String gPath = "guc.supermarket.products.GroceryProduct";
	String bPath = "guc.supermarket.products.Beverage";
	String dPath = "guc.supermarket.products.DairyProduct";

	/************ Polymorphism ************/

	@Test(timeout = 1000)
	public void testMethodBeverageGetActualPrice2() {

		try {
			Beverage.class.getDeclaredMethod("getActualPrice", double.class);
		} catch (NoSuchMethodException e) {
			fail("The overloaded method getActualPrice(double extra) should be implemented in the Beverage class.");
		}

	}

	@Test
	public void testMethodBeverageGetActualPrice2Logic()
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, ClassNotFoundException {
		double price = 10;
		double discount = 5;
		Beverage b = new Beverage("Schweppes Pomegranate", price, discount,
				SugarLevel.ADDED_SUGAR);

		Method getActualPrice = Class.forName(bPath).getDeclaredMethod(
				"getActualPrice", double.class);
		getActualPrice.setAccessible(true);
		double extra = 3;
		double result = (double) getActualPrice.invoke(b, extra);
		double finalPrice = price - price * (discount + extra) / 100;
		
		assertEquals(finalPrice, result, 0.01);

		double price2 = 20;
		double discount2 = 10;
		b = new Beverage("Schweppes Pomegranate", price2, discount2,
				SugarLevel.ADDED_SUGAR);
		getActualPrice = Class.forName(bPath).getDeclaredMethod(
				"getActualPrice", double.class);
		getActualPrice.setAccessible(true);
		double extra2 = 5;
		double result2 = (double) getActualPrice.invoke(b, extra2);
		double finalPrice2 = price2 - price2 * (discount2 + extra2) / 100;
		assertEquals(finalPrice2, result2, 0.01);

	}

	@Test(timeout = 1000)
	public void testOverloading() {
		assertTrue(
				"The method \"getActualPrice(double extra)\" should be declared in the Beverage class",
				containsMethod(Beverage.class, "getActualPrice",
						new Class[] { double.class }));
	}

	@Test(timeout = 1000)
	public void testEqualsDairyProductPolymorphism() {
		assertTrue(
				"The method \"equals\" should be declared in the DairyProduct class",
				containsMethod(DairyProduct.class, "equals",
						new Class[] { Object.class }));
		
		DairyProduct milk1 = new DairyProduct("Juhayna Milk", 10, 5,
				Fat.FULLCREAM);
		DairyProduct milk2 = new DairyProduct("Juhayna Milk", 10, 5,
				Fat.FULLCREAM);
		DairyProduct milk3 = new DairyProduct("Labanita", 10, 5, Fat.FULLCREAM);
		DairyProduct milk4 = new DairyProduct("Juhayna Milk", 9, 5,
				Fat.FULLCREAM);
		DairyProduct milk5 = new DairyProduct("Juhayna Milk", 9, 25,
				Fat.FULLCREAM);
		DairyProduct milk6 = new DairyProduct("Juhayna Milk", 9, 25,
				Fat.SKIMMED);
		assertTrue("The two instances are equal", milk1.equals(milk2));
		assertFalse(
				"The two instances are not equal, they have different names",
				milk1.equals(milk3));
		assertFalse(
				"The two instances are not equal, they have different prices",
				milk1.equals(milk4));
		assertFalse(
				"The two instances are not equal, they have different discounts",
				milk1.equals(milk5));
		assertFalse(
				"The two instances are not equal, they have different fat levels",
				milk1.equals(milk6));
	}
	@Test(timeout = 1000)
	public void testEqualsGroceryProductPolymorphism(){
		assertTrue(
				"The method \"equals\" should be declared in the GroceryProduct class",
				containsMethod(GroceryProduct.class, "equals",
						new Class[] { Object.class }));
	}

	@Test(timeout = 1000)
	public void testEqualsBeveragePolymorphism() {

		assertTrue(
				"The method \"equals\" should be declared in the Beverage class",
				containsMethod(Beverage.class, "equals",
						new Class[] { Object.class }));

		Beverage beverage1 = new Beverage("Schweppes Pomegranate", 10, 5,
				SugarLevel.ADDED_SUGAR);
		Beverage beverage2 = new Beverage("Schweppes Pomegranate", 10, 5,
				SugarLevel.ADDED_SUGAR);
		Beverage beverage3 = new Beverage("Sprite", 10, 5,
				SugarLevel.ADDED_SUGAR);
		Beverage beverage4 = new Beverage("Schweppes Pomegranate", 9, 5,
				SugarLevel.ADDED_SUGAR);
		Beverage beverage5 = new Beverage("Schweppes Pomegranate", 9, 25,
				SugarLevel.NO_ADDED_SUGAR);
		Beverage beverage6 = new Beverage("Schweppes Pomegranate", 9, 25,
				SugarLevel.LIGHT);
		assertTrue("The two instances are equal", beverage1.equals(beverage2));
		assertFalse(
				"The two instances are not equal, they have different names",
				beverage1.equals(beverage3));
		assertFalse(
				"The two instances are not equal, they have different prices",
				beverage1.equals(beverage4));
		assertFalse(
				"The two instances are not equal, they have different discounts",
				beverage1.equals(beverage5));
		assertFalse(
				"The two instances are not equal, they have different sugar levels",
				beverage1.equals(beverage6));
	}

	@Test(timeout = 1000)
	public void testEqualsPolymorphism() {
		DairyProduct milk = new DairyProduct("Juhayna Milk", 10, 5,
				Fat.FULLCREAM);
		Beverage beverage = new Beverage("Schweppes Pomegranate", 10, 5,
				SugarLevel.ADDED_SUGAR);
		assertFalse(
				"When comparing different types of grocery products, the method should return false with no exception",
				milk.equals(beverage));
		assertFalse(
				"When comparing different types of grocery products, the method should return false with no exception",
				beverage.equals(milk));
	}

	// -----------Helper methods-----------
	public static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	public static boolean containsMethod(Class c, String name,
			Class[] parameters) {
		try {
			c.getDeclaredMethod(name, parameters);
			return true;
		} catch (NoSuchMethodException e) {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	private void testClassIsSubClass(Class subClass, Class superClass) {
		assertEquals(subClass.getName() + " class should inherit from "
				+ superClass.getName() + ".", superClass,
				subClass.getSuperclass());
	}

	@SuppressWarnings("rawtypes")
	private void testInstanceVariablesArePresent(Class aClass, String varName,
			boolean implementedVar) throws SecurityException {

		boolean thrown = false;
		try {
			aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			thrown = true;
		}
		if (implementedVar) {
			assertFalse("There should be " + varName
					+ " instance variable in class " + aClass.getName(), thrown);
		} else {
			assertTrue("There should not be " + varName
					+ " instance variable in class " + aClass.getName()
					+ ", it should be inherited from the super class", thrown);
		}
	}

	@SuppressWarnings("rawtypes")
	private void testInstanceVariablesArePrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		assertEquals(
				varName + " instance variable in class " + aClass.getName()
						+ " should not be accessed outside that class", 2,
				f.getModifiers());
	}

	@SuppressWarnings("rawtypes")
	private void testInstanceVariableIsPrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		assertEquals(
				varName + " instance variable in class " + aClass.getName()
						+ " should not be accessed outside that class", 2,
				f.getModifiers());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void testGetterMethodExistsInClass(Class aClass, String methodName,
			Class returnedType) {
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException e) {
			found = false;
		}
		String varName = methodName.substring(3).toLowerCase();
		assertTrue(
				"The " + varName + " instance variable in class "
						+ aClass.getName() + " is a READ variable.", found);
		assertTrue("incorrect return type for " + methodName + " method in "
				+ aClass.getName() + " class.", m.getReturnType()
				.isAssignableFrom(returnedType));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void testSetterMethodExistsInClass(Class aClass, String methodName,
			Class inputType, boolean writeVariable) {

		Method[] methods = aClass.getDeclaredMethods();
		String varName = methodName.substring(3).toLowerCase();
		if (writeVariable) {
			assertTrue("The " + varName + " instance variable in class "
					+ aClass.getName() + " is a WRITE variable.",
					containsMethodName(methods, methodName));
		} else {
			assertFalse("The " + varName + " instance variable in class "
					+ aClass.getName() + " is a READ ONLY variable.",
					containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputType);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		assertTrue(aClass.getName() + " class should have " + methodName
				+ " method that takes one " + inputType.getSimpleName()
				+ " parameter", found);

		assertTrue("incorrect return type for " + methodName + " method in "
				+ aClass.getName() + ".", m.getReturnType().equals(Void.TYPE));

	}

}
