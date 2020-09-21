<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h3>Calculator</h3>
  <form method="post" action="/calculate">
    <input type="number" name="num1" id="num1" placeholder="number 1" value="${num1}" onkeydown="getCalculateSign();">&nbsp;
    <select name="operator" id="operator" style="color: red" onchange="getCalculateSign();">
      <option value="${operator}">${operator}</option>
      <option value="+">+</option>
      <option value="-">-</option>
      <option value="*">*</option>
      <option value="/">/</option>
    </select>&nbsp;
    <input type="number" name="num2" id="num2" placeholder="number 2" value="${num2}" onkeydown="getCalculateSign();">&nbsp;
    <input type="submit" name="equal" id="equal" value="${equal}" style="color: red" onclick="getEqualSign();">&nbsp;
    <input type="text" name="result" id="result" value="${result}">
    <p style="color: red">${msg}</p>
  </form>


  <script>
    function getEqualSign() {
      document.getElementById("equal").setAttribute("value", "=");
    }

    function getCalculateSign() {
      document.getElementById("equal").setAttribute("value", "get result");
      document.getElementById("result").setAttribute("value", "");
    }
  </script>

  </body>
</html>
