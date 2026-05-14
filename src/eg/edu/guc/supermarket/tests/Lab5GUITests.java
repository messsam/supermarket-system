package eg.edu.guc.supermarket.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab5GUITests {

	private String supermarketGUIPath = "eg.edu.guc.supermarket.controller.SupermarketGUI";
	private String supermarketViewPath = "eg.edu.guc.supermarket.view.SupermarketView";
	private String supermarketPath = "eg.edu.guc.supermarket.model.supermarket.Supermarket";
	private String cartPath = "eg.edu.guc.supermarket.model.cart.Cart";

	@BeforeClass
	public static void initJavaFX() {
		new JFXPanel();
	}

	@Test(timeout = 1000)
	public void testExestanceProductsGrid() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);
				double productsGridX = productsGrid.localToScene(
						new Point2D(productsGrid.getLayoutX(), productsGrid
								.getLayoutY())).getX();
				double productsGridY = productsGrid.localToScene(
						new Point2D(productsGrid.getLayoutX(), productsGrid
								.getLayoutY())).getY();

				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				double txtCartX = txtCart.localToScene(
						new Point2D(txtCart.getLayoutX(), txtCart
								.getLayoutY())).getX();
				double txtCartY = txtCart.localToScene(
						new Point2D(txtCart.getLayoutX(), txtCart
								.getLayoutY())).getY();

				if (productsGrid.getScene() != stage.getScene())
					Assert.fail("The given Nodes are not added to the scene");

				latch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("productsGrid is not on the scene");
			}
		});

		latch.await();
	}
	
	@Test(timeout = 1000)
	public void testExestanceTxtCart() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);
				double productsGridX = productsGrid.localToScene(
						new Point2D(productsGrid.getLayoutX(), productsGrid
								.getLayoutY())).getX();
				double productsGridY = productsGrid.localToScene(
						new Point2D(productsGrid.getLayoutX(), productsGrid
								.getLayoutY())).getY();

				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				double txtCartX = txtCart.localToScene(
						new Point2D(txtCart.getLayoutX(), txtCart
								.getLayoutY())).getX();
				double txtCartY = txtCart.localToScene(
						new Point2D(txtCart.getLayoutX(), txtCart
								.getLayoutY())).getY();

				if (txtCart.getScene() != stage.getScene())
					Assert.fail("The given Nodes are not added to the scene");

				latch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("txtCart is not on the scene");
			}
		});

		latch.await();
	}

	@Test(timeout = 1000)
	public void testLayout() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);
				double productsGridX = productsGrid.localToScene(
						new Point2D(productsGrid.getLayoutX(), productsGrid
								.getLayoutY())).getX();
				double productsGridY = productsGrid.localToScene(
						new Point2D(productsGrid.getLayoutX(), productsGrid
								.getLayoutY())).getY();

				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				double txtCartX = txtCart.localToScene(
						new Point2D(txtCart.getLayoutX(), txtCart
								.getLayoutY())).getX();
				double txtCartY = txtCart.localToScene(
						new Point2D(txtCart.getLayoutX(), txtCart
								.getLayoutY())).getY();

				if (txtCartX < productsGridX)
					Assert.fail("The given Nodes are not added to the scene");

				latch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Wrong Layout");
			}
		});

		latch.await();
	}

	@Test(timeout = 1000)
	public void testTxtCartInisialization() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);

				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				
				assertEquals("Incorrect text for txtCart",txtCart.getText(),"Cart:");
				latch.countDown();
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		});

		latch.await();
	}
	
	@Test(timeout = 1000)
	public void testProductsGridButtonsCount() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);

				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				
				assertEquals("You didn't add all the buttons",productsGrid.getChildren().size(),10);
				latch.countDown();
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		});

		latch.await();
	}
	
	@Test(timeout = 1000)
	public void testProductsGridButtonsClick() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);

				Button b = (Button) productsGrid.getChildren().get(0);
				b.fire();
				
				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				
				String expected = "Cart:\n"+"'''''\n";
				
				Field supermarket = Class.forName(supermarketGUIPath).getDeclaredField("supermarket");
				supermarket.setAccessible(true);
				Object supermarketObj = supermarket.get(controllerObj);
				
				Field cart = Class.forName(supermarketPath).getDeclaredField("cart");
				cart.setAccessible(true);
				Object cartObj = cart.get(supermarketObj);
				
				Field products = Class.forName(cartPath).getDeclaredField("products");
				products.setAccessible(true);
				ArrayList<Object> productsObj = (ArrayList) products.get(cartObj);
				
				Method getTotal = Class.forName(cartPath).getDeclaredMethod("getTotal");
				getTotal.setAccessible(true);
				double total = (double) getTotal.invoke(cartObj);
				
				for (Object product : productsObj) {
					expected += ("- ") + (product.toString()) + ("\n");
		        }
				if (!productsObj.isEmpty()) {
					expected += ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		        }
				expected += (String.format("\nTotal: $%.2f", total));
				
				assertEquals("Incorrect text for txtCart after adding a product",expected,txtCart.getText());
				latch.countDown();
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		});

		latch.await();
	}
	
	@Test(timeout = 1000)
	public void testProductsGridButtonsClickSpam() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() -> {
			try {
				Constructor<?> controller = Class.forName(supermarketGUIPath)
						.getConstructor();
				Object controllerObj = controller.newInstance();
				
				Stage stage = new Stage();

				Method start = Class.forName(supermarketGUIPath).getDeclaredMethod(
						"start", Stage.class);
				start.setAccessible(true);
				start.invoke(controllerObj, stage);
				
				Field supermarketView = Class.forName(supermarketGUIPath).getDeclaredField("supermarketView");
				supermarketView.setAccessible(true);
				Object viewObj = supermarketView.get(controllerObj);

				Method getProductsGrid = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getProductsGrid");
				getProductsGrid.setAccessible(true);
				GridPane productsGrid = (GridPane) getProductsGrid.invoke(viewObj);

				Button b = (Button) productsGrid.getChildren().get(0);
				b.fire();
				b.fire();
				b.fire();
				b.fire();
				b.fire();
				
				Method getTxtCart = Class.forName(supermarketViewPath)
						.getDeclaredMethod("getTxtCart");
				getTxtCart.setAccessible(true);
				TextArea txtCart = (TextArea) getTxtCart.invoke(viewObj);
				
				String expected = "Cart:\n"+"'''''\n";
				
				Field supermarket = Class.forName(supermarketGUIPath).getDeclaredField("supermarket");
				supermarket.setAccessible(true);
				Object supermarketObj = supermarket.get(controllerObj);
				
				Field cart = Class.forName(supermarketPath).getDeclaredField("cart");
				cart.setAccessible(true);
				Object cartObj = cart.get(supermarketObj);
				
				Field products = Class.forName(cartPath).getDeclaredField("products");
				products.setAccessible(true);
				ArrayList<Object> productsObj = (ArrayList) products.get(cartObj);
				
				Method getTotal = Class.forName(cartPath).getDeclaredMethod("getTotal");
				getTotal.setAccessible(true);
				double total = (double) getTotal.invoke(cartObj);
				
				for (Object product : productsObj) {
					expected += ("- ") + (product.toString()) + ("\n");
		        }
				if (!productsObj.isEmpty()) {
					expected += ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		        }
				expected += (String.format("\nTotal: $%.2f", total));
				
				assertEquals("Incorrect text for txtCart after adding a product",expected,txtCart.getText());
				
				b.fire();
				b.fire();
				b.fire();
				
				expected = "Cart:\n"+"'''''\n";
				supermarketObj = supermarket.get(controllerObj);
				cartObj = cart.get(supermarketObj);
				productsObj = (ArrayList) products.get(cartObj);
				total = (double) getTotal.invoke(cartObj);
				
				for (Object product : productsObj) {
					expected += ("- ") + (product.toString()) + ("\n");
		        }
				if (!productsObj.isEmpty()) {
					expected += ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		        }
				expected += (String.format("\nTotal: $%.2f", total));
				
				assertEquals("Incorrect text for txtCart after adding a product",expected,txtCart.getText());
				
				latch.countDown();
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		});

		latch.await();
	}
	
//	@Test(timeout = 1000)
//	public void testPizzaTextInitialization() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//
//				String[] test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 8);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[6].charAt(test_area[6].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[7].charAt(test_area[7].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				latch.countDown();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Wrong Layout");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testAddPizzaInitialization() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//				
//				Assert.assertTrue(calculateDistanceRecursive(trim1(addPizza
//						.getText()), trim1(addPizza.getText()).length(),
//						"addpizza", 8) <= 3);
//
//				latch.countDown();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Wrong Layout");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testAddBeverageInitialization() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//				
//				Assert.assertTrue(calculateDistanceRecursive(trim1(addBeverage
//						.getText()), trim1(addBeverage.getText()).length(),
//						"addbeverage", 11) <= 4);
//
//				latch.countDown();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Wrong Layout");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testResetOrderInitialization() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//				
//				Assert.assertTrue(calculateDistanceRecursive(trim1(resetOrder
//						.getText()), trim1(resetOrder.getText()).length(),
//						"resetorder", 10) <= 4);
//
//				latch.countDown();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Wrong Layout");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testOrderTextInitialization() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//
//				Assert.assertEquals("", trim(txtareaOrder.getText()));
//
//				latch.countDown();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Wrong Layout");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testAddPizza() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				intializeHelper(c);
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//				double txtareaItemsX = txtareaItems.localToScene(
//						new Point2D(txtareaItems.getLayoutX(), txtareaItems
//								.getLayoutY())).getX();
//				double txtareaItemsY = txtareaItems.localToScene(
//						new Point2D(txtareaItems.getLayoutX(), txtareaItems
//								.getLayoutY())).getY();
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//				double txtareaOrderX = txtareaOrder.localToScene(
//						new Point2D(txtareaOrder.getLayoutX(), txtareaOrder
//								.getLayoutY())).getX();
//				double txtareaOrderY = txtareaOrder.localToScene(
//						new Point2D(txtareaOrder.getLayoutX(), txtareaOrder
//								.getLayoutY())).getY();
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//				double addPizzaX = addPizza.localToScene(
//						new Point2D(addPizza.getLayoutX(), addPizza
//								.getLayoutY())).getX();
//				double addPizzaY = addPizza.localToScene(
//						new Point2D(addPizza.getLayoutX(), addPizza
//								.getLayoutY())).getY();
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//				double addBeverageX = addBeverage.localToScene(
//						new Point2D(addBeverage.getLayoutX(), addBeverage
//								.getLayoutY())).getX();
//				double addBeverageY = addBeverage.localToScene(
//						new Point2D(addBeverage.getLayoutX(), addBeverage
//								.getLayoutY())).getY();
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//				double resetOrderX = resetOrder.localToScene(
//						new Point2D(resetOrder.getLayoutX(), resetOrder
//								.getLayoutY())).getX();
//				double resetOrderY = resetOrder.localToScene(
//						new Point2D(resetOrder.getLayoutX(), resetOrder
//								.getLayoutY())).getY();
//
//				addPizza.fire();
//
//				String[] test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 7);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[6].charAt(test_area[6].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 3) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				String[] test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 1);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area_order[i]),
//							trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//				}
//
//				addPizza.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 6);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 2) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 2);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area_order[i]),
//							trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//				}
//
//				addPizza.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 5);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 1) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 3);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '3');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area_order[i]),
//							trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//				}
//
//				addPizza.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 4);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area[i]), trim1(test_area[i]).length(),
//							"beverage", 8) <= 4);
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 4);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '3');
//				Assert.assertEquals(test_area_order[3]
//						.charAt(test_area_order[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area_order[i]),
//							trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//				}
//
//				addPizza.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 4);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area[i]), trim1(test_area[i]).length(),
//							"beverage", 8) <= 4);
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 4);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '3');
//				Assert.assertEquals(test_area_order[3]
//						.charAt(test_area_order[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area_order[i]),
//							trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//				}
//
//				latch.countDown();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Failed to simulate addPizza button click");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testAddBeverage() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				intializeHelper(c);
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//				double txtareaItemsX = txtareaItems.localToScene(
//						new Point2D(txtareaItems.getLayoutX(), txtareaItems
//								.getLayoutY())).getX();
//				double txtareaItemsY = txtareaItems.localToScene(
//						new Point2D(txtareaItems.getLayoutX(), txtareaItems
//								.getLayoutY())).getY();
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//				double txtareaOrderX = txtareaOrder.localToScene(
//						new Point2D(txtareaOrder.getLayoutX(), txtareaOrder
//								.getLayoutY())).getX();
//				double txtareaOrderY = txtareaOrder.localToScene(
//						new Point2D(txtareaOrder.getLayoutX(), txtareaOrder
//								.getLayoutY())).getY();
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//				double addPizzaX = addPizza.localToScene(
//						new Point2D(addPizza.getLayoutX(), addPizza
//								.getLayoutY())).getX();
//				double addPizzaY = addPizza.localToScene(
//						new Point2D(addPizza.getLayoutX(), addPizza
//								.getLayoutY())).getY();
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//				double addBeverageX = addBeverage.localToScene(
//						new Point2D(addBeverage.getLayoutX(), addBeverage
//								.getLayoutY())).getX();
//				double addBeverageY = addBeverage.localToScene(
//						new Point2D(addBeverage.getLayoutX(), addBeverage
//								.getLayoutY())).getY();
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//				double resetOrderX = resetOrder.localToScene(
//						new Point2D(resetOrder.getLayoutX(), resetOrder
//								.getLayoutY())).getX();
//				double resetOrderY = resetOrder.localToScene(
//						new Point2D(resetOrder.getLayoutX(), resetOrder
//								.getLayoutY())).getY();
//
//				addBeverage.fire();
//
//				String[] test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 7);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[6].charAt(test_area[6].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				String[] test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 1);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i < 0) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				addBeverage.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 6);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 2);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i < 0) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				addBeverage.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 5);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 3);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '3');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i < 0) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				addBeverage.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 4);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 4);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '3');
//				Assert.assertEquals(test_area_order[3]
//						.charAt(test_area_order[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i < 0) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				addBeverage.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 4);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 4);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '2');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '3');
//				Assert.assertEquals(test_area_order[3]
//						.charAt(test_area_order[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i < 0) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				latch.countDown();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Failed to simulate addBeverage button click");
//			}
//		});
//
//		latch.await();
//	}
//
//	@Test(timeout = 1000)
//	public void testResetOrder() throws InterruptedException,
//			InstantiationException, IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {
//		CountDownLatch latch = new CountDownLatch(1);
//
//		Platform.runLater(() -> {
//			try {
//				Constructor<?> controller = Class.forName(controllerPath)
//						.getConstructor();
//				Object c = controller.newInstance();
//
//				intializeHelper(c);
//
//				Stage stage = new Stage();
//
//				Method start = Class.forName(controllerPath).getDeclaredMethod(
//						"start", Stage.class);
//				start.setAccessible(true);
//				start.invoke(c, stage);
//
//				Method getTxtareaItems = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaItems");
//				getTxtareaItems.setAccessible(true);
//				TextArea txtareaItems = (TextArea) getTxtareaItems.invoke(c);
//				double txtareaItemsX = txtareaItems.localToScene(
//						new Point2D(txtareaItems.getLayoutX(), txtareaItems
//								.getLayoutY())).getX();
//				double txtareaItemsY = txtareaItems.localToScene(
//						new Point2D(txtareaItems.getLayoutX(), txtareaItems
//								.getLayoutY())).getY();
//
//				Method getTxtareaOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getTxtareaOrder");
//				getTxtareaOrder.setAccessible(true);
//				TextArea txtareaOrder = (TextArea) getTxtareaOrder.invoke(c);
//				double txtareaOrderX = txtareaOrder.localToScene(
//						new Point2D(txtareaOrder.getLayoutX(), txtareaOrder
//								.getLayoutY())).getX();
//				double txtareaOrderY = txtareaOrder.localToScene(
//						new Point2D(txtareaOrder.getLayoutX(), txtareaOrder
//								.getLayoutY())).getY();
//
//				Method getAddPizza = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddPizza");
//				getAddPizza.setAccessible(true);
//				Button addPizza = (Button) getAddPizza.invoke(c);
//				double addPizzaX = addPizza.localToScene(
//						new Point2D(addPizza.getLayoutX(), addPizza
//								.getLayoutY())).getX();
//				double addPizzaY = addPizza.localToScene(
//						new Point2D(addPizza.getLayoutX(), addPizza
//								.getLayoutY())).getY();
//
//				Method getAddBeverage = Class.forName(controllerPath)
//						.getDeclaredMethod("getAddBeverage");
//				getAddBeverage.setAccessible(true);
//				Button addBeverage = (Button) getAddBeverage.invoke(c);
//				double addBeverageX = addBeverage.localToScene(
//						new Point2D(addBeverage.getLayoutX(), addBeverage
//								.getLayoutY())).getX();
//				double addBeverageY = addBeverage.localToScene(
//						new Point2D(addBeverage.getLayoutX(), addBeverage
//								.getLayoutY())).getY();
//
//				Method getResetOrder = Class.forName(controllerPath)
//						.getDeclaredMethod("getResetOrder");
//				getResetOrder.setAccessible(true);
//				Button resetOrder = (Button) getResetOrder.invoke(c);
//				double resetOrderX = resetOrder.localToScene(
//						new Point2D(resetOrder.getLayoutX(), resetOrder
//								.getLayoutY())).getX();
//				double resetOrderY = resetOrder.localToScene(
//						new Point2D(resetOrder.getLayoutX(), resetOrder
//								.getLayoutY())).getY();
//
//				addPizza.fire();
//
//				String[] test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 7);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[6].charAt(test_area[6].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 3) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				String[] test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 1);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					Assert.assertTrue(calculateDistanceRecursive(
//							trim1(test_area_order[i]),
//							trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//				}
//
//				addBeverage.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 6);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 3) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 2);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '1');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i < 1) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				addPizza.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 5);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 2) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 3);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '1');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '2');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i == 0 || i == 2) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				addBeverage.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 4);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 2) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				test_area_order = txtareaOrder.getText().split("\n");
//				test_area_order = filterEmpty(test_area_order);
//				test_area_order = filterEmpty(test_area_order);
//				Assert.assertTrue(test_area_order.length >= 4);
//				Assert.assertEquals(test_area_order[0]
//						.charAt(test_area_order[0].length() - 1), '1');
//				Assert.assertEquals(test_area_order[1]
//						.charAt(test_area_order[1].length() - 1), '1');
//				Assert.assertEquals(test_area_order[2]
//						.charAt(test_area_order[2].length() - 1), '2');
//				Assert.assertEquals(test_area_order[3]
//						.charAt(test_area_order[3].length() - 1), '2');
//
//				for (int i = 0; i < test_area_order.length; i++) {
//					if (i == 0 || i == 2) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area_order[i]),
//								trim1(test_area_order[i]).length(), "beverage",
//								8) <= 4);
//					}
//				}
//
//				resetOrder.fire();
//
//				test_area = txtareaItems.getText().split("\n");
//				test_area = filterEmpty(test_area);
//				Assert.assertTrue(test_area.length >= 8);
//				Assert.assertEquals(
//						test_area[0].charAt(test_area[0].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[1].charAt(test_area[1].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[2].charAt(test_area[2].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[3].charAt(test_area[3].length() - 1), '4');
//				Assert.assertEquals(
//						test_area[4].charAt(test_area[4].length() - 1), '1');
//				Assert.assertEquals(
//						test_area[5].charAt(test_area[5].length() - 1), '2');
//				Assert.assertEquals(
//						test_area[6].charAt(test_area[6].length() - 1), '3');
//				Assert.assertEquals(
//						test_area[7].charAt(test_area[7].length() - 1), '4');
//
//				for (int i = 0; i < test_area.length; i++) {
//					if (i < 4) {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "pizza", 5) <= 3);
//					} else {
//						Assert.assertTrue(calculateDistanceRecursive(
//								trim1(test_area[i]), trim1(test_area[i])
//										.length(), "beverage", 8) <= 4);
//					}
//				}
//
//				Assert.assertEquals("", trim(txtareaOrder.getText()));
//
//				latch.countDown();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				Assert.fail("Failed to simulate resetOrder button click");
//			}
//		});
//
//		latch.await();
//	}

	private String trim(String s) {
		String res = "";
		for (String x : s.split("\n"))
			res += x.trim();
		return res.trim();
	}

	private String trim1(String s) {
		String res = "";
		for (String x : s.split("\n"))
			for (String y : x.split(" "))
				res += y.trim().toLowerCase();
		return res.trim();
	}

	private boolean con(String s1, String s2) {
		if (s1.length() > s2.length()) {
			String t = s1.toLowerCase().toString();
			s1 = s2.toLowerCase().toString();
			s2 = t;
		}
		return s2.contains(s1);
	}

	private static int calculateDistanceRecursive(String str1, int len1,
			String str2, int len2) {
		// Base cases: if either string is empty,
		// return the length of the other string
		if (len1 == 0) {
			return len2;
		}
		if (len2 == 0) {
			return len1;
		}

		// If the last characters of the strings are equal,
		// No operation is required
		if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
			return calculateDistanceRecursive(str1, len1 - 1, str2, len2 - 1);
		}

		// Calculate cost of three possible operations
		// Insertion, Deletion, and Substitution
		int insertionCost = calculateDistanceRecursive(str1, len1, str2,
				len2 - 1);
		int deletionCost = calculateDistanceRecursive(str1, len1 - 1, str2,
				len2);
		int substitutionCost = calculateDistanceRecursive(str1, len1 - 1, str2,
				len2 - 1);

		// Return minimum of the three
		// costs plus 1 (for the operation)
		return 1 + Math.min(Math.min(insertionCost, deletionCost),
				substitutionCost);
	}

	private String[] filterEmpty(String[] arr) {
		int c = 0;
		for (String s : arr)
			if (s.length() != 0)
				c++;
		String[] res = new String[c];
		int resC = 0;
		for (String s : arr)
			if (s.length() > 0)
				res[resC++] = s;
		return res;
	}
}