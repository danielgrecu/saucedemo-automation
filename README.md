## 🤖 Automatizare

Acest proiect folosește **automatizare de tip UI (User Interface)** pentru a simula interacțiuni reale ale unui utilizator pe site-ul [saucedemo.com](https://www.saucedemo.com).

Testele automate au fost scrise folosind:

- **Selenium WebDriver** – pentru a controla browserul și a interacționa cu elementele de pe pagină (click, tastare, verificări etc.)
- **JUnit 5** – pentru structurarea și rularea testelor
- **WebDriverManager** – pentru a gestiona automat driverele de browser (fără să le descarci manual)
- **Java** – ca limbaj principal

Scopul acestor teste este de a verifica funcționalitatea principală a site-ului: autentificare, adăugare produse în coș, sortare, checkout și afișarea mesajului final.

Automatizarea este utilă pentru:
- testarea regresivă rapidă a aplicației,
- detectarea rapidă a erorilor după modificări,
- rulări automate pe diferite browsere și rezoluții.

Testele pot fi rulate local, din IDE sau din linia de comandă cu `mvn test`.
