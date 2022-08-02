var dataToSend = {} ;
var requestInit = {
  'method': 'GET'
};

result = "";

function createTable(item, index, arr) {
    result = result + "<tr><td>" + item.id + "</td><td>" + item.name + "</td><td>" + item.amount + "</td><td>" + item.creationDate + "</td><td>" + item.lastDate + "</td></tr>";
};

function zaladuj_tabele() {

    result = "<table><tr class='naglowek'><td>Id.</td><td>Product name</td><td>Amount</td><td>Last date</td><td>Creation date</td></tr>";

    var retPromise = fetch( "/api/werehouse/all" , requestInit ).then(response => response.text())
    .then((response) => {
      try {
        const obj = JSON.parse(response);

        obj.forEach(createTable);
        result = result + "</table>"
        document.getElementById('stanMagazyn').innerHTML = result;

      }catch(err){
        alert ( "Error" ) ;
      }
    })
    .catch( err => console.log(err) );
};
