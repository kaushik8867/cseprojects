<html>
<body bgcolor=lightgrey >
<center>
<?php
 $mysqli = mysqli_connect("localhost","root","", "book_shop");
 if($mysqli)
 {
$query= $_GET['Query'];  
if($query)
{
$data = mysqli_query($mysqli,$query);
if ($data)  
{ 
	echo "<br>The output for the query:<h3>", $query,"<br><br>"; 
	$total =mysqli_num_rows($data);
	//if($total)
	{
		//echo "number of rows are ",$total," <br><br>";
	}//
 	$i = 0; 
 	echo '<html><body><table  border=1><tr> ';  	
	while ($i < mysqli_num_fields($data)) 
 	{ 
 	 	$meta = mysqli_fetch_field($data); 
 	 	echo '<td><h4>' . $meta->name . '</td>'; 
 	 	$i = $i + 1; 
 	} 
 	echo '</tr>'; 
 	$i = 0; 
 	while ($row = mysqli_fetch_row($data))  
 	{ 
	  echo '<tr>';   
	$count = count($row); 
 	 	$y = 0; 
 	 	while ($y < $count) 
 	 	{ 
 	 	 	$c_row = current($row);  	 
		 	echo '<td>' . $c_row . '</td>'; 
 	 	 	next($row); 
 	 	 	$y = $y + 1; 
 	 	} 
 	 	echo '</tr>'; 
 	 	$i = $i + 1; 
 	} 

}
} 
}
else
{
	die("no query");
}
?>
</center>
</body>
</html> 