# MyRecipes
this app Fetch data from JSON API using Retrofit2 and display it in a RecyclerView.

# Features

1) you can sort the recipes ascending based on fats/Calories
2) the app remembers you last choice in sorting to re-sort the data in the same way for the next time
3) you can search by Recipe name in search bar
# Permissions

1)internet access
2)check network state

# Libraries
1) Retrofit2 >> to Fetch data from Api
2) Picasso >> to fetch photos from URL
3) Gson >> to parse the JSON data

# Steps
1) creating recipe model
2) creating Retrofit2 client class and endpoint interface
3) Editing the main activity xml file to include (SearchView, sorting cardView with checkBoxex, RecyclerView)
4) creating RecyclerView row element xml layout file
5) creating RecyclerView Adapter class
6) displaying data on RecyclerView
7) appling filter to RecyclerView to achieve searching
8) adding the searchView Listener
9) adding comparator methods to the model class to achieve sorting
10) adding okHttp3 intecepator classes to handle no internet connection
