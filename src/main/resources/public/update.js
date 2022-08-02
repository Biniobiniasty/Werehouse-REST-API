


function aktualizujeProdukt() {

    var id = parseInt(document.getElementById('productId').value);


    var amount = parseInt(document.getElementById('productAmount').value);
    var dane = JSON.stringify({'id':id,'amount':amount});



var backToJS = JSON.parse(dane);



    var requestInit2 = {
      method: "PATCH",
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(backToJS)
    };

    var retPromise2 = fetch( "/api/werehouse/update" , requestInit2).then(response => response.text())
             .then((response) => {
               try {
               if(response == "true")
               {
                      document.getElementById('lastOperation2').innerHTML = "The amount has been added.";
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
