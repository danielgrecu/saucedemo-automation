# Test automat pentru site-ul Saucedemo

Acest proiect conține un scenariu de testare automată pentru site-ul demo [saucedemo.com](https://www.saucedemo.com), realizat cu Java și Selenium WebDriver.

🔧 Tehnologii folosite

- Java 17+
- Maven
- Selenium WebDriver
- WebDriverManager
- JUnit 5

Scenariu 1 –  Achizitie completa cu 2 produse

Pasi automatizati:
- Acceseaza site-ul SauceDemo
- Logare cu date valide (username: standard_user, parola: secret_sauce)
- Aplica filtrul produse "Name (A to Z)"
- Adauga 2 produse in cos: Backpack si Bike Light
- Acceseaza cosul de cumparaturi
- Finalizeaza comanda (Checkout) completand informatiile: Daniel Grecu, cod postal 240150
- Verifica mesajul final de confirmare: "Thank you for your order!"


Scenariu 2 – Gestionarea cosului cu eliminarea unui produs si finalizarea comenzii

Pasi automatizati:
- Acceseaza site-ul SauceDemo
- Autentificare cu date valide (username: standard_user, parola: secret_sauce)
- Aplica filtrul de pret "Low to High"
- Adauga primele 3 produse in cos: Backpack, Bike Light, Bolt T-Shirt
- Acceseaza cosul de cumparaturi si elimina al 3-lea produs (Bolt T-Shirt)
- Revine la pagina de produse
- Aplica din nou filtrul de pret "Low to High" si adauga Fleece Jacket
- Finalizeaza comanda (Checkout) completand informatiile: Daniel Grecu, cod postal 240150
- Verifica mesajul final de confirmare: "Thank you for your order!"


 Scenariu 3 – Logare cu parola incorecta si verificare eroare

 Pasi automatizati:
- Acceseaza site-ul SauceDemo
- Logare cu username corect si parola gresita (ultima litera dublata)
- Verifica ca mesajul de eroare este afisat
- Browserul ramane deschis pentru inspectie
