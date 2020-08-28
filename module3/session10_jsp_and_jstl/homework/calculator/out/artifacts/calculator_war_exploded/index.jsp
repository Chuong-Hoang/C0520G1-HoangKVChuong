<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/08/2020
  Time: 8:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="/calculator.jsp" method="post">
      <label>First Operand: </label>
      <input type="text" name="firstOperand" placeholder="15"><br>
      <label>Operator</label>
      <select name="operator">
        <option selected>Addition</option>
        <option>Subtraction</option>
        <option>Multiplication</option>
        <option>Division</option>
      </select><br>

      <label>Second Operand: </label>
      <input type="text" name="secondOperand" placeholder="10"><br>
      <label></label>
      <input type="submit" value="Calculate">
  </form>
  </body>
</html>
