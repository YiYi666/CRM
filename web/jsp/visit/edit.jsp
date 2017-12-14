<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/linkman/linkman_editsubmit"
		method=post>
		<input type="hidden" name="lkmId" value="${linkman.lkmId }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户拜访管理 &gt; 修改客户拜访</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>客户Id:</td>
								<td <%--colspan="3"--%>>
									<select name="custId" style="WIDTH: 180px">
										<option value="${customerVisit.customer.custId}">${customerVisit.customer.custId}</option>
										<c:forEach items="${custIds }" var="cId">
											<option value="${cId}">${cId}</option>
										</c:forEach>
									</select>
								</td>
								<td>被拜访人：</td>
								<td>
									<INPUT class=textbox id=visitInterviewee" style="WIDTH: 180px" maxLength=50 name="visitInterviewee" value="${customerVisit.visitInterviewee}">
								</td>
							</tr>
							<TR>
								<td>拜访时间：</td>
								${customerVisit.visitTime}
								<%--<fmt:parseDate value="${customerVisit.visitTime}" var="parsedEmpDate" pattern="yyyy-MM-dd hh:mm:ss" />--%>
								<td>
									<INPUT type="datetime-local"
										   value=""
										   class=textbox id="visitTime" style="WIDTH: 180px" maxLength=50 name="visitTime">
								</td>
								<td>拜访地点 ：</td>
								<td>
									<INPUT class="textbox" id="visitAddr" value="${customerVisit.visitAddr}" style="WIDTH: 180px" maxLength=50 name="visitAddr">
							</TR>
							<TR>
								<td>下次拜访时间 ：</td>
								<td>
									<INPUT type="datetime-local" class="textbox"  value="${customerVisit.visitNextTime}" id="visitNextTime" style="WIDTH: 180px" maxLength=50 name="visitNextTime">
								</td>
								<td>拜访详情 ：</td>
								<td>
									<INPUT class="textbox" id="visitDetail" value="${customerVisit.visitDetail}" style="WIDTH: 180px" maxLength=50 name="visitDetail">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
