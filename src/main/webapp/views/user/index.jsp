<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/layouts/user/taglib.jsp"%>
<title>Trang chủ</title>
<body>

	<!-- 
Body Section 
-->

	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

					<c:forEach var="item" items="${ categorys }">
						<li><a href='<c:url value="/san-pham/${ item.id }"/>'><span
								class="icon-circle-blank"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>

					<li><a class="totalInCart" href="cart.html"><strong>Đã
								mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;">$448.42</span>
						</strong></a></li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img
					src="<c:url value="/assets/user/img/paypal.jpg"/>"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="https://danviet.mediacdn.vn/296231569849192448/2022/5/6/1a-1651818739512700903970-0-0-1005-1920-crop-16518187612572012542995.jpg"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/VNITE20210928103950174149/detail/589a38a54f90475a855da7cd8fe19cd7_1632825590396302508.webp"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="https://vtv1.mediacdn.vn/thumb_w/640/2022/2/26/xuatkhauxoaicatchusangchauau-1645855321325720800648.jpg"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>
		</div>

		<div class="span9">
			<div class="well well-small ">
				<h3>
					<a class="btn btn-mini pull-right" href="products.html"
						title="View more">Xem thêm <span class="icon-plus"></span></a> Tất cả sản phẩm
				</h3>
				<hr class="soften" />
				<div class="row-fluid">

					<c:if test="${ products.size() > 0 }">
						<ul class="thumbnails">

							<c:forEach var="item" items="${ products }" varStatus="loop">
								<li class="span4">
									<div class="thumbnail">
										<a class="zoomTool" href="#" title="add to cart"><span
											class="icon-search"></span> QUICK VIEW</a> <a
											href="chi-tiet-san-pham/${ item.id }"><img
									src="<c:url value="${ item.image }"/>"
									alt=""></a>
										<div class="caption">
											<h5>${ item.name }</h5>
											<h4>
												<a class="defaultBtn" href="product_details.html"
													title="Click to view"><span class="icon-zoom-in"></span></a>
												<a class="shopBtn" href="#" title="add to cart"><span
													class="icon-plus"></span></a> <span class="pull-right"><fmt:formatNumber
														type="number" groupingUsed="true" value="123" /> ₫</span>
											</h4>
										</div>
									</div>
								</li>

								<c:if
									test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == products.size() }">
						</ul>
						<c:if test="${ (loop.index + 1) < products.size() }">
							<ul class="thumbnails">
						</c:if>
					</c:if>

					</c:forEach>

					</c:if>

				</div>
			</div>

		</div>
	</div>
	</div>

</body>
