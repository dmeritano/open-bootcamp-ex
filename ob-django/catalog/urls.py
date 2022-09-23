from django.urls import include, re_path, path
from catalog import views

urlpatterns = [
    re_path(r"^$", views.directors, name="directors"),
    #path('/', views.index, name='index'),
    path('movies/', views.movies, name='movies'),
]