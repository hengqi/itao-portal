<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html class="root61">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" type="text/css"	href="/css/cart2.css">
<title>商品已成功加入购物车</title>
<link rel="stylesheet" type="text/css" href="/css/taotao.css" media="all" />
	<link rel="stylesheet" type="text/css" href="/css/pshow.css" media="all" />

<link type="text/css" rel="stylesheet"	href="/css/cart1.css">
</head>
<body>
<jsp:include page="commons/header.jsp" />
	<div class="main">
		<div class="success-wrap">
			<div class="w" id="result">
				<div class="m succeed-box">
					<div class="mc success-cont">
						<div class="success-lcol">
							<div class="success-top">
								<b class="succ-icon"></b>
								<h3 class="ftx-02">商品已成功加入购物车！</h3>
							</div>
							<%--<div class="p-item">
								<div class="p-img">
									<a href="http://item.jd.com/1208740.html" target="_blank"><img
										src="./商品已成功加入购物车_files/56f2064dNcca2e5b6.jpg"
										clstag="pageclick|keycount|201601152|11"></a>
								</div>
								<div class="p-info">
									<div class="p-name">
										<a href="http://item.jd.com/1208740.html" target="_blank"
											clstag="pageclick|keycount|201601152|2"
											title="罗技（Logitech）M275 无线鼠标 黑色">罗技（Logitech）M275 无线鼠标 黑色</a>
									</div>
									<div class="p-extra">
										<span class="txt" title="黑">颜色：黑</span><span class="txt">/
											数量：1</span>
									</div>
								</div>
								<div class="clr"></div>
							</div>--%>
						</div>
						<div class="success-btns">
							<div class="success-ad">
								<a
									href="http://cart.jd.com/addToCart.html?rcd=1&amp;pid=1208740&amp;pc=1&amp;rid=1474206980469&amp;em=#none"></a>
							</div>
							<div class="clr"></div>
							<div>
								<a class="btn-tobback"
									href="http://cart.jd.com/addToCart.html?rcd=1&amp;pid=1208740&amp;pc=1&amp;rid=1474206980469&amp;em=#"
									onclick="window.history.back();return false;"
									clstag="pageclick|keycount|201601152|3">返回</a><a
									class="btn-addtocart"
									href="/cart/cart.html"
									id="GotoShoppingCart" clstag="pageclick|keycount|201601152|4"><b></b>去购物车结算</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="commons/footer.jsp" />
</body>
</html>