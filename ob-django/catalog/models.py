from django.db import models
from django.urls import reverse

# Create your models here.
class Category(models.Model):
    name = models.CharField(max_length=64,help_text="Movie's categories")

    def __str__(self):
        return self.name

    class Meta:     
        verbose_name_plural = "Categories"


class Director(models.Model):
    name = models.CharField(max_length=40)
    born_date = models.DateField(null=False, blank=False)
    nationality =  models.CharField(max_length=20)
    biography = models.TextField(max_length=200)
    spouse = models.CharField(max_length=40)
    sons = models.CharField(max_length=2, help_text="Number of sons")


    def __str__(self):
        return self.name

    def get_absolute_url(self):
        return reverse('director-detail', args=[str(self.id)])

    def __str__(self):
        return '%s (%s)' % (self.name, self.nationality)        


class Movie(models.Model):
    title = models.CharField("Movie", max_length=60, help_text="Movie's title")
    synopsis = models.TextField(max_length=200, help_text="Movie's synopsis")
    writer = models.CharField("Writer", max_length=80, help_text="Movie's writer")
    stars = models.TextField(max_length=100, help_text="Movie's actors")
    release_date = models.DateField(null=False, blank=False)
    director = models.ForeignKey('Director', on_delete=models.SET_NULL, null=True)
    category = models.ManyToManyField(Category)


    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return reverse('movie-details', args=[str(self.id)])  


