


function wydajProdukt() {

    var id = parseInt(document.getElementById('productIdSell').value);

    var amount = parseInt(document.getElementById('productAmount2').value);
    var dane = JSON.stringify({'id':id,'amount':amount});


var backToJS = JSON.parse(dane);



    var requestInit2 = {
      method: "PATCH",
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(backToJS)
    };

    var retPromise2 = fetch( "/api/werehouse/sub" , requestInit2).then(response => response.text())
             .then((response) => {
               try {
               if(response == "true")
               {
                      document.getElementById('lastOperation1').innerHTML = "The quantity has been subtracted.";
                  }
                  else
                  {
                    document.getElementById('lastOperation1').innerHTML = "Connection error";
                                   }
               }catch(err){
                 document.getElementById('lastOperation1').innerHTML = "Error";
               }
             })
             .catch( err => console.log(err) );
     setTimeout(zaladuj_tabele, 1000);
};
