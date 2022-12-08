"use strict";
(function() {
    window.addEventListener("load", init);

    function init() {
        // Add listener to favorites form
        $("#favoriteForm").submit(function(e){
            e.preventDefault();
            $.ajax({
                url: "/add_favorite",
                type: "post",
                data: $("#favoriteForm").serialize(),
                success: function() {
                    $("#favoriteForm")[0].reset();
                    refreshState();
                }
            });
        });

        refreshState();
    }

    function refreshState() {
        console.log("Refreshing");

        // Get all of the favorites
        $.ajax({
            url: "/get_favorites",
            type: "get",
            success: function(favoriteBooks) {
                // Update number of favorites
                $("#numFavorites").text(favoriteBooks.length);

                // Reset list display and add in favorites
                $("#favoriteBooks").empty()
                for (let i in favoriteBooks) {
                    $("#favoriteBooks").append($("<li>").text(favoriteBooks[i]));
                }
            }
        });
    }
})();
