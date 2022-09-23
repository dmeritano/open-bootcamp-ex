from django.contrib import admin

# Register your models here.

from .models import Movie, Category, Director

admin.site.register(Movie)
admin.site.register(Category)
admin.site.register(Director)

