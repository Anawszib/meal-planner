# Anna Adamik
## Planer posiłków
### Opis
Aplikacja webowa do planowania posiłków w ciągu dnia, pokazująca kaloryczność oraz wartości odżywcze.

### Link do Heroku
https://java-meal-planner.herokuapp.com/

### Założenia ogólne
- aplikacja do planowania dziennego menu z uwzględnieniem wartości odżywczych poszczególnych dań
- użytkownik wybiera dania do swojego dziennego menu z listy dań
- możliwość zobaczenia pełnej listy wybranych dań oraz jej edycji (usuwania poszczególnych pozycji, konkretnego dania oraz wszystkich wybranych dań)
- możliwość zobaczenia podsumowania wybranych dań w odniesieniu do dziennej  referencyjnej wartości spożycia
- możliwość dodawania, edytowania oraz usuwania dań
- możliwość podglądu konkretnego dania (wartości odżywczych, możliwość jego wyboru, usunięcia z wybranych, edycji oraz usunięcia z listy dań

### Założenia techniczne
- prosta aplikacja webowa
- lista dań oraz lista wybranych dań zapisywane w bazie danych
- widoki: lista dań, lista wybranych dań, statystyki wartości odżywczych, dodawanie nowego dania, edycja dania, podgląd konkretnego dania

### Stos technologiczny
- Java
- Maven
- Spring Boot(Web, JPA)
- PostgreSQL, H2database
- Thymeleaf
- UIKit
- Chart.js
- JUnit
- Mockito
- Heroku

### Instrukcja obsługi

### Pierwsze uruchomienie lokalnie
1. W db.properties ustawić dane do swojej bazy danych.
2. Uruchomić aplikację.
3. W przeglądarce internetowej wejść na stronę: http://localhost:8080/.
4. Dodać dania do listy dań przy pomocy przycisku "DODAJ NOWE DANIE".
Przykładowa lista dań znajduje się w pliku oldData.sql.

### Pierwsze uruchomienie Heroku
1. W przeglądarce internetowej wejść na stronę: https://java-meal-planner.herokuapp.com/.

### Dodawanie nowych dań
1. Z widoku listy dań kliknąć przycisk "DODAJ NOWE DANIE", znajdujący się po lewej stronie.
2. Uzupełnić formularz:
Nazwa dania - pole jest wymagane, nazwa musi być unikalna.
Kalorie, Białko, Węglowodany, Tłuszcz, Białko, Sól - pola są opcjonalne, wartości muszą być numeryczne.
Grafika, Strona źródłowa - pola są opcjonalne.
3. Kliknąć przycisk "ZAPISZ", na dole po prawej stronie.

### Wyświetlanie listy dań
1. W przeglądarce internetowej wejść na stronę: http://localhost:8080/ (https://java-meal-planner.herokuapp.com/) lub skorzystać z przycisku "LISTA DAŃ" w pasku na górze strony.

### Wyświetlanie listy wybranych dań
1. W przeglądarce internetowej wejść na stronę: http://localhost:8080/selected-dish (https://java-meal-planner.herokuapp.com/selected-dish) lub skorzystać z przycisku "WYBRANE DANIA" w pasku na górze strony.

### Wyświetlanie % RWS wybranych dań
1. W przeglądarce internetowej wejść na stronę: http://localhost:8080/nutritional-values (https://java-meal-planner.herokuapp.com/nutritional-values) lub skorzystać z przycisku "WARTOŚCI ODŻYWCZE" w pasku na górze strony.

### Podgląd szczegółowy danego dania
1. Z widoku "LISTA DAŃ" lub "WYBRANE DANIA" kliknąć na nazwę danego dania.
2. Z tego miejsca można:
- dodać danie do wybranych - przycisk "WYBIERZ DANIE"
- edytować danie - przycisk "EDYTUJ DANIE" na rozwijanej liście, a następnie formularz analogiczny jak przy dodawaniu nowych dań
- usunąć danie z wybranych - przycisk "USUŃ DANIE Z WYBRANYCH" (np. gdy danie było wybrane 2 razy usunie oba wybory)
- usunąć danie - przycisk "USUŃ DANIE" (lista wybranych dań zostanie zaktualizowana automatycznie).

### Dodawanie dania do listy wybranych
1. Z poziomu danego dania - przycisk "WYBIERZ DANIE".
2. Z poziomu listy dań - przycisk "+" po prawej stronie dania.

### Usuwanie dania z listy wybranych
1. Z poziomu listy wybranych dań - przycisk "-" po prawej stronie dania (usunie tylko jeden wybór).
2. Z poziomu danego dania - przycisk "USUŃ DANIE Z WYBRANYCH" (np. gdy danie było wybrane 2 razy usunie oba wybory).
3. Z poziomu listy wybranych dań - przycisk "USUŃ WSZYSTKIE DANIA" na dole strony (usunie wszystkie wybrane dania).
