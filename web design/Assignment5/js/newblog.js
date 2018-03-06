

    var addEvent = function (e) {
        
          var newStickyRequset = new XMLHttpRequest();
          newStickyRequset.open('GET','../sticky.html',true) ;
          newStickyRequset.responseType='text';
          newStickyRequset.setRequestHeader('Access-Control-Allow-Origin','*');
          newStickyRequset.onload = function (e) {
             
              if(this.status=200&&this.readyState==4){
                  
                  createSticky(this.responseText,e);
              }
          };
          
          newStickyRequset.send();
          
      };
      
      var createSticky = function(stickyDom,e){
          
          var blogarea = document.querySelector('#content_area');
          blogarea.innerHTML += stickyDom;
          
      }





