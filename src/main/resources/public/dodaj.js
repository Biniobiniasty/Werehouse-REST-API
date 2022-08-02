


function dodajProdukt() {

    var name = document.getElementById('productName').value;
    var amount = parseInt(document.getElementById('productAmountnew').value);
    var dane = JSON.stringify({'name':name,'amount':amount});


var backToJS = JSON.parse(dane);



    var requestInit2 = {
      method: "POST",
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(backToJS)
    };

    var retPromise2 = fetch( "/api/werehouse/new" , requestInit2).then(response => response.text())
             .then((response) => {
               try {
               if(response == "true")
               {
                      document.getElementById('lastOperation2').innerHTML = "The product has been added.";
                  }
                  else
                  {
                    document.getElementById('lastOperation2').innerHTML = "Connection error";
                                   }
               }catch(err){
                 alert ( "Error" ) ;
               }
             })
             .catch( err => console.log(err) );
       setTimeout(zaladuj_tabele, 1000);
};
