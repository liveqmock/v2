<%@ page language="java" contentType="application/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version='1.0' encoding='UTF-8'?>
<response>
	<refresh><%= request.getAttribute("REFRESH") %></refresh>
	<content><![CDATA[
<%= request.getAttribute("CONTENT") %>
	]]></content>
</response>