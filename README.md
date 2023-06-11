Dokumentacja projektu Java Spring z bazą danych Postgres
Opis projektu

Projekt jest aplikacją webową opartą na Java Spring, wykorzystującą bazę danych PostgreSQL. Celem projektu jest umożliwienie zarządzania danymi związanych z Formułą 1, takimi jak samochody, zespoły, kierowcy, wyścigi itp. Aplikacja udostępnia endpointy do tworzenia i edycji rekordów dla każdej z tych encji. Dodatkowo, istnieje endpoint "home", który wyświetla jedynie stronę tytułową aplikacji.
Technologie

    Java Spring - framework do tworzenia aplikacji webowych w języku Java.
    PostgreSQL - system zarządzania bazą danych.
    Hibernate - narzędzie do mapowania obiektowo-relacyjnego (ORM), używane do interakcji z bazą danych.
    Thymeleaf - silnik szablonów HTML, używany do generowania widoków.

Konfiguracja bazy danych

    Zainstaluj PostgreSQL na swoim systemie.
    Utwórz nową bazę danych w PostgreSQL.
    Zmodyfikuj plik konfiguracyjny projektu (application.properties lub application.yml) w celu skonfigurowania połączenia z bazą danych. Ustaw odpowiednie wartości dla spring.datasource.url, spring.datasource.username i spring.datasource.password.

Endpointy
Endpoint /cars

    Metoda: GET
    Ścieżka: /cars
    Opis: Zwraca listę samochodów Formuły 1.
    Parametry zapytania: brak

Endpoint /carAdd

    Metoda: POST
    Ścieżka: /cars/create
    Opis: Tworzy nowy samochód Formuły 1.
    Parametry zapytania: dane samochodu w formacie JSON.

Endpoint /carEdit/{id}

    Metoda: PUT
    Opis: Edytuje istniejący samochód Formuły 1 o podanym identyfikatorze.
    Parametry zapytania: identyfikator samochodu (ID) oraz dane do edycji w formacie JSON.

Endpointy dla pozostałych encji

    Endpointy dla zespołów (/teams), głównych przedstawicieli (/principals), wyścigów (/races) i kierowców (/drivers) są zbudowane w podobny sposób jak endpointy dla samochodów. Udostępniają metody GET, POST i PUT dla pobierania, tworzenia i edycji rekordów odpowiednich encji.

Endpoint /home

    Metoda: GET
    Ścieżka: /home
    Opis: Wyświetla stronę tytułową aplikacji.

Kod odpowiedzi

    200 OK: Jeśli żądanie zostało przetworzone pomyślnie.
    201 Created: Jeśli rekord został pomyślnie utworzony.
    204 No Content: Jeśli rekord został pomyślnie zaktualizowany.
    404 Not Found: Jeśli nie znaleziono żądanego zasobu.
    500 Internal Server Error: Jeśli wystąpił błąd podczas przetwarzania żądania.

Przykłady użycia

    Pobieranie listy samochodów:


GET /cars



POST /
Body: {"manufacturer": "Mercedes", "engine": "W12", "season": 2023, "driver": "Lewis Hamilton", "wins": 0, "races": 44}
Edycja istniejącego samochodu o ID 1:

css

PUT /carEdit/1
Body: {"manufacturer": "Mercedes", "engine": "W12", "season": 2023, "driver": "Lewis Hamilton", "wins": 0, "races": 44}

Pobieranie strony tytułowej:

    GET /home
    
Mechanizmy logowania i rejestracji w projekcie Java Spring z wykorzystaniem Spring Security:

1. Logowanie:
   - W projekcie został wykorzystany moduł Spring Security do zabezpieczenia dostępu do aplikacji.
   - Użytkownik może zalogować się poprzez wywołanie endpointu /login przy użyciu metody POST.
   - W żądaniu logowania użytkownik przekazuje dane logowania w formacie JSON, takie jak adres e-mail (email) i hasło (password).
   - Dane logowania są weryfikowane przez mechanizm Spring Security, który porównuje je z danymi zapisanymi w bazie danych.

2. Rejestracja:
   - Aby umożliwić rejestrację nowego użytkownika, został utworzony endpoint /register przy użyciu metody POST.
   - W żądaniu rejestracji użytkownik przekazuje dane rejestracyjne w formacie JSON, takie jak adres e-mail (email), hasło (password), imię (firstName) i nazwisko (lastName).
   - Dane rejestracyjne są weryfikowane pod kątem poprawności (np. unikalność adresu e-mail) i zapisywane w bazie danych.
   - Po pomyślnym utworzeniu konta, użytkownik może użyć tych danych do logowania.

3. Dostęp do operacji dodawania, edycji i usuwania danych:
   - Aby móc wykonywać operacje dodawania, edycji i usuwania danych, użytkownik musi być zalogowany.
   - Każdy chroniony endpoint (np. /carAdd, /carEdit, /deleteCar) wymaga, aby się zalogować

Endpoint /login:

Metoda: POST
Ścieżka: /login
Opis: Logowanie użytkownika do aplikacji.

Parametry zapytania:

    email: Adres e-mail użytkownika.
    password: Hasło użytkownika.

Kody odpowiedzi:

    200 OK: Jeśli logowanie zakończyło się sukcesem. W odpowiedzi zostaje zwrócony token dostępu.
    401 Unauthorized: Jeśli podane dane logowania są nieprawidłowe.

Przykład użycia:

POST /login
Body: {"email": "example@example.com", "password": "password"}

Endpoint /register:

Metoda: POST
Ścieżka: /register
Opis: Rejestracja nowego użytkownika w aplikacji.

Parametry zapytania:

    email: Adres e-mail użytkownika.
    password: Hasło użytkownika.

Obsługa błędów

W przypadku wystąpienia błędu podczas przetwarzania żądania, zostanie zwrócony odpowiedni kod odpowiedzi 
HTTP (np. 404 Not Found lub 500 Internal Server Error) oraz dodatkowe informacje na temat błędu w treści odpowiedzi. 


Wersje aplikacji:

1.0.0 (2023-01-01):

    Podstawowa funkcjonalność aplikacji, umożliwiająca zarządzanie danymi związanych z Formułą 1.
    Endpointy do tworzenia, edycji i pobierania danych dla encji samochodów, zespołów, kierowców, wyścigów itp.
    Możliwość logowania i rejestracji użytkowników.
    Mechanizm uwierzytelniania i autoryzacji z wykorzystaniem Spring Security.

1.1.0 (2023-02-15):

    Dodanie endpointu /home wyświetlającego stronę tytułową aplikacji.
    Dodanie walidacji danych wejściowych przy tworzeniu i edycji rekordów.
    Poprawki błędów zgłaszanych przez użytkowników.

1.2.0 (2023-03-30):
    Aktualizacja mechanizmu uwierzytelniania i autoryzacji w celu ograniczenia dostępu do operacji dodawania, edycji i usuwania tylko dla zalogowanych użytkowników.



