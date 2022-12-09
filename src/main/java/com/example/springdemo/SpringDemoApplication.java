package com.example.springdemo;

import com.example.springdemo.model.FavoritesList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    private FavoritesList favorites;

    public SpringDemoApplication() {
        favorites = new FavoritesList();
    }

    @GetMapping("/get_favorites")
    public List<String> getFavorites() {
        List<String> favoriteBooks = new ArrayList<>();
        for (int i = 0; i < favorites.getSize(); i++) {
            favoriteBooks.add(favorites.get(i));
        }
        return favoriteBooks;
    }

    @PostMapping("/add_favorite")
    public void addFavorite(@RequestParam(value = "bookName") String bookName) {
        favorites.add(bookName);
    }
}
