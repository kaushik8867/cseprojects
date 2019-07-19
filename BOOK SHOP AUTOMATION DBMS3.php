<html> 
<body> 
<form action=" " > 
<table style="color:red;border-style:groove; height:150px;width:350px" background="8cbd005a556ccd4211ce43f309bc0eac.jpg"> 
            <tr> 
                <td style=" height:25px; font-family:'Copperplate Gothic Bold'">&nbsp;</td> 
            </tr>          
            <tr> 
               <td style="color:green;background-color:black;height:45px"> 
                  Enter Query: <input type="text" name="Query"><br></td> 
            </tr> 
            <tr> 
                <td style="height:25px"> 
                           <input type="submit" value="Submit" style="color:black;background-color:white; height:40px" /></td> 
            </tr> 
        </table>  
</body> 
</html>
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
	echo $query,"<br>"; 
	$total =mysqli_num_rows($data);
	if($total)
	{
		echo "number of rows are ",$total," <br><br>";
	}
 	$i = 0; 
 	echo '<html><body><table border=1><tr>';  	
	while ($i < mysqli_num_fields($data)) 
 	{ 
 	 	$meta = mysqli_fetch_field($data); 
 	 	echo '<td>' . $meta->name . '</td>'; 
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