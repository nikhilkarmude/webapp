/**
 * 
 */

        window.onload=function callFunction()
        {
           
            //alert(new java.util.Date());
           setInterval(abc,22000);
            //setInterval(function(){alert("Hello")},3000);
        }
        function abc()
        {
          //  alert(" abc start ");
            var xmlhttp;
            if (window.XMLHttpRequest)
            {
              //  alert("2");
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {
                
                //alert("3");
                // code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
               // alert(" Before checking response is ready ");
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                  // alert("5");
                //  alert(" xmlhttp.responseText "+xmlhttp.responseText);
                    var isForward=xmlhttp.responseText;
          //       alert("response text : "+isForward+" "+isForward.toString()+" "+isForward.toString().length);
                    
                    //        var isForward="true";
                     //           alert("response text1 : "+isForward);
                     if(isForward.toString().length==7)
                       {
                          //      alert("Going to forward");
                         location.href="./DestroySession.jsp";
                       }
                       
                }
            }
           // alert("open function is called");
            xmlhttp.open("GET","SessionValidate.jsp",true);
            xmlhttp.send();
           // alert(" abc function end ");
        }
