from django.shortcuts import render

# Create your views here.
from .models import Movie, Category, Director

def movies(request):
    movies = Movie.objects.all()

    return render(
        request,
        "movies.html",
        context = {
            "movies" : movies
        }
    )

def directors(request):
    directors = Director.objects.all()
    return render(
        request,
        "directors.html",
        context = {
            "directors" : directors
        }
    )