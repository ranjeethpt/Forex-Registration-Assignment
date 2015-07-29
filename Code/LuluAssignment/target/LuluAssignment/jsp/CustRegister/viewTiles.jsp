<%@ taglib prefix="s" uri="/struts-tags"%>

 <div align="center">
  <h2><s:property value="customerInfo.email" /> registered successfully</h2>	
  <table>
   <tr>
    <td>Customer Name:</td>
    <td><s:property value="customerInfo.custName" />
    </td>
   </tr>
   <tr>
    <td>Address</td>
    <td><s:property value="customerInfo.address" />
    </td>
   </tr>
   <tr>
    <td>Email:</td>
    <td><s:property value="customerInfo.email" />
    </td>
   </tr>
    <tr>
    <td>country:</td>
    <td><s:property value="customerInfo.country" />
    </td>
   </tr> 
   <tr>
    <td>Phone:</td>
    <td><s:property value="customerInfo.phone" />
    </td>
   </tr>
   <tr>
    <td>Date Of Birth:</td>
    <td><s:property value="customerInfo.dateOfBirth" />
    </td>
   </tr>
  </table>
 </div>