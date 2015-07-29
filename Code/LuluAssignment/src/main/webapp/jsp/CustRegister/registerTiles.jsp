<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
$(function () {
    var submitButton = $("#registerForm input[type='submit']").attr("disabled", true);
    $("#registerForm input.required").change(function () {
        var valid = true;
        $.each($("#registerForm input.required"), function (index, value) {
            
            if(!$(value).val()){
               valid = false;
            }
        });
        if(valid){
            $(submitButton).attr("disabled", false);
            console.log("valid");
        } 
        else{
             $(submitButton).attr("disabled", true);
        }
    });
});

/*  jQuery ready function. Specify a function to execute when the DOM is fully loaded.  */
$(document).ready(
  
  /* This is the function that will get executed after the DOM is fully loaded */
  function () {
    $( "#datepicker" ).datepicker({
      changeMonth: true,//this option for allowing user to select month
      changeYear: true //this option for allowing user to select from year range
    });
  }

);
</script>
<div align="center">

  <h2>Registration Form</h2>
  <s:fielderror cssClass="errorMessage" escape="false">
  		<s:param>error.msg</s:param>
	</s:fielderror>
   <s:form id="registerForm" action="register">
   <s:textfield name="customerInfo.custName" label="Customer Name " maxlength="20"/>
   <s:textarea name="customerInfo.address"  label="Address " cols="40" rows="10" maxlength="120"/>
   <s:textfield id="mandatory" name="customerInfo.email" label="Email* " cssClass="required" maxlength="60"/>
   <s:password id="mandatory" name="customerInfo.password" label="Password* " cssClass="required" maxlength="20"/>
   <s:select name="country" list="%{#request.countryList}" label="Country"/>
   <s:textfield name="customerInfo.phone" label="Phone (+[Country code][Number])" maxlength="15"/>
   <s:textfield name="customerInfo.dateOfBirth" label="Date Of Birth (MM/DD/YYYY)"  id="datepicker"/>
   <s:submit />
  </s:form>

</div>