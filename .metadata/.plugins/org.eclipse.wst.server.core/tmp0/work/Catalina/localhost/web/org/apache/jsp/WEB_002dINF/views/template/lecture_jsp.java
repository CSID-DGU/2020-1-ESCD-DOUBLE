/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2020-04-24 13:22:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lecture_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"EUC-KR\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/customize.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\n");
      out.write("<script src=\"resources/js/bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<nav class=\"navbar navbar-default\">\n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("\t\n");
      out.write("\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\"\n");
      out.write("\t\t\tdata-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\"><!-- 크기를 줄였을때 나타나는 버튼 -->\n");
      out.write("\t\t\t\t<span class=\"sr-only\"></span>\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t</button>\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"index.jsp\">코딩 부스터</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\"><!-- 네비 중간 대부분을 차지함 -->\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"index.jsp\">소개<span class=\"sr-only\"></span></a></li>\n");
      out.write("\t\t\t\t<li><a href=\"instructor.jsp\">강사진</a></li>\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\"\n");
      out.write("\t\t\t\taria-haspopup=\"true\" aria-expanded=\"false\">강의<span class=\"caret\"></span></a><!-- dropdown 연결이 어떤식인지는 모르겠지만 -->\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"lecture.jsp?lectureName=C\">c언어</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"lecture.jsp?lectureName=Java\">java</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"lecture.jsp?lectureName=Android\">안드로이드</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</li>\t\t\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<form class=\"navbar-form navbar-left\">\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"입력\"></div>\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">검색</button>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\"\n");
      out.write("\t\t\t\t\taria-haspopup=\"true\" aria-expanded=\"false\">접속하기<span class=\"caret\"></span></a>\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"loginForm.jsp\">로그인</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"registerForm.jsp\">회원가입</a></li>\t\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</nav>\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\t\t<ul class=\"list-group\">\n");
      out.write("\t\t\t<a href=\"#\" class=\"list-group-item active\">1강</a>\n");
      out.write("\t\t\t<a href=\"#\" class=\"list-group-item\">2강</a>\n");
      out.write("\t\t\t<a href=\"#\" class=\"list-group-item\">3강</a>\n");
      out.write("\t\t\t<a href=\"#\" class=\"list-group-item\">4강</a>\n");
      out.write("\t\t\t<a href=\"#\" class=\"list-group-item\">5강</a>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("<div class=\"row\">\n");
      out.write("\t<div class=\"embed-responsive embed-responsive-16by9\">\n");
      out.write("\t\t<iframe class=\"embed-responsive-item\" src=\"https://www.youtube.com/embed/BErRLIIdbjE\"></iframe>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("<div class=\"row\">\n");
      out.write("\t<p>\n");
      out.write("\t첫 번째 강의로 hello world 출력하기 입니다.\n");
      out.write("\t</p>\n");
      out.write("\t<pre class=\"pre-scrollable\">\n");
      out.write("\t#include &lt;stdio.h&gt;\n");
      out.write("\tint main(){\n");
      out.write("\tprintf(\"hi world\");\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t</pre>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<hr>\n");
      out.write("\t<form class=\"form-group\">\n");
      out.write("\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t<label>댓글 : </label>\n");
      out.write("\t\t\t<textarea class=\"form-control\" rows=\"5\" id=\"commentContent\" name=\"commentContent\"></textarea>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn pull-right\">등록</button>\n");
      out.write("\t\t</div>\n");
      out.write("\t</form><hr>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer style=\"background-color: #000000;color:#ffffff\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-sm-2\" style=\"text-align: center;\"><h5>Copyright &copy; 2020</h5><h5>staris</h5></div>\n");
      out.write("\t\t\t<div class=\"col-sm-4\"><h4>대표자 소개/<h4><p>저는 하마하마 도야지도야지 하마도야지 도야지이ㅣ이ㅣ이이하마아ㅑ아아 ㅏ ㅏㅇㅇ냐오옹옹</p></div>\n");
      out.write("\t\t\t<div class=\"col-sm-2\"><h4 style=\"text-align:center;\">네비게이션</h4>\n");
      out.write("\t\t\t\t<div class=\"list-group\">\n");
      out.write("\t\t\t\t\t<a href=\"index.jsp\" class=\"list-group-item\">소개</a>\n");
      out.write("\t\t\t\t\t<a href=\"instructor.jsp\" class=\"list-group-item\">강사진</a>\n");
      out.write("\t\t\t\t\t<a href=\"lecture.jsp\" class=\"list-group-item\">강의</a>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-sm-2\"><h4 style=\"text-align:center;\">SNS</h4>\n");
      out.write("\t\t\t\t<div class=\"list-group\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"list-group-item\">페이스북</a>\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"list-group-item\">유투브</a>\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"list-group-item\">인스타</a>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-sm-2\"><h4 style=\"text-align:center;\"><span class=\"glyphicon glyphicon-ok\"></span>&nbsp;by staris</h4></div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
