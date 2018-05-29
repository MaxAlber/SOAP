<!DOCTYPE HTML>  
<html>
<head>
    
    
<style>
        
body
{
    background-color: lightblue;
    margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;  
    
    
}

.center
{
    margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
}
    
    
        
</style>
</head>
<body>  

<?php
// Alle Variablen leeren
$albumErr = $artistErr = $actionTypeErr = "";
$album = $artist = $actionType = "";
    
    
    //Fehlererkennung -> überprüft ob etwas eingegeben wurde.
    
    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-//
                                                                        //
if ($_SERVER["REQUEST_METHOD"] == "POST")                                  //
{                                                                          // 
  
    if (empty($_POST["actionType"]))
    {
        $actionTypeErr = "Bitte Funktion auswählen";
    }
    else
    {
        $actionType = $_POST["actionType"];
    }
  
    
    if (empty($_POST["artist"]))
    {
        $artistErr = "Bitte Artisten eingeben";
    }
    else
    {
        $artist = $_POST["artist"];
    }
    
    
    if (empty($_POST["album"]))
    {
	   if (actionType == "getAlbumNames")
       {
		  $albumErr = "";
	   }
        else
        {
		  $albumErr = "Bitte Album-Namen eingeben";
	   }
    }
    else
    {
        $album = $_POST["album"];
    }

}

//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-//
    
// Ende der Fehlererkennung 
    
?>

    
    
    
    
    
    
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
  Bitte wählen Sie eine Aktion:
    <br>
  <input type="radio" name="actionType" <?php if (isset($actionType) && $actionType=="getAlbumPrice"){ echo "checked";}?> value="getAlbumPrice">Preis anzeigen
    <br>
  <input type="radio" name="actionType" <?php if (isset($actionType) && $actionType=="getAlbumNames"){ echo "checked";}?> value="getAlbumNames">Alle Alben anzeigen
    <br>
  <input type="radio" name="actionType" <?php if (isset($actionType) && $actionType=="buyAlbum"){ echo "checked";}?> value="buyAlbum">Album kaufen
  <span class="error"><?php echo $actionTypeErr;?></span>
  <br><br>
  Artist: <input type="text" name="artist" value="<?php echo $artist;?>">
  <span class="error"><?php echo $artistErr;?></span>
  <br><br>
  Album: <input type="text" name="album" value="<?php echo $album;?>">
  <span class="error"><?php echo $albumErr;?></span>
  <br><br>
  <input type="submit" name="submit" value="Los!">  
</form>

<?php
//echo "<h2>";

if(!empty($actionType) && empty($artistErr) && empty($albumErr) && empty($actionTypeErr))
{
	$client = new SoapClient("http://localhost:8080/Publisher?wsdl");
	if($actionType == "getAlbumNames")
    {
		$params = array("artist" => $artist);
	} 
    else
    {
		$params = array("artist" => $artist,"album" => $album);
	}
    
	$response = $client->__soapCall($actionType, $params);
	echo "<br>";
	
	if($actionType == "getAlbumPrice")
	{
		echo "Das Album kostet " . $response . "€";
	}
    
	else if($actionType == "getAlbumNames")     
	{
        
        
        
        // Hier wird der String so aufgeteilt damit Umbrüche eingebaut werden können
        
        //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*//
        
        
        $test = explode(" ", $response);
        
        $i = 1;
            for($i=0; $i < count($test); $i++)
            { 
                echo $test[$i];
                echo "<br>";
            }
	}
    
    
    
	else if($actionType == "buyAlbum")
	{
		if($response == "1")
			echo "Gekauft!";
		else
			echo "Album im Moment nicht verfügbar";
	}
}
echo "</h2>";
?>


</body>
</html>