<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="comm/jquery-2.1.4.js"></script>
<script>
$(function () {
    $(".smallpic").mouseenter(function () {
        var  s=this.src

        document.getElementById("#big_img").setAttribute("src",s)
        console.log($("#big_img").src)
    })

})
function numberadd() {

    var  s=$("#number")
    if (parseInt(s.val())<${number})
    {
        $("#number").val(parseInt(s.val())+1)
    }
}
function numberminus() {
    var  s=$("#number")
    if (parseInt(s.val())>1)
    {
        $("#number").val(parseInt(s.val())-1)
    }
}
function  collect() {
    $.get("ProductInfoAction?method=collect&productid="+${productid},function () {
        confirm("收藏成功")
    })

}
</script>
<html>
  <head>
    <title>$Title$</title>
    <style>
      div{
        float: left;
      }
      .smallpic{
        width: 50px;
        height: 50px;
        margin-left: 10px;
        margin-top: 25px;
      }
    </style>
  </head>
  <body>
  <fieldset style="width: 60%;height: 500px;background-color:gold;margin-left: 19.7%">

    <div style="background-color: #98bf21;width: 35%;height: 100%;margin-top: 10px;">
      <div style="height: 79%;margin: auto">
          <img id="#big_img"  style="height: 100%;margin:auto" src="picture\1.jpg">
      </div>

      <div style="width: 100%;height: 20%;background-color: white">
        <c:forEach items="${jpgs}" var="jpg">
          <div>
            <img class="smallpic" src="${jpg}" >
          </div>

        </c:forEach>
      </div>
    </div>

    <div style="width: 40%;margin: 10px;height: 100%;background-color: blueviolet">
        <div style="margin-left: 20px;width: 90%">
          <input type="hidden" name="productid" value="${productid}">
          <h3 >卖衣服了</h3>
          <div style="background-color: #98bf21;width: 95%;height: 50px;;padding-top: 10px">
            <label >价格</label>
            <label style="margin-left: 40px;color: red">￥ 999</label>
          </div>

          <div style="background-color:rosybrown;width: 95%;height: 50px;padding-top: 10px">
            <label >规格</label>

          </div>
          <div style="background-color:rosybrown;width: 95%;height: 50px;padding-top: 10px">
            <label >颜色</label>

          </div>

          <div style="background-color:rosybrown;width: 95%;height: 50px;padding-top: 10px">
            <label >数量</label>
            <button onclick="numberminus()">-</button>
            <input name="number" id="number" type="text" value="1" style="text-align: center;width: 50px">
            <button onclick="numberadd()">+</button>
            <span >件（库存${number}件）</span>
          </div>

          <button>立即购买</button>
          <button>加入购物车</button>
          <div onclick="collect()" style="float: right;color: #98bf21;">收藏</div>
        </div>
    </div>

    <div style="width: 22%;height: 100%;background-color: aqua;margin-top: 10px;">
          <button>回复</button>
    </div>
  </fieldset>
  </body>
</html>
