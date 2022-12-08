package com.example.springdemo.model;

// Author: Miya
// This class represents a list of favorites and supports various operations on the list 
// of favorites.

import java.util.*;
import java.io.*;

public class FavoritesList {
    private List<String> favorites;

    // Initializes a FavoritesList containing the contents of the file specified
    // by the given String. Each line in the file translates to a new entry in the
    // FavoritesList and the entries in the list are ordered such that the first line
    // in the file is considered the "most" favorite.
    public FavoritesList(String fileName) throws FileNotFoundException {
        this();
        loadFavorites(fileName);
    }

    // Initializes an empty FavoritesList.
    public FavoritesList() {
        favorites = new ArrayList<>();
    }

    // accessors

    // Returns the current size of this FavoritesList.
    public int getSize() {
        return favorites.size();
    }

    // Returns the entry at the given index of this FavoritesList.
    // (using 0-based indexing)
    public String get(int i) {
        return favorites.get(i);
    }

    // modifiers

    // Adds the given entry to the end of the FavoritesList
    public void add(String favorite) {
        favorites.add(favorite);
    }

    // operations

    // Prints the contents of the Favorites List to the file specified by the given outFileName.
    public void saveToFile(String outFileName) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(outFileName));
        for (int i = 0; i < favorites.size(); i++) {
            output.println(favorites.get(i));
        }
    }

    // Moves the element at index target down by one in the FavoritesList if target is valid.
    // If target is negative or beyond the penultimate index of the list, prints an error message.
    public void moveDown(int target) {
        if (target >= 0 && target < favorites.size() - 1) {
            String element = favorites.remove(target);
            favorites.add(target + 1, element);
        } else {
            System.out.println("Your favorites list isn't long enough to perform that operation!");
        }
    }

    // Returns a new list storing the first n elements of the FavoritesList.
    // If n is greater than the size of the given list, the returned list contains all elements of
    // the given list.
    // If n is negative, an empty list is returned.
    public FavoritesList topN(int n) {
        n = Math.min(n, favorites.size());
        FavoritesList result = new FavoritesList();
        for (int i = 0; i < n; i++) {
            result.add(favorites.get(i));
        }

        return result;
    }

    // Prints out this FavoritesList from most favorite to least favorite, with the elements
    // numbered 0, 1, 2, ...
    public void printList() {
        for (int i = 0; i < favorites.size(); i++) {
            System.out.println(" " + i + ") " + favorites.get(i));
        }
    }

    // Sets up this FavoritesList so that each element is a line from the file specified by the given fileName.
    public void loadFavorites(String fileName) throws FileNotFoundException {
        // favorites stored with most favorite first, in decreasing order
        Scanner favoritesScan = new Scanner(new File(fileName));
        while (favoritesScan.hasNextLine()) {
            String nextFavorite = favoritesScan.nextLine();
            favorites.add(nextFavorite);
        }
    }

    // Prints out all elements that appear both in this FavoritesList and otherList along with each
    // list's relative ranking of the element.
    public void compareToList(FavoritesList otherList) {
        for (int i = 0; i < otherList.getSize(); i++) {
            String movie = otherList.get(i);
            if (favorites.contains(movie)) {
                int myRank = favorites.indexOf(movie);
                System.out.println("-" + movie + " (you ranked " + myRank + ", friend ranked " + i + ")");
            }
        }
    }

    // Adds all of the elements in otherList to this FavoritesList at the specified location if the
    // location is a valid index.
    // If location is negative or greater than the size of this FavoritesList, prints an error message.
    public void addAll(FavoritesList otherList, int location) {
        if (location >= 0 && location <= favorites.size()) {
            for (int i = 0; i < otherList.getSize(); i++) {
                favorites.add(location + i, otherList.get(i));
            }
        } else {
            System.out.println("Your favorites list isn't long enough to perform that operation!");
        }
    }
}