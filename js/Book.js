(function(){
    var bookapp = angular.module('bookapp', ['ngRoute']);

    bookapp.config(function($routeProvider) {
        $routeProvider
        .when("/TheReadersGuild", {
          templateUrl : "TheReadersGuild.html",
        })
        .when("/Quiz", {
            templateUrl : "Quiz.html",
            controller: "QuizController"
          })
          .when("/Genres",{                           
            templateUrl : "Genres.html",
            controller: "GenresController"
          })
        .when("/CRUD",{                           
          templateUrl : "CRUD.html",
          controller: "CRUDcontroller"
        })
        
        .otherwise({
            templateUrl : "TheReadersGuild.html"
        });

      });

})()