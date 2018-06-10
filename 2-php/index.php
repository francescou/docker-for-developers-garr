<?php
ini_set('display_errors', 'On');
//error_reporting(E_ALL);

$servername = getenv('MYSQL_HOST');
$username = "root";
$password = getenv('MYSQL_PASSWORD');

// Create connection
$conn = new mysqli($servername, $username, $password);

// Create database
$sql = "CREATE DATABASE humidity";
if ($conn->query($sql) === TRUE) {
    //echo "Database created successfully";
} else {
    //echo "Error creating database: " . $conn->error;
}


$conn = new mysqli($servername, $username, $password, "humidity");


// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}



$sql = "CREATE TABLE Humidity (
    value INT(6)
    );";

    if ($conn->query($sql) === TRUE) {
        //echo "Table Humidity created successfully";
    } else {
        //echo "Error creating table: " . $conn->error;
    }




$humidityz = 60;

$sql = "SELECT value FROM Humidity";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $humidityz = $row["value"];
        //echo "value: " . $humidityz;

    }
} else {
    //echo "0 results";
    $sql = "INSERT INTO Humidity (value) VALUES ($humidityz);";

    if ($conn->query($sql) === TRUE) {
        //echo "New record created successfully";
    } else {
        //echo "Error: " . $sql . "<br>" . $conn->error;
    }

}
$conn->close();



class Humidity {
    public $value = 0;
}

$humidity = new Humidity();
$humidity->value = $humidityz;



// codifica JSON
$stringa = json_encode($humidity);

header('Content-Type: application/json');
echo $stringa;

?>