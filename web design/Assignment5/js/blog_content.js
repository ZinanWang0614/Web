function loadJSON(callback) {   
    
        var xobj = new XMLHttpRequest();
        xobj.overrideMimeType("application/json");
        xobj.open('GET', 'js/blog_content.json', true); // Replace 'my_data' with the path to your file
        xobj.responseType='text';
        xobj.setRequestHeader('Access-Control-Allow-Origin','*');
        xobj.onreadystatechange = function () {
              if ( xobj.status == 200) {
                // Required use of an anonymous callback as .open will NOT return a value but simply returns undefined in asynchronous mode
                callback(xobj.responseText);
                
              }
        };
        xobj.send(null);  
     }
    

     function init() {
        loadJSON(function(response) {
            var data = JSON.parse(response);

            var test = document.getElementById('test1');
            test.innerHTML = data[0].Post; 
            var t2 = document.getElementById('test2');
            t2.innerHTML = data[1].Post;
            var t3 = document.getElementById('test3');
            t3.innerHTML = data[2].Post;
            var t4 = document.getElementById('test4');
            t4.innerHTML = data[3].Post;

            var a1 = document.getElementById('author1');
            a1.innerHTML = data[0].author_name;
            var a2 = document.getElementById('author2');
            a2.innerHTML = data[1].author_name;
            var a3 = document.getElementById('author3');
            a3.innerHTML = data[2].author_name;
            var a4 = document.getElementById('author4');
            a4.innerHTML = data[3].author_name;

            var d1 = document.getElementById('date1');
            d1.innerHTML = data[0].post_time;
            var d2 = document.getElementById('date2');
            d2.innerHTML = data[1].post_time;
            var d3 = document.getElementById('date3');
            d3.innerHTML = data[2].post_time;
            var d4 = document.getElementById('date4');
            d4.innerHTML = data[3].post_time;
            
        });
       }
    init();


