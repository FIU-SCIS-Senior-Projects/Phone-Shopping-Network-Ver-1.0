<%--
  Created by IntelliJ IDEA.
  User: Maks
  Date: 12/2/2016
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/html" id="users-template">
  <li class="elements">
    <details class="clearfloat">
      <summary class="username column-header"><strong data-bind="text: username"></strong></summary>
      <div class="details clearfloat">
        <div class="first-name field">First name: <span data-bind="text: firstname"></span></div>
        <div class="last-name field">Last name: <span data-bind="text: lastname"></span></div>
        <div class="email field">Email: <span data-bind="text: email"></span></div>
        <div class="phone field">Phone: <span data-bind="text: phone"></span></div>
      </div>
    </details>
  </li>
</script>