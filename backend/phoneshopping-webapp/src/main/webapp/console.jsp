<%--
  Created by IntelliJ IDEA.
  User: dalam004
  Date: 11/24/2016
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>KnockoutJS Templating - foreach used with Template</title>
    <script src="https://ajax.aspnetcdn.com/ajax/knockout/knockout-3.3.0.js" type="text/javascript"></script>
</head>
<body>

<h2>Friends List</h2>
Here are the Friends from your contact page:
<div data-bind="template: { name: 'friend-template', foreach: friends }"></div>

<script type="text/html" id="friend-template">
    <h3 data-bind="text: name"></h3>
    <p>Contact Number: <span data-bind="text: contactNumber"></span></p>
    <p>Email-id: <span data-bind="text: email"></span></p>
</script>

<script type="text/javascript">
    function MyViewModel() {
        this.friends = [
            {name: 'Smith', contactNumber: 4556750345, email: 'smith123@gmail.com' },
            { name: 'Jack', contactNumber: 6789358001, email: 'jack123@yahoo.com' },
            { name: 'Lisa', contactNumber: 4567893131, email: 'lisa343@yahoo.com' }
        ]
    }

    var vm = new MyViewModel();
    ko.applyBindings(vm);
</script>
</body>
</html>
