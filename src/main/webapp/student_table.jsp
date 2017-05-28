<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>学生管理系统</title>

<meta name="description" content="Static &amp; Dynamic Tables" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="../assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="../assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="../assets/js/html5shiv.min.js"></script>
		<script src="../assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<a href="../index.jsp" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i>学生管理系统
				</small>
				</a>
			</div>

		</div>
		<!-- /.navbar-container -->
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>


			<!-- /.sidebar-shortcuts -->

			<ul class="nav nav-list">
				<li class="active">
					<a href="../index.jsp">
						<i class="menu-icon fa fa-tachometer"></i>
						<span class="menu-text"> 主页 </span>
					</a>

					<b class="arrow"></b>
				</li>




				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-list"></i>
						<span class="menu-text"> 信息管理 </span>

						<b class="arrow fa fa-angle-down"></b>
					</a>

					<b class="arrow"></b>

					<ul class="submenu">
						<li class="">
							<a href="../grade/getGradeAll.do">
								<i class="menu-icon fa fa-caret-right"></i>
								班级管理
							</a>

							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="../student/getStudentList.do
								">
								<i class="menu-icon fa fa-caret-right"></i>
								学生管理
							</a>

							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="../subject/getSubjectAll.do
								">
								<i class="menu-icon fa fa-caret-right"></i>
								科目管理
							</a>

							<b class="arrow"></b>
						</li>


					</ul>
				</li>




				<!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</ul>
		</div>

		<div class="main-content">
			<div class="main-content-inner">

				<div class="page-content">
					<div class="page-header">
						<h1>
							信息管理 <small> <i
								class="ace-icon fa fa-angle-double-right"></i> 学生信息管理
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
	
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12">
										<a style="font-size: 20px;float: right" href="../student/studentForm.do" >新增学生信息</a>
										<table id="simple-table"
											class="table  table-bordered table-hover">
								<%-- 			<c:forEach var="StudentVo" items="${list}"> --%>
											<thead>
										
												<tr>
													<th class="center">ID</th>
													<th>详细</th>
													<th>学号</th>
													<th>姓名</th>
													<th>所在班级</th>

													<th>选修科目数</th>
													<th>平均分</th>

													<th></th>
												</tr>
											</thead>

											<tbody>
											<c:forEach var="studentVo" items="${studentVos}">
												<tr>
													<td class="center">${studentVo.id}</td>

													<td class="center">
														<div class="action-buttons">
															<a href="#" class="green bigger-140 show-details-btn"
																title="Show Details"> <i
																class="ace-icon fa fa-angle-double-down"></i> <span
																class="sr-only">Details</span>
															</a>
														</div>
													</td>

													<td><a href="#">${studentVo.studentNumber} </a></td>
													<td>${studentVo.name} </td>
													<td >${studentVo.gradeName}</td>
													<td>${studentVo.subjectNumber}</td>

													<td class="hidden-480"><span
															class="label label-sm label-warning">${studentVo.average}</span></td>

													<td>
														<a href="../student/chooseSubject.do?id=${studentVo.id}">选课</a>&nbsp&nbsp&nbsp&nbsp
														<a href="../student/entryScore.do?id=${studentVo.id}">录入成绩</a>&nbsp&nbsp&nbsp&nbsp
														<a href="../student/studentForm.do?id=${studentVo.id}">更改</a>&nbsp&nbsp&nbsp&nbsp
														<a href="../student/deleteStudent.do?id=${studentVo.id}">删除</a>

													</td>
												</tr>
			<!-- 详细信息展开 -->
												<tr class="detail-row">
													<td colspan="8">
														<div class="table-detail">
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<div class="text-center">
																		<c:if test="${studentVo.logoPath==null}">
																			<img height="150"
																				 class="thumbnail inline no-margin-bottom"
																				 alt="Domain Owner's Avatar"
																				 src="../assets/images/avatars/profile-pic.jpg" /> <br />
																		</c:if>
																		<c:if test="${studentVo.logoPath!=null}">
																			<img height="150"
																				 class="thumbnail inline no-margin-bottom"
																				 alt="Domain Owner's Avatar"
																				 src="../img/${studentVo.logoPath}" /> <br />
																		</c:if>

																		<div
																				class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
																			<div class="inline position-relative">
																				<a class="user-title-label" href="#"> <i
																						class="ace-icon fa fa-circle light-green"></i>
																					&nbsp; <span class="white">${studentVo.name}</span>
																				</a>
																			</div>
																		</div>
																	</div>
																</div>

																<div class="col-xs-12 col-sm-7">
																	<div class="space visible-xs"></div>

																	<div
																		class="profile-user-info profile-user-info-striped">
																		<div class="profile-info-row">
																			<div class="profile-info-name">学号</div>

																			<div class="profile-info-value">
																				<span>${studentVo.studentNumber}</span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name">姓名</div>

																			<div class="profile-info-value">
																				
																				<span>${studentVo.name} </span>
																			</div>
																		</div>



																		<div class="profile-info-row">
																			<div class="profile-info-name">性别</div>

																			<div class="profile-info-value">
																				<span>${studentVo.sex} </span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name">出生日期</div>

																			<div class="profile-info-value">
																				<span>${studentVo.birthday} </span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name">上传照片</div>
																			<form action="../student/uploadLogo.do?id=${studentVo.id}" method="post" enctype="multipart/form-data" name="form">
																				<div class="profile-info-value">
																					<input type="file" name="file" width="100%">
																					<input type="submit" name="Submit" value="确认上传" width="100%">
																				</div>
																			</form>
																		</div>


																	</div>
																</div>


															</div>
														</div>
													</td>
												</tr>

											</c:forEach>

											</tbody>
											
										</table>
										<ul class="pagination pull-right no-margin">

											<li class="next">
												<c:if test="${currentPage!=1}">
												<a href="../student/getStudentList.do?currentPage=1">首页</a>
												<a href="../student/getStudentList.do?currentPage=${currentPage-1}">上一页</a>
												</c:if>
											<li>
											<li  class="active">
												<c:forEach begin="1" end="${pageCount}" var="each">
													<c:choose>
														<c:when test="${each == (currentPage)}">
															<a style="color: black;">${each}</a>
														</c:when>
														<c:when
																test="${each >= (currentPage- pageCount) && each <= (currentPage + pageCount)}">
															<a href="../student/getStudentList.do?currentPage=${each}">${each}</a>
														</c:when>
													</c:choose>
												</c:forEach>
											</li>
											<li class="next">
												<c:if test="${currentPage<pageCount}">
												<a href="../student/getStudentList.do?currentPage=${currentPage+1}">下一页</a>
												<a href="../student/getStudentList.do?currentPage=${pageCount}">尾页</a>
												</c:if>

											<li class="next"><a href="#">共${pageCount}页</a></li>
										</ul>
									</div>
									<!-- /.span -->
								</div>
								<!-- /.row -->




								<!-- PAGE CONTENT ENDS -->
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

	</div>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="../assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="../assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="../assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="../assets/js/jquery.dataTables.min.js"></script>
	<script src="../assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script src="../assets/js/dataTables.buttons.min.js"></script>
	<script src="../assets/js/buttons.flash.min.js"></script>
	<script src="../assets/js/buttons.html5.min.js"></script>
	<script src="../assets/js/buttons.print.min.js"></script>
	<script src="../assets/js/buttons.colVis.min.js"></script>
	<script src="../assets/js/dataTables.select.min.js"></script>

	<!-- ace scripts -->
	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin
			/*var myTable = $('#dynamic-table')
			//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
			.DataTable({
				bAutoWidth : false,
				"aoColumns" : [ {
					"bSortable" : false
				}, null, null, null, null, null, {
					"bSortable" : false
				} ],
				"aaSorting" : [],

				//"bProcessing": true,
				//"bServerSide": true,
				//"sAjaxSource": "http://127.0.0.1/table.php"	,

				//,
				//"sScrollY": "200px",
				//"bPaginate": false,

				//"sScrollX": "100%",
				//"sScrollXInner": "120%",
				//"bScrollCollapse": true,
				//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
				//you may want to wrap the table inside a "div.dataTables_borderWrap" element

				//"iDisplayLength": 50

				select : {
					style : 'multi'
				}
			});

			$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

			new $.fn.dataTable.Buttons(
					myTable,
					{
						buttons : [
								{
									"extend" : "colvis",
									"text" : "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									columns : ':not(:first):not(:last)'
								},
								{
									"extend" : "copy",
									"text" : "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "csv",
									"text" : "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "excel",
									"text" : "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "pdf",
									"text" : "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "print",
									"text" : "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									autoPrint : false,
									message : 'This print was produced using the Print button for DataTables'
								} ]
					});
			myTable.buttons().container().appendTo($('.tableTools-container'));

			//style the message box
			var defaultCopyAction = myTable.button(1).action();
			myTable
					.button(1)
					.action(
							function(e, dt, button, config) {
								defaultCopyAction(e, dt, button, config);
								$('.dt-button-info')
										.addClass(
												'gritter-item-wrapper gritter-info gritter-center white');
							});

			var defaultColvisAction = myTable.button(0).action();
			myTable
					.button(0)
					.action(
							function(e, dt, button, config) {

								defaultColvisAction(e, dt, button, config);

								if ($('.dt-button-collection > .dropdown-menu').length == 0) {
									$('.dt-button-collection')
											.wrapInner(
													'<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
											.find('a').attr('href', '#').wrap(
													"<li />")
								}
								$('.dt-button-collection').appendTo(
										'.tableTools-container .dt-buttons')
							});

			////

			setTimeout(function() {
				$($('.tableTools-container')).find('a.dt-button').each(
						function() {
							var div = $(this).find(' > div').first();
							if (div.length == 1)
								div.tooltip({
									container : 'body',
									title : div.parent().text()
								});
							else
								$(this).tooltip({
									container : 'body',
									title : $(this).text()
								});
						});
			}, 500);

			myTable.on('select', function(e, dt, type, index) {
				if (type === 'row') {
					$(myTable.row(index).node()).find('input:checkbox').prop(
							'checked', true);
				}
			});
			myTable.on('deselect', function(e, dt, type, index) {
				if (type === 'row') {
					$(myTable.row(index).node()).find('input:checkbox').prop(
							'checked', false);
				}
			});

			/////////////////////////////////
			//table checkboxes
			$('th input[type=checkbox], td input[type=checkbox]').prop(
					'checked', false);

			//select/deselect all rows according to table header checkbox
			$(
					'#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]')
					.eq(0).on('click', function() {
						var th_checked = this.checked;//checkbox inside "TH" table header

						$('#dynamic-table').find('tbody > tr').each(function() {
							var row = this;
							if (th_checked)
								myTable.row(row).select();
							else
								myTable.row(row).deselect();
						});
					});

			//select/deselect a row when the checkbox is checked/unchecked
			$('#dynamic-table').on('click', 'td input[type=checkbox]',
					function() {
						var row = $(this).closest('tr').get(0);
						if (this.checked)
							myTable.row(row).deselect();
						else
							myTable.row(row).select();
					});

			$(document).on('click', '#dynamic-table .dropdown-toggle',
					function(e) {
						e.stopImmediatePropagation();
						e.stopPropagation();
						e.preventDefault();
					});*/

			//And for the first simple table, which doesn't have TableTools or dataTables
			//select/deselect all rows according to table header checkbox
			var active_class = 'active';
			$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on(
					'click',
					function() {
						var th_checked = this.checked;//checkbox inside "TH" table header

						$(this).closest('table').find('tbody > tr').each(
								function() {
									var row = this;
									if (th_checked)
										$(row).addClass(active_class).find(
												'input[type=checkbox]').eq(0)
												.prop('checked', true);
									else
										$(row).removeClass(active_class).find(
												'input[type=checkbox]').eq(0)
												.prop('checked', false);
								});
					});

			//select/deselect a row when the checkbox is checked/unchecked
			$('#simple-table').on('click', 'td input[type=checkbox]',
					function() {
						var $row = $(this).closest('tr');
						if ($row.is('.detail-row '))
							return;
						if (this.checked)
							$row.addClass(active_class);
						else
							$row.removeClass(active_class);
					});

			/********************************/
			//add tooltip for small view action buttons in dropdown menu
			$('[data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});

			//tooltip placement on right or left
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('table')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				//var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			/***************/
			$('.show-details-btn').on(
					'click',
					function(e) {
						e.preventDefault();
						$(this).closest('tr').next().toggleClass('open');
						$(this).find(ace.vars['.icon']).toggleClass(
								'fa-angle-double-down').toggleClass(
								'fa-angle-double-up');
					});
			/***************/

			/**
			//add horizontal scrollbars to a simple table
			$('#simple-table').css({'width':'2000px', 'max-width': 'none'}).wrap('<div style="width: 1000px;" />').parent().ace_scroll(
			  {
				horizontal: true,
				styleClass: 'scroll-top scroll-dark scroll-visible',//show the scrollbars on top(default is bottom)
				size: 2000,
				mouseWheelLock: true
			  }
			).css('padding-top', '12px');
			 */

		})
	</script>
</body>
</html>
