<?php
	
	$server= "localhost";
	$user= "root";
	$passwd= "";
	$db_name= "book_shop";
	$dbcon = mysqli_connect($server, $user, $passwd, $db_name);
	
	if(!$dbcon) {
		
		die("unable to connect");
		}
 
?>