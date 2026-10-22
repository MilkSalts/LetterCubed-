# Letter Cubed

A small Java movie tracker/Letterboxd-style CLI app with SQLite persistence, watch list tracking, reviews, search, and a refactored formatter system using inheritance and polymorphism.

## Features
- Add movies
- View all movies
- Search by title/director/genre/year
- Add movies to watch list
- Change watch list status
- Add reviews and ratings
- Edit/delete movies
- Formatter refactor with a default and hype-style theme

## Run
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.lettercubed.Main"
```

Optional formatter style:
```bash
mvn exec:java -Dexec.mainClass="com.lettercubed.Main" -Dexec.args="hype"
```

## Project structure
```text
src/main/java/com/lettercubed/
  Main.java
  DatabaseConnection.java
  Movie.java
  MovieSearch.java
  WatchList.java
  Review.java
  Formatter.java
  CLIFormatter.java
  HypeFormatter.java
```
