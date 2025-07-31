# Test automat pentru site-ul Saucedemo

Acest proiect conține un scenariu de testare automată pentru site-ul demo [saucedemo.com](https://www.saucedemo.com), realizat cu Java și Selenium WebDriver.

## 🔧 Tehnologii folosite

- Java 17+
- Maven
- Selenium WebDriver
- WebDriverManager
- JUnit 5

## 📁 Structura proiectului

- `pom.xml` – fișierul Maven care conține toate bibliotecile necesare
- `src/test/java/websiteSoucedemo/` – folderul în care se află testul automat scris

## 🤖 Automatizare

Proiectul conține un **singur scenariu automatizat complet**, care acoperă următorii pași:

1. Autentificarea pe site cu date valide
2. Sortarea produselor
3. Adăugarea unuia sau mai multor produse în coș
4. Ștergerea unui produs din coș
5. Finalizarea comenzii (checkout)

