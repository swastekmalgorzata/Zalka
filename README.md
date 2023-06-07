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
Body: {"Manufacturer": "Mercedes", "engine": "W12", "year": 2023, "driver": "Lewis Hamilton", "startNumber": 44}

Edycja istniejącego samochodu o ID 1:

css

PUT /carEdit/1
Body: {"brand": "Mercedes", "model": "W13", "year": 2024, "driver": "Lewis Hamilton", "startNumber": 44}

Pobieranie strony tytułowej:

    GET /home

Obsługa błędów

W przypadku wystąpienia błędu podczas przetwarzania żądania, zostanie zwrócony odpowiedni kod odpowiedzi 
HTTP (np. 404 Not Found lub 500 Internal Server Error) oraz dodatkowe informacje na temat błędu w treści odpowiedzi. 
