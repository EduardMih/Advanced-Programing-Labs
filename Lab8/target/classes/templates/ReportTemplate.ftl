<html>
<head>
    <title>Report</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>${movie.title}</h1>
<h3>Genres</h3>
<#list  movie.genres as genre>
    <ul>
    <li>${genre.name}</li>
    </ul>
</#list>
<h3>Directors</h3>
<#list movie.directors as director>
   <ul>
    <li>${director.name}</li>
   </ul>
</#list>
<h3>Details</h3>
<ul>
    <li><strong>Release Date: </strong>${movie.releaseDate}</li>
    <li><strong>Duration: </strong>${movie.duration}</li>
    <li><strong>Score: </strong>${movie.score}</li>
</ul>
<h3>Actors</h3>
<ul>
<#list movie.actors as actor>
    <li>${actor.name}</li>
</#list>
</ul>
</body>
</html>
