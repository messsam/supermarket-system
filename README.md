# Supermarket System

A desktop supermarket POS app built with Java and JavaFX.

## What it does

Simulates a supermarket checkout: browses products, adds them to a cart, and processes the transaction. A `Simulator` class handles the automated customer/cashier behavior in the background.

## Stack

- Java
- JavaFX (controls, FXML, media)

## OOP concepts used

Inheritance, abstraction, polymorphism, encapsulation, and interfaces, all applied across the model layer (people, products, etc.).

## Project structure

```
supermarket-system/
├── src/
│   └── eg/edu/guc/supermarket/
│       ├── controller/         # JavaFX controllers, app entry point
│       └── model/
│           └── people/         # Simulator and person-related classes
├── Transactions.csv            # Transaction log (read/written at runtime)
├── cash-register-audio.wav     # Plays on checkout
├── icon.png                    # App window icon
└── supermarket-system.iml
```

## Running it

1. Clone the repo:
   ```bash
   git clone https://github.com/messsam/supermarket-system.git
   ```

2. Open in IntelliJ, it'll pick up the `.iml` file automatically.

3. Make sure all JavaFX modules (`javafx-controls`, `javafx-fxml`, `javafx-media`) are the **same version**. Mixed versions will cause runtime errors.

4. Run `SupermarketGUI.java`.

> `Transactions.csv`, `icon.png`, and `cash-register-audio.wav` need to stay in the project root (next to `src/`), they're loaded by file path, not from the classpath.
