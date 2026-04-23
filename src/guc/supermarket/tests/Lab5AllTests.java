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
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lab5AllTests {

	String gPath = "guc.supermarket.products.GroceryProduct";
	String bPath = "guc.supermarket.products.Beverage";
	String dPath = "guc.supermarket.products.DairyProduct";
	String drinkPath = "guc.supermarket.products.Drinkable";

	
	/************ Interface ************/

	@Test(timeout = 1000)
	public void testDrinkableIsAnInterface() throws ClassNotFoundException {
		testIsInterface(Class.forName(drinkPath));
	}

	@Test(timeout = 1000)
	public void testBeverageClassImplementsDrinkableInterface() {
		try {
			testClassImplementsInterface(Class.forName(bPath),
					Class.forName(drinkPath));
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
	}

	@Test(timeout = 1000)
	public void testisHealthyInDrinkableInterface()
			throws ClassNotFoundException {
		testInterfaceMethod(Class.forName(drinkPath), "isHealthy",
				boolean.class, null);
	}

	@Test(timeout = 1000)
	public final void testInterface() throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> beverageClass = Class.forName(bPath);

		Constructor<?> constructor = beverageClass.getConstructor(String.class,
				double.class, double.class, SugarLevel.class);

		Object drink = constructor.newInstance("Pepsi", 5, 0,
				SugarLevel.ADDED_SUGAR);
		Object drink2 = constructor.newInstance("Pure Apple", 5, 0,
				SugarLevel.NO_ADDED_SUGAR);
		Object drink3 = constructor.newInstance("Sprite", 5, 0,
				SugarLevel.LIGHT);
		Object drink4 = constructor.newInstance("Pepsi", 5, 0, SugarLevel.ZERO);

		Method isHealthyMethod = beverageClass.getMethod("isHealthy");

		assertFalse("A drink with added sugar is unhealthy",
				(boolean) isHealthyMethod.invoke(drink));
		assertTrue("A drink with no sugar is healthy",
				(boolean) isHealthyMethod.invoke(drink2));
		assertTrue("A drink with light sugar level is healthy",
				(boolean) isHealthyMethod.invoke(drink3));
		assertTrue("A drink with zero sugar level is healthy",
				(boolean) isHealthyMethod.invoke(drink4));
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

	private void testIsInterface(Class iClass) {
		assertTrue(iClass.getSimpleName() + " should be interface",
				iClass.isInterface());
	}

	private void testClassImplementsInterface(Class aClass, Class iClass) {
		assertTrue(
				aClass.getSimpleName() + " should implement "
						+ iClass.getSimpleName(),
				iClass.isAssignableFrom(aClass));
	}

	private void testInterfaceMethod(Class iClass, String methodName,
			Class returnType, Class[] parameters) {
		Method[] methods = iClass.getDeclaredMethods();
		assertTrue(iClass.getSimpleName() + " interface should have "
				+ methodName + "method",
				containsMethodName(methods, methodName));

		Method m = null;
		boolean thrown = false;
		try {
			m = iClass.getDeclaredMethod(methodName, parameters);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}

		assertTrue(
				"Method " + methodName
						+ " should have the following set of parameters : "
						+ Arrays.toString(parameters), !thrown);
		assertTrue("wrong return type", m.getReturnType().equals(returnType));

	}

}
