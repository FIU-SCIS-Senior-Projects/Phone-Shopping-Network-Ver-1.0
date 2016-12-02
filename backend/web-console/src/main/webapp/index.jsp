<%--
  Created by IntelliJ IDEA.
  User: Maks
  Date: 11/25/2016
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <title>Phone shopping network web console</title>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
        integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <style type="text/css">
    .wrap {
      background-color: #e1eef9;
    }

    .align-middle {
      margin: 0 auto;
    }

    .top_header {
      border-bottom: 2px solid navy;
      padding: 10px;
      margin-bottom: 20px;
    }

    .field {
      padding: 5px 0;
    }

    ol.content {
      display: block;
      counter-reset: item;
      list-style: outside none none;
      padding-left: 0;
    }

    /*ol.content li::before {*/
    /*color: #2666ad;*/
    /*content: counter(item, decimal) "";*/
    /*counter-increment: item;*/
    /*}*/

    ol.content li.elements {
      padding: 12px;
      border-bottom: 2px solid darkslateblue;
    }

    ol.content li:nth-of-type(2n+1) {
      background-color: #d3e3f3;
    }

    .control {
      float: right;
      margin: 0 5px;
    }

    li.info {
      margin: 5px 0;
      padding: 5px 0;
    }

    summary {
      /*border-bottom: 1px solid darkblue;*/
      margin-bottom: 6px;
    }

    input {
      padding: 6px;
    }

    .clearfloat {
      float: none;
      clear: both;
    }

  </style>

  <!-- Latest compiled and minified JavaScript -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
          integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
          crossorigin="anonymous"></script>
  <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/knockout/knockout-3.3.0.js"
          type="text/javascript"></script>
</head>
<body>

<div class="container">
  <div class="wrap col-md-8">
    <div class="row align-middle">
      <div class="top_header"><h1>PhoneShopping Administration Console</h1></div>
    </div>

    <div class="row">
      <div id="inner_container">
        <!-- Nav tabs -->
        <ul id="tabs" class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#users" aria-controls="users" role="tab" data-toggle="tab">Users</a>
          </li>
          <li role="presentation"><a href="#products" aria-controls="products" role="tab" data-toggle="tab">Products</a>
          </li>
          <li role="presentation"><a href="#orders" aria-controls="orders" role="tab" data-toggle="tab">Orders</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
          <div role="tabpanel" class="tab-pane active" id="users">
            <ol class="content" data-bind="template: { name: 'users-template', foreach: users }"></ol>
          </div>

          <div role="tabpanel" class="tab-pane" id="products">
            <ol class="content" data-bind="foreach: products">
              <li class="elements clearfloat">
                <details>
                  <summary class="column-header">
                    <strong data-bind="text: title"></strong>
                    <button class="btn btn-danger control" onclick="deleteProduct(this);">Delete</button>
                    <button class="btn btn-primary control" onclick="updateProduct(this);">Save</button>
                    <button class="btn btn-success control" onclick="createProduct(this);">New</button>
                  </summary>
                  <div class="details clearfloat">
                    <div class="product form">
                      <div class="field-sets">
                        <div class="field">
                          <span class="col-md-3">Product Id:</span>
                          <input class="col-md-9" type="text" name="title" data-bind="value: id"/>
                        </div>
                        <div class="field">
                          <span class="col-md-3">Product Title:</span>
                          <input class="col-md-9" type="text" name="title" data-bind="value: title"/>
                        </div>
                        <div class="field">
                          <span class="col-md-3">Product Description:</span>
                          <input class="col-md-9" type="text" name="description" data-bind="value: description"/>
                        </div>
                        <div class="more-info">
                          <div class="wrapper">
                            <span class="left">Additional Info</span>
                            <ol data-bind="template : { name: 'product-more-info-template', foreach: moreInfo}">

                            </ol>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </details>
              </li>
            </ol>
            <%--<ol class="content" data-bind="template: { name: 'products-template', foreach: products }"></ol>--%>
            <!--<div data-bind="template: { name: 'products-template', foreach: products }"></div>-->
          </div>
          <div role="tabpanel" class="tab-pane" id="orders">
            <ol class="content" data-bind="template: { name: 'orders-template', foreach: orders }"></ol>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div id="knockout_templates">
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

  <%--<script type="text/html" id="products-template">--%>
    <%----%>
  <%--</script>--%>

  <script type="text/javascript">
    function Address(pAddress) {
      var self = this;
      self.addressId = pAddress.addressId;
      self.addressLineOne = pAddress.addressLineOne;
      self.city = pAddress.city;
      self.state = pAddress.state;
      self.zipCode = pAddress.zipCode;
    }

    function ProductOrder(pOrder) {
      var self = this;
      self.orderId = pOrder.orderId;
      self.productId = pOrder.productId;
      self.unitPrice = pOrder.unitPrice;
      self.count = pOrder.count;
    }

    function Order(pId, pNumber, pStatus, pName, pBilling, pShipping, pProducts) {
      var self = this;
      self.orderId = pId;
      self.orderNumber = pNumber;
      self.orderStatus = pStatus;
      self.username = pName;
      self.billingAddress = pBilling;
      self.shippingAddress = pShipping;
      self.products = pProducts;
    }

    function Product(pId, pTitle, pDescription) {
      var self = this;
      self.id = ko.observable(pId);
      self.title = ko.observable(pTitle);
      self.description = ko.observable(pDescription);
      self.moreInfo = ko.observableArray();
      self.addInfo = function(pAfter) {
        var index = getIndex(pAfter);
        var toAdd = new NameValuePair(self, "name", "value");
        console.log("addInfo: "+index);
        if (index == -1) {
          self.moreInfo.push(toAdd);
        }
        else {
          self.moreInfo.splice(index+1, 0, toAdd);
        }
      };
      self.removeInfo = function(pThis) {
        var index = getIndex(pThis);
        if (index != -1) {
          self.moreInfo.splice(index, 1);
        }
      };

      function getIndex(pPair) {
        var index = -1;
        if (pPair != undefined) {
          for(var i = 0; i<self.moreInfo().length; i++) {
            console.log("name: "+self.moreInfo()[i].name());
            if (self.moreInfo()[i].name() == pPair.name()) {
              index = i;
              break;
            }
          }
        }

        return index;
      }
    }

    function ProductViewModel(pProduct) {
      var self = this;

      self.id = ko.observable(pProduct.id);
      self.title = ko.observable(pProduct.title);
      self.description = ko.observable(pProduct.description);
      self.moreInfo = ko.observableArray();
      for (var info in pProduct.moreInfo) {
        self.moreInfo().push(info);
      }
      self.product = pProduct;
    }
  </script>

  <script type="text/html" id="orders-template">
    <li class="elements clearfloat">
      <details>
        <summary class="column-header">
          <span>Order number#</span><strong data-bind="text: orderNumber"></strong></strong>
        </summary>
        <div class="details clearfloat">
          <div class="product form">
            <div class="field-sets">
              <div class="field row">
                <span class="col-md-3">Order Id:</span>
                <span class="col-md-9" data-bind="text: orderId"/>
              </div>
              <div class="field row">
                <span class="col-md-3">Order number:</span>
                <span class="col-md-9" data-bind="text: orderNumber"/>
              </div>
              <div class="field row">
                <span class="col-md-3">Order status:</span>
                <span class="col-md-9" data-bind="text: orderStatus"/>
              </div>
              <div class="field row">
                <span class="col-md-3">Order placed by:</span>
                <span class="col-md-9" data-bind="text: username"/>
              </div>
              <div class="field row">
                <span class="col-md-3">Shipping address:</span>
                <div class="col-md-9">
                  <span data-bind="text: shippingAddress.addressLineOne"/>
                  <span data-bind="text: shippingAddress.city"/>
                  <span data-bind="text: shippingAddress.state"/>
                  <span data-bind="text: shippingAddress.zipCode"/>
                </div>
              </div>
              <div class="field row">
                <span class="col-md-3">Ordered Items:</span>
                <div class="col-md-9">
                  <ol data-bind="foreach: products">
                    <li>
                      <div class="field row">
                        <strong class="col-md-3">Product Id: </strong>
                        <span class="col-md-9" data-bind="text: productId"/>
                      <%--</div>--%>
                      <%--<div class="field row">--%>
                        <strong class="col-md-3">Unit Price: </strong>
                        <span class="col-md-9" data-bind="text: unitPrice"/>
                      <%--</div>--%>
                      <%--<div class="field row">--%>
                        <strong class="col-md-3">Count: </strong>
                        <span class="col-md-9" data-bind="text: count"/>
                      </div>
                    </li>
                    </li>
                  </ol>
                </div>
              </div>
            </div>
          </div>
        </div>
      </details>
    </li>
  </script>

  <script type="text/html" id="product-more-info-template">
    <li class="info input clearfloat">
      <div>
        <input type="text" name="name" class="name" style="float: left;" data-bind="value: name"/>
        <input type="text" name="value" class="value" style="float:none; width: 60%" data-bind="value: value"/>
        <button class="btn btn-primary control" data-bind="click:$data.addInfo">+</button>
        <button class="btn btn-danger control" onclick="removeInfo(this);">-</button>
      </div>
    </li>
  </script>

  <script type="text/javascript">
    function NameValuePair(pParentVM, pName, pValue) {
      var self = this;
      self.parentVM = pParentVM;
      self.name = ko.observable(pName);
      self.value = ko.observable(pValue);
      self.addInfo = function() {
        self.parentVM.addInfo(self);
        console.log("In nameValue pair add info")
      }
    }

    function addInfo(pElement) {
      manageInfo(pElement, false);
    }

    function removeInfo(pElement) {
      manageInfo(pElement, true);
    }

    function manageInfo(pElement, pDelete) {
      var parentLi = $(pElement).closest("li");
      var farParent = parentLi.parent().closest("li");

      var index = parentLi.index();
      var farIndex = farParent.index();

      console.log("AddIno::: index: " + index + ":::: productIndex: " + farIndex);
      if (farIndex != -1) {
        var info = userVM.products()[farIndex].moreInfo();
        console.log("Before: " + info.length);
        if (index != -1) {
          if (pDelete) {
            userVM.products()[farIndex].moreInfo().splice(index, 1);
          }
          else {
            userVM.products()[farIndex].moreInfo().splice(index + 1, 0, new NameValuePair(userVM.products()[farIndex], "name", "value"));
          }
        }
        else {
          if (pDelete) {
            userVM.products()[farIndex].moreInfo().pop();
          }
          else {
            userVM.products()[farIndex].moreInfo().push(new NameValuePair(userVM.products()[farIndex], "name", "value"));
          }
        }
        console.log("After: " + info.length + ":::" + userVM.products()[farIndex].moreInfo().length);
      }
    }

    function deleteProduct(pElement) {
      var index = $(pElement).closest("li").index();
      console.log("Delete Project: index: " + index);
      var product = userVM.products()[index];
      $.ajax({
        url: baseUrl + "/products/" + product.id(),
        method: "DELETE"
      }).done(function () {
        userVM.products.splice(index, 1);
      })
    }

    function createProduct(pElement) {
      var index = $(pElement).closest("li").index();
      console.log("Create Product: index: " + index);
      var product = new Product(-1, "New", "No description");
      product.moreInfo.push(new NameValuePair(product, "", ""));
      userVM.products.splice(index, 0, product);
    }

    function updateProduct(pElement) {
      var index = $(pElement).closest("li").index();
      console.log("Update Project: index: " + index);
      var product = userVM.products()[index];

      var method = "POST";
      var url = baseUrl + "/products";
      if (product.id() !== -1) {
        method = "PUT";
        url = url + "/" + product.id()
      }

      var toSave = {
        title: product.title(),
        description: product.description(),
        info: {}
      };
      var info = product.moreInfo();
      for (var i = 0; i < info.length; i++) {
        var pair = info[i];
        var name = pair.name();
        var value = pair.value();
        if (!(name == undefined || name == "" || value == undefined || value == "")) {
          toSave.info[name] = value;
        }
      }

      var strToSave = JSON.stringify(toSave);
      console.log("Sending :: " + strToSave);
      $.ajax({
        url: url,
        method: method,
        contentType: "application/json",
        data: strToSave,
        statusCode: {
          201: function (pData) {
            console.log("Created: " + pData);
            product.id(parseInt(pData));// = ko.observable(parseInt(pData));
            window.status = "The product with id "+pData+" is created";
            console.log("After creation: " + product.id());
          },
          200: function (pData) {
            window.status = "The product with id "+pData+" is saved";
            console.log("SAVVVEDDDD:: " + pData)
          }
        }
      }).done(function (pData) {

      })
    }

    function UsersViewModel() {
      var self = this;
      self.users = ko.observableArray();
      self.addUser = function (user) {
        self.users.push(user);
      };


      self.products = ko.observableArray();
      self.addProduct = function (pProduct) {
        self.products.push(pProduct);
//        self.products.push(new ProductViewModel(pProduct));
      };
      self.getProductAtIndex = function(pIndex) {

      }

      self.orders = ko.observableArray();
      self.addOrder = function (pOrder) {
        self.orders.push(pOrder);
      };
    }

    var userVM = new UsersViewModel();
    ko.applyBindings(userVM);

    var baseUrl = location.origin+"/phoneshopping-webapp/service";
    $.ajax({
      url: baseUrl + "/users"
    }).done(function (data) {
      $(data).each(function (index, user) {
        userVM.addUser(user);
      });
    });

    $.ajax({
      url: baseUrl + "/products"
    }).done(function (pResult) {
      $(pResult).each(function (index, pData) {
        var product = new Product(pData.productId, pData.title, pData.description);
        for (var key in pData.info) {
          product.moreInfo().push(new NameValuePair(product, key, pData.info[key]));
        }
        userVM.addProduct(product);
        console.log("Data: " + product.title + "::  " + typeof(user));
      });
    });

    $.ajax({
      url: baseUrl + "/orders"
    }).done(function (data) {
      $(data).each(function (index, pOrder) {

        var orders = [];
        $(pOrder.products).each(function (pIndex, pProduct) {
          orders.push(new ProductOrder(pProduct));
        });
        var billing = new Address(pOrder.billingAddress);
        var shipping = new Address(pOrder.shippingAddress);
        var order = new Order(pOrder.orderId, pOrder.orderNumber, pOrder.orderStatus, pOrder.username, billing, shipping, orders)
        userVM.addOrder(order)
        console.log(JSON.stringify(order))
      });
    });
  </script>
</div>

</div>

<script type="text/javascript">
  $('#tabs a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
  });
</script>
</body>
</html>