# CSE 122 Spring Demo 

Demo project for showing how to make a web app backed by Java using Spring

Recommend to first follow this tutorial to set up the project, and then add these files to the project:

**Backend**

* `src/main/java/com/example/springdemo/SpringDemoApplication.java` - The main Spring Controller. This has the methods that link the URL links to specific Java methods.
* `src/main/java/com/example/springdemo/model/FavoritesList.java` - The `FavoriteList` class from the OOP It example.

**Frontend**

* `src/main/resources/static/index.html` - The main HTML file for outlining the content of the page.
* `src/main/resources/static/stlye.css` - The CSS file for overriding styles. Note this is minimal because the `index.html` also includes [Bootstrap](https://getbootstrap.com/) (a CSS library for good default styles)
* `src/main/resources/static/index.html` - The main JS file for outlinng how to update the page state and add interactivity for the page.

## Preview
<img width="1695" alt="image" src="https://user-images.githubusercontent.com/9054538/206813796-d88e3649-9ef5-4e35-b6de-ac66b7735739.png">

## Ideas for Extensions

The app as written is fairly simple and doesn't do a lot of extra things. Here are some ideas for other features to add to the program.

* Add the ability for users to log in and have their own set of favorite books (right now, everyone shares the same favorite book list).
* Let users compare each other's favorite books.
* Provide more control over the ordering of the favorite books.
* And many other ideas!
