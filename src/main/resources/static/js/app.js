$(document).ready(function(){
	
	/*  $(".dropdown-menu").on('click',function (e) {
      e.stopPropagation();
    });
	
		$.validator.addMethod("checkcollegename", function(collegename){
    if (collegename !== "none") {
        return true;
        }
    else{
        return false;
    }
});
	
	$("#college_form").validate({
		rules: {
			name: {
				required: true,
				minlength: 3,
				maxlength: 30
			},
			strength: {
				required: true,
				max: 5000,
				min:500
			}
		},
		submitHandler: function (form) { // for demo
    	form.submit()
}
	});
	
	$("#student_form").validate({
		rules: {
			sName: {
				required: true,
				minlength: 5,
				maxlength: 30
			},
			age: {
				required: true,
				min: 17,
				max: 30
			},
			subject: {
				required: true,
			},
			college:{
				required: true,
				checkcollegename: true
				
			}
		},
		messages:{
			college: {
				checkcollegename: "please select the collge name from the list"
			}
		},
		submitHandler: function (form) { // for demo
    	form.submit()
		}
	});
	
	$("#student-update-form").validate({
		rules: {
			sName: {
				required: true,
				minlength: 5,
				maxlength: 30
			},
			age: {
				required: true,
				min: 17,
				max: 30
			},
			subject: {
				required: true,
			}
		},
		submitHandler: function (form) { // for demo
    	form.submit()
		}
	});*/
	
	
	$("#department").on('focus',function(){
		$.ajax({  
           type: "GET",  
           url: "/department/get-department-names",  
           data: {}, 
		   dataType: 'json', 
           success: function (data) {  

				//alert(data[0]);
               var s = '';

			//alert(data.length)
               for (var i = 0; i < Object.keys(data).length; i++) {  
                   s += '<option value="' + data[i] + '">' + data[i] + '</option>';  
               } 
			//alert(s); 
			  // conslole.log($s);
               $("#department").html(s);  
           }  
       });  
	});
	
	
	
});